package com.salesforce.androidsdk.auth;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SalesforceTLSSocketFactory extends SSLSocketFactory {
   private static SalesforceTLSSocketFactory INSTANCE;
   private SSLSocketFactory delegate;

   public SalesforceTLSSocketFactory() throws KeyManagementException, NoSuchAlgorithmException {
      SSLContext var1 = SSLContext.getInstance("TLS");
      var1.init(null, null, null);
      this.delegate = var1.getSocketFactory();
   }

   private Socket disableTLS1Dot0(Socket var1) {
      if (var1 != null && var1 instanceof SSLSocket) {
         ((SSLSocket)var1).setEnabledProtocols(new String[]{"TLSv1.1", "TLSv1.2"});
      }

      return var1;
   }

   public static SalesforceTLSSocketFactory getInstance() throws KeyManagementException, NoSuchAlgorithmException {
      if (INSTANCE == null) {
         INSTANCE = new SalesforceTLSSocketFactory();
      }

      return INSTANCE;
   }

   @Override
   public Socket createSocket(String var1, int var2) throws IOException {
      return this.disableTLS1Dot0(this.delegate.createSocket(var1, var2));
   }

   @Override
   public Socket createSocket(String var1, int var2, InetAddress var3, int var4) throws IOException {
      return this.disableTLS1Dot0(this.delegate.createSocket(var1, var2, var3, var4));
   }

   @Override
   public Socket createSocket(InetAddress var1, int var2) throws IOException {
      return this.disableTLS1Dot0(this.delegate.createSocket(var1, var2));
   }

   @Override
   public Socket createSocket(InetAddress var1, int var2, InetAddress var3, int var4) throws IOException {
      return this.disableTLS1Dot0(this.delegate.createSocket(var1, var2, var3, var4));
   }

   @Override
   public Socket createSocket(Socket var1, String var2, int var3, boolean var4) throws IOException {
      return this.disableTLS1Dot0(this.delegate.createSocket(var1, var2, var3, var4));
   }

   @Override
   public String[] getDefaultCipherSuites() {
      return this.delegate.getDefaultCipherSuites();
   }

   @Override
   public String[] getSupportedCipherSuites() {
      return this.delegate.getSupportedCipherSuites();
   }
}
