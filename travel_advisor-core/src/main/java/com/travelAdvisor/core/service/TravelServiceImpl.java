package com.travelAdvisor.core.service;

import com.travelAdvisor.core.dao.directions.GoogleMapsDirectionsDao;
import com.travelAdvisor.core.dao.weather.OpenWeatherDao;
import com.travelAdvisor.core.dao.TravelInformationDao;
import com.travelAdvisor.core.decorator.TravelInformationDecorator;
import com.travelAdvisor.core.model.TravelInformation;
import com.travelAdvisor.core.model.TravelInformationImpl;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shahaf.sages on 9/21/16.
 */
@Service
public class TravelServiceImpl implements TravelService {

    private Set<TravelInformationDao> daos;

    public TravelServiceImpl() {
        this.daos = new HashSet<TravelInformationDao>(2);
        daos.add(new GoogleMapsDirectionsDao());
        daos.add(new OpenWeatherDao());
    }

    public TravelInformation travel(String origin, String destination){
        TravelInformationDecorator travelInformationDecorator = new TravelInformationDecorator(new TravelInformationImpl(origin, destination));

        for(TravelInformationDao dao: daos){
                dao.travel(travelInformationDecorator);
        }

        return travelInformationDecorator.getTravelInformation();
    }


}
