package com.mcasaje.riverflowcalculation.entities.river.math.discharge;

import com.mcasaje.riverflowcalculation.entities.river.crosssection.CrossSection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

public class SimpleDischargeCalc_calculateDischarge_CrossSection_Test {

    private DischargeCalc sut;


    @Before
    public void setup() {
        sut = new SimpleDischargeCalc();
    }

    @Test
    public void calculateDischarge_givenCrossSection_thenReturnsExpectedDischarge() {
        BigDecimal firstSubsectionDepth = BigDecimal.valueOf(1.24);
        BigDecimal firstSubsectionWidth = BigDecimal.valueOf(1.5);
        BigDecimal firstSubsectionVelocity = BigDecimal.valueOf(2.6);
        BigDecimal secondSubsectionDepth = BigDecimal.valueOf(3.87);
        BigDecimal secondSubsectionWidth = BigDecimal.valueOf(3.0);
        BigDecimal secondSubsectionVelocity = BigDecimal.valueOf(3.1);

        CrossSection crossSection = Mockito.mock(CrossSection.class);
        when(crossSection.getSubsectionCount()).thenReturn(2);
        when(crossSection.getSubsectionDepth(0)).thenReturn(firstSubsectionDepth);
        when(crossSection.getSubsectionWidth(0)).thenReturn(firstSubsectionWidth);
        when(crossSection.getSubsectionVelocity(0)).thenReturn(firstSubsectionVelocity);
        when(crossSection.getSubsectionDepth(1)).thenReturn(secondSubsectionDepth);
        when(crossSection.getSubsectionWidth(1)).thenReturn(secondSubsectionWidth);
        when(crossSection.getSubsectionVelocity(1)).thenReturn(secondSubsectionVelocity);

        // expectedDischarge = (depth*width*velocity of first subsection) + (depth*width*velocity of second subsection)
        BigDecimal expectedDischarge = BigDecimal.valueOf(40.827);
        BigDecimal actualDischarge = sut.calculateDischarge(crossSection);
        Assert.assertEquals(expectedDischarge, actualDischarge);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateDischarge_givenNullCrossSection_thenThrowsIllegalArgumentException() {
        CrossSection crossSection = null;
        sut.calculateDischarge(crossSection);
    }

}
