package com.mcasaje.riverflowcalculation.entities.river.math.discharge;

import com.mcasaje.riverflowcalculation.entities.river.crosssection.CrossSection;
import com.mcasaje.riverflowcalculation.entities.river.crosssection.Subsection;
import com.mcasaje.riverflowcalculation.entities.river.math.area.AreaCalc;

import java.math.BigDecimal;
import java.util.stream.IntStream;

class SimpleDischargeCalc implements DischargeCalc {

    @Override
    public BigDecimal calculateDischarge(CrossSection crossSection, AreaCalc areaCalc) {
        if (crossSection == null) throw new IllegalArgumentException("CrossSection cannot be null");
        int subsectionCount = crossSection.getSubsectionCount();
        return IntStream.range(0, subsectionCount)
                .mapToObj(crossSection::getSubsection)
                .map((Subsection section) -> calculateDischarge(section.getDepth(),
                                                                section.getWidth(),
                                                                section.getVelocity(),
                                                                areaCalc))
                .reduce(BigDecimal::add)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public BigDecimal calculateDischarge(BigDecimal depth, BigDecimal width, BigDecimal velocity, AreaCalc areaCalc) {
        if (width == null) throw new IllegalArgumentException("Width cannot be null");
        if (depth == null) throw new IllegalArgumentException("Depth cannot be null");
        if (velocity == null) throw new IllegalArgumentException("Velocity cannot be null");
        if (areaCalc == null) throw new IllegalArgumentException("AreaCalc cannot be null");
        BigDecimal area = areaCalc.calculateArea(width, depth);
        return calculateDischarge(area, velocity);
    }

    @Override
    public BigDecimal calculateDischarge(BigDecimal area, BigDecimal velocity) {
        if (area == null) throw new IllegalArgumentException("Area cannot be null");
        if (velocity == null) throw new IllegalArgumentException("Velocity cannot be null");
        return area.multiply(velocity);
    }

}
