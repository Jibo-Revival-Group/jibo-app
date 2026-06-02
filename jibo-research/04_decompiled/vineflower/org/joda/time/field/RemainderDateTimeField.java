package org.joda.time.field;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public class RemainderDateTimeField extends DecoratedDateTimeField {
   final int a;
   final DurationField b;
   final DurationField c;

   public RemainderDateTimeField(DateTimeField var1, DurationField var2, DateTimeFieldType var3, int var4) {
      super(var1, var3);
      if (var4 < 2) {
         throw new IllegalArgumentException("The divisor must be at least 2");
      }

      this.c = var2;
      this.b = var1.d();
      this.a = var4;
   }

   public RemainderDateTimeField(DividedDateTimeField var1) {
      this(var1, var1.a());
   }

   public RemainderDateTimeField(DividedDateTimeField var1, DateTimeFieldType var2) {
      this(var1, var1.i().d(), var2);
   }

   public RemainderDateTimeField(DividedDateTimeField var1, DurationField var2, DateTimeFieldType var3) {
      super(var1.i(), var3);
      this.a = var1.a;
      this.b = var2;
      this.c = var1.b;
   }

   private int a(int var1) {
      if (var1 >= 0) {
         var1 /= this.a;
      } else {
         var1 = (var1 + 1) / this.a - 1;
      }

      return var1;
   }

   @Override
   public int a(long var1) {
      int var3 = this.i().a(var1);
      if (var3 >= 0) {
         var3 %= this.a;
      } else {
         int var4 = this.a;
         var3 = (var3 + 1) % this.a + (var4 - 1);
      }

      return var3;
   }

   @Override
   public long b(long var1, int var3) {
      FieldUtils.a(this, var3, 0, this.a - 1);
      int var4 = this.a(this.i().a(var1));
      return this.i().b(var1, var4 * this.a + var3);
   }

   @Override
   public long d(long var1) {
      return this.i().d(var1);
   }

   @Override
   public DurationField d() {
      return this.b;
   }

   @Override
   public long e(long var1) {
      return this.i().e(var1);
   }

   @Override
   public DurationField e() {
      return this.c;
   }

   @Override
   public long f(long var1) {
      return this.i().f(var1);
   }

   @Override
   public int g() {
      return 0;
   }

   @Override
   public long g(long var1) {
      return this.i().g(var1);
   }

   @Override
   public int h() {
      return this.a - 1;
   }

   @Override
   public long h(long var1) {
      return this.i().h(var1);
   }

   @Override
   public long i(long var1) {
      return this.i().i(var1);
   }
}
