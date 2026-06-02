package com.google.api.client.util;

public class StringUtils {
   public static final String LINE_SEPARATOR = System.getProperty("line.separator");

   private StringUtils() {
   }

   public static byte[] getBytesUtf8(String var0) {
      return com.google.api.client.repackaged.org.apache.commons.codec.binary.StringUtils.getBytesUtf8(var0);
   }

   public static String newStringUtf8(byte[] var0) {
      return com.google.api.client.repackaged.org.apache.commons.codec.binary.StringUtils.newStringUtf8(var0);
   }
}
