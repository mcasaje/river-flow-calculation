package com.mcasaje.riverflowcalculation.entities.river.math.discharge;

import com.google.inject.AbstractModule;

public class DischargeCalcGuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(DischargeCalc.class).to(SimpleDischargeCalc.class);
    }
}
