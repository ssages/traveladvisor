package com.travelAdvisor.core.repository.weather.openWeatherMap;

import com.travelAdvisor.core.model.TravelDirectionsQuery;
import com.travelAdvisor.core.model.TravelWeatherQuery;
import com.travelAdvisor.core.repository.weather.TravelWeatherRepository;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by shahaf.sages on 9/22/16.
 */
public class OpenWeatherMapRepository implements TravelWeatherRepository {

    private RestTemplate restTemplate = new RestTemplate();
    private final static String API_URL= "http://api.openweathermap.org/data/2.5/weather?lat=%d&lon=%d&APPID=bab446b75e3ba39c827dd577e333b8c7";


    @Override
    public Object travel(TravelWeatherQuery travelWeatherQuery) {
        return restTemplate.getForObject(String.format(API_URL, travelWeatherQuery.getLat(), travelWeatherQuery.getLng()), Map.class);
    }
}
