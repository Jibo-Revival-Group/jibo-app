package com.google.api.client.util;

public class Base64 {
   private Base64() {
   }

   public static byte[] decodeBase64(String var0) {
      return com.google.api.client.repackaged.org.apache.commons.codec.binary.Base64.decodeBase64(var0);
   }

   public static byte[] decodeBase64(byte[] var0) {
      return com.google.api.client.repackaged.org.apache.commons.codec.binary.Base64.decodeBase64(var0);
   }

   public static byte[] encodeBase64(byte[] var0) {
      return com.google.api.client.repackaged.org.apache.commons.codec.binary.Base64.encodeBase64(var0);
   }

   public static String encodeBase64String(byte[] var0) {
      return com.google.api.client.repackaged.org.apache.commons.codec.binary.Base64.encodeBase64String(var0);
   }

   public static byte[] encodeBase64URLSafe(byte[] var0) {
      return com.google.api.client.repackaged.org.apache.commons.codec.binary.Base64.encodeBase64URLSafe(var0);
   }

   public static String encodeBase64URLSafeString(byte[] var0) {
      return com.google.api.client.repackaged.org.apache.commons.codec.binary.Base64.encodeBase64URLSafeString(var0);
   }
}
