package com.mcasaje.riverflowcalculation.entities.river.subsection.metric.simple;

import com.mcasaje.riverflowcalculation.entities.river.subsection.metric.MetricSubsection;
import com.mcasaje.riverflowcalculation.entities.river.subsection.metric.MetricUnit;

class MetersSubsection extends MetricSubsection {

    public MetersSubsection(double depthInMeters, double widthInMeters, double velocityInMetersPerSecond) {
        super(depthInMeters, widthInMeters, velocityInMetersPerSecond);
    }

    @Override
    public MetricUnit getDepthUnits() {
        return MetricUnit.METER;
    }

    @Override
    public MetricUnit getWidthUnits() {
        return MetricUnit.METER;
    }

    @Override
    public MetricUnit getVelocityUnits() {
        return MetricUnit.METER_PER_SECOND;
    }

}
