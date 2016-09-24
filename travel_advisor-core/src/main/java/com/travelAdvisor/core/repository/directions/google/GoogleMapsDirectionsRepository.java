package com.travelAdvisor.core.repository.directions.google;


import com.travelAdvisor.core.repository.directions.google.model.DirectionsResult;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 * Created by shahaf.sages on 9/21/16.
 */
@Repository
public class GoogleMapsDirectionsRepository{

    private RestTemplate restTemplate = new RestTemplate();
    private final static String API_URL = "https://maps.googleapis.com/maps/api/directions/json?key=AIzaSyALaSwI-8n_PV-emGvj3dmKggbcL_wfsVY&origin=%s&destination=%s";

    public DirectionsResult travel(String origin, String destination) {
        return restTemplate.getForObject(String.format(API_URL, origin, destination), DirectionsResult.class);
    }
}
