package com.google.android.gms.internal;

import android.os.Bundle;

final class zzcjv implements Runnable {
   private String a;
   private String b;
   private long c;
   private Bundle d;
   private boolean e;
   private boolean f;
   private boolean g;
   private String h;
   private zzcjn i;

   zzcjv(zzcjn var1, String var2, String var3, long var4, Bundle var6, boolean var7, boolean var8, boolean var9, String var10) {
      this.i = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = var6;
      this.e = var7;
      this.f = var8;
      this.g = var9;
      this.h = var10;
      super();
   }

   @Override
   public final void run() {
      zzcjn.a(this.i, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
   }
}
