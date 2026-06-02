package com.amazonaws.util;

public enum CodecUtils {
   private static final CodecUtils[] $VALUES = new CodecUtils[0];

   public static byte[] toBytesDirect(String var0) {
      char[] var3 = var0.toCharArray();
      byte[] var4 = new byte[var3.length];

      for (int var1 = 0; var1 < var4.length; var1++) {
         char var2 = var3[var1];
         if (var2 > 127) {
            throw new IllegalArgumentException("Invalid character found at position " + var1 + " for " + var0);
         }

         var4[var1] = (byte)var2;
      }

      return var4;
   }

   public static String toStringDirect(byte[] var0) {
      int var2 = 0;
      char[] var4 = new char[var0.length];
      int var3 = var0.length;

      for (int var1 = 0; var2 < var3; var1++) {
         var4[var1] = (char)var0[var2];
         var2++;
      }

      return new String(var4);
   }
}
