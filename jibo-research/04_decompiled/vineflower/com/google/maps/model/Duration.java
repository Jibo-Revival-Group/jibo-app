package com.google.maps.model;

public class Duration {
   public String humanReadable;
   public long inSeconds;

   @Override
   public String toString() {
      return this.humanReadable;
   }
}
