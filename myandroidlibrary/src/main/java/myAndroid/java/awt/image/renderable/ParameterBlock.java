package myAndroid.java.awt.image.renderable;

import java.util.Vector;

public class ParameterBlock {

    protected Vector<Object> sources = new Vector<Object>();

    protected Vector<Object> parameters = new Vector<Object>();

    public ParameterBlock() {

    }

    public ParameterBlock addSource(Object source) {
        sources.addElement(source);
        return this;
    }

    public ParameterBlock add(Object obj) {
        parameters.addElement(obj);
        return this;
    }
}
