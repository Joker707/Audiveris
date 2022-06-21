package myAndroid.java.awt.geom;


import myAndroid.java.awt.Shape;
import myAndroid.sun.awt.geom.AreaOp;
import myAndroid.sun.awt.geom.Curve;
import myAndroid.java.awt.Point;
import myAndroid.java.awt.Rectangle;

import java.util.Enumeration;
import java.util.Vector;

public class Area {


    private static Vector<Curve> EmptyCurves = new Vector<>();

    private Vector<Curve> curves;

    /**
     * Default constructor which creates an empty area.
     * @since 1.2
     */
    public Area() {
        curves = EmptyCurves;
    }

    public Area(Shape s) {
        if (s instanceof Area) {
            curves = ((Area) s).curves;
        } else {
            curves = pathToCurves(s.getPathIterator(null));
        }
    }

    private static Vector<Curve> pathToCurves(PathIterator pi) {
        Vector<Curve> curves = new Vector<>();
        int windingRule = pi.getWindingRule();
        // coords array is big enough for holding:
        //     coordinates returned from currentSegment (6)
        //     OR
        //         two subdivided quadratic curves (2+4+4=10)
        //         AND
        //             0-1 horizontal splitting parameters
        //             OR
        //             2 parametric equation derivative coefficients
        //     OR
        //         three subdivided cubic curves (2+6+6+6=20)
        //         AND
        //             0-2 horizontal splitting parameters
        //             OR
        //             3 parametric equation derivative coefficients
        double coords[] = new double[23];
        double movx = 0, movy = 0;
        double curx = 0, cury = 0;
        double newx, newy;
        while (!pi.isDone()) {
            switch (pi.currentSegment(coords)) {
                case PathIterator.SEG_MOVETO:
                    Curve.insertLine(curves, curx, cury, movx, movy);
                    curx = movx = coords[0];
                    cury = movy = coords[1];
                    Curve.insertMove(curves, movx, movy);
                    break;
                case PathIterator.SEG_LINETO:
                    newx = coords[0];
                    newy = coords[1];
                    Curve.insertLine(curves, curx, cury, newx, newy);
                    curx = newx;
                    cury = newy;
                    break;
                case PathIterator.SEG_QUADTO:
                    newx = coords[2];
                    newy = coords[3];
                    Curve.insertQuad(curves, curx, cury, coords);
                    curx = newx;
                    cury = newy;
                    break;
                case PathIterator.SEG_CUBICTO:
                    newx = coords[4];
                    newy = coords[5];
                    Curve.insertCubic(curves, curx, cury, coords);
                    curx = newx;
                    cury = newy;
                    break;
                case PathIterator.SEG_CLOSE:
                    Curve.insertLine(curves, curx, cury, movx, movy);
                    curx = movx;
                    cury = movy;
                    break;
            }
            pi.next();
        }
        Curve.insertLine(curves, curx, cury, movx, movy);
        AreaOp operator;
        if (windingRule == PathIterator.WIND_EVEN_ODD) {
            operator = new AreaOp.EOWindOp();
        } else {
            operator = new AreaOp.NZWindOp();
        }
        return operator.calculate(curves, EmptyCurves);
    }


    public void add(Area rhs) {
        curves = new AreaOp.AddOp().calculate(this.curves, rhs.curves);
        invalidateBounds();
    }

    public void subtract(Area rhs) {
        curves = new AreaOp.SubOp().calculate(this.curves, rhs.curves);
        invalidateBounds();
    }

    public void intersect(Area rhs) {
        curves = new AreaOp.IntOp().calculate(this.curves, rhs.curves);
        invalidateBounds();
    }

    public boolean isEmpty() {
        return (curves.size() == 0);
    }

    public Rectangle getBounds() {
        return getCachedBounds().getBounds();
    }




    // we debug it after rewriting rectangle class with rectangle2d exclusion
    private Rectangle2D getCachedBounds() {
        if (cachedBounds != null) {
            return cachedBounds;
        }
        Rectangle2D r = new Rectangle2D.Double();
        if (curves.size() > 0) {
            Curve c = curves.get(0);
            // First point is always an order 0 curve (moveto)
            r.setRect(c.getX0(), c.getY0(), 0, 0);
            for (int i = 1; i < curves.size(); i++) {
                curves.get(i).enlarge(r);
            }
        }
        return (cachedBounds = r);
    }

//    public Object clone() {
//        return new Area(this);
//    }


    public boolean contains(double x, double y) {
        if (!getCachedBounds().contains(x, y)) {
            return false;
        }
        Enumeration<Curve> enum_ = curves.elements();
        int crossings = 0;
        while (enum_.hasMoreElements()) {
            Curve c = enum_.nextElement();
            crossings += c.crossingsFor(x, y);
        }
        return ((crossings & 1) == 1);
    }

    public boolean contains(Point p) {
        return contains(p.getX(), p.getY());
    }




    private Rectangle2D cachedBounds;
    private void invalidateBounds() {
        cachedBounds = null;
    }
}
