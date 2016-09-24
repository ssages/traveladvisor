package com.travelAdvisor.core.decorator;

import com.travelAdvisor.core.model.*;

import java.util.Iterator;

/**
 * Created by shahaf.sages on 9/23/16.
 */
public class TravelInformationDecoratorImpl implements TravelInformationDecorator {

    private final TravelInformationImpl travelInformation;

    public TravelInformationDecoratorImpl(TravelInformationImpl travelInformation) {
        this.travelInformation = travelInformation;
    }

    @Override
    public TravelInformation getTravelInformation(){
        return this.travelInformation.clone();
    }

    @Override
    public void incrementTotalDurationInMinutes(long value) {
        travelInformation.setTotalDurationInMinutes(travelInformation.getTotalDurationInMinutes() + value);
    }

    @Override
    public void incrementTotalDistanceInMeters(long value) {
        travelInformation.setTotalDistanceInMeters(travelInformation.getTotalDistanceInMeters() + value);

    }

    @Override
    public void addStep(Step step) {
        travelInformation.getSteps().add(step);
    }

    @Override
    public Iterator<Step> getStepsIterator(){
        return travelInformation.getSteps().iterator();
    }

    @Override
    public double getAverageTemperature() {
        double sumTemperature = 0.0;
        int numberOfSteps = 1;

        Iterator<Step> stepsIterator = getStepsIterator();

        while(stepsIterator.hasNext()){
            sumTemperature += stepsIterator.next().getWeather().getCelsiusTemp();
            numberOfSteps++;
        }

        int avgTemperature = (int)sumTemperature/numberOfSteps;

        return  avgTemperature;
    }

    @Override
    public String getOrigin() {
       return this.travelInformation.getOrigin();
    }

    @Override
    public String getDestination() {
        return this.travelInformation.getDestination();
    }

    @Override
    public void calculateAdvice(){
        boolean advice = false;
        long totalDurationInHours = travelInformation.getTotalDistanceInMeters()/60;
        advice = totalDurationInHours < 3 && getAverageTemperature() > 20 && getAverageTemperature() < 30;
        travelInformation.setTravelAdvice(advice ? "Yes":"No");
    }
}
