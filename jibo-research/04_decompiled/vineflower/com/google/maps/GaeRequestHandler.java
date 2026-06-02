package com.google.maps;

import com.google.appengine.api.urlfetch.FetchOptions;
import com.google.appengine.api.urlfetch.HTTPHeader;
import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;
import com.google.gson.FieldNamingPolicy;
import com.google.maps.internal.ApiResponse;
import com.google.maps.internal.ExceptionsAllowedToRetry;
import com.google.maps.internal.GaePendingResult;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GaeRequestHandler implements GeoApiContext.RequestHandler {
   private static final Logger LOG = LoggerFactory.a(GaeRequestHandler.class.getName());
   private final URLFetchService client = URLFetchServiceFactory.getURLFetchService();

   GaeRequestHandler() {
   }

   @Override
   public <T, R extends ApiResponse<T>> PendingResult<T> handle(
      String var1, String var2, String var3, Class<R> var4, FieldNamingPolicy var5, long var6, Integer var8, ExceptionsAllowedToRetry var9
   ) {
      FetchOptions var11 = com.google.appengine.api.urlfetch.FetchOptions.Builder.withDeadline(10.0);

      try {
         StringBuilder var13 = new StringBuilder();
         URL var10 = new URL(var13.append(var1).append(var2).toString());
         var14 = new HTTPRequest(var10, HTTPMethod.POST, var11);
      } catch (MalformedURLException var12) {
         LOG.a("Request: {}{}", var1, var2, var12);
         throw new RuntimeException(var12);
      }

      return new GaePendingResult<>(var14, this.client, var4, var5, var6, var8, var9);
   }

   @Override
   public <T, R extends ApiResponse<T>> PendingResult<T> handlePost(
      String var1, String var2, String var3, String var4, Class<R> var5, FieldNamingPolicy var6, long var7, Integer var9, ExceptionsAllowedToRetry var10
   ) {
      FetchOptions var13 = com.google.appengine.api.urlfetch.FetchOptions.Builder.withDeadline(10.0);

      try {
         StringBuilder var12 = new StringBuilder();
         URL var11 = new URL(var12.append(var1).append(var2).toString());
         var15 = new HTTPRequest(var11, HTTPMethod.POST, var13);
         HTTPHeader var16 = new HTTPHeader("Content-Type", "application/json; charset=utf-8");
         var15.setHeader(var16);
         var15.setPayload(var3.getBytes());
      } catch (MalformedURLException var14) {
         LOG.a("Request: {}{}", var1, var2, var14);
         throw new RuntimeException(var14);
      }

      return new GaePendingResult<>(var15, this.client, var5, var6, var7, var9, var10);
   }

   public static class Builder implements GeoApiContext.RequestHandler.Builder {
      @Override
      public GeoApiContext.RequestHandler build() {
         return new GaeRequestHandler();
      }

      @Override
      public void connectTimeout(long var1, TimeUnit var3) {
         throw new RuntimeException("connectTimeout not implemented for Google App Engine");
      }

      @Override
      public void proxy(Proxy var1) {
         throw new RuntimeException("setProxy not implemented for Google App Engine");
      }

      @Override
      public void proxyAuthentication(String var1, String var2) {
         throw new RuntimeException("setProxyAuthentication not implemented for Google App Engine");
      }

      @Override
      public void queriesPerSecond(int var1) {
         throw new RuntimeException("queriesPerSecond not implemented for Google App Engine");
      }

      @Override
      public void readTimeout(long var1, TimeUnit var3) {
         throw new RuntimeException("readTimeout not implemented for Google App Engine");
      }

      @Override
      public void writeTimeout(long var1, TimeUnit var3) {
         throw new RuntimeException("writeTimeout not implemented for Google App Engine");
      }
   }
}
