package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public final class zzfkq extends zzfjm<zzfkq> implements Cloneable {
   public long a = 0L;
   public long b = 0L;
   public byte[] c;
   public long d;
   public byte[] e;
   private long f = 0L;
   private String g = "";
   private int h = 0;
   private int i = 0;
   private boolean j = false;
   private zzfkr[] k = zzfkr.a();
   private byte[] l = zzfjv.h;
   private zzfko m = null;
   private String n;
   private String o;
   private zzfkn p;
   private String q;
   private zzfkp r;
   private String s;
   private int t;
   private int[] u;
   private long v;
   private zzfks w;

   public zzfkq() {
      this.c = zzfjv.h;
      this.n = "";
      this.o = "";
      this.p = null;
      this.q = "";
      this.d = 180000L;
      this.r = null;
      this.e = zzfjv.h;
      this.s = "";
      this.t = 0;
      this.u = zzfjv.a;
      this.v = 0L;
      this.w = null;
      this.H = null;
      this.I = -1;
   }

   private final zzfkq a() {
      zzfkq var2;
      try {
         var2 = (zzfkq)super.c();
      } catch (CloneNotSupportedException var3) {
         throw new AssertionError(var3);
      }

      if (this.k != null && this.k.length > 0) {
         var2.k = new zzfkr[this.k.length];

         for (int var1 = 0; var1 < this.k.length; var1++) {
            if (this.k[var1] != null) {
               var2.k[var1] = (zzfkr)this.k[var1].clone();
            }
         }
      }

      if (this.m != null) {
         var2.m = (zzfko)this.m.clone();
      }

      if (this.p != null) {
         var2.p = (zzfkn)this.p.clone();
      }

      if (this.r != null) {
         var2.r = (zzfkp)this.r.clone();
      }

      if (this.u != null && this.u.length > 0) {
         var2.u = (int[])this.u.clone();
      }

      if (this.w != null) {
         var2.w = (zzfks)this.w.clone();
      }

      return var2;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private final zzfkq b(zzfjj var1) throws IOException {
      while (true) {
         int var2 = var1.a();
         int var19;
         zzfkr[] var23;
         switch (var2) {
            case 8:
               this.a = var1.b();
               continue;
            case 18:
               this.g = var1.e();
               continue;
            case 26:
               var19 = zzfjv.a(var1, 26);
               if (this.k == null) {
                  var2 = 0;
               } else {
                  var2 = this.k.length;
               }

               var23 = new zzfkr[var19 + var2];
               var19 = var2;
               if (var2 != 0) {
                  System.arraycopy(this.k, 0, var23, 0, var2);
                  var19 = var2;
               }
               break;
            case 34:
               this.l = var1.f();
               continue;
            case 50:
               this.c = var1.f();
               continue;
            case 58:
               if (this.p == null) {
                  this.p = new zzfkn();
               }

               var1.a(this.p);
               continue;
            case 66:
               this.n = var1.e();
               continue;
            case 74:
               if (this.m == null) {
                  this.m = new zzfko();
               }

               var1.a(this.m);
               continue;
            case 80:
               this.j = var1.d();
               continue;
            case 88:
               this.h = var1.c();
               continue;
            case 96:
               this.i = var1.c();
               continue;
            case 106:
               this.o = var1.e();
               continue;
            case 114:
               this.q = var1.e();
               continue;
            case 120:
               this.d = var1.g();
               continue;
            case 130:
               if (this.r == null) {
                  this.r = new zzfkp();
               }

               var1.a(this.r);
               continue;
            case 136:
               this.b = var1.b();
               continue;
            case 146:
               this.e = var1.f();
               continue;
            case 152:
               int var20 = var1.m();

               try {
                  var19 = var1.c();
               } catch (IllegalArgumentException var9) {
                  var1.e(var20);
                  this.a(var1, var2);
                  continue;
               }

               switch (var19) {
                  case 0:
                  case 1:
                  case 2:
                     try {
                        this.t = var19;
                     } catch (IllegalArgumentException var7) {
                        var1.e(var20);
                        this.a(var1, var2);
                     }
                     continue;
                  default:
                     try {
                        StringBuilder var22 = new StringBuilder(45);
                        IllegalArgumentException var6 = new IllegalArgumentException(
                           var22.append(var19).append(" is not a valid enum InternalEvent").toString()
                        );
                        throw var6;
                     } catch (IllegalArgumentException var8) {
                        var1.e(var20);
                        this.a(var1, var2);
                        continue;
                     }
               }
            case 160:
               var19 = zzfjv.a(var1, 160);
               if (this.u == null) {
                  var2 = 0;
               } else {
                  var2 = this.u.length;
               }

               int[] var21 = new int[var19 + var2];
               var19 = var2;
               if (var2 != 0) {
                  System.arraycopy(this.u, 0, var21, 0, var2);
                  var19 = var2;
               }

               while (var19 < var21.length - 1) {
                  var21[var19] = var1.c();
                  var1.a();
                  var19++;
               }

               var21[var19] = var1.c();
               this.u = var21;
               continue;
            case 162:
               int var4 = var1.c(var1.h());
               var2 = var1.m();

               for (var19 = 0; var1.l() > 0; var19++) {
                  var1.c();
               }

               var1.e(var2);
               if (this.u == null) {
                  var2 = 0;
               } else {
                  var2 = this.u.length;
               }

               int[] var5 = new int[var19 + var2];
               var19 = var2;
               if (var2 != 0) {
                  System.arraycopy(this.u, 0, var5, 0, var2);
                  var19 = var2;
               }

               while (var19 < var5.length) {
                  var5[var19] = var1.c();
                  var19++;
               }

               this.u = var5;
               var1.d(var4);
               continue;
            case 168:
               this.f = var1.b();
               continue;
            case 176:
               this.v = var1.b();
               continue;
            case 186:
               if (this.w == null) {
                  this.w = new zzfks();
               }

               var1.a(this.w);
               continue;
            case 194:
               this.s = var1.e();
               continue;
            default:
               if (super.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
         }

         while (var19 < var23.length - 1) {
            var23[var19] = new zzfkr();
            var1.a(var23[var19]);
            var1.a();
            var19++;
         }

         var23[var19] = new zzfkr();
         var1.a(var23[var19]);
         this.k = var23;
      }
   }

   @Override
   public final void a(zzfjk var1) throws IOException {
      byte var3 = 0;
      if (this.a != 0L) {
         var1.b(1, this.a);
      }

      if (this.g != null && !this.g.equals("")) {
         var1.a(2, this.g);
      }

      if (this.k != null && this.k.length > 0) {
         for (int var2 = 0; var2 < this.k.length; var2++) {
            zzfkr var4 = this.k[var2];
            if (var4 != null) {
               var1.a(3, var4);
            }
         }
      }

      if (!Arrays.equals(this.l, zzfjv.h)) {
         var1.a(4, this.l);
      }

      if (!Arrays.equals(this.c, zzfjv.h)) {
         var1.a(6, this.c);
      }

      if (this.p != null) {
         var1.a(7, this.p);
      }

      if (this.n != null && !this.n.equals("")) {
         var1.a(8, this.n);
      }

      if (this.m != null) {
         var1.a(9, this.m);
      }

      if (this.j) {
         var1.a(10, this.j);
      }

      if (this.h != 0) {
         var1.a(11, this.h);
      }

      if (this.i != 0) {
         var1.a(12, this.i);
      }

      if (this.o != null && !this.o.equals("")) {
         var1.a(13, this.o);
      }

      if (this.q != null && !this.q.equals("")) {
         var1.a(14, this.q);
      }

      if (this.d != 180000L) {
         var1.c(15, this.d);
      }

      if (this.r != null) {
         var1.a(16, this.r);
      }

      if (this.b != 0L) {
         var1.b(17, this.b);
      }

      if (!Arrays.equals(this.e, zzfjv.h)) {
         var1.a(18, this.e);
      }

      if (this.t != 0) {
         var1.a(19, this.t);
      }

      if (this.u != null && this.u.length > 0) {
         for (int var5 = var3; var5 < this.u.length; var5++) {
            var1.a(20, this.u[var5]);
         }
      }

      if (this.f != 0L) {
         var1.b(21, this.f);
      }

      if (this.v != 0L) {
         var1.b(22, this.v);
      }

      if (this.w != null) {
         var1.a(23, this.w);
      }

      if (this.s != null && !this.s.equals("")) {
         var1.a(24, this.s);
      }

      super.a(var1);
   }

   @Override
   protected final int b() {
      byte var4 = 0;
      int var1 = super.b();
      int var2 = var1;
      if (this.a != 0L) {
         var2 = var1 + zzfjk.d(1, this.a);
      }

      var1 = var2;
      if (this.g != null) {
         var1 = var2;
         if (!this.g.equals("")) {
            var1 = var2 + zzfjk.b(2, this.g);
         }
      }

      var2 = var1;
      if (this.k != null) {
         var2 = var1;
         if (this.k.length > 0) {
            int var3 = 0;

            while (var3 < this.k.length) {
               zzfkr var5 = this.k[var3];
               var2 = var1;
               if (var5 != null) {
                  var2 = var1 + zzfjk.b(3, var5);
               }

               var3++;
               var1 = var2;
            }

            var2 = var1;
         }
      }

      var1 = var2;
      if (!Arrays.equals(this.l, zzfjv.h)) {
         var1 = var2 + zzfjk.b(4, this.l);
      }

      var2 = var1;
      if (!Arrays.equals(this.c, zzfjv.h)) {
         var2 = var1 + zzfjk.b(6, this.c);
      }

      var1 = var2;
      if (this.p != null) {
         var1 = var2 + zzfjk.b(7, this.p);
      }

      var2 = var1;
      if (this.n != null) {
         var2 = var1;
         if (!this.n.equals("")) {
            var2 = var1 + zzfjk.b(8, this.n);
         }
      }

      var1 = var2;
      if (this.m != null) {
         var1 = var2 + zzfjk.b(9, this.m);
      }

      int var28 = var1;
      if (this.j) {
         var28 = var1 + zzfjk.b(10) + 1;
      }

      var2 = var28;
      if (this.h != 0) {
         var2 = var28 + zzfjk.b(11, this.h);
      }

      var1 = var2;
      if (this.i != 0) {
         var1 = var2 + zzfjk.b(12, this.i);
      }

      var2 = var1;
      if (this.o != null) {
         var2 = var1;
         if (!this.o.equals("")) {
            var2 = var1 + zzfjk.b(13, this.o);
         }
      }

      var1 = var2;
      if (this.q != null) {
         var1 = var2;
         if (!this.q.equals("")) {
            var1 = var2 + zzfjk.b(14, this.q);
         }
      }

      var2 = var1;
      if (this.d != 180000L) {
         var2 = var1 + zzfjk.e(15, this.d);
      }

      var28 = var2;
      if (this.r != null) {
         var28 = var2 + zzfjk.b(16, this.r);
      }

      var1 = var28;
      if (this.b != 0L) {
         var1 = var28 + zzfjk.d(17, this.b);
      }

      var2 = var1;
      if (!Arrays.equals(this.e, zzfjv.h)) {
         var2 = var1 + zzfjk.b(18, this.e);
      }

      var1 = var2;
      if (this.t != 0) {
         var1 = var2 + zzfjk.b(19, this.t);
      }

      var2 = var1;
      if (this.u != null) {
         var2 = var1;
         if (this.u.length > 0) {
            var28 = 0;

            for (int var25 = var4; var25 < this.u.length; var25++) {
               var28 += zzfjk.a(this.u[var25]);
            }

            var2 = var1 + var28 + this.u.length * 2;
         }
      }

      var1 = var2;
      if (this.f != 0L) {
         var1 = var2 + zzfjk.d(21, this.f);
      }

      var2 = var1;
      if (this.v != 0L) {
         var2 = var1 + zzfjk.d(22, this.v);
      }

      var1 = var2;
      if (this.w != null) {
         var1 = var2 + zzfjk.b(23, this.w);
      }

      var2 = var1;
      if (this.s != null) {
         var2 = var1;
         if (!this.s.equals("")) {
            var2 = var1 + zzfjk.b(24, this.s);
         }
      }

      return var2;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var3 = true;
      boolean var2;
      if (var1 == this) {
         var2 = var3;
      } else if (!(var1 instanceof zzfkq)) {
         var2 = false;
      } else {
         var1 = var1;
         if (this.a != var1.a) {
            var2 = false;
         } else if (this.b != var1.b) {
            var2 = false;
         } else if (this.f != var1.f) {
            var2 = false;
         } else {
            if (this.g == null) {
               if (var1.g != null) {
                  var2 = false;
                  return var2;
               }
            } else if (!this.g.equals(var1.g)) {
               var2 = false;
               return var2;
            }

            if (this.h != var1.h) {
               var2 = false;
            } else if (this.i != var1.i) {
               var2 = false;
            } else if (this.j != var1.j) {
               var2 = false;
            } else if (!zzfjq.a(this.k, var1.k)) {
               var2 = false;
            } else if (!Arrays.equals(this.l, var1.l)) {
               var2 = false;
            } else {
               if (this.m == null) {
                  if (var1.m != null) {
                     var2 = false;
                     return var2;
                  }
               } else if (!this.m.equals(var1.m)) {
                  var2 = false;
                  return var2;
               }

               if (!Arrays.equals(this.c, var1.c)) {
                  var2 = false;
               } else {
                  if (this.n == null) {
                     if (var1.n != null) {
                        var2 = false;
                        return var2;
                     }
                  } else if (!this.n.equals(var1.n)) {
                     var2 = false;
                     return var2;
                  }

                  if (this.o == null) {
                     if (var1.o != null) {
                        var2 = false;
                        return var2;
                     }
                  } else if (!this.o.equals(var1.o)) {
                     var2 = false;
                     return var2;
                  }

                  if (this.p == null) {
                     if (var1.p != null) {
                        var2 = false;
                        return var2;
                     }
                  } else if (!this.p.equals(var1.p)) {
                     var2 = false;
                     return var2;
                  }

                  if (this.q == null) {
                     if (var1.q != null) {
                        var2 = false;
                        return var2;
                     }
                  } else if (!this.q.equals(var1.q)) {
                     var2 = false;
                     return var2;
                  }

                  if (this.d != var1.d) {
                     var2 = false;
                  } else {
                     if (this.r == null) {
                        if (var1.r != null) {
                           var2 = false;
                           return var2;
                        }
                     } else if (!this.r.equals(var1.r)) {
                        var2 = false;
                        return var2;
                     }

                     if (!Arrays.equals(this.e, var1.e)) {
                        var2 = false;
                     } else {
                        if (this.s == null) {
                           if (var1.s != null) {
                              var2 = false;
                              return var2;
                           }
                        } else if (!this.s.equals(var1.s)) {
                           var2 = false;
                           return var2;
                        }

                        if (this.t != var1.t) {
                           var2 = false;
                        } else if (!zzfjq.a(this.u, var1.u)) {
                           var2 = false;
                        } else if (this.v != var1.v) {
                           var2 = false;
                        } else {
                           if (this.w == null) {
                              if (var1.w != null) {
                                 var2 = false;
                                 return var2;
                              }
                           } else if (!this.w.equals(var1.w)) {
                              var2 = false;
                              return var2;
                           }

                           if (this.H != null && !this.H.b()) {
                              var2 = this.H.equals(var1.H);
                           } else {
                              var2 = var3;
                              if (var1.H != null) {
                                 var2 = var3;
                                 if (!var1.H.b()) {
                                    var2 = false;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      byte var12 = 0;
      int var15 = this.getClass().getName().hashCode();
      int var14 = (int)(this.a ^ this.a >>> 32);
      int var13 = (int)(this.b ^ this.b >>> 32);
      int var16 = (int)(this.f ^ this.f >>> 32);
      int var1;
      if (this.g == null) {
         var1 = 0;
      } else {
         var1 = this.g.hashCode();
      }

      int var17 = this.h;
      int var18 = this.i;
      short var2;
      if (this.j) {
         var2 = 1231;
      } else {
         var2 = 1237;
      }

      int var19 = zzfjq.a(this.k);
      int var20 = Arrays.hashCode(this.l);
      zzfko var27 = this.m;
      int var3;
      if (var27 == null) {
         var3 = 0;
      } else {
         var3 = var27.hashCode();
      }

      int var21 = Arrays.hashCode(this.c);
      int var4;
      if (this.n == null) {
         var4 = 0;
      } else {
         var4 = this.n.hashCode();
      }

      int var5;
      if (this.o == null) {
         var5 = 0;
      } else {
         var5 = this.o.hashCode();
      }

      zzfkn var28 = this.p;
      int var6;
      if (var28 == null) {
         var6 = 0;
      } else {
         var6 = var28.hashCode();
      }

      int var7;
      if (this.q == null) {
         var7 = 0;
      } else {
         var7 = this.q.hashCode();
      }

      int var22 = (int)(this.d ^ this.d >>> 32);
      zzfkp var29 = this.r;
      int var8;
      if (var29 == null) {
         var8 = 0;
      } else {
         var8 = var29.hashCode();
      }

      int var23 = Arrays.hashCode(this.e);
      int var9;
      if (this.s == null) {
         var9 = 0;
      } else {
         var9 = this.s.hashCode();
      }

      int var26 = this.t;
      int var25 = zzfjq.a(this.u);
      int var24 = (int)(this.v ^ this.v >>> 32);
      zzfks var30 = this.w;
      int var10;
      if (var30 == null) {
         var10 = 0;
      } else {
         var10 = var30.hashCode();
      }

      int var11 = var12;
      if (this.H != null) {
         if (this.H.b()) {
            var11 = var12;
         } else {
            var11 = this.H.hashCode();
         }
      }

      return (
               var10
                  + (
                        (
                                 (
                                          (
                                                   var9
                                                      + (
                                                            (
                                                                     var8
                                                                        + (
                                                                              (
                                                                                       var7
                                                                                          + (
                                                                                                var6
                                                                                                   + (
                                                                                                         var5
                                                                                                            + (
                                                                                                                  var4
                                                                                                                     + (
                                                                                                                           (
                                                                                                                                    var3
                                                                                                                                       + (
                                                                                                                                             (
                                                                                                                                                      (
                                                                                                                                                               var2
                                                                                                                                                                  + (
                                                                                                                                                                        (
                                                                                                                                                                                 (
                                                                                                                                                                                          var1
                                                                                                                                                                                             + (
                                                                                                                                                                                                   (
                                                                                                                                                                                                            (
                                                                                                                                                                                                                     (
                                                                                                                                                                                                                              var15
                                                                                                                                                                                                                                 + 527
                                                                                                                                                                                                                           )
                                                                                                                                                                                                                           * 31
                                                                                                                                                                                                                        + var14
                                                                                                                                                                                                                  )
                                                                                                                                                                                                                  * 31
                                                                                                                                                                                                               + var13
                                                                                                                                                                                                         )
                                                                                                                                                                                                         * 31
                                                                                                                                                                                                      + var16
                                                                                                                                                                                                )
                                                                                                                                                                                                * 31
                                                                                                                                                                                       )
                                                                                                                                                                                       * 31
                                                                                                                                                                                    + var17
                                                                                                                                                                              )
                                                                                                                                                                              * 31
                                                                                                                                                                           + var18
                                                                                                                                                                     )
                                                                                                                                                                     * 31
                                                                                                                                                            )
                                                                                                                                                            * 31
                                                                                                                                                         + var19
                                                                                                                                                   )
                                                                                                                                                   * 31
                                                                                                                                                + var20
                                                                                                                                          )
                                                                                                                                          * 31
                                                                                                                                 )
                                                                                                                                 * 31
                                                                                                                              + var21
                                                                                                                        )
                                                                                                                        * 31
                                                                                                               )
                                                                                                               * 31
                                                                                                      )
                                                                                                      * 31
                                                                                             )
                                                                                             * 31
                                                                                    )
                                                                                    * 31
                                                                                 + var22
                                                                           )
                                                                           * 31
                                                                  )
                                                                  * 31
                                                               + var23
                                                         )
                                                         * 31
                                                )
                                                * 31
                                             + var26
                                       )
                                       * 31
                                    + var25
                              )
                              * 31
                           + var24
                     )
                     * 31
            )
            * 31
         + var11;
   }
}
