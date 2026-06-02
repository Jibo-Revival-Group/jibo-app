package com.google.maps.internal;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.maps.model.LatLng;
import java.io.IOException;

public class LatLngAdapter extends TypeAdapter<LatLng> {
   public LatLng read(JsonReader var1) throws IOException {
      boolean var7 = false;
      double var4 = 0.0;
      LatLng var9;
      if (var1.f() == JsonToken.NULL) {
         var1.j();
         var9 = null;
      } else {
         var1.c();
         boolean var6 = false;
         double var2 = 0.0;

         while (var1.e()) {
            String var8 = var1.g();
            if ("lat".equals(var8) || "latitude".equals(var8)) {
               var2 = var1.k();
               var6 = true;
            } else if ("lng".equals(var8) || "longitude".equals(var8)) {
               var4 = var1.k();
               var7 = true;
            }
         }

         var1.d();
         if (var6 && var7) {
            var9 = new LatLng(var2, var4);
         } else {
            var9 = null;
         }
      }

      return var9;
   }

   public void write(JsonWriter var1, LatLng var2) throws IOException {
      throw new UnsupportedOperationException("Unimplemented method.");
   }
}
