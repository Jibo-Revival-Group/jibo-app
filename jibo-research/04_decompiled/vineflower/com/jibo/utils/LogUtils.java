package com.jibo.utils;

import android.util.Log;

public class LogUtils {
   private static final int a = "JB_".length();

   public static String a(Class var0) {
      return a(var0.getSimpleName());
   }

   public static String a(String var0) {
      if (var0.length() > 23 - a) {
         var0 = "JB_" + var0.substring(0, 23 - a - 1);
      } else {
         var0 = "JB_" + var0;
      }

      return var0;
   }

   public static void a(String var0, String var1) {
      if (Log.isLoggable(var0, 3)) {
         Log.d(var0, var1);
      }
   }

   public static void a(String var0, String var1, Throwable var2) {
      if (Log.isLoggable(var0, 3)) {
         Log.d(var0, var1, var2);
      }
   }

   public static void b(String var0, String var1) {
      if (Log.isLoggable(var0, 2)) {
         Log.v(var0, var1);
      }
   }

   public static void b(String var0, String var1, Throwable var2) {
      Log.e(var0, var1, var2);
   }

   public static void c(String var0, String var1) {
      Log.i(var0, var1);
   }

   public static void d(String var0, String var1) {
      Log.e(var0, var1);
   }
}
