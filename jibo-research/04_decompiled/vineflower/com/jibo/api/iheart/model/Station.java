package com.jibo.api.iheart.model;

import java.util.List;

public class Station {
   private int a;
   private String b;
   private String c;
   private List<Station.Market> d;
   private String e;

   public Station(int var1, String var2, String var3, String var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.e = var4;
   }

   public int a() {
      return this.a;
   }

   public String b() {
      return this.b;
   }

   public String c() {
      return this.c;
   }

   public String d() {
      Station.Market var1;
      if (this.d != null && !this.d.isEmpty()) {
         var1 = this.d.get(0);
      } else {
         var1 = null;
      }

      String var2;
      if (var1 != null) {
         var2 = var1.a;
      } else {
         var2 = "";
      }

      return var2;
   }

   public String e() {
      Station.Market var1;
      if (this.d != null && !this.d.isEmpty()) {
         var1 = this.d.get(0);
      } else {
         var1 = null;
      }

      String var2;
      if (var1 != null) {
         var2 = var1.b;
      } else {
         var2 = "";
      }

      return var2;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var4 = true;
      boolean var3 = false;
      boolean var2;
      if (this == var1) {
         var2 = true;
      } else {
         var2 = var3;
         if (var1 != null) {
            var2 = var3;
            if (var1 instanceof Station) {
               var1 = var1;
               var2 = var3;
               if (var1.a() != 0) {
                  if (var1.a() == this.a()) {
                     var2 = var4;
                  } else {
                     var2 = false;
                  }
               }
            }
         }
      }

      return var2;
   }

   public String f() {
      String var1;
      if ("Digital".equals(this.d())) {
         var1 = "Digital";
      } else {
         var1 = this.d() + ", " + this.e();
      }

      return var1;
   }

   public String g() {
      return this.e;
   }

   public static class Market {
      private String a;
      private String b;
   }
}
