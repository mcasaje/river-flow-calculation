package com.mcasaje.riverflowcalculation.entities.river.subsection.metric;

import com.mcasaje.riverflowcalculation.entities.river.subsection.Subsection;

import java.math.BigDecimal;

public abstract class MetricSubsection extends Subsection<MetricUnit> {

    private final BigDecimal depth;
    private final BigDecimal width;
    private final BigDecimal velocity;

    public MetricSubsection(double depth, double width, double velocity) {
        this.depth = new BigDecimal(depth);
        this.width = new BigDecimal(width);
        this.velocity = new BigDecimal(velocity);
    }

    @Override
    public BigDecimal getDepth() {
        return depth;
    }

    @Override
    public BigDecimal getWidth() {
        return width;
    }

    @Override
    public BigDecimal getVelocity() {
        return velocity;
    }

    public abstract MetricUnit getDepthUnits();

    public abstract MetricUnit getWidthUnits();

    public abstract MetricUnit getVelocityUnits();

}
