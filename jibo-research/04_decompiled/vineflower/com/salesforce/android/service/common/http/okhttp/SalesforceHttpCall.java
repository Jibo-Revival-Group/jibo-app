package com.salesforce.android.service.common.http.okhttp;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.salesforce.android.service.common.http.HttpCall;
import com.salesforce.android.service.common.http.HttpResponse;
import java.io.IOException;
import okhttp3.Call;

public class SalesforceHttpCall implements HttpCall {
   private final Call a;

   SalesforceHttpCall(Call var1) {
      this.a = var1;
   }

   public static HttpCall a(Call var0) {
      return new SalesforceHttpCall(var0);
   }

   @Override
   public HttpResponse a() throws IOException {
      return SalesforceOkHttpResponse.a(FirebasePerfOkHttpClient.execute(this.a));
   }
}
