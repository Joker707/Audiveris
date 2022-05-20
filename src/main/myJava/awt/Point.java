package myJava.awt;

import java.awt.geom.Point2D;
import java.io.Serializable;

public class Point implements Cloneable, Serializable {


    private final java.awt.Point point = new java.awt.Point();


    public double distanceSq(Point2D pt) {
        return point.distanceSq(pt);
    }

    public double distance(Point2D pt) {
        return point.distance(pt);
    }

    public Object clone() {
        return point.clone();
    }

    public int hashCode() {
        return point.hashCode();
    }

    public double getX() {
        return point.getX();
    }

    public double getY() {
        return point.getY();
    }

    public void move(int x, int y) {
        point.move(x, y);
    }

    public void translate(int dx, int dy) {
        point.translate(dx, dy);
    }

    public boolean equals(Object obj) {
        return point.equals(obj);
    }

    public String toString() {
        return point.toString();
    }
}
