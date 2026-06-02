package org.joda.time.field;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public final class ZeroIsMaxDateTimeField extends DecoratedDateTimeField {
   public ZeroIsMaxDateTimeField(DateTimeField var1, DateTimeFieldType var2) {
      super(var1, var2);
      if (var1.g() != 0) {
         throw new IllegalArgumentException("Wrapped field's minumum value must be zero");
      }
   }

   @Override
   public int a(long var1) {
      int var4 = this.i().a(var1);
      int var3 = var4;
      if (var4 == 0) {
         var3 = this.h();
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
      int var5 = this.h();
      FieldUtils.a(this, var3, 1, var5);
      int var4 = var3;
      if (var3 == var5) {
         var4 = 0;
      }

      return this.i().b(var1, var4);
   }

   @Override
   public boolean b(long var1) {
      return this.i().b(var1);
   }

   @Override
   public int c(long var1) {
      return this.i().c(var1) + 1;
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
   public long f(long var1) {
      return this.i().f(var1);
   }

   @Override
   public DurationField f() {
      return this.i().f();
   }

   @Override
   public int g() {
      return 1;
   }

   @Override
   public long g(long var1) {
      return this.i().g(var1);
   }

   @Override
   public int h() {
      return this.i().h() + 1;
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
