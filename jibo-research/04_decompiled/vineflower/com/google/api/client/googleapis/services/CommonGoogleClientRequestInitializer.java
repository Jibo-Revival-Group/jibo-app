package com.google.api.client.googleapis.services;

import java.io.IOException;

public class CommonGoogleClientRequestInitializer implements GoogleClientRequestInitializer {
   private final String key;
   private final String userIp;

   public CommonGoogleClientRequestInitializer() {
      this(null);
   }

   public CommonGoogleClientRequestInitializer(String var1) {
      this(var1, null);
   }

   public CommonGoogleClientRequestInitializer(String var1, String var2) {
      this.key = var1;
      this.userIp = var2;
   }

   public final String getKey() {
      return this.key;
   }

   public final String getUserIp() {
      return this.userIp;
   }

   @Override
   public void initialize(AbstractGoogleClientRequest<?> var1) throws IOException {
      if (this.key != null) {
         var1.put("key", this.key);
      }

      if (this.userIp != null) {
         var1.put("userIp", this.userIp);
      }
   }
}
