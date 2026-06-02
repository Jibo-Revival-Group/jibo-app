package com.amazonaws;

public class AmazonClientException extends RuntimeException {
   private static final long serialVersionUID = 1L;

   public AmazonClientException(String var1) {
      super(var1);
   }

   public AmazonClientException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public boolean isRetryable() {
      return true;
   }
}
