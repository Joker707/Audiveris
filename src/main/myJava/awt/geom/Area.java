package myJava.awt.geom;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Area implements Shape, Cloneable {

    private final java.awt.geom.Area area = new java.awt.geom.Area();

    public void add(java.awt.geom.Area rhs) {
        area.add(rhs);
    }

    public void subtract(java.awt.geom.Area rhs) {
        area.subtract(rhs);
    }

    public void intersect(java.awt.geom.Area rhs) {
        area.intersect(rhs);
    }

    public boolean isEmpty() {
        return area.isEmpty();
    }

    public Rectangle2D getBounds2D() {
        return area.getBounds2D();
    }

    public Rectangle getBounds() {
        return area.getBounds();
    }

    public Object clone() {
        return area.clone();
    }

    public boolean contains(double x, double y) {
        return area.contains(x, y);
    }

    public boolean contains(Point2D p) {
        return area.contains(p);
    }

    public boolean contains(double x, double y, double w, double h) {
        return area.contains(x, y, w, h);
    }

    public boolean contains(Rectangle2D r) {
        return area.contains(r);
    }

    public boolean intersects(double x, double y, double w, double h) {
        return area.intersects(x, y, w, h);
    }

    public boolean intersects(Rectangle2D r) {
        return area.intersects(r);
    }

    public PathIterator getPathIterator(AffineTransform at) {
        return area.getPathIterator(at);
    }

    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return area.getPathIterator(at, flatness);
    }
}
