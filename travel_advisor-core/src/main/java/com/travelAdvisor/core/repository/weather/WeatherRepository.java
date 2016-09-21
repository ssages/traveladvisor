package com.travelAdvisor.core.repository.weather;

import com.travelAdvisor.core.repository.weather.TravelWeatherRepository;

/**
 * Created by shahaf.sages on 9/21/16.
 */
public class WeatherRepository implements TravelWeatherRepository {
    @Override
    public String travel(String origin, String destination) {
        return String.format("WeatherRepository, from %s to %s", origin, destination);
    }
}
