package com.google.maps.model;

import com.google.maps.internal.StringJoin;

public enum LocationType implements StringJoin.UrlValue {
   APPROXIMATE,
   GEOMETRIC_CENTER,
   RANGE_INTERPOLATED,
   ROOFTOP,
   UNKNOWN;

   private static final LocationType[] $VALUES = new LocationType[]{
      LocationType.ROOFTOP, LocationType.RANGE_INTERPOLATED, LocationType.GEOMETRIC_CENTER, LocationType.APPROXIMATE, LocationType.UNKNOWN
   };

   @Override
   public String toUrlValue() {
      if (this == UNKNOWN) {
         throw new UnsupportedOperationException("Shouldn't use LocationType.UNKNOWN in a request.");
      } else {
         return this.name();
      }
   }
}
