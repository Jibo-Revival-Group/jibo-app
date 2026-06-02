package com.google.android.gms.internal;

final class zzciv implements Runnable {
   private zzcgl a;
   private zzcir b;

   zzciv(zzcir var1, zzcgl var2) {
      this.b = var1;
      this.a = var2;
      super();
   }

   @Override
   public final void run() {
      zzcir.a(this.b).G();
      zzcir.a(this.b).b(this.a);
   }
}
