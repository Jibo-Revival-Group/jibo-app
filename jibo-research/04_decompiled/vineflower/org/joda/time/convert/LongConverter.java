package org.joda.time.convert;

import org.joda.time.Chronology;

class LongConverter extends AbstractConverter implements DurationConverter, InstantConverter, PartialConverter {
   static final LongConverter a = new LongConverter();

   protected LongConverter() {
   }

   @Override
   public long a(Object var1, Chronology var2) {
      return (Long)var1;
   }

   @Override
   public Class<?> a() {
      return Long.class;
   }
}
