package com.google.maps.internal;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.maps.model.PriceLevel;
import java.io.IOException;

public class PriceLevelAdapter extends TypeAdapter<PriceLevel> {
   public PriceLevel read(JsonReader var1) throws IOException {
      PriceLevel var2;
      if (var1.f() == JsonToken.NULL) {
         var1.j();
         var2 = null;
      } else {
         if (var1.f() == JsonToken.NUMBER) {
            switch (var1.m()) {
               case 0:
                  PriceLevel var7 = PriceLevel.FREE;
                  return var7;
               case 1:
                  PriceLevel var6 = PriceLevel.INEXPENSIVE;
                  return var6;
               case 2:
                  PriceLevel var5 = PriceLevel.MODERATE;
                  return var5;
               case 3:
                  PriceLevel var4 = PriceLevel.EXPENSIVE;
                  return var4;
               case 4:
                  PriceLevel var3 = PriceLevel.VERY_EXPENSIVE;
                  return var3;
            }
         }

         var2 = PriceLevel.UNKNOWN;
      }

      return var2;
   }

   public void write(JsonWriter var1, PriceLevel var2) throws IOException {
      throw new UnsupportedOperationException("Unimplemented method");
   }
}
