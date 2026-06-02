package com.google.zxing.qrcode.encoder;

final class MaskUtil {
   static int a(ByteMatrix var0) {
      return a(var0, true) + a(var0, false);
   }

   private static int a(ByteMatrix var0, boolean var1) {
      int var5;
      if (var1) {
         var5 = var0.a();
      } else {
         var5 = var0.b();
      }

      int var6;
      if (var1) {
         var6 = var0.b();
      } else {
         var6 = var0.a();
      }

      byte[][] var10 = var0.c();
      int var7 = 0;
      int var2 = 0;

      while (var7 < var5) {
         int var3 = -1;
         int var8 = 0;
         int var9 = 0;

         while (var8 < var6) {
            byte var4;
            if (var1) {
               var4 = var10[var7][var8];
            } else {
               var4 = var10[var8][var7];
            }

            if (var4 == var3) {
               var4 = var9 + 1;
            } else {
               var3 = var2;
               if (var9 >= 5) {
                  var3 = var2 + var9 - 5 + 3;
               }

               byte var14 = 1;
               var2 = var3;
               var3 = var4;
               var4 = var14;
            }

            var8++;
            var9 = var4;
         }

         var3 = var2;
         if (var9 >= 5) {
            var3 = var2 + var9 - 5 + 3;
         }

         var7++;
         var2 = var3;
      }

      return var2;
   }

   static boolean a(int var0, int var1, int var2) {
      switch (var0) {
         case 0:
            var0 = var2 + var1 & 1;
            break;
         case 1:
            var0 = var2 & 1;
            break;
         case 2:
            var0 = var1 % 3;
            break;
         case 3:
            var0 = (var2 + var1) % 3;
            break;
         case 4:
            var0 = var2 / 2 + var1 / 3 & 1;
            break;
         case 5:
            var0 = var2 * var1;
            var0 = var0 % 3 + (var0 & 1);
            break;
         case 6:
            var0 = var2 * var1;
            var0 = var0 % 3 + (var0 & 1) & 1;
            break;
         case 7:
            var0 = var2 * var1 % 3 + (var2 + var1 & 1) & 1;
            break;
         default:
            throw new IllegalArgumentException("Invalid mask pattern: " + var0);
      }

      boolean var3;
      if (var0 == 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   private static boolean a(byte[] var0, int var1, int var2) {
      boolean var4 = true;

      boolean var3;
      while (true) {
         var3 = var4;
         if (var1 >= var2) {
            break;
         }

         if (var1 >= 0 && var1 < var0.length && var0[var1] == 1) {
            var3 = false;
            break;
         }

         var1++;
      }

      return var3;
   }

   private static boolean a(byte[][] var0, int var1, int var2, int var3) {
      boolean var5 = true;

      boolean var4;
      while (true) {
         var4 = var5;
         if (var2 >= var3) {
            break;
         }

         if (var2 >= 0 && var2 < var0.length && var0[var2][var1] == 1) {
            var4 = false;
            break;
         }

         var2++;
      }

      return var4;
   }

   static int b(ByteMatrix var0) {
      byte[][] var8 = var0.c();
      int var6 = var0.b();
      int var5 = var0.a();
      int var1 = 0;
      int var2 = 0;

      while (var1 < var5 - 1) {
         int var3 = 0;

         while (var3 < var6 - 1) {
            byte var7 = var8[var1][var3];
            int var4 = var2;
            if (var7 == var8[var1][var3 + 1]) {
               var4 = var2;
               if (var7 == var8[var1 + 1][var3]) {
                  var4 = var2;
                  if (var7 == var8[var1 + 1][var3 + 1]) {
                     var4 = var2 + 1;
                  }
               }
            }

            var3++;
            var2 = var4;
         }

         var1++;
      }

      return var2 * 3;
   }

   static int c(ByteMatrix var0) {
      byte[][] var7 = var0.c();
      int var5 = var0.b();
      int var6 = var0.a();
      int var3 = 0;
      int var1 = 0;

      while (var3 < var6) {
         for (int var4 = 0; var4 < var5; var4++) {
            byte[] var8 = var7[var3];
            int var2 = var1;
            if (var4 + 6 < var5) {
               var2 = var1;
               if (var8[var4] == 1) {
                  var2 = var1;
                  if (var8[var4 + 1] == 0) {
                     var2 = var1;
                     if (var8[var4 + 2] == 1) {
                        var2 = var1;
                        if (var8[var4 + 3] == 1) {
                           var2 = var1;
                           if (var8[var4 + 4] == 1) {
                              var2 = var1;
                              if (var8[var4 + 5] == 0) {
                                 var2 = var1;
                                 label55:
                                 if (var8[var4 + 6] == 1) {
                                    if (!a(var8, var4 - 4, var4)) {
                                       var2 = var1;
                                       if (!a(var8, var4 + 7, var4 + 11)) {
                                          break label55;
                                       }
                                    }

                                    var2 = var1 + 1;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            var1 = var2;
            if (var3 + 6 < var6) {
               var1 = var2;
               if (var7[var3][var4] == 1) {
                  var1 = var2;
                  if (var7[var3 + 1][var4] == 0) {
                     var1 = var2;
                     if (var7[var3 + 2][var4] == 1) {
                        var1 = var2;
                        if (var7[var3 + 3][var4] == 1) {
                           var1 = var2;
                           if (var7[var3 + 4][var4] == 1) {
                              var1 = var2;
                              if (var7[var3 + 5][var4] == 0) {
                                 var1 = var2;
                                 if (var7[var3 + 6][var4] == 1) {
                                    if (!a(var7, var4, var3 - 4, var3)) {
                                       var1 = var2;
                                       if (!a(var7, var4, var3 + 7, var3 + 11)) {
                                          continue;
                                       }
                                    }

                                    var1 = var2 + 1;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         var3++;
      }

      return var1 * 40;
   }

   static int d(ByteMatrix var0) {
      byte[][] var8 = var0.c();
      int var5 = var0.b();
      int var6 = var0.a();
      int var1 = 0;
      int var2 = 0;

      while (var1 < var6) {
         byte[] var7 = var8[var1];
         int var3 = 0;

         while (var3 < var5) {
            int var4 = var2;
            if (var7[var3] == 1) {
               var4 = var2 + 1;
            }

            var3++;
            var2 = var4;
         }

         var1++;
      }

      var1 = var0.a() * var0.b();
      return Math.abs(var2 * 2 - var1) * 10 / var1 * 10;
   }
}
