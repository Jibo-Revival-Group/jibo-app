package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcmd extends zzfjm<zzcmd> {
   public zzcme[] a = zzcme.a();

   public zzcmd() {
      this.H = null;
      this.I = -1;
   }

   @Override
   public final void a(zzfjk var1) throws IOException {
      if (this.a != null && this.a.length > 0) {
         for (int var2 = 0; var2 < this.a.length; var2++) {
            zzcme var3 = this.a[var2];
            if (var3 != null) {
               var1.a(1, var3);
            }
         }
      }

      super.a(var1);
   }

   @Override
   protected final int b() {
      int var1 = super.b();
      int var3 = var1;
      if (this.a != null) {
         var3 = var1;
         if (this.a.length > 0) {
            int var2 = 0;

            while (true) {
               var3 = var1;
               if (var2 >= this.a.length) {
                  break;
               }

               zzcme var4 = this.a[var2];
               var3 = var1;
               if (var4 != null) {
                  var3 = var1 + zzfjk.b(1, var4);
               }

               var2++;
               var1 = var3;
            }
         }
      }

      return var3;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var3 = true;
      boolean var2;
      if (var1 == this) {
         var2 = var3;
      } else if (!(var1 instanceof zzcmd)) {
         var2 = false;
      } else {
         var1 = var1;
         if (!zzfjq.a(this.a, var1.a)) {
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
      int var2 = this.getClass().getName().hashCode();
      int var3 = zzfjq.a(this.a);
      int var1;
      if (this.H != null && !this.H.b()) {
         var1 = this.H.hashCode();
      } else {
         var1 = 0;
      }

      return var1 + ((var2 + 527) * 31 + var3) * 31;
   }
}
