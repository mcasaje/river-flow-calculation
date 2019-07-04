package com.mcasaje.riverflowcalculation.entities.river.math.discharge;

import com.mcasaje.riverflowcalculation.entities.river.math.area.AreaCalc;

import java.math.BigDecimal;

class SimpleDischargeCalc implements DischargeCalc {

    @Override
    public BigDecimal calculateDischarge(BigDecimal width, BigDecimal depth, BigDecimal velocity, AreaCalc areaCalc) {
        return null;
    }

    @Override
    public BigDecimal calculateDischarge(BigDecimal area, BigDecimal velocity) {
        return null;
    }

}
