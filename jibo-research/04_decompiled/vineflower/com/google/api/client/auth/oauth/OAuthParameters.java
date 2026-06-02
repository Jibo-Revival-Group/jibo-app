package com.google.api.client.auth.oauth;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.util.Beta;
import com.google.api.client.util.escape.PercentEscaper;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map.Entry;

@Beta
public final class OAuthParameters implements HttpExecuteInterceptor, HttpRequestInitializer {
   private static final PercentEscaper ESCAPER = new PercentEscaper("-_.~", false);
   private static final SecureRandom RANDOM = new SecureRandom();
   public String callback;
   public String consumerKey;
   public String nonce;
   public String realm;
   public String signature;
   public String signatureMethod;
   public OAuthSigner signer;
   public String timestamp;
   public String token;
   public String verifier;
   public String version;

   private void appendParameter(StringBuilder var1, String var2, String var3) {
      if (var3 != null) {
         var1.append(' ').append(escape(var2)).append("=\"").append(escape(var3)).append("\",");
      }
   }

   public static String escape(String var0) {
      return ESCAPER.escape(var0);
   }

   private void putParameter(TreeMap<String, String> var1, String var2, Object var3) {
      String var4 = escape(var2);
      if (var3 == null) {
         var2 = null;
      } else {
         var2 = escape(var3.toString());
      }

      var1.put(var4, var2);
   }

   private void putParameterIfValueNotNull(TreeMap<String, String> var1, String var2, String var3) {
      if (var3 != null) {
         this.putParameter(var1, var2, var3);
      }
   }

   public void computeNonce() {
      this.nonce = Long.toHexString(Math.abs(RANDOM.nextLong()));
   }

   public void computeSignature(String var1, GenericUrl var2) throws GeneralSecurityException {
      OAuthSigner var5 = this.signer;
      String var7 = var5.getSignatureMethod();
      this.signatureMethod = var7;
      TreeMap var6 = new TreeMap();
      this.putParameterIfValueNotNull(var6, "oauth_callback", this.callback);
      this.putParameterIfValueNotNull(var6, "oauth_consumer_key", this.consumerKey);
      this.putParameterIfValueNotNull(var6, "oauth_nonce", this.nonce);
      this.putParameterIfValueNotNull(var6, "oauth_signature_method", var7);
      this.putParameterIfValueNotNull(var6, "oauth_timestamp", this.timestamp);
      this.putParameterIfValueNotNull(var6, "oauth_token", this.token);
      this.putParameterIfValueNotNull(var6, "oauth_verifier", this.verifier);
      this.putParameterIfValueNotNull(var6, "oauth_version", this.version);

      for (Entry var8 : var2.entrySet()) {
         Object var9 = var8.getValue();
         if (var9 != null) {
            String var18 = (String)var8.getKey();
            if (var9 instanceof Collection) {
               Iterator var22 = ((Collection)var9).iterator();

               while (var22.hasNext()) {
                  this.putParameter(var6, var18, var22.next());
               }
            } else {
               this.putParameter(var6, var18, var9);
            }
         }
      }

      StringBuilder var15 = new StringBuilder();
      Iterator var12 = var6.entrySet().iterator();
      int var3 = 1;

      while (var12.hasNext()) {
         Entry var19 = (Entry)var12.next();
         if (var3) {
            var3 = 0;
         } else {
            var15.append('&');
         }

         var15.append((String)var19.getKey());
         String var20 = (String)var19.getValue();
         if (var20 != null) {
            var15.append('=').append(var20);
         }
      }

      label69: {
         var13 = var15.toString();
         var16 = new GenericUrl();
         String var21 = var2.getScheme();
         var16.setScheme(var21);
         var16.setHost(var2.getHost());
         var16.setPathParts(var2.getPathParts());
         int var4 = var2.getPort();
         if (!"http".equals(var21) || var4 != 80) {
            var3 = var4;
            if (!"https".equals(var21)) {
               break label69;
            }

            var3 = var4;
            if (var4 != 443) {
               break label69;
            }
         }

         var3 = -1;
      }

      var16.setPort(var3);
      var7 = var16.build();
      StringBuilder var10 = new StringBuilder();
      var10.append(escape(var1)).append('&');
      var10.append(escape(var7)).append('&');
      var10.append(escape(var13));
      this.signature = var5.computeSignature(var10.toString());
   }

   public void computeTimestamp() {
      this.timestamp = Long.toString(System.currentTimeMillis() / 1000L);
   }

   public String getAuthorizationHeader() {
      StringBuilder var1 = new StringBuilder("OAuth");
      this.appendParameter(var1, "realm", this.realm);
      this.appendParameter(var1, "oauth_callback", this.callback);
      this.appendParameter(var1, "oauth_consumer_key", this.consumerKey);
      this.appendParameter(var1, "oauth_nonce", this.nonce);
      this.appendParameter(var1, "oauth_signature", this.signature);
      this.appendParameter(var1, "oauth_signature_method", this.signatureMethod);
      this.appendParameter(var1, "oauth_timestamp", this.timestamp);
      this.appendParameter(var1, "oauth_token", this.token);
      this.appendParameter(var1, "oauth_verifier", this.verifier);
      this.appendParameter(var1, "oauth_version", this.version);
      return var1.substring(0, var1.length() - 1);
   }

   @Override
   public void initialize(HttpRequest var1) throws IOException {
      var1.setInterceptor(this);
   }

   @Override
   public void intercept(HttpRequest var1) throws IOException {
      this.computeNonce();
      this.computeTimestamp();

      try {
         this.computeSignature(var1.getRequestMethod(), var1.getUrl());
      } catch (GeneralSecurityException var3) {
         IOException var2 = new IOException();
         var2.initCause(var3);
         throw var2;
      }

      var1.getHeaders().setAuthorization(this.getAuthorizationHeader());
   }
}
