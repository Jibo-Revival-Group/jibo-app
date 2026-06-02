package io.fabric.sdk.android.services.common;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class ExecutorUtils {
   public static ExecutorService a(String var0) {
      ExecutorService var1 = Executors.newSingleThreadExecutor(c(var0));
      a(var0, var1);
      return var1;
   }

   private static final void a(String var0, ExecutorService var1) {
      a(var0, var1, 2L, TimeUnit.SECONDS);
   }

   public static final void a(String var0, ExecutorService var1, long var2, TimeUnit var4) {
      Runtime.getRuntime().addShutdownHook(new Thread(new BackgroundPriorityRunnable(var0, var1, var2, var4) {
         final String a;
         final ExecutorService b;
         final long c;
         final TimeUnit d;

         {
            this.a = var1;
            this.b = var2x;
            this.c = var3;
            this.d = var5;
         }

         @Override
         public void a() {
            try {
               Logger var2x = Fabric.h();
               StringBuilder var1x = new StringBuilder();
               var2x.a("Fabric", var1x.append("Executing shutdown hook for ").append(this.a).toString());
               this.b.shutdown();
               if (!this.b.awaitTermination(this.c, this.d)) {
                  var2x = Fabric.h();
                  var1x = new StringBuilder();
                  var2x.a("Fabric", var1x.append(this.a).append(" did not shut down in the allocated time. Requesting immediate shutdown.").toString());
                  this.b.shutdownNow();
               }
            } catch (InterruptedException var3) {
               Fabric.h().a("Fabric", String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", this.a));
               this.b.shutdownNow();
            }
         }
      }, "Crashlytics Shutdown Hook for " + var0));
   }

   public static ScheduledExecutorService b(String var0) {
      ScheduledExecutorService var1 = Executors.newSingleThreadScheduledExecutor(c(var0));
      a(var0, var1);
      return var1;
   }

   public static final ThreadFactory c(String var0) {
      return new ThreadFactory(var0, new AtomicLong(1L)) {
         final String a;
         final AtomicLong b;

         {
            this.a = var1;
            this.b = var2;
         }

         @Override
         public Thread newThread(Runnable var1) {
            var1 = Executors.defaultThreadFactory().newThread(new BackgroundPriorityRunnable(this, var1) {
               final Runnable a;
               final <unrepresentable> b;

               {
                  this.b = var1;
                  this.a = var2;
               }

               @Override
               public void a() {
                  this.a.run();
               }
            });
            var1.setName(this.a + this.b.getAndIncrement());
            return var1;
         }
      };
   }
}
