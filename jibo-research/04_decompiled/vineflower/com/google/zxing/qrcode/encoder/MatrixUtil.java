package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Version;

final class MatrixUtil {
   private static final int[][] a;
   private static final int[][] b;
   private static final int[][] c = new int[][]{
      {-1, -1, -1, -1, -1, -1, -1},
      {6, 18, -1, -1, -1, -1, -1},
      {6, 22, -1, -1, -1, -1, -1},
      {6, 26, -1, -1, -1, -1, -1},
      {6, 30, -1, -1, -1, -1, -1},
      {6, 34, -1, -1, -1, -1, -1},
      {6, 22, 38, -1, -1, -1, -1},
      {6, 24, 42, -1, -1, -1, -1},
      {6, 26, 46, -1, -1, -1, -1},
      {6, 28, 50, -1, -1, -1, -1},
      {6, 30, 54, -1, -1, -1, -1},
      {6, 32, 58, -1, -1, -1, -1},
      {6, 34, 62, -1, -1, -1, -1},
      {6, 26, 46, 66, -1, -1, -1},
      {6, 26, 48, 70, -1, -1, -1},
      {6, 26, 50, 74, -1, -1, -1},
      {6, 30, 54, 78, -1, -1, -1},
      {6, 30, 56, 82, -1, -1, -1},
      {6, 30, 58, 86, -1, -1, -1},
      {6, 34, 62, 90, -1, -1, -1},
      {6, 28, 50, 72, 94, -1, -1},
      {6, 26, 50, 74, 98, -1, -1},
      {6, 30, 54, 78, 102, -1, -1},
      {6, 28, 54, 80, 106, -1, -1},
      {6, 32, 58, 84, 110, -1, -1},
      {6, 30, 58, 86, 114, -1, -1},
      {6, 34, 62, 90, 118, -1, -1},
      {6, 26, 50, 74, 98, 122, -1},
      {6, 30, 54, 78, 102, 126, -1},
      {6, 26, 52, 78, 104, 130, -1},
      {6, 30, 56, 82, 108, 134, -1},
      {6, 34, 60, 86, 112, 138, -1},
      {6, 30, 58, 86, 114, 142, -1},
      {6, 34, 62, 90, 118, 146, -1},
      {6, 30, 54, 78, 102, 126, 150},
      {6, 24, 50, 76, 102, 128, 154},
      {6, 28, 54, 80, 106, 132, 158},
      {6, 32, 58, 84, 110, 136, 162},
      {6, 26, 54, 82, 110, 138, 166},
      {6, 30, 58, 86, 114, 142, 170}
   };
   private static final int[][] d;

   static {
      int[] var2 = new int[]{1, 1, 1, 1, 1, 1, 1};
      int[] var3 = new int[]{1, 0, 1, 1, 1, 0, 1};
      int[] var4 = new int[]{1, 0, 1, 1, 1, 0, 1};
      int[] var1 = new int[]{1, 0, 0, 0, 0, 0, 1};
      int[] var0 = new int[]{1, 1, 1, 1, 1, 1, 1};
      a = new int[][]{var2, {1, 0, 0, 0, 0, 0, 1}, var3, var4, {1, 0, 1, 1, 1, 0, 1}, var1, var0};
      var0 = new int[]{1, 0, 0, 0, 1};
      var1 = new int[]{1, 1, 1, 1, 1};
      b = new int[][]{{1, 1, 1, 1, 1}, var0, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, var1};
      var0 = new int[]{8, 4};
      int[] var5 = new int[]{8, 5};
      var4 = new int[]{8, 7};
      int[] var6 = new int[]{7, 8};
      var2 = new int[]{4, 8};
      var1 = new int[]{2, 8};
      var3 = new int[]{1, 8};
      d = new int[][]{{8, 0}, {8, 1}, {8, 2}, {8, 3}, var0, var5, var4, {8, 8}, var6, {5, 8}, var2, {3, 8}, var1, var3, {0, 8}};
   }

   static int a(int var0) {
      int var1;
      for (var1 = 0; var0 != 0; var1++) {
         var0 >>>= 1;
      }

      return var1;
   }

   static int a(int var0, int var1) {
      if (var1 == 0) {
         throw new IllegalArgumentException("0 polynomial");
      }

      int var2 = a(var1);
      var0 <<= var2 - 1;

      while (a(var0) >= var2) {
         var0 ^= var1 << a(var0) - var2;
      }

      return var0;
   }

   private static void a(int var0, int var1, ByteMatrix var2) throws WriterException {
      for (int var3 = 0; var3 < 8; var3++) {
         if (!b(var2.a(var0 + var3, var1))) {
            throw new WriterException();
         }

         var2.a(var0 + var3, var1, 0);
      }
   }

   static void a(BitArray var0, int var1, ByteMatrix var2) throws WriterException {
      int var5 = var2.b() - 1;
      int var4 = var2.a() - 1;
      int var6 = -1;
      int var3 = 0;

      while (var5 > 0) {
         if (var5 == 6) {
            var5--;
         }

         while (var4 >= 0 && var4 < var2.a()) {
            for (int var7 = 0; var7 < 2; var7++) {
               int var8 = var5 - var7;
               if (b(var2.a(var8, var4))) {
                  boolean var9;
                  if (var3 < var0.a()) {
                     var9 = var0.a(var3);
                     var3++;
                  } else {
                     var9 = false;
                  }

                  boolean var10 = var9;
                  if (var1 != -1) {
                     var10 = var9;
                     if (MaskUtil.a(var1, var8, var4)) {
                        if (!var9) {
                           var10 = true;
                        } else {
                           var10 = false;
                        }
                     }
                  }

                  var2.a(var8, var4, var10);
               }
            }

            var4 += var6;
         }

         var6 = -var6;
         var5 -= 2;
         var4 += var6;
      }

      if (var3 != var0.a()) {
         throw new WriterException("Not all bits consumed: " + var3 + '/' + var0.a());
      }
   }

   static void a(BitArray var0, ErrorCorrectionLevel var1, Version var2, int var3, ByteMatrix var4) throws WriterException {
      a(var4);
      a(var2, var4);
      a(var1, var3, var4);
      b(var2, var4);
      a(var0, var3, var4);
   }

   static void a(ErrorCorrectionLevel var0, int var1, BitArray var2) throws WriterException {
      if (!QRCode.b(var1)) {
         throw new WriterException("Invalid mask pattern");
      }

      var1 = var0.getBits() << 3 | var1;
      var2.a(var1, 5);
      var2.a(a(var1, 1335), 10);
      BitArray var3 = new BitArray();
      var3.a(21522, 15);
      var2.b(var3);
      if (var2.a() != 15) {
         throw new WriterException("should not happen but we got: " + var2.a());
      }
   }

   static void a(ErrorCorrectionLevel var0, int var1, ByteMatrix var2) throws WriterException {
      BitArray var4 = new BitArray();
      a(var0, var1, var4);

      for (int var5 = 0; var5 < var4.a(); var5++) {
         boolean var3 = var4.a(var4.a() - 1 - var5);
         var2.a(d[var5][0], d[var5][1], var3);
         if (var5 < 8) {
            var2.a(var2.b() - var5 - 1, 8, var3);
         } else {
            var2.a(8, var2.a() - 7 + (var5 - 8), var3);
         }
      }
   }

   static void a(Version var0, BitArray var1) throws WriterException {
      var1.a(var0.a(), 6);
      var1.a(a(var0.a(), 7973), 12);
      if (var1.a() != 18) {
         throw new WriterException("should not happen but we got: " + var1.a());
      }
   }

   static void a(Version var0, ByteMatrix var1) throws WriterException {
      d(var1);
      c(var1);
      c(var0, var1);
      b(var1);
   }

   static void a(ByteMatrix var0) {
      var0.a((byte)-1);
   }

   private static void b(int var0, int var1, ByteMatrix var2) throws WriterException {
      for (int var3 = 0; var3 < 7; var3++) {
         if (!b(var2.a(var0, var1 + var3))) {
            throw new WriterException();
         }

         var2.a(var0, var1 + var3, 0);
      }
   }

   static void b(Version var0, ByteMatrix var1) throws WriterException {
      if (var0.a() >= 7) {
         BitArray var6 = new BitArray();
         a(var0, var6);
         int var2 = 17;

         for (int var3 = 0; var3 < 6; var3++) {
            for (int var4 = 0; var4 < 3; var4++) {
               boolean var5 = var6.a(var2);
               var2--;
               var1.a(var3, var1.a() - 11 + var4, var5);
               var1.a(var1.a() - 11 + var4, var3, var5);
            }
         }
      }
   }

   private static void b(ByteMatrix var0) {
      for (int var1 = 8; var1 < var0.b() - 8; var1++) {
         int var2 = (var1 + 1) % 2;
         if (b(var0.a(var1, 6))) {
            var0.a(var1, 6, var2);
         }

         if (b(var0.a(6, var1))) {
            var0.a(6, var1, var2);
         }
      }
   }

   private static boolean b(int var0) {
      boolean var1;
      if (var0 == -1) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private static void c(int var0, int var1, ByteMatrix var2) {
      for (int var3 = 0; var3 < 5; var3++) {
         for (int var4 = 0; var4 < 5; var4++) {
            var2.a(var0 + var4, var1 + var3, b[var3][var4]);
         }
      }
   }

   private static void c(Version var0, ByteMatrix var1) {
      if (var0.a() >= 2) {
         int var2 = var0.a() - 1;
         int[] var7 = c[var2];
         int var4 = c[var2].length;

         for (int var8 = 0; var8 < var4; var8++) {
            for (int var3 = 0; var3 < var4; var3++) {
               int var6 = var7[var8];
               int var5 = var7[var3];
               if (var5 != -1 && var6 != -1 && b(var1.a(var5, var6))) {
                  c(var5 - 2, var6 - 2, var1);
               }
            }
         }
      }
   }

   private static void c(ByteMatrix var0) throws WriterException {
      if (var0.a(8, var0.a() - 8) == 0) {
         throw new WriterException();
      }

      var0.a(8, var0.a() - 8, 1);
   }

   private static void d(int var0, int var1, ByteMatrix var2) {
      for (int var3 = 0; var3 < 7; var3++) {
         for (int var4 = 0; var4 < 7; var4++) {
            var2.a(var0 + var4, var1 + var3, a[var3][var4]);
         }
      }
   }

   private static void d(ByteMatrix var0) throws WriterException {
      int var1 = a[0].length;
      d(0, 0, var0);
      d(var0.b() - var1, 0, var0);
      d(0, var0.b() - var1, var0);
      a(0, 7, var0);
      a(var0.b() - 8, 7, var0);
      a(0, var0.b() - 8, var0);
      b(7, 0, var0);
      b(var0.a() - 7 - 1, 0, var0);
      b(7, var0.a() - 7, var0);
   }
}
