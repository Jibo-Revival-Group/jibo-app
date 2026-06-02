package com.google.common.base;

public final class Preconditions {
   public static int a(int var0, int var1) {
      return a(var0, var1, "index");
   }

   public static int a(int var0, int var1, String var2) {
      if (var0 >= 0 && var0 <= var1) {
         return var0;
      } else {
         throw new IndexOutOfBoundsException(b(var0, var1, var2));
      }
   }

   public static <T> T a(T var0) {
      if (var0 == null) {
         throw new NullPointerException();
      } else {
         return (T)var0;
      }
   }

   static String a(String var0, Object... var1) {
      int var3 = 0;
      var0 = String.valueOf(var0);
      StringBuilder var5 = new StringBuilder(var0.length() + var1.length * 16);
      int var2 = 0;

      while (var3 < var1.length) {
         int var4 = var0.indexOf("%s", var2);
         if (var4 == -1) {
            break;
         }

         var5.append(var0, var2, var4);
         var5.append(var1[var3]);
         var2 = var4 + 2;
         var3++;
      }

      var5.append(var0, var2, var0.length());
      if (var3 < var1.length) {
         var5.append(" [");
         var5.append(var1[var3]);

         for (int var7 = var3 + 1; var7 < var1.length; var7++) {
            var5.append(", ");
            var5.append(var1[var7]);
         }

         var5.append(']');
      }

      return var5.toString();
   }

   public static void a(boolean var0) {
      if (!var0) {
         throw new IllegalArgumentException();
      }
   }

   public static void a(boolean var0, Object var1) {
      if (!var0) {
         throw new IllegalArgumentException(String.valueOf(var1));
      }
   }

   public static void a(boolean var0, String var1, int var2) {
      if (!var0) {
         throw new IllegalArgumentException(a(var1, var2));
      }
   }

   public static void a(boolean var0, String var1, long var2) {
      if (!var0) {
         throw new IllegalArgumentException(a(var1, var2));
      }
   }

   private static String b(int var0, int var1, String var2) {
      if (var0 < 0) {
         var2 = a("%s (%s) must not be negative", var2, var0);
      } else {
         if (var1 < 0) {
            throw new IllegalArgumentException("negative size: " + var1);
         }

         var2 = a("%s (%s) must not be greater than size (%s)", var2, var0, var1);
      }

      return var2;
   }

   public static void b(boolean var0) {
      if (!var0) {
         throw new IllegalStateException();
      }
   }

   public static void b(boolean var0, Object var1) {
      if (!var0) {
         throw new IllegalStateException(String.valueOf(var1));
      }
   }
}
