package com.google.android.gms.internal;

final class zzcjf implements Runnable {
   private zzcln a;
   private zzcgi b;
   private zzcir c;

   zzcjf(zzcir var1, zzcln var2, zzcgi var3) {
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
