package com.travelAdvisor.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by shahaf.sages on 9/22/16.
 */
public class StepImpl implements Step {

    private long duration;

    @JsonProperty("end_location")
    private LatLng endLocation;

    @JsonProperty("html_instructions")
    private String htmlInstructions;

    private Weather weather;

    public StepImpl(long duration, LatLng endLocation, String htmlInstructions) {
        this.duration = duration;
        this.endLocation = endLocation;
        this.htmlInstructions = htmlInstructions;
    }

    protected StepImpl(Step another) {
        this.duration = another.getDuration();
        this.endLocation = another.getEndLocation() == null ? LatLng.createEmptyLatLang() : another.getEndLocation().clone();
        this.htmlInstructions = new String(another.getHtmlInstructions() == null ? "" : another.getHtmlInstructions());
        this.weather = another.getWeather() == null ? Weather.createEmptyWeather() : another.getWeather().clone();
    }

    public Step clone() {
        return new StepImpl(this);
    }


    @Override
    public long getDuration() {
        return duration;
    }


    @Override
    public LatLng getEndLocation() {
        return endLocation;
    }


    @Override
    public String getHtmlInstructions() {
        return htmlInstructions;
    }


    @Override
    public Weather getWeather() {
        return weather;
    }


    public void setWeather(Weather weather) {
        this.weather = weather.clone();
    }
}
