package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfkn extends zzfjm<zzfkn> implements Cloneable {
   private String[] a = zzfjv.f;
   private String[] b = zzfjv.f;
   private int[] c = zzfjv.a;
   private long[] d = zzfjv.b;
   private long[] e = zzfjv.b;

   public zzfkn() {
      this.H = null;
      this.I = -1;
   }

   private zzfkn a() {
      zzfkn var1;
      try {
         var1 = (zzfkn)super.c();
      } catch (CloneNotSupportedException var2) {
         throw new AssertionError(var2);
      }

      if (this.a != null && this.a.length > 0) {
         var1.a = (String[])this.a.clone();
      }

      if (this.b != null && this.b.length > 0) {
         var1.b = (String[])this.b.clone();
      }

      if (this.c != null && this.c.length > 0) {
         var1.c = (int[])this.c.clone();
      }

      if (this.d != null && this.d.length > 0) {
         var1.d = (long[])this.d.clone();
      }

      if (this.e != null && this.e.length > 0) {
         var1.e = (long[])this.e.clone();
      }

      return var1;
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
            String var9 = this.b[var5];
            if (var9 != null) {
               var1.a(2, var9);
            }
         }
      }

      if (this.c != null && this.c.length > 0) {
         for (int var6 = 0; var6 < this.c.length; var6++) {
            var1.a(3, this.c[var6]);
         }
      }

      if (this.d != null && this.d.length > 0) {
         for (int var7 = 0; var7 < this.d.length; var7++) {
            var1.b(4, this.d[var7]);
         }
      }

      if (this.e != null && this.e.length > 0) {
         for (int var8 = var3; var8 < this.e.length; var8++) {
            var1.b(5, this.e[var8]);
         }
      }

      super.a(var1);
   }

   @Override
   protected final int b() {
      byte var7 = 0;
      int var6 = super.b();
      int var1;
      if (this.a != null && this.a.length > 0) {
         var1 = 0;
         int var3 = 0;
         int var2 = 0;

         while (var1 < this.a.length) {
            String var8 = this.a[var1];
            int var5 = var3;
            int var4 = var2;
            if (var8 != null) {
               var4 = var2 + 1;
               var5 = var3 + zzfjk.a(var8);
            }

            var1++;
            var3 = var5;
            var2 = var4;
         }

         var1 = var6 + var3 + var2 * 1;
      } else {
         var1 = var6;
      }

      int var14 = var1;
      if (this.b != null) {
         var14 = var1;
         if (this.b.length > 0) {
            int var23 = 0;
            var14 = 0;
            int var22 = 0;

            while (var23 < this.b.length) {
               String var25 = this.b[var23];
               var6 = var14;
               int var18 = var22;
               if (var25 != null) {
                  var18 = var22 + 1;
                  var6 = var14 + zzfjk.a(var25);
               }

               var23++;
               var14 = var6;
               var22 = var18;
            }

            var14 = var1 + var14 + var22 * 1;
         }
      }

      var1 = var14;
      if (this.c != null) {
         var1 = var14;
         if (this.c.length > 0) {
            var1 = 0;
            int var19 = 0;

            while (var1 < this.c.length) {
               var19 += zzfjk.a(this.c[var1]);
               var1++;
            }

            var1 = var14 + var19 + this.c.length * 1;
         }
      }

      var14 = var1;
      if (this.d != null) {
         var14 = var1;
         if (this.d.length > 0) {
            var14 = 0;
            int var20 = 0;

            while (var14 < this.d.length) {
               var20 += zzfjk.a(this.d[var14]);
               var14++;
            }

            var14 = var1 + var20 + this.d.length * 1;
         }
      }

      var1 = var14;
      if (this.e != null) {
         var1 = var14;
         if (this.e.length > 0) {
            int var21 = 0;

            for (int var13 = var7; var13 < this.e.length; var13++) {
               var21 += zzfjk.a(this.e[var13]);
            }

            var1 = var14 + var21 + this.e.length * 1;
         }
      }

      return var1;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var3 = true;
      boolean var2;
      if (var1 == this) {
         var2 = var3;
      } else if (!(var1 instanceof zzfkn)) {
         var2 = false;
      } else {
         var1 = var1;
         if (!zzfjq.a(this.a, var1.a)) {
            var2 = false;
         } else if (!zzfjq.a(this.b, var1.b)) {
            var2 = false;
         } else if (!zzfjq.a(this.c, var1.c)) {
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
      int var4 = this.getClass().getName().hashCode();
      int var5 = zzfjq.a(this.a);
      int var6 = zzfjq.a(this.b);
      int var7 = zzfjq.a(this.c);
      int var2 = zzfjq.a(this.d);
      int var3 = zzfjq.a(this.e);
      int var1;
      if (this.H != null && !this.H.b()) {
         var1 = this.H.hashCode();
      } else {
         var1 = 0;
      }

      return var1 + ((((((var4 + 527) * 31 + var5) * 31 + var6) * 31 + var7) * 31 + var2) * 31 + var3) * 31;
   }
}
