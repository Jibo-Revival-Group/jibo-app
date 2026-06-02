package com.crashlytics.android.answers;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import io.fabric.sdk.android.ActivityLifecycleManager;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.ExecutorUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.network.DefaultHttpRequestFactory;
import io.fabric.sdk.android.services.persistence.FileStoreImpl;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.util.concurrent.ScheduledExecutorService;

class SessionAnalyticsManager implements BackgroundManager.Listener {
   final AnswersEventsHandler a;
   final ActivityLifecycleManager b;
   final BackgroundManager c;
   final AnswersPreferenceManager d;
   private final long e;

   SessionAnalyticsManager(AnswersEventsHandler var1, ActivityLifecycleManager var2, BackgroundManager var3, AnswersPreferenceManager var4, long var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   public static SessionAnalyticsManager a(Kit var0, Context var1, IdManager var2, String var3, String var4, long var5) {
      SessionMetadataCollector var11 = new SessionMetadataCollector(var1, var2, var3, var4);
      AnswersFilesManagerProvider var12 = new AnswersFilesManagerProvider(var1, new FileStoreImpl(var0));
      DefaultHttpRequestFactory var10 = new DefaultHttpRequestFactory(Fabric.h());
      ActivityLifecycleManager var7 = new ActivityLifecycleManager(var1);
      ScheduledExecutorService var8 = ExecutorUtils.b("Answers Events Handler");
      BackgroundManager var9 = new BackgroundManager(var8);
      return new SessionAnalyticsManager(new AnswersEventsHandler(var0, var1, var12, var11, var10, var8), var7, var9, AnswersPreferenceManager.a(var1), var5);
   }

   @Override
   public void a() {
      Fabric.h().a("Answers", "Flush events when app is backgrounded");
      this.a.c();
   }

   public void a(long var1) {
      Fabric.h().a("Answers", "Logged install");
      this.a.b(SessionEvent.a(var1));
   }

   public void a(Activity var1, SessionEvent.Type var2) {
      Fabric.h().a("Answers", "Logged lifecycle event: " + var2.name());
      this.a.a(SessionEvent.a(var2, var1));
   }

   public void a(AnalyticsSettingsData var1, String var2) {
      this.c.a(var1.h);
      this.a.a(var1, var2);
   }

   public void a(String var1) {
   }

   public void a(String var1, String var2) {
      if (Looper.myLooper() == Looper.getMainLooper()) {
         throw new IllegalStateException("onCrash called from main thread!!!");
      }

      Fabric.h().a("Answers", "Logged crash");
      this.a.c(SessionEvent.a(var1, var2));
   }

   public void b() {
      this.a.b();
      this.b.a(new AnswersLifecycleCallbacks(this, this.c));
      this.c.a(this);
      if (this.d()) {
         this.a(this.e);
         this.d.a();
      }
   }

   public void c() {
      this.b.a();
      this.a.a();
   }

   boolean d() {
      boolean var1;
      if (!this.d.b()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }
}
