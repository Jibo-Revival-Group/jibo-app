package com.google.maps.internal;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.maps.model.Distance;
import java.io.IOException;

public class DistanceAdapter extends TypeAdapter<Distance> {
   public Distance read(JsonReader var1) throws IOException {
      Distance var4;
      if (var1.f() == JsonToken.NULL) {
         var1.j();
         var4 = null;
      } else {
         Distance var2 = new Distance();
         var1.c();

         while (var1.e()) {
            String var3 = var1.g();
            if (var3.equals("text")) {
               var2.humanReadable = var1.h();
            } else if (var3.equals("value")) {
               var2.inMeters = var1.l();
            }
         }

         var1.d();
         var4 = var2;
      }

      return var4;
   }

   public void write(JsonWriter var1, Distance var2) throws IOException {
      throw new UnsupportedOperationException("Unimplemented method");
   }
}
