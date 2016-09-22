package com.travelAdvisor.core.service;

import com.travelAdvisor.core.dao.directions.GoogleMapsDirectionsDao;
import com.travelAdvisor.core.dao.weather.OpenWeatherDao;
import com.travelAdvisor.core.dao.TravelInformationDao;
import com.travelAdvisor.core.model.TravelInformation;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shahaf.sages on 9/21/16.
 */
public class TravelServiceImpl implements TravelService {

    private Set<TravelInformationDao> daos;

    public TravelServiceImpl() {
        this.daos = new HashSet<TravelInformationDao>(2);
        daos.add(new GoogleMapsDirectionsDao());
        daos.add(new OpenWeatherDao());
    }

    public TravelInformation travel(String origin, String destination){
        TravelInformation travelInformation = new TravelInformation(origin, destination);

        for(TravelInformationDao dao: daos){
                dao.travel(travelInformation);
        }

        return travelInformation;
    }


}
