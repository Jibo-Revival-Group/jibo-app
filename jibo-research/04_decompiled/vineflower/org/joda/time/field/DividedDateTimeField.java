package org.joda.time.field;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public class DividedDateTimeField extends DecoratedDateTimeField {
   final int a;
   final DurationField b;
   final DurationField c;
   private final int d;
   private final int e;

   public DividedDateTimeField(DateTimeField var1, DateTimeFieldType var2, int var3) {
      this(var1, var1.e(), var2, var3);
   }

   public DividedDateTimeField(DateTimeField var1, DurationField var2, DateTimeFieldType var3, int var4) {
      super(var1, var3);
      if (var4 < 2) {
         throw new IllegalArgumentException("The divisor must be at least 2");
      }

      DurationField var7 = var1.d();
      if (var7 == null) {
         this.b = null;
      } else {
         this.b = new ScaledDurationField(var7, var3.y(), var4);
      }

      this.c = var2;
      this.a = var4;
      int var5 = var1.g();
      if (var5 >= 0) {
         var5 /= var4;
      } else {
         var5 = (var5 + 1) / var4 - 1;
      }

      int var6 = var1.h();
      if (var6 >= 0) {
         var4 = var6 / var4;
      } else {
         var4 = (var6 + 1) / var4 - 1;
      }

      this.d = var5;
      this.e = var4;
   }

   private int a(int var1) {
      if (var1 >= 0) {
         var1 %= this.a;
      } else {
         var1 = this.a - 1 + (var1 + 1) % this.a;
      }

      return var1;
   }

   @Override
   public int a(long var1) {
      int var3 = this.i().a(var1);
      if (var3 >= 0) {
         var3 /= this.a;
      } else {
         var3 = (var3 + 1) / this.a - 1;
      }

      return var3;
   }

   @Override
   public long a(long var1, int var3) {
      return this.i().a(var1, this.a * var3);
   }

   @Override
   public long a(long var1, long var3) {
      return this.i().a(var1, this.a * var3);
   }

   @Override
   public long b(long var1, int var3) {
      FieldUtils.a(this, var3, this.d, this.e);
      int var4 = this.a(this.i().a(var1));
      return this.i().b(var1, var4 + this.a * var3);
   }

   @Override
   public long d(long var1) {
      DateTimeField var3 = this.i();
      return var3.d(var3.b(var1, this.a(var1) * this.a));
   }

   @Override
   public DurationField d() {
      return this.b;
   }

   @Override
   public DurationField e() {
      DurationField var1;
      if (this.c != null) {
         var1 = this.c;
      } else {
         var1 = super.e();
      }

      return var1;
   }

   @Override
   public int g() {
      return this.d;
   }

   @Override
   public int h() {
      return this.e;
   }

   @Override
   public long i(long var1) {
      return this.b(var1, this.a(this.i().i(var1)));
   }
}
