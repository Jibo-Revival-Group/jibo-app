package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.Fabric;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

class PinningTrustManager implements X509TrustManager {
   private static final X509Certificate[] a = new X509Certificate[0];
   private final TrustManager[] b;
   private final SystemKeyStore c;
   private final long d;
   private final List<byte[]> e = new LinkedList<>();
   private final Set<X509Certificate> f = Collections.synchronizedSet(new HashSet<>());

   public PinningTrustManager(SystemKeyStore var1, PinningInfoProvider var2) {
      this.b = this.a(var1);
      this.c = var1;
      this.d = var2.d();

      for (String var6 : var2.c()) {
         this.e.add(this.a(var6));
      }
   }

   private void a(X509Certificate[] var1) throws CertificateException {
      if (this.d != -1L && System.currentTimeMillis() - this.d > 15552000000L) {
         Fabric.h()
            .d(
               "Fabric",
               "Certificate pins are stale, ("
                  + (System.currentTimeMillis() - this.d)
                  + " millis vs "
                  + 15552000000L
                  + " millis) falling back to system trust."
            );
      } else {
         var1 = CertificateChainCleaner.a(var1, this.c);
         int var3 = var1.length;
         int var2 = 0;

         while (true) {
            if (var2 >= var3) {
               throw new CertificateException("No valid pins found in chain!");
            }

            if (this.a(var1[var2])) {
               break;
            }

            var2++;
         }
      }
   }

   private void a(X509Certificate[] var1, String var2) throws CertificateException {
      TrustManager[] var5 = this.b;
      int var4 = var5.length;

      for (int var3 = 0; var3 < var4; var3++) {
         ((X509TrustManager)var5[var3]).checkServerTrusted(var1, var2);
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private boolean a(X509Certificate var1) throws CertificateException {
      byte[] var3;
      try {
         var3 = MessageDigest.getInstance("SHA1").digest(var1.getPublicKey().getEncoded());
         var6 = this.e.iterator();
      } catch (NoSuchAlgorithmException var4) {
         throw new CertificateException(var4);
      }

      boolean var2;
      do {
         try {
            if (!var6.hasNext()) {
               return false;
            }

            var2 = Arrays.equals((byte[])var6.next(), var3);
         } catch (NoSuchAlgorithmException var5) {
            throw new CertificateException(var5);
         }
      } while (!var2);

      return true;
   }

   private byte[] a(String var1) {
      int var3 = var1.length();
      byte[] var4 = new byte[var3 / 2];

      for (byte var2 = 0; var2 < var3; var2 += 2) {
         var4[var2 / 2] = (byte)((Character.digit(var1.charAt(var2), 16) << 4) + Character.digit(var1.charAt(var2 + 1), 16));
      }

      return var4;
   }

   private TrustManager[] a(SystemKeyStore var1) {
      try {
         TrustManagerFactory var2 = TrustManagerFactory.getInstance("X509");
         var2.init(var1.a);
         return var2.getTrustManagers();
      } catch (NoSuchAlgorithmException var3) {
         throw new AssertionError(var3);
      } catch (KeyStoreException var4) {
         throw new AssertionError(var4);
      }
   }

   @Override
   public void checkClientTrusted(X509Certificate[] var1, String var2) throws CertificateException {
      throw new CertificateException("Client certificates not supported!");
   }

   @Override
   public void checkServerTrusted(X509Certificate[] var1, String var2) throws CertificateException {
      if (!this.f.contains(var1[0])) {
         this.a(var1, var2);
         this.a(var1);
         this.f.add(var1[0]);
      }
   }

   @Override
   public X509Certificate[] getAcceptedIssuers() {
      return a;
   }
}
