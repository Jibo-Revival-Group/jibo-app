package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public final class ObjectTypeAdapter extends TypeAdapter<Object> {
   public static final TypeAdapterFactory a = new TypeAdapterFactory() {
      @Override
      public <T> TypeAdapter<T> a(Gson var1, TypeToken<T> var2) {
         ObjectTypeAdapter var3;
         if (var2.getRawType() == Object.class) {
            var3 = new ObjectTypeAdapter(var1);
         } else {
            var3 = null;
         }

         return var3;
      }
   };
   private final Gson b;

   ObjectTypeAdapter(Gson var1) {
      this.b = var1;
   }

   @Override
   public Object read(JsonReader var1) throws IOException {
      JsonToken var2 = var1.f();
      Serializable var3;
      switch (<unrepresentable>.a[var2.ordinal()]) {
         case 1:
            ArrayList var5 = new ArrayList();
            var1.a();

            while (var1.e()) {
               var5.add(this.read(var1));
            }

            var1.b();
            var3 = var5;
            break;
         case 2:
            LinkedTreeMap var4 = new LinkedTreeMap();
            var1.c();

            while (var1.e()) {
               var4.put(var1.g(), this.read(var1));
            }

            var1.d();
            var3 = var4;
            break;
         case 3:
            var3 = var1.h();
            break;
         case 4:
            var3 = var1.k();
            break;
         case 5:
            var3 = var1.i();
            break;
         case 6:
            var1.j();
            var3 = null;
            break;
         default:
            throw new IllegalStateException();
      }

      return var3;
   }

   @Override
   public void write(JsonWriter var1, Object var2) throws IOException {
      if (var2 == null) {
         var1.f();
      } else {
         TypeAdapter var3 = this.b.a(var2.getClass());
         if (var3 instanceof ObjectTypeAdapter) {
            var1.d();
            var1.e();
         } else {
            var3.write(var1, var2);
         }
      }
   }
}
