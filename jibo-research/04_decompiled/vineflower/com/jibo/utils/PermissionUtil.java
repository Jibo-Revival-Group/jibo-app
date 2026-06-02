package com.jibo.utils;

import android.content.Context;
import android.support.v4.content.ContextCompat;

public class PermissionUtil {
   public static boolean a(Context var0) {
      boolean var1;
      if (ContextCompat.b(var0, "android.permission.READ_EXTERNAL_STORAGE") + ContextCompat.b(var0, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public static boolean b(Context var0) {
      boolean var1;
      if (ContextCompat.b(var0, "android.permission.ACCESS_COARSE_LOCATION") + ContextCompat.b(var0, "android.permission.ACCESS_FINE_LOCATION") == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }
}
