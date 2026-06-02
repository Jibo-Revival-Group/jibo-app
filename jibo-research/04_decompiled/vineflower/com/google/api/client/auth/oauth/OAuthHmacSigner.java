package com.google.api.client.auth.oauth;

import com.google.api.client.util.Base64;
import com.google.api.client.util.Beta;
import com.google.api.client.util.StringUtils;
import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

@Beta
public final class OAuthHmacSigner implements OAuthSigner {
   public String clientSharedSecret;
   public String tokenSharedSecret;

   @Override
   public String computeSignature(String var1) throws GeneralSecurityException {
      StringBuilder var2 = new StringBuilder();
      String var3 = this.clientSharedSecret;
      if (var3 != null) {
         var2.append(OAuthParameters.escape(var3));
      }

      var2.append('&');
      var3 = this.tokenSharedSecret;
      if (var3 != null) {
         var2.append(OAuthParameters.escape(var3));
      }

      SecretKeySpec var6 = new SecretKeySpec(StringUtils.getBytesUtf8(var2.toString()), "HmacSHA1");
      Mac var4 = Mac.getInstance("HmacSHA1");
      var4.init(var6);
      return Base64.encodeBase64String(var4.doFinal(StringUtils.getBytesUtf8(var1)));
   }

   @Override
   public String getSignatureMethod() {
      return "HMAC-SHA1";
   }
}
