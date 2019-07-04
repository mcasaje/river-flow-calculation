package com.mcasaje.riverflowcalculation.entities.river.crosssection.metric.meters;

class SimpleMetricMetersSubsectionFactory implements MetricMetersSubsectionFactory {

    @Override
    public MetricMetersSubsection create(double depth, double width, double velocity) {
        return new MetricMetersSubsection(depth, width, velocity);
    }

    @Override
    public MetricMetersSubsection cloneOf(MetricMetersSubsection subsection) {
        return new MetricMetersSubsection(subsection);
    }

}
