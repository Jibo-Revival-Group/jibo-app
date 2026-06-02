package com.amazonaws.internal;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

public class StaticCredentialsProvider implements AWSCredentialsProvider {
   private final AWSCredentials credentials;

   public StaticCredentialsProvider(AWSCredentials var1) {
      this.credentials = var1;
   }

   @Override
   public AWSCredentials getCredentials() {
      return this.credentials;
   }
}
