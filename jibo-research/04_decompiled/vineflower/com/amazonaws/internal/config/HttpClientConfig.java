package com.amazonaws.internal.config;

public class HttpClientConfig {
   private final String serviceName;

   HttpClientConfig(String var1) {
      this.serviceName = var1;
   }

   public String getServiceName() {
      return this.serviceName;
   }

   @Override
   public String toString() {
      return "serviceName: " + this.serviceName;
   }
}
