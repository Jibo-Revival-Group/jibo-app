package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

final class zzbr implements Runnable {
   private ConnectionResult a;
   private zzbo b;

   zzbr(zzbo var1, ConnectionResult var2) {
      this.b = var1;
      this.a = var2;
      super();
   }

   @Override
   public final void run() {
      this.b.a(this.a);
   }
}
