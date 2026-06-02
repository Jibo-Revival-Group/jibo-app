package android.support.v4.math;

public class MathUtils {
   public static float a(float var0, float var1, float var2) {
      if (!(var0 < var1)) {
         if (var0 > var2) {
            var1 = var2;
         } else {
            var1 = var0;
         }
      }

      return var1;
   }

   public static int a(int var0, int var1, int var2) {
      if (var0 >= var1) {
         if (var0 > var2) {
            var1 = var2;
         } else {
            var1 = var0;
         }
      }

      return var1;
   }
}
