package org.joda.time.chrono;

import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.field.DividedDateTimeField;
import org.joda.time.field.FieldUtils;
import org.joda.time.field.MillisDurationField;
import org.joda.time.field.OffsetDateTimeField;
import org.joda.time.field.PreciseDateTimeField;
import org.joda.time.field.PreciseDurationField;
import org.joda.time.field.RemainderDateTimeField;
import org.joda.time.field.ZeroIsMaxDateTimeField;

abstract class BasicChronology extends AssembledChronology {
   private static final DurationField a = MillisDurationField.a;
   private static final DurationField b = new PreciseDurationField(DurationFieldType.b(), 1000L);
   private static final DurationField c = new PreciseDurationField(DurationFieldType.c(), 60000L);
   private static final DurationField d = new PreciseDurationField(DurationFieldType.d(), 3600000L);
   private static final DurationField e = new PreciseDurationField(DurationFieldType.e(), 43200000L);
   private static final DurationField f = new PreciseDurationField(DurationFieldType.f(), 86400000L);
   private static final DurationField g = new PreciseDurationField(DurationFieldType.g(), 604800000L);
   private static final DateTimeField h = new PreciseDateTimeField(DateTimeFieldType.a(), a, b);
   private static final DateTimeField i = new PreciseDateTimeField(DateTimeFieldType.b(), a, f);
   private static final DateTimeField j = new PreciseDateTimeField(DateTimeFieldType.c(), b, c);
   private static final DateTimeField k = new PreciseDateTimeField(DateTimeFieldType.d(), b, f);
   private static final DateTimeField l = new PreciseDateTimeField(DateTimeFieldType.e(), c, d);
   private static final DateTimeField m = new PreciseDateTimeField(DateTimeFieldType.f(), c, f);
   private static final DateTimeField n = new PreciseDateTimeField(DateTimeFieldType.g(), d, f);
   private static final DateTimeField o = new PreciseDateTimeField(DateTimeFieldType.i(), d, e);
   private static final DateTimeField p = new ZeroIsMaxDateTimeField(n, DateTimeFieldType.h());
   private static final DateTimeField q = new ZeroIsMaxDateTimeField(o, DateTimeFieldType.j());
   private static final DateTimeField r = new BasicChronology.HalfdayField();
   private final transient BasicChronology.YearInfo[] s = new BasicChronology.YearInfo[1024];
   private final int t;

   BasicChronology(Chronology var1, Object var2, int var3) {
      super(var1, var2);
      if (var3 >= 1 && var3 <= 7) {
         this.t = var3;
      } else {
         throw new IllegalArgumentException("Invalid min days in first week: " + var3);
      }
   }

   private long b(int var1, int var2, int var3, int var4) {
      long var5 = Long.MIN_VALUE;
      long var7 = this.b(var1, var2, var3);
      if (var7 == Long.MIN_VALUE) {
         var7 = this.b(var1, var2, var3 + 1);
         var4 -= 86400000;
      }

      long var9 = var4 + var7;
      if (var9 < 0L && var7 > 0L) {
         var5 = Long.MAX_VALUE;
      } else if (var9 <= 0L || var7 >= 0L) {
         var5 = var9;
      }

      return var5;
   }

   private BasicChronology.YearInfo h(int var1) {
      BasicChronology.YearInfo var3 = this.s[var1 & 1023];
      if (var3 != null) {
         BasicChronology.YearInfo var2 = var3;
         if (var3.a == var1) {
            return var2;
         }
      }

      BasicChronology.YearInfo var4 = new BasicChronology.YearInfo(var1, this.f(var1));
      this.s[var1 & 1023] = var4;
      return var4;
   }

   public int N() {
      return this.t;
   }

   int O() {
      return 366;
   }

   int P() {
      return 31;
   }

   abstract int Q();

   abstract int R();

   int S() {
      return 12;
   }

   abstract long T();

   abstract long U();

   abstract long V();

   abstract long W();

   int a(int var1) {
      short var2;
      if (this.e(var1)) {
         var2 = 366;
      } else {
         var2 = 365;
      }

      return var2;
   }

   int a(long var1) {
      long var7 = 31536000000L;
      long var11 = this.U();
      long var9 = (var1 >> 1) + this.W();
      long var5 = var9;
      if (var9 < 0L) {
         var5 = var9 - var11 + 1L;
      }

      int var4 = (int)(var5 / var11);
      var9 = this.d(var4);
      var5 = var1 - var9;
      int var3;
      if (var5 < 0L) {
         var3 = var4 - 1;
      } else {
         var3 = var4;
         if (var5 >= 31536000000L) {
            var5 = var7;
            if (this.e(var4)) {
               var5 = 31622400000L;
            }

            var3 = var4;
            if (var5 + var9 <= var1) {
               var3 = var4 + 1;
            }
         }
      }

      return var3;
   }

   abstract int a(long var1, int var3);

   int a(long var1, int var3, int var4) {
      return (int)((var1 - (this.d(var3) + this.c(var3, var4))) / 86400000L) + 1;
   }

   long a(int var1, int var2) {
      return this.d(var1) + this.c(var1, var2);
   }

   long a(int var1, int var2, int var3) {
      return this.d(var1) + this.c(var1, var2) + (var3 - 1) * 86400000L;
   }

   @Override
   public long a(int var1, int var2, int var3, int var4) throws IllegalArgumentException {
      Chronology var7 = this.L();
      long var5;
      if (var7 != null) {
         var5 = var7.a(var1, var2, var3, var4);
      } else {
         FieldUtils.a(DateTimeFieldType.b(), var4, 0, 86399999);
         var5 = this.b(var1, var2, var3, var4);
      }

      return var5;
   }

   @Override
   public long a(int var1, int var2, int var3, int var4, int var5, int var6, int var7) throws IllegalArgumentException {
      Chronology var10 = this.L();
      long var8;
      if (var10 != null) {
         var8 = var10.a(var1, var2, var3, var4, var5, var6, var7);
      } else {
         FieldUtils.a(DateTimeFieldType.g(), var4, 0, 23);
         FieldUtils.a(DateTimeFieldType.e(), var5, 0, 59);
         FieldUtils.a(DateTimeFieldType.c(), var6, 0, 59);
         FieldUtils.a(DateTimeFieldType.a(), var7, 0, 999);
         var8 = this.b(var1, var2, var3, (int)(3600000 * var4 + 60000 * var5 + var6 * 1000 + var7));
      }

      return var8;
   }

   @Override
   public DateTimeZone a() {
      Chronology var1 = this.L();
      DateTimeZone var2;
      if (var1 != null) {
         var2 = var1.a();
      } else {
         var2 = DateTimeZone.a;
      }

      return var2;
   }

   @Override
   protected void a(AssembledChronology.Fields var1) {
      var1.a = a;
      var1.b = b;
      var1.c = c;
      var1.d = d;
      var1.e = e;
      var1.f = f;
      var1.g = g;
      var1.m = h;
      var1.n = i;
      var1.o = j;
      var1.p = k;
      var1.q = l;
      var1.r = m;
      var1.s = n;
      var1.u = o;
      var1.t = p;
      var1.v = q;
      var1.w = r;
      var1.E = new BasicYearDateTimeField(this);
      var1.F = new GJYearOfEraDateTimeField(var1.E, this);
      var1.H = new DividedDateTimeField(new OffsetDateTimeField(var1.F, 99), DateTimeFieldType.v(), 100);
      var1.k = var1.H.d();
      var1.G = new OffsetDateTimeField(new RemainderDateTimeField((DividedDateTimeField)var1.H), DateTimeFieldType.u(), 1);
      var1.I = new GJEraDateTimeField(this);
      var1.x = new GJDayOfWeekDateTimeField(this, var1.f);
      var1.y = new BasicDayOfMonthDateTimeField(this, var1.f);
      var1.z = new BasicDayOfYearDateTimeField(this, var1.f);
      var1.D = new GJMonthOfYearDateTimeField(this);
      var1.B = new BasicWeekyearDateTimeField(this);
      var1.A = new BasicWeekOfWeekyearDateTimeField(this, var1.g);
      var1.C = new OffsetDateTimeField(new RemainderDateTimeField(var1.B, var1.k, DateTimeFieldType.q(), 100), DateTimeFieldType.q(), 1);
      var1.j = var1.E.d();
      var1.i = var1.D.d();
      var1.h = var1.B.d();
   }

   int b(int var1) {
      long var2 = this.c(var1);
      return (int)((this.c(var1 + 1) - var2) / 604800000L);
   }

   abstract int b(int var1, int var2);

   int b(long var1) {
      return this.a(var1, this.a(var1));
   }

   int b(long var1, int var3) {
      return this.a(var1, var3, this.a(var1, var3));
   }

   long b(int var1, int var2, int var3) {
      FieldUtils.a(DateTimeFieldType.s(), var1, this.Q() - 1, this.R() + 1);
      FieldUtils.a(DateTimeFieldType.r(), var2, 1, this.g(var1));
      FieldUtils.a(DateTimeFieldType.m(), var3, 1, this.b(var1, var2));
      long var6 = this.a(var1, var2, var3);
      long var4;
      if (var6 < 0L && var1 == this.R() + 1) {
         var4 = Long.MAX_VALUE;
      } else {
         var4 = var6;
         if (var6 > 0L) {
            var4 = var6;
            if (var1 == this.Q() - 1) {
               var4 = Long.MIN_VALUE;
            }
         }
      }

      return var4;
   }

   int c(long var1) {
      int var3 = this.a(var1);
      return this.a(var1, var3, this.a(var1, var3));
   }

   int c(long var1, int var3) {
      return (int)((var1 - this.d(var3)) / 86400000L) + 1;
   }

   long c(int var1) {
      long var2 = this.d(var1);
      var1 = this.g(var2);
      if (var1 > 8 - this.t) {
         var2 += (8 - var1) * 86400000L;
      } else {
         var2 -= (var1 - 1) * 86400000L;
      }

      return var2;
   }

   abstract long c(int var1, int var2);

   int d(long var1) {
      return this.c(var1, this.a(var1));
   }

   int d(long var1, int var3) {
      long var4 = this.c(var3);
      if (var1 < var4) {
         var3 = this.b(var3 - 1);
      } else if (var1 >= this.c(var3 + 1)) {
         var3 = 1;
      } else {
         var3 = (int)((var1 - var4) / 604800000L) + 1;
      }

      return var3;
   }

   long d(int var1) {
      return this.h(var1).b;
   }

   int e(long var1) {
      int var3 = this.a(var1);
      int var4 = this.d(var1, var3);
      if (var4 == 1) {
         var3 = this.a(604800000L + var1);
      } else if (var4 > 51) {
         var3 = this.a(var1 - 1209600000L);
      }

      return var3;
   }

   int e(long var1, int var3) {
      return this.i(var1);
   }

   abstract boolean e(int var1);

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 != null && this.getClass() == var1.getClass()) {
            var1 = var1;
            if (this.N() != var1.N() || !this.a().equals(var1.a())) {
               var2 = false;
            }
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   int f(long var1) {
      return this.d(var1, this.a(var1));
   }

   abstract long f(int var1);

   abstract long f(long var1, int var3);

   int g(int var1) {
      return this.S();
   }

   int g(long var1) {
      if (var1 >= 0L) {
         var1 /= 86400000L;
      } else {
         long var4 = (var1 - 86399999L) / 86400000L;
         var1 = var4;
         if (var4 < -3L) {
            return (int)((var4 + 4L) % 7L) + 7;
         }
      }

      return (int)((var1 + 3L) % 7L) + 1;
   }

   int h(long var1) {
      int var3;
      if (var1 >= 0L) {
         var3 = (int)(var1 % 86400000L);
      } else {
         var3 = 86399999 + (int)((1L + var1) % 86400000L);
      }

      return var3;
   }

   @Override
   public int hashCode() {
      return this.getClass().getName().hashCode() * 11 + this.a().hashCode() + this.N();
   }

   int i(long var1) {
      int var3 = this.a(var1);
      return this.b(var3, this.a(var1, var3));
   }

   boolean j(long var1) {
      return false;
   }

   @Override
   public String toString() {
      StringBuilder var4 = new StringBuilder(60);
      String var3 = this.getClass().getName();
      int var1 = var3.lastIndexOf(46);
      String var2 = var3;
      if (var1 >= 0) {
         var2 = var3.substring(var1 + 1);
      }

      var4.append(var2);
      var4.append('[');
      DateTimeZone var5 = this.a();
      if (var5 != null) {
         var4.append(var5.e());
      }

      if (this.N() != 4) {
         var4.append(",mdfw=");
         var4.append(this.N());
      }

      var4.append(']');
      return var4.toString();
   }

   private static class HalfdayField extends PreciseDateTimeField {
      HalfdayField() {
         super(DateTimeFieldType.k(), BasicChronology.e, BasicChronology.f);
      }

      @Override
      public int a(Locale var1) {
         return GJLocaleSymbols.a(var1).d();
      }

      @Override
      public long a(long var1, String var3, Locale var4) {
         return this.b(var1, GJLocaleSymbols.a(var4).d(var3));
      }

      @Override
      public String a(int var1, Locale var2) {
         return GJLocaleSymbols.a(var2).f(var1);
      }
   }

   private static class YearInfo {
      public final int a;
      public final long b;

      YearInfo(int var1, long var2) {
         this.a = var1;
         this.b = var2;
      }
   }
}
