package com.salesforce.android.service.common.liveagentclient.integrity;

import android.content.Context;
import com.salesforce.android.service.common.liveagentclient.R;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.BackoffTimer;
import com.salesforce.android.service.common.utilities.threading.HandlerManager;
import com.salesforce.android.service.common.utilities.threading.Timer;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class LiveAgentQueue implements HandlerManager.OnTimerElapsedListener {
   protected static final ServiceLogger a = ServiceLogging.a(LiveAgentQueue.class);
   protected Queue<EnqueuedRequest> b = new LinkedBlockingQueue<>();
   private final HandlerManager c;
   private final EnqueuedRequest.Factory d;
   private LiveAgentQueueRequestListener e;
   private AtomicBoolean f = new AtomicBoolean();

   LiveAgentQueue(LiveAgentQueue.Builder var1) {
      this.c = var1.a.b(this).b();
      this.d = var1.b;
      this.e = var1.c;
   }

   public <T> Async<T> a(LiveAgentRequest var1, Class<T> var2) {
      a.b("Queuing: {}", var1.getClass().getSimpleName());
      EnqueuedRequest var3 = this.d.a(var1, var2);
      this.b.add(var3);
      this.d();
      return var3.c();
   }

   public void a() {
      a.c("Clearing LiveAgentQueue and cancelling {} queued requests.", this.b.size());
      this.c.b();
      Iterator var1 = this.b.iterator();

      while (var1.hasNext()) {
         ((EnqueuedRequest)var1.next()).e();
      }

      this.b.clear();
   }

   void a(EnqueuedRequest var1) {
      this.b.remove(var1);
      var1.c().a();
      a.a("Success in sending {}", var1);
      this.e();
   }

   public void a(LiveAgentQueueRequestListener var1) {
      this.e = var1;
      this.d();
   }

   @Override
   public void b() {
      this.e();
   }

   void b(EnqueuedRequest var1) {
      var1.d();
      a.d("Error occurred while sending {}. Scheduling another attempt.", var1);
      this.c.a();
   }

   public boolean c() {
      return this.f.get();
   }

   void d() {
      if (this.e != null && this.b.size() != 0 && !this.c()) {
         this.f.set(true);
         EnqueuedRequest var1 = this.b.element();
         this.e.a(var1.a(), var1.b()).a(new Async.CompletionHandler(this, var1) {
            final EnqueuedRequest a;
            final LiveAgentQueue b;

            {
               this.b = var1;
               this.a = var2;
            }

            @Override
            public void a(Async<?> var1) {
               this.b.a(this.a);
            }
         }).a(new Async.ErrorHandler(this, var1) {
            final EnqueuedRequest a;
            final LiveAgentQueue b;

            {
               this.b = var1;
               this.a = var2;
            }

            @Override
            public void a(Async<?> var1, Throwable var2) {
               this.b.b(this.a);
            }
         });
      }
   }

   void e() {
      this.f.set(false);
      this.d();
   }

   public static class Builder {
      protected HandlerManager.Builder a;
      protected EnqueuedRequest.Factory b;
      protected LiveAgentQueueRequestListener c;
      private Context d;
      private boolean e;
      private int f = 5;

      public LiveAgentQueue.Builder a(Context var1) {
         this.d = var1;
         return this;
      }

      public LiveAgentQueue.Builder a(boolean var1) {
         this.e = var1;
         return this;
      }

      public LiveAgentQueue a() {
         Arguments.a((Context)this.d);
         if (this.e && this.a == null) {
            this.a = new BackoffTimer.Builder().a(this.f);
         } else if (this.a == null) {
            long var1 = this.d.getResources().getInteger(R.integer.salesforce_live_agent_message_retry_timeout_ms);
            this.a = new Timer.Builder().a(var1);
         }

         if (this.b == null) {
            this.b = new EnqueuedRequest.Factory();
         }

         return new LiveAgentQueue(this);
      }
   }
}
