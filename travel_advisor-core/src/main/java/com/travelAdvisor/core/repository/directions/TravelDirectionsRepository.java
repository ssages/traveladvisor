package com.travelAdvisor.core.repository.directions;

import com.travelAdvisor.core.model.TravelDirectionsQuery;

/**
 * Created by shahaf.sages on 9/21/16.
 */
public interface TravelDirectionsRepository {

    public Object travel(TravelDirectionsQuery travelDirectionsQuery);
}
