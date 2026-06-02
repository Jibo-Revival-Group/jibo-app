package com.amazonaws.auth;

public class BasicAWSCredentials implements AWSCredentials {
   private final String accessKey;
   private final String secretKey;

   public BasicAWSCredentials(String var1, String var2) {
      if (var1 == null) {
         throw new IllegalArgumentException("Access key cannot be null.");
      }

      if (var2 == null) {
         throw new IllegalArgumentException("Secret key cannot be null.");
      }

      this.accessKey = var1;
      this.secretKey = var2;
   }

   @Override
   public String getAWSAccessKeyId() {
      return this.accessKey;
   }

   @Override
   public String getAWSSecretKey() {
      return this.secretKey;
   }
}
