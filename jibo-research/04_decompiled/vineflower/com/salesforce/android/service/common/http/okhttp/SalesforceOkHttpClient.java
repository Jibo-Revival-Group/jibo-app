package com.salesforce.android.service.common.http.okhttp;

import com.salesforce.android.service.common.http.HttpCall;
import com.salesforce.android.service.common.http.HttpClient;
import com.salesforce.android.service.common.http.HttpClientBuilder;
import com.salesforce.android.service.common.http.HttpRequest;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

public class SalesforceOkHttpClient implements HttpClient {
   protected final OkHttpClient a;

   SalesforceOkHttpClient(OkHttpClient var1) {
      this.a = var1;
   }

   public static HttpClient a(OkHttpClient var0) {
      return new SalesforceOkHttpClient(var0);
   }

   public static HttpClientBuilder b() {
      return new SalesforceOkHttpClient.Builder();
   }

   @Override
   public HttpCall a(HttpRequest var1) {
      return SalesforceHttpCall.a(this.a.a(var1.b()));
   }

   @Override
   public HttpClientBuilder a() {
      return new SalesforceOkHttpClient.Builder(this);
   }

   public static class Builder implements HttpClientBuilder {
      protected final OkHttpClient.Builder a;

      public Builder() {
         this.a = new OkHttpClient.Builder();
      }

      protected Builder(SalesforceOkHttpClient var1) {
         this.a = var1.a.y();
      }

      @Override
      public HttpClient a() {
         return new SalesforceOkHttpClient(this.a.a());
      }

      @Override
      public HttpClientBuilder a(long var1, TimeUnit var3) {
         this.a.a(var1, var3);
         return this;
      }

      @Override
      public HttpClientBuilder a(List<ConnectionSpec> var1) {
         this.a.a(var1);
         return this;
      }

      @Override
      public HttpClientBuilder a(SSLSocketFactory var1, X509TrustManager var2) {
         this.a.a(var1, var2);
         return this;
      }

      @Override
      public HttpClientBuilder a(Cache var1) {
         this.a.a(var1);
         return this;
      }

      @Override
      public HttpClientBuilder a(Interceptor var1) {
         this.a.a(var1);
         return this;
      }

      @Override
      public HttpClientBuilder b(long var1, TimeUnit var3) {
         this.a.b(var1, var3);
         return this;
      }

      @Override
      public HttpClientBuilder b(Interceptor var1) {
         this.a.b(var1);
         return this;
      }
   }
}
