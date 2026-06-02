package com.salesforce.android.service.common.liveagentlogging.internal;

import android.content.Context;
import android.support.v4.util.ArraySet;
import com.google.gson.GsonBuilder;
import com.salesforce.android.service.common.liveagentclient.LiveAgentClient;
import com.salesforce.android.service.common.liveagentclient.LiveAgentSession;
import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import com.salesforce.android.service.common.liveagentclient.SessionListener;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingConfiguration;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.salesforce.android.service.common.liveagentlogging.internal.json.BaseEventSerializer;
import com.salesforce.android.service.common.liveagentlogging.internal.json.BatchedEventsSerializer;
import com.salesforce.android.service.common.liveagentlogging.internal.request.BatchedEvents;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectionInfo;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectivityState;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectivityTracker;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.Set;

public class PodConnectionManager implements SessionListener, ConnectivityTracker.Listener {
   private static final ServiceLogger a = ServiceLogging.a(PodConnectionManager.class);
   private final PodProvider b;
   private final LiveAgentClient.Builder c;
   private final LiveAgentSession.Builder d;
   private final ConnectivityTracker e;
   private final GsonBuilder f;
   private Set<PodConnectionManager.Listener> g = new ArraySet<>();
   private LiveAgentSession h;
   private SessionInfo i;
   private String j;

   protected PodConnectionManager(PodConnectionManager.Builder var1) {
      this.b = var1.c;
      this.c = var1.d;
      this.d = var1.e;
      this.e = var1.f.a(this).a();
      this.f = var1.g;
      this.d();
   }

   private LiveAgentSession a(String var1) throws GeneralSecurityException {
      LiveAgentClient var2 = this.c.a(var1).a(this.f).a();
      this.h = this.d.a(var2).a();
      this.h.a(this);
      this.h.a();
      return this.h;
   }

   private void a(LiveAgentSession var1, SessionInfo var2) {
      Iterator var3 = this.g.iterator();

      while (var3.hasNext()) {
         ((PodConnectionManager.Listener)var3.next()).a(var1, var2);
      }
   }

   private void d() {
      if (this.e.a() != ConnectivityState.CONNECTED) {
         a.c("Unable to connect to a LiveAgent Logging pod because the network is not connected. Waiting for network to be restored...");
      } else {
         try {
            this.j = this.b.a();
            a.c("Attempting to create a LiveAgent Logging session on pod {}", this.j);
            this.h = this.a(this.j);
         } catch (AllPodsUnavailableException var2) {
            a.e("Unable to connect to any LiveAgent pod for Logging. Logging has failed.");
            this.e();
         } catch (GeneralSecurityException var3) {
            a.d("Unable to connect to the LiveAgent pod {} for Logging. Trying another pod.\n{}", this.j, var3.getMessage());
            this.b.a(this.j);
            this.d();
         }
      }
   }

   private void e() {
      Iterator var1 = this.g.iterator();

      while (var1.hasNext()) {
         ((PodConnectionManager.Listener)var1.next()).d();
      }
   }

   public PodConnectionManager a(PodConnectionManager.Listener var1) {
      this.g.add(var1);
      return this;
   }

   @Override
   public void a(SessionInfo var1) {
      this.i = var1;
      this.a(this.h, this.i);
   }

   @Override
   public void a(LiveAgentState var1, LiveAgentState var2) {
      if (var1 == LiveAgentState.Ended && this.h != null) {
         this.h.b(this);
      }
   }

   @Override
   public void a(ConnectionInfo var1, ConnectivityState var2, ConnectivityState var3) {
      if (!this.a() && var2 == ConnectivityState.CONNECTED) {
         a.a("Network connection has been restored. Retrying LiveAgent Logging connection.");
         this.d();
      }
   }

   @Override
   public void a(Throwable var1) {
      ServiceLogger var3 = a;
      String var4 = this.j;
      String var2;
      if (this.i != null) {
         var2 = this.i.a();
      } else {
         var2 = "UNKNOWN";
      }

      var3.e("Error encountered during LiveAgent Logging session [Pod - {}, LiveAgent Session ID - {}]\n{}", var4, var2, var1.getMessage());
      if (this.h != null) {
         this.h.b();
      }

      this.d();
   }

   public boolean a() {
      boolean var1;
      if (this.h != null && this.i != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public PodConnectionManager b(PodConnectionManager.Listener var1) {
      this.g.remove(var1);
      return this;
   }

   public void b() {
      this.e.c();
   }

   public void c() {
      if (this.h != null) {
         this.h.b();
      }
   }

   public static class Builder {
      protected Context a;
      protected LiveAgentLoggingConfiguration b;
      protected PodProvider c;
      protected LiveAgentClient.Builder d;
      protected LiveAgentSession.Builder e;
      protected ConnectivityTracker.Builder f;
      protected GsonBuilder g;

      public PodConnectionManager.Builder a(Context var1) {
         this.a = var1;
         return this;
      }

      public PodConnectionManager.Builder a(LiveAgentLoggingConfiguration var1) {
         this.b = var1;
         return this;
      }

      public PodConnectionManager a() {
         Arguments.a((Context)this.a);
         Arguments.a(this.b);
         if (this.c == null) {
            this.c = new PodProvider.Builder().a(this.b.a()).a();
         }

         if (this.d == null) {
            this.d = new LiveAgentClient.Builder();
         }

         if (this.e == null) {
            this.e = new LiveAgentSession.Builder().a(this.a);
         }

         if (this.f == null) {
            this.f = new ConnectivityTracker.Builder();
         }

         if (this.g == null) {
            BaseEventSerializer var1 = new BaseEventSerializer();
            this.g = new GsonBuilder().a(BaseEvent.class, var1).a(BatchedEvents.class, new BatchedEventsSerializer()).a("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
         }

         this.f.a(this.a);
         return new PodConnectionManager(this);
      }
   }

   interface Listener {
      void a(LiveAgentSession var1, SessionInfo var2);

      void d();
   }
}
