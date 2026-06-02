package com.google.android.gms.common.api.internal;

import com.google.android.gms.internal.zzcxq;

final class zzcx implements Runnable {
   private zzcxq a;
   private zzcv b;

   zzcx(zzcv var1, zzcxq var2) {
      this.b = var1;
      this.a = var2;
      super();
   }

   @Override
   public final void run() {
      zzcv.a(this.b, this.a);
   }
}
