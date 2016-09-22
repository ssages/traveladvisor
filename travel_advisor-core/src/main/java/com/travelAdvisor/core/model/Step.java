package com.travelAdvisor.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by shahaf.sages on 9/22/16.
 */
public class Step {

    private long duration;

    @JsonProperty("end_location")
    private LatLng endLocation;

    @JsonProperty("html_instructions")
    private String htmlInstructions;

    private Weather weather;

    public Step(long duration, LatLng endLocation, String htmlInstructions) {
        this.duration = duration;
        this.endLocation = endLocation;
        this.htmlInstructions = htmlInstructions;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public LatLng getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(LatLng endLocation) {
        this.endLocation = endLocation;
    }

    public String getHtmlInstructions() {
        return htmlInstructions;
    }

    public void setHtmlInstructions(String htmlInstructions) {
        this.htmlInstructions = htmlInstructions;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }
}
