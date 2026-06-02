package com.google.android.gms.internal;

import java.io.IOException;

public final class zzewv extends zzfjm<zzewv> {
   public String a = null;
   public Integer b = null;
   public Long c = null;
   public Long d = null;
   public Integer e = null;
   public Integer f = null;
   public String g = null;
   public Long h = null;
   public Long i = null;
   public Long j = null;
   public Long k = null;
   public zzeww[] l = zzeww.a();

   public zzewv() {
      this.H = null;
      this.I = -1;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private final zzewv b(zzfjj var1) throws IOException {
      while (true) {
         int var2 = var1.a();
         zzeww[] var5;
         int var14;
         switch (var2) {
            case 10:
               this.a = var1.e();
               continue;
            case 16:
               var14 = var1.m();

               int var17;
               try {
                  var17 = var1.h();
               } catch (IllegalArgumentException var12) {
                  var1.e(var14);
                  this.a(var1, var2);
                  continue;
               }

               switch (var17) {
                  case 0:
                  case 1:
                  case 2:
                  case 3:
                  case 4:
                  case 5:
                  case 6:
                  case 7:
                  case 8:
                  case 9:
                     try {
                        this.b = var17;
                     } catch (IllegalArgumentException var10) {
                        var1.e(var14);
                        this.a(var1, var2);
                     }
                     continue;
                  default:
                     try {
                        StringBuilder var19 = new StringBuilder(42);
                        IllegalArgumentException var20 = new IllegalArgumentException(var19.append(var17).append(" is not a valid enum HttpMethod").toString());
                        throw var20;
                     } catch (IllegalArgumentException var11) {
                        var1.e(var14);
                        this.a(var1, var2);
                        continue;
                     }
               }
            case 24:
               this.c = var1.i();
               continue;
            case 32:
               this.d = var1.i();
               continue;
            case 40:
               this.f = var1.h();
               continue;
            case 50:
               this.g = var1.e();
               continue;
            case 56:
               this.h = var1.i();
               continue;
            case 64:
               this.i = var1.i();
               continue;
            case 72:
               this.j = var1.i();
               continue;
            case 80:
               this.k = var1.i();
               continue;
            case 88:
               int var4 = var1.m();

               try {
                  var14 = var1.h();
               } catch (IllegalArgumentException var9) {
                  var1.e(var4);
                  this.a(var1, var2);
                  continue;
               }

               switch (var14) {
                  case 0:
                  case 1:
                     try {
                        this.e = var14;
                     } catch (IllegalArgumentException var7) {
                        var1.e(var4);
                        this.a(var1, var2);
                     }
                     continue;
                  default:
                     try {
                        StringBuilder var6 = new StringBuilder(56);
                        IllegalArgumentException var18 = new IllegalArgumentException(
                           var6.append(var14).append(" is not a valid enum NetworkClientErrorReason").toString()
                        );
                        throw var18;
                     } catch (IllegalArgumentException var8) {
                        var1.e(var4);
                        this.a(var1, var2);
                        continue;
                     }
               }
            case 98:
               var14 = zzfjv.a(var1, 98);
               if (this.l == null) {
                  var2 = 0;
               } else {
                  var2 = this.l.length;
               }

               var5 = new zzeww[var14 + var2];
               var14 = var2;
               if (var2 != 0) {
                  System.arraycopy(this.l, 0, var5, 0, var2);
                  var14 = var2;
               }
               break;
            default:
               if (super.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
         }

         while (var14 < var5.length - 1) {
            var5[var14] = new zzeww();
            var1.a(var5[var14]);
            var1.a();
            var14++;
         }

         var5[var14] = new zzeww();
         var1.a(var5[var14]);
         this.l = var5;
      }
   }

   @Override
   public final void a(zzfjk var1) throws IOException {
      if (this.a != null) {
         var1.a(1, this.a);
      }

      if (this.b != null) {
         var1.a(2, this.b);
      }

      if (this.c != null) {
         var1.b(3, this.c);
      }

      if (this.d != null) {
         var1.b(4, this.d);
      }

      if (this.f != null) {
         var1.a(5, this.f);
      }

      if (this.g != null) {
         var1.a(6, this.g);
      }

      if (this.h != null) {
         var1.b(7, this.h);
      }

      if (this.i != null) {
         var1.b(8, this.i);
      }

      if (this.j != null) {
         var1.b(9, this.j);
      }

      if (this.k != null) {
         var1.b(10, this.k);
      }

      if (this.e != null) {
         var1.a(11, this.e);
      }

      if (this.l != null && this.l.length > 0) {
         for (int var2 = 0; var2 < this.l.length; var2++) {
            zzeww var3 = this.l[var2];
            if (var3 != null) {
               var1.a(12, var3);
            }
         }
      }

      super.a(var1);
   }

   @Override
   protected final int b() {
      int var2 = super.b();
      int var1 = var2;
      if (this.a != null) {
         var1 = var2 + zzfjk.b(1, this.a);
      }

      var2 = var1;
      if (this.b != null) {
         var2 = var1 + zzfjk.b(2, this.b);
      }

      var1 = var2;
      if (this.c != null) {
         var1 = var2 + zzfjk.d(3, this.c);
      }

      var2 = var1;
      if (this.d != null) {
         var2 = var1 + zzfjk.d(4, this.d);
      }

      var1 = var2;
      if (this.f != null) {
         var1 = var2 + zzfjk.b(5, this.f);
      }

      var2 = var1;
      if (this.g != null) {
         var2 = var1 + zzfjk.b(6, this.g);
      }

      var1 = var2;
      if (this.h != null) {
         var1 = var2 + zzfjk.d(7, this.h);
      }

      var2 = var1;
      if (this.i != null) {
         var2 = var1 + zzfjk.d(8, this.i);
      }

      var1 = var2;
      if (this.j != null) {
         var1 = var2 + zzfjk.d(9, this.j);
      }

      var2 = var1;
      if (this.k != null) {
         var2 = var1 + zzfjk.d(10, this.k);
      }

      var1 = var2;
      if (this.e != null) {
         var1 = var2 + zzfjk.b(11, this.e);
      }

      var2 = var1;
      if (this.l != null) {
         var2 = var1;
         if (this.l.length > 0) {
            var2 = 0;

            while (var2 < this.l.length) {
               zzeww var4 = this.l[var2];
               int var3 = var1;
               if (var4 != null) {
                  var3 = var1 + zzfjk.b(12, var4);
               }

               var2++;
               var1 = var3;
            }

            var2 = var1;
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
      } else if (!(var1 instanceof zzewv)) {
         var2 = false;
      } else {
         var1 = var1;
         if (this.a == null) {
            if (var1.a != null) {
               var2 = false;
               return var2;
            }
         } else if (!this.a.equals(var1.a)) {
            var2 = false;
            return var2;
         }

         if (this.b == null) {
            if (var1.b != null) {
               var2 = false;
               return var2;
            }
         } else if (!this.b.equals(var1.b)) {
            var2 = false;
            return var2;
         }

         if (this.c == null) {
            if (var1.c != null) {
               var2 = false;
               return var2;
            }
         } else if (!this.c.equals(var1.c)) {
            var2 = false;
            return var2;
         }

         if (this.d == null) {
            if (var1.d != null) {
               var2 = false;
               return var2;
            }
         } else if (!this.d.equals(var1.d)) {
            var2 = false;
            return var2;
         }

         if (this.e == null) {
            if (var1.e != null) {
               var2 = false;
               return var2;
            }
         } else if (!this.e.equals(var1.e)) {
            var2 = false;
            return var2;
         }

         if (this.f == null) {
            if (var1.f != null) {
               var2 = false;
               return var2;
            }
         } else if (!this.f.equals(var1.f)) {
            var2 = false;
            return var2;
         }

         if (this.g == null) {
            if (var1.g != null) {
               var2 = false;
               return var2;
            }
         } else if (!this.g.equals(var1.g)) {
            var2 = false;
            return var2;
         }

         if (this.h == null) {
            if (var1.h != null) {
               var2 = false;
               return var2;
            }
         } else if (!this.h.equals(var1.h)) {
            var2 = false;
            return var2;
         }

         if (this.i == null) {
            if (var1.i != null) {
               var2 = false;
               return var2;
            }
         } else if (!this.i.equals(var1.i)) {
            var2 = false;
            return var2;
         }

         if (this.j == null) {
            if (var1.j != null) {
               var2 = false;
               return var2;
            }
         } else if (!this.j.equals(var1.j)) {
            var2 = false;
            return var2;
         }

         if (this.k == null) {
            if (var1.k != null) {
               var2 = false;
               return var2;
            }
         } else if (!this.k.equals(var1.k)) {
            var2 = false;
            return var2;
         }

         if (!zzfjq.a(this.l, var1.l)) {
            var2 = false;
         } else if (this.H != null && !this.H.b()) {
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

      return var2;
   }

   @Override
   public final int hashCode() {
      byte var13 = 0;
      int var14 = this.getClass().getName().hashCode();
      int var1;
      if (this.a == null) {
         var1 = 0;
      } else {
         var1 = this.a.hashCode();
      }

      int var2;
      if (this.b == null) {
         var2 = 0;
      } else {
         var2 = this.b;
      }

      int var3;
      if (this.c == null) {
         var3 = 0;
      } else {
         var3 = this.c.hashCode();
      }

      int var4;
      if (this.d == null) {
         var4 = 0;
      } else {
         var4 = this.d.hashCode();
      }

      int var5;
      if (this.e == null) {
         var5 = 0;
      } else {
         var5 = this.e;
      }

      int var6;
      if (this.f == null) {
         var6 = 0;
      } else {
         var6 = this.f.hashCode();
      }

      int var7;
      if (this.g == null) {
         var7 = 0;
      } else {
         var7 = this.g.hashCode();
      }

      int var8;
      if (this.h == null) {
         var8 = 0;
      } else {
         var8 = this.h.hashCode();
      }

      int var9;
      if (this.i == null) {
         var9 = 0;
      } else {
         var9 = this.i.hashCode();
      }

      int var10;
      if (this.j == null) {
         var10 = 0;
      } else {
         var10 = this.j.hashCode();
      }

      int var11;
      if (this.k == null) {
         var11 = 0;
      } else {
         var11 = this.k.hashCode();
      }

      int var15 = zzfjq.a(this.l);
      int var12 = var13;
      if (this.H != null) {
         if (this.H.b()) {
            var12 = var13;
         } else {
            var12 = this.H.hashCode();
         }
      }

      return (
               (
                        var11
                           + (
                                 var10
                                    + (
                                          var9
                                             + (
                                                   var8
                                                      + (
                                                            var7
                                                               + (
                                                                     var6
                                                                        + (var5 + (var4 + (var3 + (var2 + (var1 + (var14 + 527) * 31) * 31) * 31) * 31) * 31)
                                                                           * 31
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
                     )
                     * 31
                  + var15
            )
            * 31
         + var12;
   }
}
