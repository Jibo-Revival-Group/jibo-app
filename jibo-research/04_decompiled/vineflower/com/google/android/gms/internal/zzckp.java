package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;

final class zzckp implements Runnable {
   private boolean a;
   private boolean b;
   private zzcgl c;
   private zzcgi d;
   private zzcgl e;
   private zzckg f;

   zzckp(zzckg var1, boolean var2, boolean var3, zzcgl var4, zzcgi var5, zzcgl var6) {
      this.f = var1;
      this.a = true;
      this.b = var3;
      this.c = var4;
      this.d = var5;
      this.e = var6;
      super();
   }

   @Override
   public final void run() {
      zzche var3 = zzckg.d(this.f);
      if (var3 == null) {
         this.f.t().y().a("Discarding data. Failed to send conditional user property to service");
      } else {
         if (this.a) {
            zzckg var2 = this.f;
            zzcgl var1;
            if (this.b) {
               var1 = null;
            } else {
               var1 = this.c;
            }

            var2.a(var3, var1, this.d);
         } else {
            try {
               if (TextUtils.isEmpty(this.e.a)) {
                  var3.a(this.c, this.d);
               } else {
                  var3.a(this.c);
               }
            } catch (RemoteException var4) {
               this.f.t().y().a("Failed to send conditional user property to the service", var4);
            }
         }

         zzckg.e(this.f);
      }
   }
}
