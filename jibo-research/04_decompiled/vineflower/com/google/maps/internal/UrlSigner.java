package com.google.maps.internal;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okio.ByteString;

public class UrlSigner {
   private static final String ALGORITHM_HMAC_SHA1 = "HmacSHA1";
   private final Mac mac;

   public UrlSigner(String var1) throws NoSuchAlgorithmException, InvalidKeyException {
      ByteString var2 = ByteString.b(var1.replace('-', '+').replace('_', '/'));
      if (var2 == null) {
         throw new IllegalArgumentException("Private key is invalid.");
      }

      this.mac = Mac.getInstance("HmacSHA1");
      this.mac.init(new SecretKeySpec(var2.i(), "HmacSHA1"));
   }

   private Mac getMac() {
      try {
         return (Mac)this.mac.clone();
      } catch (CloneNotSupportedException var2) {
         throw new IllegalStateException(var2);
      }
   }

   public String getSignature(String var1) {
      return ByteString.a(this.getMac().doFinal(var1.getBytes())).b().replace('+', '-').replace('/', '_');
   }
}
