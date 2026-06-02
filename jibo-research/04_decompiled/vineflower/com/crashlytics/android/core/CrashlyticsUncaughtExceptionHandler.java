package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.atomic.AtomicBoolean;

class CrashlyticsUncaughtExceptionHandler implements UncaughtExceptionHandler {
   private final CrashlyticsUncaughtExceptionHandler.CrashListener a;
   private final UncaughtExceptionHandler b;
   private final AtomicBoolean c;

   public CrashlyticsUncaughtExceptionHandler(CrashlyticsUncaughtExceptionHandler.CrashListener var1, UncaughtExceptionHandler var2) {
      this.a = var1;
      this.b = var2;
      this.c = new AtomicBoolean(false);
   }

   boolean a() {
      return this.c.get();
   }

   @Override
   public void uncaughtException(Thread var1, Throwable var2) {
      this.c.set(true);

      try {
         this.a.a(var1, var2);
      } catch (Exception var6) {
         Fabric.h().e("CrashlyticsCore", "An error occurred in the uncaught exception handler", var6);
      } finally {
         Fabric.h().a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
         this.b.uncaughtException(var1, var2);
         this.c.set(false);
      }
   }

   interface CrashListener {
      void a(Thread var1, Throwable var2);
   }
}
