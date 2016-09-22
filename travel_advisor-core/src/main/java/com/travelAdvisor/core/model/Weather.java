package com.travelAdvisor.core.model;

/**
 * Created by shahaf.sages on 9/22/16.
 */
public class Weather {

    private double celsiusTemp;

    private String description;

    public Weather(double celsiusTemp, String description) {
        this.celsiusTemp = celsiusTemp;
        this.description = description;
    }

    public double getCelsiusTemp() {
        return celsiusTemp;
    }

    public String getDescription() {
        return description;
    }
}
