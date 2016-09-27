package com.travelAdvisor.core.model;

import java.util.Iterator;

/**
 * Created by shahaf.sages on 9/23/16.
 */
public interface DirectionsTravelInformation extends TravelInformation{

    void incrementTotalDurationInMinutes(long value);

    void incrementTotalDistanceInMeters(long value);

    void addStep(Step step);

    long getTotalDurationInMinutes();

}
