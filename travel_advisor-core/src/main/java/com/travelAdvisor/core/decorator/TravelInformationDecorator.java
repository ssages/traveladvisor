package com.travelAdvisor.core.decorator;

import com.travelAdvisor.core.model.DirectionsTravelInformation;
import com.travelAdvisor.core.model.TravelInformation;
import com.travelAdvisor.core.model.WeatherTravelInformation;

/**
 * Created by shahaf.sages on 9/24/16.
 */
public interface TravelInformationDecorator extends DirectionsTravelInformation, WeatherTravelInformation{

    TravelInformation getTravelInformation();

    void calculateAdvice();

}
