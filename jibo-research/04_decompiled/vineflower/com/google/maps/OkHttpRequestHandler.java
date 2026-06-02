package com.google.maps;

import com.google.gson.FieldNamingPolicy;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OkHttpRequestHandler implements GeoApiContext.RequestHandler {
   private static final MediaType JSON = MediaType.a("application/json; charset=utf-8");
   private static final Logger LOG = LoggerFactory.a(OkHttpRequestHandler.class.getName());
   private final OkHttpClient client;

   OkHttpRequestHandler(OkHttpClient var1) {
      this.client = var1;
   }

   @Override
   public <T, R extends ApiResponse<T>> PendingResult<T> handle(
      String var1, String var2, String var3, Class<R> var4, FieldNamingPolicy var5, long var6, Integer var8, ExceptionsAllowedToRetry var9
   ) {
      return new OkHttpPendingResult<>(new Request.Builder().a().a("User-Agent", var3).a(var1 + var2).c(), this.client, var4, var5, var6, var8, var9);
   }

   @Override
   public <T, R extends ApiResponse<T>> PendingResult<T> handlePost(
      String var1, String var2, String var3, String var4, Class<R> var5, FieldNamingPolicy var6, long var7, Integer var9, ExceptionsAllowedToRetry var10
   ) {
      RequestBody var11 = RequestBody.a(JSON, var3);
      return new OkHttpPendingResult<>(new Request.Builder().a(var11).a("User-Agent", var4).a(var1 + var2).c(), this.client, var5, var6, var7, var9, var10);
   }

   public static class Builder implements GeoApiContext.RequestHandler.Builder {
      private final OkHttpClient.Builder builder = new OkHttpClient.Builder();
      private final Dispatcher dispatcher;
      private final RateLimitExecutorService rateLimitExecutorService = new RateLimitExecutorService();

      public Builder() {
         this.dispatcher = new Dispatcher(this.rateLimitExecutorService);
         this.builder.a(this.dispatcher);
      }

      @Override
      public GeoApiContext.RequestHandler build() {
         return new OkHttpRequestHandler(this.builder.a());
      }

      @Override
      public void connectTimeout(long var1, TimeUnit var3) {
         this.builder.a(var1, var3);
      }

      @Override
      public void proxy(Proxy var1) {
         this.builder.a(var1);
      }

      @Override
      public void proxyAuthentication(String var1, String var2) {
         this.builder.a(new Authenticator(this, var1, var2) {
            final OkHttpRequestHandler.Builder this$0;
            final String val$password;
            final String val$userName;

            {
               this.this$0 = var1;
               this.val$userName = var2x;
               this.val$password = var3;
            }

            @Override
            public Request authenticate(Route var1, Response var2x) throws IOException {
               String var3 = Credentials.a(this.val$userName, this.val$password);
               return var2x.a().e().a("Proxy-Authorization", var3).c();
            }
         });
      }

      @Override
      public void queriesPerSecond(int var1) {
         this.dispatcher.a(var1);
         this.dispatcher.b(var1);
         this.rateLimitExecutorService.setQueriesPerSecond(var1);
      }

      @Override
      public void readTimeout(long var1, TimeUnit var3) {
         this.builder.b(var1, var3);
      }

      @Override
      public void writeTimeout(long var1, TimeUnit var3) {
         this.builder.c(var1, var3);
      }
   }
}
