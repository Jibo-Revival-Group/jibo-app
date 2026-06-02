package com.google.maps;

import com.google.gson.FieldNamingPolicy;
import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.model.GeolocationPayload;
import com.google.maps.model.GeolocationResult;
import com.google.maps.model.LatLng;
import java.util.logging.Logger;

public class GeolocationApi {
   private static final String API_BASE_URL = "https://www.googleapis.com";
   static final ApiConfig GEOLOCATION_API_CONFIG = new ApiConfig("/geolocation/v1/geolocate")
      .hostName("https://www.googleapis.com")
      .supportsClientId(false)
      .fieldNamingPolicy(FieldNamingPolicy.IDENTITY)
      .requestVerb("POST");
   private static final Logger LOG = Logger.getLogger(GeolocationApi.class.getName());

   private GeolocationApi() {
   }

   public static PendingResult<GeolocationResult> geolocate(GeoApiContext var0, GeolocationPayload var1) {
      return new GeolocationApiRequest(var0).Payload(var1).CreatePayload();
   }

   public static GeolocationApiRequest newRequest(GeoApiContext var0) {
      return new GeolocationApiRequest(var0);
   }

   public static class Response implements ApiResponse<GeolocationResult> {
      public double accuracy;
      public int code = 200;
      public String debugInfo;
      public String domain;
      public LatLng location;
      public String message = "OK";
      public String reason;

      public Response() {
         this.accuracy = -1.0;
         this.location = null;
         this.domain = null;
         this.reason = null;
         this.debugInfo = null;
      }

      @Override
      public ApiException getError() {
         ApiException var1;
         if (this.successful()) {
            var1 = null;
         } else {
            var1 = ApiException.from(this.reason, this.message);
         }

         return var1;
      }

      public GeolocationResult getResult() {
         GeolocationResult var1 = new GeolocationResult();
         var1.accuracy = this.accuracy;
         var1.location = this.location;
         return var1;
      }

      @Override
      public boolean successful() {
         boolean var1;
         if (this.code == 200) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }
   }
}
