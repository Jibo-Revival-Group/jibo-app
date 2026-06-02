package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public final class zzfkp extends zzfjm<zzfkp> implements Cloneable {
   private byte[] a = zzfjv.h;
   private String b = "";
   private byte[][] c = zzfjv.g;
   private boolean d = false;

   public zzfkp() {
      this.H = null;
      this.I = -1;
   }

   private zzfkp a() {
      zzfkp var1;
      try {
         var1 = (zzfkp)super.c();
      } catch (CloneNotSupportedException var2) {
         throw new AssertionError(var2);
      }

      if (this.c != null && this.c.length > 0) {
         var1.c = (byte[][])this.c.clone();
      }

      return var1;
   }

   @Override
   public final void a(zzfjk var1) throws IOException {
      if (!Arrays.equals(this.a, zzfjv.h)) {
         var1.a(1, this.a);
      }

      if (this.c != null && this.c.length > 0) {
         for (int var2 = 0; var2 < this.c.length; var2++) {
            byte[] var3 = this.c[var2];
            if (var3 != null) {
               var1.a(2, var3);
            }
         }
      }

      if (this.d) {
         var1.a(3, this.d);
      }

      if (this.b != null && !this.b.equals("")) {
         var1.a(4, this.b);
      }

      super.a(var1);
   }

   @Override
   protected final int b() {
      int var4 = 0;
      int var2 = super.b();
      int var1 = var2;
      if (!Arrays.equals(this.a, zzfjv.h)) {
         var1 = var2 + zzfjk.b(1, this.a);
      }

      var2 = var1;
      if (this.c != null) {
         var2 = var1;
         if (this.c.length > 0) {
            int var5 = 0;
            int var3 = 0;
            var2 = var4;

            while (var2 < this.c.length) {
               byte[] var7 = this.c[var2];
               int var6 = var5;
               var4 = var3;
               if (var7 != null) {
                  var4 = var3 + 1;
                  var6 = var5 + zzfjk.b(var7);
               }

               var2++;
               var5 = var6;
               var3 = var4;
            }

            var2 = var1 + var5 + var3 * 1;
         }
      }

      var1 = var2;
      if (this.d) {
         var1 = var2 + zzfjk.b(3) + 1;
      }

      var2 = var1;
      if (this.b != null) {
         var2 = var1;
         if (!this.b.equals("")) {
            var2 = var1 + zzfjk.b(4, this.b);
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
      } else if (!(var1 instanceof zzfkp)) {
         var2 = false;
      } else {
         var1 = var1;
         if (!Arrays.equals(this.a, var1.a)) {
            var2 = false;
         } else {
            if (this.b == null) {
               if (var1.b != null) {
                  var2 = false;
                  return var2;
               }
            } else if (!this.b.equals(var1.b)) {
               var2 = false;
               return var2;
            }

            if (!zzfjq.a(this.c, var1.c)) {
               var2 = false;
            } else if (this.d != var1.d) {
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
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      byte var4 = 0;
      int var6 = this.getClass().getName().hashCode();
      int var5 = Arrays.hashCode(this.a);
      int var1;
      if (this.b == null) {
         var1 = 0;
      } else {
         var1 = this.b.hashCode();
      }

      int var7 = zzfjq.a(this.c);
      short var2;
      if (this.d) {
         var2 = 1231;
      } else {
         var2 = 1237;
      }

      int var3 = var4;
      if (this.H != null) {
         if (this.H.b()) {
            var3 = var4;
         } else {
            var3 = this.H.hashCode();
         }
      }

      return (var2 + ((var1 + ((var6 + 527) * 31 + var5) * 31) * 31 + var7) * 31) * 31 + var3;
   }
}
