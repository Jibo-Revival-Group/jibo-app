package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;

public final class zzi {
   private static Boolean a;
   private static Boolean b;
   private static Boolean c;

   @TargetApi(20)
   public static boolean a(Context var0) {
      if (a == null) {
         boolean var1;
         if (zzq.e() && var0.getPackageManager().hasSystemFeature("android.hardware.type.watch")) {
            var1 = true;
         } else {
            var1 = false;
         }

         a = var1;
      }

      return a;
   }

   @TargetApi(24)
   public static boolean b(Context var0) {
      boolean var1;
      if ((!zzq.g() || c(var0)) && a(var0)) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @TargetApi(21)
   public static boolean c(Context var0) {
      if (b == null) {
         boolean var1;
         if (zzq.f() && var0.getPackageManager().hasSystemFeature("cn.google")) {
            var1 = true;
         } else {
            var1 = false;
         }

         b = var1;
      }

      return b;
   }

   public static boolean d(Context var0) {
      if (c == null) {
         boolean var1;
         if (!var0.getPackageManager().hasSystemFeature("android.hardware.type.iot")
            && !var0.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
            var1 = false;
         } else {
            var1 = true;
         }

         c = var1;
      }

      return c;
   }
}
