package com.travelAdvisor.core.model;

/**
 * Created by shahaf.sages on 9/21/16.
 */
public class LatLng {

    private double lat;
    private double lng;

    public LatLng(double lat, double lng) {
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
