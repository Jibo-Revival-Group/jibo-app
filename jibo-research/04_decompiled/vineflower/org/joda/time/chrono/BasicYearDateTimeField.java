package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.FieldUtils;
import org.joda.time.field.ImpreciseDateTimeField;

class BasicYearDateTimeField extends ImpreciseDateTimeField {
   protected final BasicChronology a;

   BasicYearDateTimeField(BasicChronology var1) {
      super(DateTimeFieldType.s(), var1.T());
      this.a = var1;
   }

   @Override
   public int a(long var1) {
      return this.a.a(var1);
   }

   @Override
   public long a(long var1, int var3) {
      if (var3 != 0) {
         var1 = this.b(var1, FieldUtils.a(this.a(var1), var3));
      }

      return var1;
   }

   @Override
   public long a(long var1, long var3) {
      return this.a(var1, FieldUtils.a(var3));
   }

   @Override
   public long b(long var1, int var3) {
      FieldUtils.a(this, var3, this.a.Q(), this.a.R());
      return this.a.f(var1, var3);
   }

   @Override
   public boolean b(long var1) {
      return this.a.e(this.a(var1));
   }

   @Override
   public long c(long var1, int var3) {
      FieldUtils.a(this, var3, this.a.Q() - 1, this.a.R() + 1);
      return this.a.f(var1, var3);
   }

   @Override
   public long d(long var1) {
      return this.a.d(this.a(var1));
   }

   @Override
   public long e(long var1) {
      int var3 = this.a(var1);
      long var4 = var1;
      if (var1 != this.a.d(var3)) {
         var4 = this.a.d(var3 + 1);
      }

      return var4;
   }

   @Override
   public DurationField e() {
      return null;
   }

   @Override
   public DurationField f() {
      return this.a.s();
   }

   @Override
   public int g() {
      return this.a.Q();
   }

   @Override
   public int h() {
      return this.a.R();
   }

   @Override
   public long i(long var1) {
      return var1 - this.d(var1);
   }
}
