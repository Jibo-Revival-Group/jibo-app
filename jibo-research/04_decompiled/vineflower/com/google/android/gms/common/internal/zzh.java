package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

final class zzh extends Handler {
   private zzd a;

   public zzh(zzd var1, Looper var2) {
      this.a = var1;
      super(var2);
   }

   private static void a(Message var0) {
      ((zzi)var0.obj).c();
   }

   private static boolean b(Message var0) {
      boolean var2 = true;
      boolean var1 = var2;
      if (var0.what != 2) {
         var1 = var2;
         if (var0.what != 1) {
            if (var0.what == 7) {
               var1 = var2;
            } else {
               var1 = false;
            }
         }
      }

      return var1;
   }

   public final void handleMessage(Message var1) {
      PendingIntent var3 = null;
      if (this.a.c.get() != var1.arg1) {
         if (b(var1)) {
            a(var1);
         }
      } else if ((var1.what == 1 || var1.what == 7 || var1.what == 4 || var1.what == 5) && !this.a.h()) {
         a(var1);
      } else if (var1.what == 4) {
         zzd.a(this.a, new ConnectionResult(var1.arg2));
         if (zzd.b(this.a) && !zzd.c(this.a)) {
            zzd.a(this.a, 3, null);
         } else {
            ConnectionResult var4;
            if (zzd.d(this.a) != null) {
               var4 = zzd.d(this.a);
            } else {
               var4 = new ConnectionResult(8);
            }

            this.a.b.a(var4);
            this.a.a(var4);
         }
      } else if (var1.what == 5) {
         ConnectionResult var5;
         if (zzd.d(this.a) != null) {
            var5 = zzd.d(this.a);
         } else {
            var5 = new ConnectionResult(8);
         }

         this.a.b.a(var5);
         this.a.a(var5);
      } else if (var1.what == 3) {
         if (var1.obj instanceof PendingIntent) {
            var3 = (PendingIntent)var1.obj;
         }

         ConnectionResult var6 = new ConnectionResult(var1.arg2, var3);
         this.a.b.a(var6);
         this.a.a(var6);
      } else if (var1.what == 6) {
         zzd.a(this.a, 5, null);
         if (zzd.e(this.a) != null) {
            zzd.e(this.a).a(var1.arg2);
         }

         this.a.a(var1.arg2);
         zzd.a(this.a, 5, 1, null);
      } else if (var1.what == 2 && !this.a.g()) {
         a(var1);
      } else if (b(var1)) {
         ((zzi)var1.obj).b();
      } else {
         int var2 = var1.what;
         Log.wtf("GmsClient", new StringBuilder(45).append("Don't know how to handle message: ").append(var2).toString(), new Exception());
      }
   }
}
