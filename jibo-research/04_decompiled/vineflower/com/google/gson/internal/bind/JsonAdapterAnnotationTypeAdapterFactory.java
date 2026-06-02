package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;

public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {
   private final ConstructorConstructor a;

   public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor var1) {
      this.a = var1;
   }

   @Override
   public <T> TypeAdapter<T> a(Gson var1, TypeToken<T> var2) {
      JsonAdapter var3 = var2.getRawType().getAnnotation(JsonAdapter.class);
      TypeAdapter var4;
      if (var3 == null) {
         var4 = null;
      } else {
         var4 = this.a(this.a, var1, var2, var3);
      }

      return var4;
   }

   TypeAdapter<?> a(ConstructorConstructor var1, Gson var2, TypeToken<?> var3, JsonAdapter var4) {
      Object var5 = var1.a(TypeToken.get(var4.a())).a();
      TypeAdapter var6;
      if (var5 instanceof TypeAdapter) {
         var6 = (TypeAdapter)var5;
      } else if (var5 instanceof TypeAdapterFactory) {
         var6 = ((TypeAdapterFactory)var5).a(var2, var3);
      } else {
         if (!(var5 instanceof JsonSerializer) && !(var5 instanceof JsonDeserializer)) {
            throw new IllegalArgumentException(
               "Invalid attempt to bind an instance of "
                  + var5.getClass().getName()
                  + " as a @JsonAdapter for "
                  + var3.toString()
                  + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer."
            );
         }

         JsonSerializer var7;
         if (var5 instanceof JsonSerializer) {
            var7 = (JsonSerializer)var5;
         } else {
            var7 = null;
         }

         JsonDeserializer var9;
         if (var5 instanceof JsonDeserializer) {
            var9 = (JsonDeserializer)var5;
         } else {
            var9 = null;
         }

         var6 = new TreeTypeAdapter(var7, var9, var2, var3, null);
      }

      TypeAdapter var8 = var6;
      if (var6 != null) {
         var8 = var6;
         if (var4.b()) {
            var8 = var6.nullSafe();
         }
      }

      return var8;
   }
}
