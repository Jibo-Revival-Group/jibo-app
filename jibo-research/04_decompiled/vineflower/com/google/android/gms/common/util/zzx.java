package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.internal.zzbhf;

public final class zzx {
   public static boolean a(Context var0, int var1) {
      boolean var3 = false;
      boolean var2;
      if (!a(var0, var1, "com.google.android.gms")) {
         var2 = var3;
      } else {
         PackageManager var4 = var0.getPackageManager();

         try {
            var6 = var4.getPackageInfo("com.google.android.gms", 64);
         } catch (NameNotFoundException var5) {
            var2 = var3;
            if (Log.isLoggable("UidVerifier", 3)) {
               Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
               var2 = var3;
            }

            return var2;
         }

         var2 = com.google.android.gms.common.zzq.a(var0).a(var6);
      }

      return var2;
   }

   @TargetApi(19)
   public static boolean a(Context var0, int var1, String var2) {
      return zzbhf.a(var0).a(var1, var2);
   }
}
