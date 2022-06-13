//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                                        B e a m I n t e r                                       //
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
package org.audiveris.omr.sig.inter;

import org.audiveris.omr.glyph.Shape;
import org.audiveris.omr.sig.GradeImpacts;

import java.awt.geom.Line2D;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class <code>BeamInter</code> represents a (full) beam interpretation, as opposed
 * to a beam hook interpretation.
 *
 * @see BeamHookInter
 * @author Hervé Bitteur
 */
@XmlRootElement(name = "beam")
public class BeamInter
        extends AbstractBeamInter
{
    //~ Constructors -------------------------------------------------------------------------------

    /**
     * Creates a new BeamInter object.
     *
     * @param impacts the grade details
     * @param median  median beam line
     * @param height  beam height
     */
    public BeamInter (GradeImpacts impacts,
                      Line2D median,
                      double height)
    {
        super(Shape.BEAM, impacts, median, height);
    }

    /**
     * Creates manually a new BeamInter ghost object.
     *
     * @param grade quality grade
     */
    public BeamInter (Double grade)
    {
        super(Shape.BEAM, grade);
    }

    /**
     * Meant for JAXB.
     */
    private BeamInter ()
    {
        super(null, null, null, 0);
    }

    //~ Methods ------------------------------------------------------------------------------------
    //--------//
    // accept //
    //--------//
    @Override
    public void accept (InterVisitor visitor)
    {
        visitor.visit(this);
    }
}
