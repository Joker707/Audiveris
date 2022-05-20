package myJava.awt.geom;

import java.io.Serializable;

public abstract class Point2D implements Cloneable {

    private final MyPoint2D point2D = new MyPoint2D();

    public abstract double getX();

    public abstract double getY();

    public abstract void setLocation(double x, double y);

    public void setLocation(java.awt.geom.Point2D p) {
        point2D.setLocation(p);
    }

    public double distanceSq(java.awt.geom.Point2D pt) {
        return point2D.distanceSq(pt);
    }

    public double distance(java.awt.geom.Point2D pt) {
        return point2D.distance(pt);
    }

    public Object clone() {
        return point2D.clone();
    }

    public int hashCode() {
        return point2D.hashCode();
    }

    public boolean equals(Object obj) {
        return point2D.equals(obj);
    }

    private class MyPoint2D extends java.awt.geom.Point2D {
        public double getX() {
            return java.awt.geom.Point2D.this.getX();
        }

        public double getY() {
            return java.awt.geom.Point2D.this.getY();
        }

        public void setLocation(double x, double y) {
            java.awt.geom.Point2D.this.setLocation(x, y);
        }
    }
}
