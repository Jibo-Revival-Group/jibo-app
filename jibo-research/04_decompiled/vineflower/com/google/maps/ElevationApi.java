package com.google.maps;

import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.internal.PolylineEncoding;
import com.google.maps.internal.StringJoin;
import com.google.maps.model.ElevationResult;
import com.google.maps.model.EncodedPolyline;
import com.google.maps.model.LatLng;

public class ElevationApi {
   private static final ApiConfig API_CONFIG = new ApiConfig("/maps/api/elevation/json");

   private ElevationApi() {
   }

   public static PendingResult<ElevationResult[]> getByPath(GeoApiContext var0, int var1, EncodedPolyline var2) {
      return var0.get(API_CONFIG, ElevationApi.MultiResponse.class, "samples", String.valueOf(var1), "path", "enc:" + var2.getEncodedPath());
   }

   public static PendingResult<ElevationResult[]> getByPath(GeoApiContext var0, int var1, LatLng... var2) {
      return var0.get(API_CONFIG, ElevationApi.MultiResponse.class, "samples", String.valueOf(var1), "path", shortestParam(var2));
   }

   public static PendingResult<ElevationResult> getByPoint(GeoApiContext var0, LatLng var1) {
      return var0.get(API_CONFIG, ElevationApi.SingularResponse.class, "locations", var1.toString());
   }

   public static PendingResult<ElevationResult[]> getByPoints(GeoApiContext var0, EncodedPolyline var1) {
      return var0.get(API_CONFIG, ElevationApi.MultiResponse.class, "locations", "enc:" + var1.getEncodedPath());
   }

   public static PendingResult<ElevationResult[]> getByPoints(GeoApiContext var0, LatLng... var1) {
      return var0.get(API_CONFIG, ElevationApi.MultiResponse.class, "locations", shortestParam(var1));
   }

   private static String shortestParam(LatLng[] var0) {
      String var1 = StringJoin.join('|', var0);
      String var2 = "enc:" + PolylineEncoding.encode(var0);
      if (var1.length() < var2.length()) {
         var2 = var1;
      }

      return var2;
   }

   private static class MultiResponse implements ApiResponse<ElevationResult[]> {
      public String errorMessage;
      public ElevationResult[] results;
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

      public ElevationResult[] getResult() {
         return this.results;
      }

      @Override
      public boolean successful() {
         return "OK".equals(this.status);
      }
   }

   private static class SingularResponse implements ApiResponse<ElevationResult> {
      public String errorMessage;
      public ElevationResult[] results;
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

      public ElevationResult getResult() {
         return this.results[0];
      }

      @Override
      public boolean successful() {
         return "OK".equals(this.status);
      }
   }
}
