package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Set;
import java.util.Map.Entry;

public final class JsonObject extends JsonElement {
   private final LinkedTreeMap<String, JsonElement> a = new LinkedTreeMap<>();

   private JsonElement a(Object var1) {
      if (var1 == null) {
         var1 = JsonNull.a;
      } else {
         var1 = new JsonPrimitive(var1);
      }

      return var1;
   }

   public JsonElement a(String var1) {
      return this.a.remove(var1);
   }

   public Set<Entry<String, JsonElement>> a() {
      return this.a.entrySet();
   }

   public void a(String var1, JsonElement var2) {
      JsonElement var3 = var2;
      if (var2 == null) {
         var3 = JsonNull.a;
      }

      this.a.put(var1, var3);
   }

   public void a(String var1, Boolean var2) {
      this.a(var1, this.a(var2));
   }

   public void a(String var1, Number var2) {
      this.a(var1, this.a(var2));
   }

   public void a(String var1, String var2) {
      this.a(var1, this.a((Object)var2));
   }

   public boolean b(String var1) {
      return this.a.containsKey(var1);
   }

   public JsonElement c(String var1) {
      return this.a.get(var1);
   }

   public JsonArray d(String var1) {
      return (JsonArray)this.a.get(var1);
   }

   public JsonObject e(String var1) {
      return (JsonObject)this.a.get(var1);
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (var1 != this && (!(var1 instanceof JsonObject) || !((JsonObject)var1).a.equals(this.a))) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return this.a.hashCode();
   }

   public int p() {
      return this.a.size();
   }
}
