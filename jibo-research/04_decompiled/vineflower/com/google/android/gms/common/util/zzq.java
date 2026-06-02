package com.google.android.gms.common.util;

import android.os.Build.VERSION;

public final class zzq {
   public static boolean a() {
      boolean var0;
      if (VERSION.SDK_INT >= 15) {
         var0 = true;
      } else {
         var0 = false;
      }

      return var0;
   }

   public static boolean b() {
      boolean var0;
      if (VERSION.SDK_INT >= 16) {
         var0 = true;
      } else {
         var0 = false;
      }

      return var0;
   }

   public static boolean c() {
      boolean var0;
      if (VERSION.SDK_INT >= 18) {
         var0 = true;
      } else {
         var0 = false;
      }

      return var0;
   }

   public static boolean d() {
      boolean var0;
      if (VERSION.SDK_INT >= 19) {
         var0 = true;
      } else {
         var0 = false;
      }

      return var0;
   }

   public static boolean e() {
      boolean var0;
      if (VERSION.SDK_INT >= 20) {
         var0 = true;
      } else {
         var0 = false;
      }

      return var0;
   }

   public static boolean f() {
      boolean var0;
      if (VERSION.SDK_INT >= 21) {
         var0 = true;
      } else {
         var0 = false;
      }

      return var0;
   }

   public static boolean g() {
      boolean var0;
      if (VERSION.SDK_INT >= 24) {
         var0 = true;
      } else {
         var0 = false;
      }

      return var0;
   }

   public static boolean h() {
      boolean var0;
      if (VERSION.SDK_INT < 26 && !"O".equals(VERSION.CODENAME) && !VERSION.CODENAME.startsWith("OMR") && !VERSION.CODENAME.startsWith("ODR")) {
         var0 = false;
      } else {
         var0 = true;
      }

      return var0;
   }
}
