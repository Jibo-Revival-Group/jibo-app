package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.internal.zzcbc;

public final class zzd extends zza<Integer> {
   public static Integer a(SharedPreferences var0, String var1, Integer var2) {
      try {
         zze var3 = new zze(var0, var1, var2);
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
         var7 = var2;
      }

      return var7;
   }
}
