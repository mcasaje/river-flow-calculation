package com.mcasaje.riverflowcalculation.entities.river.math;

import java.math.BigDecimal;

public interface AreaCalc {

    BigDecimal calculateArea(BigDecimal width, BigDecimal depth) throws IllegalArgumentException;

}
