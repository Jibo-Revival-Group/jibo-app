package com.google.api.client.auth.oauth;

import com.google.api.client.util.Beta;

@Beta
public class OAuthGetAccessToken extends AbstractOAuthGetToken {
   public String temporaryToken;
   public String verifier;

   public OAuthGetAccessToken(String var1) {
      super(var1);
   }

   @Override
   public OAuthParameters createParameters() {
      OAuthParameters var1 = super.createParameters();
      var1.token = this.temporaryToken;
      var1.verifier = this.verifier;
      return var1;
   }
}
