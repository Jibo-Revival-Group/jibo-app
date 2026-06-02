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
import com.google.maps.model.RankBy;

public class TextSearchRequest extends PendingResultBase<PlacesSearchResponse, TextSearchRequest, TextSearchRequest.Response> {
   static final ApiConfig API_CONFIG = new ApiConfig("/maps/api/place/textsearch/json").fieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

   public TextSearchRequest(GeoApiContext var1) {
      super(var1, API_CONFIG, TextSearchRequest.Response.class);
   }

   public TextSearchRequest location(LatLng var1) {
      return this.param("location", var1);
   }

   public TextSearchRequest maxPrice(PriceLevel var1) {
      return this.param("maxprice", var1);
   }

   public TextSearchRequest minPrice(PriceLevel var1) {
      return this.param("minprice", var1);
   }

   public TextSearchRequest name(String var1) {
      return this.param("name", var1);
   }

   public TextSearchRequest openNow(boolean var1) {
      return this.param("opennow", String.valueOf(var1));
   }

   public TextSearchRequest pageToken(String var1) {
      return this.param("pagetoken", var1);
   }

   public TextSearchRequest query(String var1) {
      return this.param("query", var1);
   }

   public TextSearchRequest radius(int var1) {
      if (var1 > 50000) {
         throw new IllegalArgumentException("The maximum allowed radius is 50,000 meters.");
      } else {
         return this.param("radius", String.valueOf(var1));
      }
   }

   public TextSearchRequest rankby(RankBy var1) {
      return this.param("rankby", var1);
   }

   public TextSearchRequest type(PlaceType var1) {
      return this.param("type", var1);
   }

   @Override
   protected void validateRequest() {
      if (!this.params().containsKey("pagetoken")) {
         if (!this.params().containsKey("query")) {
            throw new IllegalArgumentException("Request must contain 'query' or a 'pageToken'.");
         }

         if (this.params().containsKey("location") && !this.params().containsKey("radius")) {
            throw new IllegalArgumentException("Request must contain 'radius' parameter when it contains a 'location' parameter.");
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
