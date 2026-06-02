package com.google.maps.model;

import com.google.maps.internal.StringJoin;

public class ComponentFilter implements StringJoin.UrlValue {
   public final String component;
   public final String value;

   ComponentFilter(String var1, String var2) {
      this.component = var1;
      this.value = var2;
   }

   public static ComponentFilter administrativeArea(String var0) {
      return new ComponentFilter("administrative_area", var0);
   }

   public static ComponentFilter country(String var0) {
      return new ComponentFilter("country", var0);
   }

   public static ComponentFilter locality(String var0) {
      return new ComponentFilter("locality", var0);
   }

   public static ComponentFilter postalCode(String var0) {
      return new ComponentFilter("postal_code", var0);
   }

   public static ComponentFilter route(String var0) {
      return new ComponentFilter("route", var0);
   }

   @Override
   public String toString() {
      return this.toUrlValue();
   }

   @Override
   public String toUrlValue() {
      return StringJoin.join(':', this.component, this.value);
   }
}
