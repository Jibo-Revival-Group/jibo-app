package com.google.api.client.googleapis.auth.oauth2;

class SystemEnvironmentProvider {
   static final SystemEnvironmentProvider INSTANCE = new SystemEnvironmentProvider();

   String getEnv(String var1) {
      return System.getenv(var1);
   }
}
