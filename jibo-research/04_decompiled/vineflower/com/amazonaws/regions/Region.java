package com.amazonaws.regions;

import java.util.Map;

public final class Region {
   private final String domain;
   private final String name;
   private final Map<String, String> serviceEndpoints;

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (!(var1 instanceof Region)) {
         var2 = false;
      } else {
         var1 = var1;
         var2 = this.getName().equals(var1.getName());
      }

      return var2;
   }

   public String getDomain() {
      return this.domain;
   }

   public String getName() {
      return this.name;
   }

   public String getServiceEndpoint(String var1) {
      return this.serviceEndpoints.get(var1);
   }

   @Override
   public int hashCode() {
      return this.getName().hashCode();
   }

   public boolean isServiceSupported(String var1) {
      return this.serviceEndpoints.containsKey(var1);
   }

   @Override
   public String toString() {
      return this.getName();
   }
}
