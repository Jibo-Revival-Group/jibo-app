package org.joda.time.convert;

import org.joda.time.ReadableInterval;

class ReadableIntervalConverter extends AbstractConverter implements DurationConverter, IntervalConverter, PeriodConverter {
   static final ReadableIntervalConverter a = new ReadableIntervalConverter();

   protected ReadableIntervalConverter() {
   }

   @Override
   public Class<?> a() {
      return ReadableInterval.class;
   }
}
