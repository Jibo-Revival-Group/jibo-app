package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;

final class zzcko implements Runnable {
   private boolean a;
   private boolean b;
   private zzcha c;
   private zzcgi d;
   private String e;
   private zzckg f;

   zzcko(zzckg var1, boolean var2, boolean var3, zzcha var4, zzcgi var5, String var6) {
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
      zzche var2 = zzckg.d(this.f);
      if (var2 == null) {
         this.f.t().y().a("Discarding data. Failed to send event to service");
      } else {
         if (this.a) {
            zzckg var3 = this.f;
            zzcha var1;
            if (this.b) {
               var1 = null;
            } else {
               var1 = this.c;
            }

            var3.a(var2, var1, this.d);
         } else {
            try {
               if (TextUtils.isEmpty(this.e)) {
                  var2.a(this.c, this.d);
               } else {
                  var2.a(this.c, this.e, this.f.t().F());
               }
            } catch (RemoteException var4) {
               this.f.t().y().a("Failed to send event to the service", var4);
            }
         }

         zzckg.e(this.f);
      }
   }
}
