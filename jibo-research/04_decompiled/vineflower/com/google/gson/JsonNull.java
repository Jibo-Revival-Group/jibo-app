package com.google.gson;

public final class JsonNull extends JsonElement {
   public static final JsonNull a = new JsonNull();

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (this != var1 && !(var1 instanceof JsonNull)) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return JsonNull.class.hashCode();
   }
}
