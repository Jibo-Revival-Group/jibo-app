package org.joda.time.convert;

import java.util.Date;
import org.joda.time.Chronology;

final class DateConverter extends AbstractConverter implements InstantConverter, PartialConverter {
   static final DateConverter a = new DateConverter();

   protected DateConverter() {
   }

   @Override
   public long a(Object var1, Chronology var2) {
      return ((Date)var1).getTime();
   }

   @Override
   public Class<?> a() {
      return Date.class;
   }
}
