package com.google.maps.errors;

/* JADX INFO: loaded from: classes.dex */
public class ApiException extends Exception {
    private static final long serialVersionUID = -6550606366694345191L;

    protected ApiException(String str) {
        super(str);
    }

    public static ApiException from(String str, String str2) {
        if ("OK".equals(str)) {
            return null;
        }
        if ("INVALID_REQUEST".equals(str)) {
            return new InvalidRequestException(str2);
        }
        if ("MAX_ELEMENTS_EXCEEDED".equals(str)) {
            return new MaxElementsExceededException(str2);
        }
        if ("NOT_FOUND".equals(str)) {
            return new NotFoundException(str2);
        }
        if ("OVER_QUERY_LIMIT".equals(str)) {
            if ("You have exceeded your daily request quota for this API.".equalsIgnoreCase(str2)) {
                return new OverDailyLimitException(str2);
            }
            return new OverQueryLimitException(str2);
        }
        if ("REQUEST_DENIED".equals(str)) {
            return new RequestDeniedException(str2);
        }
        if ("UNKNOWN_ERROR".equals(str)) {
            return new UnknownErrorException(str2);
        }
        if ("ZERO_RESULTS".equals(str)) {
            return new ZeroResultsException(str2);
        }
        if ("ACCESS_NOT_CONFIGURED".equals(str)) {
            return new AccessNotConfiguredException(str2);
        }
        if ("INVALID_ARGUMENT".equals(str)) {
            return new InvalidRequestException(str2);
        }
        if ("RESOURCE_EXHAUSTED".equals(str)) {
            return new OverQueryLimitException(str2);
        }
        if ("PERMISSION_DENIED".equals(str)) {
            return new RequestDeniedException(str2);
        }
        if ("keyInvalid".equals(str)) {
            return new AccessNotConfiguredException(str2);
        }
        if ("dailyLimitExceeded".equals(str)) {
            return new OverDailyLimitException(str2);
        }
        if ("userRateLimitExceeded".equals(str)) {
            return new OverQueryLimitException(str2);
        }
        if ("notFound".equals(str)) {
            return new NotFoundException(str2);
        }
        if ("parseError".equals(str)) {
            return new InvalidRequestException(str2);
        }
        if ("invalid".equals(str)) {
            return new InvalidRequestException(str2);
        }
        return new UnknownErrorException("An unexpected error occurred. Status: " + str + ", Message: " + str2);
    }
}
