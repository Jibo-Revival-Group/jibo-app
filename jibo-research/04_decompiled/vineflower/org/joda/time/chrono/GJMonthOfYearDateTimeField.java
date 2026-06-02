package org.joda.time.chrono;

import java.util.Locale;

final class GJMonthOfYearDateTimeField extends BasicMonthOfYearDateTimeField {
   GJMonthOfYearDateTimeField(BasicChronology var1) {
      super(var1, 2);
   }

   @Override
   protected int a(String var1, Locale var2) {
      return GJLocaleSymbols.a(var2).b(var1);
   }

   @Override
   public int a(Locale var1) {
      return GJLocaleSymbols.a(var1).b();
   }

   @Override
   public String a(int var1, Locale var2) {
      return GJLocaleSymbols.a(var2).b(var1);
   }

   @Override
   public String b(int var1, Locale var2) {
      return GJLocaleSymbols.a(var2).c(var1);
   }
}
