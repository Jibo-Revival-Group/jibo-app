package com.google.maps;

import com.google.appengine.api.urlfetch.FetchOptions;
import com.google.appengine.api.urlfetch.HTTPHeader;
import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;
import com.google.gson.FieldNamingPolicy;
import com.google.maps.GeoApiContext;
import com.google.maps.internal.ApiResponse;
import com.google.maps.internal.ExceptionsAllowedToRetry;
import com.google.maps.internal.GaePendingResult;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes.dex */
public class GaeRequestHandler implements GeoApiContext.RequestHandler {
    private static final Logger LOG = LoggerFactory.m17025a(GaeRequestHandler.class.getName());
    private final URLFetchService client = URLFetchServiceFactory.getURLFetchService();

    GaeRequestHandler() {
    }

    @Override // com.google.maps.GeoApiContext.RequestHandler
    public <T, R extends ApiResponse<T>> PendingResult<T> handle(String str, String str2, String str3, Class<R> cls, FieldNamingPolicy fieldNamingPolicy, long j, Integer num, ExceptionsAllowedToRetry exceptionsAllowedToRetry) {
        try {
            return new GaePendingResult(new HTTPRequest(new URL(str + str2), HTTPMethod.POST, FetchOptions.Builder.withDeadline(10.0d)), this.client, cls, fieldNamingPolicy, j, num, exceptionsAllowedToRetry);
        } catch (MalformedURLException e) {
            LOG.mo17022a("Request: {}{}", str, str2, e);
            throw new RuntimeException(e);
        }
    }

    @Override // com.google.maps.GeoApiContext.RequestHandler
    public <T, R extends ApiResponse<T>> PendingResult<T> handlePost(String str, String str2, String str3, String str4, Class<R> cls, FieldNamingPolicy fieldNamingPolicy, long j, Integer num, ExceptionsAllowedToRetry exceptionsAllowedToRetry) {
        try {
            HTTPRequest hTTPRequest = new HTTPRequest(new URL(str + str2), HTTPMethod.POST, FetchOptions.Builder.withDeadline(10.0d));
            hTTPRequest.setHeader(new HTTPHeader("Content-Type", "application/json; charset=utf-8"));
            hTTPRequest.setPayload(str3.getBytes());
            return new GaePendingResult(hTTPRequest, this.client, cls, fieldNamingPolicy, j, num, exceptionsAllowedToRetry);
        } catch (MalformedURLException e) {
            LOG.mo17022a("Request: {}{}", str, str2, e);
            throw new RuntimeException(e);
        }
    }

    public static class Builder implements GeoApiContext.RequestHandler.Builder {
        @Override // com.google.maps.GeoApiContext.RequestHandler.Builder
        public void connectTimeout(long j, TimeUnit timeUnit) {
            throw new RuntimeException("connectTimeout not implemented for Google App Engine");
        }

        @Override // com.google.maps.GeoApiContext.RequestHandler.Builder
        public void readTimeout(long j, TimeUnit timeUnit) {
            throw new RuntimeException("readTimeout not implemented for Google App Engine");
        }

        @Override // com.google.maps.GeoApiContext.RequestHandler.Builder
        public void writeTimeout(long j, TimeUnit timeUnit) {
            throw new RuntimeException("writeTimeout not implemented for Google App Engine");
        }

        @Override // com.google.maps.GeoApiContext.RequestHandler.Builder
        public void queriesPerSecond(int i) {
            throw new RuntimeException("queriesPerSecond not implemented for Google App Engine");
        }

        @Override // com.google.maps.GeoApiContext.RequestHandler.Builder
        public void proxy(Proxy proxy) {
            throw new RuntimeException("setProxy not implemented for Google App Engine");
        }

        @Override // com.google.maps.GeoApiContext.RequestHandler.Builder
        public void proxyAuthentication(String str, String str2) {
            throw new RuntimeException("setProxyAuthentication not implemented for Google App Engine");
        }

        @Override // com.google.maps.GeoApiContext.RequestHandler.Builder
        public GeoApiContext.RequestHandler build() {
            return new GaeRequestHandler();
        }
    }
}
