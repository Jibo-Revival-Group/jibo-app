package com.google.maps.model;

import com.google.maps.internal.PolylineEncoding;
import java.util.List;

public class EncodedPolyline {
   private final String points;

   public EncodedPolyline(String var1) {
      this.points = var1;
   }

   public EncodedPolyline(List<LatLng> var1) {
      this.points = PolylineEncoding.encode(var1);
   }

   public List<LatLng> decodePath() {
      return PolylineEncoding.decode(this.points);
   }

   public String getEncodedPath() {
      return this.points;
   }
}
