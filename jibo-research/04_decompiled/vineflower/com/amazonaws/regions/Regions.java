package com.amazonaws.regions;

public enum Regions {
   ApiDev("api-dev"),
   ServerDev("srvdev1-services"),
   Stage1("stg1-entrypoint"),
   Stage2("stg2-entrypoint");

   private static final Regions[] $VALUES = new Regions[]{Regions.ApiDev, Regions.ServerDev, Regions.Stage1, Regions.Stage2};
   public static final Regions DEFAULT_REGION = ApiDev;
   private final String name;

   Regions(String var3) {
      this.name = var3;
   }

   public static Regions fromName(String var0) {
      for (Regions var4 : values()) {
         if (var0.equals(var4.getName())) {
            return var4;
         }
      }

      throw new IllegalArgumentException("Cannot create enum from " + var0 + " value!");
   }

   public String getName() {
      return this.name;
   }
}
