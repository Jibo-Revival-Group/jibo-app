package com.crashlytics.android.core;

import android.os.Looper;
import io.fabric.sdk.android.Fabric;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

class CrashlyticsBackgroundWorker {
   private final ExecutorService a;

   public CrashlyticsBackgroundWorker(ExecutorService var1) {
      this.a = var1;
   }

   <T> T a(Callable<T> var1) {
      Object var2 = null;

      try {
         if (Looper.getMainLooper() == Looper.myLooper()) {
            var5 = this.a.submit(var1).get(4L, TimeUnit.SECONDS);
         } else {
            var5 = this.a.submit(var1).get();
         }
      } catch (RejectedExecutionException var3) {
         Fabric.h().a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
         var5 = var2;
      } catch (Exception var4) {
         Fabric.h().e("CrashlyticsCore", "Failed to execute task.", var4);
         var5 = var2;
      }

      return (T)var5;
   }

   Future<?> a(Runnable var1) {
      try {
         ExecutorService var3 = this.a;
         Runnable var2 = new Runnable(this, var1) {
            final Runnable a;
            final CrashlyticsBackgroundWorker b;

            {
               this.b = var1;
               this.a = var2x;
            }

            @Override
            public void run() {
               try {
                  this.a.run();
               } catch (Exception var2x) {
                  Fabric.h().e("CrashlyticsCore", "Failed to execute task.", var2x);
               }
            }
         };
         var5 = var3.submit(var2);
      } catch (RejectedExecutionException var4) {
         Fabric.h().a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
         var5 = null;
      }

      return var5;
   }

   <T> Future<T> b(Callable<T> var1) {
      try {
         ExecutorService var3 = this.a;
         Callable var2 = new Callable<T>(this, var1) {
            final Callable a;
            final CrashlyticsBackgroundWorker b;

            {
               this.b = var1;
               this.a = var2x;
            }

            @Override
            public T call() throws Exception {
               Object var1x;
               try {
                  var1x = this.a.call();
               } catch (Exception var2x) {
                  Fabric.h().e("CrashlyticsCore", "Failed to execute task.", var2x);
                  var1x = null;
               }

               return (T)var1x;
            }
         };
         var5 = var3.submit(var2);
      } catch (RejectedExecutionException var4) {
         Fabric.h().a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
         var5 = null;
      }

      return var5;
   }
}
