package com.google.maps;

import com.google.gson.FieldNamingPolicy;
import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.internal.StringJoin;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;
import com.google.maps.model.PriceLevel;
import com.google.maps.model.RankBy;

public class NearbySearchRequest extends PendingResultBase<PlacesSearchResponse, NearbySearchRequest, NearbySearchRequest.Response> {
   static final ApiConfig API_CONFIG = new ApiConfig("/maps/api/place/nearbysearch/json").fieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

   public NearbySearchRequest(GeoApiContext var1) {
      super(var1, API_CONFIG, NearbySearchRequest.Response.class);
   }

   public NearbySearchRequest keyword(String var1) {
      return this.param("keyword", var1);
   }

   public NearbySearchRequest location(LatLng var1) {
      return this.param("location", var1);
   }

   public NearbySearchRequest maxPrice(PriceLevel var1) {
      return this.param("maxprice", var1);
   }

   public NearbySearchRequest minPrice(PriceLevel var1) {
      return this.param("minprice", var1);
   }

   public NearbySearchRequest name(String var1) {
      return this.param("name", var1);
   }

   public NearbySearchRequest openNow(boolean var1) {
      return this.param("opennow", String.valueOf(var1));
   }

   public NearbySearchRequest pageToken(String var1) {
      return this.param("pagetoken", var1);
   }

   public NearbySearchRequest radius(int var1) {
      if (var1 > 50000) {
         throw new IllegalArgumentException("The maximum allowed radius is 50,000 meters.");
      } else {
         return this.param("radius", String.valueOf(var1));
      }
   }

   public NearbySearchRequest rankby(RankBy var1) {
      return this.param("rankby", var1);
   }

   public NearbySearchRequest type(PlaceType var1) {
      return this.param("type", var1);
   }

   public NearbySearchRequest type(PlaceType... var1) {
      return this.param("type", StringJoin.join('|', var1));
   }

   @Override
   protected void validateRequest() {
      if (!this.params().containsKey("pagetoken")) {
         if (this.params().containsKey("rankby") && this.params().get("rankby").equals(RankBy.DISTANCE.toString()) && this.params().containsKey("radius")) {
            throw new IllegalArgumentException("Request must not contain radius with rankby=distance");
         }

         if (this.params().containsKey("rankby")
            && this.params().get("rankby").equals(RankBy.DISTANCE.toString())
            && !this.params().containsKey("keyword")
            && !this.params().containsKey("name")
            && !this.params().containsKey("type")) {
            throw new IllegalArgumentException("With rankby=distance is specified, then one or more of keyword, name, or type is required");
         }
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
