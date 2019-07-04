package com.mcasaje.riverflowcalculation.entities.river.math.area;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class SimpleAreaCalc_calculateArea_Test {

    private AreaCalc sut;

    @Before
    public void setup() {
        sut = new SimpleAreaCalc();
    }

    @Test
    public void calculateArea_givenWidthAndDepthIntegers_thenReturnsExpectedArea() {
        BigDecimal width = BigDecimal.valueOf(2);
        BigDecimal depth = BigDecimal.TEN;
        BigDecimal expectedArea = BigDecimal.valueOf(20);
        BigDecimal actualArea = sut.calculateArea(width, depth);
        Assert.assertEquals(0, expectedArea.compareTo(actualArea));
    }

    @Test
    public void calculateArea_givenWidthAndDepthDoubles_thenReturnsExpectedArea() {
        BigDecimal width = BigDecimal.valueOf(3.5);
        BigDecimal depth = BigDecimal.valueOf(11.9);
        BigDecimal expectedArea = BigDecimal.valueOf(41.65);
        BigDecimal actualArea = sut.calculateArea(width, depth);
        Assert.assertEquals(0, expectedArea.compareTo(actualArea));
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateArea_givenNullWidth_thenThrowsIllegalArgumentException() {
        BigDecimal width = null;
        BigDecimal depth = BigDecimal.TEN;
        sut.calculateArea(width, depth);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateArea_givenNullDepth_thenThrowsIllegalArgumentException() {
        BigDecimal width = BigDecimal.ONE;
        BigDecimal depth = null;
        sut.calculateArea(width, depth);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateArea_givenNullWidthAndNullDepth_thenThrowsIllegalArgumentException() {
        BigDecimal width = null;
        BigDecimal depth = null;
        sut.calculateArea(width, depth);
    }

}
