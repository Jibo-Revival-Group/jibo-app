package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.PreciseDurationDateTimeField;

final class BasicWeekOfWeekyearDateTimeField extends PreciseDurationDateTimeField {
   private final BasicChronology b;

   BasicWeekOfWeekyearDateTimeField(BasicChronology var1, DurationField var2) {
      super(DateTimeFieldType.o(), var2);
      this.b = var1;
   }

   @Override
   public int a(long var1) {
      return this.b.f(var1);
   }

   @Override
   public int c(long var1) {
      int var3 = this.b.e(var1);
      return this.b.b(var3);
   }

   @Override
   protected int d(long var1, int var3) {
      int var4 = 52;
      if (var3 > 52) {
         var4 = this.c(var1);
      }

      return var4;
   }

   @Override
   public long d(long var1) {
      return super.d(var1 + 259200000L) - 259200000L;
   }

   @Override
   public long e(long var1) {
      return super.e(var1 + 259200000L) - 259200000L;
   }

   @Override
   public DurationField e() {
      return this.b.y();
   }

   @Override
   public int g() {
      return 1;
   }

   @Override
   public int h() {
      return 53;
   }

   @Override
   public long i(long var1) {
      return super.i(259200000L + var1);
   }
}
