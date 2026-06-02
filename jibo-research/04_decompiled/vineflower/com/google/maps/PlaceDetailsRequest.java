package com.google.maps;

import com.google.gson.FieldNamingPolicy;
import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.model.PlaceDetails;

public class PlaceDetailsRequest extends PendingResultBase<PlaceDetails, PlaceDetailsRequest, PlaceDetailsRequest.Response> {
   static final ApiConfig API_CONFIG = new ApiConfig("/maps/api/place/details/json").fieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

   public PlaceDetailsRequest(GeoApiContext var1) {
      super(var1, API_CONFIG, PlaceDetailsRequest.Response.class);
   }

   public PlaceDetailsRequest placeId(String var1) {
      return this.param("placeid", var1);
   }

   @Override
   protected void validateRequest() {
      if (!this.params().containsKey("placeid")) {
         throw new IllegalArgumentException("Request must contain 'placeId'.");
      }
   }

   public static class Response implements ApiResponse<PlaceDetails> {
      public String errorMessage;
      public String[] htmlAttributions;
      public PlaceDetails result;
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

      public PlaceDetails getResult() {
         if (this.result != null) {
            this.result.htmlAttributions = this.htmlAttributions;
         }

         return this.result;
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
