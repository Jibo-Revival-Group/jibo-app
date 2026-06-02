package com.google.maps.model;

import com.google.maps.internal.StringJoin;
import java.util.Locale;

public enum TravelMode implements StringJoin.UrlValue {
   BICYCLING,
   DRIVING,
   TRANSIT,
   UNKNOWN,
   WALKING;

   private static final TravelMode[] $VALUES = new TravelMode[]{
      TravelMode.DRIVING, TravelMode.WALKING, TravelMode.BICYCLING, TravelMode.TRANSIT, TravelMode.UNKNOWN
   };

   @Override
   public String toString() {
      return this.name().toLowerCase(Locale.ENGLISH);
   }

   @Override
   public String toUrlValue() {
      if (this == UNKNOWN) {
         throw new UnsupportedOperationException("Shouldn't use TravelMode.UNKNOWN in a request.");
      } else {
         return this.name().toLowerCase(Locale.ENGLISH);
      }
   }
}
