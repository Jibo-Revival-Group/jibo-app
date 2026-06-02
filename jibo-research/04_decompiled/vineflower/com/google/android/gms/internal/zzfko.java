package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfko extends zzfjm<zzfko> implements Cloneable {
   private int a = 0;
   private String b = "";
   private String c = "";

   public zzfko() {
      this.H = null;
      this.I = -1;
   }

   private zzfko a() {
      try {
         return (zzfko)super.c();
      } catch (CloneNotSupportedException var2) {
         throw new AssertionError(var2);
      }
   }

   @Override
   public final void a(zzfjk var1) throws IOException {
      if (this.a != 0) {
         var1.a(1, this.a);
      }

      if (this.b != null && !this.b.equals("")) {
         var1.a(2, this.b);
      }

      if (this.c != null && !this.c.equals("")) {
         var1.a(3, this.c);
      }

      super.a(var1);
   }

   @Override
   protected final int b() {
      int var2 = super.b();
      int var1 = var2;
      if (this.a != 0) {
         var1 = var2 + zzfjk.b(1, this.a);
      }

      var2 = var1;
      if (this.b != null) {
         var2 = var1;
         if (!this.b.equals("")) {
            var2 = var1 + zzfjk.b(2, this.b);
         }
      }

      var1 = var2;
      if (this.c != null) {
         var1 = var2;
         if (!this.c.equals("")) {
            var1 = var2 + zzfjk.b(3, this.c);
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
      } else if (!(var1 instanceof zzfko)) {
         var2 = false;
      } else {
         var1 = var1;
         if (this.a != var1.a) {
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

            if (this.c == null) {
               if (var1.c != null) {
                  var2 = false;
                  return var2;
               }
            } else if (!this.c.equals(var1.c)) {
               var2 = false;
               return var2;
            }

            if (this.H != null && !this.H.b()) {
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
      int var5 = this.getClass().getName().hashCode();
      int var6 = this.a;
      int var1;
      if (this.b == null) {
         var1 = 0;
      } else {
         var1 = this.b.hashCode();
      }

      int var2;
      if (this.c == null) {
         var2 = 0;
      } else {
         var2 = this.c.hashCode();
      }

      int var3 = var4;
      if (this.H != null) {
         if (this.H.b()) {
            var3 = var4;
         } else {
            var3 = this.H.hashCode();
         }
      }

      return (var2 + (var1 + ((var5 + 527) * 31 + var6) * 31) * 31) * 31 + var3;
   }
}
