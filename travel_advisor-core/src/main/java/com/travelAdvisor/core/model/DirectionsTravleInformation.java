package com.travelAdvisor.core.model;

/**
 * Created by shahaf.sages on 9/23/16.
 */
public interface DirectionsTravleInformation extends TravelInformation{

    void incrementTotalDurationInMinutes(long value);

    void incrementTotalDistanceInMeters(long value);

    void addStep(Step step);

}
