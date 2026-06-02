package org.joda.time.chrono;

import java.util.Locale;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.PreciseDurationDateTimeField;

final class GJDayOfWeekDateTimeField extends PreciseDurationDateTimeField {
   private final BasicChronology b;

   GJDayOfWeekDateTimeField(BasicChronology var1, DurationField var2) {
      super(DateTimeFieldType.l(), var2);
      this.b = var1;
   }

   @Override
   public int a(long var1) {
      return this.b.g(var1);
   }

   @Override
   protected int a(String var1, Locale var2) {
      return GJLocaleSymbols.a(var2).c(var1);
   }

   @Override
   public int a(Locale var1) {
      return GJLocaleSymbols.a(var1).c();
   }

   @Override
   public String a(int var1, Locale var2) {
      return GJLocaleSymbols.a(var2).d(var1);
   }

   @Override
   public String b(int var1, Locale var2) {
      return GJLocaleSymbols.a(var2).e(var1);
   }

   @Override
   public DurationField e() {
      return this.b.w();
   }

   @Override
   public int g() {
      return 1;
   }

   @Override
   public int h() {
      return 7;
   }
}
