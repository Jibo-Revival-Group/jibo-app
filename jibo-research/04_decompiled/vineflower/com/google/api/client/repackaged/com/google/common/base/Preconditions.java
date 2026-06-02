package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;

@GwtCompatible
public final class Preconditions {
   private Preconditions() {
   }

   private static String badElementIndex(int var0, int var1, String var2) {
      if (var0 < 0) {
         var2 = format("%s (%s) must not be negative", var2, var0);
      } else {
         if (var1 < 0) {
            throw new IllegalArgumentException("negative size: " + var1);
         }

         var2 = format("%s (%s) must be less than size (%s)", var2, var0, var1);
      }

      return var2;
   }

   private static String badPositionIndex(int var0, int var1, String var2) {
      if (var0 < 0) {
         var2 = format("%s (%s) must not be negative", var2, var0);
      } else {
         if (var1 < 0) {
            throw new IllegalArgumentException("negative size: " + var1);
         }

         var2 = format("%s (%s) must not be greater than size (%s)", var2, var0, var1);
      }

      return var2;
   }

   private static String badPositionIndexes(int var0, int var1, int var2) {
      String var3;
      if (var0 < 0 || var0 > var2) {
         var3 = badPositionIndex(var0, var2, "start index");
      } else if (var1 >= 0 && var1 <= var2) {
         var3 = format("end index (%s) must not be less than start index (%s)", var1, var0);
      } else {
         var3 = badPositionIndex(var1, var2, "end index");
      }

      return var3;
   }

   public static void checkArgument(boolean var0) {
      if (!var0) {
         throw new IllegalArgumentException();
      }
   }

   public static void checkArgument(boolean var0, Object var1) {
      if (!var0) {
         throw new IllegalArgumentException(String.valueOf(var1));
      }
   }

   public static void checkArgument(boolean var0, String var1, Object... var2) {
      if (!var0) {
         throw new IllegalArgumentException(format(var1, var2));
      }
   }

   public static int checkElementIndex(int var0, int var1) {
      return checkElementIndex(var0, var1, "index");
   }

   public static int checkElementIndex(int var0, int var1, String var2) {
      if (var0 >= 0 && var0 < var1) {
         return var0;
      } else {
         throw new IndexOutOfBoundsException(badElementIndex(var0, var1, var2));
      }
   }

   public static <T> T checkNotNull(T var0) {
      if (var0 == null) {
         throw new NullPointerException();
      } else {
         return (T)var0;
      }
   }

   public static <T> T checkNotNull(T var0, Object var1) {
      if (var0 == null) {
         throw new NullPointerException(String.valueOf(var1));
      } else {
         return (T)var0;
      }
   }

   public static <T> T checkNotNull(T var0, String var1, Object... var2) {
      if (var0 == null) {
         throw new NullPointerException(format(var1, var2));
      } else {
         return (T)var0;
      }
   }

   public static int checkPositionIndex(int var0, int var1) {
      return checkPositionIndex(var0, var1, "index");
   }

   public static int checkPositionIndex(int var0, int var1, String var2) {
      if (var0 >= 0 && var0 <= var1) {
         return var0;
      } else {
         throw new IndexOutOfBoundsException(badPositionIndex(var0, var1, var2));
      }
   }

   public static void checkPositionIndexes(int var0, int var1, int var2) {
      if (var0 < 0 || var1 < var0 || var1 > var2) {
         throw new IndexOutOfBoundsException(badPositionIndexes(var0, var1, var2));
      }
   }

   public static void checkState(boolean var0) {
      if (!var0) {
         throw new IllegalStateException();
      }
   }

   public static void checkState(boolean var0, Object var1) {
      if (!var0) {
         throw new IllegalStateException(String.valueOf(var1));
      }
   }

   public static void checkState(boolean var0, String var1, Object... var2) {
      if (!var0) {
         throw new IllegalStateException(format(var1, var2));
      }
   }

   static String format(String var0, Object... var1) {
      int var3 = 0;
      String var5 = String.valueOf(var0);
      StringBuilder var6 = new StringBuilder(var5.length() + var1.length * 16);
      int var2 = 0;

      while (var3 < var1.length) {
         int var4 = var5.indexOf("%s", var2);
         if (var4 == -1) {
            break;
         }

         var6.append(var5.substring(var2, var4));
         var6.append(var1[var3]);
         var2 = var4 + 2;
         var3++;
      }

      var6.append(var5.substring(var2));
      if (var3 < var1.length) {
         var6.append(" [");
         var6.append(var1[var3]);

         for (int var7 = var3 + 1; var7 < var1.length; var7++) {
            var6.append(", ");
            var6.append(var1[var7]);
         }

         var6.append(']');
      }

      return var6.toString();
   }
}
