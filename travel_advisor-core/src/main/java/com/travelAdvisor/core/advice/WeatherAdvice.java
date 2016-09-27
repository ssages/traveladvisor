package com.travelAdvisor.core.advice;

import com.travelAdvisor.core.model.WeatherTravelInformation;
import org.springframework.stereotype.Component;

/**
 * Created by shahaf.sages on 9/24/16.
 */

@Component
public class WeatherAdvice implements Advice<WeatherTravelInformation>{
    @Override
    public boolean calculate(WeatherTravelInformation travelInformation) {
        return travelInformation.getSteps().parallelStream().filter(s -> {
            double celsiusTemp = s.getWeather().getCelsiusTemp();
            return celsiusTemp > 20 && celsiusTemp < 30;
        }).count() > 0;
    }
}
