package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

final class zzcik<V> extends FutureTask<V> implements Comparable<zzcik> {
   final boolean a;
   private final long b;
   private final String c;
   private zzcih d;

   zzcik(zzcih var1, Runnable var2, boolean var3, String var4) {
      this.d = var1;
      super(var2, null);
      zzbq.a((String)var4);
      this.b = zzcih.B().getAndIncrement();
      this.c = var4;
      this.a = false;
      if (this.b == Long.MAX_VALUE) {
         var1.t().y().a("Tasks index overflow");
      }
   }

   zzcik(zzcih var1, Callable var2, boolean var3, String var4) {
      this.d = var1;
      super(var2);
      zzbq.a((String)var4);
      this.b = zzcih.B().getAndIncrement();
      this.c = var4;
      this.a = var3;
      if (this.b == Long.MAX_VALUE) {
         var1.t().y().a("Tasks index overflow");
      }
   }

   @Override
   protected final void setException(Throwable var1) {
      this.d.t().y().a(this.c, var1);
      if (var1 instanceof zzcii) {
         Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), var1);
      }

      super.setException(var1);
   }
}
