package com.travelAdvisor.core.dao.weather;

import com.travelAdvisor.core.model.Step;
import com.travelAdvisor.core.model.WeatherTravelInformation;
import com.travelAdvisor.core.repository.weather.openweathermap.OpenWeatherMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shahaf.sages on 9/22/16.
 */
@Service
@Order(value=2)
public class OpenWeatherDao implements WeatherTravelInformationDao {

    private final static double KELVIN_TO_CELSIUS = 273.15;

    @Autowired
    private OpenWeatherMapRepository repository;

    private ExecutorService es = Executors.newCachedThreadPool();

    @Override
    public WeatherTravelInformation travel(final WeatherTravelInformation travelInformation) {


        List<Callable<Object>> tasks = new ArrayList<Callable<Object>>();

        for(Step step: travelInformation.getSteps()){
            tasks.add(Executors.callable(new WeatherTask(step, repository, kelvinToCelsius())));
        }

        try {
            es.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return travelInformation;
    }

    private TemperatureConverter kelvinToCelsius(){
        return temp -> (int)(temp - KELVIN_TO_CELSIUS);
    }


}
