package com.mcasaje.riverflowcalculation.entities.river.crosssection.metric.meters;

import com.mcasaje.riverflowcalculation.entities.river.crosssection.CrossSection;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

class MetricMetersCrossSection extends CrossSection {

    private List<MetricMetersSubsection> subsections;
    private MetricMetersSubsectionFactory subsectionFactory;

    MetricMetersCrossSection(MetricMetersSubsection[] subsections,
                             MetricMetersSubsectionFactory subsectionFactory) {
        this.subsections = Arrays.asList(subsections);
        this.subsectionFactory = subsectionFactory;
    }

    MetricMetersCrossSection(List<MetricMetersSubsection> subsections,
                             MetricMetersSubsectionFactory subsectionFactory) {
        this.subsections = subsections;
        this.subsectionFactory = subsectionFactory;
    }

    @Override
    public int getSubsectionCount() {
        return subsections.size();
    }

    @Override
    public BigDecimal getSubsectionDepth(int index) {
        MetricMetersSubsection subsection = subsections.get(index);
        return subsection.getDepth();
    }

    @Override
    public BigDecimal getSubsectionWidth(int index) {
        MetricMetersSubsection subsection = subsections.get(index);
        return subsection.getWidth();
    }

    @Override
    public BigDecimal getSubsectionVelocity(int index) {
        MetricMetersSubsection subsection = subsections.get(index);
        return subsection.getVelocity();
    }

}
