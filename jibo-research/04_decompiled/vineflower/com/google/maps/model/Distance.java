package com.google.maps.model;

public class Distance {
   public String humanReadable;
   public long inMeters;

   @Override
   public String toString() {
      return this.humanReadable;
   }
}
