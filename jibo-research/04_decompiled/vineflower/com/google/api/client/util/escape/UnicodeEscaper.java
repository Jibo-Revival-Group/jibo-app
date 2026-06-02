package com.google.api.client.util.escape;

public abstract class UnicodeEscaper extends Escaper {
   private static final int DEST_PAD = 32;

   protected static int codePointAt(CharSequence var0, int var1, int var2) {
      if (var1 < var2) {
         int var5 = var1 + 1;
         char var3 = var0.charAt(var1);
         var1 = var3;
         if (var3 >= '\ud800') {
            if (var3 > '\udfff') {
               var1 = var3;
            } else {
               if (var3 > '\udbff') {
                  throw new IllegalArgumentException(
                     new StringBuilder(82)
                        .append("Unexpected low surrogate character '")
                        .append(var3)
                        .append("' with value ")
                        .append((int)var3)
                        .append(" at index ")
                        .append(var5 - 1)
                        .toString()
                  );
               }

               if (var5 == var2) {
                  var1 = -var3;
               } else {
                  char var4 = var0.charAt(var5);
                  if (!Character.isLowSurrogate(var4)) {
                     throw new IllegalArgumentException(
                        new StringBuilder(83)
                           .append("Expected low surrogate but got char '")
                           .append(var4)
                           .append("' with value ")
                           .append((int)var4)
                           .append(" at index ")
                           .append(var5)
                           .toString()
                     );
                  }

                  var1 = Character.toCodePoint(var3, var4);
               }
            }
         }

         return var1;
      } else {
         throw new IndexOutOfBoundsException("Index exceeds specified range");
      }
   }

   private static char[] growBuffer(char[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      if (var1 > 0) {
         System.arraycopy(var0, 0, var3, 0, var1);
      }

      return var3;
   }

   @Override
   public abstract String escape(String var1);

   protected abstract char[] escape(int var1);

   protected final String escapeSlow(String var1, int var2) {
      int var7 = var1.length();
      char[] var9 = Platform.charBufferFromThreadLocal();
      int var3 = 0;
      int var4 = 0;
      int var5 = var2;
      var2 = var4;

      while (var5 < var7) {
         var4 = codePointAt(var1, var5, var7);
         if (var4 < 0) {
            throw new IllegalArgumentException("Trailing high surrogate at end of input");
         }

         char[] var11 = this.escape(var4);
         byte var17;
         if (Character.isSupplementaryCodePoint(var4)) {
            var17 = 2;
         } else {
            var17 = 1;
         }

         int var6 = var17 + var5;
         if (var11 != null) {
            int var8 = var5 - var3;
            var17 = var2 + var8 + var11.length;
            char[] var10 = var9;
            if (var9.length < var17) {
               var10 = growBuffer(var9, var2, var17 + var7 - var5 + 32);
            }

            var17 = var2;
            if (var8 > 0) {
               var1.getChars(var3, var5, var10, var2);
               var17 = var2 + var8;
            }

            var2 = var17;
            if (var11.length > 0) {
               System.arraycopy(var11, 0, var10, var17, var11.length);
               var2 = var17 + var11.length;
            }

            var3 = var2;
            var2 = var6;
            var9 = var10;
         } else {
            var17 = var2;
            var2 = var3;
            var3 = var17;
         }

         var5 = this.nextEscapeIndex(var1, var6, var7);
         var17 = var2;
         var2 = var3;
         var3 = var17;
      }

      var5 = var7 - var3;
      var4 = var2;
      char[] var24 = var9;
      if (var5 > 0) {
         var4 = var5 + var2;
         var24 = var9;
         if (var9.length < var4) {
            var24 = growBuffer(var9, var2, var4);
         }

         var1.getChars(var3, var7, var24, var2);
      }

      return new String(var24, 0, var4);
   }

   protected abstract int nextEscapeIndex(CharSequence var1, int var2, int var3);
}
