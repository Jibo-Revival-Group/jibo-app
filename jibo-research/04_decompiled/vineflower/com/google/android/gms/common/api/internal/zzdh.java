package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

final class zzdh implements Runnable {
   private Result a;
   private zzdg b;

   zzdh(zzdg var1, Result var2) {
      this.b = var1;
      this.a = var2;
      super();
   }

   @Override
   public final void run() {
      try {
         BasePendingResult.a.set(true);
         PendingResult var1 = zzdg.a(this.b).a(this.a);
         zzdg.b(this.b).sendMessage(zzdg.b(this.b).obtainMessage(0, var1));
      } catch (RuntimeException var5) {
         zzdg.b(this.b).sendMessage(zzdg.b(this.b).obtainMessage(1, var5));
      } finally {
         BasePendingResult.a.set(false);
         zzdg.a(this.b, this.a);
         GoogleApiClient var2 = (GoogleApiClient)zzdg.c(this.b).get();
         if (var2 != null) {
            var2.b(this.b);
         }
      }
   }
}
