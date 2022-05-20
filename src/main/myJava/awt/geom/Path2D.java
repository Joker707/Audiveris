package myJava.awt.geom;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class Path2D implements Shape, Cloneable {


    private final MyPath2D path2D = new MyPath2D();

    public abstract void moveTo(double x, double y);

    public abstract void lineTo(double x, double y);

    public abstract Object clone();

    public abstract Rectangle2D getBounds2D();

    public abstract PathIterator getPathIterator(AffineTransform at);

    public void closePath() {
        path2D.closePath();
    }

    public Rectangle getBounds() {
        return path2D.getBounds();
    }

    public boolean contains(double x, double y) {
        return path2D.contains(x, y);
    }

    public boolean contains(Point2D p) {
        return path2D.contains(p);
    }

    public boolean contains(double x, double y, double w, double h) {
        return path2D.contains(x, y, w, h);
    }

    public boolean contains(Rectangle2D r) {
        return path2D.contains(r);
    }

    public boolean intersects(double x, double y, double w, double h) {
        return path2D.intersects(x, y, w, h);
    }

    public boolean intersects(Rectangle2D r) {
        return path2D.intersects(r);
    }

    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return path2D.getPathIterator(at, flatness);
    }

    private class MyPath2D extends java.awt.geom.Path2D {

        public void moveTo(double x, double y) {
            java.awt.geom.Path2D.this.moveTo(x, y);
        }

        public void lineTo(double x, double y) {
            java.awt.geom.Path2D.this.lineTo(x, y);
        }

        public void quadTo(double x1, double y1, double x2, double y2) {
            java.awt.geom.Path2D.this.quadTo(x1, y1, x2, y2);
        }

        public void curveTo(double x1, double y1, double x2, double y2, double x3, double y3) {
            java.awt.geom.Path2D.this.curveTo(x1, y1, x2, y2, x3, y3);
        }

        public void append(PathIterator pi, boolean connect) {
            java.awt.geom.Path2D.this.append(pi, connect);
        }

        public void transform(AffineTransform at) {
            java.awt.geom.Path2D.this.transform(at);
        }

        public Object clone() {
            return java.awt.geom.Path2D.this.clone();
        }

        public void trimToSize() {
            java.awt.geom.Path2D.this.trimToSize();
        }

        public Rectangle2D getBounds2D() {
            return Path2D.this.getBounds2D();
        }

        public PathIterator getPathIterator(AffineTransform at) {
            return Path2D.this.getPathIterator(at);
        }
    }
}
