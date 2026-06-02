package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import java.net.MalformedURLException;
import java.net.URL;

public final class zzewq {
   public static int a(byte[] var0) {
      int var2 = 0;
      int var1 = 0;

      while (var2 < 4 && var2 < var0.length) {
         var1 |= (var0[var2] & 255) << (var2 << 3);
         var2++;
      }

      return var1;
   }

   public static String a(String var0) {
      URL var2;
      try {
         var2 = new URL(var0);
      } catch (MalformedURLException var4) {
         return var0;
      }

      String var3 = var2.getQuery();
      String var1 = var0;
      if (var3 != null) {
         var1 = var0.substring(0, var0.indexOf(var3) - 1);
      }

      var0 = var2.getUserInfo();
      if (var0 == null) {
         var0 = var1;
      } else {
         var0 = var1.replace(String.valueOf(var0).concat("@"), "");
      }

      return var0;
   }

   public static String a(String var0, int var1) {
      if (var0.length() > 2000) {
         if (var0.charAt(2000) == '/') {
            var0 = var0.substring(0, 2000);
         } else {
            URL var2;
            try {
               var2 = new URL(var0);
            } catch (MalformedURLException var3) {
               var0 = var0.substring(0, 2000);
               return var0;
            }

            if (var2.getPath().lastIndexOf(47) >= 0) {
               var1 = var0.lastIndexOf(47, 1999);
               if (var1 >= 0) {
                  var0 = var0.substring(0, var1);
                  return var0;
               }
            }

            var0 = var0.substring(0, 2000);
         }
      }

      return var0;
   }

   public static boolean a(Context var0) {
      try {
         return var0.getPackageManager().getApplicationInfo(var0.getPackageName(), 128).metaData.getBoolean("firebase_performance_logcat_enabled", false);
      } catch (NameNotFoundException var2) {
         var4 = var2;
      } catch (NullPointerException var3) {
         var4 = var3;
      }

      String var5 = String.valueOf(var4.getMessage());
      String var6;
      if (var5.length() != 0) {
         var6 = "No perf logcat meta data found ".concat(var5);
      } else {
         var6 = new String("No perf logcat meta data found ");
      }

      Log.d("isEnabled", var6);
      return false;
   }
}
