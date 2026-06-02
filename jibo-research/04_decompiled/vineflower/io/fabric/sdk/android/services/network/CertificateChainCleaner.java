package io.fabric.sdk.android.services.network;

import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.LinkedList;

final class CertificateChainCleaner {
   private static boolean a(X509Certificate var0, X509Certificate var1) {
      boolean var2 = false;
      if (var0.getSubjectX500Principal().equals(var1.getIssuerX500Principal())) {
         try {
            var1.verify(var0.getPublicKey());
         } catch (GeneralSecurityException var3) {
            return var2;
         }

         var2 = true;
      }

      return var2;
   }

   public static X509Certificate[] a(X509Certificate[] var0, SystemKeyStore var1) throws CertificateException {
      boolean var5 = true;
      LinkedList var6 = new LinkedList();
      boolean var2;
      if (var1.a(var0[0])) {
         var2 = true;
      } else {
         var2 = false;
      }

      var6.add(var0[0]);
      int var4 = 1;
      boolean var3 = var2;

      while (true) {
         var2 = var3;
         if (var4 >= var0.length) {
            break;
         }

         if (var1.a(var0[var4])) {
            var3 = true;
         }

         var2 = var3;
         if (!a(var0[var4], var0[var4 - 1])) {
            break;
         }

         var6.add(var0[var4]);
         var4++;
      }

      X509Certificate var7 = var1.b(var0[var4 - 1]);
      if (var7 != null) {
         var6.add(var7);
         var2 = var5;
      }

      if (var2) {
         return var6.toArray(new X509Certificate[var6.size()]);
      } else {
         throw new CertificateException("Didn't find a trust anchor in chain cleanup!");
      }
   }
}
