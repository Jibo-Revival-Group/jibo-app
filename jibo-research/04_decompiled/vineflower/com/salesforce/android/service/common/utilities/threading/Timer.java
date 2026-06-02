package com.salesforce.android.service.common.utilities.threading;

import android.os.Handler;
import android.os.Looper;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class Timer implements HandlerManager {
   protected static final ServiceLogger a = ServiceLogging.a(Timer.class);
   protected boolean b = false;
   private final Timer.TimerRunnable c;
   private final long d;
   private final Handler e;

   protected Timer(Timer.Builder var1) {
      this.c = new Timer.TimerRunnable(var1.a, new Timer.OnTimerExecutedListener(this) {
         final Timer a;

         {
            this.a = var1;
         }

         @Override
         public void a() {
            this.a.b = false;
         }
      });
      this.d = var1.b;
      this.e = var1.c;
   }

   @Override
   public void a() {
      if (!this.b) {
         a.b("Scheduling the timer with a delay of {}ms", this.d);
         this.e.postDelayed(this.c, this.d);
         this.b = true;
      }
   }

   @Override
   public void b() {
      if (this.b) {
         a.b("Cancelling the timer.");
         this.e.removeCallbacks(this.c);
         this.b = false;
      }
   }

   public static class Builder implements HandlerManager.Builder {
      protected HandlerManager.OnTimerElapsedListener a;
      protected long b = 15000L;
      protected Handler c;

      public Timer.Builder a(long var1) {
         this.b = var1;
         return this;
      }

      public Timer.Builder a(HandlerManager.OnTimerElapsedListener var1) {
         this.a = var1;
         return this;
      }

      public Timer a() {
         Arguments.a(this.a);
         if (this.c == null) {
            this.c = new Handler(Looper.myLooper());
         }

         return new Timer(this);
      }
   }

   protected interface OnTimerExecutedListener {
      void a();
   }

   private static class TimerRunnable implements Runnable {
      private final HandlerManager.OnTimerElapsedListener a;
      private final Timer.OnTimerExecutedListener b;

      TimerRunnable(HandlerManager.OnTimerElapsedListener var1, Timer.OnTimerExecutedListener var2) {
         this.a = var1;
         this.b = var2;
      }

      @Override
      public void run() {
         this.b.a();
         Timer.a.a("Notifying the OnTimerElapsedListener that the timer has elapsed.");
         this.a.b();
      }
   }
}
