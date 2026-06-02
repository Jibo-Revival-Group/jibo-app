package com.google.maps;

import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.internal.StringJoin;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.GeocodedWaypoint;

public class DirectionsApi {
   static final ApiConfig API_CONFIG = new ApiConfig("/maps/api/directions/json");

   private DirectionsApi() {
   }

   public static DirectionsApiRequest getDirections(GeoApiContext var0, String var1, String var2) {
      return new DirectionsApiRequest(var0).origin(var1).destination(var2);
   }

   public static DirectionsApiRequest newRequest(GeoApiContext var0) {
      return new DirectionsApiRequest(var0);
   }

   static class Response implements ApiResponse<DirectionsResult> {
      public String errorMessage;
      public GeocodedWaypoint[] geocodedWaypoints;
      public DirectionsRoute[] routes;
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

      public DirectionsResult getResult() {
         DirectionsResult var1 = new DirectionsResult();
         var1.geocodedWaypoints = this.geocodedWaypoints;
         var1.routes = this.routes;
         return var1;
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

   public enum RouteRestriction implements StringJoin.UrlValue {
      FERRIES("ferries"),
      HIGHWAYS("highways"),
      TOLLS("tolls");

      private static final DirectionsApi.RouteRestriction[] $VALUES = new DirectionsApi.RouteRestriction[]{
         DirectionsApi.RouteRestriction.TOLLS, DirectionsApi.RouteRestriction.HIGHWAYS, DirectionsApi.RouteRestriction.FERRIES
      };
      private final String restriction;

      RouteRestriction(String var3) {
         this.restriction = var3;
      }

      @Override
      public String toString() {
         return this.restriction;
      }

      @Override
      public String toUrlValue() {
         return this.restriction;
      }
   }
}
