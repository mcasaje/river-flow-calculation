package com.mcasaje.riverflowcalculation.entities.river.crosssection.metric.meters;

import com.mcasaje.riverflowcalculation.entities.river.crosssection.Subsection;
import com.mcasaje.riverflowcalculation.entities.river.crosssection.metric.MetricUnit;

import java.math.BigDecimal;

public class MetricMetersSubsection extends Subsection<MetricUnit> {

    private final double depthInMeters;
    private final double widthInMeters;
    private final double velocityInMetersPerSecond;

    MetricMetersSubsection(double depthInMeters, double widthInMeters, double velocityInMetersPerSecond) {
        this.depthInMeters = depthInMeters;
        this.widthInMeters = widthInMeters;
        this.velocityInMetersPerSecond = velocityInMetersPerSecond;
    }

    MetricMetersSubsection(MetricMetersSubsection original) {
        this.depthInMeters = original.getDepth().doubleValue();
        this.widthInMeters = original.getWidth().doubleValue();
        this.velocityInMetersPerSecond = original.getVelocity().doubleValue();
    }

    @Override
    public BigDecimal getDepth() {
        return BigDecimal.valueOf(depthInMeters);
    }

    @Override
    public BigDecimal getWidth() {
        return BigDecimal.valueOf(widthInMeters);
    }

    @Override
    public BigDecimal getVelocity() {
        return BigDecimal.valueOf(velocityInMetersPerSecond);
    }

    @Override
    public MetricUnit getDepthUnits() {
        return MetricUnit.METERS;
    }

    @Override
    public MetricUnit getWidthUnits() {
        return MetricUnit.METERS;
    }

    @Override
    public MetricUnit getVelocityUnits() {
        return MetricUnit.METERS_PER_SECOND;
    }

}
