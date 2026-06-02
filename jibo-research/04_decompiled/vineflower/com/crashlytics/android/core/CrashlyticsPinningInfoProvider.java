package com.crashlytics.android.core;

import java.io.InputStream;

class CrashlyticsPinningInfoProvider implements io.fabric.sdk.android.services.network.PinningInfoProvider {
   private final PinningInfoProvider a;

   public CrashlyticsPinningInfoProvider(PinningInfoProvider var1) {
      this.a = var1;
   }

   @Override
   public InputStream a() {
      return this.a.a();
   }

   @Override
   public String b() {
      return this.a.b();
   }

   @Override
   public String[] c() {
      return this.a.c();
   }

   @Override
   public long d() {
      return -1L;
   }
}
