package com.travelAdvisor.core.dao.directions;

import com.travelAdvisor.core.dao.TravelInformationDao;
import com.travelAdvisor.core.model.*;
import com.travelAdvisor.core.repository.directions.google.GoogleMapsDirectionsRepository;
import com.travelAdvisor.core.repository.directions.google.model.DirectionsResult;
import com.travelAdvisor.core.repository.directions.google.model.DirectionsStep;

/**
 * Created by shahaf.sages on 9/22/16.
 */
public class GoogleMapsDirectionsDao implements TravelInformationDao<DirectionsTravelInformation> {

    private GoogleMapsDirectionsRepository repository = new GoogleMapsDirectionsRepository();


    @Override
    public DirectionsTravelInformation travel(final DirectionsTravelInformation travelInformation) {
        DirectionsResult directionsResult = repository.travel(travelInformation.getOrigin(), travelInformation.getDestination());

        if(directionsResult.routes.length  < 1){
            travelInformation.addStep(new StepImpl(0, new LatLng(0, 0), "Route not found!"));
            return travelInformation;
        }


        //assuming only one leg
        for(DirectionsStep step: directionsResult.routes[0].legs[0].steps){
            travelInformation.incrementTotalDistanceInMeters(step.distance.value);
            travelInformation.incrementTotalDurationInMinutes(step.duration.value);
            travelInformation.addStep(new StepImpl(step.duration.value, new LatLng(step.endLocation.lat, step.endLocation.lng), step.htmlInstructions));
        }

        return travelInformation;
    }
}
