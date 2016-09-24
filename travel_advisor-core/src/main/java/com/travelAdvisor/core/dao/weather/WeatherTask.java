package com.travelAdvisor.core.dao.weather;

import com.travelAdvisor.core.model.Step;
import com.travelAdvisor.core.model.Weather;
import com.travelAdvisor.core.repository.weather.openweathermap.OpenWeatherMapRepository;
import com.travelAdvisor.core.repository.weather.openweathermap.model.WeatherResult;

/**
 * Created by shahaf.sages on 9/22/16.
 */
public class WeatherTask implements Runnable {
    private final static double KELVIN_TO_CELSIUS = 273.15;
    private Step step;
    private OpenWeatherMapRepository repository;
    private TemperatureConverter temperatureConverter;

    public WeatherTask(Step step, OpenWeatherMapRepository repository, TemperatureConverter temperatureConverter) {
        this.step = step;
        this.repository = repository;
        this.temperatureConverter = temperatureConverter;
    }

    @Override
    public void run() {
        WeatherResult travel = repository.travel(step.getEndLocation().getLat(), step.getEndLocation().getLng());
        step.setWeather(new Weather(temperatureConverter.convert(travel.main.temp), travel.weather[0].description));

    }


}
