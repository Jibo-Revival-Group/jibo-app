package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {
   public static final TypeAdapterFactory a = new TypeAdapterFactory() {
      @Override
      public <T> TypeAdapter<T> a(Gson var1, TypeToken<T> var2) {
         Type var4 = var2.getType();
         ArrayTypeAdapter var3;
         if (var4 instanceof GenericArrayType || var4 instanceof Class && ((Class)var4).isArray()) {
            Type var5 = $Gson$Types.g(var4);
            var3 = new ArrayTypeAdapter(var1, (TypeAdapter<E>)var1.a(TypeToken.get(var5)), (Class<E>)$Gson$Types.e(var5));
         } else {
            var3 = null;
         }

         return var3;
      }
   };
   private final Class<E> b;
   private final TypeAdapter<E> c;

   public ArrayTypeAdapter(Gson var1, TypeAdapter<E> var2, Class<E> var3) {
      this.c = new TypeAdapterRuntimeTypeWrapper<>(var1, var2, var3);
      this.b = var3;
   }

   @Override
   public Object read(JsonReader var1) throws IOException {
      Object var6;
      if (var1.f() == JsonToken.NULL) {
         var1.j();
         var6 = null;
      } else {
         ArrayList var5 = new ArrayList();
         var1.a();

         while (var1.e()) {
            var5.add(this.c.read(var1));
         }

         var1.b();
         int var3 = var5.size();
         Object var4 = Array.newInstance(this.b, var3);
         int var2 = 0;

         while (true) {
            var6 = var4;
            if (var2 >= var3) {
               break;
            }

            Array.set(var4, var2, var5.get(var2));
            var2++;
         }
      }

      return var6;
   }

   @Override
   public void write(JsonWriter var1, Object var2) throws IOException {
      if (var2 == null) {
         var1.f();
      } else {
         var1.b();
         int var3 = 0;

         for (int var4 = Array.getLength(var2); var3 < var4; var3++) {
            Object var5 = Array.get(var2, var3);
            this.c.write(var1, (E)var5);
         }

         var1.c();
      }
   }
}
