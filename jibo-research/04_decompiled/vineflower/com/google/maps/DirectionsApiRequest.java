package com.google.maps;

import com.google.maps.internal.StringJoin;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.TrafficModel;
import com.google.maps.model.TransitMode;
import com.google.maps.model.TransitRoutingPreference;
import com.google.maps.model.TravelMode;
import com.google.maps.model.Unit;
import org.joda.time.ReadableInstant;

public class DirectionsApiRequest extends PendingResultBase<DirectionsResult, DirectionsApiRequest, DirectionsApi.Response> {
   protected boolean optimizeWaypoints;
   protected String[] waypoints;

   DirectionsApiRequest(GeoApiContext var1) {
      super(var1, DirectionsApi.API_CONFIG, DirectionsApi.Response.class);
   }

   public DirectionsApiRequest alternatives(boolean var1) {
      DirectionsApiRequest var2;
      if (var1) {
         var2 = this.param("alternatives", "true");
      } else {
         var2 = this.param("alternatives", "false");
      }

      return var2;
   }

   public DirectionsApiRequest arrivalTime(ReadableInstant var1) {
      return this.param("arrival_time", Long.toString(var1.c() / 1000L));
   }

   public DirectionsApiRequest avoid(DirectionsApi.RouteRestriction... var1) {
      return this.param("avoid", StringJoin.join('|', var1));
   }

   public DirectionsApiRequest departureTime(ReadableInstant var1) {
      return this.param("departure_time", Long.toString(var1.c() / 1000L));
   }

   public DirectionsApiRequest destination(LatLng var1) {
      return this.destination(var1.toString());
   }

   public DirectionsApiRequest destination(String var1) {
      return this.param("destination", var1);
   }

   public DirectionsApiRequest mode(TravelMode var1) {
      return this.param("mode", var1);
   }

   public DirectionsApiRequest optimizeWaypoints(boolean var1) {
      this.optimizeWaypoints = var1;
      DirectionsApiRequest var2 = this;
      if (this.waypoints != null) {
         var2 = this.waypoints(this.waypoints);
      }

      return var2;
   }

   public DirectionsApiRequest origin(LatLng var1) {
      return this.origin(var1.toString());
   }

   public DirectionsApiRequest origin(String var1) {
      return this.param("origin", var1);
   }

   public DirectionsApiRequest region(String var1) {
      return this.param("region", var1);
   }

   public DirectionsApiRequest trafficModel(TrafficModel var1) {
      return this.param("traffic_model", var1);
   }

   public DirectionsApiRequest transitMode(TransitMode... var1) {
      return this.param("transit_mode", StringJoin.join('|', var1));
   }

   public DirectionsApiRequest transitRoutingPreference(TransitRoutingPreference var1) {
      return this.param("transit_routing_preference", var1);
   }

   public DirectionsApiRequest units(Unit var1) {
      return this.param("units", var1);
   }

   @Override
   protected void validateRequest() {
      if (!this.params().containsKey("origin")) {
         throw new IllegalArgumentException("Request must contain 'origin'");
      }

      if (!this.params().containsKey("destination")) {
         throw new IllegalArgumentException("Request must contain 'destination'");
      }

      if (TravelMode.TRANSIT.toString().equals(this.params().get("mode"))
         && this.params().containsKey("arrival_time")
         && this.params().containsKey("departure_time")) {
         throw new IllegalArgumentException("Transit request must not contain both a departureTime and an arrivalTime");
      }

      if (this.params().containsKey("traffic_model") && !this.params().containsKey("departure_time")) {
         throw new IllegalArgumentException("Specifying a traffic model requires that departure time be provided.");
      }
   }

   public DirectionsApiRequest waypoints(LatLng... var1) {
      DirectionsApiRequest var5;
      if (var1 == null) {
         var5 = this;
      } else {
         int var3 = var1.length;
         String[] var4 = new String[var3];

         for (int var2 = 0; var2 < var3; var2++) {
            var4[var2] = var1[var2].toString();
         }

         var5 = this.waypoints(var4);
      }

      return var5;
   }

   public DirectionsApiRequest waypoints(String... var1) {
      this.waypoints = var1;
      DirectionsApiRequest var4;
      if (var1 != null && var1.length != 0) {
         if (var1.length == 1) {
            var4 = this.param("waypoints", var1[0]);
         } else {
            StringBuilder var3 = new StringBuilder();
            String var2;
            if (this.optimizeWaypoints) {
               var2 = "optimize:true|";
            } else {
               var2 = "";
            }

            var4 = this.param("waypoints", var3.append(var2).append(StringJoin.join('|', var1)).toString());
         }
      } else {
         var4 = this;
      }

      return var4;
   }
}
