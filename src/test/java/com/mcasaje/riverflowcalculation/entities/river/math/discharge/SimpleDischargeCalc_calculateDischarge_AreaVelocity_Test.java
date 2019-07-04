package com.mcasaje.riverflowcalculation.entities.river.math.discharge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class SimpleDischargeCalc_calculateDischarge_AreaVelocity_Test {

    private DischargeCalc sut;

    @Before
    public void setup() {
        sut = new SimpleDischargeCalc();
    }

    @Test
    public void calculateDischarge_givenAreaAndVelocity_thenReturnsExpectedDischarge() {
        BigDecimal area = BigDecimal.valueOf(6);
        BigDecimal velocity = BigDecimal.valueOf(3.25);
        BigDecimal expectedDischarge = BigDecimal.valueOf(19.5);
        BigDecimal actualDischarge = sut.calculateDischarge(area, velocity);
        Assert.assertEquals(0, expectedDischarge.compareTo(actualDischarge));
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateDischarge_givenNullArea_thenThrowsIllegalArgumentException() {
        BigDecimal area = null;
        BigDecimal velocity = BigDecimal.valueOf(3.25);
        sut.calculateDischarge(area, velocity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateDischarge_givenNullVelocity_thenThrowsIllegalArgumentException() {
        BigDecimal area = BigDecimal.valueOf(3.25);
        BigDecimal velocity = null;
        sut.calculateDischarge(area, velocity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateDischarge_givenNullAreaAndNullVelocity_thenThrowsIllegalArgumentException() {
        BigDecimal area = null;
        BigDecimal velocity = null;
        sut.calculateDischarge(area, velocity);
    }

}
