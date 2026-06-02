package com.google.maps.internal;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class DateTimeAdapter extends TypeAdapter<DateTime> {
   public DateTime read(JsonReader var1) throws IOException {
      DateTime var6;
      if (var1.f() == JsonToken.NULL) {
         var1.j();
         var6 = null;
      } else {
         String var4 = "";
         long var2 = 0L;
         var1.c();

         while (var1.e()) {
            String var5 = var1.g();
            if (var5.equals("text")) {
               var1.h();
            } else if (var5.equals("time_zone")) {
               var4 = var1.h();
            } else if (var5.equals("value")) {
               var2 = var1.l();
            }
         }

         var1.d();
         var6 = new DateTime(var2 * 1000L, DateTimeZone.a(var4));
      }

      return var6;
   }

   public void write(JsonWriter var1, DateTime var2) throws IOException {
      throw new UnsupportedOperationException("Unimplemented method");
   }
}
