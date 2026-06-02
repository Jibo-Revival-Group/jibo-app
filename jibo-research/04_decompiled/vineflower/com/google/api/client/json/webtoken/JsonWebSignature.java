package com.google.api.client.json.webtoken;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Base64;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.SecurityUtils;
import com.google.api.client.util.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class JsonWebSignature extends JsonWebToken {
   private final byte[] signatureBytes;
   private final byte[] signedContentBytes;

   public JsonWebSignature(JsonWebSignature.Header var1, JsonWebToken.Payload var2, byte[] var3, byte[] var4) {
      super(var1, var2);
      this.signatureBytes = Preconditions.checkNotNull(var3);
      this.signedContentBytes = Preconditions.checkNotNull(var4);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static X509TrustManager getDefaultX509TrustManager() {
      int var1;
      TrustManager[] var9;
      try {
         TrustManagerFactory var8 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
         var8.init((KeyStore)null);
         var9 = var8.getTrustManagers();
         var1 = ((Object[])var9).length;
      } catch (NoSuchAlgorithmException var6) {
         return null;
      } catch (KeyStoreException var7) {
         return null;
      }

      int var0 = 0;

      while (true) {
         if (var0 >= var1) {
            var9 = null;
            break;
         }

         TrustManager var3 = ((Object[])var9)[var0];

         try {
            if (var3 instanceof X509TrustManager) {
               var9 = (X509TrustManager)var3;
               break;
            }
         } catch (NoSuchAlgorithmException var4) {
            var9 = null;
            break;
         } catch (KeyStoreException var5) {
            var9 = null;
            break;
         }

         var0++;
      }

      return var9;
   }

   public static JsonWebSignature parse(JsonFactory var0, String var1) throws IOException {
      return parser(var0).parse(var1);
   }

   public static JsonWebSignature.Parser parser(JsonFactory var0) {
      return new JsonWebSignature.Parser(var0);
   }

   public static String signUsingRsaSha256(PrivateKey var0, JsonFactory var1, JsonWebSignature.Header var2, JsonWebToken.Payload var3) throws GeneralSecurityException, IOException {
      String var9 = String.valueOf(String.valueOf(Base64.encodeBase64URLSafeString(var1.toByteArray(var2))));
      String var6 = String.valueOf(String.valueOf(Base64.encodeBase64URLSafeString(var1.toByteArray(var3))));
      String var7 = new StringBuilder(var9.length() + 1 + var6.length()).append(var9).append(".").append(var6).toString();
      byte[] var10 = StringUtils.getBytesUtf8(var7);
      byte[] var4 = SecurityUtils.sign(SecurityUtils.getSha256WithRsaSignatureAlgorithm(), var0, var10);
      String var8 = String.valueOf(String.valueOf(var7));
      String var5 = String.valueOf(String.valueOf(Base64.encodeBase64URLSafeString(var4)));
      return new StringBuilder(var8.length() + 1 + var5.length()).append(var8).append(".").append(var5).toString();
   }

   public JsonWebSignature.Header getHeader() {
      return (JsonWebSignature.Header)super.getHeader();
   }

   public final byte[] getSignatureBytes() {
      return this.signatureBytes;
   }

   public final byte[] getSignedContentBytes() {
      return this.signedContentBytes;
   }

   @Beta
   public final X509Certificate verifySignature() throws GeneralSecurityException {
      X509TrustManager var1 = getDefaultX509TrustManager();
      X509Certificate var2;
      if (var1 == null) {
         var2 = null;
      } else {
         var2 = this.verifySignature(var1);
      }

      return var2;
   }

   @Beta
   public final X509Certificate verifySignature(X509TrustManager var1) throws GeneralSecurityException {
      Object var3 = null;
      List var4 = this.getHeader().getX509Certificates();
      X509Certificate var2 = (X509Certificate)var3;
      if (var4 != null) {
         if (var4.isEmpty()) {
            var2 = (X509Certificate)var3;
         } else {
            var2 = (X509Certificate)var3;
            if ("RS256".equals(this.getHeader().getAlgorithm())) {
               var2 = SecurityUtils.verify(SecurityUtils.getSha256WithRsaSignatureAlgorithm(), var1, var4, this.signatureBytes, this.signedContentBytes);
            }
         }
      }

      return var2;
   }

   public final boolean verifySignature(PublicKey var1) throws GeneralSecurityException {
      boolean var2;
      if ("RS256".equals(this.getHeader().getAlgorithm())) {
         var2 = SecurityUtils.verify(SecurityUtils.getSha256WithRsaSignatureAlgorithm(), var1, this.signatureBytes, this.signedContentBytes);
      } else {
         var2 = false;
      }

      return var2;
   }

   public static class Header extends JsonWebToken.Header {
      @Key("alg")
      private String algorithm;
      @Key("crit")
      private List<String> critical;
      @Key("jwk")
      private String jwk;
      @Key("jku")
      private String jwkUrl;
      @Key("kid")
      private String keyId;
      @Key("x5c")
      private List<String> x509Certificates;
      @Key("x5t")
      private String x509Thumbprint;
      @Key("x5u")
      private String x509Url;

      public JsonWebSignature.Header clone() {
         return (JsonWebSignature.Header)super.clone();
      }

      public final String getAlgorithm() {
         return this.algorithm;
      }

      public final List<String> getCritical() {
         return this.critical;
      }

      public final String getJwk() {
         return this.jwk;
      }

      public final String getJwkUrl() {
         return this.jwkUrl;
      }

      public final String getKeyId() {
         return this.keyId;
      }

      @Deprecated
      public final String getX509Certificate() {
         String var1;
         if (this.x509Certificates != null && !this.x509Certificates.isEmpty()) {
            var1 = this.x509Certificates.get(0);
         } else {
            var1 = null;
         }

         return var1;
      }

      public final List<String> getX509Certificates() {
         return this.x509Certificates;
      }

      public final String getX509Thumbprint() {
         return this.x509Thumbprint;
      }

      public final String getX509Url() {
         return this.x509Url;
      }

      public JsonWebSignature.Header set(String var1, Object var2) {
         return (JsonWebSignature.Header)super.set(var1, var2);
      }

      public JsonWebSignature.Header setAlgorithm(String var1) {
         this.algorithm = var1;
         return this;
      }

      public JsonWebSignature.Header setCritical(List<String> var1) {
         this.critical = var1;
         return this;
      }

      public JsonWebSignature.Header setJwk(String var1) {
         this.jwk = var1;
         return this;
      }

      public JsonWebSignature.Header setJwkUrl(String var1) {
         this.jwkUrl = var1;
         return this;
      }

      public JsonWebSignature.Header setKeyId(String var1) {
         this.keyId = var1;
         return this;
      }

      public JsonWebSignature.Header setType(String var1) {
         super.setType(var1);
         return this;
      }

      @Deprecated
      public JsonWebSignature.Header setX509Certificate(String var1) {
         ArrayList var2 = new ArrayList();
         var2.add(var1);
         this.x509Certificates = var2;
         return this;
      }

      public JsonWebSignature.Header setX509Certificates(List<String> var1) {
         this.x509Certificates = var1;
         return this;
      }

      public JsonWebSignature.Header setX509Thumbprint(String var1) {
         this.x509Thumbprint = var1;
         return this;
      }

      public JsonWebSignature.Header setX509Url(String var1) {
         this.x509Url = var1;
         return this;
      }
   }

   public static final class Parser {
      private Class<? extends JsonWebSignature.Header> headerClass = JsonWebSignature.Header.class;
      private final JsonFactory jsonFactory;
      private Class<? extends JsonWebToken.Payload> payloadClass = JsonWebToken.Payload.class;

      public Parser(JsonFactory var1) {
         this.jsonFactory = Preconditions.checkNotNull(var1);
      }

      public Class<? extends JsonWebSignature.Header> getHeaderClass() {
         return this.headerClass;
      }

      public JsonFactory getJsonFactory() {
         return this.jsonFactory;
      }

      public Class<? extends JsonWebToken.Payload> getPayloadClass() {
         return this.payloadClass;
      }

      public JsonWebSignature parse(String var1) throws IOException {
         boolean var5 = true;
         int var2 = var1.indexOf(46);
         boolean var4;
         if (var2 != -1) {
            var4 = true;
         } else {
            var4 = false;
         }

         Preconditions.checkArgument(var4);
         byte[] var8 = Base64.decodeBase64(var1.substring(0, var2));
         int var3 = var1.indexOf(46, var2 + 1);
         if (var3 != -1) {
            var4 = true;
         } else {
            var4 = false;
         }

         Preconditions.checkArgument(var4);
         if (var1.indexOf(46, var3 + 1) == -1) {
            var4 = true;
         } else {
            var4 = false;
         }

         Preconditions.checkArgument(var4);
         byte[] var6 = Base64.decodeBase64(var1.substring(var2 + 1, var3));
         byte[] var7 = Base64.decodeBase64(var1.substring(var3 + 1));
         byte[] var9 = StringUtils.getBytesUtf8(var1.substring(0, var3));
         JsonWebSignature.Header var13 = this.jsonFactory.fromInputStream(new ByteArrayInputStream(var8), this.headerClass);
         if (var13.getAlgorithm() != null) {
            var4 = var5;
         } else {
            var4 = false;
         }

         Preconditions.checkArgument(var4);
         return new JsonWebSignature(var13, this.jsonFactory.fromInputStream(new ByteArrayInputStream(var6), this.payloadClass), var7, var9);
      }

      public JsonWebSignature.Parser setHeaderClass(Class<? extends JsonWebSignature.Header> var1) {
         this.headerClass = var1;
         return this;
      }

      public JsonWebSignature.Parser setPayloadClass(Class<? extends JsonWebToken.Payload> var1) {
         this.payloadClass = var1;
         return this;
      }
   }
}
