package com.salesforce.android.service.common.liveagentlogging.internal.service;

import android.content.Intent;
import android.os.IBinder;
import android.support.v4.util.ArraySet;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingConfiguration;
import com.salesforce.android.service.common.liveagentlogging.internal.InternalLiveAgentLoggingSession;
import com.salesforce.android.service.common.liveagentlogging.internal.PodConnectionManager;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.Iterator;
import java.util.Set;

class LiveAgentLoggingServiceDelegate {
   protected static final ServiceLogger a = ServiceLogging.a(LiveAgentLoggingService.class);
   protected Set<PodConnectionManager> b = new ArraySet<>();
   protected Set<InternalLiveAgentLoggingSession> c = new ArraySet<>();
   private final LiveAgentLoggingService d;
   private final LiveAgentLoggingServiceBinder.Builder e;
   private final PodConnectionManager.Builder f;
   private final InternalLiveAgentLoggingSession.Builder g;

   LiveAgentLoggingServiceDelegate(LiveAgentLoggingService var1) {
      this(var1, new LiveAgentLoggingServiceBinder.Builder(), new PodConnectionManager.Builder(), new InternalLiveAgentLoggingSession.Builder());
   }

   LiveAgentLoggingServiceDelegate(
      LiveAgentLoggingService var1, LiveAgentLoggingServiceBinder.Builder var2, PodConnectionManager.Builder var3, InternalLiveAgentLoggingSession.Builder var4
   ) {
      this.d = var1;
      this.e = var2;
      this.f = var3;
      this.g = var4;
   }

   private void b() {
      Iterator var1 = this.b.iterator();

      while (var1.hasNext()) {
         ((PodConnectionManager)var1.next()).b();
      }
   }

   public IBinder a(Intent var1) {
      a.b("LiveAgentLoggingService is starting");
      LiveAgentLoggingConfiguration var2 = (LiveAgentLoggingConfiguration)var1.getSerializableExtra(
         "com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingConfiguration"
      );
      Arguments.a(var2);
      PodConnectionManager var3 = this.f.a(this.d).a(var2).a();
      InternalLiveAgentLoggingSession var4 = this.g.a(this.d).a(var2).a(var3).a();
      this.b.add(var3);
      this.c.add(var4);
      return this.e.a(var4).a();
   }

   public void a() {
      this.b();

      for (InternalLiveAgentLoggingSession var2 : this.c) {
         var2.a().a(new Async.CompletionHandler(this, var2) {
            final InternalLiveAgentLoggingSession a;
            final LiveAgentLoggingServiceDelegate b;

            {
               this.b = var1;
               this.a = var2x;
            }

            @Override
            public void a(Async<?> var1) {
               this.a.c();
            }
         }).a(new Async.ErrorHandler(this, var2) {
            final InternalLiveAgentLoggingSession a;
            final LiveAgentLoggingServiceDelegate b;

            {
               this.b = var1;
               this.a = var2;
            }

            @Override
            public void a(Async<?> var1, Throwable var2x) {
               LiveAgentLoggingServiceDelegate.a.e("Error encountered while sending final logging events. {}", var2x.getMessage());
               this.a.c();
            }
         });
      }

      a.b("LiveAgentLoggingService has been destroyed");
   }
}
