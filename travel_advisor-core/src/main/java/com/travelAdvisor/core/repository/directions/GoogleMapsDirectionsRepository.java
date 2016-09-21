package com.travelAdvisor.core.repository.directions;

/**
 * Created by shahaf.sages on 9/21/16.
 */
public class GoogleMapsDirectionsRepository implements TravelDirectionsRepository {

    @Override
    public String travel(String origin, String destination) {
        return String.format("GoogleMapsDirectionsRepository, from %s to %s", origin, destination);
    }
}
