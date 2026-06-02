package com.google.api.client.auth.oauth;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UrlEncodedParser;
import com.google.api.client.util.Beta;
import java.io.IOException;

@Beta
public abstract class AbstractOAuthGetToken extends GenericUrl {
   public String consumerKey;
   public OAuthSigner signer;
   public HttpTransport transport;
   protected boolean usePost;

   protected AbstractOAuthGetToken(String var1) {
      super(var1);
   }

   public OAuthParameters createParameters() {
      OAuthParameters var1 = new OAuthParameters();
      var1.consumerKey = this.consumerKey;
      var1.signer = this.signer;
      return var1;
   }

   public final OAuthCredentialsResponse execute() throws IOException {
      HttpRequestFactory var2 = this.transport.createRequestFactory();
      String var1;
      if (this.usePost) {
         var1 = "POST";
      } else {
         var1 = "GET";
      }

      HttpRequest var3 = var2.buildRequest(var1, this, null);
      this.createParameters().intercept(var3);
      HttpResponse var4 = var3.execute();
      var4.setContentLoggingLimit(0);
      OAuthCredentialsResponse var5 = new OAuthCredentialsResponse();
      UrlEncodedParser.parse(var4.parseAsString(), var5);
      return var5;
   }
}
