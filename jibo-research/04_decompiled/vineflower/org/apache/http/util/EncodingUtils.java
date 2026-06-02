package org.apache.http.util;

import java.io.UnsupportedEncodingException;
import org.apache.http.Consts;

public final class EncodingUtils {
   private EncodingUtils() {
   }

   public static byte[] getAsciiBytes(String var0) {
      Args.notNull(var0, "Input");
      return var0.getBytes(Consts.ASCII);
   }

   public static String getAsciiString(byte[] var0) {
      Args.notNull(var0, "Input");
      return getAsciiString(var0, 0, var0.length);
   }

   public static String getAsciiString(byte[] var0, int var1, int var2) {
      Args.notNull(var0, "Input");
      return new String(var0, var1, var2, Consts.ASCII);
   }

   public static byte[] getBytes(String var0, String var1) {
      Args.notNull(var0, "Input");
      Args.notEmpty(var1, "Charset");

      try {
         var4 = var0.getBytes(var1);
      } catch (UnsupportedEncodingException var2) {
         return var0.getBytes();
      }

      return var4;
   }

   public static String getString(byte[] var0, int var1, int var2, String var3) {
      Args.notNull(var0, "Input");
      Args.notEmpty(var3, "Charset");

      String var4;
      try {
         var4 = new String(var0, var1, var2, var3);
      } catch (UnsupportedEncodingException var5) {
         return new String(var0, var1, var2);
      }

      return var4;
   }

   public static String getString(byte[] var0, String var1) {
      Args.notNull(var0, "Input");
      return getString(var0, 0, var0.length, var1);
   }
}
