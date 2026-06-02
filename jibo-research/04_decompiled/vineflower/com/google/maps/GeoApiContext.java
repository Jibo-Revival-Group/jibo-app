package com.google.maps;

import com.google.gson.FieldNamingPolicy;
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
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

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
   private final GeoApiContext.RequestHandler requestHandler;
   private final UrlSigner urlSigner;

   GeoApiContext(
      GeoApiContext.RequestHandler var1,
      String var2,
      String var3,
      String var4,
      String var5,
      long var6,
      ExceptionsAllowedToRetry var8,
      Integer var9,
      UrlSigner var10
   ) {
      this.requestHandler = var1;
      this.apiKey = var2;
      this.baseUrlOverride = var3;
      this.channel = var4;
      this.clientId = var5;
      this.errorTimeout = var6;
      this.exceptionsAllowedToRetry = var8;
      this.maxRetries = var9;
      this.urlSigner = var10;
   }

   private void checkContext(boolean var1) {
      if (this.urlSigner == null && this.apiKey == null) {
         throw new IllegalStateException("Must provide either API key or Maps for Work credentials.");
      }

      if (!var1 && this.apiKey == null) {
         throw new IllegalStateException("API does not support client ID & secret - you must provide a key");
      }

      if (this.urlSigner == null && !this.apiKey.startsWith("AIza")) {
         throw new IllegalStateException("Invalid API key.");
      }
   }

   private <T, R extends ApiResponse<T>> PendingResult<T> getWithPath(
      Class<R> var1, FieldNamingPolicy var2, String var3, String var4, boolean var5, String var6
   ) {
      this.checkContext(var5);
      if (!var6.startsWith("&")) {
         throw new IllegalArgumentException("encodedPath must start with &");
      }

      StringBuilder var7 = new StringBuilder(var4);
      if (var5 && this.clientId != null) {
         var7.append("?client=").append(this.clientId);
      } else {
         var7.append("?key=").append(this.apiKey);
      }

      var7.append(var6);
      if (var5 && this.urlSigner != null) {
         var6 = this.urlSigner.getSignature(var7.toString());
         var7.append("&signature=").append(var6);
      }

      if (this.baseUrlOverride != null) {
         var3 = this.baseUrlOverride;
      }

      return this.requestHandler
         .handle(var3, var7.toString(), "GoogleGeoApiClientJava/0.2.3-SNAPSHOT", var1, var2, this.errorTimeout, this.maxRetries, this.exceptionsAllowedToRetry);
   }

   <T, R extends ApiResponse<T>> PendingResult<T> get(ApiConfig var1, Class<? extends R> var2, Map<String, String> var3) {
      if (this.channel != null && !this.channel.isEmpty() && !var3.containsKey("channel")) {
         var3.put("channel", this.channel);
      }

      StringBuilder var4 = new StringBuilder();

      for (Entry var5 : var3.entrySet()) {
         var4.append('&').append((String)var5.getKey()).append("=");

         try {
            var4.append(URLEncoder.encode((String)var5.getValue(), "UTF-8"));
         } catch (UnsupportedEncodingException var6) {
            throw new IllegalStateException(var6);
         }
      }

      return this.getWithPath(var2, var1.fieldNamingPolicy, var1.hostName, var1.path, var1.supportsClientId, var4.toString());
   }

   <T, R extends ApiResponse<T>> PendingResult<T> get(ApiConfig var1, Class<? extends R> var2, String... var3) {
      int var5 = 0;
      if (var3.length % 2 != 0) {
         throw new IllegalArgumentException("Params must be matching key/value pairs.");
      }

      StringBuilder var6 = new StringBuilder();
      boolean var4 = false;

      while (var5 < var3.length) {
         if (var3[var5].equals("channel")) {
            var4 = true;
         }

         var6.append('&').append(var3[var5]).append('=');
         var5++;

         try {
            var6.append(URLEncoder.encode(var3[var5], "UTF-8"));
         } catch (UnsupportedEncodingException var7) {
            throw new IllegalStateException(var7);
         }

         var5++;
      }

      if (!var4 && this.channel != null && !this.channel.isEmpty()) {
         var6.append("&channel=").append(this.channel);
      }

      return this.getWithPath(var2, var1.fieldNamingPolicy, var1.hostName, var1.path, var1.supportsClientId, var6.toString());
   }

   <T, R extends ApiResponse<T>> PendingResult<T> post(ApiConfig var1, Class<? extends R> var2, Map<String, String> var3) {
      this.checkContext(var1.supportsClientId);
      StringBuilder var5 = new StringBuilder(var1.path);
      if (var1.supportsClientId && this.clientId != null) {
         var5.append("?client=").append(this.clientId);
      } else {
         var5.append("?key=").append(this.apiKey);
      }

      if (var1.supportsClientId && this.urlSigner != null) {
         String var4 = this.urlSigner.getSignature(var5.toString());
         var5.append("&signature=").append(var4);
      }

      String var6 = var1.hostName;
      if (this.baseUrlOverride != null) {
         var6 = this.baseUrlOverride;
      }

      return this.requestHandler
         .handlePost(
            var6,
            var5.toString(),
            (String)var3.get("_payload"),
            "GoogleGeoApiClientJava/0.2.3-SNAPSHOT",
            var2,
            var1.fieldNamingPolicy,
            this.errorTimeout,
            this.maxRetries,
            this.exceptionsAllowedToRetry
         );
   }

   public static class Builder {
      private String apiKey;
      private String baseUrlOverride;
      private GeoApiContext.RequestHandler.Builder builder;
      private String channel;
      private String clientId;
      private long errorTimeout = 60000L;
      private ExceptionsAllowedToRetry exceptionsAllowedToRetry = new ExceptionsAllowedToRetry();
      private Integer maxRetries;
      private UrlSigner urlSigner;

      public Builder() {
         this.requestHandlerBuilder(new OkHttpRequestHandler.Builder());
      }

      public Builder(GeoApiContext.RequestHandler.Builder var1) {
         this.requestHandlerBuilder(var1);
      }

      public GeoApiContext.Builder apiKey(String var1) {
         this.apiKey = var1;
         return this;
      }

      GeoApiContext.Builder baseUrlForTesting(String var1) {
         this.baseUrlOverride = var1;
         return this;
      }

      public GeoApiContext build() {
         return new GeoApiContext(
            this.builder.build(),
            this.apiKey,
            this.baseUrlOverride,
            this.channel,
            this.clientId,
            this.errorTimeout,
            this.exceptionsAllowedToRetry,
            this.maxRetries,
            this.urlSigner
         );
      }

      public GeoApiContext.Builder channel(String var1) {
         this.channel = var1;
         return this;
      }

      public GeoApiContext.Builder connectTimeout(long var1, TimeUnit var3) {
         this.builder.connectTimeout(var1, var3);
         return this;
      }

      public GeoApiContext.Builder disableRetries() {
         this.maxRetries(0);
         this.retryTimeout(0L, TimeUnit.MILLISECONDS);
         return this;
      }

      public GeoApiContext.Builder enterpriseCredentials(String var1, String var2) {
         this.clientId = var1;

         try {
            UrlSigner var6 = new UrlSigner(var2);
            this.urlSigner = var6;
            return this;
         } catch (NoSuchAlgorithmException var3) {
            var5 = var3;
         } catch (InvalidKeyException var4) {
            var5 = var4;
         }

         throw new IllegalStateException(var5);
      }

      public GeoApiContext.Builder maxRetries(Integer var1) {
         this.maxRetries = var1;
         return this;
      }

      public GeoApiContext.Builder proxy(Proxy var1) {
         GeoApiContext.RequestHandler.Builder var3 = this.builder;
         Proxy var2 = var1;
         if (var1 == null) {
            var2 = Proxy.NO_PROXY;
         }

         var3.proxy(var2);
         return this;
      }

      public GeoApiContext.Builder proxyAuthentication(String var1, String var2) {
         this.builder.proxyAuthentication(var1, var2);
         return this;
      }

      public GeoApiContext.Builder queryRateLimit(int var1) {
         this.builder.queriesPerSecond(var1);
         return this;
      }

      public GeoApiContext.Builder readTimeout(long var1, TimeUnit var3) {
         this.builder.readTimeout(var1, var3);
         return this;
      }

      public GeoApiContext.Builder requestHandlerBuilder(GeoApiContext.RequestHandler.Builder var1) {
         this.builder = var1;
         this.exceptionsAllowedToRetry.add(OverQueryLimitException.class);
         return this;
      }

      public GeoApiContext.Builder retryTimeout(long var1, TimeUnit var3) {
         this.errorTimeout = var3.toMillis(var1);
         return this;
      }

      public GeoApiContext.Builder setIfExceptionIsAllowedToRetry(Class<? extends ApiException> var1, boolean var2) {
         if (var2) {
            this.exceptionsAllowedToRetry.add(var1);
         } else {
            this.exceptionsAllowedToRetry.remove(var1);
         }

         return this;
      }

      public GeoApiContext.Builder writeTimeout(long var1, TimeUnit var3) {
         this.builder.writeTimeout(var1, var3);
         return this;
      }
   }

   public interface RequestHandler {
      <T, R extends ApiResponse<T>> PendingResult<T> handle(
         String var1, String var2, String var3, Class<R> var4, FieldNamingPolicy var5, long var6, Integer var8, ExceptionsAllowedToRetry var9
      );

      <T, R extends ApiResponse<T>> PendingResult<T> handlePost(
         String var1, String var2, String var3, String var4, Class<R> var5, FieldNamingPolicy var6, long var7, Integer var9, ExceptionsAllowedToRetry var10
      );

      interface Builder {
         GeoApiContext.RequestHandler build();

         void connectTimeout(long var1, TimeUnit var3);

         void proxy(Proxy var1);

         void proxyAuthentication(String var1, String var2);

         void queriesPerSecond(int var1);

         void readTimeout(long var1, TimeUnit var3);

         void writeTimeout(long var1, TimeUnit var3);
      }
   }
}
