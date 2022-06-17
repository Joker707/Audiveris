package myAndroid.java.awt.geom;


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
