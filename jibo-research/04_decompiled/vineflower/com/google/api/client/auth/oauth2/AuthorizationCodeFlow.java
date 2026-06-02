package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;
import com.google.api.client.util.Joiner;
import com.google.api.client.util.Lists;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Strings;
import com.google.api.client.util.store.DataStore;
import com.google.api.client.util.store.DataStoreFactory;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

public class AuthorizationCodeFlow {
   private final String authorizationServerEncodedUrl;
   private final HttpExecuteInterceptor clientAuthentication;
   private final String clientId;
   private final Clock clock;
   private final AuthorizationCodeFlow.CredentialCreatedListener credentialCreatedListener;
   @Beta
   private final DataStore<StoredCredential> credentialDataStore;
   @Deprecated
   @Beta
   private final CredentialStore credentialStore;
   private final JsonFactory jsonFactory;
   private final Credential.AccessMethod method;
   private final Collection<CredentialRefreshListener> refreshListeners;
   private final HttpRequestInitializer requestInitializer;
   private final Collection<String> scopes;
   private final String tokenServerEncodedUrl;
   private final HttpTransport transport;

   protected AuthorizationCodeFlow(AuthorizationCodeFlow.Builder var1) {
      this.method = Preconditions.checkNotNull(var1.method);
      this.transport = Preconditions.checkNotNull(var1.transport);
      this.jsonFactory = Preconditions.checkNotNull(var1.jsonFactory);
      this.tokenServerEncodedUrl = Preconditions.checkNotNull(var1.tokenServerUrl).build();
      this.clientAuthentication = var1.clientAuthentication;
      this.clientId = Preconditions.checkNotNull(var1.clientId);
      this.authorizationServerEncodedUrl = Preconditions.checkNotNull(var1.authorizationServerEncodedUrl);
      this.requestInitializer = var1.requestInitializer;
      this.credentialStore = var1.credentialStore;
      this.credentialDataStore = var1.credentialDataStore;
      this.scopes = Collections.unmodifiableCollection(var1.scopes);
      this.clock = Preconditions.checkNotNull(var1.clock);
      this.credentialCreatedListener = var1.credentialCreatedListener;
      this.refreshListeners = Collections.unmodifiableCollection(var1.refreshListeners);
   }

   public AuthorizationCodeFlow(
      Credential.AccessMethod var1, HttpTransport var2, JsonFactory var3, GenericUrl var4, HttpExecuteInterceptor var5, String var6, String var7
   ) {
      this(new AuthorizationCodeFlow.Builder(var1, var2, var3, var4, var5, var6, var7));
   }

   private Credential newCredential(String var1) {
      Credential.Builder var2 = new Credential.Builder(this.method)
         .setTransport(this.transport)
         .setJsonFactory(this.jsonFactory)
         .setTokenServerEncodedUrl(this.tokenServerEncodedUrl)
         .setClientAuthentication(this.clientAuthentication)
         .setRequestInitializer(this.requestInitializer)
         .setClock(this.clock);
      if (this.credentialDataStore != null) {
         var2.addRefreshListener(new DataStoreCredentialRefreshListener(var1, this.credentialDataStore));
      } else if (this.credentialStore != null) {
         var2.addRefreshListener(new CredentialStoreRefreshListener(var1, this.credentialStore));
      }

      var2.getRefreshListeners().addAll(this.refreshListeners);
      return var2.build();
   }

   public Credential createAndStoreCredential(TokenResponse var1, String var2) throws IOException {
      Credential var3 = this.newCredential(var2).setFromTokenResponse(var1);
      if (this.credentialStore != null) {
         this.credentialStore.store(var2, var3);
      }

      if (this.credentialDataStore != null) {
         this.credentialDataStore.set(var2, new StoredCredential(var3));
      }

      if (this.credentialCreatedListener != null) {
         this.credentialCreatedListener.onCredentialCreated(var3, var1);
      }

      return var3;
   }

   public final String getAuthorizationServerEncodedUrl() {
      return this.authorizationServerEncodedUrl;
   }

   public final HttpExecuteInterceptor getClientAuthentication() {
      return this.clientAuthentication;
   }

   public final String getClientId() {
      return this.clientId;
   }

   public final Clock getClock() {
      return this.clock;
   }

   @Beta
   public final DataStore<StoredCredential> getCredentialDataStore() {
      return this.credentialDataStore;
   }

   @Deprecated
   @Beta
   public final CredentialStore getCredentialStore() {
      return this.credentialStore;
   }

   public final JsonFactory getJsonFactory() {
      return this.jsonFactory;
   }

   public final Credential.AccessMethod getMethod() {
      return this.method;
   }

   public final Collection<CredentialRefreshListener> getRefreshListeners() {
      return this.refreshListeners;
   }

   public final HttpRequestInitializer getRequestInitializer() {
      return this.requestInitializer;
   }

   public final Collection<String> getScopes() {
      return this.scopes;
   }

   public final String getScopesAsString() {
      return Joiner.on(' ').join(this.scopes);
   }

   public final String getTokenServerEncodedUrl() {
      return this.tokenServerEncodedUrl;
   }

   public final HttpTransport getTransport() {
      return this.transport;
   }

   public Credential loadCredential(String var1) throws IOException {
      Credential var3;
      if (Strings.isNullOrEmpty(var1)) {
         var3 = null;
      } else if (this.credentialDataStore == null && this.credentialStore == null) {
         var3 = null;
      } else {
         Credential var2 = this.newCredential(var1);
         if (this.credentialDataStore != null) {
            StoredCredential var4 = this.credentialDataStore.get(var1);
            if (var4 == null) {
               Object var5 = null;
               return (Credential)var5;
            }

            var2.setAccessToken(var4.getAccessToken());
            var2.setRefreshToken(var4.getRefreshToken());
            var2.setExpirationTimeMilliseconds(var4.getExpirationTimeMilliseconds());
         } else if (!this.credentialStore.load(var1, var2)) {
            Object var6 = null;
            return (Credential)var6;
         }

         var3 = var2;
      }

      return var3;
   }

   public AuthorizationCodeRequestUrl newAuthorizationUrl() {
      return new AuthorizationCodeRequestUrl(this.authorizationServerEncodedUrl, this.clientId).setScopes(this.scopes);
   }

   public AuthorizationCodeTokenRequest newTokenRequest(String var1) {
      return new AuthorizationCodeTokenRequest(this.transport, this.jsonFactory, new GenericUrl(this.tokenServerEncodedUrl), var1)
         .setClientAuthentication(this.clientAuthentication)
         .setRequestInitializer(this.requestInitializer)
         .setScopes(this.scopes);
   }

   public static class Builder {
      String authorizationServerEncodedUrl;
      HttpExecuteInterceptor clientAuthentication;
      String clientId;
      Clock clock;
      AuthorizationCodeFlow.CredentialCreatedListener credentialCreatedListener;
      @Beta
      DataStore<StoredCredential> credentialDataStore;
      @Deprecated
      @Beta
      CredentialStore credentialStore;
      JsonFactory jsonFactory;
      Credential.AccessMethod method;
      Collection<CredentialRefreshListener> refreshListeners;
      HttpRequestInitializer requestInitializer;
      Collection<String> scopes = Lists.newArrayList();
      GenericUrl tokenServerUrl;
      HttpTransport transport;

      public Builder(Credential.AccessMethod var1, HttpTransport var2, JsonFactory var3, GenericUrl var4, HttpExecuteInterceptor var5, String var6, String var7) {
         this.clock = Clock.SYSTEM;
         this.refreshListeners = Lists.newArrayList();
         this.setMethod(var1);
         this.setTransport(var2);
         this.setJsonFactory(var3);
         this.setTokenServerUrl(var4);
         this.setClientAuthentication(var5);
         this.setClientId(var6);
         this.setAuthorizationServerEncodedUrl(var7);
      }

      public AuthorizationCodeFlow.Builder addRefreshListener(CredentialRefreshListener var1) {
         this.refreshListeners.add(Preconditions.checkNotNull(var1));
         return this;
      }

      public AuthorizationCodeFlow build() {
         return new AuthorizationCodeFlow(this);
      }

      public final String getAuthorizationServerEncodedUrl() {
         return this.authorizationServerEncodedUrl;
      }

      public final HttpExecuteInterceptor getClientAuthentication() {
         return this.clientAuthentication;
      }

      public final String getClientId() {
         return this.clientId;
      }

      public final Clock getClock() {
         return this.clock;
      }

      public final AuthorizationCodeFlow.CredentialCreatedListener getCredentialCreatedListener() {
         return this.credentialCreatedListener;
      }

      @Beta
      public final DataStore<StoredCredential> getCredentialDataStore() {
         return this.credentialDataStore;
      }

      @Deprecated
      @Beta
      public final CredentialStore getCredentialStore() {
         return this.credentialStore;
      }

      public final JsonFactory getJsonFactory() {
         return this.jsonFactory;
      }

      public final Credential.AccessMethod getMethod() {
         return this.method;
      }

      public final Collection<CredentialRefreshListener> getRefreshListeners() {
         return this.refreshListeners;
      }

      public final HttpRequestInitializer getRequestInitializer() {
         return this.requestInitializer;
      }

      public final Collection<String> getScopes() {
         return this.scopes;
      }

      public final GenericUrl getTokenServerUrl() {
         return this.tokenServerUrl;
      }

      public final HttpTransport getTransport() {
         return this.transport;
      }

      public AuthorizationCodeFlow.Builder setAuthorizationServerEncodedUrl(String var1) {
         this.authorizationServerEncodedUrl = Preconditions.checkNotNull(var1);
         return this;
      }

      public AuthorizationCodeFlow.Builder setClientAuthentication(HttpExecuteInterceptor var1) {
         this.clientAuthentication = var1;
         return this;
      }

      public AuthorizationCodeFlow.Builder setClientId(String var1) {
         this.clientId = Preconditions.checkNotNull(var1);
         return this;
      }

      public AuthorizationCodeFlow.Builder setClock(Clock var1) {
         this.clock = Preconditions.checkNotNull(var1);
         return this;
      }

      public AuthorizationCodeFlow.Builder setCredentialCreatedListener(AuthorizationCodeFlow.CredentialCreatedListener var1) {
         this.credentialCreatedListener = var1;
         return this;
      }

      @Beta
      public AuthorizationCodeFlow.Builder setCredentialDataStore(DataStore<StoredCredential> var1) {
         boolean var2;
         if (this.credentialStore == null) {
            var2 = true;
         } else {
            var2 = false;
         }

         Preconditions.checkArgument(var2);
         this.credentialDataStore = var1;
         return this;
      }

      @Deprecated
      @Beta
      public AuthorizationCodeFlow.Builder setCredentialStore(CredentialStore var1) {
         boolean var2;
         if (this.credentialDataStore == null) {
            var2 = true;
         } else {
            var2 = false;
         }

         Preconditions.checkArgument(var2);
         this.credentialStore = var1;
         return this;
      }

      @Beta
      public AuthorizationCodeFlow.Builder setDataStoreFactory(DataStoreFactory var1) throws IOException {
         return this.setCredentialDataStore(StoredCredential.getDefaultDataStore(var1));
      }

      public AuthorizationCodeFlow.Builder setJsonFactory(JsonFactory var1) {
         this.jsonFactory = Preconditions.checkNotNull(var1);
         return this;
      }

      public AuthorizationCodeFlow.Builder setMethod(Credential.AccessMethod var1) {
         this.method = Preconditions.checkNotNull(var1);
         return this;
      }

      public AuthorizationCodeFlow.Builder setRefreshListeners(Collection<CredentialRefreshListener> var1) {
         this.refreshListeners = Preconditions.checkNotNull(var1);
         return this;
      }

      public AuthorizationCodeFlow.Builder setRequestInitializer(HttpRequestInitializer var1) {
         this.requestInitializer = var1;
         return this;
      }

      public AuthorizationCodeFlow.Builder setScopes(Collection<String> var1) {
         this.scopes = Preconditions.checkNotNull(var1);
         return this;
      }

      public AuthorizationCodeFlow.Builder setTokenServerUrl(GenericUrl var1) {
         this.tokenServerUrl = Preconditions.checkNotNull(var1);
         return this;
      }

      public AuthorizationCodeFlow.Builder setTransport(HttpTransport var1) {
         this.transport = Preconditions.checkNotNull(var1);
         return this;
      }
   }

   public interface CredentialCreatedListener {
      void onCredentialCreated(Credential var1, TokenResponse var2) throws IOException;
   }
}
