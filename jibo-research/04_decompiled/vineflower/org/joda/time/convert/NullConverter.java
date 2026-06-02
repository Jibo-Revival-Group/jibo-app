package org.joda.time.convert;

class NullConverter extends AbstractConverter implements DurationConverter, InstantConverter, IntervalConverter, PartialConverter, PeriodConverter {
   static final NullConverter a = new NullConverter();

   protected NullConverter() {
   }

   @Override
   public Class<?> a() {
      return null;
   }
}
