package com.google.maps.internal;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class LocalTimeAdapter extends TypeAdapter<LocalTime> {
   public LocalTime read(JsonReader var1) throws IOException {
      LocalTime var3;
      if (var1.f() == JsonToken.NULL) {
         var1.j();
         var3 = null;
      } else {
         if (var1.f() != JsonToken.STRING) {
            throw new UnsupportedOperationException("Unsupported format");
         }

         DateTimeFormatter var2 = DateTimeFormat.a("HHmm");
         var3 = LocalTime.a(var1.h(), var2);
      }

      return var3;
   }

   public void write(JsonWriter var1, LocalTime var2) throws IOException {
      throw new UnsupportedOperationException("Unimplemented method");
   }
}
