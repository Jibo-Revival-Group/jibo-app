package com.salesforce.android.service.common.utilities.threading;

import android.os.Handler;
import android.os.Looper;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.concurrent.atomic.AtomicInteger;

public class BackoffTimer implements HandlerManager {
   protected static final ServiceLogger a = ServiceLogging.a(BackoffTimer.class);
   protected boolean b = false;
   protected AtomicInteger c = new AtomicInteger();
   private final BackoffTimer.TimerRunnable d;
   private final Handler e;
   private final int f;
   private long g;

   protected BackoffTimer(BackoffTimer.Builder var1) {
      this.d = new BackoffTimer.TimerRunnable(var1.a, new BackoffTimer.OnTimerExecutedListener(this) {
         final BackoffTimer a;

         {
            this.a = var1;
         }

         @Override
         public void a() {
            this.a.c();
         }
      });
      this.f = var1.c;
      this.g = var1.b;
      this.e = var1.d;
   }

   @Override
   public void a() {
      if (!this.b) {
         this.b = true;
         this.c();
      }
   }

   @Override
   public void b() {
      if (this.b) {
         a.a("Cancelling the BackoffTimer.");
         this.e.removeCallbacks(this.d);
         this.b = false;
         this.c.set(0);
      }
   }

   protected void c() {
      if (this.b) {
         if (this.c.get() >= this.f) {
            a.d("BackoffTimer has exceeded the maximum number of attempts ({}). Stopping.", this.f);
            this.b();
         } else {
            a.b("Scheduling the BackoffTimer with a delay of {}ms", this.g);
            this.c.incrementAndGet();
            this.e.postDelayed(this.d, this.g);
            this.g *= 2L;
         }
      }
   }

   public static class Builder implements HandlerManager.Builder {
      protected HandlerManager.OnTimerElapsedListener a;
      protected long b = 1000L;
      protected int c = 10;
      protected Handler d;

      public BackoffTimer.Builder a(int var1) {
         this.c = var1;
         return this;
      }

      public BackoffTimer.Builder a(HandlerManager.OnTimerElapsedListener var1) {
         this.a = var1;
         return this;
      }

      public BackoffTimer a() {
         Arguments.a(this.a);
         if (this.d == null) {
            this.d = new Handler(Looper.myLooper());
         }

         return new BackoffTimer(this);
      }
   }

   protected interface OnTimerExecutedListener {
      void a();
   }

   private static class TimerRunnable implements Runnable {
      private final HandlerManager.OnTimerElapsedListener a;
      private final BackoffTimer.OnTimerExecutedListener b;

      TimerRunnable(HandlerManager.OnTimerElapsedListener var1, BackoffTimer.OnTimerExecutedListener var2) {
         this.a = var1;
         this.b = var2;
      }

      @Override
      public void run() {
         this.b.a();
         BackoffTimer.a.a("Notifying the OnTimerElapsedListener that the BackoffTimer has elapsed.");
         this.a.b();
      }
   }
}
