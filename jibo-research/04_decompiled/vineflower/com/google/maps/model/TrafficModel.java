package com.google.maps.model;

import com.google.maps.internal.StringJoin;
import java.util.Locale;

public enum TrafficModel implements StringJoin.UrlValue {
   BEST_GUESS,
   OPTIMISTIC,
   PESSIMISTIC;

   private static final TrafficModel[] $VALUES = new TrafficModel[]{TrafficModel.BEST_GUESS, TrafficModel.OPTIMISTIC, TrafficModel.PESSIMISTIC};

   @Override
   public String toString() {
      return this.name().toLowerCase(Locale.ENGLISH);
   }

   @Override
   public String toUrlValue() {
      return this.toString();
   }
}
