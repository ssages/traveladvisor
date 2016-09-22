package com.travelAdvisor.core.model;

import java.util.List;

/**
 * Created by myPc on 19/09/2016.
 */
public class TravelInformation {

    private String origin;
    private String destination;
    private int totalDurationInMinutes;
    private long totalDistanceInMeters;
    private List<Step> steps;
    private String travelAdvice;

    public TravelInformation(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getTotalDurationInMinutes() {
        return totalDurationInMinutes;
    }

    public void setTotalDurationInMinutes(int totalDurationInMinutes) {
        this.totalDurationInMinutes = totalDurationInMinutes;
    }

    public long getTotalDistanceInMeters() {
        return totalDistanceInMeters;
    }

    public void setTotalDistanceInMeters(long totalDistanceInMeters) {
        this.totalDistanceInMeters = totalDistanceInMeters;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public String getTravelAdvice() {
        return travelAdvice;
    }

    public void setTravelAdvice(String travelAdvice) {
        this.travelAdvice = travelAdvice;
    }
}
