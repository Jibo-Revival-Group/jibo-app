package org.joda.time.field;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public class PreciseDateTimeField extends PreciseDurationDateTimeField {
   private final int b;
   private final DurationField c;

   public PreciseDateTimeField(DateTimeFieldType var1, DurationField var2, DurationField var3) {
      super(var1, var2);
      if (!var3.c()) {
         throw new IllegalArgumentException("Range duration field must be precise");
      }

      this.b = (int)(var3.d() / this.i());
      if (this.b < 2) {
         throw new IllegalArgumentException("The effective range must be at least 2");
      }

      this.c = var3;
   }

   @Override
   public int a(long var1) {
      int var3;
      if (var1 >= 0L) {
         var3 = (int)(var1 / this.i() % this.b);
      } else {
         var3 = this.b - 1 + (int)((1L + var1) / this.i() % this.b);
      }

      return var3;
   }

   @Override
   public long b(long var1, int var3) {
      FieldUtils.a(this, var3, this.g(), this.h());
      return (var3 - this.a(var1)) * this.a + var1;
   }

   @Override
   public DurationField e() {
      return this.c;
   }

   @Override
   public int h() {
      return this.b - 1;
   }
}
