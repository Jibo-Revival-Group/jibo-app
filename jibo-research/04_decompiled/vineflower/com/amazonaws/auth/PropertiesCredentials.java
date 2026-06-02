package com.amazonaws.auth;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesCredentials implements AWSCredentials {
   private final String accessKey;
   private final String secretAccessKey;

   public PropertiesCredentials(File var1) {
      if (!var1.exists()) {
         throw new FileNotFoundException("File doesn't exist:  " + var1.getAbsolutePath());
      }

      FileInputStream var2 = new FileInputStream(var1);

      try {
         Properties var3 = new Properties();
         var3.load(var2);
         if (var3.getProperty("accessKey") == null || var3.getProperty("secretKey") == null) {
            StringBuilder var4 = new StringBuilder();
            IllegalArgumentException var10 = new IllegalArgumentException(
               var4.append("The specified file (")
                  .append(var1.getAbsolutePath())
                  .append(") doesn't contain the expected properties 'accessKey' ")
                  .append("and 'secretKey'.")
                  .toString()
            );
            throw var10;
         }

         this.accessKey = var3.getProperty("accessKey");
         this.secretAccessKey = var3.getProperty("secretKey");
      } finally {
         try {
            var2.close();
         } catch (IOException var8) {
         }
      }
   }

   public PropertiesCredentials(InputStream var1) {
      Properties var2 = new Properties();

      try {
         var2.load(var1);
      } finally {
         try {
            var1.close();
         } catch (Exception var6) {
         }
      }

      if (var2.getProperty("accessKey") != null && var2.getProperty("secretKey") != null) {
         this.accessKey = var2.getProperty("accessKey");
         this.secretAccessKey = var2.getProperty("secretKey");
      } else {
         throw new IllegalArgumentException("The specified properties data doesn't contain the expected properties 'accessKey' and 'secretKey'.");
      }
   }

   @Override
   public String getAWSAccessKeyId() {
      return this.accessKey;
   }

   @Override
   public String getAWSSecretKey() {
      return this.secretAccessKey;
   }
}
