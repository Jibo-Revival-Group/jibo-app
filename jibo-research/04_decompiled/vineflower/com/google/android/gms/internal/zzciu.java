package com.google.android.gms.internal;

final class zzciu implements Runnable {
   private zzcgl a;
   private zzcgi b;
   private zzcir c;

   zzciu(zzcir var1, zzcgl var2, zzcgi var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
      super();
   }

   @Override
   public final void run() {
      zzcir.a(this.c).G();
      zzcir.a(this.c).a(this.a, this.b);
   }
}
