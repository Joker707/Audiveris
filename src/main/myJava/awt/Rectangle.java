package myJava.awt;

import org.jetbrains.annotations.NotNull;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.*;
import java.io.Serializable;

public class Rectangle implements Shape, Cloneable, Serializable {

    public int x;
    public int y;
    public int width;
    public int height;



    private final java.awt.Rectangle rectangle = new java.awt.Rectangle();


    public double getMinY() {
        return rectangle.getMinY();
    }

    public double getMaxX() {
        return rectangle.getMaxX();
    }

    public double getMaxY() {
        return rectangle.getMaxY();
    }

    public double getCenterX() {
        return rectangle.getCenterX();
    }

    public double getCenterY() {
        return rectangle.getCenterY();
    }


    public boolean contains(Point2D p) {
        return rectangle.contains(p);
    }

    public boolean intersects(Rectangle2D r) {
        return rectangle.intersects(r);
    }

    public boolean contains(Rectangle2D r) {
        return rectangle.contains(r);
    }

    public Object clone() {
        return rectangle.clone();
    }


    public boolean intersectsLine(double x1, double y1, double x2, double y2) {
        return rectangle.intersectsLine(x1, y1, x2, y2);
    }


    public boolean contains(double x, double y) {
        return rectangle.contains(x, y);
    }

    public boolean intersects(double x, double y, double w, double h) {
        return rectangle.intersects(x, y, w, h);
    }

    public boolean contains(double x, double y, double w, double h) {
        return rectangle.contains(x, y, w, h);
    }

    public PathIterator getPathIterator(AffineTransform at) {
        return rectangle.getPathIterator(at);
    }

    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return rectangle.getPathIterator(at, flatness);
    }

    public int hashCode() {
        return rectangle.hashCode();
    }

    public double getWidth() {
        return rectangle.getWidth();
    }

    public double getHeight() {
        return rectangle.getHeight();
    }

    public java.awt.Rectangle getBounds() {
        return rectangle.getBounds();
    }

    public Rectangle2D getBounds2D() {
        return rectangle.getBounds2D();
    }

    public void setBounds(@NotNull java.awt.Rectangle r) {
        rectangle.setBounds(r);
    }

    public void setBounds(int x, int y, int width, int height) {
        rectangle.setBounds(x, y, width, height);
    }

    public Point getLocation() {
        return rectangle.getLocation();
    }

    public void translate(int dx, int dy) {
        rectangle.translate(dx, dy);
    }

    public Dimension getSize() {
        return rectangle.getSize();
    }

    public void setSize(int width, int height) {
        rectangle.setSize(width, height);
    }

    public boolean contains(@NotNull Point p) {
        return rectangle.contains(p);
    }

    public boolean contains(int x, int y) {
        return rectangle.contains(x, y);
    }

    public java.awt.Rectangle intersection(@NotNull java.awt.Rectangle r) {
        return rectangle.intersection(r);
    }

    public java.awt.Rectangle union(@NotNull java.awt.Rectangle r) {
        return rectangle.union(r);
    }

    public void add(int newx, int newy) {
        rectangle.add(newx, newy);
    }

    public void grow(int h, int v) {
        rectangle.grow(h, v);
    }

    public boolean isEmpty() {
        return rectangle.isEmpty();
    }

    public boolean equals(Object obj) {
        return rectangle.equals(obj);
    }

    public String toString() {
        return rectangle.toString();
    }
}
