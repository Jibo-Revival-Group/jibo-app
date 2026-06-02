package org.apache.http.ssl;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

@NotThreadSafe
public class SSLContextBuilder {
   static final String TLS = "TLS";
   private final Set<KeyManager> keymanagers = new LinkedHashSet<>();
   private String protocol;
   private SecureRandom secureRandom;
   private final Set<TrustManager> trustmanagers = new LinkedHashSet<>();

   public static SSLContextBuilder create() {
      return new SSLContextBuilder();
   }

   public SSLContext build() throws NoSuchAlgorithmException, KeyManagementException {
      String var1;
      if (this.protocol != null) {
         var1 = this.protocol;
      } else {
         var1 = "TLS";
      }

      SSLContext var2 = SSLContext.getInstance(var1);
      this.initSSLContext(var2, this.keymanagers, this.trustmanagers, this.secureRandom);
      return var2;
   }

   protected void initSSLContext(SSLContext var1, Collection<KeyManager> var2, Collection<TrustManager> var3, SecureRandom var4) throws KeyManagementException {
      KeyManager[] var5;
      if (!var2.isEmpty()) {
         var5 = var2.toArray(new KeyManager[var2.size()]);
      } else {
         var5 = null;
      }

      TrustManager[] var6;
      if (!var3.isEmpty()) {
         var6 = var3.toArray(new TrustManager[var3.size()]);
      } else {
         var6 = null;
      }

      var1.init(var5, var6, var4);
   }

   public SSLContextBuilder loadKeyMaterial(File var1, char[] var2, char[] var3) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {
      return this.loadKeyMaterial(var1, var2, var3, null);
   }

   public SSLContextBuilder loadKeyMaterial(File var1, char[] var2, char[] var3, PrivateKeyStrategy var4) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {
      Args.notNull(var1, "Keystore file");
      KeyStore var5 = KeyStore.getInstance(KeyStore.getDefaultType());
      FileInputStream var8 = new FileInputStream(var1);

      try {
         var5.load(var8, var2);
      } finally {
         var8.close();
      }

      return this.loadKeyMaterial(var5, var3, var4);
   }

   public SSLContextBuilder loadKeyMaterial(URL var1, char[] var2, char[] var3) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {
      return this.loadKeyMaterial(var1, var2, var3, null);
   }

   public SSLContextBuilder loadKeyMaterial(URL var1, char[] var2, char[] var3, PrivateKeyStrategy var4) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {
      Args.notNull(var1, "Keystore URL");
      KeyStore var5 = KeyStore.getInstance(KeyStore.getDefaultType());
      InputStream var8 = FirebasePerfUrlConnection.openStream(var1);

      try {
         var5.load(var8, var2);
      } finally {
         var8.close();
      }

      return this.loadKeyMaterial(var5, var3, var4);
   }

   public SSLContextBuilder loadKeyMaterial(KeyStore var1, char[] var2) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException {
      return this.loadKeyMaterial(var1, var2, null);
   }

   public SSLContextBuilder loadKeyMaterial(KeyStore var1, char[] var2, PrivateKeyStrategy var3) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException {
      byte var5 = 0;
      KeyManagerFactory var7 = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
      var7.init(var1, var2);
      KeyManager[] var8 = var7.getKeyManagers();
      if (var8 != null) {
         if (var3 != null) {
            for (int var4 = 0; var4 < var8.length; var4++) {
               KeyManager var9 = var8[var4];
               if (var9 instanceof X509ExtendedKeyManager) {
                  var8[var4] = new SSLContextBuilder.KeyManagerDelegate((X509ExtendedKeyManager)var9, var3);
               }
            }
         }

         int var6 = var8.length;

         for (int var11 = var5; var11 < var6; var11++) {
            KeyManager var10 = var8[var11];
            this.keymanagers.add(var10);
         }
      }

      return this;
   }

   public SSLContextBuilder loadTrustMaterial(File var1) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
      return this.loadTrustMaterial(var1, null);
   }

   public SSLContextBuilder loadTrustMaterial(File var1, char[] var2) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
      return this.loadTrustMaterial(var1, var2, null);
   }

   public SSLContextBuilder loadTrustMaterial(File var1, char[] var2, TrustStrategy var3) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
      Args.notNull(var1, "Truststore file");
      KeyStore var4 = KeyStore.getInstance(KeyStore.getDefaultType());
      FileInputStream var7 = new FileInputStream(var1);

      try {
         var4.load(var7, var2);
      } finally {
         var7.close();
      }

      return this.loadTrustMaterial(var4, var3);
   }

   public SSLContextBuilder loadTrustMaterial(URL var1, char[] var2) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
      return this.loadTrustMaterial(var1, var2, null);
   }

   public SSLContextBuilder loadTrustMaterial(URL var1, char[] var2, TrustStrategy var3) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
      Args.notNull(var1, "Truststore URL");
      KeyStore var4 = KeyStore.getInstance(KeyStore.getDefaultType());
      InputStream var7 = FirebasePerfUrlConnection.openStream(var1);

      try {
         var4.load(var7, var2);
      } finally {
         var7.close();
      }

      return this.loadTrustMaterial(var4, var3);
   }

   public SSLContextBuilder loadTrustMaterial(KeyStore var1, TrustStrategy var2) throws NoSuchAlgorithmException, KeyStoreException {
      byte var4 = 0;
      TrustManagerFactory var6 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      var6.init(var1);
      TrustManager[] var7 = var6.getTrustManagers();
      if (var7 != null) {
         if (var2 != null) {
            for (int var3 = 0; var3 < var7.length; var3++) {
               TrustManager var10 = var7[var3];
               if (var10 instanceof X509TrustManager) {
                  var7[var3] = new SSLContextBuilder.TrustManagerDelegate((X509TrustManager)var10, var2);
               }
            }
         }

         int var5 = var7.length;

         for (int var9 = var4; var9 < var5; var9++) {
            TrustManager var8 = var7[var9];
            this.trustmanagers.add(var8);
         }
      }

      return this;
   }

   public SSLContextBuilder loadTrustMaterial(TrustStrategy var1) throws NoSuchAlgorithmException, KeyStoreException {
      return this.loadTrustMaterial(null, var1);
   }

   public SSLContextBuilder setSecureRandom(SecureRandom var1) {
      this.secureRandom = var1;
      return this;
   }

   public SSLContextBuilder useProtocol(String var1) {
      this.protocol = var1;
      return this;
   }

   static class KeyManagerDelegate extends X509ExtendedKeyManager {
      private final PrivateKeyStrategy aliasStrategy;
      private final X509ExtendedKeyManager keyManager;

      KeyManagerDelegate(X509ExtendedKeyManager var1, PrivateKeyStrategy var2) {
         this.keyManager = var1;
         this.aliasStrategy = var2;
      }

      @Override
      public String chooseClientAlias(String[] var1, Principal[] var2, Socket var3) {
         Map var4 = this.getClientAliasMap(var1, var2);
         return this.aliasStrategy.chooseAlias(var4, var3);
      }

      @Override
      public String chooseEngineClientAlias(String[] var1, Principal[] var2, SSLEngine var3) {
         Map var4 = this.getClientAliasMap(var1, var2);
         return this.aliasStrategy.chooseAlias(var4, null);
      }

      @Override
      public String chooseEngineServerAlias(String var1, Principal[] var2, SSLEngine var3) {
         Map var4 = this.getServerAliasMap(var1, var2);
         return this.aliasStrategy.chooseAlias(var4, null);
      }

      @Override
      public String chooseServerAlias(String var1, Principal[] var2, Socket var3) {
         Map var4 = this.getServerAliasMap(var1, var2);
         return this.aliasStrategy.chooseAlias(var4, var3);
      }

      @Override
      public X509Certificate[] getCertificateChain(String var1) {
         return this.keyManager.getCertificateChain(var1);
      }

      public Map<String, PrivateKeyDetails> getClientAliasMap(String[] var1, Principal[] var2) {
         HashMap var7 = new HashMap();

         for (String var10 : var1) {
            String[] var9 = this.keyManager.getClientAliases(var10, var2);
            if (var9 != null) {
               for (String var8 : var9) {
                  var7.put(var8, new PrivateKeyDetails(var10, this.keyManager.getCertificateChain(var8)));
               }
            }
         }

         return var7;
      }

      @Override
      public String[] getClientAliases(String var1, Principal[] var2) {
         return this.keyManager.getClientAliases(var1, var2);
      }

      @Override
      public PrivateKey getPrivateKey(String var1) {
         return this.keyManager.getPrivateKey(var1);
      }

      public Map<String, PrivateKeyDetails> getServerAliasMap(String var1, Principal[] var2) {
         HashMap var5 = new HashMap();
         String[] var7 = this.keyManager.getServerAliases(var1, var2);
         if (var7 != null) {
            for (String var6 : var7) {
               var5.put(var6, new PrivateKeyDetails(var1, this.keyManager.getCertificateChain(var6)));
            }
         }

         return var5;
      }

      @Override
      public String[] getServerAliases(String var1, Principal[] var2) {
         return this.keyManager.getServerAliases(var1, var2);
      }
   }

   static class TrustManagerDelegate implements X509TrustManager {
      private final X509TrustManager trustManager;
      private final TrustStrategy trustStrategy;

      TrustManagerDelegate(X509TrustManager var1, TrustStrategy var2) {
         this.trustManager = var1;
         this.trustStrategy = var2;
      }

      @Override
      public void checkClientTrusted(X509Certificate[] var1, String var2) throws CertificateException {
         this.trustManager.checkClientTrusted(var1, var2);
      }

      @Override
      public void checkServerTrusted(X509Certificate[] var1, String var2) throws CertificateException {
         if (!this.trustStrategy.isTrusted(var1, var2)) {
            this.trustManager.checkServerTrusted(var1, var2);
         }
      }

      @Override
      public X509Certificate[] getAcceptedIssuers() {
         return this.trustManager.getAcceptedIssuers();
      }
   }
}
