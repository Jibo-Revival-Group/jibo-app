package com.google.api.client.googleapis.testing.auth.oauth2;

import com.google.api.client.googleapis.testing.TestUtils;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.client.util.Beta;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Beta
public class MockTokenServerTransport extends MockHttpTransport {
   static final String EXPECTED_GRANT_TYPE = "urn:ietf:params:oauth:grant-type:jwt-bearer";
   static final JsonFactory JSON_FACTORY = new JacksonFactory();
   Map<String, String> clients;
   Map<String, String> refreshTokens;
   Map<String, String> serviceAccounts = new HashMap<>();
   final String tokenServerUrl;

   public MockTokenServerTransport() {
      this("https://accounts.google.com/o/oauth2/token");
   }

   public MockTokenServerTransport(String var1) {
      this.clients = new HashMap<>();
      this.refreshTokens = new HashMap<>();
      this.tokenServerUrl = var1;
   }

   public void addClient(String var1, String var2) {
      this.clients.put(var1, var2);
   }

   public void addRefreshToken(String var1, String var2) {
      this.refreshTokens.put(var1, var2);
   }

   public void addServiceAccount(String var1, String var2) {
      this.serviceAccounts.put(var1, var2);
   }

   @Override
   public LowLevelHttpRequest buildRequest(String var1, String var2) throws IOException {
      LowLevelHttpRequest var3;
      if (var2.equals(this.tokenServerUrl)) {
         var3 = new MockLowLevelHttpRequest(this, var2) {
            final MockTokenServerTransport this$0;

            {
               this.this$0 = var1;
            }

            @Override
            public LowLevelHttpResponse execute() throws IOException {
               Map var1x = TestUtils.parseQuery(this.getContentAsString());
               String var3x = (String)var1x.get("client_id");
               String var6;
               if (var3x != null) {
                  if (!this.this$0.clients.containsKey(var3x)) {
                     throw new IOException("Client ID not found.");
                  }

                  String var10 = (String)var1x.get("client_secret");
                  var3x = this.this$0.clients.get(var3x);
                  if (var10 == null || !var10.equals(var3x)) {
                     throw new IOException("Client secret not found.");
                  }

                  String var7 = (String)var1x.get("refresh_token");
                  if (!this.this$0.refreshTokens.containsKey(var7)) {
                     throw new IOException("Refresh Token not found.");
                  }

                  var6 = this.this$0.refreshTokens.get(var7);
               } else {
                  if (!var1x.containsKey("grant_type")) {
                     throw new IOException("Unknown token type.");
                  }

                  if (!"urn:ietf:params:oauth:grant-type:jwt-bearer".equals((String)var1x.get("grant_type"))) {
                     throw new IOException("Unexpected Grant Type.");
                  }

                  String var4 = (String)var1x.get("assertion");
                  JsonWebSignature var2x = JsonWebSignature.parse(MockTokenServerTransport.JSON_FACTORY, var4);
                  String var5 = var2x.getPayload().getIssuer();
                  if (!this.this$0.serviceAccounts.containsKey(var5)) {
                     throw new IOException("Service Account Email not found as issuer.");
                  }

                  var6 = this.this$0.serviceAccounts.get(var5);
                  String var9 = (String)var2x.getPayload().get("scope");
                  if (var9 == null || var9.length() == 0) {
                     throw new IOException("Scopes not found.");
                  }
               }

               GenericJson var11 = new GenericJson();
               var11.setFactory(MockTokenServerTransport.JSON_FACTORY);
               var11.put("access_token", var6);
               var11.put("expires_in", 3600000);
               var11.put("token_type", "Bearer");
               String var8 = var11.toPrettyString();
               return new MockLowLevelHttpResponse().setContentType("application/json; charset=UTF-8").setContent(var8);
            }
         };
      } else {
         var3 = super.buildRequest(var1, var2);
      }

      return var3;
   }
}
