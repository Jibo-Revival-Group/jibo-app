package com.fasterxml.jackson.core;

import java.io.Serializable;

public class JsonLocation implements Serializable {
   public static final JsonLocation a = new JsonLocation("N/A", -1L, -1L, -1, -1);
   final long b;
   final long c;
   final int d;
   final int e;
   final transient Object f;

   public JsonLocation(Object var1, long var2, int var4, int var5) {
      this(var1, -1L, var2, var4, var5);
   }

   public JsonLocation(Object var1, long var2, long var4, int var6, int var7) {
      this.f = var1;
      this.b = var2;
      this.c = var4;
      this.d = var6;
      this.e = var7;
   }

   public long a() {
      return this.b;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var4 = true;
      boolean var3 = false;
      boolean var2;
      if (var1 == this) {
         var2 = true;
      } else {
         var2 = var3;
         if (var1 != null) {
            var2 = var3;
            if (var1 instanceof JsonLocation) {
               var1 = var1;
               if (this.f == null) {
                  var2 = var3;
                  if (var1.f != null) {
                     return var2;
                  }
               } else if (!this.f.equals(var1.f)) {
                  var2 = var3;
                  return var2;
               }

               if (this.d == var1.d && this.e == var1.e && this.c == var1.c && this.a() == var1.a()) {
                  var2 = var4;
               } else {
                  var2 = false;
               }
            }
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      int var1;
      if (this.f == null) {
         var1 = 1;
      } else {
         var1 = this.f.hashCode();
      }

      return ((var1 ^ this.d) + this.e ^ (int)this.c) + (int)this.b;
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder(80);
      var1.append("[Source: ");
      if (this.f == null) {
         var1.append("UNKNOWN");
      } else {
         var1.append(this.f.toString());
      }

      var1.append("; line: ");
      var1.append(this.d);
      var1.append(", column: ");
      var1.append(this.e);
      var1.append(']');
      return var1.toString();
   }
}
