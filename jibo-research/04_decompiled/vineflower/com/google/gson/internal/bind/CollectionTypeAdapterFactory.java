package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {
   private final ConstructorConstructor a;

   public CollectionTypeAdapterFactory(ConstructorConstructor var1) {
      this.a = var1;
   }

   @Override
   public <T> TypeAdapter<T> a(Gson var1, TypeToken<T> var2) {
      Type var4 = var2.getType();
      Class var3 = var2.getRawType();
      CollectionTypeAdapterFactory.Adapter var5;
      if (!Collection.class.isAssignableFrom(var3)) {
         var5 = null;
      } else {
         Type var6 = $Gson$Types.a(var4, var3);
         var5 = new CollectionTypeAdapterFactory.Adapter<>(var1, var6, var1.a(TypeToken.get(var6)), this.a.a(var2));
      }

      return var5;
   }

   private static final class Adapter<E> extends TypeAdapter<Collection<E>> {
      private final TypeAdapter<E> a;
      private final ObjectConstructor<? extends Collection<E>> b;

      public Adapter(Gson var1, Type var2, TypeAdapter<E> var3, ObjectConstructor<? extends Collection<E>> var4) {
         this.a = new TypeAdapterRuntimeTypeWrapper<>(var1, var3, var2);
         this.b = var4;
      }

      public Collection<E> a(JsonReader var1) throws IOException {
         Collection var3;
         if (var1.f() == JsonToken.NULL) {
            var1.j();
            var3 = null;
         } else {
            Collection var2 = this.b.a();
            var1.a();

            while (var1.e()) {
               var2.add(this.a.read(var1));
            }

            var1.b();
            var3 = var2;
         }

         return var3;
      }

      public void a(JsonWriter var1, Collection<E> var2) throws IOException {
         if (var2 == null) {
            var1.f();
         } else {
            var1.b();

            for (Object var3 : var2) {
               this.a.write(var1, (E)var3);
            }

            var1.c();
         }
      }
   }
}
