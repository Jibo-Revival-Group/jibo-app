package com.salesforce.android.service.common.liveagentclient;

import android.content.Context;
import com.salesforce.android.service.common.liveagentclient.handler.CreateSessionHandler;
import com.salesforce.android.service.common.liveagentclient.handler.DeleteSessionHandler;
import com.salesforce.android.service.common.liveagentclient.handler.MessagesHandler;
import com.salesforce.android.service.common.liveagentclient.integrity.LiveAgentQueueRequestListener;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentMetric;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState;
import com.salesforce.android.service.common.liveagentclient.request.InternalLiveAgentRequestFactory;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequestFactory;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleEvaluator;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleListener;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.concurrent.atomic.AtomicInteger;

public class LiveAgentSession implements LiveAgentQueueRequestListener, LifecycleListener<LiveAgentState, LiveAgentMetric> {
   protected static final ServiceLogger a = ServiceLogging.a(LiveAgentSession.class);
   protected AtomicInteger b = new AtomicInteger();
   private final LiveAgentClient c;
   private final LifecycleEvaluator<LiveAgentState, LiveAgentMetric> d;
   private final SessionListenerNotifier e;
   private final MessagesHandler f;
   private final CreateSessionHandler g;
   private final DeleteSessionHandler h;

   LiveAgentSession(LiveAgentSession.Builder var1) {
      this.c = var1.a;
      this.e = var1.c;
      this.g = var1.d;
      this.f = var1.e;
      this.h = var1.f;
      this.d = var1.b.a(LiveAgentState.Deleting);
      this.d.a(this);
   }

   public LiveAgentSession a(SessionListener var1) {
      this.e.a(var1);
      return this;
   }

   @Override
   public <T> Async<T> a(LiveAgentRequest var1, Class<T> var2) {
      int var3 = this.b.incrementAndGet();
      a.b("Handling pending request #{}, {}", var3, var1.getClass().getSimpleName());
      return this.c.<T>a(var1, var2, var3).a(new Async.ErrorHandler(this) {
         final LiveAgentSession a;

         {
            this.a = var1;
         }

         @Override
         public void a(Async<?> var1, Throwable var2x) {
            this.a.b.decrementAndGet();
         }
      });
   }

   public void a() {
      this.d.b(LiveAgentMetric.Initiated).a();
   }

   public void a(int var1) {
      if (var1 > 0) {
         this.f.a(var1);
      }
   }

   public void a(LiveAgentMetric var1) {
      this.d.b().a();
   }

   public void a(LiveAgentState var1, LiveAgentState var2) {
      if (var1 == LiveAgentState.Connecting) {
         a.c("Creating LiveAgent Session...");
      } else if (var1 == LiveAgentState.LongPolling) {
         a.c("Starting LiveAgent heartbeat (Long polling, MessagesRequest)");
      } else if (var1 == LiveAgentState.Deleting) {
         a.c("Ending LiveAgent Session");
      } else if (var1 == LiveAgentState.Ended) {
         a.c("LiveAgent Session has ended");
      }

      this.e.a(var1, var2);
   }

   public LiveAgentSession b(SessionListener var1) {
      this.e.b(var1);
      return this;
   }

   public void b() {
      this.d.b().a();
   }

   public static class Builder {
      protected LiveAgentClient a;
      protected LifecycleEvaluator<LiveAgentState, LiveAgentMetric> b;
      protected SessionListenerNotifier c;
      protected CreateSessionHandler d;
      protected MessagesHandler e;
      protected DeleteSessionHandler f;
      protected LiveAgentRequestFactory g = new InternalLiveAgentRequestFactory();
      private Context h;

      public LiveAgentSession.Builder a(Context var1) {
         this.h = var1;
         return this;
      }

      public LiveAgentSession.Builder a(LiveAgentClient var1) {
         this.a = var1;
         return this;
      }

      public LiveAgentSession a() {
         Arguments.a((Context)this.h);
         Arguments.a(this.a);
         int var1 = this.h.getResources().getInteger(R.integer.salesforce_live_agent_message_retry_timeout_ms);
         if (this.b == null) {
            this.b = new LifecycleEvaluator.Builder<LiveAgentState, LiveAgentMetric>().a(LiveAgentState.class, LiveAgentMetric.class);
         }

         if (this.c == null) {
            this.c = new SessionListenerNotifier();
         }

         if (this.d == null) {
            this.d = new CreateSessionHandler(this.a, this.g, this.c, this.b);
         }

         if (this.e == null) {
            this.e = new MessagesHandler.Builder().a(this.a).a(this.g).a(this.c).a(this.b).a(var1).a();
         }

         if (this.f == null) {
            this.f = new DeleteSessionHandler(this.a, this.g, this.c, this.b);
         }

         return new LiveAgentSession(this);
      }
   }
}
