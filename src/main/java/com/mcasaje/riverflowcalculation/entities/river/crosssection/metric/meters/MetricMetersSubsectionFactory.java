package com.mcasaje.riverflowcalculation.entities.river.crosssection.metric.meters;

public interface MetricMetersSubsectionFactory {

    public MetricMetersSubsection create(double depth, double width, double velocity);

    public MetricMetersSubsection cloneOf(MetricMetersSubsection subsection);

}
