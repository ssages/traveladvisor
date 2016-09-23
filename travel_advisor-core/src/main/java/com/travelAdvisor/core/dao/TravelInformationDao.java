package com.travelAdvisor.core.dao;

import com.travelAdvisor.core.model.TravelInformation;

/**
 * Created by shahaf.sages on 9/22/16.
 */
public interface TravelInformationDao<T extends TravelInformation> {

     T travel(final T travelInformation);
}
