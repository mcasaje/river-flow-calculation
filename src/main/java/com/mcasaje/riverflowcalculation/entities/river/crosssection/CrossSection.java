package com.mcasaje.riverflowcalculation.entities.river.crosssection;

import java.math.BigDecimal;

public abstract class CrossSection<SYSTEM_OF_MEASUREMENT extends Enum> {

    /**
     * @return the total number of subsections
     */
    public abstract int getSubsectionCount();

    /**
     * @param index position of the subsection to return - starting at index 0
     * @return the subsection at the specificed index
     */
    public abstract Subsection<SYSTEM_OF_MEASUREMENT> getSubsection(int index);

    /**
     * @param index position of the subsection to return - starting at index 0
     * @return the depth of the subsection at the specificed index
     */
    public abstract BigDecimal getSubsectionDepth(int index);

    /**
     * @param index position of the subsection to return - starting at index 0
     * @return the width of the subsection at the specificed index
     */
    public abstract BigDecimal getSubsectionWidth(int index);

    /**
     * @param index position of the subsection to return - starting at index 0
     * @return the velocity of the subsection at the specificed index
     */
    public abstract BigDecimal getSubsectionVelocity(int index);

}
