package com.travelAdvisor.core.decorator;

import com.travelAdvisor.core.advice.Advice;
import com.travelAdvisor.core.model.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

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
    public long getTotalDurationInMinutes(){
        return travelInformation.getTotalDurationInMinutes();
    }


    @Override
    public void addStep(Step step) {
        travelInformation.getSteps().add(step);
    }

    @Override
    public Collection<Step> getSteps(){return travelInformation.getSteps();}

    @Override
    public int getNumberOfSteps() {
        return travelInformation.getSteps().size();
    }

    @Override
    public String getOrigin() {
       return this.travelInformation.getOrigin();
    }

    @Override
    public String getDestination() {
        return this.travelInformation.getDestination();
    }

    public void calculateAdvice(Set<Advice> advices){

        boolean result = true;
        for(Advice advice: advices){
            result = result && advice.calculate(this);
        }
        travelInformation.setTravelAdvice(result? "Yes":"No");

    }
}
