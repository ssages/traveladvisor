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

    protected LatLng(LatLng another){
        this.lat = another.getLat();
        this.lng = another.getLng();
    }

    protected LatLng clone(){
        return new LatLng(this);
    }

    public static LatLng createEmptyLatLang(){
        return new LatLng(0.0, 0.0);
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}
