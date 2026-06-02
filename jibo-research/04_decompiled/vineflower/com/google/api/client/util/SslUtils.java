package com.google.api.client.util;

import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class SslUtils {
   private SslUtils() {
   }

   public static KeyManagerFactory getDefaultKeyManagerFactory() throws NoSuchAlgorithmException {
      return KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
   }

   public static TrustManagerFactory getDefaultTrustManagerFactory() throws NoSuchAlgorithmException {
      return TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
   }

   public static KeyManagerFactory getPkixKeyManagerFactory() throws NoSuchAlgorithmException {
      return KeyManagerFactory.getInstance("PKIX");
   }

   public static TrustManagerFactory getPkixTrustManagerFactory() throws NoSuchAlgorithmException {
      return TrustManagerFactory.getInstance("PKIX");
   }

   public static SSLContext getSslContext() throws NoSuchAlgorithmException {
      return SSLContext.getInstance("SSL");
   }

   public static SSLContext getTlsSslContext() throws NoSuchAlgorithmException {
      return SSLContext.getInstance("TLS");
   }

   public static SSLContext initSslContext(SSLContext var0, KeyStore var1, TrustManagerFactory var2) throws GeneralSecurityException {
      var2.init(var1);
      var0.init(null, var2.getTrustManagers(), null);
      return var0;
   }

   @Beta
   public static HostnameVerifier trustAllHostnameVerifier() {
      return new HostnameVerifier() {
         @Override
         public boolean verify(String var1, SSLSession var2) {
            return true;
         }
      };
   }

   @Beta
   public static SSLContext trustAllSSLContext() throws GeneralSecurityException {
      X509TrustManager var0 = new X509TrustManager() {
         @Override
         public void checkClientTrusted(X509Certificate[] var1, String var2) throws CertificateException {
         }

         @Override
         public void checkServerTrusted(X509Certificate[] var1, String var2) throws CertificateException {
         }

         @Override
         public X509Certificate[] getAcceptedIssuers() {
            return null;
         }
      };
      SSLContext var1 = getTlsSslContext();
      var1.init(null, new TrustManager[]{var0}, null);
      return var1;
   }
}
