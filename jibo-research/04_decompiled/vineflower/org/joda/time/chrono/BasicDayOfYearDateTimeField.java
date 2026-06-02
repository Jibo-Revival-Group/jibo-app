package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.PreciseDurationDateTimeField;

final class BasicDayOfYearDateTimeField extends PreciseDurationDateTimeField {
   private final BasicChronology b;

   BasicDayOfYearDateTimeField(BasicChronology var1, DurationField var2) {
      super(DateTimeFieldType.n(), var2);
      this.b = var1;
   }

   @Override
   public int a(long var1) {
      return this.b.d(var1);
   }

   @Override
   public boolean b(long var1) {
      return this.b.j(var1);
   }

   @Override
   public int c(long var1) {
      int var3 = this.b.a(var1);
      return this.b.a(var3);
   }

   @Override
   protected int d(long var1, int var3) {
      int var4 = this.b.O() - 1;
      if (var3 > var4 || var3 < 1) {
         var4 = this.c(var1);
      }

      return var4;
   }

   @Override
   public DurationField e() {
      return this.b.D();
   }

   @Override
   public int g() {
      return 1;
   }

   @Override
   public int h() {
      return this.b.O();
   }
}
