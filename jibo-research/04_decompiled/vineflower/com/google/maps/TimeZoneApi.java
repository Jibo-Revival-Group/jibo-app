package com.google.maps;

import com.google.gson.FieldNamingPolicy;
import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.model.LatLng;
import java.util.TimeZone;

public class TimeZoneApi {
   private static final ApiConfig API_CONFIG = new ApiConfig("/maps/api/timezone/json").fieldNamingPolicy(FieldNamingPolicy.IDENTITY);

   private TimeZoneApi() {
   }

   public static PendingResult<TimeZone> getTimeZone(GeoApiContext var0, LatLng var1) {
      return var0.get(API_CONFIG, TimeZoneApi.Response.class, "location", var1.toString(), "timestamp", "0");
   }

   private static class Response implements ApiResponse<TimeZone> {
      public String errorMessage;
      public String status;
      private String timeZoneId;

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

      public TimeZone getResult() {
         TimeZone var1;
         if (this.timeZoneId == null) {
            var1 = null;
         } else {
            var1 = TimeZone.getTimeZone(this.timeZoneId);
         }

         return var1;
      }

      @Override
      public boolean successful() {
         return "OK".equals(this.status);
      }
   }
}
