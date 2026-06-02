package com.google.android.gms.internal;

final class zzcjw implements Runnable {
   private String a;
   private String b;
   private Object c;
   private long d;
   private zzcjn e;

   zzcjw(zzcjn var1, String var2, String var3, Object var4, long var5) {
      this.e = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = var5;
      super();
   }

   @Override
   public final void run() {
      zzcjn.a(this.e, this.a, this.b, this.c, this.d);
   }
}
