package com.mcasaje.riverflowcalculation.entities.river.math.discharge;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mcasaje.riverflowcalculation.entities.river.math.area.AreaCalc;
import com.mcasaje.riverflowcalculation.entities.river.math.area.AreaCalcGuiceModule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;

public class SimpleDischargeCalc_calculateDischarge_WidthDepthVelocityAndAreaCalc_Test {

    private static Injector injector;
    private DischargeCalc sut;
    private AreaCalc areaCalc;

    @BeforeClass
    public static void initialSetup() {
        AreaCalcGuiceModule areaCalcModule = new AreaCalcGuiceModule();
        injector = Guice.createInjector(areaCalcModule);
    }

    @Before
    public void setup() {
        sut = new SimpleDischargeCalc();
        areaCalc = injector.getInstance(AreaCalc.class);
    }

    @Test
    public void calculateDischarge_givenWidthDepthVelocityAndAreaCalc_thenReturnsExpectedDischarge() {
        BigDecimal width = BigDecimal.valueOf(5.5);
        BigDecimal depth = BigDecimal.valueOf(23.2);
        BigDecimal velocity = BigDecimal.valueOf(2.5);
        BigDecimal expectedDischarge = BigDecimal.valueOf(319.0);
        BigDecimal actualDischarge = sut.calculateDischarge(width, depth, velocity, areaCalc);
        Assert.assertEquals(expectedDischarge, actualDischarge);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateDischarge_givenNullWidth_thenThrowsIllegalArgumentException() {
        BigDecimal width = null;
        BigDecimal depth = BigDecimal.valueOf(23.2);
        BigDecimal velocity = BigDecimal.valueOf(2.5);
        sut.calculateDischarge(width, depth, velocity, areaCalc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateDischarge_givenNullDepth_thenThrowsIllegalArgumentException() {
        BigDecimal width = BigDecimal.valueOf(5.5);
        BigDecimal depth = null;
        BigDecimal velocity = BigDecimal.valueOf(2.5);
        sut.calculateDischarge(width, depth, velocity, areaCalc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateDischarge_givenNullVelocity_thenThrowsIllegalArgumentException() {
        BigDecimal width = BigDecimal.valueOf(5.5);
        BigDecimal depth = BigDecimal.valueOf(23.2);
        BigDecimal velocity = null;
        sut.calculateDischarge(width, depth, velocity, areaCalc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateDischarge_givenNullAreaCalc_thenThrowsIllegalArgumentException() {
        BigDecimal width = BigDecimal.valueOf(5.5);
        BigDecimal depth = BigDecimal.valueOf(23.2);
        BigDecimal velocity = BigDecimal.valueOf(2.5);
        AreaCalc nullAreaCalc = null;
        sut.calculateDischarge(width, depth, velocity, nullAreaCalc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateDischarge_givenAllNullParams_thenThrowsIllegalArgumentException() {
        BigDecimal width = null;
        BigDecimal depth = null;
        BigDecimal velocity = null;
        AreaCalc nullAreaCalc = null;
        sut.calculateDischarge(width, depth, velocity, nullAreaCalc);
    }

}
