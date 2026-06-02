package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.PreciseDurationDateTimeField;

final class BasicDayOfMonthDateTimeField extends PreciseDurationDateTimeField {
   private final BasicChronology b;

   BasicDayOfMonthDateTimeField(BasicChronology var1, DurationField var2) {
      super(DateTimeFieldType.m(), var2);
      this.b = var1;
   }

   @Override
   public int a(long var1) {
      return this.b.c(var1);
   }

   @Override
   public boolean b(long var1) {
      return this.b.j(var1);
   }

   @Override
   public int c(long var1) {
      return this.b.i(var1);
   }

   @Override
   protected int d(long var1, int var3) {
      return this.b.e(var1, var3);
   }

   @Override
   public DurationField e() {
      return this.b.B();
   }

   @Override
   public int g() {
      return 1;
   }

   @Override
   public int h() {
      return this.b.P();
   }
}
