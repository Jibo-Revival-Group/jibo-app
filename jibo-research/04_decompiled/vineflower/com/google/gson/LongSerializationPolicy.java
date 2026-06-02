package com.google.gson;

public enum LongSerializationPolicy {
   DEFAULT {
      @Override
      public JsonElement serialize(Long var1) {
         return new JsonPrimitive(var1);
      }
   },
   STRING {
      @Override
      public JsonElement serialize(Long var1) {
         return new JsonPrimitive(String.valueOf(var1));
      }
   };

   private static final LongSerializationPolicy[] $VALUES = new LongSerializationPolicy[]{LongSerializationPolicy.DEFAULT, LongSerializationPolicy.STRING};

   LongSerializationPolicy() {
   }

   public abstract JsonElement serialize(Long var1);
}
