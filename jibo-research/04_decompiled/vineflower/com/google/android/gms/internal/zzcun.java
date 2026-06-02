package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.util.Log;

final class zzcun extends zzcui<String> {
   zzcun(zzcup var1, String var2, String var3) {
      super(var1, var2, var3, null);
   }

   private final String b(SharedPreferences var1) {
      try {
         var6 = var1.getString(this.a, null);
      } catch (ClassCastException var3) {
         String var4 = String.valueOf(this.a);
         String var5;
         if (var4.length() != 0) {
            var5 = "Invalid string value in SharedPreferences for ".concat(var4);
         } else {
            var5 = new String("Invalid string value in SharedPreferences for ");
         }

         Log.e("PhenotypeFlag", var5, var3);
         var6 = null;
      }

      return var6;
   }
}
