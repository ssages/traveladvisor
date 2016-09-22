package com.travelAdvisor.core.dao;

import com.travelAdvisor.core.model.Step;
import com.travelAdvisor.core.model.TravelInformation;
import com.travelAdvisor.core.model.Weather;
import com.travelAdvisor.core.repository.weather.openweathermap.model.WeatherResult;
import com.travelAdvisor.core.repository.weather.openweathermap.OpenWeatherMapRepository;

import java.util.List;

/**
 * Created by shahaf.sages on 9/22/16.
 */
public class OpenWeatherDao implements TravelInformationDao {

    private OpenWeatherMapRepository repository = new OpenWeatherMapRepository();
    private final static double KELVIN_TO_CELSIUS = 273.15;

    @Override
    public TravelInformation travel(final TravelInformation travelInformation) {
        List<Step> steps = travelInformation.getSteps();
        for(Step step: steps){
            WeatherResult travel = repository.travel(step.getEndLocation().getLat(), step.getEndLocation().getLng());
            step.setWeather(new Weather(kelvinToCelsius(travel.main.temp), travel.weather[0].description));

        }

        return travelInformation;
    }

    private double kelvinToCelsius(double temp){
        return temp - KELVIN_TO_CELSIUS;
    }
}
