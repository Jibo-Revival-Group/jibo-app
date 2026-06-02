package com.salesforce.android.service.common.utilities.internal.android;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class BackgroundTracker implements ActivityTracker.OnResumeListener, ActivityTracker.OnStopListener {
   private final ActivityTracker a;
   private final Handler b;
   private final Set<BackgroundTracker.Listener> c = Collections.newSetFromMap(new ConcurrentHashMap<>());
   private boolean d = false;

   BackgroundTracker(ActivityTracker var1, Handler var2) {
      this.a = var1;
      this.b = var2;
   }

   public static BackgroundTracker a(ActivityTracker var0) {
      return new BackgroundTracker(var0, new Handler(Looper.getMainLooper()));
   }

   private void a(boolean var1) {
      if (this.d != var1) {
         this.d = var1;
         Iterator var2 = this.c.iterator();

         while (var2.hasNext()) {
            ((BackgroundTracker.Listener)var2.next()).a(var1);
         }
      }
   }

   public void a() {
      boolean var1;
      if (this.a.b() == null) {
         var1 = true;
      } else {
         var1 = false;
      }

      this.d = var1;
      this.a.a(this).a(this);
   }

   @Override
   public void a(Activity var1) {
      this.b.post(new Runnable(this) {
         final BackgroundTracker a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            this.a.c();
         }
      });
   }

   public void a(BackgroundTracker.Listener var1) {
      this.c.add(var1);
   }

   public void b() {
      this.a.b(this).b(this);
   }

   @Override
   public void b(Activity var1) {
      this.a(false);
   }

   void c() {
      if (this.a.b() == null) {
         this.a(true);
      }
   }

   public interface Listener {
      void a(boolean var1);
   }
}
