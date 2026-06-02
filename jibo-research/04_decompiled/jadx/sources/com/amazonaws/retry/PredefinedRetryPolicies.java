package com.amazonaws.retry;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.retry.RetryPolicy;
import java.io.IOException;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class PredefinedRetryPolicies {
    public static final RetryPolicy.BackoffStrategy DEFAULT_BACKOFF_STRATEGY;
    public static final RetryPolicy.BackoffStrategy DYNAMODB_DEFAULT_BACKOFF_STRATEGY;
    public static final RetryPolicy.RetryCondition DEFAULT_RETRY_CONDITION = new SDKDefaultRetryCondition();
    public static final RetryPolicy DEFAULT = getDefaultRetryPolicy();
    public static final RetryPolicy DYNAMODB_DEFAULT = getDynamoDBDefaultRetryPolicy();

    private static class DynamoDBDefaultBackoffStrategy implements RetryPolicy.BackoffStrategy {
        private DynamoDBDefaultBackoffStrategy() {
        }

        @Override // com.amazonaws.retry.RetryPolicy.BackoffStrategy
        public final long delayBeforeNextRetry(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i) {
            if (i <= 0) {
                return 0L;
            }
            return Math.min((1 << i) * 25, 20000L);
        }
    }

    private static class SDKDefaultBackoffStrategy implements RetryPolicy.BackoffStrategy {
        private final Random random;

        private SDKDefaultBackoffStrategy() {
            this.random = new Random();
        }

        @Override // com.amazonaws.retry.RetryPolicy.BackoffStrategy
        public final long delayBeforeNextRetry(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i) {
            if (i <= 0) {
                return 0L;
            }
            return Math.min((((amazonClientException instanceof AmazonServiceException) && RetryUtils.isThrottlingException((AmazonServiceException) amazonClientException)) ? this.random.nextInt(125) + 500 : 300) * (1 << i), 20000L);
        }
    }

    public static class SDKDefaultRetryCondition implements RetryPolicy.RetryCondition {
        @Override // com.amazonaws.retry.RetryPolicy.RetryCondition
        public boolean shouldRetry(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i) {
            if (amazonClientException.getCause() instanceof IOException) {
                return true;
            }
            if (amazonClientException instanceof AmazonServiceException) {
                AmazonServiceException amazonServiceException = (AmazonServiceException) amazonClientException;
                if (amazonServiceException.getStatusCode() == 500 || amazonServiceException.getStatusCode() == 503 || RetryUtils.isThrottlingException(amazonServiceException) || RetryUtils.isClockSkewError(amazonServiceException)) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        DEFAULT_BACKOFF_STRATEGY = new SDKDefaultBackoffStrategy();
        DYNAMODB_DEFAULT_BACKOFF_STRATEGY = new DynamoDBDefaultBackoffStrategy();
    }

    public static RetryPolicy getDefaultRetryPolicy() {
        return new RetryPolicy(DEFAULT_RETRY_CONDITION, DEFAULT_BACKOFF_STRATEGY, 2, true);
    }

    public static RetryPolicy getDynamoDBDefaultRetryPolicy() {
        return new RetryPolicy(DEFAULT_RETRY_CONDITION, DYNAMODB_DEFAULT_BACKOFF_STRATEGY, 3, true);
    }
}
