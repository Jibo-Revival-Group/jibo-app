package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class JsonArray extends JsonElement implements Iterable<JsonElement> {
   private final List<JsonElement> a = new ArrayList<>();

   public int a() {
      return this.a.size();
   }

   public JsonElement a(int var1) {
      return this.a.get(var1);
   }

   public void a(JsonElement var1) {
      JsonElement var2 = var1;
      if (var1 == null) {
         var2 = JsonNull.a;
      }

      this.a.add(var2);
   }

   @Override
   public Number b() {
      if (this.a.size() == 1) {
         return this.a.get(0).b();
      } else {
         throw new IllegalStateException();
      }
   }

   @Override
   public String c() {
      if (this.a.size() == 1) {
         return this.a.get(0).c();
      } else {
         throw new IllegalStateException();
      }
   }

   @Override
   public double d() {
      if (this.a.size() == 1) {
         return this.a.get(0).d();
      } else {
         throw new IllegalStateException();
      }
   }

   @Override
   public long e() {
      if (this.a.size() == 1) {
         return this.a.get(0).e();
      } else {
         throw new IllegalStateException();
      }
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (var1 != this && (!(var1 instanceof JsonArray) || !((JsonArray)var1).a.equals(this.a))) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   @Override
   public int f() {
      if (this.a.size() == 1) {
         return this.a.get(0).f();
      } else {
         throw new IllegalStateException();
      }
   }

   @Override
   public boolean g() {
      if (this.a.size() == 1) {
         return this.a.get(0).g();
      } else {
         throw new IllegalStateException();
      }
   }

   @Override
   public int hashCode() {
      return this.a.hashCode();
   }

   @Override
   public Iterator<JsonElement> iterator() {
      return this.a.iterator();
   }
}
