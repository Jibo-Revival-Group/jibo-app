package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public final class GoogleClientSecrets extends GenericJson {
   @Key
   private GoogleClientSecrets.Details installed;
   @Key
   private GoogleClientSecrets.Details web;

   public static GoogleClientSecrets load(JsonFactory var0, Reader var1) throws IOException {
      return var0.fromReader(var1, GoogleClientSecrets.class);
   }

   public GoogleClientSecrets clone() {
      return (GoogleClientSecrets)super.clone();
   }

   public GoogleClientSecrets.Details getDetails() {
      boolean var3 = true;
      boolean var1;
      if (this.web == null) {
         var1 = true;
      } else {
         var1 = false;
      }

      boolean var2;
      if (this.installed == null) {
         var2 = true;
      } else {
         var2 = false;
      }

      if (var1 == var2) {
         var3 = false;
      }

      Preconditions.checkArgument(var3);
      GoogleClientSecrets.Details var4;
      if (this.web == null) {
         var4 = this.installed;
      } else {
         var4 = this.web;
      }

      return var4;
   }

   public GoogleClientSecrets.Details getInstalled() {
      return this.installed;
   }

   public GoogleClientSecrets.Details getWeb() {
      return this.web;
   }

   public GoogleClientSecrets set(String var1, Object var2) {
      return (GoogleClientSecrets)super.set(var1, var2);
   }

   public GoogleClientSecrets setInstalled(GoogleClientSecrets.Details var1) {
      this.installed = var1;
      return this;
   }

   public GoogleClientSecrets setWeb(GoogleClientSecrets.Details var1) {
      this.web = var1;
      return this;
   }

   public static final class Details extends GenericJson {
      @Key("auth_uri")
      private String authUri;
      @Key("client_id")
      private String clientId;
      @Key("client_secret")
      private String clientSecret;
      @Key("redirect_uris")
      private List<String> redirectUris;
      @Key("token_uri")
      private String tokenUri;

      public GoogleClientSecrets.Details clone() {
         return (GoogleClientSecrets.Details)super.clone();
      }

      public String getAuthUri() {
         return this.authUri;
      }

      public String getClientId() {
         return this.clientId;
      }

      public String getClientSecret() {
         return this.clientSecret;
      }

      public List<String> getRedirectUris() {
         return this.redirectUris;
      }

      public String getTokenUri() {
         return this.tokenUri;
      }

      public GoogleClientSecrets.Details set(String var1, Object var2) {
         return (GoogleClientSecrets.Details)super.set(var1, var2);
      }

      public GoogleClientSecrets.Details setAuthUri(String var1) {
         this.authUri = var1;
         return this;
      }

      public GoogleClientSecrets.Details setClientId(String var1) {
         this.clientId = var1;
         return this;
      }

      public GoogleClientSecrets.Details setClientSecret(String var1) {
         this.clientSecret = var1;
         return this;
      }

      public GoogleClientSecrets.Details setRedirectUris(List<String> var1) {
         this.redirectUris = var1;
         return this;
      }

      public GoogleClientSecrets.Details setTokenUri(String var1) {
         this.tokenUri = var1;
         return this;
      }
   }
}
