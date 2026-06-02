package com.salesforce.androidsdk.analytics.security;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.salesforce.androidsdk.analytics.util.SalesforceAnalyticsLogger;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Encryptor {
   private static String a;
   private static boolean b;

   public static String a(String var0, String var1) {
      String var2 = var0;
      if (!TextUtils.isEmpty(var1)) {
         if (var0 == null) {
            var2 = var0;
         } else {
            var2 = a(var0.getBytes(), var1);
         }
      }

      return var2;
   }

   public static String a(byte[] var0, String var1) {
      Object var2 = null;
      if (TextUtils.isEmpty(var1)) {
         var1 = (String)var2;
         if (var0 != null) {
            var1 = new String(var0, Charset.forName("UTF-8"));
         }
      } else {
         try {
            byte[] var7 = Base64.decode(var1, 0);
            var0 = Base64.decode(var0, 0);
            var0 = a(var0, 0, var0.length, var7);
            var1 = new String(var0, 0, var0.length, "UTF-8");
         } catch (Exception var3) {
            SalesforceAnalyticsLogger.b(null, "Encryptor", "Error during decryption", var3);
            var1 = (String)var2;
         }
      }

      return var1;
   }

   public static Cipher a() throws GeneralSecurityException {
      Cipher var0;
      if (a != null) {
         var0 = Cipher.getInstance(a, "BC");
      } else {
         Cipher var5;
         label30: {
            label29: {
               label34: {
                  try {
                     var0 = Cipher.getInstance("AES/CBC/PKCS5Padding", "BC");
                  } catch (GeneralSecurityException var3) {
                     var1 = var3;
                     var0 = null;
                     break label34;
                  }

                  var5 = var0;
                  if (var0 == null) {
                     break label30;
                  }

                  try {
                     a = "AES/CBC/PKCS5Padding";
                     break label29;
                  } catch (GeneralSecurityException var2) {
                     var1 = var2;
                  }
               }

               SalesforceAnalyticsLogger.a(null, "Encryptor", "Preferred combo not available", var1);
               var5 = var0;
               break label30;
            }

            var5 = var0;
         }

         var0 = var5;
         if (a == null) {
            SalesforceAnalyticsLogger.a(null, "Encryptor", "No cipher transformation available");
            var0 = var5;
         }
      }

      return var0;
   }

   public static boolean a(Context var0) {
      boolean var2 = false;
      boolean var1;
      if (((DevicePolicyManager)var0.getSystemService("device_policy")).getStorageEncryptionStatus() == 3) {
         var1 = true;
      } else {
         var1 = false;
      }

      b = var1;
      a = null;

      try {
         a();
      } catch (GeneralSecurityException var4) {
         SalesforceAnalyticsLogger.a(var0, "Encryptor", "Security exception thrown", var4);
      }

      if (a == null) {
         var1 = var2;
      } else {
         try {
            Mac.getInstance("HmacSHA256", "BC");
         } catch (GeneralSecurityException var5) {
            SalesforceAnalyticsLogger.a(var0, "Encryptor", "No MAC transformation available", var5);
            var1 = var2;
            return var1;
         }

         var1 = true;
      }

      return var1;
   }

   private static byte[] a(byte[] var0, int var1, int var2, byte[] var3) throws GeneralSecurityException {
      byte[] var6 = new byte[16];
      System.arraycopy(var0, var1, var6, 0, var6.length);
      int var4 = var2 - var6.length;
      var2 = var6.length;
      byte[] var5 = new byte[var4];
      System.arraycopy(var0, var2 + var1, var5, 0, var4);
      Cipher var7 = a();
      var7.init(2, new SecretKeySpec(var3, var7.getAlgorithm()), new IvParameterSpec(var6));
      return var7.doFinal(var5, 0, var4);
   }

   private static byte[] a(byte[] var0, byte[] var1) throws GeneralSecurityException {
      Cipher var2 = a();
      SecretKeySpec var3 = new SecretKeySpec(var1, var2.getAlgorithm());
      var1 = c();
      var2.init(1, var3, new IvParameterSpec(var1));
      byte[] var6 = var2.doFinal(var0);
      var0 = new byte[var1.length + var6.length];
      System.arraycopy(var1, 0, var0, 0, var1.length);
      System.arraycopy(var6, 0, var0, var1.length, var6.length);
      return var0;
   }

   public static String b(String var0, String var1) {
      String var2 = var0;
      if (!TextUtils.isEmpty(var1)) {
         if (var0 == null) {
            var2 = var0;
         } else {
            byte[] var4 = c(var0, var1);
            if (var4 == null) {
               var2 = null;
            } else {
               try {
                  var2 = new String(var4, "US-ASCII");
               } catch (UnsupportedEncodingException var3) {
                  SalesforceAnalyticsLogger.b(null, "Encryptor", "Error during encryption", var3);
                  var2 = null;
               }
            }
         }
      }

      return var2;
   }

   public static boolean b() {
      return b;
   }

   private static byte[] c() throws NoSuchAlgorithmException, NoSuchProviderException {
      SecureRandom var1 = SecureRandom.getInstance("SHA1PRNG");
      byte[] var0 = new byte[16];
      var1.nextBytes(var0);
      return var0;
   }

   public static byte[] c(String var0, String var1) {
      Object var2 = null;
      byte[] var4;
      if (TextUtils.isEmpty(var1)) {
         if (var0 == null) {
            var4 = (byte[])var2;
         } else {
            var4 = var0.getBytes();
         }
      } else {
         try {
            byte[] var5 = Base64.decode(var1, 0);
            var4 = Base64.encode(a(var0.getBytes("UTF-8"), var5), 0);
         } catch (Exception var3) {
            SalesforceAnalyticsLogger.b(null, "Encryptor", "Error during encryption", var3);
            var4 = (byte[])var2;
         }
      }

      return var4;
   }

   public static String d(String var0, String var1) {
      Object var2 = null;

      try {
         byte[] var8 = var1.getBytes("UTF-8");
         byte[] var4 = var0.getBytes("UTF-8");
         Mac var3 = Mac.getInstance("HmacSHA256", "BC");
         SecretKeySpec var7 = new SecretKeySpec(var8, var3.getAlgorithm());
         var3.init(var7);
         var0 = Base64.encodeToString(var3.doFinal(var4), 2);
      } catch (Exception var5) {
         SalesforceAnalyticsLogger.b(null, "Encryptor", "Error during hashing", var5);
         var0 = (String)var2;
      }

      return var0;
   }
}
