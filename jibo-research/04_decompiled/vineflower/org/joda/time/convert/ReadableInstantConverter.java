package org.joda.time.convert;

import org.joda.time.Chronology;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadableInstant;
import org.joda.time.chrono.ISOChronology;

class ReadableInstantConverter extends AbstractConverter implements InstantConverter, PartialConverter {
   static final ReadableInstantConverter a = new ReadableInstantConverter();

   protected ReadableInstantConverter() {
   }

   @Override
   public long a(Object var1, Chronology var2) {
      return ((ReadableInstant)var1).c();
   }

   @Override
   public Class<?> a() {
      return ReadableInstant.class;
   }

   @Override
   public Chronology a(Object var1, DateTimeZone var2) {
      Chronology var3 = ((ReadableInstant)var1).d();
      Chronology var4;
      if (var3 == null) {
         var4 = ISOChronology.b(var2);
      } else {
         var4 = var3;
         if (var3.a() != var2) {
            var3 = var3.a(var2);
            var4 = var3;
            if (var3 == null) {
               var4 = ISOChronology.b(var2);
            }
         }
      }

      return var4;
   }

   @Override
   public Chronology b(Object var1, Chronology var2) {
      Chronology var3 = var2;
      if (var2 == null) {
         var3 = DateTimeUtils.a(((ReadableInstant)var1).d());
      }

      return var3;
   }
}
