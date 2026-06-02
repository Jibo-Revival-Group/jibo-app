package com.google.maps.model;

import com.google.maps.internal.StringJoin;
import java.util.Locale;

public enum Unit implements StringJoin.UrlValue {
   IMPERIAL,
   METRIC;

   private static final Unit[] $VALUES = new Unit[]{Unit.METRIC, Unit.IMPERIAL};

   @Override
   public String toString() {
      return this.toUrlValue();
   }

   @Override
   public String toUrlValue() {
      return this.name().toLowerCase(Locale.ENGLISH);
   }
}
