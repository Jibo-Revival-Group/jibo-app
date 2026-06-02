package com.google.api.client.googleapis.testing.compute;

import com.google.api.client.googleapis.auth.oauth2.OAuth2Utils;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.client.util.Beta;
import java.io.IOException;

@Beta
public class MockMetadataServerTransport extends MockHttpTransport {
   static final JsonFactory JSON_FACTORY = new JacksonFactory();
   private static final String METADATA_SERVER_URL = OAuth2Utils.getMetadataServerUrl();
   private static final String METADATA_TOKEN_SERVER_URL = String.valueOf(METADATA_SERVER_URL)
      .concat("/computeMetadata/v1/instance/service-accounts/default/token");
   String accessToken;
   Integer tokenRequestStatusCode;

   public MockMetadataServerTransport(String var1) {
      this.accessToken = var1;
   }

   @Override
   public LowLevelHttpRequest buildRequest(String var1, String var2) throws IOException {
      LowLevelHttpRequest var3;
      if (var2.equals(METADATA_TOKEN_SERVER_URL)) {
         var3 = new MockLowLevelHttpRequest(this, var2) {
            final MockMetadataServerTransport this$0;

            {
               this.this$0 = var1;
            }

            @Override
            public LowLevelHttpResponse execute() throws IOException {
               MockLowLevelHttpResponse var1x;
               if (this.this$0.tokenRequestStatusCode != null) {
                  var1x = new MockLowLevelHttpResponse().setStatusCode(this.this$0.tokenRequestStatusCode).setContent("Token Fetch Error");
               } else {
                  if (!"Google".equals(this.getFirstHeaderValue("Metadata-Flavor"))) {
                     throw new IOException("Metadata request header not found.");
                  }

                  GenericJson var2x = new GenericJson();
                  var2x.setFactory(MockMetadataServerTransport.JSON_FACTORY);
                  var2x.put("access_token", this.this$0.accessToken);
                  var2x.put("expires_in", 3600000);
                  var2x.put("token_type", "Bearer");
                  String var3x = var2x.toPrettyString();
                  var1x = new MockLowLevelHttpResponse().setContentType("application/json; charset=UTF-8").setContent(var3x);
               }

               return var1x;
            }
         };
      } else if (var2.equals(METADATA_SERVER_URL)) {
         var3 = new MockLowLevelHttpRequest(this, var2) {
            final MockMetadataServerTransport this$0;

            {
               this.this$0 = var1;
            }

            @Override
            public LowLevelHttpResponse execute() {
               MockLowLevelHttpResponse var1 = new MockLowLevelHttpResponse();
               var1.addHeader("Metadata-Flavor", "Google");
               return var1;
            }
         };
      } else {
         var3 = super.buildRequest(var1, var2);
      }

      return var3;
   }

   public void setTokenRequestStatusCode(Integer var1) {
      this.tokenRequestStatusCode = var1;
   }
}
