package com.mcasaje.riverflowcalculation.entities.river.subsection;

public interface SubsectionFactory {

    public Subsection create(double depth, double width, double velocity);

}
