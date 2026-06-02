package org.joda.time.field;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public abstract class PreciseDurationDateTimeField extends BaseDateTimeField {
   final long a;
   private final DurationField b;

   public PreciseDurationDateTimeField(DateTimeFieldType var1, DurationField var2) {
      super(var1);
      if (!var2.c()) {
         throw new IllegalArgumentException("Unit duration field must be precise");
      }

      this.a = var2.d();
      if (this.a < 1L) {
         throw new IllegalArgumentException("The unit milliseconds must be at least 1");
      }

      this.b = var2;
   }

   @Override
   public long b(long var1, int var3) {
      FieldUtils.a(this, var3, this.g(), this.d(var1, var3));
      return (var3 - this.a(var1)) * this.a + var1;
   }

   protected int d(long var1, int var3) {
      return this.c(var1);
   }

   @Override
   public long d(long var1) {
      if (var1 >= 0L) {
         var1 -= var1 % this.a;
      } else {
         var1++;
         var1 = var1 - var1 % this.a - this.a;
      }

      return var1;
   }

   @Override
   public DurationField d() {
      return this.b;
   }

   @Override
   public long e(long var1) {
      if (var1 > 0L) {
         var1--;
         var1 = var1 - var1 % this.a + this.a;
      } else {
         var1 -= var1 % this.a;
      }

      return var1;
   }

   @Override
   public int g() {
      return 0;
   }

   public final long i() {
      return this.a;
   }

   @Override
   public long i(long var1) {
      if (var1 >= 0L) {
         var1 %= this.a;
      } else {
         var1 = (var1 + 1L) % this.a + this.a - 1L;
      }

      return var1;
   }
}
