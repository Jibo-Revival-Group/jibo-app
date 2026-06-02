package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver.PendingResult;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzbq;

public final class zzcid {
   private final zzcif a;

   public zzcid(zzcif var1) {
      zzbq.a(var1);
      this.a = var1;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static boolean a(Context var0) {
      boolean var2 = false;
      zzbq.a(var0);

      PackageManager var4;
      try {
         var4 = var0.getPackageManager();
      } catch (NameNotFoundException var8) {
         return var2;
      }

      boolean var1;
      if (var4 == null) {
         var1 = var2;
      } else {
         try {
            ComponentName var5 = new ComponentName(var0, "com.google.android.gms.measurement.AppMeasurementReceiver");
            var9 = var4.getReceiverInfo(var5, 2);
         } catch (NameNotFoundException var7) {
            var1 = var2;
            return var1;
         }

         var1 = var2;
         if (var9 != null) {
            boolean var3;
            try {
               var3 = var9.enabled;
            } catch (NameNotFoundException var6) {
               var1 = var2;
               return var1;
            }

            var1 = var2;
            if (var3) {
               var1 = true;
            }
         }
      }

      return var1;
   }

   public final void a(Context var1, Intent var2) {
      zzcim var8 = zzcim.a(var1);
      zzchm var7 = var8.f();
      if (var2 == null) {
         var7.A().a("Receiver called with null intent");
      } else {
         String var5 = var2.getAction();
         var7.E().a("Local receiver got", var5);
         if ("com.google.android.gms.measurement.UPLOAD".equals(var5)) {
            var2 = new Intent().setClassName(var1, "com.google.android.gms.measurement.AppMeasurementService");
            var2.setAction("com.google.android.gms.measurement.UPLOAD");
            var7.E().a("Starting wakeful intent.");
            this.a.a(var1, var2);
         } else if ("com.android.vending.INSTALL_REFERRER".equals(var5)) {
            PendingResult var9 = this.a.a();
            String var6 = var2.getStringExtra("referrer");
            if (var6 == null) {
               var7.E().a("Install referrer extras are null");
               if (var9 != null) {
                  var9.finish();
               }
            } else {
               var7.C().a("Install referrer extras are", var6);
               var5 = var6;
               if (!var6.contains("?")) {
                  var5 = String.valueOf(var6);
                  if (var5.length() != 0) {
                     var5 = "?".concat(var5);
                  } else {
                     var5 = new String("?");
                  }
               }

               Uri var13 = Uri.parse(var5);
               Bundle var14 = var8.o().a(var13);
               if (var14 == null) {
                  var7.E().a("No campaign defined in install referrer broadcast");
                  if (var9 != null) {
                     var9.finish();
                  }
               } else {
                  long var3 = 1000L * var2.getLongExtra("referrer_timestamp_seconds", 0L);
                  if (var3 == 0L) {
                     var7.A().a("Install referrer is missing timestamp");
                  }

                  var8.h().a(new zzcie(this, var8, var3, var14, var1, var7, var9));
               }
            }
         }
      }
   }
}
