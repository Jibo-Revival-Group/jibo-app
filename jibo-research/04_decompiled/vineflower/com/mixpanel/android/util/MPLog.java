package com.mixpanel.android.util;

import android.util.Log;

public class MPLog {
   private static int a = 5;

   public static void a(int var0) {
      a = var0;
   }

   public static void a(String var0, String var1) {
      if (b(2)) {
         Log.v(var0, var1);
      }
   }

   public static void a(String var0, String var1, Throwable var2) {
      if (b(2)) {
         Log.v(var0, var1, var2);
      }
   }

   public static void b(String var0, String var1) {
      if (b(3)) {
         Log.d(var0, var1);
      }
   }

   public static void b(String var0, String var1, Throwable var2) {
      if (b(3)) {
         Log.d(var0, var1, var2);
      }
   }

   private static boolean b(int var0) {
      boolean var1;
      if (a <= var0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public static void c(String var0, String var1) {
      if (b(4)) {
         Log.i(var0, var1);
      }
   }

   public static void c(String var0, String var1, Throwable var2) {
      if (b(4)) {
         Log.i(var0, var1, var2);
      }
   }

   public static void d(String var0, String var1) {
      if (b(5)) {
         Log.w(var0, var1);
      }
   }

   public static void d(String var0, String var1, Throwable var2) {
      if (b(5)) {
         Log.w(var0, var1, var2);
      }
   }

   public static void e(String var0, String var1) {
      if (b(6)) {
         Log.e(var0, var1);
      }
   }

   public static void e(String var0, String var1, Throwable var2) {
      if (b(6)) {
         Log.e(var0, var1, var2);
      }
   }

   public static void f(String var0, String var1) {
      if (b(6)) {
         Log.wtf(var0, var1);
      }
   }

   public static void f(String var0, String var1, Throwable var2) {
      if (b(6)) {
         Log.wtf(var0, var1, var2);
      }
   }
}
