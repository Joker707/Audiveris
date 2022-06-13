package java.awt.geom;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;

public class Line2D extends java.awt.geom.Line2D {
    public static class Double implements Shape {
        public Double(double xx, double v, double xx1, double v1) {

        }

        @Override
        public Rectangle getBounds() {
            return null;
        }

        @Override
        public Rectangle2D getBounds2D() {
            return null;
        }

        @Override
        public boolean contains(double var1, double var3) {
            return false;
        }

        @Override
        public boolean contains(Point2D var1) {
            return false;
        }

        @Override
        public boolean intersects(double var1, double var3, double var5, double var7) {
            return false;
        }

        @Override
        public boolean intersects(Rectangle2D var1) {
            return false;
        }

        @Override
        public boolean contains(double var1, double var3, double var5, double var7) {
            return false;
        }

        @Override
        public boolean contains(Rectangle2D var1) {
            return false;
        }

        @Override
        public PathIterator getPathIterator(AffineTransform var1) {
            return null;
        }

        @Override
        public PathIterator getPathIterator(AffineTransform var1, double var2) {
            return null;
        }

        public double ptLineDist(Point point) {
            return 0;
        }
    }
}
