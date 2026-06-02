package com.amazonaws.retry;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceRequest;

public final class RetryPolicy {
   private final RetryPolicy.BackoffStrategy backoffStrategy;
   private final boolean honorMaxErrorRetryInClientConfig;
   private final int maxErrorRetry;
   private final RetryPolicy.RetryCondition retryCondition;

   public RetryPolicy(RetryPolicy.RetryCondition var1, RetryPolicy.BackoffStrategy var2, int var3, boolean var4) {
      RetryPolicy.RetryCondition var5 = var1;
      if (var1 == null) {
         var5 = PredefinedRetryPolicies.DEFAULT_RETRY_CONDITION;
      }

      RetryPolicy.BackoffStrategy var6 = var2;
      if (var2 == null) {
         var6 = PredefinedRetryPolicies.DEFAULT_BACKOFF_STRATEGY;
      }

      if (var3 < 0) {
         throw new IllegalArgumentException("Please provide a non-negative value for maxErrorRetry.");
      }

      this.retryCondition = var5;
      this.backoffStrategy = var6;
      this.maxErrorRetry = var3;
      this.honorMaxErrorRetryInClientConfig = var4;
   }

   public RetryPolicy.BackoffStrategy getBackoffStrategy() {
      return this.backoffStrategy;
   }

   public int getMaxErrorRetry() {
      return this.maxErrorRetry;
   }

   public RetryPolicy.RetryCondition getRetryCondition() {
      return this.retryCondition;
   }

   public boolean isMaxErrorRetryInClientConfigHonored() {
      return this.honorMaxErrorRetryInClientConfig;
   }

   public interface BackoffStrategy {
      long delayBeforeNextRetry(AmazonWebServiceRequest var1, AmazonClientException var2, int var3);
   }

   public interface RetryCondition {
      boolean shouldRetry(AmazonWebServiceRequest var1, AmazonClientException var2, int var3);
   }
}
