package com.salesforce.android.service.common.http;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class TlsSocketFactory extends SSLSocketFactory {
   private SSLSocketFactory a;

   public TlsSocketFactory() throws KeyManagementException, NoSuchAlgorithmException {
      SSLContext var1 = SSLContext.getInstance("TLSv1.2");
      var1.init(null, null, null);
      this.a = var1.getSocketFactory();
   }

   private Socket a(Socket var1) {
      if (var1 != null && var1 instanceof SSLSocket) {
         ((SSLSocket)var1).setEnabledProtocols(new String[]{"TLSv1.2"});
      }

      return var1;
   }

   public static X509TrustManager a() {
      try {
         TrustManagerFactory var0 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
         var0.init((KeyStore)null);
         TrustManager[] var4 = var0.getTrustManagers();
         if (var4.length == 1 && var4[0] instanceof X509TrustManager) {
            return (X509TrustManager)var4[0];
         }

         StringBuilder var1 = new StringBuilder();
         IllegalStateException var2 = new IllegalStateException(var1.append("Unexpected default trust managers:").append(Arrays.toString(var4)).toString());
         throw var2;
      } catch (GeneralSecurityException var3) {
         throw new AssertionError();
      }
   }

   @Override
   public Socket createSocket(String var1, int var2) throws IOException {
      return this.a(this.a.createSocket(var1, var2));
   }

   @Override
   public Socket createSocket(String var1, int var2, InetAddress var3, int var4) throws IOException {
      return this.a(this.a.createSocket(var1, var2, var3, var4));
   }

   @Override
   public Socket createSocket(InetAddress var1, int var2) throws IOException {
      return this.a(this.a.createSocket(var1, var2));
   }

   @Override
   public Socket createSocket(InetAddress var1, int var2, InetAddress var3, int var4) throws IOException {
      return this.a(this.a.createSocket(var1, var2, var3, var4));
   }

   @Override
   public Socket createSocket(Socket var1, String var2, int var3, boolean var4) throws IOException {
      return this.a(this.a.createSocket(var1, var2, var3, var4));
   }

   @Override
   public String[] getDefaultCipherSuites() {
      return this.a.getDefaultCipherSuites();
   }

   @Override
   public String[] getSupportedCipherSuites() {
      return this.a.getSupportedCipherSuites();
   }
}
