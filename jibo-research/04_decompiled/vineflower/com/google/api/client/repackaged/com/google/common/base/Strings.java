package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import com.google.api.client.repackaged.com.google.common.annotations.VisibleForTesting;

@GwtCompatible
public final class Strings {
   private Strings() {
   }

   public static String commonPrefix(CharSequence var0, CharSequence var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      int var3 = Math.min(var0.length(), var1.length());
      int var2 = 0;

      while (var2 < var3 && var0.charAt(var2) == var1.charAt(var2)) {
         var2++;
      }

      if (!validSurrogatePairAt(var0, var2 - 1)) {
         var3 = var2;
         if (!validSurrogatePairAt(var1, var2 - 1)) {
            return var0.subSequence(0, var3).toString();
         }
      }

      var3 = var2 - 1;
      return var0.subSequence(0, var3).toString();
   }

   public static String commonSuffix(CharSequence var0, CharSequence var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      int var3 = Math.min(var0.length(), var1.length());
      int var2 = 0;

      while (var2 < var3 && var0.charAt(var0.length() - var2 - 1) == var1.charAt(var1.length() - var2 - 1)) {
         var2++;
      }

      if (!validSurrogatePairAt(var0, var0.length() - var2 - 1)) {
         var3 = var2;
         if (!validSurrogatePairAt(var1, var1.length() - var2 - 1)) {
            return var0.subSequence(var0.length() - var3, var0.length()).toString();
         }
      }

      var3 = var2 - 1;
      return var0.subSequence(var0.length() - var3, var0.length()).toString();
   }

   public static String emptyToNull(String var0) {
      String var1 = var0;
      if (isNullOrEmpty(var0)) {
         var1 = null;
      }

      return var1;
   }

   public static boolean isNullOrEmpty(String var0) {
      boolean var1;
      if (var0 != null && var0.length() != 0) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public static String nullToEmpty(String var0) {
      String var1 = var0;
      if (var0 == null) {
         var1 = "";
      }

      return var1;
   }

   public static String padEnd(String var0, int var1, char var2) {
      Preconditions.checkNotNull(var0);
      if (var0.length() < var1) {
         StringBuilder var4 = new StringBuilder(var1);
         var4.append(var0);

         for (int var3 = var0.length(); var3 < var1; var3++) {
            var4.append(var2);
         }

         var0 = var4.toString();
      }

      return var0;
   }

   public static String padStart(String var0, int var1, char var2) {
      Preconditions.checkNotNull(var0);
      if (var0.length() < var1) {
         StringBuilder var4 = new StringBuilder(var1);

         for (int var3 = var0.length(); var3 < var1; var3++) {
            var4.append(var2);
         }

         var4.append(var0);
         var0 = var4.toString();
      }

      return var0;
   }

   public static String repeat(String var0, int var1) {
      Preconditions.checkNotNull(var0);
      if (var1 <= 1) {
         boolean var4;
         if (var1 >= 0) {
            var4 = true;
         } else {
            var4 = false;
         }

         Preconditions.checkArgument(var4, "invalid count: %s", var1);
         if (var1 == 0) {
            var0 = "";
         }
      } else {
         int var2 = var0.length();
         long var5 = (long)var2 * var1;
         int var3 = (int)var5;
         if (var3 != var5) {
            throw new ArrayIndexOutOfBoundsException("Required array size too large: " + var5);
         }

         char[] var7 = new char[var3];
         var0.getChars(0, var2, var7, 0);

         for (var1 = var2; var1 < var3 - var1; var1 <<= 1) {
            System.arraycopy(var7, 0, var7, var1, var1);
         }

         System.arraycopy(var7, 0, var7, var1, var3 - var1);
         var0 = new String(var7);
      }

      return var0;
   }

   @VisibleForTesting
   static boolean validSurrogatePairAt(CharSequence var0, int var1) {
      boolean var2;
      if (var1 >= 0 && var1 <= var0.length() - 2 && Character.isHighSurrogate(var0.charAt(var1)) && Character.isLowSurrogate(var0.charAt(var1 + 1))) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }
}
