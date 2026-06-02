package com.google.android.gms.internal;

final class zzcju implements Runnable {
   private long a;
   private zzcjn b;

   zzcju(zzcjn var1, long var2) {
      this.b = var1;
      this.a = var2;
      super();
   }

   @Override
   public final void run() {
      this.b.u().k.a(this.a);
      this.b.t().D().a("Session timeout duration set", this.a);
   }
}
