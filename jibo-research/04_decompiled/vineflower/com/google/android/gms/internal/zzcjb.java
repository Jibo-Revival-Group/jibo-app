package com.google.android.gms.internal;

final class zzcjb implements Runnable {
   private zzcgi a;
   private zzcir b;

   zzcjb(zzcir var1, zzcgi var2) {
      this.b = var1;
      this.a = var2;
      super();
   }

   @Override
   public final void run() {
      zzcir.a(this.b).G();
      zzcir.a(this.b).a(this.a);
   }
}
