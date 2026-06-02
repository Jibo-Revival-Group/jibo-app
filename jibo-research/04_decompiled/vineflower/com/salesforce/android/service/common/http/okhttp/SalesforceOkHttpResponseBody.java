package com.salesforce.android.service.common.http.okhttp;

import com.salesforce.android.service.common.http.HttpResponseBody;
import java.io.IOException;
import java.io.Reader;
import okhttp3.ResponseBody;
import okio.BufferedSource;

public class SalesforceOkHttpResponseBody implements HttpResponseBody {
   private final ResponseBody a;

   SalesforceOkHttpResponseBody(ResponseBody var1) {
      this.a = var1;
   }

   public static HttpResponseBody a(ResponseBody var0) {
      return new SalesforceOkHttpResponseBody(var0);
   }

   @Override
   public BufferedSource a() {
      return this.a.c();
   }

   @Override
   public Reader b() {
      return this.a.e();
   }

   @Override
   public String c() throws IOException {
      return this.a.f();
   }

   @Override
   public void close() {
      this.a.close();
   }
}
