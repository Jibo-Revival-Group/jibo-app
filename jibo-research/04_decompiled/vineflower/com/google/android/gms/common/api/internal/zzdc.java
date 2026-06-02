package com.google.android.gms.common.api.internal;

import android.os.Bundle;

final class zzdc implements Runnable {
   private LifecycleCallback a;
   private String b;
   private zzdb c;

   zzdc(zzdb var1, LifecycleCallback var2, String var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
      super();
   }

   @Override
   public final void run() {
      if (zzdb.a(this.c) > 0) {
         LifecycleCallback var2 = this.a;
         Bundle var1;
         if (zzdb.b(this.c) != null) {
            var1 = zzdb.b(this.c).getBundle(this.b);
         } else {
            var1 = null;
         }

         var2.a(var1);
      }

      if (zzdb.a(this.c) >= 2) {
         this.a.b();
      }

      if (zzdb.a(this.c) >= 3) {
         this.a.c();
      }

      if (zzdb.a(this.c) >= 4) {
         this.a.d();
      }

      if (zzdb.a(this.c) >= 5) {
         this.a.e();
      }
   }
}
