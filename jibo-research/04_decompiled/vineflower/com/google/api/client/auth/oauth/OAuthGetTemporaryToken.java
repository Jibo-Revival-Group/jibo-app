package com.google.api.client.auth.oauth;

import com.google.api.client.util.Beta;

@Beta
public class OAuthGetTemporaryToken extends AbstractOAuthGetToken {
   public String callback;

   public OAuthGetTemporaryToken(String var1) {
      super(var1);
   }

   @Override
   public OAuthParameters createParameters() {
      OAuthParameters var1 = super.createParameters();
      var1.callback = this.callback;
      return var1;
   }
}
