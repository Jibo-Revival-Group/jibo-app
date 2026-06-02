package com.amazonaws.retry;

import com.amazonaws.AmazonServiceException;

public class RetryUtils {
   public static boolean isClockSkewError(AmazonServiceException var0) {
      boolean var1 = false;
      if (var0 != null) {
         String var2 = var0.getErrorCode();
         if ("RequestTimeTooSkewed".equals(var2)
            || "RequestExpired".equals(var2)
            || "InvalidSignatureException".equals(var2)
            || "SignatureDoesNotMatch".equals(var2)) {
            var1 = true;
         }
      }

      return var1;
   }

   public static boolean isThrottlingException(AmazonServiceException var0) {
      boolean var1 = false;
      if (var0 != null) {
         String var2 = var0.getErrorCode();
         if ("Throttling".equals(var2) || "ThrottlingException".equals(var2) || "ProvisionedThroughputExceededException".equals(var2)) {
            var1 = true;
         }
      }

      return var1;
   }
}
