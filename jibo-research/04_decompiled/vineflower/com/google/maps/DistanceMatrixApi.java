package com.google.maps;

import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixRow;

public class DistanceMatrixApi {
   static final ApiConfig API_CONFIG = new ApiConfig("/maps/api/distancematrix/json");

   private DistanceMatrixApi() {
   }

   public static DistanceMatrixApiRequest getDistanceMatrix(GeoApiContext var0, String[] var1, String[] var2) {
      return newRequest(var0).origins(var1).destinations(var2);
   }

   public static DistanceMatrixApiRequest newRequest(GeoApiContext var0) {
      return new DistanceMatrixApiRequest(var0);
   }

   static class Response implements ApiResponse<DistanceMatrix> {
      public String[] destinationAddresses;
      public String errorMessage;
      public String[] originAddresses;
      public DistanceMatrixRow[] rows;
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

      public DistanceMatrix getResult() {
         return new DistanceMatrix(this.originAddresses, this.destinationAddresses, this.rows);
      }

      @Override
      public boolean successful() {
         return "OK".equals(this.status);
      }
   }
}
