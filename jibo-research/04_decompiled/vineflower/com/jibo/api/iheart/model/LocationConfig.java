package com.jibo.api.iheart.model;

public class LocationConfig {
   private String a;
   private LocationConfig.Config b;

   public LocationConfig(String var1, LocationConfig.Config var2) {
      this.a = var1;
      this.b = var2;
   }

   public String a() {
      String var1;
      if (this.b != null) {
         var1 = this.b.a;
      } else {
         var1 = "";
      }

      return var1;
   }

   public static class Config {
      private String a;

      public Config(String var1) {
         this.a = var1;
      }
   }
}
