package com.crashlytics.android.answers;

import android.app.Activity;
import android.os.Bundle;
import io.fabric.sdk.android.ActivityLifecycleManager;

class AnswersLifecycleCallbacks extends ActivityLifecycleManager.Callbacks {
   private final SessionAnalyticsManager a;
   private final BackgroundManager b;

   public AnswersLifecycleCallbacks(SessionAnalyticsManager var1, BackgroundManager var2) {
      this.a = var1;
      this.b = var2;
   }

   @Override
   public void a(Activity var1) {
      this.a.a(var1, SessionEvent.Type.START);
   }

   @Override
   public void a(Activity var1, Bundle var2) {
   }

   @Override
   public void b(Activity var1) {
      this.a.a(var1, SessionEvent.Type.RESUME);
      this.b.a();
   }

   @Override
   public void b(Activity var1, Bundle var2) {
   }

   @Override
   public void c(Activity var1) {
      this.a.a(var1, SessionEvent.Type.PAUSE);
      this.b.b();
   }

   @Override
   public void d(Activity var1) {
      this.a.a(var1, SessionEvent.Type.STOP);
   }

   @Override
   public void e(Activity var1) {
   }
}
