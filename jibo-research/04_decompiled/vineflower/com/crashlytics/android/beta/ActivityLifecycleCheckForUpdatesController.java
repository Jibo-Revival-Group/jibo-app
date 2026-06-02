package com.crashlytics.android.beta;

import android.annotation.TargetApi;
import android.app.Activity;
import io.fabric.sdk.android.ActivityLifecycleManager;
import java.util.concurrent.ExecutorService;

@TargetApi(14)
class ActivityLifecycleCheckForUpdatesController extends AbstractCheckForUpdatesController {
   private final ActivityLifecycleManager.Callbacks a = new ActivityLifecycleManager.Callbacks(this) {
      final ActivityLifecycleCheckForUpdatesController a;

      {
         this.a = var1;
      }

      @Override
      public void a(Activity var1) {
         if (this.a.a()) {
            this.a.b.submit(new Runnable(this) {
               final <unrepresentable> a;

               {
                  this.a = var1;
               }

               @Override
               public void run() {
                  this.a.a.c();
               }
            });
         }
      }
   };
   private final ExecutorService b;

   public ActivityLifecycleCheckForUpdatesController(ActivityLifecycleManager var1, ExecutorService var2) {
      this.b = var2;
      var1.a(this.a);
   }
}
