package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class GeoPoint extends GenericJson {
   @Key
   private Double altitude;
   @Key
   private Double latitude;
   @Key
   private Double longitude;

   public GeoPoint clone() {
      return (GeoPoint)super.clone();
   }

   public Double getAltitude() {
      return this.altitude;
   }

   public Double getLatitude() {
      return this.latitude;
   }

   public Double getLongitude() {
      return this.longitude;
   }

   public GeoPoint set(String var1, Object var2) {
      return (GeoPoint)super.set(var1, var2);
   }

   public GeoPoint setAltitude(Double var1) {
      this.altitude = var1;
      return this;
   }

   public GeoPoint setLatitude(Double var1) {
      this.latitude = var1;
      return this;
   }

   public GeoPoint setLongitude(Double var1) {
      this.longitude = var1;
      return this;
   }
}
