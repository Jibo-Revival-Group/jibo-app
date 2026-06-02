package com.salesforce.android.service.common.http.okhttp;

import com.salesforce.android.service.common.http.HttpResponse;
import com.salesforce.android.service.common.http.HttpResponseBody;
import okhttp3.Response;

public class SalesforceOkHttpResponse implements HttpResponse {
   private final Response a;

   SalesforceOkHttpResponse(Response var1) {
      this.a = var1;
   }

   public static HttpResponse a(Response var0) {
      return new SalesforceOkHttpResponse(var0);
   }

   @Override
   public int a() {
      return this.a.c();
   }

   @Override
   public boolean b() {
      return this.a.d();
   }

   @Override
   public HttpResponseBody c() {
      return SalesforceOkHttpResponseBody.a(this.a.h());
   }

   @Override
   public void close() {
      this.a.close();
   }

   @Override
   public String toString() {
      return this.a.toString();
   }
}
