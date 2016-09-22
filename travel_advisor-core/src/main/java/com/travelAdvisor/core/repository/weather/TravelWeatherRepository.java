package com.travelAdvisor.core.repository.weather;

import com.travelAdvisor.core.model.TravelWeatherQuery;

/**
 * Created by shahaf.sages on 9/21/16.
 */
public interface TravelWeatherRepository {

    Object travel(TravelWeatherQuery travelWeatherQuery);

}
