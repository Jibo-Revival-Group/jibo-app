package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {
   private final Gson a;
   private final TypeAdapter<T> b;
   private final Type c;

   TypeAdapterRuntimeTypeWrapper(Gson var1, TypeAdapter<T> var2, Type var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   private Type a(Type var1, Object var2) {
      Type var3 = var1;
      if (var2 != null) {
         if (var1 != Object.class && !(var1 instanceof TypeVariable)) {
            var3 = var1;
            if (!(var1 instanceof Class)) {
               return var3;
            }
         }

         var3 = var2.getClass();
      }

      return var3;
   }

   @Override
   public T read(JsonReader var1) throws IOException {
      return this.b.read(var1);
   }

   @Override
   public void write(JsonWriter var1, T var2) throws IOException {
      TypeAdapter var3 = this.b;
      Type var4 = this.a(this.c, var2);
      if (var4 != this.c) {
         var3 = this.a.a(TypeToken.get(var4));
         if (var3 instanceof ReflectiveTypeAdapterFactory.Adapter && !(this.b instanceof ReflectiveTypeAdapterFactory.Adapter)) {
            var3 = this.b;
         }
      }

      var3.write(var1, var2);
   }
}
