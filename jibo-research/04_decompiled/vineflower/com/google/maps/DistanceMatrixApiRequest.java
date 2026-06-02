package com.google.maps;

import com.google.maps.internal.StringJoin;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.LatLng;
import com.google.maps.model.TrafficModel;
import com.google.maps.model.TransitMode;
import com.google.maps.model.TransitRoutingPreference;
import com.google.maps.model.TravelMode;
import com.google.maps.model.Unit;
import org.joda.time.ReadableInstant;

public class DistanceMatrixApiRequest extends PendingResultBase<DistanceMatrix, DistanceMatrixApiRequest, DistanceMatrixApi.Response> {
   public DistanceMatrixApiRequest(GeoApiContext var1) {
      super(var1, DistanceMatrixApi.API_CONFIG, DistanceMatrixApi.Response.class);
   }

   public DistanceMatrixApiRequest arrivalTime(ReadableInstant var1) {
      return this.param("arrival_time", Long.toString(var1.c() / 1000L));
   }

   public DistanceMatrixApiRequest avoid(DirectionsApi.RouteRestriction var1) {
      return this.param("avoid", var1);
   }

   public DistanceMatrixApiRequest departureTime(ReadableInstant var1) {
      return this.param("departure_time", Long.toString(var1.c() / 1000L));
   }

   public DistanceMatrixApiRequest destinations(LatLng... var1) {
      return this.param("destinations", StringJoin.join('|', var1));
   }

   public DistanceMatrixApiRequest destinations(String... var1) {
      return this.param("destinations", StringJoin.join('|', var1));
   }

   public DistanceMatrixApiRequest mode(TravelMode var1) {
      if (!TravelMode.DRIVING.equals(var1) && !TravelMode.WALKING.equals(var1) && !TravelMode.BICYCLING.equals(var1) && !TravelMode.TRANSIT.equals(var1)) {
         throw new IllegalArgumentException("Distance Matrix API travel modes must be Driving, Transit, Walking or Bicycling");
      } else {
         return this.param("mode", var1);
      }
   }

   public DistanceMatrixApiRequest origins(LatLng... var1) {
      return this.param("origins", StringJoin.join('|', var1));
   }

   public DistanceMatrixApiRequest origins(String... var1) {
      return this.param("origins", StringJoin.join('|', var1));
   }

   public DistanceMatrixApiRequest trafficModel(TrafficModel var1) {
      return this.param("traffic_model", var1);
   }

   public DistanceMatrixApiRequest transitModes(TransitMode... var1) {
      return this.param("transit_mode", StringJoin.join('|', var1));
   }

   public DistanceMatrixApiRequest transitRoutingPreference(TransitRoutingPreference var1) {
      return this.param("transit_routing_preference", var1);
   }

   public DistanceMatrixApiRequest units(Unit var1) {
      return this.param("units", var1);
   }

   @Override
   protected void validateRequest() {
      if (!this.params().containsKey("origins")) {
         throw new IllegalArgumentException("Request must contain 'origins'");
      }

      if (!this.params().containsKey("destinations")) {
         throw new IllegalArgumentException("Request must contain 'destinations'");
      }

      if (TravelMode.TRANSIT.toString().equals(this.params().get("mode"))
         && this.params().containsKey("arrival_time")
         && this.params().containsKey("departure_time")) {
         throw new IllegalArgumentException("Transit request must not contain both a departureTime and an arrivalTime");
      }
   }
}
