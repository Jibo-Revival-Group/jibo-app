package com.facebook.appevents.internal;

import android.os.Looper;

public class AppEventUtility {
   public static void assertIsMainThread() {
   }

   public static void assertIsNotMainThread() {
   }

   private static boolean isMainThread() {
      boolean var0;
      if (Looper.myLooper() == Looper.getMainLooper()) {
         var0 = true;
      } else {
         var0 = false;
      }

      return var0;
   }
}
