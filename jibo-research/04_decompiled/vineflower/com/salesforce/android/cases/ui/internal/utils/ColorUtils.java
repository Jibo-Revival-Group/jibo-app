package com.salesforce.android.cases.ui.internal.utils;

import android.graphics.Color;

public class ColorUtils {
   public static int a(int var0, float var1) {
      String var5 = Integer.toHexString(var0);
      String var4 = var5;
      if (var5.length() == 8) {
         var4 = var5.substring(2, 8);
      }

      if (var4.length() >= 6) {
         int var2 = Integer.parseInt(var4.substring(0, 2), 16);
         var0 = Integer.parseInt(var4.substring(2, 4), 16);
         int var3 = Integer.parseInt(var4.substring(4, 6), 16);
         var0 = Color.rgb(
            (int)(var2 * (1.0F - var1) / 255.0F * 255.0F), (int)(var0 * (1.0F - var1) / 255.0F * 255.0F), (int)(var3 * (1.0F - var1) / 255.0F * 255.0F)
         );
      }

      return var0;
   }
}
