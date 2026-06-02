package com.google.maps;

import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.StringJoin;
import com.google.maps.model.AddressType;
import com.google.maps.model.ComponentFilter;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.LocationType;

public class GeocodingApiRequest extends PendingResultBase<GeocodingResult[], GeocodingApiRequest, GeocodingApi.Response> {
   private static final ApiConfig API_CONFIG = new ApiConfig("/maps/api/geocode/json");

   public GeocodingApiRequest(GeoApiContext var1) {
      super(var1, API_CONFIG, GeocodingApi.Response.class);
   }

   public GeocodingApiRequest address(String var1) {
      return this.param("address", var1);
   }

   public GeocodingApiRequest bounds(LatLng var1, LatLng var2) {
      return this.param("bounds", StringJoin.join('|', var1, var2));
   }

   public GeocodingApiRequest components(ComponentFilter... var1) {
      return this.param("components", StringJoin.join('|', var1));
   }

   public GeocodingApiRequest latlng(LatLng var1) {
      return this.param("latlng", var1);
   }

   public GeocodingApiRequest locationType(LocationType... var1) {
      return this.param("location_type", StringJoin.join('|', var1));
   }

   public GeocodingApiRequest place(String var1) {
      return this.param("place_id", var1);
   }

   public GeocodingApiRequest region(String var1) {
      return this.param("region", var1);
   }

   public GeocodingApiRequest resultType(AddressType... var1) {
      return this.param("result_type", StringJoin.join('|', var1));
   }

   @Override
   protected void validateRequest() {
      if (this.params().containsKey("latlng") && this.params().containsKey("address") && this.params().containsKey("place_id")) {
         throw new IllegalArgumentException("Request must contain only one of 'address', 'latlng' or 'place_id'.");
      }

      if (!this.params().containsKey("latlng")
         && !this.params().containsKey("address")
         && !this.params().containsKey("components")
         && !this.params().containsKey("place_id")) {
         throw new IllegalArgumentException("Request must contain at least one of 'address', 'latlng', 'place_id' and 'components'.");
      }
   }
}
