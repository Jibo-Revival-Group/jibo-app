package io.fabric.sdk.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.Build.VERSION;
import java.util.HashSet;
import java.util.Set;

public class ActivityLifecycleManager {
   private final Application a;
   private ActivityLifecycleManager.ActivityLifecycleCallbacksWrapper b;

   public ActivityLifecycleManager(Context var1) {
      this.a = (Application)var1.getApplicationContext();
      if (VERSION.SDK_INT >= 14) {
         this.b = new ActivityLifecycleManager.ActivityLifecycleCallbacksWrapper(this.a);
      }
   }

   public void a() {
      if (this.b != null) {
         this.b.a();
      }
   }

   public boolean a(ActivityLifecycleManager.Callbacks var1) {
      boolean var2;
      if (this.b != null && this.b.a(var1)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   private static class ActivityLifecycleCallbacksWrapper {
      private final Set<ActivityLifecycleCallbacks> a = new HashSet<>();
      private final Application b;

      ActivityLifecycleCallbacksWrapper(Application var1) {
         this.b = var1;
      }

      @TargetApi(14)
      private void a() {
         for (ActivityLifecycleCallbacks var1 : this.a) {
            this.b.unregisterActivityLifecycleCallbacks(var1);
         }
      }

      @TargetApi(14)
      private boolean a(ActivityLifecycleManager.Callbacks var1) {
         boolean var2;
         if (this.b != null) {
            ActivityLifecycleCallbacks var3 = new ActivityLifecycleCallbacks(this, var1) {
               final ActivityLifecycleManager.Callbacks a;
               final ActivityLifecycleManager.ActivityLifecycleCallbacksWrapper b;

               {
                  this.b = var1;
                  this.a = var2x;
               }

               public void onActivityCreated(Activity var1, Bundle var2x) {
                  this.a.a(var1, var2x);
               }

               public void onActivityDestroyed(Activity var1) {
                  this.a.e(var1);
               }

               public void onActivityPaused(Activity var1) {
                  this.a.c(var1);
               }

               public void onActivityResumed(Activity var1) {
                  this.a.b(var1);
               }

               public void onActivitySaveInstanceState(Activity var1, Bundle var2x) {
                  this.a.b(var1, var2x);
               }

               public void onActivityStarted(Activity var1) {
                  this.a.a(var1);
               }

               public void onActivityStopped(Activity var1) {
                  this.a.d(var1);
               }
            };
            this.b.registerActivityLifecycleCallbacks(var3);
            this.a.add(var3);
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }
   }

   public abstract static class Callbacks {
      public void a(Activity var1) {
      }

      public void a(Activity var1, Bundle var2) {
      }

      public void b(Activity var1) {
      }

      public void b(Activity var1, Bundle var2) {
      }

      public void c(Activity var1) {
      }

      public void d(Activity var1) {
      }

      public void e(Activity var1) {
      }
   }
}
