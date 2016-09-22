package com.travelAdvisor.core.dao;

import com.travelAdvisor.core.model.LatLng;
import com.travelAdvisor.core.model.Step;
import com.travelAdvisor.core.model.TravelInformation;
import com.travelAdvisor.core.repository.directions.google.GoogleMapsDirectionsRepository;
import com.travelAdvisor.core.repository.directions.google.model.DirectionsLeg;
import com.travelAdvisor.core.repository.directions.google.model.DirectionsResult;
import com.travelAdvisor.core.repository.directions.google.model.DirectionsRoute;
import com.travelAdvisor.core.repository.directions.google.model.DirectionsStep;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shahaf.sages on 9/22/16.
 */
public class GoogleMapsDirectionsDao implements TravelInformationDao{

    private GoogleMapsDirectionsRepository repository = new GoogleMapsDirectionsRepository();


    @Override
    public TravelInformation travel(final TravelInformation travelInformation) {
        DirectionsResult directionsResult = repository.travel(travelInformation.getOrigin(), travelInformation.getDestination());

        List<Step> steps = new ArrayList<Step>();
        int totalDurationInMinutes = -1;
        long totalDistanceInMeters = -1;

        //assuming only one leg
        for(DirectionsStep step: directionsResult.routes[0].legs[0].steps){
            totalDistanceInMeters+= step.duration.value;
            totalDurationInMinutes+= step.distance.value;
            steps.add(new Step(step.duration.value, new LatLng(step.endLocation.lat, step.endLocation.lng), step.htmlInstructions));
        }

        travelInformation.setSteps(steps);
        travelInformation.setTotalDurationInMinutes(totalDurationInMinutes);
        travelInformation.setTotalDistanceInMeters(totalDistanceInMeters);

        return travelInformation;
    }
}
