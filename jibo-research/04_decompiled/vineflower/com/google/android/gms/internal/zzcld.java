package com.google.android.gms.internal;

final class zzcld implements Runnable {
   private zzcim a;
   private Runnable b;

   zzcld(zzcla var1, zzcim var2, Runnable var3) {
      this.a = var2;
      this.b = var3;
      super();
   }

   @Override
   public final void run() {
      this.a.G();
      this.a.a(this.b);
      this.a.E();
   }
}
