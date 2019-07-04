package com.mcasaje.riverflowcalculation.entities.river.math.discharge;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mcasaje.riverflowcalculation.entities.river.crosssection.CrossSection;
import com.mcasaje.riverflowcalculation.entities.river.crosssection.Subsection;
import com.mcasaje.riverflowcalculation.entities.river.math.area.AreaCalc;
import com.mcasaje.riverflowcalculation.entities.river.math.area.AreaCalcGuiceModule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

public class SimpleDischargeCalc_calculateDischarge_CrossSection_Test {

    private static Injector injector;
    private DischargeCalc sut;
    private AreaCalc areaCalc;
    private CrossSection mockCrossSection;
    private BigDecimal firstDepth = BigDecimal.valueOf(1.24);
    private BigDecimal firstWidth = BigDecimal.valueOf(1.5);
    private BigDecimal firstVelocity = BigDecimal.valueOf(2.6);
    private BigDecimal secondDepth = BigDecimal.valueOf(3.87);
    private BigDecimal secondWidth = BigDecimal.valueOf(3.0);
    private BigDecimal secondVelocity = BigDecimal.valueOf(3.1);

    @BeforeClass
    public static void initialSetup() {
        AreaCalcGuiceModule areaCalcModule = new AreaCalcGuiceModule();
        injector = Guice.createInjector(areaCalcModule);
    }

    @Before
    public void setup() {
        sut = new SimpleDischargeCalc();
        areaCalc = injector.getInstance(AreaCalc.class);

        Subsection firstMockSubsection = createMockSubsection(firstDepth, firstWidth, firstVelocity);
        Subsection secondMockSubsection = createMockSubsection(secondDepth, secondWidth, secondVelocity);
        mockCrossSection = Mockito.mock(CrossSection.class);
        when(mockCrossSection.getSubsectionCount()).thenReturn(2);
        when(mockCrossSection.getSubsectionDepth(0)).thenReturn(firstDepth);
        when(mockCrossSection.getSubsectionWidth(0)).thenReturn(firstWidth);
        when(mockCrossSection.getSubsectionVelocity(0)).thenReturn(firstVelocity);
        when(mockCrossSection.getSubsectionDepth(1)).thenReturn(secondDepth);
        when(mockCrossSection.getSubsectionWidth(1)).thenReturn(secondWidth);
        when(mockCrossSection.getSubsectionVelocity(1)).thenReturn(secondVelocity);
        when(mockCrossSection.getSubsection(0)).thenReturn(firstMockSubsection);
        when(mockCrossSection.getSubsection(1)).thenReturn(secondMockSubsection);
    }

    @Test
    public void calculateDischarge_givenCrossSection_thenReturnsExpectedDischarge() {
        // expectedDischarge = (depth*width*velocity of first subsection) + (depth*width*velocity of second subsection)
        BigDecimal expectedDischarge = BigDecimal.valueOf(40.827);
        BigDecimal actualDischarge = sut.calculateDischarge(mockCrossSection, areaCalc);
        Assert.assertEquals(0, expectedDischarge.compareTo(actualDischarge));
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateDischarge_givenNullCrossSection_thenThrowsIllegalArgumentException() {
        CrossSection crossSection = null;
        sut.calculateDischarge(crossSection, areaCalc);
    }

    private Subsection createMockSubsection(BigDecimal depth, BigDecimal width, BigDecimal velocity) {
        Subsection mockSubsection = mock(Subsection.class);
        when(mockSubsection.getDepth()).thenReturn(depth);
        when(mockSubsection.getWidth()).thenReturn(width);
        when(mockSubsection.getVelocity()).thenReturn(velocity);
        return mockSubsection;
    }

}
