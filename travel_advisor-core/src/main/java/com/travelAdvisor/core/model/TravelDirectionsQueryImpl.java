package com.travelAdvisor.core.model;

/**
 * Created by shahaf.sages on 9/22/16.
 */
public class TravelDirectionsQueryImpl implements TravelDirectionsQuery {

    private String origin;
    private String destination;


    public TravelDirectionsQueryImpl(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public String getOrigin() {
        return origin;
    }

    @Override
    public String getDestination() {
        return destination;
    }

}
