package com.mcasaje.riverflowcalculation.entities.river.crosssection.metric.meters;

import com.mcasaje.riverflowcalculation.entities.river.crosssection.CrossSection;

public interface MetricMetersCrossSectionBuilder {

    public MetricMetersCrossSectionBuilder addSubsection(double depth, double width, double velocity);

    public CrossSection build();

}
