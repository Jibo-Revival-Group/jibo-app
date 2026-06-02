package com.amazonaws.auth;

public class BasicSessionCredentials implements AWSSessionCredentials {
   private final String awsAccessKey;
   private final String awsSecretKey;
   private final String sessionToken;

   public BasicSessionCredentials(String var1, String var2, String var3) {
      this.awsAccessKey = var1;
      this.awsSecretKey = var2;
      this.sessionToken = var3;
   }

   @Override
   public String getAWSAccessKeyId() {
      return this.awsAccessKey;
   }

   @Override
   public String getAWSSecretKey() {
      return this.awsSecretKey;
   }

   @Override
   public String getSessionToken() {
      return this.sessionToken;
   }
}
