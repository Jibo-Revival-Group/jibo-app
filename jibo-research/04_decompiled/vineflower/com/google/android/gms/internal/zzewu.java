package com.google.android.gms.internal;

import java.io.IOException;

public final class zzewu extends zzfjm<zzewu> {
   private String a = null;
   private String b = null;
   private String c = null;
   private zzfks d = null;

   public zzewu() {
      this.H = null;
      this.I = -1;
   }

   @Override
   public final void a(zzfjk var1) throws IOException {
      if (this.a != null) {
         var1.a(2, this.a);
      }

      if (this.b != null) {
         var1.a(3, this.b);
      }

      if (this.c != null) {
         var1.a(4, this.c);
      }

      if (this.d != null) {
         var1.a(5, this.d);
      }

      super.a(var1);
   }

   @Override
   protected final int b() {
      int var2 = super.b();
      int var1 = var2;
      if (this.a != null) {
         var1 = var2 + zzfjk.b(2, this.a);
      }

      var2 = var1;
      if (this.b != null) {
         var2 = var1 + zzfjk.b(3, this.b);
      }

      var1 = var2;
      if (this.c != null) {
         var1 = var2 + zzfjk.b(4, this.c);
      }

      var2 = var1;
      if (this.d != null) {
         var2 = var1 + zzfjk.b(5, this.d);
      }

      return var2;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var3 = true;
      boolean var2;
      if (var1 == this) {
         var2 = var3;
      } else if (!(var1 instanceof zzewu)) {
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

         if (this.c == null) {
            if (var1.c != null) {
               var2 = false;
               return var2;
            }
         } else if (!this.c.equals(var1.c)) {
            var2 = false;
            return var2;
         }

         if (this.d == null) {
            if (var1.d != null) {
               var2 = false;
               return var2;
            }
         } else if (!this.d.equals(var1.d)) {
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

      return var2;
   }

   @Override
   public final int hashCode() {
      byte var6 = 0;
      int var7 = this.getClass().getName().hashCode();
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
      if (this.c == null) {
         var3 = 0;
      } else {
         var3 = this.c.hashCode();
      }

      zzfks var8 = this.d;
      int var4;
      if (var8 == null) {
         var4 = 0;
      } else {
         var4 = var8.hashCode();
      }

      int var5 = var6;
      if (this.H != null) {
         if (this.H.b()) {
            var5 = var6;
         } else {
            var5 = this.H.hashCode();
         }
      }

      return (var4 + (var3 + (var2 + (var1 + (var7 + 527) * 31) * 31) * 31) * 31) * 31 + var5;
   }
}
