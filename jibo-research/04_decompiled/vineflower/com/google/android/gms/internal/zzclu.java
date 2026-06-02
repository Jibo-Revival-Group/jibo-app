package com.google.android.gms.internal;

import java.io.IOException;

public final class zzclu extends zzfjm<zzclu> {
   public Integer a = null;
   public Boolean b = null;
   public String c = null;
   public String d = null;
   public String e = null;

   public zzclu() {
      this.H = null;
      this.I = -1;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private final zzclu b(zzfjj var1) throws IOException {
      while (true) {
         int var2 = var1.a();
         switch (var2) {
            case 8:
               int var4 = var1.m();

               int var3;
               try {
                  var3 = var1.h();
               } catch (IllegalArgumentException var9) {
                  var1.e(var4);
                  this.a(var1, var2);
                  break;
               }

               switch (var3) {
                  case 0:
                  case 1:
                  case 2:
                  case 3:
                  case 4:
                     try {
                        this.a = var3;
                     } catch (IllegalArgumentException var7) {
                        var1.e(var4);
                        this.a(var1, var2);
                     }
                     continue;
                  default:
                     try {
                        StringBuilder var5 = new StringBuilder(46);
                        IllegalArgumentException var6 = new IllegalArgumentException(var5.append(var3).append(" is not a valid enum ComparisonType").toString());
                        throw var6;
                     } catch (IllegalArgumentException var8) {
                        var1.e(var4);
                        this.a(var1, var2);
                        continue;
                     }
               }
            case 16:
               this.b = var1.d();
               break;
            case 26:
               this.c = var1.e();
               break;
            case 34:
               this.d = var1.e();
               break;
            case 42:
               this.e = var1.e();
               break;
            default:
               if (super.a(var1, var2)) {
                  break;
               }
            case 0:
               return this;
         }
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

      if (this.d != null) {
         var1.a(4, this.d);
      }

      if (this.e != null) {
         var1.a(5, this.e);
      }

      super.a(var1);
   }

   @Override
   protected final int b() {
      int var2 = super.b();
      int var1 = var2;
      if (this.a != null) {
         var1 = var2 + zzfjk.b(1, this.a);
      }

      var2 = var1;
      if (this.b != null) {
         this.b;
         var2 = var1 + zzfjk.b(2) + 1;
      }

      int var3 = var2;
      if (this.c != null) {
         var3 = var2 + zzfjk.b(3, this.c);
      }

      var1 = var3;
      if (this.d != null) {
         var1 = var3 + zzfjk.b(4, this.d);
      }

      var2 = var1;
      if (this.e != null) {
         var2 = var1 + zzfjk.b(5, this.e);
      }

      return var2;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var3 = true;
      boolean var2;
      if (var1 == this) {
         var2 = var3;
      } else if (!(var1 instanceof zzclu)) {
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

         if (this.e == null) {
            if (var1.e != null) {
               var2 = false;
               return var2;
            }
         } else if (!this.e.equals(var1.e)) {
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
      byte var7 = 0;
      int var8 = this.getClass().getName().hashCode();
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

      int var4;
      if (this.d == null) {
         var4 = 0;
      } else {
         var4 = this.d.hashCode();
      }

      int var5;
      if (this.e == null) {
         var5 = 0;
      } else {
         var5 = this.e.hashCode();
      }

      int var6 = var7;
      if (this.H != null) {
         if (this.H.b()) {
            var6 = var7;
         } else {
            var6 = this.H.hashCode();
         }
      }

      return (var5 + (var4 + (var3 + (var2 + (var1 + (var8 + 527) * 31) * 31) * 31) * 31) * 31) * 31 + var6;
   }
}
