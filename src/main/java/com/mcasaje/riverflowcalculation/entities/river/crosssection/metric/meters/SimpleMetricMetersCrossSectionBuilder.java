package com.mcasaje.riverflowcalculation.entities.river.crosssection.metric.meters;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

class SimpleMetricMetersCrossSectionBuilder implements MetricMetersCrossSectionBuilder {

    private List<MetricMetersSubsection> subsections;
    private MetricMetersSubsectionFactory factory;

    @Inject
    public SimpleMetricMetersCrossSectionBuilder(MetricMetersSubsectionFactory factory) {
        this.factory = factory;
        subsections = new ArrayList<>();
    }

    @Override
    public MetricMetersCrossSectionBuilder addSubsection(double depth, double width, double velocity) {
        MetricMetersSubsection newSubsection = factory.create(depth, width, velocity);
        subsections.add(newSubsection);
        return this;
    }

    @Override
    public MetricMetersCrossSection build() {
        return new MetricMetersCrossSection(subsections, factory);
    }

}
