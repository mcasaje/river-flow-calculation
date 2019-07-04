package com.mcasaje.riverflowcalculation.entities.river.crosssection.metric.meters;

public interface MetricMetersCrossSectionBuilder {

    public void addSubsection(double depth, double width, double velocity);

    public MetricMetersCrossSection build();

}
