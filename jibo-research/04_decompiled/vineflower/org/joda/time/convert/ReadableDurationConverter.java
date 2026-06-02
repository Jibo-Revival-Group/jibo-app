package org.joda.time.convert;

import org.joda.time.ReadableDuration;

class ReadableDurationConverter extends AbstractConverter implements DurationConverter, PeriodConverter {
   static final ReadableDurationConverter a = new ReadableDurationConverter();

   protected ReadableDurationConverter() {
   }

   @Override
   public Class<?> a() {
      return ReadableDuration.class;
   }
}
