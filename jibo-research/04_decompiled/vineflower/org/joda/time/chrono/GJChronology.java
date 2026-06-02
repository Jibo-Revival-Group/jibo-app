package org.joda.time.chrono;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.Instant;
import org.joda.time.LocalDate;
import org.joda.time.ReadableInstant;
import org.joda.time.field.BaseDateTimeField;
import org.joda.time.field.DecoratedDurationField;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public final class GJChronology extends AssembledChronology {
   static final Instant a = new Instant(-12219292800000L);
   private static final ConcurrentHashMap<GJCacheKey, GJChronology> b = new ConcurrentHashMap<>();
   private JulianChronology c;
   private GregorianChronology d;
   private Instant e;
   private long f;
   private long g;

   private GJChronology(Chronology var1, JulianChronology var2, GregorianChronology var3, Instant var4) {
      super(var1, new Object[]{var2, var3, var4});
   }

   private GJChronology(JulianChronology var1, GregorianChronology var2, Instant var3) {
      super(null, new Object[]{var1, var2, var3});
   }

   private static long a(long var0, Chronology var2, Chronology var3) {
      return var3.a(var2.E().a(var0), var2.C().a(var0), var2.u().a(var0), var2.e().a(var0));
   }

   public static GJChronology a(DateTimeZone var0, long var1, int var3) {
      Instant var4;
      if (var1 == a.c()) {
         var4 = null;
      } else {
         var4 = new Instant(var1);
      }

      return a(var0, var4, var3);
   }

   public static GJChronology a(DateTimeZone var0, ReadableInstant var1) {
      return a(var0, var1, 4);
   }

   public static GJChronology a(DateTimeZone var0, ReadableInstant var1, int var2) {
      DateTimeZone var4 = DateTimeUtils.a(var0);
      if (var1 == null) {
         var1 = a;
      } else {
         var1 = var1.b();
         if (new LocalDate(var1.c(), GregorianChronology.b(var4)).d() <= 0) {
            throw new IllegalArgumentException("Cutover too early. Must be on or after 0001-01-01.");
         }
      }

      GJCacheKey var5 = new GJCacheKey(var4, var1, var2);
      GJChronology var3 = b.get(var5);
      GJChronology var6 = var3;
      if (var3 == null) {
         if (var4 == DateTimeZone.a) {
            var6 = new GJChronology(JulianChronology.a(var4, var2), GregorianChronology.a(var4, var2), var1);
         } else {
            GJChronology var7 = a(DateTimeZone.a, var1, var2);
            var6 = new GJChronology(ZonedChronology.a(var7, var4), var7.c, var7.d, var7.e);
         }

         GJChronology var9 = b.putIfAbsent(var5, var6);
         if (var9 != null) {
            var6 = var9;
         }
      }

      return var6;
   }

   private static long b(long var0, Chronology var2, Chronology var3) {
      long var4 = var3.z().b(0L, var2.z().a(var0));
      var4 = var3.x().b(var4, var2.x().a(var0));
      var4 = var3.t().b(var4, var2.t().a(var0));
      return var3.e().b(var4, var2.e().a(var0));
   }

   private Object readResolve() {
      return a(this.a(), this.e, this.N());
   }

   public int N() {
      return this.d.N();
   }

   @Override
   public long a(int var1, int var2, int var3, int var4) throws IllegalArgumentException {
      Chronology var9 = this.L();
      long var5;
      if (var9 != null) {
         var5 = var9.a(var1, var2, var3, var4);
      } else {
         long var7 = this.d.a(var1, var2, var3, var4);
         var5 = var7;
         if (var7 < this.f) {
            var7 = this.c.a(var1, var2, var3, var4);
            var5 = var7;
            if (var7 >= this.f) {
               throw new IllegalArgumentException("Specified date does not exist");
            }
         }
      }

      return var5;
   }

   @Override
   public long a(int var1, int var2, int var3, int var4, int var5, int var6, int var7) throws IllegalArgumentException {
      Chronology var12 = this.L();
      long var15;
      if (var12 != null) {
         var15 = var12.a(var1, var2, var3, var4, var5, var6, var7);
      } else {
         long var8;
         try {
            var8 = this.d.a(var1, var2, var3, var4, var5, var6, var7);
         } catch (IllegalFieldValueException var13) {
            if (var2 != 2 || var3 != 29) {
               throw var13;
            }

            var15 = this.d.a(var1, var2, 28, var4, var5, var6, var7);
            var8 = var15;
            if (var15 >= this.f) {
               throw var13;
            }
         }

         var15 = var8;
         if (var8 < this.f) {
            var8 = this.c.a(var1, var2, var3, var4, var5, var6, var7);
            var15 = var8;
            if (var8 >= this.f) {
               throw new IllegalArgumentException("Specified date does not exist");
            }
         }
      }

      return var15;
   }

   long a(long var1) {
      return a(var1, this.c, this.d);
   }

   @Override
   public Chronology a(DateTimeZone var1) {
      DateTimeZone var2 = var1;
      if (var1 == null) {
         var2 = DateTimeZone.a();
      }

      GJChronology var3;
      if (var2 == this.a()) {
         var3 = this;
      } else {
         var3 = a(var2, this.e, this.N());
      }

      return var3;
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
      Object[] var6 = (Object[])this.M();
      JulianChronology var5 = (JulianChronology)var6[0];
      GregorianChronology var4 = (GregorianChronology)var6[1];
      Instant var9 = (Instant)var6[2];
      this.f = var9.c();
      this.c = var5;
      this.d = var4;
      this.e = var9;
      if (this.L() == null) {
         if (var5.N() != var4.N()) {
            throw new IllegalArgumentException();
         }

         this.g = this.f - this.a(this.f);
         var1.a(var4);
         if (var4.e().a(this.f) == 0) {
            var1.m = new GJChronology.CutoverField(this, var5.d(), var1.m, this.f);
            var1.n = new GJChronology.CutoverField(this, var5.e(), var1.n, this.f);
            var1.o = new GJChronology.CutoverField(this, var5.g(), var1.o, this.f);
            var1.p = new GJChronology.CutoverField(this, var5.h(), var1.p, this.f);
            var1.q = new GJChronology.CutoverField(this, var5.j(), var1.q, this.f);
            var1.r = new GJChronology.CutoverField(this, var5.k(), var1.r, this.f);
            var1.s = new GJChronology.CutoverField(this, var5.m(), var1.s, this.f);
            var1.u = new GJChronology.CutoverField(this, var5.p(), var1.u, this.f);
            var1.t = new GJChronology.CutoverField(this, var5.n(), var1.t, this.f);
            var1.v = new GJChronology.CutoverField(this, var5.q(), var1.v, this.f);
            var1.w = new GJChronology.CutoverField(this, var5.r(), var1.w, this.f);
         }

         var1.I = new GJChronology.CutoverField(this, var5.K(), var1.I, this.f);
         var1.E = new GJChronology.ImpreciseCutoverField(this, var5.E(), var1.E, this.f);
         var1.j = var1.E.d();
         var1.F = new GJChronology.ImpreciseCutoverField(this, var5.F(), var1.F, var1.j, this.f);
         var1.H = new GJChronology.ImpreciseCutoverField(this, var5.I(), var1.H, this.f);
         var1.k = var1.H.d();
         var1.G = new GJChronology.ImpreciseCutoverField(this, var5.G(), var1.G, var1.j, var1.k, this.f);
         var1.D = new GJChronology.ImpreciseCutoverField(this, var5.C(), var1.D, null, var1.j, this.f);
         var1.i = var1.D.d();
         var1.B = new GJChronology.ImpreciseCutoverField(this, var5.z(), var1.B, null, this.f, true);
         var1.h = var1.B.d();
         var1.C = new GJChronology.ImpreciseCutoverField(this, var5.A(), var1.C, var1.h, var1.k, this.f);
         long var2 = var4.E().e(this.f);
         var1.z = new GJChronology.CutoverField(this, var5.v(), var1.z, var1.j, var2, false);
         var2 = var4.z().e(this.f);
         var1.A = new GJChronology.CutoverField(this, var5.x(), var1.A, var1.h, var2, true);
         GJChronology.CutoverField var8 = new GJChronology.CutoverField(this, var5.u(), var1.y, this.f);
         var8.f = var1.i;
         var1.y = var8;
      }
   }

   long b(long var1) {
      return a(var1, this.d, this.c);
   }

   @Override
   public Chronology b() {
      return this.a(DateTimeZone.a);
   }

   long c(long var1) {
      return b(var1, this.c, this.d);
   }

   long d(long var1) {
      return b(var1, this.d, this.c);
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 instanceof GJChronology) {
            var1 = var1;
            if (this.f != var1.f || this.N() != var1.N() || !this.a().equals(var1.a())) {
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
      return "GJ".hashCode() * 11 + this.a().hashCode() + this.N() + this.e.hashCode();
   }

   @Override
   public String toString() {
      StringBuffer var2 = new StringBuffer(60);
      var2.append("GJChronology");
      var2.append('[');
      var2.append(this.a().e());
      if (this.f != a.c()) {
         var2.append(",cutover=");
         DateTimeFormatter var1;
         if (this.b().v().i(this.f) == 0L) {
            var1 = ISODateTimeFormat.b();
         } else {
            var1 = ISODateTimeFormat.d();
         }

         var1.a(this.b()).a(var2, this.f);
      }

      if (this.N() != 4) {
         var2.append(",mdfw=");
         var2.append(this.N());
      }

      var2.append(']');
      return var2.toString();
   }

   private class CutoverField extends BaseDateTimeField {
      final DateTimeField a;
      final DateTimeField b;
      final long c;
      final boolean d;
      protected DurationField e;
      protected DurationField f;
      final GJChronology g;

      CutoverField(GJChronology var1, DateTimeField var2, DateTimeField var3, long var4) {
         this(var1, var2, var3, var4, false);
      }

      CutoverField(GJChronology var1, DateTimeField var2, DateTimeField var3, long var4, boolean var6) {
         this(var1, var2, var3, null, var4, var6);
      }

      CutoverField(GJChronology var1, DateTimeField var2, DateTimeField var3, DurationField var4, long var5, boolean var7) {
         super(var3.a());
         this.g = var1;
         this.a = var2;
         this.b = var3;
         this.c = var5;
         this.d = var7;
         this.e = var3.d();
         DurationField var8 = var4;
         if (var4 == null) {
            DurationField var9 = var3.e();
            var8 = var9;
            if (var9 == null) {
               var8 = var2.e();
            }
         }

         this.f = var8;
      }

      @Override
      public int a(long var1) {
         int var3;
         if (var1 >= this.c) {
            var3 = this.b.a(var1);
         } else {
            var3 = this.a.a(var1);
         }

         return var3;
      }

      @Override
      public int a(Locale var1) {
         return Math.max(this.a.a(var1), this.b.a(var1));
      }

      @Override
      public long a(long var1, int var3) {
         return this.b.a(var1, var3);
      }

      @Override
      public long a(long var1, long var3) {
         return this.b.a(var1, var3);
      }

      @Override
      public long a(long var1, String var3, Locale var4) {
         if (var1 >= this.c) {
            long var5 = this.b.a(var1, var3, var4);
            var1 = var5;
            if (var5 < this.c) {
               var1 = var5;
               if (this.g.g + var5 < this.c) {
                  var1 = this.k(var5);
               }
            }
         } else {
            long var8 = this.a.a(var1, var3, var4);
            var1 = var8;
            if (var8 >= this.c) {
               var1 = var8;
               if (var8 - this.g.g >= this.c) {
                  var1 = this.j(var8);
               }
            }
         }

         return var1;
      }

      @Override
      public String a(int var1, Locale var2) {
         return this.b.a(var1, var2);
      }

      @Override
      public String a(long var1, Locale var3) {
         String var4;
         if (var1 >= this.c) {
            var4 = this.b.a(var1, var3);
         } else {
            var4 = this.a.a(var1, var3);
         }

         return var4;
      }

      @Override
      public long b(long var1, int var3) {
         if (var1 >= this.c) {
            long var6 = this.b.b(var1, var3);
            var1 = var6;
            if (var6 < this.c) {
               long var4 = var6;
               if (this.g.g + var6 < this.c) {
                  var4 = this.k(var6);
               }

               var1 = var4;
               if (this.a(var4) != var3) {
                  throw new IllegalFieldValueException(this.b.a(), var3, null, null);
               }
            }
         } else {
            long var10 = this.a.b(var1, var3);
            var1 = var10;
            if (var10 >= this.c) {
               long var9 = var10;
               if (var10 - this.g.g >= this.c) {
                  var9 = this.j(var10);
               }

               var1 = var9;
               if (this.a(var9) != var3) {
                  throw new IllegalFieldValueException(this.a.a(), var3, null, null);
               }
            }
         }

         return var1;
      }

      @Override
      public String b(int var1, Locale var2) {
         return this.b.b(var1, var2);
      }

      @Override
      public String b(long var1, Locale var3) {
         String var4;
         if (var1 >= this.c) {
            var4 = this.b.b(var1, var3);
         } else {
            var4 = this.a.b(var1, var3);
         }

         return var4;
      }

      @Override
      public boolean b(long var1) {
         boolean var3;
         if (var1 >= this.c) {
            var3 = this.b.b(var1);
         } else {
            var3 = this.a.b(var1);
         }

         return var3;
      }

      @Override
      public int c(long var1) {
         int var3;
         if (var1 >= this.c) {
            var3 = this.b.c(var1);
         } else {
            int var4 = this.a.c(var1);
            var3 = var4;
            if (this.a.b(var1, var4) >= this.c) {
               var3 = this.a.a(this.a.a(this.c, -1));
            }
         }

         return var3;
      }

      @Override
      public long d(long var1) {
         if (var1 >= this.c) {
            long var3 = this.b.d(var1);
            var1 = var3;
            if (var3 < this.c) {
               var1 = var3;
               if (this.g.g + var3 < this.c) {
                  var1 = this.k(var3);
               }
            }
         } else {
            var1 = this.a.d(var1);
         }

         return var1;
      }

      @Override
      public DurationField d() {
         return this.e;
      }

      @Override
      public long e(long var1) {
         if (var1 >= this.c) {
            var1 = this.b.e(var1);
         } else {
            long var3 = this.a.e(var1);
            var1 = var3;
            if (var3 >= this.c) {
               var1 = var3;
               if (var3 - this.g.g >= this.c) {
                  var1 = this.j(var3);
               }
            }
         }

         return var1;
      }

      @Override
      public DurationField e() {
         return this.f;
      }

      @Override
      public DurationField f() {
         return this.b.f();
      }

      @Override
      public int g() {
         return this.a.g();
      }

      @Override
      public int h() {
         return this.b.h();
      }

      protected long j(long var1) {
         if (this.d) {
            var1 = this.g.c(var1);
         } else {
            var1 = this.g.a(var1);
         }

         return var1;
      }

      protected long k(long var1) {
         if (this.d) {
            var1 = this.g.d(var1);
         } else {
            var1 = this.g.b(var1);
         }

         return var1;
      }
   }

   private final class ImpreciseCutoverField extends GJChronology.CutoverField {
      final GJChronology h;

      ImpreciseCutoverField(GJChronology var1, DateTimeField var2, DateTimeField var3, long var4) {
         this(var1, var2, var3, null, var4, false);
      }

      ImpreciseCutoverField(GJChronology var1, DateTimeField var2, DateTimeField var3, DurationField var4, long var5) {
         this(var1, var2, var3, var4, var5, false);
      }

      ImpreciseCutoverField(GJChronology var1, DateTimeField var2, DateTimeField var3, DurationField var4, long var5, boolean var7) {
         super(var1, var2, var3, var5, var7);
         this.h = var1;
         DurationField var8 = var4;
         if (var4 == null) {
            var8 = new GJChronology.LinkedDurationField(this.e, this);
         }

         this.e = var8;
      }

      ImpreciseCutoverField(GJChronology var1, DateTimeField var2, DateTimeField var3, DurationField var4, DurationField var5, long var6) {
         this(var1, var2, var3, var4, var6, false);
         this.f = var5;
      }

      @Override
      public long a(long var1, int var3) {
         if (var1 >= this.c) {
            long var4 = this.b.a(var1, var3);
            var1 = var4;
            if (var4 < this.c) {
               var1 = var4;
               if (this.h.g + var4 < this.c) {
                  if (this.d) {
                     var1 = var4;
                     if (this.h.d.z().a(var4) <= 0) {
                        var1 = this.h.d.z().a(var4, -1);
                     }
                  } else {
                     var1 = var4;
                     if (this.h.d.E().a(var4) <= 0) {
                        var1 = this.h.d.E().a(var4, -1);
                     }
                  }

                  var1 = this.k(var1);
               }
            }
         } else {
            long var8 = this.a.a(var1, var3);
            var1 = var8;
            if (var8 >= this.c) {
               var1 = var8;
               if (var8 - this.h.g >= this.c) {
                  var1 = this.j(var8);
               }
            }
         }

         return var1;
      }

      @Override
      public long a(long var1, long var3) {
         if (var1 >= this.c) {
            var3 = this.b.a(var1, var3);
            var1 = var3;
            if (var3 < this.c) {
               var1 = var3;
               if (this.h.g + var3 < this.c) {
                  if (this.d) {
                     var1 = var3;
                     if (this.h.d.z().a(var3) <= 0) {
                        var1 = this.h.d.z().a(var3, -1);
                     }
                  } else {
                     var1 = var3;
                     if (this.h.d.E().a(var3) <= 0) {
                        var1 = this.h.d.E().a(var3, -1);
                     }
                  }

                  var1 = this.k(var1);
               }
            }
         } else {
            var3 = this.a.a(var1, var3);
            var1 = var3;
            if (var3 >= this.c) {
               var1 = var3;
               if (var3 - this.h.g >= this.c) {
                  var1 = this.j(var3);
               }
            }
         }

         return var1;
      }

      @Override
      public int c(long var1) {
         int var3;
         if (var1 >= this.c) {
            var3 = this.b.c(var1);
         } else {
            var3 = this.a.c(var1);
         }

         return var3;
      }
   }

   private static class LinkedDurationField extends DecoratedDurationField {
      private final GJChronology.ImpreciseCutoverField a;

      LinkedDurationField(DurationField var1, GJChronology.ImpreciseCutoverField var2) {
         super(var1, var1.a());
         this.a = var2;
      }

      @Override
      public long a(long var1, int var3) {
         return this.a.a(var1, var3);
      }

      @Override
      public long a(long var1, long var3) {
         return this.a.a(var1, var3);
      }
   }
}
