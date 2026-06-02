package org.joda.time.chrono;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.DecoratedDateTimeField;
import org.joda.time.field.FieldUtils;

class ISOYearOfEraDateTimeField extends DecoratedDateTimeField {
   static final DateTimeField a = new ISOYearOfEraDateTimeField();

   private ISOYearOfEraDateTimeField() {
      super(GregorianChronology.Z().E(), DateTimeFieldType.t());
   }

   @Override
   public int a(long var1) {
      int var4 = this.i().a(var1);
      int var3 = var4;
      if (var4 < 0) {
         var3 = -var4;
      }

      return var3;
   }

   @Override
   public long a(long var1, int var3) {
      return this.i().a(var1, var3);
   }

   @Override
   public long a(long var1, long var3) {
      return this.i().a(var1, var3);
   }

   @Override
   public long b(long var1, int var3) {
      FieldUtils.a(this, var3, 0, this.h());
      int var4 = var3;
      if (this.i().a(var1) < 0) {
         var4 = -var3;
      }

      return super.b(var1, var4);
   }

   @Override
   public long d(long var1) {
      return this.i().d(var1);
   }

   @Override
   public long e(long var1) {
      return this.i().e(var1);
   }

   @Override
   public DurationField e() {
      return GregorianChronology.Z().J();
   }

   @Override
   public int g() {
      return 0;
   }

   @Override
   public int h() {
      return this.i().h();
   }

   @Override
   public long i(long var1) {
      return this.i().i(var1);
   }
}
