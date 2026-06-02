package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.FieldUtils;
import org.joda.time.field.ImpreciseDateTimeField;

final class BasicWeekyearDateTimeField extends ImpreciseDateTimeField {
   private final BasicChronology a;

   BasicWeekyearDateTimeField(BasicChronology var1) {
      super(DateTimeFieldType.p(), var1.T());
      this.a = var1;
   }

   @Override
   public int a(long var1) {
      return this.a.e(var1);
   }

   @Override
   public long a(long var1, int var3) {
      if (var3 != 0) {
         var1 = this.b(var1, this.a(var1) + var3);
      }

      return var1;
   }

   @Override
   public long a(long var1, long var3) {
      return this.a(var1, FieldUtils.a(var3));
   }

   @Override
   public long b(long var1, int var3) {
      FieldUtils.a(this, Math.abs(var3), this.a.Q(), this.a.R());
      int var4 = this.a(var1);
      if (var4 != var3) {
         int var6 = this.a.g(var1);
         var4 = this.a.b(var4);
         int var5 = this.a.b(var3);
         if (var5 < var4) {
            var4 = var5;
         }

         var5 = this.a.f(var1);
         if (var5 <= var4) {
            var4 = var5;
         }

         long var7 = this.a.f(var1, var3);
         var5 = this.a(var7);
         if (var5 < var3) {
            var1 = var7 + 604800000L;
         } else {
            var1 = var7;
            if (var5 > var3) {
               var1 = var7 - 604800000L;
            }
         }

         var7 = var4 - this.a.f(var1);
         var1 = this.a.t().b(var7 * 604800000L + var1, var6);
      }

      return var1;
   }

   @Override
   public boolean b(long var1) {
      boolean var3;
      if (this.a.b(this.a.e(var1)) > 52) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   @Override
   public long d(long var1) {
      long var4 = this.a.x().d(var1);
      int var3 = this.a.f(var4);
      var1 = var4;
      if (var3 > 1) {
         var1 = var4 - (var3 - 1) * 604800000L;
      }

      return var1;
   }

   @Override
   public DurationField e() {
      return null;
   }

   @Override
   public DurationField f() {
      return this.a.w();
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
