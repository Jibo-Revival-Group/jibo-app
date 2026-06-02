package org.joda.time.convert;

import org.joda.time.Chronology;
import org.joda.time.format.ISODateTimeFormat;

class StringConverter extends AbstractConverter implements DurationConverter, InstantConverter, IntervalConverter, PartialConverter, PeriodConverter {
   static final StringConverter a = new StringConverter();

   protected StringConverter() {
   }

   @Override
   public long a(Object var1, Chronology var2) {
      var1 = var1;
      return ISODateTimeFormat.a().a(var2).a(var1);
   }

   @Override
   public Class<?> a() {
      return String.class;
   }
}
