package com.google.api.client.http.javanet;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.SecurityUtils;
import com.google.api.client.util.SslUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Arrays;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public final class NetHttpTransport extends HttpTransport {
   private static final String[] SUPPORTED_METHODS = new String[]{"DELETE", "GET", "HEAD", "OPTIONS", "POST", "PUT", "TRACE"};
   private final ConnectionFactory connectionFactory;
   private final HostnameVerifier hostnameVerifier;
   private final SSLSocketFactory sslSocketFactory;

   static {
      Arrays.sort(SUPPORTED_METHODS);
   }

   public NetHttpTransport() {
      this((ConnectionFactory)null, null, null);
   }

   NetHttpTransport(ConnectionFactory var1, SSLSocketFactory var2, HostnameVerifier var3) {
      ConnectionFactory var4 = var1;
      if (var1 == null) {
         var4 = new DefaultConnectionFactory();
      }

      this.connectionFactory = var4;
      this.sslSocketFactory = var2;
      this.hostnameVerifier = var3;
   }

   NetHttpTransport(Proxy var1, SSLSocketFactory var2, HostnameVerifier var3) {
      this(new DefaultConnectionFactory(var1), var2, var3);
   }

   protected NetHttpRequest buildRequest(String var1, String var2) throws IOException {
      Preconditions.checkArgument(this.supportsMethod(var1), "HTTP method %s not supported", var1);
      URL var4 = new URL(var2);
      HttpURLConnection var5 = this.connectionFactory.openConnection(var4);
      var5.setRequestMethod(var1);
      if (var5 instanceof HttpsURLConnection) {
         HttpsURLConnection var3 = (HttpsURLConnection)var5;
         if (this.hostnameVerifier != null) {
            var3.setHostnameVerifier(this.hostnameVerifier);
         }

         if (this.sslSocketFactory != null) {
            var3.setSSLSocketFactory(this.sslSocketFactory);
         }
      }

      return new NetHttpRequest(var5);
   }

   @Override
   public boolean supportsMethod(String var1) {
      boolean var2;
      if (Arrays.binarySearch(SUPPORTED_METHODS, var1) >= 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public static final class Builder {
      private ConnectionFactory connectionFactory;
      private HostnameVerifier hostnameVerifier;
      private Proxy proxy;
      private SSLSocketFactory sslSocketFactory;

      public NetHttpTransport build() {
         NetHttpTransport var1;
         if (this.proxy == null) {
            var1 = new NetHttpTransport(this.connectionFactory, this.sslSocketFactory, this.hostnameVerifier);
         } else {
            var1 = new NetHttpTransport(this.proxy, this.sslSocketFactory, this.hostnameVerifier);
         }

         return var1;
      }

      @Beta
      public NetHttpTransport.Builder doNotValidateCertificate() throws GeneralSecurityException {
         this.hostnameVerifier = SslUtils.trustAllHostnameVerifier();
         this.sslSocketFactory = SslUtils.trustAllSSLContext().getSocketFactory();
         return this;
      }

      public HostnameVerifier getHostnameVerifier() {
         return this.hostnameVerifier;
      }

      public SSLSocketFactory getSslSocketFactory() {
         return this.sslSocketFactory;
      }

      public NetHttpTransport.Builder setConnectionFactory(ConnectionFactory var1) {
         this.connectionFactory = var1;
         return this;
      }

      public NetHttpTransport.Builder setHostnameVerifier(HostnameVerifier var1) {
         this.hostnameVerifier = var1;
         return this;
      }

      public NetHttpTransport.Builder setProxy(Proxy var1) {
         this.proxy = var1;
         return this;
      }

      public NetHttpTransport.Builder setSslSocketFactory(SSLSocketFactory var1) {
         this.sslSocketFactory = var1;
         return this;
      }

      public NetHttpTransport.Builder trustCertificates(KeyStore var1) throws GeneralSecurityException {
         SSLContext var2 = SslUtils.getTlsSslContext();
         SslUtils.initSslContext(var2, var1, SslUtils.getPkixTrustManagerFactory());
         return this.setSslSocketFactory(var2.getSocketFactory());
      }

      public NetHttpTransport.Builder trustCertificatesFromJavaKeyStore(InputStream var1, String var2) throws GeneralSecurityException, IOException {
         KeyStore var3 = SecurityUtils.getJavaKeyStore();
         SecurityUtils.loadKeyStore(var3, var1, var2);
         return this.trustCertificates(var3);
      }

      public NetHttpTransport.Builder trustCertificatesFromStream(InputStream var1) throws GeneralSecurityException, IOException {
         KeyStore var2 = SecurityUtils.getJavaKeyStore();
         var2.load(null, null);
         SecurityUtils.loadKeyStoreFromCertificates(var2, SecurityUtils.getX509CertificateFactory(), var1);
         return this.trustCertificates(var2);
      }
   }
}
