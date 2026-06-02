package org.joda.time.field;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public class OffsetDateTimeField extends DecoratedDateTimeField {
   private final int a;
   private final int b;
   private final int c;

   public OffsetDateTimeField(DateTimeField var1, int var2) {
      DateTimeFieldType var3;
      if (var1 == null) {
         var3 = null;
      } else {
         var3 = var1.a();
      }

      this(var1, var3, var2, Integer.MIN_VALUE, Integer.MAX_VALUE);
   }

   public OffsetDateTimeField(DateTimeField var1, DateTimeFieldType var2, int var3) {
      this(var1, var2, var3, Integer.MIN_VALUE, Integer.MAX_VALUE);
   }

   public OffsetDateTimeField(DateTimeField var1, DateTimeFieldType var2, int var3, int var4, int var5) {
      super(var1, var2);
      if (var3 == 0) {
         throw new IllegalArgumentException("The offset cannot be zero");
      }

      this.a = var3;
      if (var4 < var1.g() + var3) {
         this.b = var1.g() + var3;
      } else {
         this.b = var4;
      }

      if (var5 > var1.h() + var3) {
         this.c = var1.h() + var3;
      } else {
         this.c = var5;
      }
   }

   @Override
   public int a(long var1) {
      return super.a(var1) + this.a;
   }

   @Override
   public long a(long var1, int var3) {
      var1 = super.a(var1, var3);
      FieldUtils.a(this, this.a(var1), this.b, this.c);
      return var1;
   }

   @Override
   public long a(long var1, long var3) {
      var1 = super.a(var1, (long)var3);
      FieldUtils.a(this, this.a(var1), this.b, this.c);
      return var1;
   }

   @Override
   public long b(long var1, int var3) {
      FieldUtils.a(this, var3, this.b, this.c);
      return super.b(var1, var3 - this.a);
   }

   @Override
   public boolean b(long var1) {
      return this.i().b(var1);
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
      return this.b;
   }

   @Override
   public long g(long var1) {
      return this.i().g(var1);
   }

   @Override
   public int h() {
      return this.c;
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
