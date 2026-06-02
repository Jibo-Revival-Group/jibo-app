package com.google.maps;

import com.google.gson.FieldNamingPolicy;
import com.google.maps.GeoApiContext;
import com.google.maps.internal.ApiResponse;
import com.google.maps.internal.ExceptionsAllowedToRetry;
import com.google.maps.internal.OkHttpPendingResult;
import com.google.maps.internal.RateLimitExecutorService;
import java.io.IOException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.Dispatcher;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import org.apache.http.HttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes.dex */
public class OkHttpRequestHandler implements GeoApiContext.RequestHandler {
    private final OkHttpClient client;
    private static final Logger LOG = LoggerFactory.m17025a(OkHttpRequestHandler.class.getName());
    private static final MediaType JSON = MediaType.m15695a("application/json; charset=utf-8");

    OkHttpRequestHandler(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    @Override // com.google.maps.GeoApiContext.RequestHandler
    public <T, R extends ApiResponse<T>> PendingResult<T> handle(String str, String str2, String str3, Class<R> cls, FieldNamingPolicy fieldNamingPolicy, long j, Integer num, ExceptionsAllowedToRetry exceptionsAllowedToRetry) {
        return new OkHttpPendingResult(new Request.Builder().m15773a().m15775a("User-Agent", str3).m15774a(str + str2).m15784c(), this.client, cls, fieldNamingPolicy, j, num, exceptionsAllowedToRetry);
    }

    @Override // com.google.maps.GeoApiContext.RequestHandler
    public <T, R extends ApiResponse<T>> PendingResult<T> handlePost(String str, String str2, String str3, String str4, Class<R> cls, FieldNamingPolicy fieldNamingPolicy, long j, Integer num, ExceptionsAllowedToRetry exceptionsAllowedToRetry) {
        return new OkHttpPendingResult(new Request.Builder().m15779a(RequestBody.m15785a(JSON, str3)).m15775a("User-Agent", str4).m15774a(str + str2).m15784c(), this.client, cls, fieldNamingPolicy, j, num, exceptionsAllowedToRetry);
    }

    public static class Builder implements GeoApiContext.RequestHandler.Builder {
        private final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        private final RateLimitExecutorService rateLimitExecutorService = new RateLimitExecutorService();
        private final Dispatcher dispatcher = new Dispatcher(this.rateLimitExecutorService);

        public Builder() {
            this.builder.m15750a(this.dispatcher);
        }

        @Override // com.google.maps.GeoApiContext.RequestHandler.Builder
        public void connectTimeout(long j, TimeUnit timeUnit) {
            this.builder.m15743a(j, timeUnit);
        }

        @Override // com.google.maps.GeoApiContext.RequestHandler.Builder
        public void readTimeout(long j, TimeUnit timeUnit) {
            this.builder.m15753b(j, timeUnit);
        }

        @Override // com.google.maps.GeoApiContext.RequestHandler.Builder
        public void writeTimeout(long j, TimeUnit timeUnit) {
            this.builder.m15755c(j, timeUnit);
        }

        @Override // com.google.maps.GeoApiContext.RequestHandler.Builder
        public void queriesPerSecond(int i) {
            this.dispatcher.m15594a(i);
            this.dispatcher.m15598b(i);
            this.rateLimitExecutorService.setQueriesPerSecond(i);
        }

        @Override // com.google.maps.GeoApiContext.RequestHandler.Builder
        public void proxy(Proxy proxy) {
            this.builder.m15744a(proxy);
        }

        @Override // com.google.maps.GeoApiContext.RequestHandler.Builder
        public void proxyAuthentication(final String str, final String str2) {
            this.builder.m15748a(new Authenticator() { // from class: com.google.maps.OkHttpRequestHandler.Builder.1
                @Override // okhttp3.Authenticator
                public Request authenticate(Route route, Response response) throws IOException {
                    return response.m15791a().m15770e().m15775a(HttpHeaders.PROXY_AUTHORIZATION, Credentials.m15588a(str, str2)).m15784c();
                }
            });
        }

        @Override // com.google.maps.GeoApiContext.RequestHandler.Builder
        public GeoApiContext.RequestHandler build() {
            return new OkHttpRequestHandler(this.builder.m15752a());
        }
    }
}
