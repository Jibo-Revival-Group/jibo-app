package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcly extends zzfjm<zzcly> {
   public Long a = null;
   public String b = null;
   public zzclz[] c;
   public zzclx[] d;
   public zzclr[] e;
   private Integer f = null;

   public zzcly() {
      this.c = zzclz.a();
      this.d = zzclx.a();
      this.e = zzclr.a();
      this.H = null;
      this.I = -1;
   }

   @Override
   public final void a(zzfjk var1) throws IOException {
      byte var3 = 0;
      if (this.a != null) {
         var1.b(1, this.a);
      }

      if (this.b != null) {
         var1.a(2, this.b);
      }

      if (this.f != null) {
         var1.a(3, this.f);
      }

      if (this.c != null && this.c.length > 0) {
         for (int var2 = 0; var2 < this.c.length; var2++) {
            zzclz var4 = this.c[var2];
            if (var4 != null) {
               var1.a(4, var4);
            }
         }
      }

      if (this.d != null && this.d.length > 0) {
         for (int var5 = 0; var5 < this.d.length; var5++) {
            zzclx var7 = this.d[var5];
            if (var7 != null) {
               var1.a(5, var7);
            }
         }
      }

      if (this.e != null && this.e.length > 0) {
         for (int var6 = var3; var6 < this.e.length; var6++) {
            zzclr var8 = this.e[var6];
            if (var8 != null) {
               var1.a(6, var8);
            }
         }
      }

      super.a(var1);
   }

   @Override
   protected final int b() {
      byte var4 = 0;
      int var2 = super.b();
      int var1 = var2;
      if (this.a != null) {
         var1 = var2 + zzfjk.d(1, this.a);
      }

      var2 = var1;
      if (this.b != null) {
         var2 = var1 + zzfjk.b(2, this.b);
      }

      var1 = var2;
      if (this.f != null) {
         var1 = var2 + zzfjk.b(3, this.f);
      }

      var2 = var1;
      if (this.c != null) {
         var2 = var1;
         if (this.c.length > 0) {
            var2 = 0;

            while (var2 < this.c.length) {
               zzclz var5 = this.c[var2];
               int var3 = var1;
               if (var5 != null) {
                  var3 = var1 + zzfjk.b(4, var5);
               }

               var2++;
               var1 = var3;
            }

            var2 = var1;
         }
      }

      var1 = var2;
      if (this.d != null) {
         var1 = var2;
         if (this.d.length > 0) {
            var1 = var2;
            int var13 = 0;

            while (var13 < this.d.length) {
               zzclx var16 = this.d[var13];
               var2 = var1;
               if (var16 != null) {
                  var2 = var1 + zzfjk.b(5, var16);
               }

               var13++;
               var1 = var2;
            }
         }
      }

      int var14 = var1;
      if (this.e != null) {
         var14 = var1;
         if (this.e.length > 0) {
            var2 = var4;

            while (true) {
               var14 = var1;
               if (var2 >= this.e.length) {
                  break;
               }

               zzclr var17 = this.e[var2];
               var14 = var1;
               if (var17 != null) {
                  var14 = var1 + zzfjk.b(6, var17);
               }

               var2++;
               var1 = var14;
            }
         }
      }

      return var14;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var3 = true;
      boolean var2;
      if (var1 == this) {
         var2 = var3;
      } else if (!(var1 instanceof zzcly)) {
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

         if (this.f == null) {
            if (var1.f != null) {
               var2 = false;
               return var2;
            }
         } else if (!this.f.equals(var1.f)) {
            var2 = false;
            return var2;
         }

         if (!zzfjq.a(this.c, var1.c)) {
            var2 = false;
         } else if (!zzfjq.a(this.d, var1.d)) {
            var2 = false;
         } else if (!zzfjq.a(this.e, var1.e)) {
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
      byte var5 = 0;
      int var6 = this.getClass().getName().hashCode();
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

      int var3;
      if (this.f == null) {
         var3 = 0;
      } else {
         var3 = this.f.hashCode();
      }

      int var8 = zzfjq.a(this.c);
      int var9 = zzfjq.a(this.d);
      int var7 = zzfjq.a(this.e);
      int var4 = var5;
      if (this.H != null) {
         if (this.H.b()) {
            var4 = var5;
         } else {
            var4 = this.H.hashCode();
         }
      }

      return ((((var3 + (var2 + (var1 + (var6 + 527) * 31) * 31) * 31) * 31 + var8) * 31 + var9) * 31 + var7) * 31 + var4;
   }
}
