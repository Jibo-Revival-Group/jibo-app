package com.google.maps;

import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiResponse;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

public class GeocodingApi {
   private GeocodingApi() {
   }

   public static GeocodingApiRequest geocode(GeoApiContext var0, String var1) {
      GeocodingApiRequest var2 = new GeocodingApiRequest(var0);
      var2.address(var1);
      return var2;
   }

   public static GeocodingApiRequest newRequest(GeoApiContext var0) {
      return new GeocodingApiRequest(var0);
   }

   public static GeocodingApiRequest reverseGeocode(GeoApiContext var0, LatLng var1) {
      GeocodingApiRequest var2 = new GeocodingApiRequest(var0);
      var2.latlng(var1);
      return var2;
   }

   static class Response implements ApiResponse<GeocodingResult[]> {
      public String errorMessage;
      public GeocodingResult[] results;
      public String status;

      @Override
      public ApiException getError() {
         ApiException var1;
         if (this.successful()) {
            var1 = null;
         } else {
            var1 = ApiException.from(this.status, this.errorMessage);
         }

         return var1;
      }

      public GeocodingResult[] getResult() {
         return this.results;
      }

      @Override
      public boolean successful() {
         boolean var1;
         if (!"OK".equals(this.status) && !"ZERO_RESULTS".equals(this.status)) {
            var1 = false;
         } else {
            var1 = true;
         }

         return var1;
      }
   }
}
