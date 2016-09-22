package com.travelAdvisor.core.model;

/**
 * Created by shahaf.sages on 9/22/16.
 */
public class TravelWeatherQueryImpl implements TravelWeatherQuery {

    private double lat;
    private double lng;

    public TravelWeatherQueryImpl(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}
