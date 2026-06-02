package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;

@Deprecated
public class SystemPropertiesCredentialsProvider implements AWSCredentialsProvider {
   @Override
   public AWSCredentials getCredentials() {
      if (System.getProperty("aws.accessKeyId") != null && System.getProperty("aws.secretKey") != null) {
         return new BasicAWSCredentials(System.getProperty("aws.accessKeyId"), System.getProperty("aws.secretKey"));
      } else {
         throw new AmazonClientException("Unable to load AWS credentials from Java system properties (aws.accessKeyId and aws.secretKey)");
      }
   }

   @Override
   public String toString() {
      return this.getClass().getSimpleName();
   }
}
