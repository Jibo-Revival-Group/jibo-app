package com.google.android.gms.internal;

final class zzcjt implements Runnable {
   private long a;
   private zzcjn b;

   zzcjt(zzcjn var1, long var2) {
      this.b = var1;
      this.a = var2;
      super();
   }

   @Override
   public final void run() {
      this.b.u().j.a(this.a);
      this.b.t().D().a("Minimum session duration set", this.a);
   }
}
