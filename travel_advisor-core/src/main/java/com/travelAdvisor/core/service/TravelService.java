package com.travelAdvisor.core.service;

import com.travelAdvisor.core.domain.TravelInformation;
import com.travelAdvisor.core.repository.TravelRepository;
import com.travelAdvisor.core.repository.directions.GoogleMapsDirectionsRepository;
import com.travelAdvisor.core.repository.weather.WeatherRepository;

import java.util.LinkedHashSet;
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
        StringBuffer data = new StringBuffer();
        for(TravelRepository r: repositories ){
            data.append(r.travel(origin, destination)).append("|");
        }
        return new TravelInformation(data.toString());

    }
}
