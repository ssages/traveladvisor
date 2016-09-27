package com.travelAdvisor.core.decorator;

import com.travelAdvisor.core.advice.Advice;
import com.travelAdvisor.core.model.DirectionsTravelInformation;
import com.travelAdvisor.core.model.TravelInformation;
import com.travelAdvisor.core.model.WeatherTravelInformation;

import java.util.Set;

/**
 * Created by shahaf.sages on 9/24/16.
 */
public interface TravelInformationDecorator extends DirectionsTravelInformation, WeatherTravelInformation{

    TravelInformation getTravelInformation();

    int getNumberOfSteps();

    void calculateAdvice(Set<Advice> advices);


}
