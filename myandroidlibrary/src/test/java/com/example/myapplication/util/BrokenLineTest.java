//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                                  B r o k e n L i n e T e s t                                   //
//                                                                                                //
//------------------------------------------------------------------------------------------------//
// <editor-fold defaultstate="collapsed" desc="hdr">
//
//  Copyright © Audiveris 2021. All rights reserved.
//
//  This program is free software: you can redistribute it and/or modify it under the terms of the
//  GNU Affero General Public License as published by the Free Software Foundation, either version
//  3 of the License, or (at your option) any later version.
//
//  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
//  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
//  See the GNU Affero General Public License for more details.
//
//  You should have received a copy of the GNU Affero General Public License along with this
//  program.  If not, see <http://www.gnu.org/licenses/>.
//------------------------------------------------------------------------------------------------//
// </editor-fold>
package com.example.myapplication.util;

import myAndroid.java.awt.Point;
import org.audiveris.omr.util.BrokenLine;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Class <code>BrokenLineTest</code> is a set of unitary tests for the
 * <code>BrokenLine</code> class.
 *
 * @author Hervé Bitteur
 * @version $Id$
 */
public class BrokenLineTest
{

    private Point p0 = new Point(1, 5);

    private Point p1 = new Point(10, 5);

    private Point p2 = new Point(10, 1);

    private Point p3 = new Point(1, 1);

    private BrokenLine instance;

    /**
     * Creates a new BrokenLineTest object.
     */
    public BrokenLineTest()
    {
        ///System.out.println("BrokenLineTest");
    }

    /**
     * Test of addPoint method, of class BrokenLine.
     */
    @Test
    public void addPoint ()
    {
        System.out.println("addPoint");
        System.out.println("before: " + instance.getSequenceString());

        Point point = new Point(2, 3);
        instance.addPoint(point);
        System.out.println("after : " + instance.getSequenceString());

        ///assertEquals(5, instance.size());
    }

    /**
     * Test of addPointEmpty method, of class BrokenLine.
     */
    @Test
    public void addPointEmpty ()
    {
        System.out.println("addPointEmpty");
        instance = new BrokenLine();
        System.out.println("before: " + instance.getSequenceString());

        Point point = new Point(2, 3);
        instance.addPoint(point);
        System.out.println("after : " + instance.getSequenceString());

        ///assertEquals(1, instance.size());
    }


    /**
     * Test of getPoint method, of class BrokenLine.
     */
    @Test
    public void getPoint ()
    {
        System.out.println("getPoint");

        int index = 2;
        Point expResult = p2;
        Point result = instance.getPoint(index);
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of getPoints method, of class BrokenLine.
     */
    @Test
    public void getSequence ()
    {
        System.out.println("getSequence");

        List<Point> expResult = Arrays.asList(p0, p1, p2, p3);
        List<Point> result = instance.getPoints();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSequenceString method, of class BrokenLine.
     */
    @Test
    public void getSequenceString ()
    {
        System.out.println("getSequenceString");

        String expResult = "[(1,5) (10,5) (10,1) (1,1)]";
        String result = instance.getSequenceString();
        assertEquals(expResult, result);
    }

    /**
     * Test of indexOf method, of class BrokenLine.
     */
    @Test
    public void indexOf ()
    {
        int expResult = 2;
        int result = instance.indexOf(p2);
        assertEquals(expResult, result);
    }

    /**
     * Test of insertPoint method, of class BrokenLine.
     */
    @Test
    public void insertPoint ()
    {
        int index = 2;
        System.out.println("insertPoint " + index);
        System.out.println("before: " + instance.getSequenceString());

        Point point = new Point(5, 2);
        instance.insertPoint(index, point);
        System.out.println("after : " + instance.getSequenceString());
        assertTrue(point.equals(instance.getPoint(index)));
    }

    /**
     * Test of insertPointAfter method, of class BrokenLine.
     */
    @Test
    public void insertPointAfter ()
    {
        System.out.println("insertPointAfter " + p2);
        System.out.println("before: " + instance.getSequenceString());

        Point point = new Point(5, 2);
        instance.insertPointAfter(point, p2);
        System.out.println("after : " + instance.getSequenceString());
        assertEquals(3, instance.indexOf(point));
    }



    /**
     * Test of movePoint method, of class BrokenLine.
     */
    @Test
    public void movePoint ()
    {
        System.out.println("movePoint " + p1);
        System.out.println("before: " + instance.getSequenceString());

        Point location = new Point(11, 6);
        p1.setLocation(location);

        System.out.println("after : " + instance.getSequenceString());
        assertEquals(location, instance.getPoint(1));
    }

    /**
     * Test of removePoint method, of class BrokenLine.
     */
    @Test
    public void removePoint ()
    {
        System.out.println("removePoint " + p2);
        System.out.println("before: " + instance.getSequenceString());

        instance.removePoint(p2);
        System.out.println("after : " + instance.getSequenceString());
        assertTrue(p3.equals(instance.getPoint(2)));
    }

    @Before
    public void setUp ()
    {
        ///System.out.println("setUp");
        instance = new BrokenLine(p0, p1, p2, p3);
    }
}
