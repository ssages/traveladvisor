package com.travelAdvisor.core.service;

import com.travelAdvisor.core.model.TravelInformation;

/**
 * Created by shahaf.sages on 9/22/16.
 */
public interface TravelService {

    TravelInformation travel(String origin, String destination);
}
