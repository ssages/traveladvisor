package com.travelAdvisor.core.service;

import com.travelAdvisor.core.advice.Advice;
import com.travelAdvisor.core.dao.directions.DirectionsTravelInformationDao;
import com.travelAdvisor.core.dao.weather.WeatherTravelInformationDao;
import com.travelAdvisor.core.decorator.TravelInformationDecorator;
import com.travelAdvisor.core.decorator.TravelInformationDecoratorImpl;
import com.travelAdvisor.core.model.TravelInformation;
import com.travelAdvisor.core.model.TravelInformationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by shahaf.sages on 9/21/16.
 */
@Service
public class TravelServiceImpl implements TravelService {

    @Autowired
    private DirectionsTravelInformationDao directions;

    @Autowired
    private WeatherTravelInformationDao weather;

    @Autowired
    Set<Advice> advices;


    public TravelInformation travel(String origin, String destination){
        TravelInformationDecorator travelInformationDecorator = new TravelInformationDecoratorImpl(new TravelInformationImpl(origin, destination));
        directions.travel(travelInformationDecorator);
         weather.travel(travelInformationDecorator);
        travelInformationDecorator.calculateAdvice(advices);
        return travelInformationDecorator.getTravelInformation();
    }


}
