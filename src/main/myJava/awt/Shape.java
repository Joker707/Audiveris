package myJava.awt;

import myJava.awt.geom.AffineTransform;
import myJava.awt.geom.PathIterator;
import myJava.awt.geom.Point2D;
import myJava.awt.geom.Rectangle2D;

public interface Shape {

    Rectangle getBounds();

    Rectangle2D getBounds2D();

    boolean contains(double var1, double var3);

    boolean contains(Point2D var1);

    boolean intersects(double var1, double var3, double var5, double var7);

    boolean intersects(Rectangle2D var1);

    boolean contains(double var1, double var3, double var5, double var7);

    boolean contains(Rectangle2D var1);

    PathIterator getPathIterator(AffineTransform var1);

    PathIterator getPathIterator(AffineTransform var1, double var2);
}
