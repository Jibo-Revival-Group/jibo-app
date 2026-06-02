package com.fasterxml.jackson.core;

public abstract class JsonStreamContext {
   protected int a;
   protected int b;

   protected JsonStreamContext() {
   }

   public final boolean a() {
      boolean var1 = true;
      if (this.a != 1) {
         var1 = false;
      }

      return var1;
   }

   public final boolean b() {
      boolean var1;
      if (this.a == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public final boolean c() {
      boolean var1;
      if (this.a == 2) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public final String d() {
      String var1;
      switch (this.a) {
         case 0:
            var1 = "ROOT";
            break;
         case 1:
            var1 = "ARRAY";
            break;
         case 2:
            var1 = "OBJECT";
            break;
         default:
            var1 = "?";
      }

      return var1;
   }

   public final int e() {
      return this.b + 1;
   }

   public final int f() {
      int var1;
      if (this.b < 0) {
         var1 = 0;
      } else {
         var1 = this.b;
      }

      return var1;
   }
}
