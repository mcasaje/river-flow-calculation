package com.mcasaje.riverflowcalculation.entities.river.math.discharge;

import com.mcasaje.riverflowcalculation.entities.river.math.area.AreaCalc;

import java.math.BigDecimal;

class SimpleDischargeCalc implements DischargeCalc {

    @Override
    public BigDecimal calculateDischarge(BigDecimal width, BigDecimal depth, BigDecimal velocity, AreaCalc areaCalc) {
        if(width == null) throw new IllegalArgumentException("Width cannot be null");
        if(depth == null) throw new IllegalArgumentException("Depth cannot be null");
        if(velocity == null) throw new IllegalArgumentException("Velocity cannot be null");
        if(areaCalc == null) throw new IllegalArgumentException("AreaCalc cannot be null");
        BigDecimal area = areaCalc.calculateArea(width, depth);
        return calculateDischarge(area, velocity);
    }

    @Override
    public BigDecimal calculateDischarge(BigDecimal area, BigDecimal velocity) {
        if(area == null) throw new IllegalArgumentException("Area cannot be null");
        if(velocity == null) throw new IllegalArgumentException("Velocity cannot be null");
        return area.multiply(velocity);
    }

}
