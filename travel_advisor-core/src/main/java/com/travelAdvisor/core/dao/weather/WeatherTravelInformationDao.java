package com.travelAdvisor.core.dao.weather;

import com.travelAdvisor.core.model.WeatherTravelInformation;

/**
 * Created by shahaf.sages on 9/24/16.
 */
public interface WeatherTravelInformationDao {
    WeatherTravelInformation travel(final WeatherTravelInformation travelInformation);
}
