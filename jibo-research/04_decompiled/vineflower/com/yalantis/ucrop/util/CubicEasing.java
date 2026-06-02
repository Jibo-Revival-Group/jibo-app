package com.yalantis.ucrop.util;

public final class CubicEasing {
   public static float easeIn(float var0, float var1, float var2, float var3) {
      var0 /= var3;
      return var0 * (var2 * var0 * var0) + var1;
   }

   public static float easeInOut(float var0, float var1, float var2, float var3) {
      var3 = var0 / (var3 / 2.0F);
      if (var3 < 1.0F) {
         var0 = var3 * (var2 / 2.0F * var3 * var3) + var1;
      } else {
         var0 = var2 / 2.0F;
         var2 = var3 - 2.0F;
         var0 = (var2 * (var2 * var2) + 2.0F) * var0 + var1;
      }

      return var0;
   }

   public static float easeOut(float var0, float var1, float var2, float var3) {
      var0 = var0 / var3 - 1.0F;
      return (var0 * (var0 * var0) + 1.0F) * var2 + var1;
   }
}
