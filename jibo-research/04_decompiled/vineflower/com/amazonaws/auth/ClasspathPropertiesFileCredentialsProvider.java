package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import java.io.IOException;
import java.io.InputStream;

@Deprecated
public class ClasspathPropertiesFileCredentialsProvider implements AWSCredentialsProvider {
   private static String DEFAULT_PROPERTIES_FILE = "AwsCredentials.properties";
   private final String credentialsFilePath;

   public ClasspathPropertiesFileCredentialsProvider() {
      this(DEFAULT_PROPERTIES_FILE);
   }

   public ClasspathPropertiesFileCredentialsProvider(String var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("Credentials file path cannot be null");
      }

      if (!var1.startsWith("/")) {
         this.credentialsFilePath = "/" + var1;
      } else {
         this.credentialsFilePath = var1;
      }
   }

   @Override
   public AWSCredentials getCredentials() {
      InputStream var1 = this.getClass().getResourceAsStream(this.credentialsFilePath);
      if (var1 == null) {
         throw new AmazonClientException("Unable to load AWS credentials from the " + this.credentialsFilePath + " file on the classpath");
      }

      try {
         return new PropertiesCredentials(var1);
      } catch (IOException var2) {
         throw new AmazonClientException("Unable to load AWS credentials from the " + this.credentialsFilePath + " file on the classpath", var2);
      }
   }

   @Override
   public String toString() {
      return this.getClass().getSimpleName() + "(" + this.credentialsFilePath + ")";
   }
}
