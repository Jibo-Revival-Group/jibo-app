package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.internal.zzcbc;

public final class zzb extends zza<Boolean> {
   public static Boolean a(SharedPreferences var0, String var1, Boolean var2) {
      try {
         zzc var3 = new zzc(var0, var1, var2);
         var7 = zzcbc.a(var3);
      } catch (Exception var4) {
         String var5 = String.valueOf(var4.getMessage());
         String var6;
         if (var5.length() != 0) {
            var6 = "Flag value not available, returning default: ".concat(var5);
         } else {
            var6 = new String("Flag value not available, returning default: ");
         }

         Log.w("FlagDataUtils", var6);
         return var2;
      }

      return var7;
   }
}
