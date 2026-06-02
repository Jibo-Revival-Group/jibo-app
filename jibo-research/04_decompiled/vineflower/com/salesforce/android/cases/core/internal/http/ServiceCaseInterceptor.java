package com.salesforce.android.cases.core.internal.http;

import java.io.IOException;
import java.util.Locale;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ServiceCaseInterceptor implements Interceptor {
   private final long a;

   ServiceCaseInterceptor(long var1) {
      this.a = var1;
   }

   @Override
   public Response a(Interceptor.Chain var1) throws IOException {
      Request var2 = var1.a();
      Response var3;
      if (var2.a("force_caching") == null) {
         var3 = var1.a(var2);
      } else {
         var3 = var1.a(var2).i().a("Cache-Control", String.format(Locale.getDefault(), "max-age=%d, only-if-cached, max-stale=0", this.a)).a();
      }

      return var3;
   }
}
