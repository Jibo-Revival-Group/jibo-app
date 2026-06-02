package com.google.android.gms.internal;

import android.content.ComponentName;

final class zzckw implements Runnable {
   private ComponentName a;
   private zzcku b;

   zzckw(zzcku var1, ComponentName var2) {
      this.b = var1;
      this.a = var2;
      super();
   }

   @Override
   public final void run() {
      zzckg.a(this.b.a, this.a);
   }
}
