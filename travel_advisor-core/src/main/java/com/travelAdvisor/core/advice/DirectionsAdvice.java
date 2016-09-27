package com.travelAdvisor.core.advice;

import com.travelAdvisor.core.model.DirectionsTravelInformation;
import org.springframework.stereotype.Component;

/**
 * Created by shahaf.sages on 9/24/16.
 */
@Component
public class DirectionsAdvice implements Advice<DirectionsTravelInformation>{


    @Override
    public boolean calculate(DirectionsTravelInformation travelInformation) {
        return travelInformation.getTotalDurationInMinutes()/60 < 3;
    }
}
