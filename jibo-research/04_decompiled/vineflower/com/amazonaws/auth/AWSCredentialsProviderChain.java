package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.jibo.aws.integration.util.a;
import java.util.LinkedList;
import java.util.List;

public class AWSCredentialsProviderChain implements AWSCredentialsProvider {
   private static final String TAG = a.a(AWSCredentialsProviderChain.class);
   private List<AWSCredentialsProvider> credentialsProviders = new LinkedList<>();
   private AWSCredentialsProvider lastUsedProvider;
   private boolean reuseLastProvider = true;

   public AWSCredentialsProviderChain(AWSCredentialsProvider... var1) {
      if (var1 != null && var1.length != 0) {
         for (AWSCredentialsProvider var4 : var1) {
            this.credentialsProviders.add(var4);
         }
      } else {
         throw new IllegalArgumentException("No credential providers specified");
      }
   }

   @Override
   public AWSCredentials getCredentials() {
      if (this.reuseLastProvider && this.lastUsedProvider != null) {
         return this.lastUsedProvider.getCredentials();
      }

      for (AWSCredentialsProvider var2 : this.credentialsProviders) {
         try {
            AWSCredentials var1 = var2.getCredentials();
            if (var1.getAWSAccessKeyId() != null && var1.getAWSSecretKey() != null) {
               String var4 = TAG;
               StringBuilder var5 = new StringBuilder();
               a.a(var4, var5.append("Loading credentials from ").append(var2.toString()).toString());
               this.lastUsedProvider = var2;
               return var1;
            }
         } catch (Exception var6) {
            a.a(TAG, "Unable to load credentials from " + var2.toString() + ": " + var6.getMessage());
         }
      }

      throw new AmazonClientException("Unable to load AWS credentials from any provider in the chain");
   }
}
