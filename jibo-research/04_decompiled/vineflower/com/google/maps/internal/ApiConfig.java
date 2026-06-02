package com.google.maps.internal;

import com.google.gson.FieldNamingPolicy;

public class ApiConfig {
   public FieldNamingPolicy fieldNamingPolicy = FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;
   public String hostName = "https://maps.googleapis.com";
   public String path;
   public String requestVerb;
   public boolean supportsClientId = true;

   public ApiConfig(String var1) {
      this.requestVerb = "GET";
      this.path = var1;
   }

   public ApiConfig fieldNamingPolicy(FieldNamingPolicy var1) {
      this.fieldNamingPolicy = var1;
      return this;
   }

   public ApiConfig hostName(String var1) {
      this.hostName = var1;
      return this;
   }

   public ApiConfig requestVerb(String var1) {
      this.requestVerb = var1;
      return this;
   }

   public ApiConfig supportsClientId(boolean var1) {
      this.supportsClientId = var1;
      return this;
   }
}
