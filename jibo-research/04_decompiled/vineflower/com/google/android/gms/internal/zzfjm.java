package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzfjm<M extends zzfjm<M>> extends zzfjs {
   protected zzfjo H;

   @Override
   public void a(zzfjk var1) throws IOException {
      if (this.H != null) {
         for (int var2 = 0; var2 < this.H.a(); var2++) {
            this.H.b(var2).a(var1);
         }
      }
   }

   protected final boolean a(zzfjj var1, int var2) throws IOException {
      int var3 = var1.m();
      boolean var5;
      if (!var1.b(var2)) {
         var5 = false;
      } else {
         int var4 = var2 >>> 3;
         zzfju var7 = new zzfju(var2, var1.a(var3, var1.m() - var3));
         zzfjp var8 = null;
         if (this.H == null) {
            this.H = new zzfjo();
         } else {
            var8 = this.H.a(var4);
         }

         zzfjp var6 = var8;
         if (var8 == null) {
            var6 = new zzfjp();
            this.H.a(var4, var6);
         }

         var6.a(var7);
         var5 = true;
      }

      return var5;
   }

   @Override
   protected int b() {
      int var2 = 0;
      int var3;
      if (this.H != null) {
         int var1 = 0;

         while (true) {
            var3 = var1;
            if (var2 >= this.H.a()) {
               break;
            }

            var1 += this.H.b(var2).a();
            var2++;
         }
      } else {
         var3 = 0;
      }

      return var3;
   }

   public M c() throws CloneNotSupportedException {
      zzfjm var1 = (zzfjm)super.d();
      zzfjq.a(this, var1);
      return (M)var1;
   }
}
