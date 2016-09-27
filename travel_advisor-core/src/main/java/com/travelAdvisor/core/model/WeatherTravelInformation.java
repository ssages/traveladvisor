package com.travelAdvisor.core.model;

import java.util.Collection;

/**
 * Created by shahaf.sages on 9/23/16.
 */
public interface WeatherTravelInformation extends TravelInformation{

    Collection<Step> getSteps();
}
