package com.google.maps;

import com.google.gson.FieldNamingPolicy;
import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.internal.StringJoin;
import com.google.maps.model.AutocompletePrediction;
import com.google.maps.model.ComponentFilter;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceAutocompleteType;

public class PlaceAutocompleteRequest extends PendingResultBase<AutocompletePrediction[], PlaceAutocompleteRequest, PlaceAutocompleteRequest.Response> {
   static final ApiConfig API_CONFIG = new ApiConfig("/maps/api/place/autocomplete/json").fieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

   protected PlaceAutocompleteRequest(GeoApiContext var1) {
      super(var1, API_CONFIG, PlaceAutocompleteRequest.Response.class);
   }

   public PlaceAutocompleteRequest components(ComponentFilter... var1) {
      return this.param("components", StringJoin.join('|', var1));
   }

   public PlaceAutocompleteRequest input(String var1) {
      return this.param("input", var1);
   }

   public PlaceAutocompleteRequest location(LatLng var1) {
      return this.param("location", var1);
   }

   public PlaceAutocompleteRequest offset(int var1) {
      return this.param("offset", String.valueOf(var1));
   }

   public PlaceAutocompleteRequest radius(int var1) {
      return this.param("radius", String.valueOf(var1));
   }

   public PlaceAutocompleteRequest type(PlaceAutocompleteType var1) {
      return this.param("types", var1);
   }

   @Override
   protected void validateRequest() {
      if (!this.params().containsKey("input")) {
         throw new IllegalArgumentException("Request must contain 'input'.");
      }
   }

   public static class Response implements ApiResponse<AutocompletePrediction[]> {
      public String errorMessage;
      public AutocompletePrediction[] predictions;
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

      public AutocompletePrediction[] getResult() {
         return this.predictions;
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
