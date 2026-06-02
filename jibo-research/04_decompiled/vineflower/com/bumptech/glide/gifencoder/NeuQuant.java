package com.bumptech.glide.gifencoder;

class NeuQuant {
   protected int a;
   protected byte[] b;
   protected int c;
   protected int d;
   protected int[][] e;
   protected int[] f = new int[256];
   protected int[] g = new int[256];
   protected int[] h = new int[256];
   protected int[] i = new int[32];

   public NeuQuant(byte[] var1, int var2, int var3) {
      this.b = (byte[])var1;
      this.c = var2;
      this.d = var3;
      this.e = new int[256][];

      for (int var5 = 0; var5 < 256; var5++) {
         this.e[var5] = new int[4];
         var1 = this.e[var5];
         var3 = (var5 << 12) / 256;
         var1[2] = var3;
         var1[1] = var3;
         var1[0] = var3;
         this.h[var5] = 256;
         this.g[var5] = 0;
      }
   }

   public int a(int var1, int var2, int var3) {
      int var6 = this.f[var2];
      int var7 = var6 - 1;
      int var5 = 1000;
      int var4 = -1;

      while (var6 < 256 || var7 >= 0) {
         label61: {
            int var8 = var6;
            if (var6 < 256) {
               int[] var11 = this.e[var6];
               int var9 = var11[1] - var2;
               if (var9 >= var5) {
                  short var21 = 256;
                  var6 = var4;
                  var4 = var21;
                  break label61;
               }

               var6++;
               var8 = var9;
               if (var9 < 0) {
                  var8 = -var9;
               }

               int var10 = var11[0] - var1;
               var9 = var10;
               if (var10 < 0) {
                  var9 = -var10;
               }

               var10 = var9 + var8;
               var8 = var6;
               if (var10 < var5) {
                  var9 = var11[2] - var3;
                  var8 = var9;
                  if (var9 < 0) {
                     var8 = -var9;
                  }

                  var9 = var10 + var8;
                  var8 = var6;
                  if (var9 < var5) {
                     var5 = var11[3];
                     var4 = var6;
                     var6 = var5;
                     var5 = var9;
                     break label61;
                  }
               }
            }

            var6 = var4;
            var4 = var8;
         }

         int var22 = var7;
         if (var7 >= 0) {
            int[] var36 = this.e[var7];
            int var29 = var2 - var36[1];
            if (var29 >= var5) {
               byte var25 = -1;
               var7 = var6;
               var6 = var4;
               var4 = var7;
               var7 = var25;
               continue;
            }

            var7--;
            var22 = var29;
            if (var29 < 0) {
               var22 = -var29;
            }

            int var34 = var36[0] - var1;
            var29 = var34;
            if (var34 < 0) {
               var29 = -var34;
            }

            var34 = var29 + var22;
            var22 = var7;
            if (var34 < var5) {
               var29 = var36[2] - var3;
               var22 = var29;
               if (var29 < 0) {
                  var22 = -var29;
               }

               var29 = var22 + var34;
               var22 = var7;
               if (var29 < var5) {
                  var5 = var36[3];
                  var6 = var4;
                  var4 = var5;
                  var5 = var29;
                  continue;
               }
            }
         }

         var7 = var4;
         var4 = var6;
         var6 = var7;
         var7 = var22;
      }

      return var4;
   }

   protected void a(int var1, int var2, int var3, int var4, int var5) {
      int var8 = var2 - var1;
      if (var8 < -1) {
         var8 = -1;
      }

      var1 = var2 + var1;
      int var9 = var1;
      if (var1 > 256) {
         var9 = 256;
      }

      int var6 = 1;
      int var7 = var2 - 1;
      var1 = var2 + 1;
      var2 = var6;

      while (var1 < var9 || var7 > var8) {
         int var10;
         int[] var11 = this.i;
         var6 = var2 + 1;
         var10 = var11[var2];
         label38:
         if (var1 < var9) {
            int[][] var20 = this.e;
            var2 = var1 + 1;
            var11 = var20[var1];

            try {
               var11[0] -= (var11[0] - var3) * var10 / 262144;
               var11[1] -= (var11[1] - var4) * var10 / 262144;
               var11[2] -= (var11[2] - var5) * var10 / 262144;
            } catch (Exception var12) {
               var1 = var2;
               break label38;
            }

            var1 = var2;
         }

         if (var7 > var8) {
            int[][] var22 = this.e;
            var2 = var7 - 1;
            var11 = var22[var7];

            try {
               var11[0] -= (var11[0] - var3) * var10 / 262144;
               var11[1] -= (var11[1] - var4) * var10 / 262144;
               var11[2] -= var10 * (var11[2] - var5) / 262144;
            } catch (Exception var13) {
               var7 = var2;
               var2 = var6;
               continue;
            }

            var7 = var2;
            var2 = var6;
         } else {
            var2 = var6;
         }
      }
   }

   public byte[] a() {
      byte[] var7 = new byte[768];
      int[] var6 = new int[256];
      int var1 = 0;

      while (var1 < 256) {
         var6[this.e[var1][3]] = var1++;
      }

      var1 = 0;
      int var2 = 0;

      while (var1 < 256) {
         int var3 = var6[var1];
         int var4 = var2 + 1;
         var7[var2] = (byte)this.e[var3][0];
         int var5 = var4 + 1;
         var7[var4] = (byte)this.e[var3][1];
         var2 = var5 + 1;
         var7[var5] = (byte)this.e[var3][2];
         var1++;
      }

      return var7;
   }

   protected int b(int var1, int var2, int var3) {
      int var5 = Integer.MAX_VALUE;
      int var6 = -1;
      int var4 = 0;
      int var8 = -1;
      int var7 = Integer.MAX_VALUE;

      while (var4 < 256) {
         int[] var13 = this.e[var4];
         int var10 = var13[0] - var1;
         int var9 = var10;
         if (var10 < 0) {
            var9 = -var10;
         }

         int var11 = var13[1] - var2;
         var10 = var11;
         if (var11 < 0) {
            var10 = -var11;
         }

         int var12 = var13[2] - var3;
         var11 = var12;
         if (var12 < 0) {
            var11 = -var12;
         }

         var10 = var10 + var9 + var11;
         if (var10 < var7) {
            var7 = var4;
            var8 = var10;
         } else {
            var9 = var8;
            var8 = var7;
            var7 = var9;
         }

         var9 = var10 - (this.g[var4] >> 12);
         if (var9 < var5) {
            var5 = var9;
            var6 = var4;
         }

         var9 = this.h[var4] >> 10;
         var13 = this.h;
         var13[var4] -= var9;
         var13 = this.g;
         var13[var4] += var9 << 10;
         var4++;
         var9 = var8;
         var8 = var7;
         var7 = var9;
      }

      int[] var25 = this.h;
      var25[var8] += 64;
      var25 = this.g;
      var25[var8] -= 65536;
      return var6;
   }

   public void b() {
      int var1 = 0;
      int var3 = 0;
      int var2 = 0;

      while (var1 < 256) {
         int[] var8 = this.e[var1];
         int var4 = var8[1];
         int var5 = var1 + 1;
         int var7 = var1;

         while (var5 < 256) {
            int[] var9 = this.e[var5];
            int var6 = var4;
            if (var9[1] < var4) {
               var6 = var9[1];
               var7 = var5;
            }

            var5++;
            var4 = var6;
         }

         int[] var16 = this.e[var7];
         if (var1 != var7) {
            var5 = var16[0];
            var16[0] = var8[0];
            var8[0] = var5;
            var5 = var16[1];
            var16[1] = var8[1];
            var8[1] = var5;
            var5 = var16[2];
            var16[2] = var8[2];
            var8[2] = var5;
            var5 = var16[3];
            var16[3] = var8[3];
            var8[3] = var5;
         }

         if (var4 != var2) {
            this.f[var2] = var3 + var1 >> 1;
            var2++;

            while (var2 < var4) {
               this.f[var2] = var1;
               var2++;
            }

            var2 = var4;
            var3 = var1;
         }

         var1++;
      }

      this.f[var2] = var3 + 255 >> 1;

      for (int var10 = var2 + 1; var10 < 256; var10++) {
         this.f[var10] = 255;
      }
   }

   protected void b(int var1, int var2, int var3, int var4, int var5) {
      int[] var6 = this.e[var2];
      var6[0] -= (var6[0] - var3) * var1 / 1024;
      var6[1] -= (var6[1] - var4) * var1 / 1024;
      var6[2] -= (var6[2] - var5) * var1 / 1024;
   }

   public void c() {
      if (this.c < 1509) {
         this.d = 1;
      }

      this.a = (this.d - 1) / 3 + 30;
      byte[] var14 = this.b;
      int var9 = this.c;
      int var10 = this.c / (this.d * 3);
      int var3 = var10 / 100;

      for (int var1 = 0; var1 < 32; var1++) {
         this.i[var1] = (1024 - var1 * var1) * 256 / 1024 * 1024;
      }

      short var15;
      if (this.c < 1509) {
         var15 = 3;
      } else if (this.c % 499 != 0) {
         var15 = 1497;
      } else if (this.c % 491 != 0) {
         var15 = 1473;
      } else if (this.c % 487 != 0) {
         var15 = 1461;
      } else {
         var15 = 1509;
      }

      int var4 = 0;
      int var6 = 32;
      int var5 = 2048;
      int var2 = 0;
      int var7 = 1024;

      while (var4 < var10) {
         int var8 = (var14[var2 + 0] & 255) << 4;
         int var11 = (var14[var2 + 1] & 255) << 4;
         int var12 = (var14[var2 + 2] & 255) << 4;
         int var13 = this.b(var8, var11, var12);
         this.b(var7, var13, var8, var11, var12);
         if (var6 != 0) {
            this.a(var6, var13, var8, var11, var12);
         }

         var2 += var15;
         if (var2 >= var9) {
            var2 -= this.c;
         }

         var8 = var4 + 1;
         if (var3 == 0) {
            var3 = 1;
         }

         if (var8 % var3 == 0) {
            var7 -= var7 / this.a;
            var6 = var5 - var5 / 30;
            var5 = var6 >> 6;
            var4 = var5;
            if (var5 <= 1) {
               var4 = 0;
            }

            for (int var18 = 0; var18 < var4; var18++) {
               this.i[var18] = (var4 * var4 - var18 * var18) * 256 / (var4 * var4) * var7;
            }

            var5 = var6;
            var6 = var4;
            var4 = var8;
         } else {
            var4 = var8;
         }
      }
   }

   public byte[] d() {
      this.c();
      this.e();
      this.b();
      return this.a();
   }

   public void e() {
      int var1 = 0;

      while (var1 < 256) {
         int[] var2 = this.e[var1];
         var2[0] >>= 4;
         var2 = this.e[var1];
         var2[1] >>= 4;
         var2 = this.e[var1];
         var2[2] >>= 4;
         this.e[var1][3] = var1++;
      }
   }
}
