//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                                  K e y C a n c e l S y m b o l                                 //
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
package org.audiveris.omr.ui.symbol;

import org.audiveris.omr.glyph.Shape;

/**
 * Class <code>KeyCancelSymbol</code> displays a Key Signature cancel symbol, using a
 * dynamically computed sequence of natural signs.
 *
 * @author Hervé Bitteur
 */
public class KeyCancelSymbol
        extends KeySymbol
{
    //~ Constructors -------------------------------------------------------------------------------

    /**
     * Creates a new <code>KeyCancelSymbol</code> object
     *
     * @param isIcon true for an icon
     */
    public KeyCancelSymbol (boolean isIcon)
    {
        super(0, isIcon, Shape.KEY_CANCEL, 110);
    }

    /**
     * Creates a KeyCancelSymbol with a count of naturals based on the precise key fifths
     * to cancel.
     *
     * @param fifths the canceled key
     */
    public KeyCancelSymbol (int fifths)
    {
        super(fifths, false, Shape.KEY_CANCEL, 110);
    }

    //~ Methods ------------------------------------------------------------------------------------
    //------------//
    // createIcon //
    //------------//
    @Override
    protected ShapeSymbol createIcon ()
    {
        return new KeyCancelSymbol(true);
    }
}
