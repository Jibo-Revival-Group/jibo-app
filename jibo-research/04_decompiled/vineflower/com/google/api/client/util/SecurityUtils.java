package com.google.api.client.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.X509TrustManager;

public final class SecurityUtils {
   private SecurityUtils() {
   }

   public static KeyStore getDefaultKeyStore() throws KeyStoreException {
      return KeyStore.getInstance(KeyStore.getDefaultType());
   }

   public static KeyStore getJavaKeyStore() throws KeyStoreException {
      return KeyStore.getInstance("JKS");
   }

   public static KeyStore getPkcs12KeyStore() throws KeyStoreException {
      return KeyStore.getInstance("PKCS12");
   }

   public static PrivateKey getPrivateKey(KeyStore var0, String var1, String var2) throws GeneralSecurityException {
      return (PrivateKey)var0.getKey(var1, var2.toCharArray());
   }

   public static KeyFactory getRsaKeyFactory() throws NoSuchAlgorithmException {
      return KeyFactory.getInstance("RSA");
   }

   public static Signature getSha1WithRsaSignatureAlgorithm() throws NoSuchAlgorithmException {
      return Signature.getInstance("SHA1withRSA");
   }

   public static Signature getSha256WithRsaSignatureAlgorithm() throws NoSuchAlgorithmException {
      return Signature.getInstance("SHA256withRSA");
   }

   public static CertificateFactory getX509CertificateFactory() throws CertificateException {
      return CertificateFactory.getInstance("X.509");
   }

   public static void loadKeyStore(KeyStore var0, InputStream var1, String var2) throws IOException, GeneralSecurityException {
      try {
         var0.load(var1, var2.toCharArray());
      } finally {
         var1.close();
      }
   }

   public static void loadKeyStoreFromCertificates(KeyStore var0, CertificateFactory var1, InputStream var2) throws GeneralSecurityException {
      Iterator var4 = var1.generateCertificates(var2).iterator();

      for (int var3 = 0; var4.hasNext(); var3++) {
         var0.setCertificateEntry(String.valueOf(var3), (Certificate)var4.next());
      }
   }

   public static PrivateKey loadPrivateKeyFromKeyStore(KeyStore var0, InputStream var1, String var2, String var3, String var4) throws IOException, GeneralSecurityException {
      loadKeyStore(var0, var1, var2);
      return getPrivateKey(var0, var3, var4);
   }

   public static byte[] sign(Signature var0, PrivateKey var1, byte[] var2) throws InvalidKeyException, SignatureException {
      var0.initSign(var1);
      var0.update(var2);
      return var0.sign();
   }

   public static X509Certificate verify(Signature var0, X509TrustManager var1, List<String> var2, byte[] var3, byte[] var4) throws InvalidKeyException, SignatureException {
      CertificateFactory var7;
      try {
         var7 = getX509CertificateFactory();
      } catch (CertificateException var11) {
         return null;
      }

      X509Certificate[] var6 = new X509Certificate[var2.size()];
      Iterator var13 = var2.iterator();
      int var5 = 0;

      while (true) {
         if (var13.hasNext()) {
            ByteArrayInputStream var8 = new ByteArrayInputStream(Base64.decodeBase64((String)var13.next()));

            label36: {
               try {
                  Certificate var14 = var7.generateCertificate(var8);
                  if (!(var14 instanceof X509Certificate)) {
                     break label36;
                  }

                  var6[var5] = (X509Certificate)var14;
               } catch (CertificateException var10) {
                  var12 = null;
                  break;
               }

               var5++;
               continue;
            }

            var12 = null;
            break;
         }

         try {
            var1.checkServerTrusted(var6, "RSA");
         } catch (CertificateException var9) {
            var12 = null;
            break;
         }

         if (verify(var0, var6[0].getPublicKey(), var3, var4)) {
            var12 = var6[0];
         } else {
            var12 = null;
         }
         break;
      }

      return var12;
   }

   public static boolean verify(Signature var0, PublicKey var1, byte[] var2, byte[] var3) throws InvalidKeyException, SignatureException {
      var0.initVerify(var1);
      var0.update(var3);

      boolean var4;
      try {
         var4 = var0.verify(var2);
      } catch (SignatureException var5) {
         var4 = false;
      }

      return var4;
   }
}
