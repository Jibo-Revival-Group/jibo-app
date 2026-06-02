package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;

final class zzckd implements Runnable {
   private boolean a;
   private AppMeasurement.zzb b;
   private zzckf c;
   private zzckc d;

   zzckd(zzckc var1, boolean var2, AppMeasurement.zzb var3, zzckf var4) {
      this.d = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      super();
   }

   @Override
   public final void run() {
      if (this.a && this.d.a != null) {
         zzckc.a(this.d, this.d.a);
      }

      boolean var1;
      if (this.b != null && this.b.d == this.c.d && zzclq.a(this.b.c, this.c.c) && zzclq.a(this.b.b, this.c.b)) {
         var1 = false;
      } else {
         var1 = true;
      }

      if (var1) {
         Bundle var2 = new Bundle();
         zzckc.a(this.c, var2);
         if (this.b != null) {
            if (this.b.b != null) {
               var2.putString("_pn", this.b.b);
            }

            var2.putString("_pc", this.b.c);
            var2.putLong("_pi", this.b.d);
         }

         this.d.f().a("auto", "_vs", var2);
      }

      this.d.a = this.c;
      this.d.i().a(this.c);
   }
}
