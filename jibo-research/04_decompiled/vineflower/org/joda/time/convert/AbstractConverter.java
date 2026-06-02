package org.joda.time.convert;

import org.joda.time.Chronology;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.ISOChronology;

public abstract class AbstractConverter implements Converter {
   protected AbstractConverter() {
   }

   public long a(Object var1, Chronology var2) {
      return DateTimeUtils.a();
   }

   public Chronology a(Object var1, DateTimeZone var2) {
      return ISOChronology.b(var2);
   }

   public Chronology b(Object var1, Chronology var2) {
      return DateTimeUtils.a(var2);
   }

   @Override
   public String toString() {
      StringBuilder var2 = new StringBuilder().append("Converter[");
      String var1;
      if (this.a() == null) {
         var1 = "null";
      } else {
         var1 = this.a().getName();
      }

      return var2.append(var1).append("]").toString();
   }
}
