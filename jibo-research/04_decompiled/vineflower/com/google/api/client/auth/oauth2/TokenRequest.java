package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Joiner;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.Collection;

public class TokenRequest extends GenericData {
   HttpExecuteInterceptor clientAuthentication;
   @Key("grant_type")
   private String grantType;
   private final JsonFactory jsonFactory;
   HttpRequestInitializer requestInitializer;
   @Key("scope")
   private String scopes;
   private GenericUrl tokenServerUrl;
   private final HttpTransport transport;

   public TokenRequest(HttpTransport var1, JsonFactory var2, GenericUrl var3, String var4) {
      this.transport = Preconditions.checkNotNull(var1);
      this.jsonFactory = Preconditions.checkNotNull(var2);
      this.setTokenServerUrl(var3);
      this.setGrantType(var4);
   }

   public TokenResponse execute() throws IOException {
      return this.executeUnparsed().parseAs(TokenResponse.class);
   }

   public final HttpResponse executeUnparsed() throws IOException {
      HttpRequest var1 = this.transport.createRequestFactory(new HttpRequestInitializer(this) {
         final TokenRequest this$0;

         {
            this.this$0 = var1;
         }

         @Override
         public void initialize(HttpRequest var1) throws IOException {
            if (this.this$0.requestInitializer != null) {
               this.this$0.requestInitializer.initialize(var1);
            }

            var1.setInterceptor(new HttpExecuteInterceptor(this, var1.getInterceptor()) {
               final <unrepresentable> this$1;
               final HttpExecuteInterceptor val$interceptor;

               {
                  this.this$1 = var1;
                  this.val$interceptor = var2;
               }

               @Override
               public void intercept(HttpRequest var1) throws IOException {
                  if (this.val$interceptor != null) {
                     this.val$interceptor.intercept(var1);
                  }

                  if (this.this$1.this$0.clientAuthentication != null) {
                     this.this$1.this$0.clientAuthentication.intercept(var1);
                  }
               }
            });
         }
      }).buildPostRequest(this.tokenServerUrl, new UrlEncodedContent(this));
      var1.setParser(new JsonObjectParser(this.jsonFactory));
      var1.setThrowExceptionOnExecuteError(false);
      HttpResponse var2 = var1.execute();
      if (var2.isSuccessStatusCode()) {
         return var2;
      } else {
         throw TokenResponseException.from(this.jsonFactory, var2);
      }
   }

   public final HttpExecuteInterceptor getClientAuthentication() {
      return this.clientAuthentication;
   }

   public final String getGrantType() {
      return this.grantType;
   }

   public final JsonFactory getJsonFactory() {
      return this.jsonFactory;
   }

   public final HttpRequestInitializer getRequestInitializer() {
      return this.requestInitializer;
   }

   public final String getScopes() {
      return this.scopes;
   }

   public final GenericUrl getTokenServerUrl() {
      return this.tokenServerUrl;
   }

   public final HttpTransport getTransport() {
      return this.transport;
   }

   public TokenRequest set(String var1, Object var2) {
      return (TokenRequest)super.set(var1, var2);
   }

   public TokenRequest setClientAuthentication(HttpExecuteInterceptor var1) {
      this.clientAuthentication = var1;
      return this;
   }

   public TokenRequest setGrantType(String var1) {
      this.grantType = Preconditions.checkNotNull(var1);
      return this;
   }

   public TokenRequest setRequestInitializer(HttpRequestInitializer var1) {
      this.requestInitializer = var1;
      return this;
   }

   public TokenRequest setScopes(Collection<String> var1) {
      String var2;
      if (var1 == null) {
         var2 = null;
      } else {
         var2 = Joiner.on(' ').join(var1);
      }

      this.scopes = var2;
      return this;
   }

   public TokenRequest setTokenServerUrl(GenericUrl var1) {
      this.tokenServerUrl = var1;
      boolean var2;
      if (var1.getFragment() == null) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2);
      return this;
   }
}
