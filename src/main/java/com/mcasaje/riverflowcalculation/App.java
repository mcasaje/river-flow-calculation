package com.mcasaje.riverflowcalculation;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mcasaje.riverflowcalculation.entities.river.crosssection.CrossSection;
import com.mcasaje.riverflowcalculation.entities.river.crosssection.metric.MetricUnit;
import com.mcasaje.riverflowcalculation.entities.river.crosssection.metric.meters.MetricMetersCrossSectionBuilder;
import com.mcasaje.riverflowcalculation.entities.river.crosssection.metric.meters.MetricMetersSubsectionGuiceModule;
import com.mcasaje.riverflowcalculation.entities.river.math.area.AreaCalc;
import com.mcasaje.riverflowcalculation.entities.river.math.area.AreaCalcGuiceModule;
import com.mcasaje.riverflowcalculation.entities.river.math.discharge.DischargeCalc;
import com.mcasaje.riverflowcalculation.entities.river.math.discharge.DischargeCalcGuiceModule;

import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {

        // Setup
        Injector injector = getInjector();
        MetricMetersCrossSectionBuilder crossSectionBuilder =
                injector.getInstance(MetricMetersCrossSectionBuilder.class);
        DischargeCalc dischargeCalc = injector.getInstance(DischargeCalc.class);
        AreaCalc areaCalc = injector.getInstance(AreaCalc.class);

        // Assumption: River data will come from an external source such as a database or an API
        CrossSection crossSection1 = crossSectionBuilder
                .addSubsection(10, 5, 1)
                .addSubsection(10.2, 5, 1)
                .addSubsection(10, 5, 1)
                .build();
        BigDecimal dischargeOfCrossSection1 = dischargeCalc.calculateDischarge(crossSection1, areaCalc);

        CrossSection crossSection2 = crossSectionBuilder
                .addSubsection(0.5, 5, 0.25)
                .addSubsection(1.2, 3, 0.35)
                .addSubsection(2.7, 2, 0.45)
                .addSubsection(5.59, 2, 1.12)
                .addSubsection(8.91, 2, 1.12)
                .addSubsection(12.58, 2, 1.5)
                .addSubsection(18.6, 2, 1.6)
                .addSubsection(15.3, 2, 1.4)
                .addSubsection(11.96, 2, 1.45)
                .addSubsection(9.77, 2, 0.9)
                .addSubsection(3.22, 3, 0.5)
                .addSubsection(1.12, 3, 0.3)
                .addSubsection(0.75, 5, 0.27)
                .build();
        BigDecimal dischargeOfCrossSection2 = dischargeCalc.calculateDischarge(crossSection2, areaCalc);

        System.out.println("==================================================");
        System.out.println("Discharge of Cross Section 1:");
        System.out.print(dischargeOfCrossSection1);
        System.out.println(" " + MetricUnit.CUBIC_METERS_PER_SECOND);
        System.out.println();
        System.out.println("Discharge of Cross Section 2:");
        System.out.print(dischargeOfCrossSection2);
        System.out.println(" " + MetricUnit.CUBIC_METERS_PER_SECOND);
        System.out.println("==================================================");
    }

    private static Injector getInjector() {
        return Guice.createInjector(getGuiceModules());
    }

    private static AbstractModule[] getGuiceModules() {
        AreaCalcGuiceModule areaCalcGuiceModule = new AreaCalcGuiceModule();
        DischargeCalcGuiceModule dischargeCalcGuiceModule = new DischargeCalcGuiceModule();
        MetricMetersSubsectionGuiceModule metricMetersSubsectionGuiceModule = new MetricMetersSubsectionGuiceModule();
        return new AbstractModule[]{
                areaCalcGuiceModule,
                dischargeCalcGuiceModule,
                metricMetersSubsectionGuiceModule
        };
    }

}
