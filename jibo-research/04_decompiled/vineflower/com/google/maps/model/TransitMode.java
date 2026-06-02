package com.google.maps.model;

import com.google.maps.internal.StringJoin;
import java.util.Locale;

public enum TransitMode implements StringJoin.UrlValue {
   BUS,
   RAIL,
   SUBWAY,
   TRAIN,
   TRAM;

   private static final TransitMode[] $VALUES = new TransitMode[]{TransitMode.BUS, TransitMode.SUBWAY, TransitMode.TRAIN, TransitMode.TRAM, TransitMode.RAIL};

   @Override
   public String toString() {
      return this.name().toLowerCase(Locale.ENGLISH);
   }

   @Override
   public String toUrlValue() {
      return this.name().toLowerCase(Locale.ENGLISH);
   }
}
