package com.google.maps;

import com.google.gson.FieldNamingPolicy;
import com.google.maps.errors.ApiError;
import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.internal.StringJoin;
import com.google.maps.model.LatLng;
import com.google.maps.model.SnappedPoint;
import com.google.maps.model.SnappedSpeedLimitResponse;
import com.google.maps.model.SpeedLimit;

public class RoadsApi {
   static final String API_BASE_URL = "https://roads.googleapis.com";
   static final ApiConfig NEAREST_ROADS_API_CONFIG = new ApiConfig("/v1/nearestRoads")
      .hostName("https://roads.googleapis.com")
      .supportsClientId(false)
      .fieldNamingPolicy(FieldNamingPolicy.IDENTITY);
   static final ApiConfig SNAP_TO_ROADS_API_CONFIG = new ApiConfig("/v1/snapToRoads")
      .hostName("https://roads.googleapis.com")
      .supportsClientId(false)
      .fieldNamingPolicy(FieldNamingPolicy.IDENTITY);
   static final ApiConfig SPEEDS_API_CONFIG = new ApiConfig("/v1/speedLimits")
      .hostName("https://roads.googleapis.com")
      .supportsClientId(false)
      .fieldNamingPolicy(FieldNamingPolicy.IDENTITY);

   private RoadsApi() {
   }

   public static PendingResult<SnappedPoint[]> nearestRoads(GeoApiContext var0, LatLng... var1) {
      return var0.get(NEAREST_ROADS_API_CONFIG, RoadsApi.RoadsResponse.class, "points", StringJoin.join('|', var1));
   }

   public static PendingResult<SnappedPoint[]> snapToRoads(GeoApiContext var0, boolean var1, LatLng... var2) {
      return var0.get(SNAP_TO_ROADS_API_CONFIG, RoadsApi.RoadsResponse.class, "path", StringJoin.join('|', var2), "interpolate", String.valueOf(var1));
   }

   public static PendingResult<SnappedPoint[]> snapToRoads(GeoApiContext var0, LatLng... var1) {
      return var0.get(SNAP_TO_ROADS_API_CONFIG, RoadsApi.RoadsResponse.class, "path", StringJoin.join('|', var1));
   }

   public static PendingResult<SnappedSpeedLimitResponse> snappedSpeedLimits(GeoApiContext var0, LatLng... var1) {
      return var0.get(SPEEDS_API_CONFIG, RoadsApi.CombinedResponse.class, "path", StringJoin.join('|', var1));
   }

   public static PendingResult<SpeedLimit[]> speedLimits(GeoApiContext var0, LatLng... var1) {
      return var0.get(SPEEDS_API_CONFIG, RoadsApi.SpeedsResponse.class, "path", StringJoin.join('|', var1));
   }

   public static PendingResult<SpeedLimit[]> speedLimits(GeoApiContext var0, String... var1) {
      byte var2 = 0;
      String[] var6 = new String[var1.length * 2];

      for (String var7 : var1) {
         int var8;
         int var5 = var8 + 1;
         var6[var8] = "placeId";
         var8 = var5 + 1;
         var6[var5] = var7;
      }

      return var0.get(SPEEDS_API_CONFIG, RoadsApi.SpeedsResponse.class, var6);
   }

   private static class CombinedResponse implements ApiResponse<SnappedSpeedLimitResponse> {
      private ApiError error;
      private SnappedPoint[] snappedPoints;
      private SpeedLimit[] speedLimits;

      @Override
      public ApiException getError() {
         return ApiException.from(this.error.status, this.error.message);
      }

      public SnappedSpeedLimitResponse getResult() {
         SnappedSpeedLimitResponse var1 = new SnappedSpeedLimitResponse();
         var1.snappedPoints = this.snappedPoints;
         var1.speedLimits = this.speedLimits;
         return var1;
      }

      @Override
      public boolean successful() {
         boolean var1;
         if (this.error == null) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }
   }

   private static class RoadsResponse implements ApiResponse<SnappedPoint[]> {
      private ApiError error;
      private SnappedPoint[] snappedPoints;

      @Override
      public ApiException getError() {
         return ApiException.from(this.error.status, this.error.message);
      }

      public SnappedPoint[] getResult() {
         return this.snappedPoints;
      }

      @Override
      public boolean successful() {
         boolean var1;
         if (this.error == null) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }
   }

   private static class SpeedsResponse implements ApiResponse<SpeedLimit[]> {
      private ApiError error;
      private SpeedLimit[] speedLimits;

      @Override
      public ApiException getError() {
         return ApiException.from(this.error.status, this.error.message);
      }

      public SpeedLimit[] getResult() {
         return this.speedLimits;
      }

      @Override
      public boolean successful() {
         boolean var1;
         if (this.error == null) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }
   }
}
