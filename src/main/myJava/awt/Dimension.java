package myJava.awt;

import java.io.Serializable;

public class Dimension implements Cloneable, Serializable {

    private final Dimension dimension = new Dimension();

    public Object clone() {
        return dimension.clone();
    }

    public boolean equals(Object obj) {
        return dimension.equals(obj);
    }

    public int hashCode() {
        return dimension.hashCode();
    }

    public String toString() {
        return dimension.toString();
    }
}
