package com.travelAdvisor.core.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by myPc on 19/09/2016.
 */
public class TravelInformationImpl implements TravelInformation {

    private String origin;
    private String destination;
    private long totalDurationInMinutes;
    private long totalDistanceInMeters;
    private List<Step> steps = new ArrayList<Step>();
    private String travelAdvice;

    public TravelInformationImpl(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    protected TravelInformationImpl(TravelInformationImpl another) {
        this.origin = new String(another.getOrigin() == null ? "" : another.getOrigin());
        this.destination = new String(another.getDestination() == null ? "" : another.getDestination());
        this.totalDurationInMinutes = another.getTotalDurationInMinutes();
        this.totalDistanceInMeters = another.getTotalDistanceInMeters();
        this.steps = another.getSteps().parallelStream().map(step -> step == null ? Step.createEmtpyStep(): step.clone()).collect(Collectors.toList());
        this.travelAdvice = new String(another.getTravelAdvice() == null ? "" : another.getTravelAdvice());

    }


    public TravelInformation clone() {
        return new TravelInformationImpl(this);
    }

    @Override
    public String getOrigin() {
        return origin;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    public long getTotalDurationInMinutes() {
        return totalDurationInMinutes;
    }

    public void setTotalDurationInMinutes(long totalDurationInMinutes) {
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



    public String getTravelAdvice() {
        return travelAdvice;
    }

    public void setTravelAdvice(String travelAdvice) {
        this.travelAdvice = travelAdvice;
    }
}
