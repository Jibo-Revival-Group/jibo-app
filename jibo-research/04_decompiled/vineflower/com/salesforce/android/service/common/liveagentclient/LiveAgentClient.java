package com.salesforce.android.service.common.liveagentclient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.salesforce.android.service.common.http.HttpClient;
import com.salesforce.android.service.common.http.HttpFactory;
import com.salesforce.android.service.common.http.HttpJob;
import com.salesforce.android.service.common.http.HttpRequest;
import com.salesforce.android.service.common.http.TlsSocketFactory;
import com.salesforce.android.service.common.liveagentclient.json.GsonFactory;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.JobQueue;
import com.salesforce.android.service.common.utilities.threading.PriorityThreadFactory;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionSpec;
import okhttp3.TlsVersion;

public class LiveAgentClient {
   private static final ServiceLogger b = ServiceLogging.a(LiveAgentClient.class);
   String a;
   private final JobQueue c;
   private final HttpClient d;
   private final Gson e;

   protected LiveAgentClient(LiveAgentClient.Builder var1) {
      b.a("Initializing LiveAgentClient for pod {}", var1.a);
      this.a = var1.a;
      this.d = var1.c;
      this.c = var1.b;
      this.e = var1.d;
   }

   public <T> Async<T> a(LiveAgentRequest var1, Class<T> var2) {
      return this.a(var1, var2, this.d, 0);
   }

   public <T> Async<T> a(LiveAgentRequest var1, Class<T> var2, int var3) {
      return this.a(var1, var2, this.d, var3);
   }

   public <T> Async<T> a(LiveAgentRequest var1, Class<T> var2, long var3) {
      return this.a(var1, var2, this.d.a().b(var3, TimeUnit.MILLISECONDS).a(), 0);
   }

   <T> Async<T> a(LiveAgentRequest var1, Class<T> var2, HttpClient var3, int var4) {
      if (var4 > 0) {
         b.a("Sending #{} {} to LiveAgent: URL[{}] - Body[{}]", var4, var1.getClass().getSimpleName(), var1.a(this.a), var1.a(this.e));
      } else {
         b.a("Sending {} to LiveAgent: URL[{}] - Body[{}]", var1.getClass().getSimpleName(), var1.a(this.a), var1.a(this.e));
      }

      HttpRequest var5 = var1.a(this.a, this.e, var4);
      return this.c.a(HttpJob.a(var3, var5, var2, this.e));
   }

   public void a(String var1) {
      b.a("Updating LiveAgentClient pod: {} --> {}", this.a, var1);
      this.a = var1;
   }

   public static class Builder {
      protected String a;
      protected JobQueue b;
      protected HttpClient c;
      protected Gson d;
      private LiveAgentMessageRegistry e;
      private boolean f = false;
      private GsonBuilder g;

      public LiveAgentClient.Builder a(GsonBuilder var1) {
         this.g = var1;
         return this;
      }

      public LiveAgentClient.Builder a(String var1) {
         this.a = var1;
         return this;
      }

      public LiveAgentClient a() throws NoSuchAlgorithmException, KeyManagementException {
         Arguments.a(this.a);
         if (this.b == null) {
            this.b = new JobQueue(Executors.newFixedThreadPool(2, PriorityThreadFactory.a()));
         }

         if (this.c == null) {
            ConnectionSpec var1 = new ConnectionSpec.Builder(ConnectionSpec.a).a(TlsVersion.TLS_1_2).a();
            this.c = HttpFactory.a().a(Arrays.asList(var1, ConnectionSpec.c)).a(new TlsSocketFactory(), TlsSocketFactory.a()).a();
         }

         if (this.e == null) {
            this.e = new LiveAgentMessageRegistry();
         }

         if (this.g == null) {
            this.g = new GsonBuilder();
         }

         this.d = GsonFactory.a(this.g, this.e, this.f);
         return new LiveAgentClient(this);
      }
   }
}
