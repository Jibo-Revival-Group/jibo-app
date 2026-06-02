package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfjn<M extends zzfjm<M>, T> {
   protected final Class<T> a;
   public final int b;
   protected final boolean c;
   private int d;

   protected final int a(Object var1) {
      int var2 = this.b >>> 3;
      switch (this.d) {
         case 10:
            var1 = var1;
            var2 = (zzfjk.b(var2) << 1) + var1.f();
            break;
         case 11:
            var2 = zzfjk.b(var2, var1);
            break;
         default:
            var2 = this.d;
            throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(var2).toString());
      }

      return var2;
   }

   protected final void a(Object var1, zzfjk var2) {
      try {
         var2.c(this.b);
         switch (this.d) {
            case 10:
               int var7 = this.b;
               ((zzfjs)var1).a(var2);
               var2.c(var7 >>> 3, 4);
               break;
            case 11:
               var2.a((zzfjs)var1);
               break;
            default:
               int var3 = this.d;
               StringBuilder var6 = new StringBuilder(24);
               IllegalArgumentException var5 = new IllegalArgumentException(var6.append("Unknown type ").append(var3).toString());
               throw var5;
         }
      } catch (IOException var4) {
         throw new IllegalStateException(var4);
      }
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof zzfjn)) {
            var2 = false;
         } else {
            var1 = var1;
            if (this.d != var1.d || this.a != var1.a || this.b != var1.b || this.c != var1.c) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      int var4 = this.d;
      int var2 = this.a.hashCode();
      int var3 = this.b;
      byte var1;
      if (this.c) {
         var1 = 1;
      } else {
         var1 = 0;
      }

      return var1 + (((var4 + 1147) * 31 + var2) * 31 + var3) * 31;
   }
}
