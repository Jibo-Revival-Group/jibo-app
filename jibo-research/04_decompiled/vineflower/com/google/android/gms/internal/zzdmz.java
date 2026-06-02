package com.google.android.gms.internal;

import java.io.IOException;

public final class zzdmz extends zzfjm<zzdmz> {
   public String[] a = zzfjv.f;
   public int[] b = zzfjv.a;
   public byte[][] c = zzfjv.g;

   public zzdmz() {
      this.H = null;
      this.I = -1;
   }

   public static zzdmz a(byte[] var0) throws zzfjr {
      return zzfjs.a(new zzdmz(), var0);
   }

   @Override
   public final void a(zzfjk var1) throws IOException {
      byte var3 = 0;
      if (this.a != null && this.a.length > 0) {
         for (int var2 = 0; var2 < this.a.length; var2++) {
            String var4 = this.a[var2];
            if (var4 != null) {
               var1.a(1, var4);
            }
         }
      }

      if (this.b != null && this.b.length > 0) {
         for (int var5 = 0; var5 < this.b.length; var5++) {
            var1.a(2, this.b[var5]);
         }
      }

      if (this.c != null && this.c.length > 0) {
         for (int var6 = var3; var6 < this.c.length; var6++) {
            byte[] var7 = this.c[var6];
            if (var7 != null) {
               var1.a(3, var7);
            }
         }
      }

      super.a(var1);
   }

   @Override
   protected final int b() {
      int var6 = 0;
      int var7 = super.b();
      int var2;
      if (this.a != null && this.a.length > 0) {
         int var3 = 0;
         var2 = 0;
         int var1 = 0;

         while (var3 < this.a.length) {
            String var8 = this.a[var3];
            int var5 = var2;
            int var4 = var1;
            if (var8 != null) {
               var4 = var1 + 1;
               var5 = var2 + zzfjk.a(var8);
            }

            var3++;
            var2 = var5;
            var1 = var4;
         }

         var2 = var7 + var2 + var1 * 1;
      } else {
         var2 = var7;
      }

      int var9 = var2;
      if (this.b != null) {
         var9 = var2;
         if (this.b.length > 0) {
            var9 = 0;
            int var14 = 0;

            while (var9 < this.b.length) {
               var14 += zzfjk.a(this.b[var9]);
               var9++;
            }

            var9 = var2 + var14 + this.b.length * 1;
         }
      }

      var2 = var9;
      if (this.c != null) {
         var2 = var9;
         if (this.c.length > 0) {
            int var15 = 0;
            int var16 = 0;
            var2 = var6;

            while (var2 < this.c.length) {
               byte[] var19 = this.c[var2];
               var6 = var15;
               int var17 = var16;
               if (var19 != null) {
                  var17 = var16 + 1;
                  var6 = var15 + zzfjk.b(var19);
               }

               var2++;
               var15 = var6;
               var16 = var17;
            }

            var2 = var9 + var15 + var16 * 1;
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
      } else if (!(var1 instanceof zzdmz)) {
         var2 = false;
      } else {
         var1 = var1;
         if (!zzfjq.a(this.a, var1.a)) {
            var2 = false;
         } else if (!zzfjq.a(this.b, var1.b)) {
            var2 = false;
         } else if (!zzfjq.a(this.c, var1.c)) {
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
      int var4 = this.getClass().getName().hashCode();
      int var2 = zzfjq.a(this.a);
      int var5 = zzfjq.a(this.b);
      int var3 = zzfjq.a(this.c);
      int var1;
      if (this.H != null && !this.H.b()) {
         var1 = this.H.hashCode();
      } else {
         var1 = 0;
      }

      return var1 + ((((var4 + 527) * 31 + var2) * 31 + var5) * 31 + var3) * 31;
   }
}
