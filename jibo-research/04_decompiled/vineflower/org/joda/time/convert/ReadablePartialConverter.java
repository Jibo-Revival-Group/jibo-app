package org.joda.time.convert;

import org.joda.time.Chronology;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadablePartial;

class ReadablePartialConverter extends AbstractConverter implements PartialConverter {
   static final ReadablePartialConverter a = new ReadablePartialConverter();

   protected ReadablePartialConverter() {
   }

   @Override
   public Class<?> a() {
      return ReadablePartial.class;
   }

   @Override
   public Chronology a(Object var1, DateTimeZone var2) {
      return this.b(var1, (Chronology)null).a(var2);
   }

   @Override
   public Chronology b(Object var1, Chronology var2) {
      Chronology var3 = var2;
      if (var2 == null) {
         var3 = DateTimeUtils.a(((ReadablePartial)var1).c());
      }

      return var3;
   }
}
