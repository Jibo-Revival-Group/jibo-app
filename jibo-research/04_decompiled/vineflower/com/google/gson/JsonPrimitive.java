package com.google.gson;

import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigInteger;

public final class JsonPrimitive extends JsonElement {
   private static final Class<?>[] a = new Class[]{
      int.class,
      long.class,
      short.class,
      float.class,
      double.class,
      byte.class,
      boolean.class,
      char.class,
      Integer.class,
      Long.class,
      Short.class,
      Float.class,
      Double.class,
      Byte.class,
      Boolean.class,
      Character.class
   };
   private Object b;

   public JsonPrimitive(Boolean var1) {
      this.a(var1);
   }

   public JsonPrimitive(Number var1) {
      this.a(var1);
   }

   JsonPrimitive(Object var1) {
      this.a(var1);
   }

   public JsonPrimitive(String var1) {
      this.a(var1);
   }

   private static boolean a(JsonPrimitive var0) {
      boolean var1;
      if (var0.b instanceof Number) {
         Number var2 = (Number)var0.b;
         if (!(var2 instanceof BigInteger) && !(var2 instanceof Long) && !(var2 instanceof Integer) && !(var2 instanceof Short) && !(var2 instanceof Byte)) {
            var1 = false;
         } else {
            var1 = true;
         }
      } else {
         var1 = false;
      }

      return var1;
   }

   private static boolean b(Object var0) {
      boolean var4 = true;
      boolean var3;
      if (var0 instanceof String) {
         var3 = var4;
      } else {
         Class var5 = var0.getClass();
         var0 = a;
         int var2 = var0.length;
         int var1 = 0;

         while (true) {
            if (var1 >= var2) {
               var3 = false;
               break;
            }

            var3 = var4;
            if (var0[var1].isAssignableFrom(var5)) {
               break;
            }

            var1++;
         }
      }

      return var3;
   }

   void a(Object var1) {
      if (var1 instanceof Character) {
         this.b = String.valueOf(((Character)var1).charValue());
      } else {
         boolean var2;
         if (!(var1 instanceof Number) && !b(var1)) {
            var2 = false;
         } else {
            var2 = true;
         }

         $Gson$Preconditions.a(var2);
         this.b = var1;
      }
   }

   public boolean a() {
      return this.b instanceof Boolean;
   }

   @Override
   public Number b() {
      Number var1;
      if (this.b instanceof String) {
         var1 = new LazilyParsedNumber((String)this.b);
      } else {
         var1 = (Number)this.b;
      }

      return var1;
   }

   @Override
   public String c() {
      String var1;
      if (this.p()) {
         var1 = this.b().toString();
      } else if (this.a()) {
         var1 = this.o().toString();
      } else {
         var1 = (String)this.b;
      }

      return var1;
   }

   @Override
   public double d() {
      double var1;
      if (this.p()) {
         var1 = this.b().doubleValue();
      } else {
         var1 = Double.parseDouble(this.c());
      }

      return var1;
   }

   @Override
   public long e() {
      long var1;
      if (this.p()) {
         var1 = this.b().longValue();
      } else {
         var1 = Long.parseLong(this.c());
      }

      return var1;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var6 = true;
      boolean var7 = false;
      if (this != var1) {
         if (var1 != null && this.getClass() == var1.getClass()) {
            var1 = var1;
            if (this.b == null) {
               if (var1.b != null) {
                  var6 = false;
               }
            } else if (a(this) && a(var1)) {
               if (this.b().longValue() != var1.b().longValue()) {
                  var6 = false;
               }
            } else if (this.b instanceof Number && var1.b instanceof Number) {
               double var4 = this.b().doubleValue();
               double var2 = var1.b().doubleValue();
               if (var4 != var2) {
                  var6 = var7;
                  if (!Double.isNaN(var4)) {
                     return var6;
                  }

                  var6 = var7;
                  if (!Double.isNaN(var2)) {
                     return var6;
                  }
               }

               var6 = true;
            } else {
               var6 = this.b.equals(var1.b);
            }
         } else {
            var6 = false;
         }
      }

      return var6;
   }

   @Override
   public int f() {
      int var1;
      if (this.p()) {
         var1 = this.b().intValue();
      } else {
         var1 = Integer.parseInt(this.c());
      }

      return var1;
   }

   @Override
   public boolean g() {
      boolean var1;
      if (this.a()) {
         var1 = this.o();
      } else {
         var1 = Boolean.parseBoolean(this.c());
      }

      return var1;
   }

   @Override
   public int hashCode() {
      int var1;
      if (this.b == null) {
         var1 = 31;
      } else if (a(this)) {
         long var2 = this.b().longValue();
         var1 = (int)(var2 ^ var2 >>> 32);
      } else if (this.b instanceof Number) {
         long var4 = Double.doubleToLongBits(this.b().doubleValue());
         var1 = (int)(var4 ^ var4 >>> 32);
      } else {
         var1 = this.b.hashCode();
      }

      return var1;
   }

   @Override
   Boolean o() {
      return (Boolean)this.b;
   }

   public boolean p() {
      return this.b instanceof Number;
   }

   public boolean q() {
      return this.b instanceof String;
   }
}
