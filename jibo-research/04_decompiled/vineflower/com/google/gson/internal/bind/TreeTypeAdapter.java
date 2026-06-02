package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;

public final class TreeTypeAdapter<T> extends TypeAdapter<T> {
   final Gson a;
   private final JsonSerializer<T> b;
   private final JsonDeserializer<T> c;
   private final TypeToken<T> d;
   private final TypeAdapterFactory e;
   private final TreeTypeAdapter<T>.GsonContextImpl f = new TreeTypeAdapter.GsonContextImpl(this);
   private TypeAdapter<T> g;

   public TreeTypeAdapter(JsonSerializer<T> var1, JsonDeserializer<T> var2, Gson var3, TypeToken<T> var4, TypeAdapterFactory var5) {
      this.b = var1;
      this.c = var2;
      this.a = var3;
      this.d = var4;
      this.e = var5;
   }

   private TypeAdapter<T> a() {
      TypeAdapter var1 = this.g;
      if (var1 == null) {
         var1 = this.a.a(this.e, this.d);
         this.g = var1;
      }

      return var1;
   }

   public static TypeAdapterFactory a(TypeToken<?> var0, Object var1) {
      boolean var2;
      if (var0.getType() == var0.getRawType()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return new TreeTypeAdapter.SingleTypeFactory(var1, var0, var2, null);
   }

   public static TypeAdapterFactory a(Class<?> var0, Object var1) {
      return new TreeTypeAdapter.SingleTypeFactory(var1, null, false, var0);
   }

   @Override
   public T read(JsonReader var1) throws IOException {
      Object var2;
      if (this.c == null) {
         var2 = this.a().read(var1);
      } else {
         var2 = Streams.a(var1);
         if (var2.k()) {
            var2 = null;
         } else {
            var2 = this.c.deserialize(var2, this.d.getType(), this.f);
         }
      }

      return (T)var2;
   }

   @Override
   public void write(JsonWriter var1, T var2) throws IOException {
      if (this.b == null) {
         this.a().write(var1, (T)var2);
      } else if (var2 == null) {
         var1.f();
      } else {
         Streams.a(this.b.a((T)var2, this.d.getType(), this.f), var1);
      }
   }

   private final class GsonContextImpl implements JsonDeserializationContext, JsonSerializationContext {
      final TreeTypeAdapter a;

      private GsonContextImpl(TreeTypeAdapter var1) {
         this.a = var1;
      }

      @Override
      public JsonElement a(Object var1) {
         return this.a.a.a(var1);
      }

      @Override
      public JsonElement a(Object var1, Type var2) {
         return this.a.a.a(var1, var2);
      }

      @Override
      public <R> R a(JsonElement var1, Type var2) throws JsonParseException {
         return this.a.a.a(var1, var2);
      }
   }

   private static final class SingleTypeFactory implements TypeAdapterFactory {
      private final TypeToken<?> a;
      private final boolean b;
      private final Class<?> c;
      private final JsonSerializer<?> d;
      private final JsonDeserializer<?> e;

      SingleTypeFactory(Object var1, TypeToken<?> var2, boolean var3, Class<?> var4) {
         JsonSerializer var6;
         if (var1 instanceof JsonSerializer) {
            var6 = (JsonSerializer)var1;
         } else {
            var6 = null;
         }

         this.d = var6;
         JsonDeserializer var7;
         if (var1 instanceof JsonDeserializer) {
            var7 = (JsonDeserializer)var1;
         } else {
            var7 = null;
         }

         this.e = var7;
         boolean var5;
         if (this.d == null && this.e == null) {
            var5 = false;
         } else {
            var5 = true;
         }

         $Gson$Preconditions.a(var5);
         this.a = var2;
         this.b = var3;
         this.c = var4;
      }

      @Override
      public <T> TypeAdapter<T> a(Gson var1, TypeToken<T> var2) {
         boolean var3;
         if (this.a != null) {
            if (!this.a.equals(var2) && (!this.b || this.a.getType() != var2.getRawType())) {
               var3 = false;
            } else {
               var3 = true;
            }
         } else {
            var3 = this.c.isAssignableFrom(var2.getRawType());
         }

         TreeTypeAdapter var4;
         if (var3) {
            var4 = new TreeTypeAdapter<>(this.d, this.e, var1, var2, this);
         } else {
            var4 = null;
         }

         return var4;
      }
   }
}
