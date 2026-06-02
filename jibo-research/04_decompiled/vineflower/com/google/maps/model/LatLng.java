package com.google.maps.model;

import com.google.maps.internal.StringJoin;
import java.util.Locale;

public class LatLng implements StringJoin.UrlValue {
   public double lat;
   public double lng;

   public LatLng() {
   }

   public LatLng(double var1, double var3) {
      this.lat = var1;
      this.lng = var3;
   }

   @Override
   public String toString() {
      return this.toUrlValue();
   }

   @Override
   public String toUrlValue() {
      return String.format(Locale.ENGLISH, "%.8f,%.8f", this.lat, this.lng);
   }
}
