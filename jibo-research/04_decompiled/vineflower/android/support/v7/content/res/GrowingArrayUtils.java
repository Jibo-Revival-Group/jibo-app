package android.support.v7.content.res;

import java.lang.reflect.Array;

final class GrowingArrayUtils {
   static final boolean a;

   static {
      boolean var0;
      if (!GrowingArrayUtils.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      a = var0;
   }

   private GrowingArrayUtils() {
   }

   public static int a(int var0) {
      if (var0 <= 4) {
         var0 = 8;
      } else {
         var0 *= 2;
      }

      return var0;
   }

   public static int[] a(int[] var0, int var1, int var2) {
      if (!a && var1 > var0.length) {
         throw new AssertionError();
      }

      int[] var3 = var0;
      if (var1 + 1 > var0.length) {
         var3 = new int[a(var1)];
         System.arraycopy(var0, 0, var3, 0, var1);
      }

      var3[var1] = var2;
      return var3;
   }

   public static <T> T[] a(T[] var0, int var1, T var2) {
      if (!a && var1 > var0.length) {
         throw new AssertionError();
      }

      if (var1 + 1 > var0.length) {
         Object[] var3 = (Object[])Array.newInstance(var0.getClass().getComponentType(), a(var1));
         System.arraycopy(var0, 0, var3, 0, var1);
         var0 = var3;
      }

      var0[var1] = var2;
      return (T[])var0;
   }
}
