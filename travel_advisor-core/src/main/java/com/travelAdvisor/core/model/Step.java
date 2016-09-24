package com.travelAdvisor.core.model;

/**
 * Created by shahaf.sages on 9/24/16.
 */
public interface Step {
    long getDuration();

    LatLng getEndLocation();

    String getHtmlInstructions();

    Weather getWeather();

    void setWeather(Weather weather);

    Step clone();

    public static Step createEmtpyStep(){
        return new StepImpl(0, LatLng.createEmptyLatLang(), "");
    };
}
