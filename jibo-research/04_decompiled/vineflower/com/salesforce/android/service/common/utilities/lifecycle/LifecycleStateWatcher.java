package com.salesforce.android.service.common.utilities.lifecycle;

import android.os.Handler;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class LifecycleStateWatcher<S extends Enum<S> & LifecycleState<M>, M extends Enum<M> & LifecycleMetric> {
   protected final BlockingDeque<S> a = new LinkedBlockingDeque<>();
   protected final ServiceLogger b;
   private final Handler c;

   LifecycleStateWatcher(Handler var1, ServiceLogger var2) {
      this.c = var1;
      this.b = var2;
   }

   void a() {
      this.c.removeCallbacksAndMessages(null);
   }

   void a(S var1, LifecycleEvaluator<S, M> var2) {
      if (this.a.isEmpty() || this.a.getLast() != var1) {
         this.b.b("Adding state: {}.{} to the notification queue", var1.getClass().getSimpleName(), var1.name());
         this.a.add((S)var1);
         this.c.post(new Runnable(this, var2) {
            final LifecycleEvaluator a;
            final LifecycleStateWatcher b;

            {
               this.b = var1;
               this.a = var2x;
            }

            @Override
            public void run() {
               if (this.b.a.isEmpty()) {
                  this.b.b.d("State queue is empty.");
               } else {
                  Enum var1x = this.b.a.pop();
                  this.b.b.b("Processing state {}", var1x.name());
                  this.a.h((S)var1x);
               }
            }
         });
      }
   }

   public static class Builder<S extends Enum<S> & LifecycleState<M>, M extends Enum<M> & LifecycleMetric> {
      private Handler a;
      private ServiceLogger b;

      public LifecycleStateWatcher<S, M> a(Class<S> var1) {
         if (this.a == null) {
            this.a = new Handler();
         }

         if (this.b == null) {
            this.b = ServiceLogging.a(LifecycleStateWatcher.class, String.format("LifecycleStateWatcher:%s", var1.getSimpleName()));
         }

         return new LifecycleStateWatcher<>(this.a, this.b);
      }
   }
}
