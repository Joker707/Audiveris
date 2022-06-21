//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                                  B a s i c L i n e C h e c k                                   //
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
package com.example.myapplication.math;

import com.example.myapplication.util.BaseTestCase;
import org.audiveris.omr.math.BasicLine;
import org.junit.Test;

/**
 * Class <code>BasicLineCheck</code> gathers test bodies for various
 * unit tests on BasicLine class.
 *
 * @author Hervé Bitteur
 */
public class BasicLineCheck
        extends BaseTestCase
{

    public static void checkDistanceOf (BasicLine l)
    {
        print(l);

        double d = l.distanceOf(0, 0);
        System.out.println("Distance of origin: " + d);
        assertNears("Distance of origin", 0.19611613513818404d, d);

        double d1 = l.distanceOf(1, 0);
        System.out.println("Distance of (1,0): " + d1);
        assertNears("Distance of (1,0)", -0.7844645405527361, d1);

        double d2 = l.distanceOf(1, 10);
        System.out.println("Distance of (1,10): " + d2);
        assertNears("Distance of (1,10)", 1.176696810829104, d2);

        BasicLine ll = new BasicLine();
        ll.includePoint(1, 1);
        ll.includePoint(2, 10);

        double dll = ll.distanceOf(0, 0);
        System.out.println("ll Distance of (0.0): " + dll);
        assertNears("ll Distance of (0,0)", 0.8834522085987723, dll);

        BasicLine h = new BasicLine();
        h.includePoint(1, 1);
        h.includePoint(10, -2);

        double dh = h.distanceOf(0, 0);
        System.out.println("h Distance of (0.0): " + dh);
        assertNears("h Distance of (0,0)", 1.2649110640673515, dh);
    }

    public static void checkGetMeanDistance (BasicLine l)
    {
        print(l);

        double md = l.getMeanDistance();
        System.out.println(" md=" + md);
        assertNears("Check zero mean distance", 0d, md);
    }

    public static void checkGetNoMeanDistance (BasicLine l)
    {
        try {
            l.getMeanDistance();
            print(l);
            fail("Exception should be raised" + " when less than 2 points are known");
        } catch (Exception expected) {
            checkException(expected);
        }
    }

    public static void checkHorizontalPoints (BasicLine l)
    {
        l.includePoint(0, 1);
        l.includePoint(-2, 1);
        print(l);
    }

    public static void checkHorizontalXAt (BasicLine l)
    {
        l.includePoint(0, 0);
        l.includePoint(1, 0);
        print(l);

        try {
            double x = l.xAtY(0d);
            System.out.println("at y=0, x=" + x);
            fail("Exception should be raised" + " when abscissa cannot be determined");
        } catch (Exception expected) {
            checkException(expected);
        }
    }

    public static void checkHorizontalYAt (BasicLine l)
    {
        l.includePoint(0, 0);
        l.includePoint(1, 0);
        print(l);

        double y = l.yAtX(0d);
        System.out.println("at x=0, y=" + y);
    }







    public static void checkNoArgLine (BasicLine l)
    {
        assertEquals("No defining points", 0, l.getNumberOfPoints());
    }

    public static void checkNoDistanceOf (BasicLine l)
    {
        try {
            l.distanceOf(0, 0);
            fail("Exception should be raised" + " when line parameters are not set");
        } catch (Exception expected) {
            checkException(expected);
        }
    }

    public static void checkObliquePoints (BasicLine l)
    {
        l.includePoint(0, 0);
        l.includePoint(1, 1);
        print(l);
    }

    // --------------------------------------------------------------------


    public static void checkPointsLineNb (BasicLine l)
    {
        print(l);
        assertEquals("Five defining points", 5, l.getNumberOfPoints());
    }

    public static void checkReset (BasicLine l)
    {
        l.includePoint(12, 34);
        l.includePoint(56, 78);
        l.reset();
        assertEquals("Number of points", 0, l.getNumberOfPoints());
    }

    public static void checkSingleInclude (BasicLine l)
    {
        l.includePoint(1d, 3d);
        assertEquals("Number of points", 1, l.getNumberOfPoints());

        try {
            print(l);

            l.distanceOf(0, 0);
            fail("Exception should be raised" + " when line parameters are not set");
        } catch (Exception expected) {
            checkException(expected);
        }
    }

    public static void checkTangent (BasicLine l)
    {
        print(l);

        int y;
        y = 322;
        System.out.println("x=" + l.xAtY(y) + ", y=" + y);
        assertNears("xAt " + y, 241, l.xAtY(y));
        y = 323;
        System.out.println("x=" + l.xAtY(y) + ", y=" + y);
        assertNears("xAt " + y, 241, l.xAtY(y));
        y = 324;
        System.out.println("x=" + l.xAtY(y) + ", y=" + y);
        assertNears("xAt " + y, 240, l.xAtY(y));
    }

    public static void checkTangent1 (BasicLine l)
    {
        l.includePoint(214, 624);
        l.includePoint(215, 625);
        l.includePoint(215, 626);
        l.includePoint(215, 627);
        print(l);

        double y;
        y = 624;
        System.out.println("x=" + l.xAtY(y) + ", y=" + y);
        assertNears("xAt " + y, 214.3, l.xAtY(y));
        y = 625;
        System.out.println("x=" + l.xAtY(y) + ", y=" + y);
        assertNears("xAt " + y, 214.6, l.xAtY(y));
        y = 626;
        System.out.println("x=" + l.xAtY(y) + ", y=" + y);
        assertNears("xAt " + y, 214.9, l.xAtY(y));
        y = 627;
        System.out.println("x=" + l.xAtY(y) + ", y=" + y);
        assertNears("xAt " + y, 215.2, l.xAtY(y));
    }

    public static void checkTangent10 (BasicLine l)
    {
        l.includePoint(-1, 4);
        l.includePoint(0, 5);
        l.includePoint(0, 6);
        l.includePoint(0, 7);
        print(l);

        double y;
        y = 4;
        System.out.println("x=" + l.xAtY(y) + ", y=" + y);
        assertNears("xAt " + y, -0.7, l.xAtY(y));
        y = 5;
        System.out.println("x=" + l.xAtY(y) + ", y=" + y);
        assertNears("xAt " + y, -0.4, l.xAtY(y));
        y = 6;
        System.out.println("x=" + l.xAtY(y) + ", y=" + y);
        assertNears("xAt " + y, -0.1, l.xAtY(y));
        y = 7;
        System.out.println("x=" + l.xAtY(y) + ", y=" + y);
        assertNears("xAt " + y, 0.2, l.xAtY(y));
    }

    public static void checkTangent2 (BasicLine l)
    {
        l.includePoint(215, 627);
        l.includePoint(215, 626);
        l.includePoint(215, 625);
        l.includePoint(214, 624);
        print(l);

        double y;
        y = 624;
        System.out.println("x=" + l.xAtY(y) + ", y=" + y);
        assertNears("xAt " + y, 214.3, l.xAtY(y));
        y = 625;
        System.out.println("x=" + l.xAtY(y) + ", y=" + y);
        assertNears("xAt " + y, 214.6, l.xAtY(y));
        y = 626;
        System.out.println("x=" + l.xAtY(y) + ", y=" + y);
        assertNears("xAt " + y, 214.9, l.xAtY(y));
        y = 627;
        System.out.println("x=" + l.xAtY(y) + ", y=" + y);
        assertNears("xAt " + y, 215.2, l.xAtY(y));
        y = 628;
        System.out.println("x=" + l.xAtY(y) + ", y=" + y);
        assertNears("xAt " + y, 215.5, l.xAtY(y));
        System.out.println();
        y = 629;
        System.out.println("x=" + l.xAtY(y) + ", y=" + y);
        assertNears("xAt " + y, 215.8, l.xAtY(y));
        y = 630;
        System.out.println("x=" + l.xAtY(y) + ", y=" + y);
        assertNears("xAt " + y, 216.1, l.xAtY(y));
        y = 631;
        System.out.println("x=" + l.xAtY(y) + ", y=" + y);
        assertNears("xAt " + y, 216.4, l.xAtY(y));
    }

    public static void checkTangent3 (BasicLine l)
    {
        l.includePoint(222, 627);
        l.includePoint(222, 626);
        l.includePoint(222, 625);
        l.includePoint(221, 624);
        print(l);

        double y;
        y = 624;
        System.out.println("x=" + l.xAtY(y) + ", y=" + y);
        assertNears("xAt " + y, 221.3, l.xAtY(y));
        y = 625;
        System.out.println("x=" + l.xAtY(y) + ", y=" + y);
        assertNears("xAt " + y, 221.6, l.xAtY(y));
        y = 626;
        System.out.println("x=" + l.xAtY(y) + ", y=" + y);
        assertNears("xAt " + y, 221.9, l.xAtY(y));
        y = 627;
        System.out.println("x=" + l.xAtY(y) + ", y=" + y);
        assertNears("xAt " + y, 222.2, l.xAtY(y));
        y = 628;
        System.out.println("x=" + l.xAtY(y) + ", y=" + y);
        assertNears("xAt " + y, 222.5, l.xAtY(y));
        System.out.println();
        y = 629;
        System.out.println("x=" + l.xAtY(y) + ", y=" + y);
        assertNears("xAt " + y, 222.8, l.xAtY(y));
        y = 630;
        System.out.println("x=" + l.xAtY(y) + ", y=" + y);
        assertNears("xAt " + y, 223.1, l.xAtY(y));
        y = 631;
        System.out.println("x=" + l.xAtY(y) + ", y=" + y);
        assertNears("xAt " + y, 223.4, l.xAtY(y));
    }

    public static void checkVerticalPoints (BasicLine l)
    {
        l.includePoint(1, 0);
        l.includePoint(1, -2);
        print(l);
    }

    public static void checkVerticalXAt (BasicLine l)
    {
        l.includePoint(0, 0);
        l.includePoint(0, 1);
        assertNears("Ordinate axis", 0d, l.xAtY(0d));
    }

    public static void checkVerticalYAt (BasicLine l)
    {
        l.includePoint(0, 0);
        l.includePoint(0, 1);
        print(l);

        try {
            double y = l.yAtX(0d);
            System.out.println("at x=0, y=" + y);
            fail("Exception should be raised" + " when ordinate cannot be determined");
        } catch (Exception expected) {
            checkException(expected);
        }
    }

    public static void checkXAt (BasicLine l)
    {
        l.includePoint(1d, 3d);
        l.includePoint(-1d, 1d);
        print(l);
        assertNears("Crossing x axis", -2d, l.xAtY(0d));
        assertNears("Crossing y axis", 0d, l.xAtY(2d));
    }

    public static void checkXAtInt (BasicLine l)
    {
        l.includePoint(0, 0);
        l.includePoint(2, 5);
        print(l);
        assertEquals("Rounding test.", 1, l.xAtY(3));
    }

    public static void checkYAt (BasicLine l)
    {
        l.includePoint(1d, 3d);
        l.includePoint(-1d, 1d);
        print(l);
        assertNears("Crossing x axis", 0d, l.yAtX(-2d));
        assertNears("Crossing y axis", 2d, l.yAtX(0d));
    }

    public static void checkYAtInt (BasicLine l)
    {
        l.includePoint(0, 0);
        l.includePoint(5, 2);
        print(l);
        assertEquals("Rounding test.", 2, l.yAtX(4));
    }

    @Test
    public void testPlaceHolder ()
    {
        System.out.println("BaseTestCase. testPlaceHolder");
    }

    //-----------------------//
    // assertParamsUndefined //
    //-----------------------//

}
