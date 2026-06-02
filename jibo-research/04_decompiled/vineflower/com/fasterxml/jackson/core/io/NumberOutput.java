package com.fasterxml.jackson.core.io;

public final class NumberOutput {
   static final String a = String.valueOf(Long.MIN_VALUE);
   static final char[] b = new char[4000];
   static final char[] c = new char[4000];
   static final byte[] d;
   static final String[] e;
   static final String[] f;
   private static int g = 1000000;
   private static int h = 1000000000;
   private static long i = 10000000000L;
   private static long j = 1000L;
   private static long k = -2147483648L;
   private static long l = 2147483647L;

   static {
      int var6 = 0;
      byte var5 = 0;

      while (var6 < 10) {
         char var2 = (char)(var6 + 48);
         char var0;
         if (var6 == 0) {
            var0 = 0;
         } else {
            var0 = var2;
         }

         for (int var7 = 0; var7 < 10; var7++) {
            char var3 = (char)(var7 + 48);
            char var1;
            if (var6 == 0 && var7 == 0) {
               var1 = 0;
            } else {
               var1 = var3;
            }

            for (int var8 = 0; var8 < 10; var8++) {
               char var4 = (char)(var8 + 48);
               b[var5] = var0;
               b[var5 + 1] = var1;
               b[var5 + 2] = var4;
               c[var5] = var2;
               c[var5 + 1] = var3;
               c[var5 + 2] = var4;
               var5 += 4;
            }
         }

         var6++;
      }

      d = new byte[4000];

      for (int var9 = 0; var9 < 4000; var9++) {
         d[var9] = (byte)c[var9];
      }

      e = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
      f = new String[]{"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10"};
   }

   public static int a(int var0, byte[] var1, int var2) {
      int var4 = var0;
      int var3 = var2;
      if (var0 < 0) {
         if (var0 == Integer.MIN_VALUE) {
            var0 = a((long)var0, var1, var2);
            return var0;
         }

         var1[var2] = 45;
         var4 = -var0;
         var3 = var2 + 1;
      }

      if (var4 < g) {
         if (var4 < 1000) {
            if (var4 < 10) {
               var0 = var3 + 1;
               var1[var3] = (byte)(var4 + 48);
            } else {
               var0 = b(var4, var1, var3);
            }
         } else {
            var0 = var4 / 1000;
            var0 = c(var4 - var0 * 1000, var1, b(var0, var1, var3));
         }
      } else {
         boolean var5;
         if (var4 >= h) {
            var5 = true;
         } else {
            var5 = false;
         }

         var0 = var4;
         var2 = var3;
         if (var5) {
            var0 = var4 - h;
            if (var0 >= h) {
               var0 -= h;
               var1[var3] = 50;
               var2 = var3 + 1;
            } else {
               var1[var3] = 49;
               var2 = var3 + 1;
            }
         }

         var4 = var0 / 1000;
         var3 = var4 / 1000;
         if (var5) {
            var2 = c(var3, var1, var2);
         } else {
            var2 = b(var3, var1, var2);
         }

         var0 = c(var0 - var4 * 1000, var1, c(var4 - var3 * 1000, var1, var2));
      }

      return var0;
   }

   public static int a(int var0, char[] var1, int var2) {
      int var4 = var0;
      int var3 = var2;
      if (var0 < 0) {
         if (var0 == Integer.MIN_VALUE) {
            var0 = a((long)var0, var1, var2);
            return var0;
         }

         var1[var2] = '-';
         var4 = -var0;
         var3 = var2 + 1;
      }

      if (var4 < g) {
         if (var4 < 1000) {
            if (var4 < 10) {
               var0 = var3 + 1;
               var1[var3] = (char)(var4 + 48);
            } else {
               var0 = b(var4, var1, var3);
            }
         } else {
            var0 = var4 / 1000;
            var0 = c(var4 - var0 * 1000, var1, b(var0, var1, var3));
         }
      } else {
         boolean var5;
         if (var4 >= h) {
            var5 = true;
         } else {
            var5 = false;
         }

         var0 = var4;
         var2 = var3;
         if (var5) {
            var0 = var4 - h;
            if (var0 >= h) {
               var0 -= h;
               var1[var3] = '2';
               var2 = var3 + 1;
            } else {
               var1[var3] = '1';
               var2 = var3 + 1;
            }
         }

         var4 = var0 / 1000;
         var3 = var4 / 1000;
         if (var5) {
            var2 = c(var3, var1, var2);
         } else {
            var2 = b(var3, var1, var2);
         }

         var0 = c(var0 - var4 * 1000, var1, c(var4 - var3 * 1000, var1, var2));
      }

      return var0;
   }

   private static int a(long var0) {
      int var2 = 10;

      for (long var3 = i; var0 >= var3 && var2 != 19; var3 = (var3 << 1) + (var3 << 3)) {
         var2++;
      }

      return var2;
   }

   public static int a(long var0, byte[] var2, int var3) {
      int var4;
      long var8;
      if (var0 < 0L) {
         if (var0 > k) {
            var3 = a((int)var0, var2, var3);
            return var3;
         }

         if (var0 == Long.MIN_VALUE) {
            int var6 = a.length();
            int var5 = 0;
            var4 = var3;

            while (true) {
               var3 = var4;
               if (var5 >= var6) {
                  return var3;
               }

               var2[var4] = (byte)a.charAt(var5);
               var5++;
               var4++;
            }
         }

         var2[var3] = 45;
         var8 = -var0;
         var4 = var3 + 1;
      } else {
         var8 = var0;
         var4 = var3;
         if (var0 <= l) {
            var3 = a((int)var0, var2, var3);
            return var3;
         }
      }

      int var15 = var4 + a(var8);
      var3 = var15;

      while (var8 > l) {
         var3 -= 3;
         var0 = var8 / j;
         c((int)(var8 - j * var0), var2, var3);
         var8 = var0;
      }

      int var7 = (int)var8;
      int var16 = var3;
      var3 = var7;

      while (var3 >= 1000) {
         var16 -= 3;
         var7 = var3 / 1000;
         c(var3 - var7 * 1000, var2, var16);
         var3 = var7;
      }

      b(var3, var2, var4);
      return var15;
   }

   public static int a(long var0, char[] var2, int var3) {
      int var4;
      long var8;
      if (var0 < 0L) {
         if (var0 > k) {
            return a((int)var0, var2, var3);
         }

         if (var0 == Long.MIN_VALUE) {
            var4 = a.length();
            a.getChars(0, var4, var2, var3);
            return var3 + var4;
         }

         var2[var3] = '-';
         var8 = -var0;
         var4 = var3 + 1;
      } else {
         var8 = var0;
         var4 = var3;
         if (var0 <= l) {
            return a((int)var0, var2, var3);
         }
      }

      int var5 = var4 + a(var8);
      var3 = var5;

      while (var8 > l) {
         var3 -= 3;
         var0 = var8 / j;
         c((int)(var8 - j * var0), var2, var3);
         var8 = var0;
      }

      int var7 = (int)var8;
      int var6 = var3;
      var3 = var7;

      while (var3 >= 1000) {
         var6 -= 3;
         var7 = var3 / 1000;
         c(var3 - var7 * 1000, var2, var6);
         var3 = var7;
      }

      b(var3, var2, var4);
      return var5;
   }

   private static int b(int var0, byte[] var1, int var2) {
      var0 <<= 2;
      char[] var5 = b;
      int var3 = var0 + 1;
      char var4 = var5[var0];
      var0 = var2;
      if (var4 != 0) {
         var1[var2] = (byte)var4;
         var0 = var2 + 1;
      }

      var4 = b[var3];
      var2 = var0;
      if (var4 != 0) {
         var1[var0] = (byte)var4;
         var2 = var0 + 1;
      }

      var1[var2] = (byte)b[var3 + 1];
      return var2 + 1;
   }

   private static int b(int var0, char[] var1, int var2) {
      var0 <<= 2;
      char[] var5 = b;
      int var4 = var0 + 1;
      char var3 = var5[var0];
      var0 = var2;
      if (var3 != 0) {
         var1[var2] = var3;
         var0 = var2 + 1;
      }

      var3 = b[var4];
      var2 = var0;
      if (var3 != 0) {
         var1[var0] = var3;
         var2 = var0 + 1;
      }

      var1[var2] = b[var4 + 1];
      return var2 + 1;
   }

   private static int c(int var0, byte[] var1, int var2) {
      int var4 = var0 << 2;
      var0 = var2 + 1;
      byte[] var5 = d;
      int var3 = var4 + 1;
      var1[var2] = var5[var4];
      var2 = var0 + 1;
      var1[var0] = d[var3];
      var1[var2] = d[var3 + 1];
      return var2 + 1;
   }

   private static int c(int var0, char[] var1, int var2) {
      int var4 = var0 << 2;
      var0 = var2 + 1;
      char[] var5 = c;
      int var3 = var4 + 1;
      var1[var2] = var5[var4];
      var2 = var0 + 1;
      var1[var0] = c[var3];
      var1[var2] = c[var3 + 1];
      return var2 + 1;
   }
}
