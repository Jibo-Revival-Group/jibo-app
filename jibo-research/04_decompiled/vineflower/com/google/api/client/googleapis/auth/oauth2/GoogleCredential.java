package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.ClientParametersAuthentication;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.CredentialRefreshListener;
import com.google.api.client.auth.oauth2.TokenRequest;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.util.Utils;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.json.webtoken.JsonWebToken;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;
import com.google.api.client.util.Joiner;
import com.google.api.client.util.PemReader;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.SecurityUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GoogleCredential extends Credential {
   static final String SERVICE_ACCOUNT_FILE_TYPE = "service_account";
   static final String USER_FILE_TYPE = "authorized_user";
   @Beta
   private static DefaultCredentialProvider defaultCredentialProvider = new DefaultCredentialProvider();
   private String serviceAccountId;
   private PrivateKey serviceAccountPrivateKey;
   private String serviceAccountPrivateKeyId;
   private String serviceAccountProjectId;
   private Collection<String> serviceAccountScopes;
   private String serviceAccountUser;

   public GoogleCredential() {
      this(new GoogleCredential.Builder());
   }

   protected GoogleCredential(GoogleCredential.Builder var1) {
      super(var1);
      if (var1.serviceAccountPrivateKey == null) {
         boolean var2;
         if (var1.serviceAccountId == null && var1.serviceAccountScopes == null && var1.serviceAccountUser == null) {
            var2 = true;
         } else {
            var2 = false;
         }

         Preconditions.checkArgument(var2);
      } else {
         this.serviceAccountId = Preconditions.checkNotNull(var1.serviceAccountId);
         this.serviceAccountProjectId = var1.serviceAccountProjectId;
         Collection var3;
         if (var1.serviceAccountScopes == null) {
            var3 = Collections.emptyList();
         } else {
            var3 = Collections.unmodifiableCollection(var1.serviceAccountScopes);
         }

         this.serviceAccountScopes = var3;
         this.serviceAccountPrivateKey = var1.serviceAccountPrivateKey;
         this.serviceAccountPrivateKeyId = var1.serviceAccountPrivateKeyId;
         this.serviceAccountUser = var1.serviceAccountUser;
      }
   }

   @Beta
   public static GoogleCredential fromStream(InputStream var0) throws IOException {
      return fromStream(var0, Utils.getDefaultTransport(), Utils.getDefaultJsonFactory());
   }

   @Beta
   public static GoogleCredential fromStream(InputStream var0, HttpTransport var1, JsonFactory var2) throws IOException {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      GenericJson var4 = new JsonObjectParser(var2).parseAndClose(var0, OAuth2Utils.UTF_8, GenericJson.class);
      String var3 = (String)var4.get("type");
      if (var3 == null) {
         throw new IOException("Error reading credentials from stream, 'type' field not specified.");
      }

      GoogleCredential var5;
      if ("authorized_user".equals(var3)) {
         var5 = fromStreamUser(var4, var1, var2);
      } else {
         if (!"service_account".equals(var3)) {
            throw new IOException(
               String.format(
                  "Error reading credentials from stream, 'type' value '%s' not recognized. Expecting '%s' or '%s'.",
                  var3,
                  "authorized_user",
                  "service_account"
               )
            );
         }

         var5 = fromStreamServiceAccount(var4, var1, var2);
      }

      return var5;
   }

   @Beta
   private static GoogleCredential fromStreamServiceAccount(GenericJson var0, HttpTransport var1, JsonFactory var2) throws IOException {
      String var5 = (String)var0.get("client_id");
      String var4 = (String)var0.get("client_email");
      String var6 = (String)var0.get("private_key");
      String var3 = (String)var0.get("private_key_id");
      if (var5 != null && var4 != null && var6 != null && var3 != null) {
         PrivateKey var11 = privateKeyFromPkcs8(var6);
         List var10 = Collections.emptyList();
         GoogleCredential.Builder var8 = new GoogleCredential.Builder()
            .setTransport(var1)
            .setJsonFactory(var2)
            .setServiceAccountId(var4)
            .setServiceAccountScopes(var10)
            .setServiceAccountPrivateKey(var11)
            .setServiceAccountPrivateKeyId(var3);
         String var9 = (String)var0.get("token_uri");
         if (var9 != null) {
            var8.setTokenServerEncodedUrl(var9);
         }

         String var7 = (String)var0.get("project_id");
         if (var7 != null) {
            var8.setServiceAccountProjectId(var7);
         }

         return var8.build();
      } else {
         throw new IOException(
            "Error reading service account credential from stream, expecting  'client_id', 'client_email', 'private_key' and 'private_key_id'."
         );
      }
   }

   @Beta
   private static GoogleCredential fromStreamUser(GenericJson var0, HttpTransport var1, JsonFactory var2) throws IOException {
      String var4 = (String)var0.get("client_id");
      String var3 = (String)var0.get("client_secret");
      String var5 = (String)var0.get("refresh_token");
      if (var4 != null && var3 != null && var5 != null) {
         GoogleCredential var6 = new GoogleCredential.Builder().setClientSecrets(var4, var3).setTransport(var1).setJsonFactory(var2).build();
         var6.setRefreshToken(var5);
         var6.refreshToken();
         return var6;
      } else {
         throw new IOException("Error reading user credential from stream,  expecting 'client_id', 'client_secret' and 'refresh_token'.");
      }
   }

   @Beta
   public static GoogleCredential getApplicationDefault() throws IOException {
      return getApplicationDefault(Utils.getDefaultTransport(), Utils.getDefaultJsonFactory());
   }

   @Beta
   public static GoogleCredential getApplicationDefault(HttpTransport var0, JsonFactory var1) throws IOException {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return defaultCredentialProvider.getDefaultCredential(var0, var1);
   }

   @Beta
   private static PrivateKey privateKeyFromPkcs8(String var0) throws IOException {
      PemReader.Section var3 = PemReader.readFirstSectionAndClose(new StringReader(var0), "PRIVATE KEY");
      if (var3 == null) {
         throw new IOException("Invalid PKCS8 data.");
      }

      PKCS8EncodedKeySpec var4 = new PKCS8EncodedKeySpec(var3.getBase64DecodedBytes());

      try {
         return SecurityUtils.getRsaKeyFactory().generatePrivate(var4);
      } catch (NoSuchAlgorithmException var1) {
         var5 = var1;
      } catch (InvalidKeySpecException var2) {
         var5 = var2;
      }

      throw (IOException)OAuth2Utils.exceptionWithCause(new IOException("Unexpected exception reading PKCS data"), var5);
   }

   @Beta
   public GoogleCredential createScoped(Collection<String> var1) {
      GoogleCredential var2;
      if (this.serviceAccountPrivateKey == null) {
         var2 = this;
      } else {
         var2 = new GoogleCredential.Builder()
            .setServiceAccountPrivateKey(this.serviceAccountPrivateKey)
            .setServiceAccountPrivateKeyId(this.serviceAccountPrivateKeyId)
            .setServiceAccountId(this.serviceAccountId)
            .setServiceAccountProjectId(this.serviceAccountProjectId)
            .setServiceAccountUser(this.serviceAccountUser)
            .setServiceAccountScopes(var1)
            .setTokenServerEncodedUrl(this.getTokenServerEncodedUrl())
            .setTransport(this.getTransport())
            .setJsonFactory(this.getJsonFactory())
            .setClock(this.getClock())
            .build();
      }

      return var2;
   }

   @Beta
   public boolean createScopedRequired() {
      boolean var1 = false;
      if (this.serviceAccountPrivateKey != null && (this.serviceAccountScopes == null || this.serviceAccountScopes.isEmpty())) {
         var1 = true;
      }

      return var1;
   }

   @Beta
   @Override
   protected TokenResponse executeRefreshToken() throws IOException {
      TokenResponse var3;
      if (this.serviceAccountPrivateKey == null) {
         var3 = super.executeRefreshToken();
      } else {
         JsonWebSignature.Header var4 = new JsonWebSignature.Header();
         var4.setAlgorithm("RS256");
         var4.setType("JWT");
         var4.setKeyId(this.serviceAccountPrivateKeyId);
         JsonWebToken.Payload var9 = new JsonWebToken.Payload();
         long var1 = this.getClock().currentTimeMillis();
         var9.setIssuer(this.serviceAccountId);
         var9.setAudience(this.getTokenServerEncodedUrl());
         var9.setIssuedAtTimeSeconds(var1 / 1000L);
         var9.setExpirationTimeSeconds(var1 / 1000L + 3600L);
         var9.setSubject(this.serviceAccountUser);
         var9.put("scope", Joiner.on(' ').join(this.serviceAccountScopes));

         try {
            String var12 = JsonWebSignature.signUsingRsaSha256(this.serviceAccountPrivateKey, this.getJsonFactory(), var4, var9);
            HttpTransport var6 = this.getTransport();
            JsonFactory var5 = this.getJsonFactory();
            GenericUrl var11 = new GenericUrl(this.getTokenServerEncodedUrl());
            TokenRequest var7 = new TokenRequest(var6, var5, var11, "urn:ietf:params:oauth:grant-type:jwt-bearer");
            var7.put("assertion", var12);
            var3 = var7.execute();
         } catch (GeneralSecurityException var8) {
            IOException var10 = new IOException();
            var10.initCause(var8);
            throw var10;
         }
      }

      return var3;
   }

   public final String getServiceAccountId() {
      return this.serviceAccountId;
   }

   public final PrivateKey getServiceAccountPrivateKey() {
      return this.serviceAccountPrivateKey;
   }

   @Beta
   public final String getServiceAccountPrivateKeyId() {
      return this.serviceAccountPrivateKeyId;
   }

   public final String getServiceAccountProjectId() {
      return this.serviceAccountProjectId;
   }

   public final Collection<String> getServiceAccountScopes() {
      return this.serviceAccountScopes;
   }

   public final String getServiceAccountScopesAsString() {
      String var1;
      if (this.serviceAccountScopes == null) {
         var1 = null;
      } else {
         var1 = Joiner.on(' ').join(this.serviceAccountScopes);
      }

      return var1;
   }

   public final String getServiceAccountUser() {
      return this.serviceAccountUser;
   }

   public GoogleCredential setAccessToken(String var1) {
      return (GoogleCredential)super.setAccessToken(var1);
   }

   public GoogleCredential setExpirationTimeMilliseconds(Long var1) {
      return (GoogleCredential)super.setExpirationTimeMilliseconds(var1);
   }

   public GoogleCredential setExpiresInSeconds(Long var1) {
      return (GoogleCredential)super.setExpiresInSeconds(var1);
   }

   public GoogleCredential setFromTokenResponse(TokenResponse var1) {
      return (GoogleCredential)super.setFromTokenResponse(var1);
   }

   public GoogleCredential setRefreshToken(String var1) {
      if (var1 != null) {
         boolean var2;
         if (this.getJsonFactory() != null && this.getTransport() != null && this.getClientAuthentication() != null) {
            var2 = true;
         } else {
            var2 = false;
         }

         Preconditions.checkArgument(var2, "Please use the Builder and call setJsonFactory, setTransport and setClientSecrets");
      }

      return (GoogleCredential)super.setRefreshToken(var1);
   }

   public static class Builder extends Credential.Builder {
      String serviceAccountId;
      PrivateKey serviceAccountPrivateKey;
      String serviceAccountPrivateKeyId;
      String serviceAccountProjectId;
      Collection<String> serviceAccountScopes;
      String serviceAccountUser;

      public Builder() {
         super(BearerToken.authorizationHeaderAccessMethod());
         this.setTokenServerEncodedUrl("https://accounts.google.com/o/oauth2/token");
      }

      public GoogleCredential.Builder addRefreshListener(CredentialRefreshListener var1) {
         return (GoogleCredential.Builder)super.addRefreshListener(var1);
      }

      public GoogleCredential build() {
         return new GoogleCredential(this);
      }

      public final String getServiceAccountId() {
         return this.serviceAccountId;
      }

      public final PrivateKey getServiceAccountPrivateKey() {
         return this.serviceAccountPrivateKey;
      }

      @Beta
      public final String getServiceAccountPrivateKeyId() {
         return this.serviceAccountPrivateKeyId;
      }

      public final String getServiceAccountProjectId() {
         return this.serviceAccountProjectId;
      }

      public final Collection<String> getServiceAccountScopes() {
         return this.serviceAccountScopes;
      }

      public final String getServiceAccountUser() {
         return this.serviceAccountUser;
      }

      public GoogleCredential.Builder setClientAuthentication(HttpExecuteInterceptor var1) {
         return (GoogleCredential.Builder)super.setClientAuthentication(var1);
      }

      public GoogleCredential.Builder setClientSecrets(GoogleClientSecrets var1) {
         GoogleClientSecrets.Details var2 = var1.getDetails();
         this.setClientAuthentication(new ClientParametersAuthentication(var2.getClientId(), var2.getClientSecret()));
         return this;
      }

      public GoogleCredential.Builder setClientSecrets(String var1, String var2) {
         this.setClientAuthentication(new ClientParametersAuthentication(var1, var2));
         return this;
      }

      public GoogleCredential.Builder setClock(Clock var1) {
         return (GoogleCredential.Builder)super.setClock(var1);
      }

      public GoogleCredential.Builder setJsonFactory(JsonFactory var1) {
         return (GoogleCredential.Builder)super.setJsonFactory(var1);
      }

      public GoogleCredential.Builder setRefreshListeners(Collection<CredentialRefreshListener> var1) {
         return (GoogleCredential.Builder)super.setRefreshListeners(var1);
      }

      public GoogleCredential.Builder setRequestInitializer(HttpRequestInitializer var1) {
         return (GoogleCredential.Builder)super.setRequestInitializer(var1);
      }

      public GoogleCredential.Builder setServiceAccountId(String var1) {
         this.serviceAccountId = var1;
         return this;
      }

      public GoogleCredential.Builder setServiceAccountPrivateKey(PrivateKey var1) {
         this.serviceAccountPrivateKey = var1;
         return this;
      }

      public GoogleCredential.Builder setServiceAccountPrivateKeyFromP12File(File var1) throws GeneralSecurityException, IOException {
         this.serviceAccountPrivateKey = SecurityUtils.loadPrivateKeyFromKeyStore(
            SecurityUtils.getPkcs12KeyStore(), new FileInputStream(var1), "notasecret", "privatekey", "notasecret"
         );
         return this;
      }

      @Beta
      public GoogleCredential.Builder setServiceAccountPrivateKeyFromPemFile(File var1) throws GeneralSecurityException, IOException {
         byte[] var2 = PemReader.readFirstSectionAndClose(new FileReader(var1), "PRIVATE KEY").getBase64DecodedBytes();
         this.serviceAccountPrivateKey = SecurityUtils.getRsaKeyFactory().generatePrivate(new PKCS8EncodedKeySpec(var2));
         return this;
      }

      @Beta
      public GoogleCredential.Builder setServiceAccountPrivateKeyId(String var1) {
         this.serviceAccountPrivateKeyId = var1;
         return this;
      }

      public GoogleCredential.Builder setServiceAccountProjectId(String var1) {
         this.serviceAccountProjectId = var1;
         return this;
      }

      public GoogleCredential.Builder setServiceAccountScopes(Collection<String> var1) {
         this.serviceAccountScopes = var1;
         return this;
      }

      public GoogleCredential.Builder setServiceAccountUser(String var1) {
         this.serviceAccountUser = var1;
         return this;
      }

      public GoogleCredential.Builder setTokenServerEncodedUrl(String var1) {
         return (GoogleCredential.Builder)super.setTokenServerEncodedUrl(var1);
      }

      public GoogleCredential.Builder setTokenServerUrl(GenericUrl var1) {
         return (GoogleCredential.Builder)super.setTokenServerUrl(var1);
      }

      public GoogleCredential.Builder setTransport(HttpTransport var1) {
         return (GoogleCredential.Builder)super.setTransport(var1);
      }
   }
}
