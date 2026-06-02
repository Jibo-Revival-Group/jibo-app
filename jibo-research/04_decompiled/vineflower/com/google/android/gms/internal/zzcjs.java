package com.google.android.gms.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzcjs implements Runnable {
   private AtomicReference a;
   private String b;
   private String c;
   private String d;
   private boolean e;
   private zzcjn f;

   zzcjs(zzcjn var1, AtomicReference var2, String var3, String var4, String var5, boolean var6) {
      this.f = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = var5;
      this.e = var6;
      super();
   }

   @Override
   public final void run() {
      this.f.p.w().a(this.a, this.b, this.c, this.d, this.e);
   }
}
