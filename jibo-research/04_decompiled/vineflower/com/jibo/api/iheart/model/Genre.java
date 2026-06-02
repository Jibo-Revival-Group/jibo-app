package com.jibo.api.iheart.model;

public class Genre {
   private int a;
   private String b;
   private Station c;

   public Genre(int var1, String var2) {
      this.a = var1;
      this.b = var2;
   }

   public int a() {
      return this.a;
   }

   public String b() {
      return this.b;
   }

   public Station c() {
      return this.c;
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
            if (var1 instanceof Genre) {
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
}
