package com.google.android.gms.internal;

final class zzcit implements Runnable {
   private zzcgl a;
   private zzcgi b;
   private zzcir c;

   zzcit(zzcir var1, zzcgl var2, zzcgi var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
      super();
   }

   @Override
   public final void run() {
      zzcir.a(this.c).G();
      zzcir.a(this.c).b(this.a, this.b);
   }
}
