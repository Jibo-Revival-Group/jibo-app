package com.google.android.gms.internal;

import java.io.IOException;

public final class zzewr extends zzfjm<zzewr> {
   public String a = null;
   public String b = null;
   public String c = null;

   public zzewr() {
      this.H = null;
      this.I = -1;
   }

   @Override
   public final void a(zzfjk var1) throws IOException {
      if (this.a != null) {
         var1.a(1, this.a);
      }

      if (this.b != null) {
         var1.a(2, this.b);
      }

      if (this.c != null) {
         var1.a(3, this.c);
      }

      super.a(var1);
   }

   @Override
   protected final int b() {
      int var1 = super.b();
      int var2 = var1;
      if (this.a != null) {
         var2 = var1 + zzfjk.b(1, this.a);
      }

      var1 = var2;
      if (this.b != null) {
         var1 = var2 + zzfjk.b(2, this.b);
      }

      var2 = var1;
      if (this.c != null) {
         var2 = var1 + zzfjk.b(3, this.c);
      }

      return var2;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var3 = true;
      boolean var2;
      if (var1 == this) {
         var2 = var3;
      } else if (!(var1 instanceof zzewr)) {
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
      byte var5 = 0;
      int var6 = this.getClass().getName().hashCode();
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

      int var4 = var5;
      if (this.H != null) {
         if (this.H.b()) {
            var4 = var5;
         } else {
            var4 = this.H.hashCode();
         }
      }

      return (var3 + (var2 + (var1 + (var6 + 527) * 31) * 31) * 31) * 31 + var4;
   }
}
