package org.joda.time.chrono;

import java.io.IOException;
import java.io.ObjectInputStream;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;

public abstract class AssembledChronology extends BaseChronology {
   private transient DateTimeField A;
   private transient DateTimeField B;
   private transient DateTimeField C;
   private transient DateTimeField D;
   private transient DateTimeField E;
   private transient DateTimeField F;
   private transient DateTimeField G;
   private transient DateTimeField H;
   private transient DateTimeField I;
   private transient DateTimeField J;
   private transient DateTimeField K;
   private transient int L;
   private final Chronology a;
   private final Object b;
   private transient DurationField c;
   private transient DurationField d;
   private transient DurationField e;
   private transient DurationField f;
   private transient DurationField g;
   private transient DurationField h;
   private transient DurationField i;
   private transient DurationField j;
   private transient DurationField k;
   private transient DurationField l;
   private transient DurationField m;
   private transient DurationField n;
   private transient DateTimeField o;
   private transient DateTimeField p;
   private transient DateTimeField q;
   private transient DateTimeField r;
   private transient DateTimeField s;
   private transient DateTimeField t;
   private transient DateTimeField u;
   private transient DateTimeField v;
   private transient DateTimeField w;
   private transient DateTimeField x;
   private transient DateTimeField y;
   private transient DateTimeField z;

   protected AssembledChronology(Chronology var1, Object var2) {
      this.a = var1;
      this.b = var2;
      this.N();
   }

   private void N() {
      byte var4 = 0;
      int var1 = 0;
      AssembledChronology.Fields var6 = new AssembledChronology.Fields();
      if (this.a != null) {
         var6.a(this.a);
      }

      this.a(var6);
      DurationField var5 = var6.a;
      if (var5 == null) {
         var5 = super.c();
      }

      this.c = var5;
      var5 = var6.b;
      if (var5 == null) {
         var5 = super.f();
      }

      this.d = var5;
      var5 = var6.c;
      if (var5 == null) {
         var5 = super.i();
      }

      this.e = var5;
      var5 = var6.d;
      if (var5 == null) {
         var5 = super.l();
      }

      this.f = var5;
      var5 = var6.e;
      if (var5 == null) {
         var5 = super.o();
      }

      this.g = var5;
      var5 = var6.f;
      if (var5 == null) {
         var5 = super.s();
      }

      this.h = var5;
      var5 = var6.g;
      if (var5 == null) {
         var5 = super.w();
      }

      this.i = var5;
      var5 = var6.h;
      if (var5 == null) {
         var5 = super.y();
      }

      this.j = var5;
      var5 = var6.i;
      if (var5 == null) {
         var5 = super.B();
      }

      this.k = var5;
      var5 = var6.j;
      if (var5 == null) {
         var5 = super.D();
      }

      this.l = var5;
      var5 = var6.k;
      if (var5 == null) {
         var5 = super.H();
      }

      this.m = var5;
      var5 = var6.l;
      if (var5 == null) {
         var5 = super.J();
      }

      this.n = var5;
      DateTimeField var19 = var6.m;
      if (var19 == null) {
         var19 = super.d();
      }

      this.o = var19;
      DateTimeField var20 = var6.n;
      if (var20 == null) {
         var20 = super.e();
      }

      this.p = var20;
      DateTimeField var21 = var6.o;
      if (var21 == null) {
         var21 = super.g();
      }

      this.q = var21;
      DateTimeField var22 = var6.p;
      if (var22 == null) {
         var22 = super.h();
      }

      this.r = var22;
      DateTimeField var23 = var6.q;
      if (var23 == null) {
         var23 = super.j();
      }

      this.s = var23;
      DateTimeField var24 = var6.r;
      if (var24 == null) {
         var24 = super.k();
      }

      this.t = var24;
      DateTimeField var25 = var6.s;
      if (var25 == null) {
         var25 = super.m();
      }

      this.u = var25;
      DateTimeField var26 = var6.t;
      if (var26 == null) {
         var26 = super.n();
      }

      this.v = var26;
      DateTimeField var27 = var6.u;
      if (var27 == null) {
         var27 = super.p();
      }

      this.w = var27;
      DateTimeField var28 = var6.v;
      if (var28 == null) {
         var28 = super.q();
      }

      this.x = var28;
      DateTimeField var29 = var6.w;
      if (var29 == null) {
         var29 = super.r();
      }

      this.y = var29;
      DateTimeField var30 = var6.x;
      if (var30 == null) {
         var30 = super.t();
      }

      this.z = var30;
      DateTimeField var31 = var6.y;
      if (var31 == null) {
         var31 = super.u();
      }

      this.A = var31;
      DateTimeField var32 = var6.z;
      if (var32 == null) {
         var32 = super.v();
      }

      this.B = var32;
      DateTimeField var33 = var6.A;
      if (var33 == null) {
         var33 = super.x();
      }

      this.C = var33;
      DateTimeField var34 = var6.B;
      if (var34 == null) {
         var34 = super.z();
      }

      this.D = var34;
      DateTimeField var35 = var6.C;
      if (var35 == null) {
         var35 = super.A();
      }

      this.E = var35;
      DateTimeField var36 = var6.D;
      if (var36 == null) {
         var36 = super.C();
      }

      this.F = var36;
      DateTimeField var37 = var6.E;
      if (var37 == null) {
         var37 = super.E();
      }

      this.G = var37;
      DateTimeField var38 = var6.F;
      if (var38 == null) {
         var38 = super.F();
      }

      this.H = var38;
      DateTimeField var39 = var6.G;
      if (var39 == null) {
         var39 = super.G();
      }

      this.I = var39;
      DateTimeField var40 = var6.H;
      if (var40 == null) {
         var40 = super.I();
      }

      this.J = var40;
      DateTimeField var41 = var6.I;
      if (var41 == null) {
         var41 = super.K();
      }

      this.K = var41;
      if (this.a != null) {
         byte var7;
         if (this.u == this.a.m() && this.s == this.a.j() && this.q == this.a.g() && this.o == this.a.d()) {
            var7 = 1;
         } else {
            var7 = 0;
         }

         byte var2;
         if (this.p == this.a.e()) {
            var2 = 2;
         } else {
            var2 = 0;
         }

         byte var3 = var4;
         if (this.G == this.a.E()) {
            var3 = var4;
            if (this.F == this.a.C()) {
               var3 = var4;
               if (this.A == this.a.u()) {
                  var3 = 4;
               }
            }
         }

         var1 = var3 | var7 | var2;
      }

      this.L = var1;
   }

   private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
      var1.defaultReadObject();
      this.N();
   }

   @Override
   public final DateTimeField A() {
      return this.E;
   }

   @Override
   public final DurationField B() {
      return this.k;
   }

   @Override
   public final DateTimeField C() {
      return this.F;
   }

   @Override
   public final DurationField D() {
      return this.l;
   }

   @Override
   public final DateTimeField E() {
      return this.G;
   }

   @Override
   public final DateTimeField F() {
      return this.H;
   }

   @Override
   public final DateTimeField G() {
      return this.I;
   }

   @Override
   public final DurationField H() {
      return this.m;
   }

   @Override
   public final DateTimeField I() {
      return this.J;
   }

   @Override
   public final DurationField J() {
      return this.n;
   }

   @Override
   public final DateTimeField K() {
      return this.K;
   }

   protected final Chronology L() {
      return this.a;
   }

   protected final Object M() {
      return this.b;
   }

   @Override
   public long a(int var1, int var2, int var3, int var4) throws IllegalArgumentException {
      Chronology var7 = this.a;
      long var5;
      if (var7 != null && (this.L & 6) == 6) {
         var5 = var7.a(var1, var2, var3, var4);
      } else {
         var5 = super.a(var1, var2, var3, var4);
      }

      return var5;
   }

   @Override
   public long a(int var1, int var2, int var3, int var4, int var5, int var6, int var7) throws IllegalArgumentException {
      Chronology var10 = this.a;
      long var8;
      if (var10 != null && (this.L & 5) == 5) {
         var8 = var10.a(var1, var2, var3, var4, var5, var6, var7);
      } else {
         var8 = super.a(var1, var2, var3, var4, var5, var6, var7);
      }

      return var8;
   }

   @Override
   public long a(long var1, int var3, int var4, int var5, int var6) throws IllegalArgumentException {
      Chronology var7 = this.a;
      if (var7 != null && (this.L & 1) == 1) {
         var1 = var7.a(var1, var3, var4, var5, var6);
      } else {
         var1 = super.a(var1, var3, var4, var5, var6);
      }

      return var1;
   }

   @Override
   public DateTimeZone a() {
      Chronology var1 = this.a;
      DateTimeZone var2;
      if (var1 != null) {
         var2 = var1.a();
      } else {
         var2 = null;
      }

      return var2;
   }

   protected abstract void a(AssembledChronology.Fields var1);

   @Override
   public final DurationField c() {
      return this.c;
   }

   @Override
   public final DateTimeField d() {
      return this.o;
   }

   @Override
   public final DateTimeField e() {
      return this.p;
   }

   @Override
   public final DurationField f() {
      return this.d;
   }

   @Override
   public final DateTimeField g() {
      return this.q;
   }

   @Override
   public final DateTimeField h() {
      return this.r;
   }

   @Override
   public final DurationField i() {
      return this.e;
   }

   @Override
   public final DateTimeField j() {
      return this.s;
   }

   @Override
   public final DateTimeField k() {
      return this.t;
   }

   @Override
   public final DurationField l() {
      return this.f;
   }

   @Override
   public final DateTimeField m() {
      return this.u;
   }

   @Override
   public final DateTimeField n() {
      return this.v;
   }

   @Override
   public final DurationField o() {
      return this.g;
   }

   @Override
   public final DateTimeField p() {
      return this.w;
   }

   @Override
   public final DateTimeField q() {
      return this.x;
   }

   @Override
   public final DateTimeField r() {
      return this.y;
   }

   @Override
   public final DurationField s() {
      return this.h;
   }

   @Override
   public final DateTimeField t() {
      return this.z;
   }

   @Override
   public final DateTimeField u() {
      return this.A;
   }

   @Override
   public final DateTimeField v() {
      return this.B;
   }

   @Override
   public final DurationField w() {
      return this.i;
   }

   @Override
   public final DateTimeField x() {
      return this.C;
   }

   @Override
   public final DurationField y() {
      return this.j;
   }

   @Override
   public final DateTimeField z() {
      return this.D;
   }

   public static final class Fields {
      public DateTimeField A;
      public DateTimeField B;
      public DateTimeField C;
      public DateTimeField D;
      public DateTimeField E;
      public DateTimeField F;
      public DateTimeField G;
      public DateTimeField H;
      public DateTimeField I;
      public DurationField a;
      public DurationField b;
      public DurationField c;
      public DurationField d;
      public DurationField e;
      public DurationField f;
      public DurationField g;
      public DurationField h;
      public DurationField i;
      public DurationField j;
      public DurationField k;
      public DurationField l;
      public DateTimeField m;
      public DateTimeField n;
      public DateTimeField o;
      public DateTimeField p;
      public DateTimeField q;
      public DateTimeField r;
      public DateTimeField s;
      public DateTimeField t;
      public DateTimeField u;
      public DateTimeField v;
      public DateTimeField w;
      public DateTimeField x;
      public DateTimeField y;
      public DateTimeField z;

      Fields() {
      }

      private static boolean a(DateTimeField var0) {
         boolean var1;
         if (var0 == null) {
            var1 = false;
         } else {
            var1 = var0.c();
         }

         return var1;
      }

      private static boolean a(DurationField var0) {
         boolean var1;
         if (var0 == null) {
            var1 = false;
         } else {
            var1 = var0.b();
         }

         return var1;
      }

      public void a(Chronology var1) {
         DurationField var2 = var1.c();
         if (a(var2)) {
            this.a = var2;
         }

         var2 = var1.f();
         if (a(var2)) {
            this.b = var2;
         }

         var2 = var1.i();
         if (a(var2)) {
            this.c = var2;
         }

         var2 = var1.l();
         if (a(var2)) {
            this.d = var2;
         }

         var2 = var1.o();
         if (a(var2)) {
            this.e = var2;
         }

         var2 = var1.s();
         if (a(var2)) {
            this.f = var2;
         }

         var2 = var1.w();
         if (a(var2)) {
            this.g = var2;
         }

         var2 = var1.y();
         if (a(var2)) {
            this.h = var2;
         }

         var2 = var1.B();
         if (a(var2)) {
            this.i = var2;
         }

         var2 = var1.D();
         if (a(var2)) {
            this.j = var2;
         }

         var2 = var1.H();
         if (a(var2)) {
            this.k = var2;
         }

         var2 = var1.J();
         if (a(var2)) {
            this.l = var2;
         }

         DateTimeField var15 = var1.d();
         if (a(var15)) {
            this.m = var15;
         }

         DateTimeField var16 = var1.e();
         if (a(var16)) {
            this.n = var16;
         }

         DateTimeField var17 = var1.g();
         if (a(var17)) {
            this.o = var17;
         }

         DateTimeField var18 = var1.h();
         if (a(var18)) {
            this.p = var18;
         }

         DateTimeField var19 = var1.j();
         if (a(var19)) {
            this.q = var19;
         }

         DateTimeField var20 = var1.k();
         if (a(var20)) {
            this.r = var20;
         }

         DateTimeField var21 = var1.m();
         if (a(var21)) {
            this.s = var21;
         }

         DateTimeField var22 = var1.n();
         if (a(var22)) {
            this.t = var22;
         }

         DateTimeField var23 = var1.p();
         if (a(var23)) {
            this.u = var23;
         }

         DateTimeField var24 = var1.q();
         if (a(var24)) {
            this.v = var24;
         }

         DateTimeField var25 = var1.r();
         if (a(var25)) {
            this.w = var25;
         }

         DateTimeField var26 = var1.t();
         if (a(var26)) {
            this.x = var26;
         }

         DateTimeField var27 = var1.u();
         if (a(var27)) {
            this.y = var27;
         }

         DateTimeField var28 = var1.v();
         if (a(var28)) {
            this.z = var28;
         }

         DateTimeField var29 = var1.x();
         if (a(var29)) {
            this.A = var29;
         }

         DateTimeField var30 = var1.z();
         if (a(var30)) {
            this.B = var30;
         }

         DateTimeField var31 = var1.A();
         if (a(var31)) {
            this.C = var31;
         }

         DateTimeField var32 = var1.C();
         if (a(var32)) {
            this.D = var32;
         }

         DateTimeField var33 = var1.E();
         if (a(var33)) {
            this.E = var33;
         }

         DateTimeField var34 = var1.F();
         if (a(var34)) {
            this.F = var34;
         }

         DateTimeField var35 = var1.G();
         if (a(var35)) {
            this.G = var35;
         }

         DateTimeField var36 = var1.I();
         if (a(var36)) {
            this.H = var36;
         }

         DateTimeField var3 = var1.K();
         if (a(var3)) {
            this.I = var3;
         }
      }
   }
}
