package com.google.maps.model;

import org.joda.time.DateTime;

public class DirectionsLeg {
   public DateTime arrivalTime;
   public DateTime departureTime;
   public Distance distance;
   public Duration duration;
   public Duration durationInTraffic;
   public String endAddress;
   public LatLng endLocation;
   public String startAddress;
   public LatLng startLocation;
   public DirectionsStep[] steps;
}
