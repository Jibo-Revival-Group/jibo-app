package com.google.maps;

import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.model.PhotoResult;

public class PhotoRequest extends PendingResultBase<PhotoResult, PhotoRequest, PhotoRequest.Response> {
   static final ApiConfig API_CONFIG = new ApiConfig("/maps/api/place/photo");

   public PhotoRequest(GeoApiContext var1) {
      super(var1, API_CONFIG, PhotoRequest.Response.class);
   }

   public PhotoRequest maxHeight(int var1) {
      return this.param("maxheight", String.valueOf(var1));
   }

   public PhotoRequest maxWidth(int var1) {
      return this.param("maxwidth", String.valueOf(var1));
   }

   public PhotoRequest photoReference(String var1) {
      return this.param("photoreference", var1);
   }

   @Override
   protected void validateRequest() {
      if (!this.params().containsKey("photoreference")) {
         throw new IllegalArgumentException("Request must contain 'photoReference'.");
      }

      if (!this.params().containsKey("maxheight") && !this.params().containsKey("maxwidth")) {
         throw new IllegalArgumentException("Request must contain 'maxHeight' or 'maxWidth'.");
      }
   }

   public static class Response implements ApiResponse<PhotoResult> {
      private Response() {
      }

      @Override
      public ApiException getError() {
         return null;
      }

      public PhotoResult getResult() {
         return null;
      }

      @Override
      public boolean successful() {
         return false;
      }
   }
}
