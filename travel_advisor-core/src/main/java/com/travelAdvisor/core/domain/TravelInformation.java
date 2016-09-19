package com.travelAdvisor.core.domain;

/**
 * Created by myPc on 19/09/2016.
 */
public class TravelInformation {

    private String origin;
    private String destination;

    public TravelInformation(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TravelInformation{");
        sb.append("origin='").append(origin).append('\'');
        sb.append(", destination='").append(destination).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }
}
