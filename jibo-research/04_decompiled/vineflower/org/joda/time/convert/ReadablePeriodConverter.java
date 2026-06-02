package org.joda.time.convert;

import org.joda.time.ReadablePeriod;

class ReadablePeriodConverter extends AbstractConverter implements PeriodConverter {
   static final ReadablePeriodConverter a = new ReadablePeriodConverter();

   protected ReadablePeriodConverter() {
   }

   @Override
   public Class<?> a() {
      return ReadablePeriod.class;
   }
}
