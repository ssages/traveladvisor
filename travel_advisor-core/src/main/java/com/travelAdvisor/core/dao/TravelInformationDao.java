package com.travelAdvisor.core.dao;

import com.travelAdvisor.core.model.TravelInformation;

/**
 * Created by shahaf.sages on 9/22/16.
 */
public interface TravelInformationDao {


    TravelInformation travel(final TravelInformation travelInformation);
}
