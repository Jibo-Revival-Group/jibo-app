package android.support.v4.graphics;

import android.graphics.Color;

public final class ColorUtils {
   private static final ThreadLocal<double[]> a = new ThreadLocal<>();

   public static int a(int var0, int var1) {
      int var3 = Color.alpha(var1);
      int var2 = Color.alpha(var0);
      int var4 = c(var2, var3);
      return Color.argb(
         var4,
         a(Color.red(var0), var2, Color.red(var1), var3, var4),
         a(Color.green(var0), var2, Color.green(var1), var3, var4),
         a(Color.blue(var0), var2, Color.blue(var1), var3, var4)
      );
   }

   private static int a(int var0, int var1, int var2, int var3, int var4) {
      if (var4 == 0) {
         var0 = 0;
      } else {
         var0 = (var0 * 255 * var1 + var2 * var3 * (255 - var1)) / (var4 * 255);
      }

      return var0;
   }

   public static int b(int var0, int var1) {
      if (var1 >= 0 && var1 <= 255) {
         return 16777215 & var0 | var1 << 24;
      } else {
         throw new IllegalArgumentException("alpha must be between 0 and 255.");
      }
   }

   private static int c(int var0, int var1) {
      return 255 - (255 - var1) * (255 - var0) / 255;
   }
}
