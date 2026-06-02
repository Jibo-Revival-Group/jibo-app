package com.google.android.gms.internal;

final class zzcjo implements Runnable {
   private boolean a;
   private zzcjn b;

   zzcjo(zzcjn var1, boolean var2) {
      this.b = var1;
      this.a = var2;
      super();
   }

   @Override
   public final void run() {
      zzcjn.a(this.b, this.a);
   }
}
