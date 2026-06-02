package com.amazonaws.retry;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import java.io.IOException;
import java.util.Random;

public class PredefinedRetryPolicies {
   public static final RetryPolicy DEFAULT = getDefaultRetryPolicy();
   public static final RetryPolicy.BackoffStrategy DEFAULT_BACKOFF_STRATEGY = new PredefinedRetryPolicies.SDKDefaultBackoffStrategy();
   public static final RetryPolicy.RetryCondition DEFAULT_RETRY_CONDITION = new PredefinedRetryPolicies.SDKDefaultRetryCondition();
   public static final RetryPolicy DYNAMODB_DEFAULT = getDynamoDBDefaultRetryPolicy();
   public static final RetryPolicy.BackoffStrategy DYNAMODB_DEFAULT_BACKOFF_STRATEGY = new PredefinedRetryPolicies.DynamoDBDefaultBackoffStrategy();

   public static RetryPolicy getDefaultRetryPolicy() {
      return new RetryPolicy(DEFAULT_RETRY_CONDITION, DEFAULT_BACKOFF_STRATEGY, 2, true);
   }

   public static RetryPolicy getDynamoDBDefaultRetryPolicy() {
      return new RetryPolicy(DEFAULT_RETRY_CONDITION, DYNAMODB_DEFAULT_BACKOFF_STRATEGY, 3, true);
   }

   private static class DynamoDBDefaultBackoffStrategy implements RetryPolicy.BackoffStrategy {
      private DynamoDBDefaultBackoffStrategy() {
      }

      @Override
      public final long delayBeforeNextRetry(AmazonWebServiceRequest var1, AmazonClientException var2, int var3) {
         long var4;
         if (var3 <= 0) {
            var4 = 0L;
         } else {
            var4 = Math.min((1 << var3) * 25, 20000L);
         }

         return var4;
      }
   }

   private static class SDKDefaultBackoffStrategy implements RetryPolicy.BackoffStrategy {
      private final Random random = new Random();

      private SDKDefaultBackoffStrategy() {
      }

      @Override
      public final long delayBeforeNextRetry(AmazonWebServiceRequest var1, AmazonClientException var2, int var3) {
         long var5;
         if (var3 <= 0) {
            var5 = 0L;
         } else {
            int var4;
            if (var2 instanceof AmazonServiceException && RetryUtils.isThrottlingException((AmazonServiceException)var2)) {
               var4 = this.random.nextInt(125) + 500;
            } else {
               var4 = 300;
            }

            var5 = Math.min(var4 * (1 << var3), 20000L);
         }

         return var5;
      }
   }

   public static class SDKDefaultRetryCondition implements RetryPolicy.RetryCondition {
      @Override
      public boolean shouldRetry(AmazonWebServiceRequest var1, AmazonClientException var2, int var3) {
         boolean var5 = true;
         boolean var4;
         if (var2.getCause() instanceof IOException) {
            var4 = var5;
         } else {
            if (var2 instanceof AmazonServiceException) {
               AmazonServiceException var6 = (AmazonServiceException)var2;
               var4 = var5;
               if (var6.getStatusCode() == 500) {
                  return var4;
               }

               var4 = var5;
               if (var6.getStatusCode() == 503) {
                  return var4;
               }

               var4 = var5;
               if (RetryUtils.isThrottlingException(var6)) {
                  return var4;
               }

               var4 = var5;
               if (RetryUtils.isClockSkewError(var6)) {
                  return var4;
               }
            }

            var4 = false;
         }

         return var4;
      }
   }
}
