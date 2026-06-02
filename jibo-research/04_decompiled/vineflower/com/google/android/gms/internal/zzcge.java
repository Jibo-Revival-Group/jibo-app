package com.google.android.gms.internal;

final class zzcge implements Runnable {
   private String a;
   private long b;
   private zzcgd c;

   zzcge(zzcgd var1, String var2, long var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
      super();
   }

   @Override
   public final void run() {
      zzcgd.a(this.c, this.a, this.b);
   }
}
