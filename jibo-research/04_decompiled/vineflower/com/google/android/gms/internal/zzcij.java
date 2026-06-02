package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;
import java.lang.Thread.UncaughtExceptionHandler;

final class zzcij implements UncaughtExceptionHandler {
   private final String a;
   private zzcih b;

   public zzcij(zzcih var1, String var2) {
      this.b = var1;
      super();
      zzbq.a((String)var2);
      this.a = var2;
   }

   @Override
   public final void uncaughtException(Thread var1, Throwable var2) {
      synchronized (this) {
         this.b.t().y().a(this.a, var2);
      }
   }
}
