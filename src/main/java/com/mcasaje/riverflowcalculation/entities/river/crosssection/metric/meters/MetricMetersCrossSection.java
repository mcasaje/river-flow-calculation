package com.mcasaje.riverflowcalculation.entities.river.crosssection.metric.meters;

import com.mcasaje.riverflowcalculation.entities.river.crosssection.CrossSection;
import com.mcasaje.riverflowcalculation.entities.river.crosssection.Subsection;
import com.mcasaje.riverflowcalculation.entities.river.crosssection.metric.MetricUnit;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class MetricMetersCrossSection extends CrossSection<MetricUnit> {

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
    public Subsection<MetricUnit> getSubsection(int index) {
        MetricMetersSubsection subsection = subsections.get(index);
        return subsectionFactory.cloneOf(subsection);
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
