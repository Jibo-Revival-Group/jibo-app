package com.google.android.gms.internal;

import java.io.IOException;

public final class zzews extends zzfjm<zzews> {
   public String a = null;
   public String b = null;
   public zzewr c = null;
   public Integer d;
   public zzewt[] e;
   private zzewu f = null;

   public zzews() {
      this.d = null;
      this.e = zzewt.a();
      this.H = null;
      this.I = -1;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private final zzews b(zzfjj var1) throws IOException {
      while (true) {
         int var4 = var1.a();
         zzewt[] var5;
         int var11;
         switch (var4) {
            case 10:
               this.a = var1.e();
               continue;
            case 18:
               this.b = var1.e();
               continue;
            case 26:
               if (this.c == null) {
                  this.c = new zzewr();
               }

               var1.a(this.c);
               continue;
            case 34:
               if (this.f == null) {
                  this.f = new zzewu();
               }

               var1.a(this.f);
               continue;
            case 40:
               int var10 = var1.m();

               try {
                  var11 = var1.h();
               } catch (IllegalArgumentException var9) {
                  var1.e(var10);
                  this.a(var1, var4);
                  continue;
               }

               switch (var11) {
                  case 0:
                  case 1:
                  case 2:
                  case 3:
                     try {
                        this.d = var11;
                     } catch (IllegalArgumentException var7) {
                        var1.e(var10);
                        this.a(var1, var4);
                     }
                     continue;
                  default:
                     try {
                        StringBuilder var13 = new StringBuilder(55);
                        IllegalArgumentException var6 = new IllegalArgumentException(
                           var13.append(var11).append(" is not a valid enum ApplicationProcessState").toString()
                        );
                        throw var6;
                     } catch (IllegalArgumentException var8) {
                        var1.e(var10);
                        this.a(var1, var4);
                        continue;
                     }
               }
            case 50:
               var11 = zzfjv.a(var1, 50);
               int var2;
               if (this.e == null) {
                  var2 = 0;
               } else {
                  var2 = this.e.length;
               }

               var5 = new zzewt[var11 + var2];
               var11 = var2;
               if (var2 != 0) {
                  System.arraycopy(this.e, 0, var5, 0, var2);
                  var11 = var2;
               }
               break;
            default:
               if (super.a(var1, var4)) {
                  continue;
               }
            case 0:
               return this;
         }

         while (var11 < var5.length - 1) {
            var5[var11] = new zzewt();
            var1.a(var5[var11]);
            var1.a();
            var11++;
         }

         var5[var11] = new zzewt();
         var1.a(var5[var11]);
         this.e = var5;
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
         var1.a(3, this.c);
      }

      if (this.f != null) {
         var1.a(4, this.f);
      }

      if (this.d != null) {
         var1.a(5, this.d);
      }

      if (this.e != null && this.e.length > 0) {
         for (int var2 = 0; var2 < this.e.length; var2++) {
            zzewt var3 = this.e[var2];
            if (var3 != null) {
               var1.a(6, var3);
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
         var1 = var2 + zzfjk.b(3, this.c);
      }

      var2 = var1;
      if (this.f != null) {
         var2 = var1 + zzfjk.b(4, this.f);
      }

      var1 = var2;
      if (this.d != null) {
         var1 = var2 + zzfjk.b(5, this.d);
      }

      var2 = var1;
      if (this.e != null) {
         var2 = var1;
         if (this.e.length > 0) {
            int var3 = 0;

            while (var3 < this.e.length) {
               zzewt var4 = this.e[var3];
               var2 = var1;
               if (var4 != null) {
                  var2 = var1 + zzfjk.b(6, var4);
               }

               var3++;
               var1 = var2;
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
      } else if (!(var1 instanceof zzews)) {
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

         if (this.f == null) {
            if (var1.f != null) {
               var2 = false;
               return var2;
            }
         } else if (!this.f.equals(var1.f)) {
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

         if (!zzfjq.a(this.e, var1.e)) {
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
      byte var7 = 0;
      int var8 = this.getClass().getName().hashCode();
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
         var2 = this.b.hashCode();
      }

      zzewr var10 = this.c;
      int var3;
      if (var10 == null) {
         var3 = 0;
      } else {
         var3 = var10.hashCode();
      }

      zzewu var11 = this.f;
      int var4;
      if (var11 == null) {
         var4 = 0;
      } else {
         var4 = var11.hashCode();
      }

      int var5;
      if (this.d == null) {
         var5 = 0;
      } else {
         var5 = this.d;
      }

      int var9 = zzfjq.a(this.e);
      int var6 = var7;
      if (this.H != null) {
         if (this.H.b()) {
            var6 = var7;
         } else {
            var6 = this.H.hashCode();
         }
      }

      return ((var5 + (var4 + (var3 + (var2 + (var1 + (var8 + 527) * 31) * 31) * 31) * 31) * 31) * 31 + var9) * 31 + var6;
   }
}
