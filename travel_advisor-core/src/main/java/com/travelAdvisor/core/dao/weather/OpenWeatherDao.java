package com.travelAdvisor.core.dao.weather;

import com.travelAdvisor.core.dao.TravelInformationDao;
import com.travelAdvisor.core.decorator.TravelInformationDecorator;
import com.travelAdvisor.core.model.Step;
import com.travelAdvisor.core.model.StepImpl;
import com.travelAdvisor.core.model.TravelInformation;
import com.travelAdvisor.core.model.WeatherTravelInformation;
import com.travelAdvisor.core.repository.weather.openweathermap.OpenWeatherMapRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shahaf.sages on 9/22/16.
 */
public class OpenWeatherDao implements TravelInformationDao<WeatherTravelInformation> {

    private OpenWeatherMapRepository repository = new OpenWeatherMapRepository();
    private final static double KELVIN_TO_CELSIUS = 273.15;
    private ExecutorService es = Executors.newCachedThreadPool();

    @Override
    public WeatherTravelInformation travel(final WeatherTravelInformation travelInformation) {


        List<Callable<Object>> tasks = new ArrayList<Callable<Object>>();

        Iterator<Step> stepsIterator = travelInformation.getStepsIterator();
        while(stepsIterator.hasNext()){
            tasks.add(Executors.callable(new WeatherTask(stepsIterator.next(), repository, kelvinToCelsius())));
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
