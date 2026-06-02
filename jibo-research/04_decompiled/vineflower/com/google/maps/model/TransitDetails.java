package com.google.maps.model;

import org.joda.time.DateTime;

public class TransitDetails {
   public StopDetails arrivalStop;
   public DateTime arrivalTime;
   public StopDetails departureStop;
   public DateTime departureTime;
   public String headsign;
   public long headway;
   public TransitLine line;
   public int numStops;
}
