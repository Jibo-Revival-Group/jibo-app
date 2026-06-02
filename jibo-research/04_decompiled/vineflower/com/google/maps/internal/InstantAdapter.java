package com.google.maps.internal;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import org.joda.time.Instant;

public class InstantAdapter extends TypeAdapter<Instant> {
   public Instant read(JsonReader var1) throws IOException {
      Instant var2;
      if (var1.f() == JsonToken.NULL) {
         var1.j();
         var2 = null;
      } else {
         if (var1.f() != JsonToken.NUMBER) {
            throw new UnsupportedOperationException("Unsupported format");
         }

         var2 = new Instant(var1.l() * 1000L);
      }

      return var2;
   }

   public void write(JsonWriter var1, Instant var2) throws IOException {
      throw new UnsupportedOperationException("Unimplemented method");
   }
}
