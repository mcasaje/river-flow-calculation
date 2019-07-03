package com.mcasaje.riverflowcalculation.entities.river.subsection;

import java.math.BigDecimal;

public interface Subsection<SYSTEM_OF_MEASUREMENT> {

    public BigDecimal getDepth();

    public BigDecimal getWidth();

    public BigDecimal getVelocity();

    public SYSTEM_OF_MEASUREMENT getDepthUnits();

    public SYSTEM_OF_MEASUREMENT getWidthUnits();

    public SYSTEM_OF_MEASUREMENT getVelocityUnits();

}
