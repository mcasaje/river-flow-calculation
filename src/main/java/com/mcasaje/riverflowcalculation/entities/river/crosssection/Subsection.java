package com.mcasaje.riverflowcalculation.entities.river.crosssection;

import java.math.BigDecimal;

public abstract class Subsection<SYSTEM_OF_MEASUREMENT extends Enum> {

    public abstract BigDecimal getDepth();

    public abstract BigDecimal getWidth();

    public abstract BigDecimal getVelocity();

    public abstract SYSTEM_OF_MEASUREMENT getDepthUnits();

    public abstract SYSTEM_OF_MEASUREMENT getWidthUnits();

    public abstract SYSTEM_OF_MEASUREMENT getVelocityUnits();

}
