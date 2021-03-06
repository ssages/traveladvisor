package com.travelAdvisor.core.model;

/**
 * Created by shahaf.sages on 9/24/16.
 */
public interface Step {
    String getDuration();

    LatLng getEndLocation();

    String getHtmlInstructions();

    Weather getWeather();

    void setWeather(Weather weather);

    Step clone();

    static Step createEmtpyStep(){
        return new StepImpl("", LatLng.createEmptyLatLang(), "");
    };
}
