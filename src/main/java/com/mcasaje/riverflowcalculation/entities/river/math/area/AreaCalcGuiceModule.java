package com.mcasaje.riverflowcalculation.entities.river.math.area;

import com.google.inject.AbstractModule;

public class AreaCalcGuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AreaCalc.class).to(SimpleAreaCalc.class).asEagerSingleton();
    }
}
