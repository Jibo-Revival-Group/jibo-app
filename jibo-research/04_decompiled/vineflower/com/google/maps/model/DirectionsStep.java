package com.google.maps.model;

public class DirectionsStep {
   public Distance distance;
   public Duration duration;
   public LatLng endLocation;
   public String htmlInstructions;
   @Deprecated
   public String maneuver;
   public EncodedPolyline polyline;
   public LatLng startLocation;
   public DirectionsStep[] steps;
   public TransitDetails transitDetails;
   public TravelMode travelMode;
}
