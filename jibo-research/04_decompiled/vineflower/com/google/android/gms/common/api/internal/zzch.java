package com.google.android.gms.common.api.internal;

import android.os.Bundle;

final class zzch implements Runnable {
   private LifecycleCallback a;
   private String b;
   private zzcg c;

   zzch(zzcg var1, LifecycleCallback var2, String var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
      super();
   }

   @Override
   public final void run() {
      if (zzcg.a(this.c) > 0) {
         LifecycleCallback var2 = this.a;
         Bundle var1;
         if (zzcg.b(this.c) != null) {
            var1 = zzcg.b(this.c).getBundle(this.b);
         } else {
            var1 = null;
         }

         var2.a(var1);
      }

      if (zzcg.a(this.c) >= 2) {
         this.a.b();
      }

      if (zzcg.a(this.c) >= 3) {
         this.a.c();
      }

      if (zzcg.a(this.c) >= 4) {
         this.a.d();
      }

      if (zzcg.a(this.c) >= 5) {
         this.a.e();
      }
   }
}
