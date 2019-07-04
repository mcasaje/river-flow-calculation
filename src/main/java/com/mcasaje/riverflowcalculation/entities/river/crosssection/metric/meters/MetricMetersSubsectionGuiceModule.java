package com.mcasaje.riverflowcalculation.entities.river.crosssection.metric.meters;

import com.google.inject.AbstractModule;

public class MetricMetersSubsectionGuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MetricMetersCrossSectionBuilder.class).to(SimpleMetricMetersCrossSectionBuilder.class);
        bind(MetricMetersSubsectionFactory.class).to(SimpleMetricMetersSubsectionFactory.class).asEagerSingleton();
    }

}
