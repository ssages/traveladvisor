package com.travelAdvisor.core.repository;

import com.travelAdvisor.core.repository.directions.google.model.DirectionsResult;

/**
 * Created by shahaf.sages on 9/21/16.
 */
public interface TravelRepository {

    public Object travel(String origin, String destination);

}
