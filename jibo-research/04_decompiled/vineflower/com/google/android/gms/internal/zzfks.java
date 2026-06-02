package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfks extends zzfjm<zzfks> implements Cloneable {
   private int a = -1;
   private int b = 0;

   public zzfks() {
      this.H = null;
      this.I = -1;
   }

   private zzfks a() {
      try {
         return (zzfks)super.c();
      } catch (CloneNotSupportedException var2) {
         throw new AssertionError(var2);
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private final zzfks b(zzfjj var1) throws IOException {
      while (true) {
         int var2 = var1.a();
         switch (var2) {
            case 8:
               int var14 = var1.m();

               int var13;
               try {
                  var13 = var1.c();
               } catch (IllegalArgumentException var12) {
                  var1.e(var14);
                  this.a(var1, var2);
                  break;
               }

               switch (var13) {
                  case -1:
                  case 0:
                  case 1:
                  case 2:
                  case 3:
                  case 4:
                  case 5:
                  case 6:
                  case 7:
                  case 8:
                  case 9:
                  case 10:
                  case 11:
                  case 12:
                  case 13:
                  case 14:
                  case 15:
                  case 16:
                  case 17:
                     try {
                        this.a = var13;
                     } catch (IllegalArgumentException var10) {
                        var1.e(var14);
                        this.a(var1, var2);
                     }
                     continue;
                  default:
                     try {
                        StringBuilder var16 = new StringBuilder(43);
                        IllegalArgumentException var15 = new IllegalArgumentException(var16.append(var13).append(" is not a valid enum NetworkType").toString());
                        throw var15;
                     } catch (IllegalArgumentException var11) {
                        var1.e(var14);
                        this.a(var1, var2);
                        continue;
                     }
               }
            case 16:
               int var3 = var1.m();

               int var4;
               try {
                  var4 = var1.c();
               } catch (IllegalArgumentException var9) {
                  var1.e(var3);
                  this.a(var1, var2);
                  break;
               }

               switch (var4) {
                  case 0:
                  case 1:
                  case 2:
                  case 3:
                  case 4:
                  case 5:
                  case 6:
                  case 7:
                  case 8:
                  case 9:
                  case 10:
                  case 11:
                  case 12:
                  case 13:
                  case 14:
                  case 15:
                  case 16:
                  case 100:
                     try {
                        this.b = var4;
                     } catch (IllegalArgumentException var7) {
                        var1.e(var3);
                        this.a(var1, var2);
                     }
                     continue;
                  default:
                     try {
                        StringBuilder var6 = new StringBuilder(45);
                        IllegalArgumentException var5 = new IllegalArgumentException(var6.append(var4).append(" is not a valid enum MobileSubtype").toString());
                        throw var5;
                     } catch (IllegalArgumentException var8) {
                        var1.e(var3);
                        this.a(var1, var2);
                        continue;
                     }
               }
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
      if (this.a != -1) {
         var1.a(1, this.a);
      }

      if (this.b != 0) {
         var1.a(2, this.b);
      }

      super.a(var1);
   }

   @Override
   protected final int b() {
      int var2 = super.b();
      int var1 = var2;
      if (this.a != -1) {
         var1 = var2 + zzfjk.b(1, this.a);
      }

      var2 = var1;
      if (this.b != 0) {
         var2 = var1 + zzfjk.b(2, this.b);
      }

      return var2;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var3 = true;
      boolean var2;
      if (var1 == this) {
         var2 = var3;
      } else if (!(var1 instanceof zzfks)) {
         var2 = false;
      } else {
         var1 = var1;
         if (this.a != var1.a) {
            var2 = false;
         } else if (this.b != var1.b) {
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
      int var4 = this.a;
      int var3 = this.b;
      int var1;
      if (this.H != null && !this.H.b()) {
         var1 = this.H.hashCode();
      } else {
         var1 = 0;
      }

      return var1 + (((var2 + 527) * 31 + var4) * 31 + var3) * 31;
   }
}
