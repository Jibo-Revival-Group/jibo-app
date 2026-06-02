package com.google.android.gms.internal;

public final class zzfjo implements Cloneable {
   private static final zzfjp a = new zzfjp();
   private boolean b = false;
   private int[] c;
   private zzfjp[] d;
   private int e;

   zzfjo() {
      this(10);
   }

   private zzfjo(int var1) {
      var1 = c(var1);
      this.c = new int[var1];
      this.d = new zzfjp[var1];
      this.e = 0;
   }

   private static int c(int var0) {
      int var2 = var0 << 2;
      var0 = 4;

      int var1;
      while (true) {
         var1 = var2;
         if (var0 >= 32) {
            break;
         }

         if (var2 <= (1 << var0) - 12) {
            var1 = (1 << var0) - 12;
            break;
         }

         var0++;
      }

      return var1 / 4;
   }

   private final int d(int var1) {
      int var3 = this.e;
      int var2 = 0;
      var3--;

      while (true) {
         if (var2 > var3) {
            var3 = ~var2;
            break;
         }

         int var4 = var2 + var3 >>> 1;
         int var5 = this.c[var4];
         if (var5 < var1) {
            var2 = var4 + 1;
         } else {
            var3 = var4;
            if (var5 <= var1) {
               break;
            }

            var3 = var4 - 1;
         }
      }

      return var3;
   }

   final int a() {
      return this.e;
   }

   final zzfjp a(int var1) {
      var1 = this.d(var1);
      zzfjp var2;
      if (var1 >= 0 && this.d[var1] != a) {
         var2 = this.d[var1];
      } else {
         var2 = null;
      }

      return var2;
   }

   final void a(int var1, zzfjp var2) {
      int var3 = this.d(var1);
      if (var3 >= 0) {
         this.d[var3] = var2;
      } else {
         var3 = ~var3;
         if (var3 < this.e && this.d[var3] == a) {
            this.c[var3] = var1;
            this.d[var3] = var2;
         } else {
            if (this.e >= this.c.length) {
               int var4 = c(this.e + 1);
               int[] var6 = new int[var4];
               zzfjp[] var5 = new zzfjp[var4];
               System.arraycopy(this.c, 0, var6, 0, this.c.length);
               System.arraycopy(this.d, 0, var5, 0, this.d.length);
               this.c = var6;
               this.d = var5;
            }

            if (this.e - var3 != 0) {
               System.arraycopy(this.c, var3, this.c, var3 + 1, this.e - var3);
               System.arraycopy(this.d, var3, this.d, var3 + 1, this.e - var3);
            }

            this.c[var3] = var1;
            this.d[var3] = var2;
            this.e++;
         }
      }
   }

   final zzfjp b(int var1) {
      return this.d[var1];
   }

   public final boolean b() {
      boolean var1;
      if (this.e == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var4 = true;
      if (var1 != this) {
         if (!(var1 instanceof zzfjo)) {
            var4 = false;
         } else {
            var1 = var1;
            if (this.e != var1.e) {
               var4 = false;
            } else {
               int[] var5 = this.c;
               int[] var6 = var1.c;
               int var3 = this.e;
               int var2 = 0;

               while (true) {
                  if (var2 >= var3) {
                     var9 = true;
                     break;
                  }

                  if (var5[var2] != var6[var2]) {
                     var9 = false;
                     break;
                  }

                  var2++;
               }

               if (var9) {
                  zzfjp[] var13 = this.d;
                  zzfjp[] var8 = var1.d;
                  var3 = this.e;
                  var2 = 0;

                  while (true) {
                     if (var2 >= var3) {
                        var11 = true;
                        break;
                     }

                     if (!var13[var2].equals(var8[var2])) {
                        var11 = false;
                        break;
                     }

                     var2++;
                  }

                  if (var11) {
                     return var4;
                  }
               }

               var4 = false;
            }
         }
      }

      return var4;
   }

   @Override
   public final int hashCode() {
      int var2 = 17;

      for (int var1 = 0; var1 < this.e; var1++) {
         var2 = (var2 * 31 + this.c[var1]) * 31 + this.d[var1].hashCode();
      }

      return var2;
   }
}
