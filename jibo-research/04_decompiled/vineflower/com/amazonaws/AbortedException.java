package com.amazonaws;

public class AbortedException extends AmazonClientException {
   public AbortedException() {
      super("");
   }

   @Override
   public boolean isRetryable() {
      return false;
   }
}
