package org.apache.http.util;

public final class LangUtils {
   public static final int HASH_OFFSET = 37;
   public static final int HASH_SEED = 17;

   private LangUtils() {
   }

   public static boolean equals(Object var0, Object var1) {
      boolean var2;
      if (var0 == null) {
         if (var1 == null) {
            var2 = true;
         } else {
            var2 = false;
         }
      } else {
         var2 = var0.equals(var1);
      }

      return var2;
   }

   public static boolean equals(Object[] var0, Object[] var1) {
      boolean var4 = true;
      boolean var3;
      if (var0 == null) {
         if (var1 == null) {
            var3 = var4;
         } else {
            var3 = false;
         }
      } else if (var1 != null && var0.length == var1.length) {
         int var2 = 0;

         while (true) {
            var3 = var4;
            if (var2 >= var0.length) {
               break;
            }

            if (!equals(var0[var2], var1[var2])) {
               var3 = false;
               break;
            }

            var2++;
         }
      } else {
         var3 = false;
      }

      return var3;
   }

   public static int hashCode(int var0, int var1) {
      return var0 * 37 + var1;
   }

   public static int hashCode(int var0, Object var1) {
      int var2;
      if (var1 != null) {
         var2 = var1.hashCode();
      } else {
         var2 = 0;
      }

      return hashCode(var0, var2);
   }

   public static int hashCode(int var0, boolean var1) {
      byte var2;
      if (var1) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      return hashCode(var0, var2);
   }
}
