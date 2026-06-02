package com.google.maps;

import com.google.gson.FieldNamingPolicy;
import com.google.maps.OkHttpRequestHandler;
import com.google.maps.errors.ApiException;
import com.google.maps.errors.OverQueryLimitException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.internal.ExceptionsAllowedToRetry;
import com.google.maps.internal.UrlSigner;
import java.io.UnsupportedEncodingException;
import java.net.Proxy;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class GeoApiContext {
    private static final int DEFAULT_BACKOFF_TIMEOUT_MILLIS = 60000;
    private static final String USER_AGENT = "GoogleGeoApiClientJava/0.2.3-SNAPSHOT";
    private static final String VERSION = "0.2.3-SNAPSHOT";
    private final String apiKey;
    private final String baseUrlOverride;
    private final String channel;
    private final String clientId;
    private final long errorTimeout;
    private final ExceptionsAllowedToRetry exceptionsAllowedToRetry;
    private final Integer maxRetries;
    private final RequestHandler requestHandler;
    private final UrlSigner urlSigner;

    public interface RequestHandler {

        public interface Builder {
            RequestHandler build();

            void connectTimeout(long j, TimeUnit timeUnit);

            void proxy(Proxy proxy);

            void proxyAuthentication(String str, String str2);

            void queriesPerSecond(int i);

            void readTimeout(long j, TimeUnit timeUnit);

            void writeTimeout(long j, TimeUnit timeUnit);
        }

        <T, R extends ApiResponse<T>> PendingResult<T> handle(String str, String str2, String str3, Class<R> cls, FieldNamingPolicy fieldNamingPolicy, long j, Integer num, ExceptionsAllowedToRetry exceptionsAllowedToRetry);

        <T, R extends ApiResponse<T>> PendingResult<T> handlePost(String str, String str2, String str3, String str4, Class<R> cls, FieldNamingPolicy fieldNamingPolicy, long j, Integer num, ExceptionsAllowedToRetry exceptionsAllowedToRetry);
    }

    GeoApiContext(RequestHandler requestHandler, String str, String str2, String str3, String str4, long j, ExceptionsAllowedToRetry exceptionsAllowedToRetry, Integer num, UrlSigner urlSigner) {
        this.requestHandler = requestHandler;
        this.apiKey = str;
        this.baseUrlOverride = str2;
        this.channel = str3;
        this.clientId = str4;
        this.errorTimeout = j;
        this.exceptionsAllowedToRetry = exceptionsAllowedToRetry;
        this.maxRetries = num;
        this.urlSigner = urlSigner;
    }

    <T, R extends ApiResponse<T>> PendingResult<T> get(ApiConfig apiConfig, Class<? extends R> cls, Map<String, String> map) {
        if (this.channel != null && !this.channel.isEmpty() && !map.containsKey("channel")) {
            map.put("channel", this.channel);
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append('&').append(entry.getKey()).append("=");
            try {
                sb.append(URLEncoder.encode(entry.getValue(), HTTP.UTF_8));
            } catch (UnsupportedEncodingException e) {
                throw new IllegalStateException(e);
            }
        }
        return getWithPath(cls, apiConfig.fieldNamingPolicy, apiConfig.hostName, apiConfig.path, apiConfig.supportsClientId, sb.toString());
    }

    <T, R extends ApiResponse<T>> PendingResult<T> get(ApiConfig apiConfig, Class<? extends R> cls, String... strArr) {
        int i = 0;
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Params must be matching key/value pairs.");
        }
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        while (i < strArr.length) {
            if (strArr[i].equals("channel")) {
                z = true;
            }
            sb.append('&').append(strArr[i]).append('=');
            int i2 = i + 1;
            try {
                sb.append(URLEncoder.encode(strArr[i2], HTTP.UTF_8));
                i = i2 + 1;
            } catch (UnsupportedEncodingException e) {
                throw new IllegalStateException(e);
            }
        }
        if (!z && this.channel != null && !this.channel.isEmpty()) {
            sb.append("&channel=").append(this.channel);
        }
        return getWithPath(cls, apiConfig.fieldNamingPolicy, apiConfig.hostName, apiConfig.path, apiConfig.supportsClientId, sb.toString());
    }

    <T, R extends ApiResponse<T>> PendingResult<T> post(ApiConfig apiConfig, Class<? extends R> cls, Map<String, String> map) {
        checkContext(apiConfig.supportsClientId);
        StringBuilder sb = new StringBuilder(apiConfig.path);
        if (apiConfig.supportsClientId && this.clientId != null) {
            sb.append("?client=").append(this.clientId);
        } else {
            sb.append("?key=").append(this.apiKey);
        }
        if (apiConfig.supportsClientId && this.urlSigner != null) {
            sb.append("&signature=").append(this.urlSigner.getSignature(sb.toString()));
        }
        String str = apiConfig.hostName;
        if (this.baseUrlOverride != null) {
            str = this.baseUrlOverride;
        }
        return this.requestHandler.handlePost(str, sb.toString(), map.get("_payload"), USER_AGENT, cls, apiConfig.fieldNamingPolicy, this.errorTimeout, this.maxRetries, this.exceptionsAllowedToRetry);
    }

    private <T, R extends ApiResponse<T>> PendingResult<T> getWithPath(Class<R> cls, FieldNamingPolicy fieldNamingPolicy, String str, String str2, boolean z, String str3) {
        checkContext(z);
        if (!str3.startsWith("&")) {
            throw new IllegalArgumentException("encodedPath must start with &");
        }
        StringBuilder sb = new StringBuilder(str2);
        if (z && this.clientId != null) {
            sb.append("?client=").append(this.clientId);
        } else {
            sb.append("?key=").append(this.apiKey);
        }
        sb.append(str3);
        if (z && this.urlSigner != null) {
            sb.append("&signature=").append(this.urlSigner.getSignature(sb.toString()));
        }
        return this.requestHandler.handle(this.baseUrlOverride != null ? this.baseUrlOverride : str, sb.toString(), USER_AGENT, cls, fieldNamingPolicy, this.errorTimeout, this.maxRetries, this.exceptionsAllowedToRetry);
    }

    private void checkContext(boolean z) {
        if (this.urlSigner == null && this.apiKey == null) {
            throw new IllegalStateException("Must provide either API key or Maps for Work credentials.");
        }
        if (!z && this.apiKey == null) {
            throw new IllegalStateException("API does not support client ID & secret - you must provide a key");
        }
        if (this.urlSigner == null && !this.apiKey.startsWith("AIza")) {
            throw new IllegalStateException("Invalid API key.");
        }
    }

    public static class Builder {
        private String apiKey;
        private String baseUrlOverride;
        private RequestHandler.Builder builder;
        private String channel;
        private String clientId;
        private long errorTimeout = 60000;
        private ExceptionsAllowedToRetry exceptionsAllowedToRetry = new ExceptionsAllowedToRetry();
        private Integer maxRetries;
        private UrlSigner urlSigner;

        public Builder() {
            requestHandlerBuilder(new OkHttpRequestHandler.Builder());
        }

        public Builder(RequestHandler.Builder builder) {
            requestHandlerBuilder(builder);
        }

        public Builder requestHandlerBuilder(RequestHandler.Builder builder) {
            this.builder = builder;
            this.exceptionsAllowedToRetry.add(OverQueryLimitException.class);
            return this;
        }

        Builder baseUrlForTesting(String str) {
            this.baseUrlOverride = str;
            return this;
        }

        public Builder apiKey(String str) {
            this.apiKey = str;
            return this;
        }

        public Builder enterpriseCredentials(String str, String str2) {
            this.clientId = str;
            try {
                this.urlSigner = new UrlSigner(str2);
                return this;
            } catch (InvalidKeyException | NoSuchAlgorithmException e) {
                throw new IllegalStateException(e);
            }
        }

        public Builder channel(String str) {
            this.channel = str;
            return this;
        }

        public Builder connectTimeout(long j, TimeUnit timeUnit) {
            this.builder.connectTimeout(j, timeUnit);
            return this;
        }

        public Builder readTimeout(long j, TimeUnit timeUnit) {
            this.builder.readTimeout(j, timeUnit);
            return this;
        }

        public Builder writeTimeout(long j, TimeUnit timeUnit) {
            this.builder.writeTimeout(j, timeUnit);
            return this;
        }

        public Builder retryTimeout(long j, TimeUnit timeUnit) {
            this.errorTimeout = timeUnit.toMillis(j);
            return this;
        }

        public Builder maxRetries(Integer num) {
            this.maxRetries = num;
            return this;
        }

        public Builder disableRetries() {
            maxRetries(0);
            retryTimeout(0L, TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder queryRateLimit(int i) {
            this.builder.queriesPerSecond(i);
            return this;
        }

        public Builder setIfExceptionIsAllowedToRetry(Class<? extends ApiException> cls, boolean z) {
            if (z) {
                this.exceptionsAllowedToRetry.add(cls);
            } else {
                this.exceptionsAllowedToRetry.remove(cls);
            }
            return this;
        }

        public Builder proxy(Proxy proxy) {
            RequestHandler.Builder builder = this.builder;
            if (proxy == null) {
                proxy = Proxy.NO_PROXY;
            }
            builder.proxy(proxy);
            return this;
        }

        public Builder proxyAuthentication(String str, String str2) {
            this.builder.proxyAuthentication(str, str2);
            return this;
        }

        public GeoApiContext build() {
            return new GeoApiContext(this.builder.build(), this.apiKey, this.baseUrlOverride, this.channel, this.clientId, this.errorTimeout, this.exceptionsAllowedToRetry, this.maxRetries, this.urlSigner);
        }
    }
}
