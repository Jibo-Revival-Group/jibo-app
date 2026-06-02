package com.google.android.gms.common.util;

import android.util.Base64;

public final class zzb {
   public static String a(byte[] var0) {
      String var1;
      if (var0 == null) {
         var1 = null;
      } else {
         var1 = Base64.encodeToString(var0, 0);
      }

      return var1;
   }

   public static String b(byte[] var0) {
      String var1;
      if (var0 == null) {
         var1 = null;
      } else {
         var1 = Base64.encodeToString(var0, 10);
      }

      return var1;
   }
}
