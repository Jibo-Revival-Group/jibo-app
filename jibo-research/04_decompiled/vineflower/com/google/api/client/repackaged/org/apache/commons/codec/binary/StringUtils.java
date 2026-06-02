package com.google.api.client.repackaged.org.apache.commons.codec.binary;

import java.io.UnsupportedEncodingException;

public class StringUtils {
   public static byte[] getBytesIso8859_1(String var0) {
      return getBytesUnchecked(var0, "ISO-8859-1");
   }

   public static byte[] getBytesUnchecked(String var0, String var1) {
      byte[] var3;
      if (var0 == null) {
         var3 = null;
      } else {
         try {
            var3 = var0.getBytes(var1);
         } catch (UnsupportedEncodingException var2) {
            throw newIllegalStateException(var1, var2);
         }
      }

      return var3;
   }

   public static byte[] getBytesUsAscii(String var0) {
      return getBytesUnchecked(var0, "US-ASCII");
   }

   public static byte[] getBytesUtf16(String var0) {
      return getBytesUnchecked(var0, "UTF-16");
   }

   public static byte[] getBytesUtf16Be(String var0) {
      return getBytesUnchecked(var0, "UTF-16BE");
   }

   public static byte[] getBytesUtf16Le(String var0) {
      return getBytesUnchecked(var0, "UTF-16LE");
   }

   public static byte[] getBytesUtf8(String var0) {
      return getBytesUnchecked(var0, "UTF-8");
   }

   private static IllegalStateException newIllegalStateException(String var0, UnsupportedEncodingException var1) {
      return new IllegalStateException(var0 + ": " + var1);
   }

   public static String newString(byte[] var0, String var1) {
      String var3;
      if (var0 == null) {
         var3 = null;
      } else {
         try {
            var3 = new String(var0, var1);
         } catch (UnsupportedEncodingException var2) {
            throw newIllegalStateException(var1, var2);
         }
      }

      return var3;
   }

   public static String newStringIso8859_1(byte[] var0) {
      return newString(var0, "ISO-8859-1");
   }

   public static String newStringUsAscii(byte[] var0) {
      return newString(var0, "US-ASCII");
   }

   public static String newStringUtf16(byte[] var0) {
      return newString(var0, "UTF-16");
   }

   public static String newStringUtf16Be(byte[] var0) {
      return newString(var0, "UTF-16BE");
   }

   public static String newStringUtf16Le(byte[] var0) {
      return newString(var0, "UTF-16LE");
   }

   public static String newStringUtf8(byte[] var0) {
      return newString(var0, "UTF-8");
   }
}
