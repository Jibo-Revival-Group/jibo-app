package org.joda.time.chrono;

import java.util.HashMap;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.MutableDateTime;
import org.joda.time.ReadableDateTime;
import org.joda.time.field.DecoratedDateTimeField;
import org.joda.time.field.DecoratedDurationField;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public final class LimitChronology extends AssembledChronology {
   final DateTime a;
   final DateTime b;
   private transient LimitChronology c;

   private LimitChronology(Chronology var1, DateTime var2, DateTime var3) {
      super(var1, null);
      this.a = var2;
      this.b = var3;
   }

   private DateTimeField a(DateTimeField var1, HashMap<Object, Object> var2) {
      if (var1 != null && var1.c()) {
         if (var2.containsKey(var1)) {
            var1 = (DateTimeField)var2.get(var1);
         } else {
            LimitChronology.LimitDateTimeField var3 = new LimitChronology.LimitDateTimeField(
               this, var1, this.a(var1.d(), var2), this.a(var1.e(), var2), this.a(var1.f(), var2)
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
            LimitChronology.LimitDurationField var3 = new LimitChronology.LimitDurationField(this, var1);
            var2.put(var1, var3);
            var1 = var3;
         }
      }

      return var1;
   }

   public static LimitChronology a(Chronology var0, ReadableDateTime var1, ReadableDateTime var2) {
      Object var3 = null;
      if (var0 == null) {
         throw new IllegalArgumentException("Must supply a chronology");
      }

      if (var1 == null) {
         var1 = null;
      } else {
         var1 = var1.a();
      }

      if (var2 == null) {
         var2 = (DateTime)var3;
      } else {
         var2 = var2.a();
      }

      if (var1 != null && var2 != null && !var1.a(var2)) {
         throw new IllegalArgumentException("The lower limit must be come before than the upper limit");
      } else {
         return new LimitChronology(var0, var1, var2);
      }
   }

   public DateTime N() {
      return this.a;
   }

   public DateTime O() {
      return this.b;
   }

   @Override
   public long a(int var1, int var2, int var3, int var4) throws IllegalArgumentException {
      long var5 = this.L().a(var1, var2, var3, var4);
      this.a(var5, "resulting");
      return var5;
   }

   @Override
   public long a(int var1, int var2, int var3, int var4, int var5, int var6, int var7) throws IllegalArgumentException {
      long var8 = this.L().a(var1, var2, var3, var4, var5, var6, var7);
      this.a(var8, "resulting");
      return var8;
   }

   @Override
   public long a(long var1, int var3, int var4, int var5, int var6) throws IllegalArgumentException {
      this.a(var1, null);
      var1 = this.L().a(var1, var3, var4, var5, var6);
      this.a(var1, "resulting");
      return var1;
   }

   @Override
   public Chronology a(DateTimeZone var1) {
      DateTimeZone var2 = var1;
      if (var1 == null) {
         var2 = DateTimeZone.a();
      }

      LimitChronology var5;
      if (var2 == this.a()) {
         var5 = this;
      } else if (var2 == DateTimeZone.a && this.c != null) {
         var5 = this.c;
      } else {
         DateTime var3 = this.a;
         DateTime var6 = var3;
         if (var3 != null) {
            MutableDateTime var7 = var3.e();
            var7.a(var2);
            var6 = var7.a();
         }

         DateTime var4 = this.b;
         var3 = var4;
         if (var4 != null) {
            MutableDateTime var9 = var4.e();
            var9.a(var2);
            var3 = var9.a();
         }

         var5 = a(this.L().a(var2), var6, var3);
         if (var2 == DateTimeZone.a) {
            this.c = var5;
         }
      }

      return var5;
   }

   void a(long var1, String var3) {
      DateTime var4 = this.a;
      if (var4 != null && var1 < var4.c()) {
         throw new LimitChronology.LimitException(this, var3, true);
      }

      var4 = this.b;
      if (var4 != null && var1 >= var4.c()) {
         throw new LimitChronology.LimitException(this, var3, false);
      }
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
      return this.a(DateTimeZone.a);
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof LimitChronology)) {
            var2 = false;
         } else {
            var1 = var1;
            if (!this.L().equals(var1.L()) || !FieldUtils.a(this.N(), var1.N()) || !FieldUtils.a(this.O(), var1.O())) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      int var2 = 0;
      int var1;
      if (this.N() != null) {
         var1 = this.N().hashCode();
      } else {
         var1 = 0;
      }

      if (this.O() != null) {
         var2 = this.O().hashCode();
      }

      return var1 + 317351877 + var2 + this.L().hashCode() * 7;
   }

   @Override
   public String toString() {
      StringBuilder var2 = new StringBuilder().append("LimitChronology[").append(this.L().toString()).append(", ");
      String var1;
      if (this.N() == null) {
         var1 = "NoLimit";
      } else {
         var1 = this.N().toString();
      }

      var2 = var2.append(var1).append(", ");
      if (this.O() == null) {
         var1 = "NoLimit";
      } else {
         var1 = this.O().toString();
      }

      return var2.append(var1).append(']').toString();
   }

   private class LimitDateTimeField extends DecoratedDateTimeField {
      final LimitChronology a;
      private final DurationField b;
      private final DurationField c;
      private final DurationField d;

      LimitDateTimeField(LimitChronology var1, DateTimeField var2, DurationField var3, DurationField var4, DurationField var5) {
         super(var2, var2.a());
         this.a = var1;
         this.b = var3;
         this.c = var4;
         this.d = var5;
      }

      @Override
      public int a(long var1) {
         this.a.a(var1, null);
         return this.i().a(var1);
      }

      @Override
      public int a(Locale var1) {
         return this.i().a(var1);
      }

      @Override
      public long a(long var1, int var3) {
         this.a.a(var1, null);
         var1 = this.i().a(var1, var3);
         this.a.a(var1, "resulting");
         return var1;
      }

      @Override
      public long a(long var1, long var3) {
         this.a.a(var1, null);
         var1 = this.i().a(var1, var3);
         this.a.a(var1, "resulting");
         return var1;
      }

      @Override
      public long a(long var1, String var3, Locale var4) {
         this.a.a(var1, null);
         var1 = this.i().a(var1, var3, var4);
         this.a.a(var1, "resulting");
         return var1;
      }

      @Override
      public String a(long var1, Locale var3) {
         this.a.a(var1, null);
         return this.i().a(var1, var3);
      }

      @Override
      public long b(long var1, int var3) {
         this.a.a(var1, null);
         var1 = this.i().b(var1, var3);
         this.a.a(var1, "resulting");
         return var1;
      }

      @Override
      public String b(long var1, Locale var3) {
         this.a.a(var1, null);
         return this.i().b(var1, var3);
      }

      @Override
      public boolean b(long var1) {
         this.a.a(var1, null);
         return this.i().b(var1);
      }

      @Override
      public int c(long var1) {
         this.a.a(var1, null);
         return this.i().c(var1);
      }

      @Override
      public long d(long var1) {
         this.a.a(var1, null);
         var1 = this.i().d(var1);
         this.a.a(var1, "resulting");
         return var1;
      }

      @Override
      public final DurationField d() {
         return this.b;
      }

      @Override
      public long e(long var1) {
         this.a.a(var1, null);
         var1 = this.i().e(var1);
         this.a.a(var1, "resulting");
         return var1;
      }

      @Override
      public final DurationField e() {
         return this.c;
      }

      @Override
      public long f(long var1) {
         this.a.a(var1, null);
         var1 = this.i().f(var1);
         this.a.a(var1, "resulting");
         return var1;
      }

      @Override
      public final DurationField f() {
         return this.d;
      }

      @Override
      public long g(long var1) {
         this.a.a(var1, null);
         var1 = this.i().g(var1);
         this.a.a(var1, "resulting");
         return var1;
      }

      @Override
      public long h(long var1) {
         this.a.a(var1, null);
         var1 = this.i().h(var1);
         this.a.a(var1, "resulting");
         return var1;
      }

      @Override
      public long i(long var1) {
         this.a.a(var1, null);
         var1 = this.i().i(var1);
         this.a.a(var1, "resulting");
         return var1;
      }
   }

   private class LimitDurationField extends DecoratedDurationField {
      final LimitChronology a;

      LimitDurationField(LimitChronology var1, DurationField var2) {
         super(var2, var2.a());
         this.a = var1;
      }

      @Override
      public long a(long var1, int var3) {
         this.a.a(var1, null);
         var1 = this.f().a(var1, var3);
         this.a.a(var1, "resulting");
         return var1;
      }

      @Override
      public long a(long var1, long var3) {
         this.a.a(var1, null);
         var1 = this.f().a(var1, var3);
         this.a.a(var1, "resulting");
         return var1;
      }
   }

   private class LimitException extends IllegalArgumentException {
      final LimitChronology a;
      private final boolean b;

      LimitException(LimitChronology var1, String var2, boolean var3) {
         super(var2);
         this.a = var1;
         this.b = var3;
      }

      @Override
      public String getMessage() {
         StringBuffer var1 = new StringBuffer(85);
         var1.append("The");
         String var2 = super.getMessage();
         if (var2 != null) {
            var1.append(' ');
            var1.append(var2);
         }

         var1.append(" instant is ");
         DateTimeFormatter var3 = ISODateTimeFormat.d().a(this.a.L());
         if (this.b) {
            var1.append("below the supported minimum of ");
            var3.a(var1, this.a.N().c());
         } else {
            var1.append("above the supported maximum of ");
            var3.a(var1, this.a.O().c());
         }

         var1.append(" (");
         var1.append(this.a.L());
         var1.append(')');
         return var1.toString();
      }

      @Override
      public String toString() {
         return "IllegalArgumentException: " + this.getMessage();
      }
   }
}
