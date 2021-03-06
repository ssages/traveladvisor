package com.travelAdvisor.core.model;

/**
 * Created by shahaf.sages on 9/22/16.
 */
public class Weather {

    private static final String NO_INFO = "No information";
    private double celsiusTemp;

    private String description;

    public Weather(double celsiusTemp, String description) {
        this.celsiusTemp = celsiusTemp;
        this.description = description;
    }

    protected Weather(Weather another){
        this.celsiusTemp = another.getCelsiusTemp();
        this.description = new String(another.getDescription() == null ? "" : another.getDescription());
    }

    public Weather clone(){
        return new Weather(this);
    }

    public static Weather createEmptyWeather(){
        return new Weather(0.0, NO_INFO);
    }

    public double getCelsiusTemp() {
        return celsiusTemp;
    }

    public String getDescription() {
        return description;
    }
}
