package com.google.maps.model;

import com.google.maps.internal.StringJoin;

public enum PriceLevel implements StringJoin.UrlValue {
   EXPENSIVE("3"),
   FREE("0"),
   INEXPENSIVE("1"),
   MODERATE("2"),
   UNKNOWN("Unknown"),
   VERY_EXPENSIVE("4");

   private static final PriceLevel[] $VALUES = new PriceLevel[]{
      PriceLevel.FREE, PriceLevel.INEXPENSIVE, PriceLevel.MODERATE, PriceLevel.EXPENSIVE, PriceLevel.VERY_EXPENSIVE, PriceLevel.UNKNOWN
   };
   private final String priceLevel;

   PriceLevel(String var3) {
      this.priceLevel = var3;
   }

   @Override
   public String toString() {
      return this.priceLevel;
   }

   @Override
   public String toUrlValue() {
      if (this == UNKNOWN) {
         throw new UnsupportedOperationException("Shouldn't use PriceLevel.UNKNOWN in a request.");
      } else {
         return this.priceLevel;
      }
   }
}
