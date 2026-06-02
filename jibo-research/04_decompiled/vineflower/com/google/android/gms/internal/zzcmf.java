package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcmf extends zzfjm<zzcmf> {
   public long[] a;
   public long[] b;

   public zzcmf() {
      this.a = zzfjv.b;
      this.b = zzfjv.b;
      this.H = null;
      this.I = -1;
   }

   @Override
   public final void a(zzfjk var1) throws IOException {
      byte var3 = 0;
      if (this.a != null && this.a.length > 0) {
         for (int var2 = 0; var2 < this.a.length; var2++) {
            var1.a(1, this.a[var2]);
         }
      }

      if (this.b != null && this.b.length > 0) {
         for (int var4 = var3; var4 < this.b.length; var4++) {
            var1.a(2, this.b[var4]);
         }
      }

      super.a(var1);
   }

   @Override
   protected final int b() {
      int var3 = 0;
      int var4 = super.b();
      int var1;
      if (this.a != null && this.a.length > 0) {
         var1 = 0;
         int var2 = 0;

         while (var1 < this.a.length) {
            var2 += zzfjk.a(this.a[var1]);
            var1++;
         }

         var1 = var4 + var2 + this.a.length * 1;
      } else {
         var1 = var4;
      }

      int var6 = var1;
      if (this.b != null) {
         var6 = var1;
         if (this.b.length > 0) {
            var6 = 0;

            while (var3 < this.b.length) {
               var6 += zzfjk.a(this.b[var3]);
               var3++;
            }

            var6 = var1 + var6 + this.b.length * 1;
         }
      }

      return var6;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var3 = true;
      boolean var2;
      if (var1 == this) {
         var2 = var3;
      } else if (!(var1 instanceof zzcmf)) {
         var2 = false;
      } else {
         var1 = var1;
         if (!zzfjq.a(this.a, var1.a)) {
            var2 = false;
         } else if (!zzfjq.a(this.b, var1.b)) {
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
      int var3 = this.getClass().getName().hashCode();
      int var2 = zzfjq.a(this.a);
      int var4 = zzfjq.a(this.b);
      int var1;
      if (this.H != null && !this.H.b()) {
         var1 = this.H.hashCode();
      } else {
         var1 = 0;
      }

      return var1 + (((var3 + 527) * 31 + var2) * 31 + var4) * 31;
   }
}
