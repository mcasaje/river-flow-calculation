package com.mcasaje.riverflowcalculation.entities.river.subsection.metric.simple;

import com.mcasaje.riverflowcalculation.entities.river.subsection.metric.MetricSubsection;
import com.mcasaje.riverflowcalculation.entities.river.subsection.SubsectionFactory;

public class MetersSubsectionFactory implements SubsectionFactory {

    @Override
    public MetricSubsection create(double depth, double width, double velocity) {
        return new MetersSubsection(depth, width, velocity);
    }

}
