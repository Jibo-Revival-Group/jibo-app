package com.salesforce.android.service.common.utilities.lifecycle;

import android.os.Handler;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;

public class LifecycleMetricWatcher<S extends Enum<S> & LifecycleState<M>, M extends Enum<M> & LifecycleMetric> {
   private final ServiceLogger a;
   private final Handler b;
   private boolean c;

   LifecycleMetricWatcher(Handler var1, ServiceLogger var2) {
      this.b = var1;
      this.a = var2;
   }

   void a(S var1, LifecycleEvaluator var2) {
      this.b.removeCallbacksAndMessages(null);

      for (Enum var5 : ((LifecycleState)var1).getMetrics()) {
         if (((LifecycleMetric)var5).getTimeoutMs() != null && ((LifecycleMetric)var5).getTimeoutMs() > 0) {
            this.a.b("Starting timeout for metric: {} on state: {}", var5.name(), var1.name());
            this.b.postDelayed(new Runnable(this, var2, var5) {
               final LifecycleEvaluator a;
               final Enum b;
               final LifecycleMetricWatcher c;

               {
                  this.c = var1;
                  this.a = var2x;
                  this.b = var3;
               }

               @Override
               public void run() {
                  if (!this.c.a() && !this.a.d((M)this.b)) {
                     this.c.a.b("Metric {} timed out after {} ms", this.b.name(), ((LifecycleMetric)this.b).getTimeoutMs());
                     this.a.g((M)this.b);
                     this.c.b();
                  }
               }
            }, ((LifecycleMetric)var5).getTimeoutMs().intValue());
         }
      }
   }

   boolean a() {
      return this.c;
   }

   void b() {
      this.b.removeCallbacksAndMessages(null);
      this.c = true;
   }

   public static class Builder<S extends Enum<S> & LifecycleState<M>, M extends Enum<M> & LifecycleMetric> {
      private Handler a;
      private ServiceLogger b;

      public LifecycleMetricWatcher<S, M> a(Class<S> var1) {
         if (this.a == null) {
            this.a = new Handler();
         }

         if (this.b == null) {
            this.b = ServiceLogging.a(LifecycleEvaluator.class, String.format("LifecycleMetricWatcher:%s", var1.getSimpleName()));
         }

         return new LifecycleMetricWatcher<>(this.a, this.b);
      }
   }
}
