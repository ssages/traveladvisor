package com.travelAdvisor.core.repository.directions.google;


import com.travelAdvisor.core.model.TravelDirectionsQuery;
import com.travelAdvisor.core.repository.directions.TravelDirectionsRepository;

import com.travelAdvisor.core.repository.directions.google.model.DirectionsResult;
import org.springframework.web.client.RestTemplate;

/**
 * Created by shahaf.sages on 9/21/16.
 */
public class GoogleMapsDirectionsRepository implements TravelDirectionsRepository {

    private RestTemplate restTemplate = new RestTemplate();
    private final static String API_URL = "https://maps.googleapis.com/maps/api/directions/json?key=AIzaSyALaSwI-8n_PV-emGvj3dmKggbcL_wfsVY&origin=%s&destination=%s";

    @Override
    public Object travel(TravelDirectionsQuery travelDirectionsQuery) {
        return restTemplate.getForObject(String.format(API_URL, travelDirectionsQuery.getOrigin(), travelDirectionsQuery.getDestination()), DirectionsResult.class);
    }
}
