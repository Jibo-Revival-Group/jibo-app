package com.salesforce.android.service.common.http.okhttp;

import com.salesforce.android.service.common.http.HttpRequest;
import com.salesforce.android.service.common.http.HttpRequestBuilder;
import com.salesforce.android.service.common.http.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;

public class SalesforceOkHttpRequest implements HttpRequest {
   protected Request a;

   SalesforceOkHttpRequest(SalesforceOkHttpRequest.Builder var1) {
      this.a = var1.a.c();
   }

   SalesforceOkHttpRequest(Request var1) {
      this.a = var1;
   }

   public static HttpRequest a(Request var0) {
      return new SalesforceOkHttpRequest(var0);
   }

   public static HttpRequestBuilder c() {
      return new SalesforceOkHttpRequest.Builder();
   }

   @Override
   public HttpUrl a() {
      return SalesforceHttpUrl.a(this.a.a());
   }

   @Override
   public Request b() {
      return this.a;
   }

   @Override
   public String toString() {
      return this.a.toString();
   }

   public static class Builder implements HttpRequestBuilder {
      protected final Request.Builder a = new Request.Builder();

      @Override
      public HttpRequestBuilder a() {
         this.a.a();
         return this;
      }

      @Override
      public HttpRequestBuilder a(String var1) {
         this.a.a(var1);
         return this;
      }

      @Override
      public HttpRequestBuilder a(String var1, String var2) {
         this.a.b(var1, var2);
         return this;
      }

      @Override
      public HttpRequestBuilder a(okhttp3.HttpUrl var1) {
         this.a.a(var1);
         return this;
      }

      @Override
      public HttpRequestBuilder a(RequestBody var1) {
         this.a.a(var1);
         return this;
      }

      @Override
      public HttpRequestBuilder b() {
         this.a.b();
         return this;
      }

      @Override
      public HttpRequest c() {
         return new SalesforceOkHttpRequest(this);
      }
   }
}
