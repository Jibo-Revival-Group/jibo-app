package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.FieldUtils;
import org.joda.time.field.ImpreciseDateTimeField;

class BasicMonthOfYearDateTimeField extends ImpreciseDateTimeField {
   private final BasicChronology a;
   private final int c;
   private final int d;

   BasicMonthOfYearDateTimeField(BasicChronology var1, int var2) {
      super(DateTimeFieldType.r(), var1.V());
      this.a = var1;
      this.c = this.a.S();
      this.d = var2;
   }

   @Override
   public int a(long var1) {
      return this.a.b(var1);
   }

   @Override
   public long a(long var1, int var3) {
      if (var3 != 0) {
         long var9 = this.a.h(var1);
         int var5 = this.a.a(var1);
         int var8 = this.a.a(var1, var5);
         int var6 = var8 - 1 + var3;
         int var4;
         if (var8 > 0 && var6 < 0) {
            if (Math.signum(this.c + var3) == Math.signum(var3)) {
               var6 = var5 - 1;
               var4 = this.c + var3;
               var3 = var6;
            } else {
               var6 = var5 + 1;
               var4 = var3 - this.c;
               var3 = var6;
            }

            var6 = var4 + (var8 - 1);
            var4 = var3;
            var3 = var6;
         } else {
            var4 = var5;
            var3 = var6;
         }

         if (var3 >= 0) {
            var6 = var4 + var3 / this.c;
            var4 = var3 % this.c + 1;
            var3 = var6;
         } else {
            var6 = var4 + var3 / this.c - 1;
            var4 = Math.abs(var3) % this.c;
            var3 = var4;
            if (var4 == 0) {
               var3 = this.c;
            }

            int var7 = this.c - var3 + 1;
            var4 = var7;
            var3 = var6;
            if (var7 == 1) {
               var3 = var6 + 1;
               var4 = var7;
            }
         }

         var5 = this.a.a(var1, var5, var8);
         var6 = this.a.b(var3, var4);
         if (var5 > var6) {
            var5 = var6;
         }

         var1 = this.a.a(var3, var4, var5) + var9;
      }

      return var1;
   }

   @Override
   public long a(long var1, long var3) {
      int var5 = (int)var3;
      if (var5 == var3) {
         var1 = this.a(var1, var5);
      } else {
         long var17 = this.a.h(var1);
         int var10 = this.a.a(var1);
         int var9 = this.a.a(var1, var10);
         long var15 = var9 - 1 + var3;
         long var11;
         long var13;
         if (var15 >= 0L) {
            var11 = var10 + var15 / this.c;
            var13 = var15 % this.c + 1L;
         } else {
            var13 = var10 + var15 / this.c - 1L;
            int var6 = (int)(Math.abs(var15) % this.c);
            var5 = var6;
            if (var6 == 0) {
               var5 = this.c;
            }

            var11 = this.c - var5 + 1;
            if (var11 == 1L) {
               var15 = 1L + var13;
               var13 = var11;
               var11 = var15;
            } else {
               var15 = var11;
               var11 = var13;
               var13 = var15;
            }
         }

         if (var11 < this.a.Q() || var11 > this.a.R()) {
            throw new IllegalArgumentException("Magnitude of add amount is too large: " + var3);
         }

         int var7 = (int)var11;
         int var8 = (int)var13;
         var5 = this.a.a(var1, var10, var9);
         int var22 = this.a.b(var7, var8);
         if (var5 > var22) {
            var5 = var22;
         }

         var1 = this.a.a(var7, var8, var5) + var17;
      }

      return var1;
   }

   @Override
   public long b(long var1, int var3) {
      FieldUtils.a(this, var3, 1, this.c);
      int var6 = this.a.a(var1);
      int var5 = this.a.b(var1, var6);
      int var4 = this.a.b(var6, var3);
      if (var5 <= var4) {
         var4 = var5;
      }

      return this.a.a(var6, var3, var4) + this.a.h(var1);
   }

   @Override
   public boolean b(long var1) {
      boolean var5 = false;
      int var3 = this.a.a(var1);
      boolean var4 = var5;
      if (this.a.e(var3)) {
         var4 = var5;
         if (this.a.a(var1, var3) == this.d) {
            var4 = true;
         }
      }

      return var4;
   }

   @Override
   public long d(long var1) {
      int var3 = this.a.a(var1);
      int var4 = this.a.a(var1, var3);
      return this.a.a(var3, var4);
   }

   @Override
   public DurationField e() {
      return this.a.D();
   }

   @Override
   public DurationField f() {
      return this.a.s();
   }

   @Override
   public int g() {
      return 1;
   }

   @Override
   public int h() {
      return this.c;
   }

   @Override
   public long i(long var1) {
      return var1 - this.d(var1);
   }
}
