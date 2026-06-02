package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import java.util.Collections;

final class zzbv implements Runnable {
   private ConnectionResult a;
   private zzbu b;

   zzbv(zzbu var1, ConnectionResult var2) {
      this.b = var1;
      this.a = var2;
      super();
   }

   @Override
   public final void run() {
      if (this.a.b()) {
         zzbu.a(this.b, true);
         if (zzbu.a(this.b).i()) {
            zzbu.b(this.b);
         } else {
            zzbu.a(this.b).a(null, Collections.emptySet());
         }
      } else {
         ((zzbo)zzbm.j(this.b.a).get(zzbu.c(this.b))).a(this.a);
      }
   }
}
