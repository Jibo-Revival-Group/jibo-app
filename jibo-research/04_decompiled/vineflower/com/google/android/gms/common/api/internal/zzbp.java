package com.google.android.gms.common.api.internal;

final class zzbp implements Runnable {
   private zzbo a;

   zzbp(zzbo var1) {
      this.a = var1;
      super();
   }

   @Override
   public final void run() {
      zzbo.a(this.a);
   }
}
