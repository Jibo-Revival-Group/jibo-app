package com.google.android.gms.internal;

import java.io.IOException;

public final class zzclw extends zzfjm<zzclw> {
   public Integer a = null;
   public String b = null;
   public Boolean c = null;
   public String[] d = zzfjv.f;

   public zzclw() {
      this.H = null;
      this.I = -1;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private final zzclw b(zzfjj var1) throws IOException {
      while (true) {
         int var2 = var1.a();
         String[] var5;
         int var11;
         switch (var2) {
            case 8:
               int var4 = var1.m();

               try {
                  var11 = var1.h();
               } catch (IllegalArgumentException var9) {
                  var1.e(var4);
                  this.a(var1, var2);
                  continue;
               }

               switch (var11) {
                  case 0:
                  case 1:
                  case 2:
                  case 3:
                  case 4:
                  case 5:
                  case 6:
                     try {
                        this.a = var11;
                     } catch (IllegalArgumentException var7) {
                        var1.e(var4);
                        this.a(var1, var2);
                     }
                     continue;
                  default:
                     try {
                        StringBuilder var6 = new StringBuilder(41);
                        IllegalArgumentException var13 = new IllegalArgumentException(var6.append(var11).append(" is not a valid enum MatchType").toString());
                        throw var13;
                     } catch (IllegalArgumentException var8) {
                        var1.e(var4);
                        this.a(var1, var2);
                        continue;
                     }
               }
            case 18:
               this.b = var1.e();
               continue;
            case 24:
               this.c = var1.d();
               continue;
            case 34:
               var11 = zzfjv.a(var1, 34);
               if (this.d == null) {
                  var2 = 0;
               } else {
                  var2 = this.d.length;
               }

               var5 = new String[var11 + var2];
               var11 = var2;
               if (var2 != 0) {
                  System.arraycopy(this.d, 0, var5, 0, var2);
                  var11 = var2;
               }
               break;
            default:
               if (super.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
         }

         while (var11 < var5.length - 1) {
            var5[var11] = var1.e();
            var1.a();
            var11++;
         }

         var5[var11] = var1.e();
         this.d = var5;
      }
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

      if (this.d != null && this.d.length > 0) {
         for (int var2 = 0; var2 < this.d.length; var2++) {
            String var3 = this.d[var2];
            if (var3 != null) {
               var1.a(4, var3);
            }
         }
      }

      super.a(var1);
   }

   @Override
   protected final int b() {
      int var3 = 0;
      int var2 = super.b();
      int var1 = var2;
      if (this.a != null) {
         var1 = var2 + zzfjk.b(1, this.a);
      }

      var2 = var1;
      if (this.b != null) {
         var2 = var1 + zzfjk.b(2, this.b);
      }

      var1 = var2;
      if (this.c != null) {
         this.c;
         var1 = var2 + zzfjk.b(3) + 1;
      }

      var2 = var1;
      if (this.d != null) {
         var2 = var1;
         if (this.d.length > 0) {
            int var5 = 0;
            int var4 = 0;

            while (var3 < this.d.length) {
               String var7 = this.d[var3];
               int var6 = var5;
               var2 = var4;
               if (var7 != null) {
                  var2 = var4 + 1;
                  var6 = var5 + zzfjk.a(var7);
               }

               var3++;
               var5 = var6;
               var4 = var2;
            }

            var2 = var1 + var5 + var4 * 1;
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
      } else if (!(var1 instanceof zzclw)) {
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

         if (!zzfjq.a(this.d, var1.d)) {
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
      byte var5 = 0;
      int var6 = this.getClass().getName().hashCode();
      int var1;
      if (this.a == null) {
         var1 = 0;
      } else {
         var1 = this.a;
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

      int var7 = zzfjq.a(this.d);
      int var4 = var5;
      if (this.H != null) {
         if (this.H.b()) {
            var4 = var5;
         } else {
            var4 = this.H.hashCode();
         }
      }

      return ((var3 + (var2 + (var1 + (var6 + 527) * 31) * 31) * 31) * 31 + var7) * 31 + var4;
   }
}
