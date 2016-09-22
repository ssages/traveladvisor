package com.travelAdvisor.core.repository.directions.google.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by shahaf.sages on 9/21/16.
 */
public class DirectionsStep {

  @JsonProperty("html_instructions")
  public String htmlInstructions;

  public Distance distance;

  public Duration duration;

  @JsonProperty("start_location")
  public LatLng startLocation;

  @JsonProperty("end_location")
  public LatLng endLocation;

}
