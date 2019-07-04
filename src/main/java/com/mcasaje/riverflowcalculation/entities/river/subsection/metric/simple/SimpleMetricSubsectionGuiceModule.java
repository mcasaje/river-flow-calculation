package com.mcasaje.riverflowcalculation.entities.river.subsection.metric.simple;

import com.google.inject.AbstractModule;
import com.mcasaje.riverflowcalculation.entities.river.subsection.SubsectionFactory;

public class SimpleMetricSubsectionGuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(SubsectionFactory.class).to(MetersSubsectionFactory.class).asEagerSingleton();
    }

}
