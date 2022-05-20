@XmlJavaTypeAdapters({
    @XmlJavaTypeAdapter(value = Jaxb.PointAdapter.class, type = Point.class),
    @XmlJavaTypeAdapter(value = Jaxb.RectangleAdapter.class, type = Rectangle.class)
})
package org.audiveris.omr.jaxb.facade;

import org.audiveris.omr.util.Jaxb;

import myJava.awt.Point;
import myJava.awt.Rectangle;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
