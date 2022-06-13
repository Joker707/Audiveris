package java.awt;

import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

public class Polygon implements Shape, Serializable {

    private final java.awt.Polygon polygon = new java.awt.Polygon();

    public void translate(int deltaX, int deltaY) {
        polygon.translate(deltaX, deltaY);
    }

    public void addPoint(int x, int y) {
        polygon.addPoint(x, y);
    }

    public Rectangle getBounds() {
        return polygon.getBounds();
    }

    public Rectangle2D getBounds2D() {
        return polygon.getBounds2D();
    }

    public boolean contains(double x, double y) {
        return polygon.contains(x, y);
    }

    public boolean contains(Point2D p) {
        return polygon.contains(p);
    }

    public boolean intersects(double x, double y, double w, double h) {
        return polygon.intersects(x, y, w, h);
    }

    public boolean intersects(Rectangle2D r) {
        return polygon.intersects(r);
    }

    public boolean contains(double x, double y, double w, double h) {
        return polygon.contains(x, y, w, h);
    }

    public boolean contains(Rectangle2D r) {
        return polygon.contains(r);
    }

    public PathIterator getPathIterator(AffineTransform at) {
        return polygon.getPathIterator(at);
    }

    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return polygon.getPathIterator(at, flatness);
    }
}
