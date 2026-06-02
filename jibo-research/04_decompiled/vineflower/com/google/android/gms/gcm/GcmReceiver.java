package com.google.android.gms.gcm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.zzq;

public class GcmReceiver extends WakefulBroadcastReceiver {
   private static boolean a = false;
   private static com.google.android.gms.iid.zzh b;
   private static com.google.android.gms.iid.zzh c;

   private final com.google.android.gms.iid.zzh a(Context var1, String var2) {
      com.google.android.gms.iid.zzh var6;
      synchronized (this) {
         if ("com.google.android.c2dm.intent.RECEIVE".equals(var2)) {
            if (c == null) {
               com.google.android.gms.iid.zzh var3 = new com.google.android.gms.iid.zzh(var1, var2);
               c = var3;
            }

            var6 = c;
         } else {
            if (b == null) {
               com.google.android.gms.iid.zzh var7 = new com.google.android.gms.iid.zzh(var1, var2);
               b = var7;
            }

            var6 = b;
         }
      }

      return var6;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private final void b(Context var1, Intent var2) {
      if (this.isOrderedBroadcast()) {
         this.setResultCode(500);
      }

      ResolveInfo var3 = var1.getPackageManager().resolveService(var2, 0);
      if (var3 != null && var3.serviceInfo != null) {
         ServiceInfo var4 = var3.serviceInfo;
         if (var1.getPackageName().equals(var4.packageName) && var4.name != null) {
            String var14 = var4.name;
            String var11 = var14;
            if (var14.startsWith(".")) {
               String var12 = String.valueOf(var1.getPackageName());
               String var15 = String.valueOf(var14);
               if (var15.length() != 0) {
                  var11 = var12.concat(var15);
               } else {
                  var11 = new String(var12);
               }
            }

            if (Log.isLoggable("GcmReceiver", 3)) {
               String var16 = String.valueOf(var11);
               String var17;
               if (var16.length() != 0) {
                  var17 = "Restricting intent to a specific service: ".concat(var16);
               } else {
                  var17 = new String("Restricting intent to a specific service: ");
               }

               Log.d("GcmReceiver", var17);
            }

            var2.setClassName(var1.getPackageName(), var11);
         } else {
            String var10 = var4.packageName;
            String var13 = var4.name;
            Log.e(
               "GcmReceiver",
               new StringBuilder(String.valueOf(var10).length() + 94 + String.valueOf(var13).length())
                  .append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ")
                  .append(var10)
                  .append("/")
                  .append(var13)
                  .toString()
            );
         }
      } else {
         Log.e("GcmReceiver", "Failed to resolve target intent service, skipping classname enforcement");
      }

      label71: {
         label70: {
            try {
               if (var1.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                  var9 = a_(var1, var2);
                  break label70;
               }
            } catch (SecurityException var8) {
               Log.e("GcmReceiver", "Error while delivering the message to the serviceIntent", var8);
               if (!this.isOrderedBroadcast()) {
                  return;
               }
               break label71;
            }

            try {
               var9 = var1.startService(var2);
               Log.d("GcmReceiver", "Missing wake lock permission, service start may be delayed");
            } catch (SecurityException var7) {
               Log.e("GcmReceiver", "Error while delivering the message to the serviceIntent", var7);
               if (!this.isOrderedBroadcast()) {
                  return;
               }
               break label71;
            }
         }

         if (var9 == null) {
            try {
               Log.e("GcmReceiver", "Error while delivering the message: ServiceIntent not found.");
               if (this.isOrderedBroadcast()) {
                  this.setResultCode(404);
               }

               return;
            } catch (SecurityException var5) {
               Log.e("GcmReceiver", "Error while delivering the message to the serviceIntent", var5);
               if (!this.isOrderedBroadcast()) {
                  return;
               }
            }
         } else {
            try {
               if (this.isOrderedBroadcast()) {
                  this.setResultCode(-1);
               }

               return;
            } catch (SecurityException var6) {
               Log.e("GcmReceiver", "Error while delivering the message to the serviceIntent", var6);
               if (!this.isOrderedBroadcast()) {
                  return;
               }
            }
         }
      }

      this.setResultCode(401);
   }

   public void onReceive(Context var1, Intent var2) {
      boolean var4 = false;
      if (Log.isLoggable("GcmReceiver", 3)) {
         Log.d("GcmReceiver", "received new intent");
      }

      var2.setComponent(null);
      var2.setPackage(var1.getPackageName());
      if (VERSION.SDK_INT <= 18) {
         var2.removeCategory(var1.getPackageName());
      }

      String var5 = var2.getStringExtra("from");
      if ("google.com/iid".equals(var5) || "gcm.googleapis.com/refresh".equals(var5)) {
         var2.setAction("com.google.android.gms.iid.InstanceID");
      }

      var5 = var2.getStringExtra("gcm.rawData64");
      if (var5 != null) {
         var2.putExtra("rawData", Base64.decode(var5, 0));
         var2.removeExtra("gcm.rawData64");
      }

      boolean var3 = var4;
      if (zzq.h()) {
         var3 = var4;
         if (var1.getApplicationInfo().targetSdkVersion > 25) {
            var3 = true;
         }
      }

      if (var3) {
         if (this.isOrderedBroadcast()) {
            this.setResultCode(-1);
         }

         this.a(var1, var2.getAction()).a(var2, this.goAsync());
      } else {
         if ("com.google.android.c2dm.intent.RECEIVE".equals(var2.getAction())) {
            this.b(var1, var2);
         } else {
            this.b(var1, var2);
         }

         if (this.isOrderedBroadcast() && this.getResultCode() == 0) {
            this.setResultCode(-1);
         }
      }
   }
}
