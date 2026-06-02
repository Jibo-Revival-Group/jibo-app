package com.google.android.gms.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzcjr implements Runnable {
   private AtomicReference a;
   private String b;
   private String c;
   private String d;
   private zzcjn e;

   zzcjr(zzcjn var1, AtomicReference var2, String var3, String var4, String var5) {
      this.e = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = var5;
      super();
   }

   @Override
   public final void run() {
      this.e.p.w().a(this.a, this.b, this.c, this.d);
   }
}
