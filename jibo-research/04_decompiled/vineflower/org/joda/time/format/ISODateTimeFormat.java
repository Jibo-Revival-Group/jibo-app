package org.joda.time.format;

import org.joda.time.DateTimeFieldType;

public class ISODateTimeFormat {
   public static DateTimeFormatter a() {
      return ISODateTimeFormat.Constants.ae;
   }

   public static DateTimeFormatter b() {
      return f();
   }

   public static DateTimeFormatter c() {
      return ISODateTimeFormat.Constants.A;
   }

   public static DateTimeFormatter d() {
      return ISODateTimeFormat.Constants.E;
   }

   public static DateTimeFormatter e() {
      return ISODateTimeFormat.Constants.q;
   }

   public static DateTimeFormatter f() {
      return ISODateTimeFormat.Constants.o;
   }

   public static DateTimeFormatter g() {
      return ISODateTimeFormat.Constants.h;
   }

   static final class Constants {
      private static final DateTimeFormatter A = p();
      private static final DateTimeFormatter B = q();
      private static final DateTimeFormatter C = r();
      private static final DateTimeFormatter D = s();
      private static final DateTimeFormatter E = t();
      private static final DateTimeFormatter F = u();
      private static final DateTimeFormatter G = y();
      private static final DateTimeFormatter H = z();
      private static final DateTimeFormatter I = v();
      private static final DateTimeFormatter J = w();
      private static final DateTimeFormatter K = x();
      private static final DateTimeFormatter L = A();
      private static final DateTimeFormatter M = B();
      private static final DateTimeFormatter N = C();
      private static final DateTimeFormatter O = D();
      private static final DateTimeFormatter P = E();
      private static final DateTimeFormatter Q = F();
      private static final DateTimeFormatter R = G();
      private static final DateTimeFormatter S = H();
      private static final DateTimeFormatter T = I();
      private static final DateTimeFormatter U = J();
      private static final DateTimeFormatter V = K();
      private static final DateTimeFormatter W = L();
      private static final DateTimeFormatter X = M();
      private static final DateTimeFormatter Y = i();
      private static final DateTimeFormatter Z = l();
      private static final DateTimeFormatter a = aa();
      private static final DateTimeFormatter aa = g();
      private static final DateTimeFormatter ab = h();
      private static final DateTimeFormatter ac = j();
      private static final DateTimeFormatter ad = k();
      private static final DateTimeFormatter ae = m();
      private static final DateTimeFormatter af = n();
      private static final DateTimeFormatter ag = o();
      private static final DateTimeFormatter b = ab();
      private static final DateTimeFormatter c = ac();
      private static final DateTimeFormatter d = ad();
      private static final DateTimeFormatter e = ae();
      private static final DateTimeFormatter f = af();
      private static final DateTimeFormatter g = ag();
      private static final DateTimeFormatter h = ai();
      private static final DateTimeFormatter i = aj();
      private static final DateTimeFormatter j = ak();
      private static final DateTimeFormatter k = al();
      private static final DateTimeFormatter l = am();
      private static final DateTimeFormatter m = ah();
      private static final DateTimeFormatter n = N();
      private static final DateTimeFormatter o = O();
      private static final DateTimeFormatter p = P();
      private static final DateTimeFormatter q = Q();
      private static final DateTimeFormatter r = R();
      private static final DateTimeFormatter s = S();
      private static final DateTimeFormatter t = T();
      private static final DateTimeFormatter u = U();
      private static final DateTimeFormatter v = V();
      private static final DateTimeFormatter w = W();
      private static final DateTimeFormatter x = X();
      private static final DateTimeFormatter y = Y();
      private static final DateTimeFormatter z = Z();

      private static DateTimeFormatter A() {
         DateTimeFormatter var0;
         if (L == null) {
            var0 = new DateTimeFormatterBuilder().e(4, 4).a(DateTimeFieldType.r(), 2).a(DateTimeFieldType.m(), 2).a();
         } else {
            var0 = L;
         }

         return var0;
      }

      private static DateTimeFormatter B() {
         DateTimeFormatter var0;
         if (M == null) {
            var0 = new DateTimeFormatterBuilder()
               .a(DateTimeFieldType.g(), 2)
               .a(DateTimeFieldType.e(), 2)
               .a(DateTimeFieldType.c(), 2)
               .a('.')
               .a(3, 9)
               .a("Z", false, 2, 2)
               .a();
         } else {
            var0 = M;
         }

         return var0;
      }

      private static DateTimeFormatter C() {
         DateTimeFormatter var0;
         if (N == null) {
            var0 = new DateTimeFormatterBuilder().a(DateTimeFieldType.g(), 2).a(DateTimeFieldType.e(), 2).a(DateTimeFieldType.c(), 2).a("Z", false, 2, 2).a();
         } else {
            var0 = N;
         }

         return var0;
      }

      private static DateTimeFormatter D() {
         DateTimeFormatter var0;
         if (O == null) {
            var0 = new DateTimeFormatterBuilder().a(ah()).a(B()).a();
         } else {
            var0 = O;
         }

         return var0;
      }

      private static DateTimeFormatter E() {
         DateTimeFormatter var0;
         if (P == null) {
            var0 = new DateTimeFormatterBuilder().a(ah()).a(C()).a();
         } else {
            var0 = P;
         }

         return var0;
      }

      private static DateTimeFormatter F() {
         DateTimeFormatter var0;
         if (Q == null) {
            var0 = new DateTimeFormatterBuilder().a(A()).a(D()).a();
         } else {
            var0 = Q;
         }

         return var0;
      }

      private static DateTimeFormatter G() {
         DateTimeFormatter var0;
         if (R == null) {
            var0 = new DateTimeFormatterBuilder().a(A()).a(E()).a();
         } else {
            var0 = R;
         }

         return var0;
      }

      private static DateTimeFormatter H() {
         DateTimeFormatter var0;
         if (S == null) {
            var0 = new DateTimeFormatterBuilder().e(4, 4).a(DateTimeFieldType.n(), 3).a();
         } else {
            var0 = S;
         }

         return var0;
      }

      private static DateTimeFormatter I() {
         DateTimeFormatter var0;
         if (T == null) {
            var0 = new DateTimeFormatterBuilder().a(H()).a(D()).a();
         } else {
            var0 = T;
         }

         return var0;
      }

      private static DateTimeFormatter J() {
         DateTimeFormatter var0;
         if (U == null) {
            var0 = new DateTimeFormatterBuilder().a(H()).a(E()).a();
         } else {
            var0 = U;
         }

         return var0;
      }

      private static DateTimeFormatter K() {
         DateTimeFormatter var0;
         if (V == null) {
            var0 = new DateTimeFormatterBuilder().d(4, 4).a('W').a(DateTimeFieldType.o(), 2).a(DateTimeFieldType.l(), 1).a();
         } else {
            var0 = V;
         }

         return var0;
      }

      private static DateTimeFormatter L() {
         DateTimeFormatter var0;
         if (W == null) {
            var0 = new DateTimeFormatterBuilder().a(K()).a(D()).a();
         } else {
            var0 = W;
         }

         return var0;
      }

      private static DateTimeFormatter M() {
         DateTimeFormatter var0;
         if (X == null) {
            var0 = new DateTimeFormatterBuilder().a(K()).a(E()).a();
         } else {
            var0 = X;
         }

         return var0;
      }

      private static DateTimeFormatter N() {
         DateTimeFormatter var0;
         if (n == null) {
            var0 = new DateTimeFormatterBuilder().a(aa()).a(ab()).a();
         } else {
            var0 = n;
         }

         return var0;
      }

      private static DateTimeFormatter O() {
         DateTimeFormatter var0;
         if (o == null) {
            var0 = new DateTimeFormatterBuilder().a(aa()).a(ab()).a(ac()).a();
         } else {
            var0 = o;
         }

         return var0;
      }

      private static DateTimeFormatter P() {
         DateTimeFormatter var0;
         if (p == null) {
            var0 = new DateTimeFormatterBuilder().a(ad()).a(ae()).a();
         } else {
            var0 = p;
         }

         return var0;
      }

      private static DateTimeFormatter Q() {
         DateTimeFormatter var0;
         if (q == null) {
            var0 = new DateTimeFormatterBuilder().a(ad()).a(ae()).a(af()).a();
         } else {
            var0 = q;
         }

         return var0;
      }

      private static DateTimeFormatter R() {
         DateTimeFormatter var0;
         if (r == null) {
            var0 = new DateTimeFormatterBuilder().a(ai()).a(aj()).a();
         } else {
            var0 = r;
         }

         return var0;
      }

      private static DateTimeFormatter S() {
         DateTimeFormatter var0;
         if (s == null) {
            var0 = new DateTimeFormatterBuilder().a(ai()).a(aj()).a(ak()).a();
         } else {
            var0 = s;
         }

         return var0;
      }

      private static DateTimeFormatter T() {
         DateTimeFormatter var0;
         if (t == null) {
            var0 = new DateTimeFormatterBuilder().a(ai()).a(aj()).a(ak()).a('.').a(3, 3).a();
         } else {
            var0 = t;
         }

         return var0;
      }

      private static DateTimeFormatter U() {
         DateTimeFormatter var0;
         if (u == null) {
            var0 = new DateTimeFormatterBuilder().a(ai()).a(aj()).a(ak()).a(al()).a();
         } else {
            var0 = u;
         }

         return var0;
      }

      private static DateTimeFormatter V() {
         DateTimeFormatter var0;
         if (v == null) {
            var0 = new DateTimeFormatterBuilder().a(ISODateTimeFormat.b()).a(ah()).a(ISODateTimeFormat.g()).a();
         } else {
            var0 = v;
         }

         return var0;
      }

      private static DateTimeFormatter W() {
         DateTimeFormatter var0;
         if (w == null) {
            var0 = new DateTimeFormatterBuilder().a(ISODateTimeFormat.b()).a(ah()).a(R()).a();
         } else {
            var0 = w;
         }

         return var0;
      }

      private static DateTimeFormatter X() {
         DateTimeFormatter var0;
         if (x == null) {
            var0 = new DateTimeFormatterBuilder().a(ISODateTimeFormat.b()).a(ah()).a(S()).a();
         } else {
            var0 = x;
         }

         return var0;
      }

      private static DateTimeFormatter Y() {
         DateTimeFormatter var0;
         if (y == null) {
            var0 = new DateTimeFormatterBuilder().a(ISODateTimeFormat.b()).a(ah()).a(T()).a();
         } else {
            var0 = y;
         }

         return var0;
      }

      private static DateTimeFormatter Z() {
         DateTimeFormatter var0;
         if (z == null) {
            var0 = new DateTimeFormatterBuilder().a(ISODateTimeFormat.b()).a(ah()).a(U()).a();
         } else {
            var0 = z;
         }

         return var0;
      }

      private static DateTimeFormatter aa() {
         DateTimeFormatter var0;
         if (a == null) {
            var0 = new DateTimeFormatterBuilder().e(4, 9).a();
         } else {
            var0 = a;
         }

         return var0;
      }

      private static DateTimeFormatter ab() {
         DateTimeFormatter var0;
         if (b == null) {
            var0 = new DateTimeFormatterBuilder().a('-').k(2).a();
         } else {
            var0 = b;
         }

         return var0;
      }

      private static DateTimeFormatter ac() {
         DateTimeFormatter var0;
         if (c == null) {
            var0 = new DateTimeFormatterBuilder().a('-').h(2).a();
         } else {
            var0 = c;
         }

         return var0;
      }

      private static DateTimeFormatter ad() {
         DateTimeFormatter var0;
         if (d == null) {
            var0 = new DateTimeFormatterBuilder().d(4, 9).a();
         } else {
            var0 = d;
         }

         return var0;
      }

      private static DateTimeFormatter ae() {
         DateTimeFormatter var0;
         if (e == null) {
            var0 = new DateTimeFormatterBuilder().a("-W").j(2).a();
         } else {
            var0 = e;
         }

         return var0;
      }

      private static DateTimeFormatter af() {
         DateTimeFormatter var0;
         if (f == null) {
            var0 = new DateTimeFormatterBuilder().a('-').g(1).a();
         } else {
            var0 = f;
         }

         return var0;
      }

      private static DateTimeFormatter ag() {
         DateTimeFormatter var0;
         if (g == null) {
            var0 = new DateTimeFormatterBuilder().a('-').i(3).a();
         } else {
            var0 = g;
         }

         return var0;
      }

      private static DateTimeFormatter ah() {
         DateTimeFormatter var0;
         if (m == null) {
            var0 = new DateTimeFormatterBuilder().a('T').a();
         } else {
            var0 = m;
         }

         return var0;
      }

      private static DateTimeFormatter ai() {
         DateTimeFormatter var0;
         if (h == null) {
            var0 = new DateTimeFormatterBuilder().c(2).a();
         } else {
            var0 = h;
         }

         return var0;
      }

      private static DateTimeFormatter aj() {
         DateTimeFormatter var0;
         if (i == null) {
            var0 = new DateTimeFormatterBuilder().a(':').b(2).a();
         } else {
            var0 = i;
         }

         return var0;
      }

      private static DateTimeFormatter ak() {
         DateTimeFormatter var0;
         if (j == null) {
            var0 = new DateTimeFormatterBuilder().a(':').a(2).a();
         } else {
            var0 = j;
         }

         return var0;
      }

      private static DateTimeFormatter al() {
         DateTimeFormatter var0;
         if (k == null) {
            var0 = new DateTimeFormatterBuilder().a('.').a(3, 9).a();
         } else {
            var0 = k;
         }

         return var0;
      }

      private static DateTimeFormatter am() {
         DateTimeFormatter var0;
         if (l == null) {
            var0 = new DateTimeFormatterBuilder().a("Z", true, 2, 4).a();
         } else {
            var0 = l;
         }

         return var0;
      }

      private static DateTimeFormatter g() {
         DateTimeFormatter var1;
         if (aa == null) {
            DateTimeParser var0 = new DateTimeFormatterBuilder().a('T').a(am()).b();
            var1 = new DateTimeFormatterBuilder().a(i()).b(var0).a();
         } else {
            var1 = aa;
         }

         return var1;
      }

      private static DateTimeFormatter h() {
         DateTimeFormatter var0;
         if (ab == null) {
            var0 = i().d();
         } else {
            var0 = ab;
         }

         return var0;
      }

      private static DateTimeFormatter i() {
         DateTimeFormatter var0;
         if (Y == null) {
            var0 = new DateTimeFormatterBuilder()
               .a(
                  null,
                  new DateTimeParser[]{
                     new DateTimeFormatterBuilder().a(aa()).b(new DateTimeFormatterBuilder().a(ab()).b(ac().b()).b()).b(),
                     new DateTimeFormatterBuilder().a(ad()).a(ae()).b(af().b()).b(),
                     new DateTimeFormatterBuilder().a(aa()).a(ag()).b()
                  }
               )
               .a();
         } else {
            var0 = Y;
         }

         return var0;
      }

      private static DateTimeFormatter j() {
         DateTimeFormatter var0;
         if (ac == null) {
            var0 = new DateTimeFormatterBuilder().b(ah().b()).a(l()).b(am().b()).a();
         } else {
            var0 = ac;
         }

         return var0;
      }

      private static DateTimeFormatter k() {
         DateTimeFormatter var0;
         if (ad == null) {
            var0 = new DateTimeFormatterBuilder().b(ah().b()).a(l()).a().d();
         } else {
            var0 = ad;
         }

         return var0;
      }

      private static DateTimeFormatter l() {
         DateTimeFormatter var1;
         if (Z == null) {
            DateTimeParser var0 = new DateTimeFormatterBuilder()
               .a(null, new DateTimeParser[]{new DateTimeFormatterBuilder().a('.').b(), new DateTimeFormatterBuilder().a(',').b()})
               .b();
            var1 = new DateTimeFormatterBuilder()
               .a(ai())
               .a(
                  null,
                  new DateTimeParser[]{
                     new DateTimeFormatterBuilder()
                        .a(aj())
                        .a(
                           null,
                           new DateTimeParser[]{
                              new DateTimeFormatterBuilder().a(ak()).b(new DateTimeFormatterBuilder().a(var0).a(1, 9).b()).b(),
                              new DateTimeFormatterBuilder().a(var0).b(1, 9).b(),
                              null
                           }
                        )
                        .b(),
                     new DateTimeFormatterBuilder().a(var0).c(1, 9).b(),
                     null
                  }
               )
               .a();
         } else {
            var1 = Z;
         }

         return var1;
      }

      private static DateTimeFormatter m() {
         DateTimeFormatter var1;
         if (ae == null) {
            DateTimeParser var0 = new DateTimeFormatterBuilder().a('T').a(l()).b(am().b()).b();
            var1 = new DateTimeFormatterBuilder().a(null, new DateTimeParser[]{var0, n().b()}).a();
         } else {
            var1 = ae;
         }

         return var1;
      }

      private static DateTimeFormatter n() {
         DateTimeFormatter var1;
         if (af == null) {
            DateTimeParser var0 = new DateTimeFormatterBuilder().a('T').b(l().b()).b(am().b()).b();
            var1 = new DateTimeFormatterBuilder().a(i()).b(var0).a();
         } else {
            var1 = af;
         }

         return var1;
      }

      private static DateTimeFormatter o() {
         DateTimeFormatter var1;
         if (ag == null) {
            DateTimeParser var0 = new DateTimeFormatterBuilder().a('T').a(l()).b();
            var1 = new DateTimeFormatterBuilder().a(i()).b(var0).a().d();
         } else {
            var1 = ag;
         }

         return var1;
      }

      private static DateTimeFormatter p() {
         DateTimeFormatter var0;
         if (A == null) {
            var0 = new DateTimeFormatterBuilder().a(U()).a(am()).a();
         } else {
            var0 = A;
         }

         return var0;
      }

      private static DateTimeFormatter q() {
         DateTimeFormatter var0;
         if (B == null) {
            var0 = new DateTimeFormatterBuilder().a(S()).a(am()).a();
         } else {
            var0 = B;
         }

         return var0;
      }

      private static DateTimeFormatter r() {
         DateTimeFormatter var0;
         if (C == null) {
            var0 = new DateTimeFormatterBuilder().a(ah()).a(p()).a();
         } else {
            var0 = C;
         }

         return var0;
      }

      private static DateTimeFormatter s() {
         DateTimeFormatter var0;
         if (D == null) {
            var0 = new DateTimeFormatterBuilder().a(ah()).a(q()).a();
         } else {
            var0 = D;
         }

         return var0;
      }

      private static DateTimeFormatter t() {
         DateTimeFormatter var0;
         if (E == null) {
            var0 = new DateTimeFormatterBuilder().a(ISODateTimeFormat.b()).a(r()).a();
         } else {
            var0 = E;
         }

         return var0;
      }

      private static DateTimeFormatter u() {
         DateTimeFormatter var0;
         if (F == null) {
            var0 = new DateTimeFormatterBuilder().a(ISODateTimeFormat.b()).a(s()).a();
         } else {
            var0 = F;
         }

         return var0;
      }

      private static DateTimeFormatter v() {
         DateTimeFormatter var0;
         if (I == null) {
            var0 = new DateTimeFormatterBuilder().a(aa()).a(ag()).a();
         } else {
            var0 = I;
         }

         return var0;
      }

      private static DateTimeFormatter w() {
         DateTimeFormatter var0;
         if (J == null) {
            var0 = new DateTimeFormatterBuilder().a(v()).a(r()).a();
         } else {
            var0 = J;
         }

         return var0;
      }

      private static DateTimeFormatter x() {
         DateTimeFormatter var0;
         if (K == null) {
            var0 = new DateTimeFormatterBuilder().a(v()).a(s()).a();
         } else {
            var0 = K;
         }

         return var0;
      }

      private static DateTimeFormatter y() {
         DateTimeFormatter var0;
         if (G == null) {
            var0 = new DateTimeFormatterBuilder().a(ISODateTimeFormat.e()).a(r()).a();
         } else {
            var0 = G;
         }

         return var0;
      }

      private static DateTimeFormatter z() {
         DateTimeFormatter var0;
         if (H == null) {
            var0 = new DateTimeFormatterBuilder().a(ISODateTimeFormat.e()).a(s()).a();
         } else {
            var0 = H;
         }

         return var0;
      }
   }
}
