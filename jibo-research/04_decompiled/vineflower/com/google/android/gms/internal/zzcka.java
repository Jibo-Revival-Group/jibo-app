package com.google.android.gms.internal;

final class zzcka implements Runnable {
   private zzcjn a;

   zzcka(zzcjn var1) {
      this.a = var1;
      super();
   }

   @Override
   public final void run() {
      zzcjn var1 = this.a;
      var1.c();
      var1.Q();
      var1.t().D().a("Resetting analytics data (FE)");
      var1.i().A();
   }
}
