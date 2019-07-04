package com.mcasaje.riverflowcalculation.entities.river.math.discharge;

import com.mcasaje.riverflowcalculation.entities.river.math.area.AreaCalc;

import java.math.BigDecimal;

public interface DischargeCalc {

    public BigDecimal calculateDischarge(BigDecimal area, BigDecimal velocity);

    public BigDecimal calculateDischarge(BigDecimal width, BigDecimal depth, BigDecimal velocity, AreaCalc areaCalc);

}
