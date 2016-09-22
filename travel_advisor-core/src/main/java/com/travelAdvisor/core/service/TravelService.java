package com.travelAdvisor.core.service;

import com.travelAdvisor.core.model.TravelDirectionsQueryImpl;
import com.travelAdvisor.core.model.TravelInformation;
import com.travelAdvisor.core.model.TravelWeatherQuery;
import com.travelAdvisor.core.repository.directions.TravelDirectionsRepository;
import com.travelAdvisor.core.repository.directions.google.GoogleMapsDirectionsRepository;
import com.travelAdvisor.core.repository.weather.TravelWeatherRepository;
import com.travelAdvisor.core.repository.weather.openWeatherMap.OpenWeatherMapRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shahaf.sages on 9/21/16.
 */
public class TravelService {

    private TravelDirectionsRepository directions = new GoogleMapsDirectionsRepository();
    private TravelWeatherRepository weather = new OpenWeatherMapRepository();

    public TravelService(){

    }

    public TravelInformation travel(String origin, String destination){
        List<Object> data = new ArrayList<Object>();
        data.add(directions.travel(new TravelDirectionsQueryImpl(origin,destination)));
        return new TravelInformation(data);

    }
}
