package com.travelAdvisor.core.dao.directions;

import com.travelAdvisor.core.model.*;
import com.travelAdvisor.core.repository.directions.google.GoogleMapsDirectionsRepository;
import com.travelAdvisor.core.repository.directions.google.model.DirectionsResult;
import com.travelAdvisor.core.repository.directions.google.model.DirectionsStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * Created by shahaf.sages on 9/22/16.
 */
@Service
@Order(value=1)
public class GoogleMapsDirectionsDao implements DirectionsTravelInformationDao {

    @Autowired
    private GoogleMapsDirectionsRepository repository;


    @Override
    public DirectionsTravelInformation travel(final DirectionsTravelInformation travelInformation) {
        DirectionsResult directionsResult = repository.travel(travelInformation.getOrigin(), travelInformation.getDestination());

        if(directionsResult.routes.length  < 1){
            return travelInformation;
        }


        //assuming only one leg
        for(DirectionsStep step: directionsResult.routes[0].legs[0].steps){
            travelInformation.incrementTotalDistanceInMeters(step.distance.value);
            travelInformation.incrementTotalDurationInMinutes(step.duration.value / 60);
            travelInformation.addStep(new StepImpl(step.duration.value, new LatLng(step.endLocation.lat, step.endLocation.lng), step.htmlInstructions));
        }

        return travelInformation;
    }
}
