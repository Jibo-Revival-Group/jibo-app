package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import java.util.Arrays;

public class zzc {
   protected final DataHolder a;
   protected int b;
   private int c;

   public zzc(DataHolder var1, int var2) {
      this.a = zzbq.a(var1);
      this.a(var2);
   }

   protected final void a(int var1) {
      boolean var2;
      if (var1 >= 0 && var1 < this.a.a) {
         var2 = true;
      } else {
         var2 = false;
      }

      zzbq.a(var2);
      this.b = var1;
      this.c = this.a.a(this.b);
   }

   public final boolean a(String var1) {
      return this.a.a(var1);
   }

   protected final int b(String var1) {
      return this.a.a(var1, this.b, this.c);
   }

   protected final String c(String var1) {
      return this.a.b(var1, this.b, this.c);
   }

   protected final float d(String var1) {
      return this.a.c(var1, this.b, this.c);
   }

   protected final byte[] e(String var1) {
      return this.a.d(var1, this.b, this.c);
   }

   @Override
   public boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2 = var3;
      if (var1 instanceof zzc) {
         var1 = var1;
         var2 = var3;
         if (zzbg.a(var1.b, this.b)) {
            var2 = var3;
            if (zzbg.a(var1.c, this.c)) {
               var2 = var3;
               if (var1.a == this.a) {
                  var2 = true;
               }
            }
         }
      }

      return var2;
   }

   protected final boolean f(String var1) {
      return this.a.e(var1, this.b, this.c);
   }

   @Override
   public int hashCode() {
      return Arrays.hashCode(new Object[]{this.b, this.c, this.a});
   }
}
