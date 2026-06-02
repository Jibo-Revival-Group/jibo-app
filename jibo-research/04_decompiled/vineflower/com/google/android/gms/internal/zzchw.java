package com.google.android.gms.internal;

final class zzchw implements Runnable {
   private boolean a;
   private zzchv b;

   zzchw(zzchv var1, boolean var2) {
      this.b = var1;
      this.a = var2;
      super();
   }

   @Override
   public final void run() {
      zzchv.a(this.b).a(this.a);
   }
}
