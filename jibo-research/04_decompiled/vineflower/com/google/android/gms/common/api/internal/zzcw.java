package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

final class zzcw implements Runnable {
   private zzcv a;

   zzcw(zzcv var1) {
      this.a = var1;
      super();
   }

   @Override
   public final void run() {
      zzcv.a(this.a).b(new ConnectionResult(4));
   }
}
