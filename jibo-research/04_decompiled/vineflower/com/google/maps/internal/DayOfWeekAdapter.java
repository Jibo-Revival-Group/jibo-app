package com.google.maps.internal;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.maps.model.OpeningHours;
import java.io.IOException;

public class DayOfWeekAdapter extends TypeAdapter<OpeningHours.Period.OpenClose.DayOfWeek> {
   public OpeningHours.Period.OpenClose.DayOfWeek read(JsonReader var1) throws IOException {
      OpeningHours.Period.OpenClose.DayOfWeek var2;
      if (var1.f() == JsonToken.NULL) {
         var1.j();
         var2 = null;
      } else {
         if (var1.f() == JsonToken.NUMBER) {
            switch (var1.m()) {
               case 0:
                  OpeningHours.Period.OpenClose.DayOfWeek var9 = OpeningHours.Period.OpenClose.DayOfWeek.SUNDAY;
                  return var9;
               case 1:
                  OpeningHours.Period.OpenClose.DayOfWeek var8 = OpeningHours.Period.OpenClose.DayOfWeek.MONDAY;
                  return var8;
               case 2:
                  OpeningHours.Period.OpenClose.DayOfWeek var7 = OpeningHours.Period.OpenClose.DayOfWeek.TUESDAY;
                  return var7;
               case 3:
                  OpeningHours.Period.OpenClose.DayOfWeek var6 = OpeningHours.Period.OpenClose.DayOfWeek.WEDNESDAY;
                  return var6;
               case 4:
                  OpeningHours.Period.OpenClose.DayOfWeek var5 = OpeningHours.Period.OpenClose.DayOfWeek.THURSDAY;
                  return var5;
               case 5:
                  OpeningHours.Period.OpenClose.DayOfWeek var4 = OpeningHours.Period.OpenClose.DayOfWeek.FRIDAY;
                  return var4;
               case 6:
                  OpeningHours.Period.OpenClose.DayOfWeek var3 = OpeningHours.Period.OpenClose.DayOfWeek.SATURDAY;
                  return var3;
            }
         }

         var2 = OpeningHours.Period.OpenClose.DayOfWeek.UNKNOWN;
      }

      return var2;
   }

   public void write(JsonWriter var1, OpeningHours.Period.OpenClose.DayOfWeek var2) throws IOException {
      throw new UnsupportedOperationException("Unimplemented method");
   }
}
