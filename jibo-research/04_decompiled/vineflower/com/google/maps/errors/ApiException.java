package com.google.maps.errors;

public class ApiException extends Exception {
   private static final long serialVersionUID = -6550606366694345191L;

   protected ApiException(String var1) {
      super(var1);
   }

   public static ApiException from(String var0, String var1) {
      ApiException var2;
      if ("OK".equals(var0)) {
         var2 = null;
      } else if ("INVALID_REQUEST".equals(var0)) {
         var2 = new InvalidRequestException(var1);
      } else if ("MAX_ELEMENTS_EXCEEDED".equals(var0)) {
         var2 = new MaxElementsExceededException(var1);
      } else if ("NOT_FOUND".equals(var0)) {
         var2 = new NotFoundException(var1);
      } else if ("OVER_QUERY_LIMIT".equals(var0)) {
         if ("You have exceeded your daily request quota for this API.".equalsIgnoreCase(var1)) {
            var2 = new OverDailyLimitException(var1);
         } else {
            var2 = new OverQueryLimitException(var1);
         }
      } else if ("REQUEST_DENIED".equals(var0)) {
         var2 = new RequestDeniedException(var1);
      } else if ("UNKNOWN_ERROR".equals(var0)) {
         var2 = new UnknownErrorException(var1);
      } else if ("ZERO_RESULTS".equals(var0)) {
         var2 = new ZeroResultsException(var1);
      } else if ("ACCESS_NOT_CONFIGURED".equals(var0)) {
         var2 = new AccessNotConfiguredException(var1);
      } else if ("INVALID_ARGUMENT".equals(var0)) {
         var2 = new InvalidRequestException(var1);
      } else if ("RESOURCE_EXHAUSTED".equals(var0)) {
         var2 = new OverQueryLimitException(var1);
      } else if ("PERMISSION_DENIED".equals(var0)) {
         var2 = new RequestDeniedException(var1);
      } else if ("keyInvalid".equals(var0)) {
         var2 = new AccessNotConfiguredException(var1);
      } else if ("dailyLimitExceeded".equals(var0)) {
         var2 = new OverDailyLimitException(var1);
      } else if ("userRateLimitExceeded".equals(var0)) {
         var2 = new OverQueryLimitException(var1);
      } else if ("notFound".equals(var0)) {
         var2 = new NotFoundException(var1);
      } else if ("parseError".equals(var0)) {
         var2 = new InvalidRequestException(var1);
      } else if ("invalid".equals(var0)) {
         var2 = new InvalidRequestException(var1);
      } else {
         var2 = new UnknownErrorException("An unexpected error occurred. Status: " + var0 + ", Message: " + var1);
      }

      return var2;
   }
}
