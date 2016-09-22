package com.travelAdvisor.core.service;

import com.travelAdvisor.core.model.TravelInformation;
import com.travelAdvisor.core.repository.TravelRepository;
import com.travelAdvisor.core.repository.directions.google.GoogleMapsDirectionsRepository;
import com.travelAdvisor.core.repository.weather.WeatherRepository;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by shahaf.sages on 9/21/16.
 */
public class TravelService {

    Set<TravelRepository> repositories;

    public TravelService(){
        this.repositories = new LinkedHashSet<TravelRepository>(2);
        this.repositories.add(new GoogleMapsDirectionsRepository());
        this.repositories.add(new WeatherRepository());

    }


    public TravelInformation travel(String origin, String destination){
        List<Object> data = new ArrayList<Object>(repositories.size());
        for(TravelRepository r: repositories ){
            data.add(r.travel(origin, destination));
        }
        return new TravelInformation(data);

    }
}
