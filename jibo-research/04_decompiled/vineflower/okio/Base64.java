package okio;

import java.io.UnsupportedEncodingException;

final class Base64 {
   private static final byte[] a = new byte[]{
      65,
      66,
      67,
      68,
      69,
      70,
      71,
      72,
      73,
      74,
      75,
      76,
      77,
      78,
      79,
      80,
      81,
      82,
      83,
      84,
      85,
      86,
      87,
      88,
      89,
      90,
      97,
      98,
      99,
      100,
      101,
      102,
      103,
      104,
      105,
      106,
      107,
      108,
      109,
      110,
      111,
      112,
      113,
      114,
      115,
      116,
      117,
      118,
      119,
      120,
      121,
      122,
      48,
      49,
      50,
      51,
      52,
      53,
      54,
      55,
      56,
      57,
      43,
      47
   };
   private static final byte[] b = new byte[]{
      65,
      66,
      67,
      68,
      69,
      70,
      71,
      72,
      73,
      74,
      75,
      76,
      77,
      78,
      79,
      80,
      81,
      82,
      83,
      84,
      85,
      86,
      87,
      88,
      89,
      90,
      97,
      98,
      99,
      100,
      101,
      102,
      103,
      104,
      105,
      106,
      107,
      108,
      109,
      110,
      111,
      112,
      113,
      114,
      115,
      116,
      117,
      118,
      119,
      120,
      121,
      122,
      48,
      49,
      50,
      51,
      52,
      53,
      54,
      55,
      56,
      57,
      45,
      95
   };

   public static String a(byte[] var0) {
      return a(var0, a);
   }

   private static String a(byte[] var0, byte[] var1) {
      int var3 = 0;
      byte[] var6 = new byte[(var0.length + 2) / 3 * 4];
      int var4 = var0.length - var0.length % 3;
      int var2 = 0;

      while (var3 < var4) {
         int var5 = var2 + 1;
         var6[var2] = var1[(var0[var3] & 255) >> 2];
         var2 = var5 + 1;
         var6[var5] = var1[(var0[var3] & 3) << 4 | (var0[var3 + 1] & 255) >> 4];
         var5 = var2 + 1;
         var6[var2] = var1[(var0[var3 + 1] & 15) << 2 | (var0[var3 + 2] & 255) >> 6];
         var2 = var5 + 1;
         var6[var5] = var1[var0[var3 + 2] & 63];
         var3 += 3;
      }

      switch (var0.length % 3) {
         case 1:
            var3 = var2 + 1;
            var6[var2] = var1[(var0[var4] & 255) >> 2];
            var2 = var3 + 1;
            var6[var3] = var1[(var0[var4] & 3) << 4];
            var3 = var2 + 1;
            var6[var2] = 61;
            var6[var3] = 61;
            break;
         case 2:
            var3 = var2 + 1;
            var6[var2] = var1[(var0[var4] & 255) >> 2];
            var2 = var3 + 1;
            var6[var3] = var1[(var0[var4] & 3) << 4 | (var0[var4 + 1] & 255) >> 4];
            var3 = var2 + 1;
            var6[var2] = var1[(var0[var4 + 1] & 15) << 2];
            var6[var3] = 61;
      }

      try {
         return new String(var6, "US-ASCII");
      } catch (UnsupportedEncodingException var7) {
         throw new AssertionError(var7);
      }
   }

   public static byte[] a(String var0) {
      int var5;
      for (var5 = var0.length(); var5 > 0; var5--) {
         char var1 = var0.charAt(var5 - 1);
         if (var1 != '=' && var1 != '\n' && var1 != '\r' && var1 != ' ' && var1 != '\t') {
            break;
         }
      }

      byte[] var8 = new byte[(int)(var5 * 6L / 8L)];
      int var6 = 0;
      int var4 = 0;
      int var3 = 0;
      int var10 = 0;

      while (true) {
         if (var6 >= var5) {
            var3 %= 4;
            if (var3 == 1) {
               var9 = null;
            } else {
               int var13;
               if (var3 == 2) {
                  var8[var10] = (byte)(var4 << 12 >> 16);
                  var13 = var10 + 1;
               } else {
                  var13 = var10;
                  if (var3 == 3) {
                     var3 = var4 << 6;
                     var4 = var10 + 1;
                     var8[var10] = (byte)(var3 >> 16);
                     var13 = var4 + 1;
                     var8[var4] = (byte)(var3 >> 8);
                  }
               }

               if (var13 == var8.length) {
                  var9 = var8;
               } else {
                  var9 = new byte[var13];
                  System.arraycopy(var8, 0, var9, 0, var13);
               }
            }
            break;
         }

         int var12;
         label110: {
            int var2 = var0.charAt(var6);
            if (var2 >= 65 && var2 <= 90) {
               var2 -= 65;
            } else if (var2 >= 97 && var2 <= 122) {
               var2 -= 71;
            } else if (var2 >= 48 && var2 <= 57) {
               var2 += 4;
            } else if (var2 != 43 && var2 != 45) {
               if (var2 != 47 && var2 != 95) {
                  if (var2 != 10 && var2 != 13 && var2 != 32) {
                     if (var2 != 9) {
                        var9 = null;
                        break;
                     }

                     var12 = var4;
                  } else {
                     var12 = var4;
                  }
                  break label110;
               }

               var2 = 63;
            } else {
               var2 = 62;
            }

            var12 = (byte)var2 | var4 << 6;
            if (++var3 % 4 == 0) {
               int var7 = var10 + 1;
               var8[var10] = (byte)(var12 >> 16);
               var4 = var7 + 1;
               var8[var7] = (byte)(var12 >> 8);
               var10 = var4 + 1;
               var8[var4] = (byte)var12;
            }
         }

         var6++;
         var4 = var12;
      }

      return var9;
   }
}
