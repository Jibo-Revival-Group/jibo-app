package com.salesforce.android.service.common.liveagentclient.handler;

import com.salesforce.android.service.common.liveagentclient.LiveAgentClient;
import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import com.salesforce.android.service.common.liveagentclient.SessionListener;
import com.salesforce.android.service.common.liveagentclient.SessionListenerNotifier;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentMetric;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequestFactory;
import com.salesforce.android.service.common.liveagentclient.response.MessagesResponse;
import com.salesforce.android.service.common.liveagentclient.response.message.AsyncResult;
import com.salesforce.android.service.common.liveagentclient.response.message.LiveAgentMessage;
import com.salesforce.android.service.common.liveagentclient.response.message.SwitchServerMessage;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleEvaluator;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.HandlerManager;
import com.salesforce.android.service.common.utilities.threading.Timer;

public class MessagesHandler implements SessionListener, Async.Handler<MessagesResponse>, HandlerManager.OnTimerElapsedListener {
   private static final ServiceLogger a = ServiceLogging.a(MessagesHandler.class);
   private final LiveAgentClient b;
   private final LiveAgentRequestFactory c;
   private final SessionListenerNotifier d;
   private final LifecycleEvaluator<LiveAgentState, LiveAgentMetric> e;
   private final int f;
   private final Timer g;
   private SessionInfo h;
   private boolean i;
   private int j;
   private int k;

   protected MessagesHandler(MessagesHandler.Builder var1) {
      this.b = var1.a;
      this.c = var1.b;
      this.d = var1.c.a(this);
      this.e = var1.d;
      this.f = var1.g;
      this.g = var1.e.a(this.f).a(this).a();
      this.j = var1.f;
   }

   void a() {
      if (this.h != null) {
         this.b.a(this.c.a(this.h), MessagesResponse.class, this.h.d()).b(this);
      }
   }

   public void a(int var1) {
      this.j = var1 / this.f;
   }

   @Override
   public void a(SessionInfo var1) {
      this.h = var1;
   }

   @Override
   public void a(LiveAgentState var1, LiveAgentState var2) {
      switch (<unrepresentable>.a[var1.ordinal()]) {
         case 1:
            this.a();
            break;
         case 2:
            this.h = null;
      }
   }

   void a(AsyncResult var1) {
      if (var1.a() && this.i) {
         a.e("LiveAgent session has encountered an error while creating a session - {}", var1.b());
         this.e.b().a();
         this.d.a(new Exception(var1.b()));
      }
   }

   void a(SwitchServerMessage var1) {
      String var2 = var1.b();
      if (var2 == null) {
         a.d("Failed to switch to a different LiveAgent Server: Address is null.");
         this.e.b().a();
      } else {
         a.a("Switching to a different LiveAgent Server: {}" + var1.a());
         this.b.a(var2);
         this.e.c(LiveAgentMetric.ConnectionEstablished).a();
      }
   }

   @Override
   public void a(Async<?> var1) {
      this.k = 0;
      this.a();
   }

   public void a(Async<?> var1, MessagesResponse var2) {
      a.a("LiveAgent heartbeat response (MessagesResponse) has been received");

      for (LiveAgentMessage var4 : var2.a()) {
         if (var4.a().equals("SwitchServer")) {
            this.a(var4.a(SwitchServerMessage.class));
         } else if (var4.a().equals("AsyncResult")) {
            this.a(var4.a(AsyncResult.class));
         }
      }

      this.d.a(var2);
   }

   @Override
   public void a(Async<?> var1, Throwable var2) {
      if (this.e.e() == LiveAgentState.LongPolling) {
         this.k++;
         if (this.k > this.j) {
            a.e("LiveAgent session has encountered an unrecoverable error while retrieving messages - {}", var2);
            this.e.b().a();
            this.d.a(var2);
         } else {
            a.d("LiveAgent session is attempting to reconnect. Retry #{} of {}", this.k, this.j);
            this.g.a();
         }
      }
   }

   @Override
   public void a(Throwable var1) {
   }

   @Override
   public void b() {
      this.a();
   }

   public static class Builder {
      protected LiveAgentClient a;
      protected LiveAgentRequestFactory b;
      protected SessionListenerNotifier c;
      protected LifecycleEvaluator<LiveAgentState, LiveAgentMetric> d;
      protected Timer.Builder e;
      protected int f = 20;
      protected int g = 2000;

      public MessagesHandler.Builder a(int var1) {
         this.g = var1;
         return this;
      }

      public MessagesHandler.Builder a(LiveAgentClient var1) {
         this.a = var1;
         return this;
      }

      public MessagesHandler.Builder a(SessionListenerNotifier var1) {
         this.c = var1;
         return this;
      }

      public MessagesHandler.Builder a(LiveAgentRequestFactory var1) {
         this.b = var1;
         return this;
      }

      public MessagesHandler.Builder a(LifecycleEvaluator<LiveAgentState, LiveAgentMetric> var1) {
         this.d = var1;
         return this;
      }

      public MessagesHandler a() {
         if (this.e == null) {
            this.e = new Timer.Builder();
         }

         return new MessagesHandler(this);
      }
   }
}
