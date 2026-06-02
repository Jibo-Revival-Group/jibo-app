package org.joda.time;

import java.io.Serializable;

public abstract class DateTimeFieldType implements Serializable {
   private static final DateTimeFieldType a = new DateTimeFieldType.StandardDateTimeFieldType("era", (byte)1, DurationFieldType.l(), null);
   private static final DateTimeFieldType b = new DateTimeFieldType.StandardDateTimeFieldType(
      "yearOfEra", (byte)2, DurationFieldType.j(), DurationFieldType.l()
   );
   private static final DateTimeFieldType c = new DateTimeFieldType.StandardDateTimeFieldType(
      "centuryOfEra", (byte)3, DurationFieldType.k(), DurationFieldType.l()
   );
   private static final DateTimeFieldType d = new DateTimeFieldType.StandardDateTimeFieldType(
      "yearOfCentury", (byte)4, DurationFieldType.j(), DurationFieldType.k()
   );
   private static final DateTimeFieldType e = new DateTimeFieldType.StandardDateTimeFieldType("year", (byte)5, DurationFieldType.j(), null);
   private static final DateTimeFieldType f = new DateTimeFieldType.StandardDateTimeFieldType(
      "dayOfYear", (byte)6, DurationFieldType.f(), DurationFieldType.j()
   );
   private static final DateTimeFieldType g = new DateTimeFieldType.StandardDateTimeFieldType(
      "monthOfYear", (byte)7, DurationFieldType.i(), DurationFieldType.j()
   );
   private static final DateTimeFieldType h = new DateTimeFieldType.StandardDateTimeFieldType(
      "dayOfMonth", (byte)8, DurationFieldType.f(), DurationFieldType.i()
   );
   private static final DateTimeFieldType i = new DateTimeFieldType.StandardDateTimeFieldType(
      "weekyearOfCentury", (byte)9, DurationFieldType.h(), DurationFieldType.k()
   );
   private static final DateTimeFieldType j = new DateTimeFieldType.StandardDateTimeFieldType("weekyear", (byte)10, DurationFieldType.h(), null);
   private static final DateTimeFieldType k = new DateTimeFieldType.StandardDateTimeFieldType(
      "weekOfWeekyear", (byte)11, DurationFieldType.g(), DurationFieldType.h()
   );
   private static final DateTimeFieldType l = new DateTimeFieldType.StandardDateTimeFieldType(
      "dayOfWeek", (byte)12, DurationFieldType.f(), DurationFieldType.g()
   );
   private static final DateTimeFieldType m = new DateTimeFieldType.StandardDateTimeFieldType(
      "halfdayOfDay", (byte)13, DurationFieldType.e(), DurationFieldType.f()
   );
   private static final DateTimeFieldType n = new DateTimeFieldType.StandardDateTimeFieldType(
      "hourOfHalfday", (byte)14, DurationFieldType.d(), DurationFieldType.e()
   );
   private static final DateTimeFieldType o = new DateTimeFieldType.StandardDateTimeFieldType(
      "clockhourOfHalfday", (byte)15, DurationFieldType.d(), DurationFieldType.e()
   );
   private static final DateTimeFieldType p = new DateTimeFieldType.StandardDateTimeFieldType(
      "clockhourOfDay", (byte)16, DurationFieldType.d(), DurationFieldType.f()
   );
   private static final DateTimeFieldType q = new DateTimeFieldType.StandardDateTimeFieldType(
      "hourOfDay", (byte)17, DurationFieldType.d(), DurationFieldType.f()
   );
   private static final DateTimeFieldType r = new DateTimeFieldType.StandardDateTimeFieldType(
      "minuteOfDay", (byte)18, DurationFieldType.c(), DurationFieldType.f()
   );
   private static final DateTimeFieldType s = new DateTimeFieldType.StandardDateTimeFieldType(
      "minuteOfHour", (byte)19, DurationFieldType.c(), DurationFieldType.d()
   );
   private static final DateTimeFieldType t = new DateTimeFieldType.StandardDateTimeFieldType(
      "secondOfDay", (byte)20, DurationFieldType.b(), DurationFieldType.f()
   );
   private static final DateTimeFieldType u = new DateTimeFieldType.StandardDateTimeFieldType(
      "secondOfMinute", (byte)21, DurationFieldType.b(), DurationFieldType.c()
   );
   private static final DateTimeFieldType v = new DateTimeFieldType.StandardDateTimeFieldType(
      "millisOfDay", (byte)22, DurationFieldType.a(), DurationFieldType.f()
   );
   private static final DateTimeFieldType w = new DateTimeFieldType.StandardDateTimeFieldType(
      "millisOfSecond", (byte)23, DurationFieldType.a(), DurationFieldType.b()
   );
   private final String x;

   protected DateTimeFieldType(String var1) {
      this.x = var1;
   }

   public static DateTimeFieldType a() {
      return w;
   }

   public static DateTimeFieldType b() {
      return v;
   }

   public static DateTimeFieldType c() {
      return u;
   }

   public static DateTimeFieldType d() {
      return t;
   }

   public static DateTimeFieldType e() {
      return s;
   }

   public static DateTimeFieldType f() {
      return r;
   }

   public static DateTimeFieldType g() {
      return q;
   }

   public static DateTimeFieldType h() {
      return p;
   }

   public static DateTimeFieldType i() {
      return n;
   }

   public static DateTimeFieldType j() {
      return o;
   }

   public static DateTimeFieldType k() {
      return m;
   }

   public static DateTimeFieldType l() {
      return l;
   }

   public static DateTimeFieldType m() {
      return h;
   }

   public static DateTimeFieldType n() {
      return f;
   }

   public static DateTimeFieldType o() {
      return k;
   }

   public static DateTimeFieldType p() {
      return j;
   }

   public static DateTimeFieldType q() {
      return i;
   }

   public static DateTimeFieldType r() {
      return g;
   }

   public static DateTimeFieldType s() {
      return e;
   }

   public static DateTimeFieldType t() {
      return b;
   }

   public static DateTimeFieldType u() {
      return d;
   }

   public static DateTimeFieldType v() {
      return c;
   }

   public static DateTimeFieldType w() {
      return a;
   }

   public abstract DateTimeField a(Chronology var1);

   @Override
   public String toString() {
      return this.x();
   }

   public String x() {
      return this.x;
   }

   public abstract DurationFieldType y();

   public abstract DurationFieldType z();

   private static class StandardDateTimeFieldType extends DateTimeFieldType {
      private final byte a;
      private final transient DurationFieldType b;
      private final transient DurationFieldType c;

      StandardDateTimeFieldType(String var1, byte var2, DurationFieldType var3, DurationFieldType var4) {
         super(var1);
         this.a = var2;
         this.b = var3;
         this.c = var4;
      }

      private Object readResolve() {
         DateTimeFieldType var1;
         switch (this.a) {
            case 1:
               var1 = DateTimeFieldType.a;
               break;
            case 2:
               var1 = DateTimeFieldType.b;
               break;
            case 3:
               var1 = DateTimeFieldType.c;
               break;
            case 4:
               var1 = DateTimeFieldType.d;
               break;
            case 5:
               var1 = DateTimeFieldType.e;
               break;
            case 6:
               var1 = DateTimeFieldType.f;
               break;
            case 7:
               var1 = DateTimeFieldType.g;
               break;
            case 8:
               var1 = DateTimeFieldType.h;
               break;
            case 9:
               var1 = DateTimeFieldType.i;
               break;
            case 10:
               var1 = DateTimeFieldType.j;
               break;
            case 11:
               var1 = DateTimeFieldType.k;
               break;
            case 12:
               var1 = DateTimeFieldType.l;
               break;
            case 13:
               var1 = DateTimeFieldType.m;
               break;
            case 14:
               var1 = DateTimeFieldType.n;
               break;
            case 15:
               var1 = DateTimeFieldType.o;
               break;
            case 16:
               var1 = DateTimeFieldType.p;
               break;
            case 17:
               var1 = DateTimeFieldType.q;
               break;
            case 18:
               var1 = DateTimeFieldType.r;
               break;
            case 19:
               var1 = DateTimeFieldType.s;
               break;
            case 20:
               var1 = DateTimeFieldType.t;
               break;
            case 21:
               var1 = DateTimeFieldType.u;
               break;
            case 22:
               var1 = DateTimeFieldType.v;
               break;
            case 23:
               var1 = DateTimeFieldType.w;
               break;
            default:
               var1 = this;
         }

         return var1;
      }

      @Override
      public DateTimeField a(Chronology var1) {
         var1 = DateTimeUtils.a(var1);
         DateTimeField var3;
         switch (this.a) {
            case 1:
               var3 = var1.K();
               break;
            case 2:
               var3 = var1.F();
               break;
            case 3:
               var3 = var1.I();
               break;
            case 4:
               var3 = var1.G();
               break;
            case 5:
               var3 = var1.E();
               break;
            case 6:
               var3 = var1.v();
               break;
            case 7:
               var3 = var1.C();
               break;
            case 8:
               var3 = var1.u();
               break;
            case 9:
               var3 = var1.A();
               break;
            case 10:
               var3 = var1.z();
               break;
            case 11:
               var3 = var1.x();
               break;
            case 12:
               var3 = var1.t();
               break;
            case 13:
               var3 = var1.r();
               break;
            case 14:
               var3 = var1.p();
               break;
            case 15:
               var3 = var1.q();
               break;
            case 16:
               var3 = var1.n();
               break;
            case 17:
               var3 = var1.m();
               break;
            case 18:
               var3 = var1.k();
               break;
            case 19:
               var3 = var1.j();
               break;
            case 20:
               var3 = var1.h();
               break;
            case 21:
               var3 = var1.g();
               break;
            case 22:
               var3 = var1.e();
               break;
            case 23:
               var3 = var1.d();
               break;
            default:
               throw new InternalError();
         }

         return var3;
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2 = true;
         if (this != var1) {
            if (var1 instanceof DateTimeFieldType.StandardDateTimeFieldType) {
               if (this.a != ((DateTimeFieldType.StandardDateTimeFieldType)var1).a) {
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
         return 1 << this.a;
      }

      @Override
      public DurationFieldType y() {
         return this.b;
      }

      @Override
      public DurationFieldType z() {
         return this.c;
      }
   }
}
