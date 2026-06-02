package io.fabric.sdk.android.services.network;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashMap;

class SystemKeyStore {
   final KeyStore a;
   private final HashMap<Principal, X509Certificate> b;

   public SystemKeyStore(InputStream var1, String var2) {
      KeyStore var3 = this.a(var1, var2);
      this.b = this.a(var3);
      this.a = var3;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private KeyStore a(InputStream var1, String var2) {
      BufferedInputStream var3;
      KeyStore var4;
      try {
         var4 = KeyStore.getInstance("BKS");
         var3 = new BufferedInputStream(var1);
      } catch (KeyStoreException var23) {
         throw new AssertionError(var23);
      } catch (NoSuchAlgorithmException var24) {
         throw new AssertionError(var24);
      } catch (CertificateException var25) {
         throw new AssertionError(var25);
      } catch (IOException var26) {
         throw new AssertionError(var26);
      }

      try {
         var4.load(var3, var2.toCharArray());
      } finally {
         try {
            var3.close();
         } catch (KeyStoreException var18) {
            throw new AssertionError(var18);
         } catch (NoSuchAlgorithmException var19) {
            throw new AssertionError(var19);
         } catch (CertificateException var20) {
            throw new AssertionError(var20);
         } catch (IOException var21) {
            throw new AssertionError(var21);
         }
      }

      return var4;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private HashMap<Principal, X509Certificate> a(KeyStore var1) {
      HashMap var2;
      Enumeration var3;
      try {
         var2 = new HashMap();
         var3 = var1.aliases();
      } catch (KeyStoreException var6) {
         throw new AssertionError(var6);
      }

      while (true) {
         X509Certificate var4;
         try {
            if (!var3.hasMoreElements()) {
               return var2;
            }

            var4 = (X509Certificate)var1.getCertificate((String)var3.nextElement());
         } catch (KeyStoreException var7) {
            throw new AssertionError(var7);
         }

         if (var4 != null) {
            try {
               var2.put(var4.getSubjectX500Principal(), var4);
            } catch (KeyStoreException var5) {
               throw new AssertionError(var5);
            }
         }
      }
   }

   public boolean a(X509Certificate var1) {
      X509Certificate var3 = this.b.get(var1.getSubjectX500Principal());
      boolean var2;
      if (var3 != null && var3.getPublicKey().equals(var1.getPublicKey())) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public X509Certificate b(X509Certificate var1) {
      X509Certificate var2 = this.b.get(var1.getIssuerX500Principal());
      if (var2 == null) {
         var1 = null;
      } else if (var2.getSubjectX500Principal().equals(var1.getSubjectX500Principal())) {
         var1 = null;
      } else {
         try {
            var1.verify(var2.getPublicKey());
         } catch (GeneralSecurityException var3) {
            var1 = null;
            return var1;
         }

         var1 = var2;
      }

      return var1;
   }
}
