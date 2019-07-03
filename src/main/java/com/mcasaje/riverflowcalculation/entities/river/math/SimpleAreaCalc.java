package com.mcasaje.riverflowcalculation.entities.river.math;

import java.math.BigDecimal;

class SimpleAreaCalc implements AreaCalc {

    @Override
    public BigDecimal calculateArea(BigDecimal width, BigDecimal depth) {
        if (width == null) throw new IllegalArgumentException("Width cannot be null");
        if (depth == null) throw new IllegalArgumentException("Depth cannot be null");
        return width.multiply(depth);
    }

}
