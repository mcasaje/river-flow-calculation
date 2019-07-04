package com.mcasaje.riverflowcalculation.entities.river.crosssection.metric.meters;

public interface MetricMetersCrossSectionBuilder {

    public MetricMetersCrossSectionBuilder addSubsection(double depth, double width, double velocity);

    public MetricMetersCrossSection build();

}
