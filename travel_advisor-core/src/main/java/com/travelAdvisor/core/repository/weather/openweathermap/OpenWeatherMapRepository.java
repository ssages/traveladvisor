package com.travelAdvisor.core.repository.weather.openweathermap;

import com.travelAdvisor.core.repository.weather.openweathermap.model.WeatherResult;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 * Created by shahaf.sages on 9/22/16.
 */
@Repository
public class OpenWeatherMapRepository {

    private RestTemplate restTemplate = new RestTemplate();
    private final static String API_URL= "http://api.openweathermap.org/data/2.5/Weather?lat=%f&lon=%f&APPID=bab446b75e3ba39c827dd577e333b8c7";

    public WeatherResult travel(double lat, double lon) {
        return restTemplate.getForObject(String.format(API_URL, lat,lon), WeatherResult.class);
    }

}
