package com.mcasaje.riverflowcalculation.entities.river.math.discharge;

import com.mcasaje.riverflowcalculation.entities.river.crosssection.CrossSection;
import com.mcasaje.riverflowcalculation.entities.river.math.area.AreaCalc;

import java.math.BigDecimal;

public interface DischargeCalc {

    public BigDecimal calculateDischarge(CrossSection crossSection, AreaCalc areaCalc);

    public BigDecimal calculateDischarge(BigDecimal area, BigDecimal velocity);

    public BigDecimal calculateDischarge(BigDecimal depth, BigDecimal width, BigDecimal velocity, AreaCalc areaCalc);

}
