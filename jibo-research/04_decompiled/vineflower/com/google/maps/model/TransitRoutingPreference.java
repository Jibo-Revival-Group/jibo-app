package com.google.maps.model;

import com.google.maps.internal.StringJoin;
import java.util.Locale;

public enum TransitRoutingPreference implements StringJoin.UrlValue {
   FEWER_TRANSFERS,
   LESS_WALKING;

   private static final TransitRoutingPreference[] $VALUES = new TransitRoutingPreference[]{
      TransitRoutingPreference.LESS_WALKING, TransitRoutingPreference.FEWER_TRANSFERS
   };

   @Override
   public String toString() {
      return this.name().toLowerCase(Locale.ENGLISH);
   }

   @Override
   public String toUrlValue() {
      return this.name().toLowerCase(Locale.ENGLISH);
   }
}
