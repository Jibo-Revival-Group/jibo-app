package com.salesforce.android.cases.core.internal.http;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.google.gson.Gson;
import com.salesforce.android.service.common.utilities.control.ResultReceiver;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.Job;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.rest.ClientManager;
import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;

class AuthenticatedHttpJob<T> implements Job<T> {
   private static final ServiceLogger a = ServiceLogging.a(AuthenticatedHttpJob.class);
   private final ClientManager b;
   private final UserAccount c;
   private final Request d;
   private final Class<T> e;
   private final Gson f;

   private AuthenticatedHttpJob(ClientManager var1, UserAccount var2, Request var3, Class<T> var4, Gson var5) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.e = var4;
      this.f = var5;
   }

   public static <T> AuthenticatedHttpJob<T> a(ClientManager var0, UserAccount var1, Request var2, Class<T> var3, Gson var4) {
      return new AuthenticatedHttpJob<>(var0, var1, var2, var3, var4);
   }

   @Override
   public void a(ResultReceiver<T> var1) {
      a.a("Submitting http request to {}", this.d.a());

      try {
         Response var2 = FirebasePerfOkHttpClient.execute(this.b.a(this.c).d().a(this.d));
         if (!var2.d()) {
            a.d("Unsuccessful HTTP request: {}", var2);
            StringBuilder var3 = new StringBuilder();
            IOException var4 = new IOException(var3.append("Unsuccessful HTTP request: ").append(var2).toString());
            var1.b(var4);
         } else {
            var1.b(this.f.a(var2.h().e(), this.e));
            var1.b();
         }
      } catch (Exception var5) {
         a.d("Encountered Exception during HTTP request {}", var5);
         var1.b(var5);
      }
   }
}
