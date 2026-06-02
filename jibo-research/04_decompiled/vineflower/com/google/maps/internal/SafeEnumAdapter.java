package com.google.maps.internal;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SafeEnumAdapter<E extends Enum<E>> extends TypeAdapter<E> {
   private static final Logger LOG = LoggerFactory.a(SafeEnumAdapter.class.getName());
   private final Class<E> clazz;
   private final E unknownValue;

   public SafeEnumAdapter(E var1) {
      if (var1 == null) {
         throw new IllegalArgumentException();
      }

      this.unknownValue = (E)var1;
      this.clazz = var1.getDeclaringClass();
   }

   public E read(JsonReader var1) throws IOException {
      Enum var4;
      if (var1.f() == JsonToken.NULL) {
         var1.j();
         var4 = null;
      } else {
         String var2 = var1.h();

         try {
            var4 = Enum.valueOf(this.clazz, var2.toUpperCase(Locale.ENGLISH));
         } catch (IllegalArgumentException var3) {
            LOG.a("Unknown type for enum {}: '{}'", this.clazz.getName(), var2);
            var4 = this.unknownValue;
         }
      }

      return (E)var4;
   }

   public void write(JsonWriter var1, E var2) throws IOException {
      throw new UnsupportedOperationException("Unimplemented method");
   }
}
