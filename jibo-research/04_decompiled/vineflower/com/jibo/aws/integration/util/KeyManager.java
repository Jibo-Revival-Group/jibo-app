package com.jibo.aws.integration.util;

import android.content.Context;
import android.security.KeyPairGeneratorSpec;
import android.security.KeyPairGeneratorSpec.Builder;
import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.KeyStore.Entry;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Enumeration;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;

public class KeyManager {
   public static final String DATA_SEPARATOR = "\n-----SIGNATURE-----\n";
   public static final String SIGNATURE_ALGORITHM = "SHA256withRSA";
   private static final String a = KeyManager.class.getSimpleName();
   private static final byte[] b = new byte[]{2, 4, 6, 8, 31, 29, 27, 25, 9, 11, 13, 15, 24, 22, 20, 18};
   private static final byte[] c = new byte[]{10, 32, 101, 88, 3, 75, 46, 57, 94, 11, 27, 40, 6, 112, 51, 80};
   private static KeyManager d = null;
   private KeyStore e;
   private Entry f;
   private String g;

   public KeyManager(String var1) {
      try {
         this.g = var1;
         this.e = KeyStore.getInstance("AndroidKeyStore");
         this.e.load(null);
      } catch (Exception var2) {
         com.jibo.aws.integration.util.a.d(a, "Could not create KeyManager", var2);
      }
   }

   private String a(String var1) {
      return "loop_" + this.g + "_" + var1;
   }

   private void a(Context var1) {
      boolean var2;
      try {
         StringBuilder var3 = new StringBuilder();
         String var14 = var3.append("account_").append(this.g).toString();
         if (!this.e.containsAlias(var14)) {
            Calendar var4 = Calendar.getInstance();
            Calendar var5 = Calendar.getInstance();
            var5.add(1, 50);
            Builder var6 = new Builder(var1);
            Builder var12 = var6.setAlias(var14);
            StringBuilder var7 = new StringBuilder();
            X500Principal var16 = new X500Principal(var7.append("CN=").append(var14).append(", O=Jibo Authority").toString());
            KeyPairGeneratorSpec var13 = var12.setSubject(var16)
               .setSerialNumber(BigInteger.ONE)
               .setStartDate(var4.getTime())
               .setEndDate(var5.getTime())
               .build();
            KeyPairGenerator var15 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            var15.initialize(var13);
            var15.generateKeyPair();
         }

         this.f = this.e.getEntry(var14, null);
         var2 = this.f instanceof PrivateKeyEntry;
      } catch (Exception var10) {
         var10.printStackTrace();
         return;
      } finally {
         ;
      }

      if (!var2) {
      }
   }

   private void a(Context var1, String var2, byte[] var3) {
      Cipher var4 = Cipher.getInstance("RSA/NONE/PKCS1Padding");
      var4.init(1, ((PrivateKeyEntry)this.f).getCertificate().getPublicKey());
      var3 = var4.doFinal(Base64.encodeToString(var3, 0).getBytes("UTF-8"));
      File var7 = new File(var1.getFilesDir(), this.a(var2));
      if (var7.exists()) {
         var7.delete();
      }

      FileOutputStream var5 = var1.openFileOutput(this.a(var2), 0);
      var5.write(var3);
      var5.close();
   }

   private byte[] a(Context var1, String var2) {
      if (!this.c(var1.getApplicationContext(), var2)) {
         throw new KeyManager.NoKeyForLoopException(var2);
      }

      Cipher var4 = Cipher.getInstance("RSA/NONE/PKCS1Padding");
      var4.init(2, ((PrivateKeyEntry)this.f).getPrivateKey());
      FileInputStream var5 = var1.openFileInput(this.a(var2));
      ByteArrayOutputStream var6 = new ByteArrayOutputStream();

      while (true) {
         int var3 = var5.read();
         if (var3 == -1) {
            byte[] var7 = var4.doFinal(var6.toByteArray());
            var5.close();
            var6.close();
            return Base64.decode(new String(var7, 0, var7.length, "UTF-8"), 0);
         }

         var6.write(var3);
      }
   }

   private byte[] a(String var1, String var2) {
      SecretKeySpec var3 = new SecretKeySpec(MessageDigest.getInstance("SHA-256").digest(var2.getBytes("UTF-8")), "AES");
      Cipher var4 = Cipher.getInstance("AES/CBC/PKCS5Padding");
      var4.init(2, var3, new IvParameterSpec(c));
      return var4.doFinal(Base64.decode(var1, 0));
   }

   private SecretKey b(Context var1, String var2) {
      byte[] var3 = this.a(var1, var2);
      return new SecretKeySpec(var3, 0, var3.length, "AES");
   }

   private boolean c(Context var1, String var2) {
      return new File(var1.getFilesDir(), this.a(var2)).exists();
   }

   public static KeyManager getInstance(Context var0, String var1) {
      synchronized (KeyManager.class) {
         if (d == null) {
            KeyManager var2 = new KeyManager(var1);
            d = var2;
            d.a(var0.getApplicationContext());
         }

         return d;
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public void deleteAccountData(Context var1) {
      label60: {
         Enumeration var5;
         String var18;
         try {
            var5 = this.e.aliases();
            StringBuilder var6 = new StringBuilder();
            var18 = var6.append("account_").append(this.g).toString();
         } catch (Exception var13) {
            com.jibo.aws.integration.util.a.d(a, "Could not delete any of the aliases", var13);
            break label60;
         }

         while (true) {
            boolean var4;
            try {
               var4 = var5.hasMoreElements();
            } catch (Exception var10) {
               com.jibo.aws.integration.util.a.d(a, "Could not delete any of the aliases", var10);
               break;
            }

            if (!var4) {
               break;
            }

            try {
               String var20 = (String)var5.nextElement();
               if (var20.equals(var18)) {
                  this.e.deleteEntry(var20);
                  break;
               }
            } catch (Exception var12) {
               Exception var7 = var12;

               try {
                  com.jibo.aws.integration.util.a.d(a, "Could not delete key alias", var7);
               } catch (Exception var11) {
                  com.jibo.aws.integration.util.a.d(a, "Could not delete any of the aliases", var11);
                  break;
               }
            }
         }
      }

      int var3;
      File[] var19;
      try {
         File var16 = var1.getFilesDir();
         StringBuilder var14 = new StringBuilder();
         var15 = var14.append("loop_").append(this.g).append("_").toString();
         var19 = var16.listFiles();
         var3 = var19.length;
      } catch (Exception var9) {
         com.jibo.aws.integration.util.a.d(a, "Could not delete key file", var9);
         return;
      }

      for (int var2 = 0; var2 < var3; var2++) {
         File var17 = var19[var2];

         try {
            if (var17.getName().startsWith(var15)) {
               var17.delete();
            }
         } catch (Exception var8) {
            com.jibo.aws.integration.util.a.d(a, "Could not delete key file", var8);
            break;
         }
      }
   }

   public void generateSymmetricKey(Context var1, String var2, boolean var3) {
      SecureRandom var4 = new SecureRandom();
      KeyGenerator var5 = KeyGenerator.getInstance("AES");
      var5.init(256, var4);
      SecretKey var7 = var5.generateKey();
      com.jibo.aws.integration.util.a.a("KeyManager", "generateSymmetricKey raw:" + Base64.encodeToString(var7.getEncoded(), 0));
      Cipher var9 = Cipher.getInstance("RSA/NONE/PKCS1Padding");
      var9.init(1, ((PrivateKeyEntry)this.f).getCertificate().getPublicKey());
      byte[] var8 = var9.doFinal(Base64.encodeToString(var7.getEncoded(), 0).getBytes("UTF-8"));
      com.jibo.aws.integration.util.a.a("KeyManager", "generateSymmetricKey encoded:" + Base64.encodeToString(var8, 0));
      File var10 = new File(var1.getFilesDir(), this.a(var2));
      if (var10.exists() && var3) {
         var10.delete();
      }

      FileOutputStream var6 = var1.openFileOutput(this.a(var2), 0);
      var6.write(var8);
      var6.close();
   }

   public String getEncryptedKey(Context var1, String var2, String var3) {
      String var4 = Base64.encodeToString(this.a(var1, var2), 0);
      byte[] var6 = MessageDigest.getInstance("SHA-256").digest(var3.getBytes("UTF-8"));
      Cipher var7 = Cipher.getInstance("AES/CBC/PKCS5Padding");
      var7.init(1, new SecretKeySpec(var6, "AES"), new IvParameterSpec(c));
      String var5 = Base64.encodeToString(var7.doFinal(var4.getBytes("UTF-8")), 0);
      com.jibo.aws.integration.util.a.a("KEY", "getEncryptedKey: " + var5);
      return var5;
   }

   public String getPublicKeyForSharing() {
      return Base64.encodeToString(((PrivateKeyEntry)this.f).getCertificate().getPublicKey().getEncoded(), 2).trim();
   }

   public String getSymmetricalKey(Context var1, String var2) {
      return Base64.encodeToString(this.a(var1, var2), 0);
   }

   public void logout(Context var1) {
      try {
         this.e = null;
         d = null;
      } catch (Exception var2) {
      }
   }

   public KeyManager.SymmetricKeyHolder obtainKeyHolder(Context var1, String var2) {
      return new KeyManager.SymmetricKeyHolder(this.b(var1.getApplicationContext(), var2));
   }

   public void saveSymmetricKey(Context var1, String var2, String var3) {
      if (!TextUtils.isEmpty(var3) && !TextUtils.isEmpty(var2)) {
         byte[] var5 = Base64.decode(var3, 0);
         Cipher var4 = Cipher.getInstance("RSA/NONE/PKCS1Padding");
         var4.init(2, ((PrivateKeyEntry)this.f).getPrivateKey());
         byte[] var6 = var4.doFinal(var5);
         byte[] var7 = Arrays.copyOfRange(var6, var6.length - 32, var6.length);
         com.jibo.aws.integration.util.a.a(a, new String(var7));
         com.jibo.aws.integration.util.a.a(a, Base64.encodeToString(var7, 0));
         this.a(var1, var2, var7);
      }
   }

   public void saveSymmetricKey(Context var1, String var2, String var3, String var4) {
      this.a(var1, var2, Base64.decode(this.a(var3, var4), 0));
   }

   public static class NoKeyForLoopException extends Exception {
      public NoKeyForLoopException() {
      }

      public NoKeyForLoopException(String var1) {
         super("No key for loop:" + var1);
      }

      public NoKeyForLoopException(String var1, Throwable var2) {
         super(var1, var2);
      }

      public NoKeyForLoopException(Throwable var1) {
         super(var1);
      }
   }

   public static class SymmetricKeyHolder {
      private SecretKey a;
      private IvParameterSpec b;

      public SymmetricKeyHolder(SecretKey var1) {
         this.a = var1;
         this.b = new IvParameterSpec(this.a());
      }

      private PublicKey a(String var1) {
         Object var2 = null;

         try {
            byte[] var3 = Base64.decode(var1.replace("-----BEGIN PUBLIC KEY-----\n", "").replace("\n-----END PUBLIC KEY-----", ""), 0);
            X509EncodedKeySpec var9 = new X509EncodedKeySpec(var3);
            return KeyFactory.getInstance("RSA").generatePublic(var9);
         } catch (Exception var6) {
            var6.printStackTrace();
         } finally {
            ;
         }

         return (PublicKey)var2;
      }

      private void a(InputStream var1, OutputStream var2) {
         Cipher var4 = Cipher.getInstance("AES/CBC/PKCS5Padding");
         var4.init(1, this.a, this.b);
         CipherOutputStream var5 = new CipherOutputStream(var2, var4);
         byte[] var6 = new byte[1024];

         while (true) {
            int var3 = var1.read(var6);
            if (var3 == -1) {
               var1.close();
               var5.close();
               var2.close();
               return;
            }

            var5.write(var6, 0, var3);
         }
      }

      private byte[] a() {
         byte[] var2 = new byte[16];
         byte[] var3 = this.a.getEncoded();

         for (int var1 = 0; var1 < KeyManager.b.length; var1++) {
            var2[var1] = var3[KeyManager.b[var1]];
         }

         return var2;
      }

      private void b(InputStream var1, OutputStream var2) {
         Cipher var4 = Cipher.getInstance("AES/CBC/PKCS5Padding");
         var4.init(2, this.a, this.b);
         CipherInputStream var5 = new CipherInputStream(var1, var4);
         byte[] var6 = new byte[1024];

         while (true) {
            int var3 = var5.read(var6);
            if (var3 == -1) {
               var1.close();
               var5.close();
               var2.close();
               return;
            }

            var2.write(var6, 0, var3);
         }
      }

      public void decodeFile(File var1, File var2) {
         this.b(new FileInputStream(var1), new FileOutputStream(var2));
      }

      public String decodeString(String var1) {
         Cipher var2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
         var2.init(2, this.a, this.b);
         return new String(var2.doFinal(Base64.decode(var1, 2)), "UTF-8");
      }

      public void encodeFile(File var1, File var2) {
         this.a(new FileInputStream(var1), new FileOutputStream(var2));
      }

      public String encodeString(String var1) {
         Cipher var2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
         var2.init(1, this.a, this.b);
         return Base64.encodeToString(var2.doFinal(var1.getBytes("UTF-8")), 2);
      }

      public String shareSymmetricKey(String var1) {
         PublicKey var2 = this.a(var1);
         Cipher var3 = Cipher.getInstance("RSA/NONE/PKCS1Padding");
         var3.init(1, var2);
         return Base64.encodeToString(var3.doFinal(this.a.getEncoded()), 2);
      }
   }
}
