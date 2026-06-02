package com.crashlytics.android.answers;

import io.fabric.sdk.android.Fabric;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class BackgroundManager {
   final AtomicReference<ScheduledFuture<?>> a;
   boolean b;
   private final ScheduledExecutorService c;
   private final List<BackgroundManager.Listener> d = new ArrayList<>();
   private volatile boolean e = true;

   public BackgroundManager(ScheduledExecutorService var1) {
      this.a = new AtomicReference<>();
      this.b = true;
      this.c = var1;
   }

   private void c() {
      Iterator var1 = this.d.iterator();

      while (var1.hasNext()) {
         ((BackgroundManager.Listener)var1.next()).a();
      }
   }

   public void a() {
      this.b = false;
      ScheduledFuture var1 = this.a.getAndSet(null);
      if (var1 != null) {
         var1.cancel(false);
      }
   }

   public void a(BackgroundManager.Listener var1) {
      this.d.add(var1);
   }

   public void a(boolean var1) {
      this.e = var1;
   }

   public void b() {
      if (this.e && !this.b) {
         this.b = true;

         try {
            AtomicReference var2 = this.a;
            ScheduledExecutorService var1 = this.c;
            Runnable var3 = new Runnable(this) {
               final BackgroundManager a;

               {
                  this.a = var1;
               }

               @Override
               public void run() {
                  this.a.a.set(null);
                  this.a.c();
               }
            };
            var2.compareAndSet(null, var1.schedule(var3, 5000L, TimeUnit.MILLISECONDS));
         } catch (RejectedExecutionException var4) {
            Fabric.h().a("Answers", "Failed to schedule background detector", var4);
         }
      }
   }

   public interface Listener {
      void a();
   }
}
