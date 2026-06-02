package com.google.maps.internal;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.maps.model.Fare;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Currency;

public class FareAdapter extends TypeAdapter<Fare> {
   public Fare read(JsonReader var1) throws IOException {
      Fare var4;
      if (var1.f() == JsonToken.NULL) {
         var1.j();
         var4 = null;
      } else {
         Fare var2 = new Fare();
         var1.c();

         while (var1.e()) {
            String var3 = var1.g();
            if ("currency".equals(var3)) {
               var2.currency = Currency.getInstance(var1.h());
            } else if ("value".equals(var3)) {
               var2.value = new BigDecimal(var1.h());
            } else {
               var1.n();
            }
         }

         var1.d();
         var4 = var2;
      }

      return var4;
   }

   public void write(JsonWriter var1, Fare var2) throws IOException {
      throw new UnsupportedOperationException("Unimplemented method");
   }
}
