package com.google.maps;

import com.google.gson.FieldNamingPolicy;
import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;
import com.google.maps.model.PriceLevel;

public class RadarSearchRequest extends PendingResultBase<PlacesSearchResponse, RadarSearchRequest, RadarSearchRequest.Response> {
   static final ApiConfig API_CONFIG = new ApiConfig("/maps/api/place/radarsearch/json").fieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

   protected RadarSearchRequest(GeoApiContext var1) {
      super(var1, API_CONFIG, RadarSearchRequest.Response.class);
   }

   public RadarSearchRequest keyword(String var1) {
      return this.param("keyword", var1);
   }

   public RadarSearchRequest location(LatLng var1) {
      return this.param("location", var1);
   }

   public RadarSearchRequest maxPrice(PriceLevel var1) {
      return this.param("maxprice", var1);
   }

   public RadarSearchRequest minPrice(PriceLevel var1) {
      return this.param("minprice", var1);
   }

   public RadarSearchRequest name(String var1) {
      return this.param("name", var1);
   }

   public RadarSearchRequest openNow(boolean var1) {
      return this.param("opennow", String.valueOf(var1));
   }

   public RadarSearchRequest radius(int var1) {
      if (var1 > 50000) {
         throw new IllegalArgumentException("The maximum allowed radius is 50,000 meters.");
      } else {
         return this.param("radius", String.valueOf(var1));
      }
   }

   public RadarSearchRequest type(PlaceType var1) {
      return this.param("type", var1);
   }

   @Override
   protected void validateRequest() {
      if (!this.params().containsKey("keyword") && !this.params().containsKey("name") && !this.params().containsKey("type")) {
         throw new IllegalArgumentException("Request must contain 'keyword', 'name' or 'type'.");
      }
   }

   public static class Response implements ApiResponse<PlacesSearchResponse> {
      public String errorMessage;
      public String[] htmlAttributions;
      public String nextPageToken;
      public PlacesSearchResult[] results;
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

      public PlacesSearchResponse getResult() {
         PlacesSearchResponse var1 = new PlacesSearchResponse();
         var1.htmlAttributions = this.htmlAttributions;
         var1.results = this.results;
         var1.nextPageToken = this.nextPageToken;
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
}
