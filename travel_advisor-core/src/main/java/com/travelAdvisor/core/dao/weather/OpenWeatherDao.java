package com.travelAdvisor.core.dao.weather;

import com.travelAdvisor.core.dao.TravelInformationDao;
import com.travelAdvisor.core.model.Step;
import com.travelAdvisor.core.model.TravelInformation;
import com.travelAdvisor.core.repository.weather.openweathermap.OpenWeatherMapRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shahaf.sages on 9/22/16.
 */
public class OpenWeatherDao implements TravelInformationDao {

    private OpenWeatherMapRepository repository = new OpenWeatherMapRepository();
    private final static double KELVIN_TO_CELSIUS = 273.15;
    private ExecutorService es = Executors.newCachedThreadPool();

    @Override
    public TravelInformation travel(final TravelInformation travelInformation) {
        List<Step> steps = travelInformation.getSteps();

        List<Callable<Object>> tasks = new ArrayList<Callable<Object>>(steps.size());

        for(Step step: steps){
            tasks.add(Executors.callable(new WeatherTask(step, repository, kelvinToCelsius())));
        }

        try {
            es.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        travelInformation.setSteps(steps);

        return travelInformation;
    }

    private TemperatureConverter kelvinToCelsius(){
        return temp -> temp - KELVIN_TO_CELSIUS;
    }


}
