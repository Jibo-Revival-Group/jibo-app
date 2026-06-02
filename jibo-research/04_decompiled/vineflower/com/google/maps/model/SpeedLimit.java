package com.google.maps.model;

public class SpeedLimit {
   public String placeId;
   public double speedLimit;

   public long speedLimitMph() {
      return Math.round(this.speedLimit * 0.621371);
   }
}
