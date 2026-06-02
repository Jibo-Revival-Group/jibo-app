package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class MapTypeAdapterFactory implements TypeAdapterFactory {
   final boolean a;
   private final ConstructorConstructor b;

   public MapTypeAdapterFactory(ConstructorConstructor var1, boolean var2) {
      this.b = var1;
      this.a = var2;
   }

   private TypeAdapter<?> a(Gson var1, Type var2) {
      TypeAdapter var3;
      if (var2 != boolean.class && var2 != Boolean.class) {
         var3 = var1.a(TypeToken.get(var2));
      } else {
         var3 = TypeAdapters.f;
      }

      return var3;
   }

   @Override
   public <T> TypeAdapter<T> a(Gson var1, TypeToken<T> var2) {
      Type var3 = var2.getType();
      MapTypeAdapterFactory.Adapter var6;
      if (!Map.class.isAssignableFrom(var2.getRawType())) {
         var6 = null;
      } else {
         Type[] var4 = $Gson$Types.b(var3, $Gson$Types.e(var3));
         TypeAdapter var8 = this.a(var1, var4[0]);
         TypeAdapter var5 = var1.a(TypeToken.get(var4[1]));
         ObjectConstructor var7 = this.b.a(var2);
         var6 = new MapTypeAdapterFactory.Adapter(this, var1, var4[0], var8, var4[1], var5, var7);
      }

      return var6;
   }

   private final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {
      final MapTypeAdapterFactory a;
      private final TypeAdapter<K> b;
      private final TypeAdapter<V> c;
      private final ObjectConstructor<? extends Map<K, V>> d;

      public Adapter(MapTypeAdapterFactory var1, Gson var2, Type var3, TypeAdapter var4, Type var5, TypeAdapter var6, ObjectConstructor var7) {
         this.a = var1;
         this.b = new TypeAdapterRuntimeTypeWrapper<>(var2, var4, var3);
         this.c = new TypeAdapterRuntimeTypeWrapper<>(var2, var6, var5);
         this.d = var7;
      }

      private String a(JsonElement var1) {
         String var3;
         if (var1.j()) {
            var1 = var1.n();
            if (var1.p()) {
               var3 = String.valueOf(var1.b());
            } else if (var1.a()) {
               var3 = Boolean.toString(var1.g());
            } else {
               if (!var1.q()) {
                  throw new AssertionError();
               }

               var3 = var1.c();
            }
         } else {
            if (!var1.k()) {
               throw new AssertionError();
            }

            var3 = "null";
         }

         return var3;
      }

      public Map<K, V> a(JsonReader var1) throws IOException {
         JsonToken var3 = var1.f();
         Map var4;
         if (var3 == JsonToken.NULL) {
            var1.j();
            var4 = null;
         } else {
            Map var2 = this.d.a();
            if (var3 == JsonToken.BEGIN_ARRAY) {
               var1.a();

               while (var1.e()) {
                  var1.a();
                  Object var5 = this.b.read(var1);
                  if (var2.put(var5, this.c.read(var1)) != null) {
                     throw new JsonSyntaxException("duplicate key: " + var5);
                  }

                  var1.b();
               }

               var1.b();
               var4 = var2;
            } else {
               var1.c();

               while (var1.e()) {
                  JsonReaderInternalAccess.a.a(var1);
                  Object var6 = this.b.read(var1);
                  if (var2.put(var6, this.c.read(var1)) != null) {
                     throw new JsonSyntaxException("duplicate key: " + var6);
                  }
               }

               var1.d();
               var4 = var2;
            }
         }

         return var4;
      }

      public void a(JsonWriter var1, Map<K, V> var2) throws IOException {
         byte var5 = 0;
         byte var6 = 0;
         if (var2 == null) {
            var1.f();
         } else if (!this.a.a) {
            var1.d();

            for (Entry var11 : var2.entrySet()) {
               var1.a(String.valueOf(var11.getKey()));
               this.c.write(var1, (V)var11.getValue());
            }

            var1.e();
         } else {
            ArrayList var8 = new ArrayList(var2.size());
            ArrayList var17 = new ArrayList(var2.size());
            Iterator var12 = var2.entrySet().iterator();
            boolean var3 = false;

            while (var12.hasNext()) {
               Entry var9 = (Entry)var12.next();
               JsonElement var10 = this.b.toJsonTree((K)var9.getKey());
               var8.add(var10);
               var17.add(var9.getValue());
               boolean var4;
               if (!var10.h() && !var10.i()) {
                  var4 = false;
               } else {
                  var4 = true;
               }

               var3 |= var4;
            }

            if (var3) {
               var1.b();
               int var15 = var8.size();

               for (int var13 = var6; var13 < var15; var13++) {
                  var1.b();
                  Streams.a((JsonElement)var8.get(var13), var1);
                  this.c.write(var1, (V)var17.get(var13));
                  var1.c();
               }

               var1.c();
            } else {
               var1.d();
               int var16 = var8.size();

               for (int var14 = var5; var14 < var16; var14++) {
                  var1.a(this.a((JsonElement)var8.get(var14)));
                  this.c.write(var1, (V)var17.get(var14));
               }

               var1.e();
            }
         }
      }
   }
}
