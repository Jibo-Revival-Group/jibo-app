package com.google.android.gms.internal;

final class zzcgf implements Runnable {
   private String a;
   private long b;
   private zzcgd c;

   zzcgf(zzcgd var1, String var2, long var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
      super();
   }

   @Override
   public final void run() {
      zzcgd.b(this.c, this.a, this.b);
   }
}
