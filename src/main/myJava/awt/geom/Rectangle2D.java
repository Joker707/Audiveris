package myJava.awt.geom;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;

public abstract class Rectangle2D implements Shape, Cloneable {

    private final MyRectangle2D rectangle2D = new MyRectangle2D();

    public abstract void setRect(double x, double y, double w, double h);

    public abstract java.awt.geom.Rectangle2D createUnion(java.awt.geom.Rectangle2D r);

    public abstract double getX();

    public abstract double getY();

    public abstract double getWidth();

    public abstract double getHeight();

    public abstract boolean isEmpty();

    public double getMaxX() {
        return rectangle2D.getMaxX();
    }

    public boolean contains(Point2D p) {
        return rectangle2D.contains(p);
    }

    public boolean intersects(java.awt.geom.Rectangle2D r) {
        return rectangle2D.intersects(r);
    }

    public boolean contains(java.awt.geom.Rectangle2D r) {
        return rectangle2D.contains(r);
    }

    public Rectangle getBounds() {
        return rectangle2D.getBounds();
    }

    public Object clone() {
        return rectangle2D.clone();
    }

    public void setRect(java.awt.geom.Rectangle2D r) {
        rectangle2D.setRect(r);
    }

    public java.awt.geom.Rectangle2D getBounds2D() {
        return rectangle2D.getBounds2D();
    }

    public boolean contains(double x, double y) {
        return rectangle2D.contains(x, y);
    }

    public boolean intersects(double x, double y, double w, double h) {
        return rectangle2D.intersects(x, y, w, h);
    }

    public boolean contains(double x, double y, double w, double h) {
        return rectangle2D.contains(x, y, w, h);
    }

    public PathIterator getPathIterator(AffineTransform at) {
        return rectangle2D.getPathIterator(at);
    }

    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return rectangle2D.getPathIterator(at, flatness);
    }

    public int hashCode() {
        return rectangle2D.hashCode();
    }

    public boolean equals(Object obj) {
        return rectangle2D.equals(obj);
    }

    private class MyRectangle2D extends java.awt.geom.Rectangle2D {
        public void setRect(double x, double y, double w, double h) {
            java.awt.geom.Rectangle2D.this.setRect(x, y, w, h);
        }

        public int outcode(double x, double y) {
            return java.awt.geom.Rectangle2D.this.outcode(x, y);
        }

        public java.awt.geom.Rectangle2D createIntersection(java.awt.geom.Rectangle2D r) {
            return java.awt.geom.Rectangle2D.this.createIntersection(r);
        }

        public java.awt.geom.Rectangle2D createUnion(java.awt.geom.Rectangle2D r) {
            return java.awt.geom.Rectangle2D.this.createUnion(r);
        }

        public double getX() {
            return Rectangle2D.this.getX();
        }

        public double getY() {
            return Rectangle2D.this.getY();
        }

        public double getWidth() {
            return Rectangle2D.this.getWidth();
        }

        public double getHeight() {
            return Rectangle2D.this.getHeight();
        }

        public boolean isEmpty() {
            return Rectangle2D.this.isEmpty();
        }
    }
}
