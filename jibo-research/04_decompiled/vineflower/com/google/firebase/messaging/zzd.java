package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.measurement.AppMeasurement;

final class zzd {
   private static AppMeasurement a(Context var0) {
      try {
         var2 = AppMeasurement.getInstance(var0);
      } catch (NoClassDefFoundError var1) {
         var2 = null;
      }

      return var2;
   }

   public static void a(Context var0, Intent var1) {
      String var2 = var1.getStringExtra("google.c.a.abt");
      if (var2 != null) {
         zzc.a(var0, "fcm", Base64.decode(var2, 0), new zzb(), 1);
      }

      a(var0, "_nr", var1);
   }

   private static void a(Context var0, String var1, Intent var2) {
      Bundle var4 = new Bundle();
      String var3 = var2.getStringExtra("google.c.a.c_id");
      if (var3 != null) {
         var4.putString("_nmid", var3);
      }

      var3 = var2.getStringExtra("google.c.a.c_l");
      if (var3 != null) {
         var4.putString("_nmn", var3);
      }

      var3 = var2.getStringExtra("from");
      if (var3 == null || !var3.startsWith("/topics/")) {
         var3 = null;
      }

      if (var3 != null) {
         var4.putString("_nt", var3);
      }

      try {
         var4.putInt("_nmt", Integer.valueOf(var2.getStringExtra("google.c.a.ts")));
      } catch (NumberFormatException var6) {
         Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", var6);
      }

      if (var2.hasExtra("google.c.a.udt")) {
         try {
            var4.putInt("_ndt", Integer.valueOf(var2.getStringExtra("google.c.a.udt")));
         } catch (NumberFormatException var5) {
            Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", var5);
         }
      }

      if (Log.isLoggable("FirebaseMessaging", 3)) {
         String var8 = String.valueOf(var4);
         Log.d(
            "FirebaseMessaging",
            new StringBuilder(String.valueOf(var1).length() + 22 + String.valueOf(var8).length())
               .append("Sending event=")
               .append(var1)
               .append(" params=")
               .append(var8)
               .toString()
         );
      }

      AppMeasurement var7 = a(var0);
      if (var7 != null) {
         var7.logEventInternal("fcm", var1, var4);
      } else {
         Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
      }
   }

   public static void b(Context var0, Intent var1) {
      if (var1 != null) {
         if ("1".equals(var1.getStringExtra("google.c.a.tc"))) {
            AppMeasurement var2 = a(var0);
            if (Log.isLoggable("FirebaseMessaging", 3)) {
               Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event");
            }

            if (var2 != null) {
               String var4 = var1.getStringExtra("google.c.a.c_id");
               var2.setUserPropertyInternal("fcm", "_ln", var4);
               Bundle var3 = new Bundle();
               var3.putString("source", "Firebase");
               var3.putString("medium", "notification");
               var3.putString("campaign", var4);
               var2.logEventInternal("fcm", "_cmp", var3);
            } else {
               Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
            }
         } else if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Received event with track-conversion=false. Do not set user property");
         }
      }

      a(var0, "_no", var1);
   }

   public static void c(Context var0, Intent var1) {
      a(var0, "_nd", var1);
   }

   public static void d(Context var0, Intent var1) {
      a(var0, "_nf", var1);
   }
}
