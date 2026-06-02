package com.google.api.client.auth.oauth2;

import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.util.Data;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.Map;

public class ClientParametersAuthentication implements HttpExecuteInterceptor, HttpRequestInitializer {
   private final String clientId;
   private final String clientSecret;

   public ClientParametersAuthentication(String var1, String var2) {
      this.clientId = Preconditions.checkNotNull(var1);
      this.clientSecret = var2;
   }

   public final String getClientId() {
      return this.clientId;
   }

   public final String getClientSecret() {
      return this.clientSecret;
   }

   @Override
   public void initialize(HttpRequest var1) throws IOException {
      var1.setInterceptor(this);
   }

   @Override
   public void intercept(HttpRequest var1) throws IOException {
      Map var2 = Data.mapOf(UrlEncodedContent.getContent(var1).getData());
      var2.put("client_id", this.clientId);
      if (this.clientSecret != null) {
         var2.put("client_secret", this.clientSecret);
      }
   }
}
