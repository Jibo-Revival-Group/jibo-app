package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Base64;
import android.util.Log;

public final class FirebaseInstanceIdReceiver extends WakefulBroadcastReceiver {
   private static boolean a = false;
   private static zzh b;
   private static zzh c;

   private static zzh a(Context var0, String var1) {
      zzh var5;
      synchronized (FirebaseInstanceIdReceiver.class) {
         if ("com.google.firebase.MESSAGING_EVENT".equals(var1)) {
            if (c == null) {
               zzh var2 = new zzh(var0, var1);
               c = var2;
            }

            var5 = c;
         } else {
            if (b == null) {
               zzh var6 = new zzh(var0, var1);
               b = var6;
            }

            var5 = b;
         }
      }

      return var5;
   }

   private final void a(Context var1, Intent var2, String var3) {
      Object var7 = null;
      boolean var6 = false;
      byte var5 = -1;
      var2.setComponent(null);
      var2.setPackage(var1.getPackageName());
      if (VERSION.SDK_INT <= 18) {
         var2.removeCategory(var1.getPackageName());
      }

      String var8 = var2.getStringExtra("gcm.rawData64");
      if (var8 != null) {
         var2.putExtra("rawData", Base64.decode(var8, 0));
         var2.removeExtra("gcm.rawData64");
      }

      if ("google.com/iid".equals(var2.getStringExtra("from")) || "com.google.firebase.INSTANCE_ID_EVENT".equals(var3)) {
         var3 = "com.google.firebase.INSTANCE_ID_EVENT";
      } else if (!"com.google.android.c2dm.intent.RECEIVE".equals(var3) && !"com.google.firebase.MESSAGING_EVENT".equals(var3)) {
         Log.d("FirebaseInstanceId", "Unexpected intent");
         var3 = (String)var7;
      } else {
         var3 = "com.google.firebase.MESSAGING_EVENT";
      }

      int var4 = var5;
      if (var3 != null) {
         boolean var10 = var6;
         if (com.google.android.gms.common.util.zzq.h()) {
            var10 = var6;
            if (var1.getApplicationInfo().targetSdkVersion >= 26) {
               var10 = true;
            }
         }

         if (var10) {
            if (this.isOrderedBroadcast()) {
               this.setResultCode(-1);
            }

            a(var1, var3).a(var2, this.goAsync());
            var4 = var5;
         } else {
            var4 = zzx.a().a(var1, var3, var2);
         }
      }

      if (this.isOrderedBroadcast()) {
         this.setResultCode(var4);
      }
   }

   public final void onReceive(Context var1, Intent var2) {
      if (var2 != null) {
         Parcelable var3 = var2.getParcelableExtra("wrapped_intent");
         if (var3 instanceof Intent) {
            this.a(var1, (Intent)var3, var2.getAction());
         } else {
            this.a(var1, var2, var2.getAction());
         }
      }
   }
}
