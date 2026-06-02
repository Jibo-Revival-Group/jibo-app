package org.joda.time.convert;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.GJChronology;
import org.joda.time.chrono.GregorianChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.chrono.JulianChronology;

final class CalendarConverter extends AbstractConverter implements InstantConverter, PartialConverter {
   static final CalendarConverter a = new CalendarConverter();

   protected CalendarConverter() {
   }

   @Override
   public long a(Object var1, Chronology var2) {
      return ((Calendar)var1).getTime().getTime();
   }

   @Override
   public Class<?> a() {
      return Calendar.class;
   }

   @Override
   public Chronology a(Object var1, DateTimeZone var2) {
      AssembledChronology var5;
      if (var1.getClass().getName().endsWith(".BuddhistCalendar")) {
         var5 = BuddhistChronology.b(var2);
      } else if (var1 instanceof GregorianCalendar) {
         long var3 = ((GregorianCalendar)var1).getGregorianChange().getTime();
         if (var3 == Long.MIN_VALUE) {
            var5 = GregorianChronology.b(var2);
         } else if (var3 == Long.MAX_VALUE) {
            var5 = JulianChronology.b(var2);
         } else {
            var5 = GJChronology.a(var2, var3, 4);
         }
      } else {
         var5 = ISOChronology.b(var2);
      }

      return var5;
   }

   @Override
   public Chronology b(Object var1, Chronology var2) {
      if (var2 == null) {
         Calendar var5 = (Calendar)var1;

         try {
            var4 = DateTimeZone.a(var5.getTimeZone());
         } catch (IllegalArgumentException var3) {
            var4 = DateTimeZone.a();
         }

         var2 = this.a(var5, var4);
      }

      return var2;
   }
}
