package com.travelAdvisor.core.repository.directions.google.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

/**
 * Created by shahaf.sages on 9/21/16.
 */

public class DirectionsLeg {

  public DirectionsStep[] steps;

  public Distance distance;

  public Duration duration;

  @JsonProperty("start_location")
  public LatLng startLocation;

  @JsonProperty("end_location")
  public LatLng endLocation;

  @JsonProperty("start_address")
  public String startAddress;

  @JsonProperty("end_address")
  public String endAddress;

}
