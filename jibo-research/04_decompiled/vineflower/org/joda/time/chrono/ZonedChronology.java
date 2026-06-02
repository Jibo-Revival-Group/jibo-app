package org.joda.time.chrono;

import java.util.HashMap;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.IllegalInstantException;
import org.joda.time.field.BaseDateTimeField;
import org.joda.time.field.BaseDurationField;

public final class ZonedChronology extends AssembledChronology {
   private ZonedChronology(Chronology var1, DateTimeZone var2) {
      super(var1, var2);
   }

   private long a(long var1) {
      long var4 = Long.MAX_VALUE;
      if (var1 != Long.MAX_VALUE) {
         if (var1 == Long.MIN_VALUE) {
            var4 = Long.MIN_VALUE;
         } else {
            DateTimeZone var8 = this.a();
            int var3 = var8.e(var1);
            long var6 = var1 - var3;
            if (var1 <= 604800000L || var6 >= 0L) {
               if (var1 < -604800000L && var6 > 0L) {
                  var4 = Long.MIN_VALUE;
               } else {
                  if (var3 != var8.b(var6)) {
                     throw new IllegalInstantException(var1, var8.e());
                  }

                  var4 = var6;
               }
            }
         }
      }

      return var4;
   }

   private DateTimeField a(DateTimeField var1, HashMap<Object, Object> var2) {
      if (var1 != null && var1.c()) {
         if (var2.containsKey(var1)) {
            var1 = (DateTimeField)var2.get(var1);
         } else {
            ZonedChronology.ZonedDateTimeField var3 = new ZonedChronology.ZonedDateTimeField(
               var1, this.a(), this.a(var1.d(), var2), this.a(var1.e(), var2), this.a(var1.f(), var2)
            );
            var2.put(var1, var3);
            var1 = var3;
         }
      }

      return var1;
   }

   private DurationField a(DurationField var1, HashMap<Object, Object> var2) {
      if (var1 != null && var1.b()) {
         if (var2.containsKey(var1)) {
            var1 = (DurationField)var2.get(var1);
         } else {
            ZonedChronology.ZonedDurationField var3 = new ZonedChronology.ZonedDurationField(var1, this.a());
            var2.put(var1, var3);
            var1 = var3;
         }
      }

      return var1;
   }

   public static ZonedChronology a(Chronology var0, DateTimeZone var1) {
      if (var0 == null) {
         throw new IllegalArgumentException("Must supply a chronology");
      } else {
         var0 = var0.b();
         if (var0 == null) {
            throw new IllegalArgumentException("UTC chronology must not be null");
         } else if (var1 == null) {
            throw new IllegalArgumentException("DateTimeZone must not be null");
         } else {
            return new ZonedChronology(var0, var1);
         }
      }
   }

   static boolean a(DurationField var0) {
      boolean var1;
      if (var0 != null && var0.d() < 43200000L) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public long a(int var1, int var2, int var3, int var4) throws IllegalArgumentException {
      return this.a(this.L().a(var1, var2, var3, var4));
   }

   @Override
   public long a(int var1, int var2, int var3, int var4, int var5, int var6, int var7) throws IllegalArgumentException {
      return this.a(this.L().a(var1, var2, var3, var4, var5, var6, var7));
   }

   @Override
   public long a(long var1, int var3, int var4, int var5, int var6) throws IllegalArgumentException {
      return this.a(this.L().a(this.a().b(var1) + var1, var3, var4, var5, var6));
   }

   @Override
   public Chronology a(DateTimeZone var1) {
      DateTimeZone var2 = var1;
      if (var1 == null) {
         var2 = DateTimeZone.a();
      }

      Chronology var3;
      if (var2 == this.M()) {
         var3 = this;
      } else if (var2 == DateTimeZone.a) {
         var3 = this.L();
      } else {
         var3 = new ZonedChronology(this.L(), var2);
      }

      return var3;
   }

   @Override
   public DateTimeZone a() {
      return (DateTimeZone)this.M();
   }

   @Override
   protected void a(AssembledChronology.Fields var1) {
      HashMap var2 = new HashMap();
      var1.l = this.a(var1.l, var2);
      var1.k = this.a(var1.k, var2);
      var1.j = this.a(var1.j, var2);
      var1.i = this.a(var1.i, var2);
      var1.h = this.a(var1.h, var2);
      var1.g = this.a(var1.g, var2);
      var1.f = this.a(var1.f, var2);
      var1.e = this.a(var1.e, var2);
      var1.d = this.a(var1.d, var2);
      var1.c = this.a(var1.c, var2);
      var1.b = this.a(var1.b, var2);
      var1.a = this.a(var1.a, var2);
      var1.E = this.a(var1.E, var2);
      var1.F = this.a(var1.F, var2);
      var1.G = this.a(var1.G, var2);
      var1.H = this.a(var1.H, var2);
      var1.I = this.a(var1.I, var2);
      var1.x = this.a(var1.x, var2);
      var1.y = this.a(var1.y, var2);
      var1.z = this.a(var1.z, var2);
      var1.D = this.a(var1.D, var2);
      var1.A = this.a(var1.A, var2);
      var1.B = this.a(var1.B, var2);
      var1.C = this.a(var1.C, var2);
      var1.m = this.a(var1.m, var2);
      var1.n = this.a(var1.n, var2);
      var1.o = this.a(var1.o, var2);
      var1.p = this.a(var1.p, var2);
      var1.q = this.a(var1.q, var2);
      var1.r = this.a(var1.r, var2);
      var1.s = this.a(var1.s, var2);
      var1.u = this.a(var1.u, var2);
      var1.t = this.a(var1.t, var2);
      var1.v = this.a(var1.v, var2);
      var1.w = this.a(var1.w, var2);
   }

   @Override
   public Chronology b() {
      return this.L();
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof ZonedChronology)) {
            var2 = false;
         } else {
            var1 = var1;
            if (!this.L().equals(var1.L()) || !this.a().equals(var1.a())) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return 326565 + this.a().hashCode() * 11 + this.L().hashCode() * 7;
   }

   @Override
   public String toString() {
      return "ZonedChronology[" + this.L() + ", " + this.a().e() + ']';
   }

   static final class ZonedDateTimeField extends BaseDateTimeField {
      final DateTimeField a;
      final DateTimeZone b;
      final DurationField c;
      final boolean d;
      final DurationField e;
      final DurationField f;

      ZonedDateTimeField(DateTimeField var1, DateTimeZone var2, DurationField var3, DurationField var4, DurationField var5) {
         super(var1.a());
         if (!var1.c()) {
            throw new IllegalArgumentException();
         }

         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = ZonedChronology.a(var3);
         this.e = var4;
         this.f = var5;
      }

      private int j(long var1) {
         int var3 = this.b.b(var1);
         if ((var3 + var1 ^ var1) < 0L && (var3 ^ var1) >= 0L) {
            throw new ArithmeticException("Adding time zone offset caused overflow");
         } else {
            return var3;
         }
      }

      @Override
      public int a(long var1) {
         var1 = this.b.f(var1);
         return this.a.a(var1);
      }

      @Override
      public int a(Locale var1) {
         return this.a.a(var1);
      }

      @Override
      public long a(long var1, int var3) {
         if (this.d) {
            int var4 = this.j(var1);
            var1 = this.a.a(var4 + var1, var3) - var4;
         } else {
            long var5 = this.b.f(var1);
            var5 = this.a.a(var5, var3);
            var1 = this.b.a(var5, false, var1);
         }

         return var1;
      }

      @Override
      public long a(long var1, long var3) {
         if (this.d) {
            int var5 = this.j(var1);
            var1 = this.a.a(var5 + var1, var3) - var5;
         } else {
            long var6 = this.b.f(var1);
            var3 = this.a.a(var6, var3);
            var1 = this.b.a(var3, false, var1);
         }

         return var1;
      }

      @Override
      public long a(long var1, String var3, Locale var4) {
         long var5 = this.b.f(var1);
         var5 = this.a.a(var5, var3, var4);
         return this.b.a(var5, false, var1);
      }

      @Override
      public String a(int var1, Locale var2) {
         return this.a.a(var1, var2);
      }

      @Override
      public String a(long var1, Locale var3) {
         var1 = this.b.f(var1);
         return this.a.a(var1, var3);
      }

      @Override
      public long b(long var1, int var3) {
         long var4 = this.b.f(var1);
         var4 = this.a.b(var4, var3);
         var1 = this.b.a(var4, false, var1);
         if (this.a(var1) != var3) {
            IllegalInstantException var6 = new IllegalInstantException(var4, this.b.e());
            IllegalFieldValueException var7 = new IllegalFieldValueException(this.a.a(), var3, var6.getMessage());
            var7.initCause(var6);
            throw var7;
         } else {
            return var1;
         }
      }

      @Override
      public String b(int var1, Locale var2) {
         return this.a.b(var1, var2);
      }

      @Override
      public String b(long var1, Locale var3) {
         var1 = this.b.f(var1);
         return this.a.b(var1, var3);
      }

      @Override
      public boolean b(long var1) {
         var1 = this.b.f(var1);
         return this.a.b(var1);
      }

      @Override
      public int c(long var1) {
         var1 = this.b.f(var1);
         return this.a.c(var1);
      }

      @Override
      public long d(long var1) {
         if (this.d) {
            int var3 = this.j(var1);
            var1 = this.a.d(var3 + var1) - var3;
         } else {
            long var4 = this.b.f(var1);
            var4 = this.a.d(var4);
            var1 = this.b.a(var4, false, var1);
         }

         return var1;
      }

      @Override
      public final DurationField d() {
         return this.c;
      }

      @Override
      public long e(long var1) {
         if (this.d) {
            int var3 = this.j(var1);
            var1 = this.a.e(var3 + var1) - var3;
         } else {
            long var4 = this.b.f(var1);
            var4 = this.a.e(var4);
            var1 = this.b.a(var4, false, var1);
         }

         return var1;
      }

      @Override
      public final DurationField e() {
         return this.e;
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2 = true;
         if (this != var1) {
            if (var1 instanceof ZonedChronology.ZonedDateTimeField) {
               var1 = var1;
               if (!this.a.equals(var1.a) || !this.b.equals(var1.b) || !this.c.equals(var1.c) || !this.e.equals(var1.e)) {
                  var2 = false;
               }
            } else {
               var2 = false;
            }
         }

         return var2;
      }

      @Override
      public final DurationField f() {
         return this.f;
      }

      @Override
      public int g() {
         return this.a.g();
      }

      @Override
      public int h() {
         return this.a.h();
      }

      @Override
      public int hashCode() {
         return this.a.hashCode() ^ this.b.hashCode();
      }

      @Override
      public long i(long var1) {
         var1 = this.b.f(var1);
         return this.a.i(var1);
      }
   }

   static class ZonedDurationField extends BaseDurationField {
      final DurationField a;
      final boolean b;
      final DateTimeZone c;

      ZonedDurationField(DurationField var1, DateTimeZone var2) {
         super(var1.a());
         if (!var1.b()) {
            throw new IllegalArgumentException();
         }

         this.a = var1;
         this.b = ZonedChronology.a(var1);
         this.c = var2;
      }

      private int a(long var1) {
         int var3 = this.c.b(var1);
         if ((var3 + var1 ^ var1) < 0L && (var3 ^ var1) >= 0L) {
            throw new ArithmeticException("Adding time zone offset caused overflow");
         } else {
            return var3;
         }
      }

      private int b(long var1) {
         int var3 = this.c.e(var1);
         if ((var1 - var3 ^ var1) < 0L && (var3 ^ var1) < 0L) {
            throw new ArithmeticException("Subtracting time zone offset caused overflow");
         } else {
            return var3;
         }
      }

      @Override
      public long a(long var1, int var3) {
         int var4 = this.a(var1);
         var1 = this.a.a(var4 + var1, var3);
         if (this.b) {
            var3 = var4;
         } else {
            var3 = this.b(var1);
         }

         return var1 - var3;
      }

      @Override
      public long a(long var1, long var3) {
         int var5 = this.a(var1);
         var1 = this.a.a(var5 + var1, var3);
         if (!this.b) {
            var5 = this.b(var1);
         }

         return var1 - var5;
      }

      @Override
      public boolean c() {
         boolean var1;
         if (this.b) {
            var1 = this.a.c();
         } else if (this.a.c() && this.c.f()) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      @Override
      public long d() {
         return this.a.d();
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2 = true;
         if (this != var1) {
            if (var1 instanceof ZonedChronology.ZonedDurationField) {
               var1 = var1;
               if (!this.a.equals(var1.a) || !this.c.equals(var1.c)) {
                  var2 = false;
               }
            } else {
               var2 = false;
            }
         }

         return var2;
      }

      @Override
      public int hashCode() {
         return this.a.hashCode() ^ this.c.hashCode();
      }
   }
}
