package com.google.zxing.qrcode.encoder;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class Encoder {
   private static final int[] a = new int[]{
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      36,
      -1,
      -1,
      -1,
      37,
      38,
      -1,
      -1,
      -1,
      -1,
      39,
      40,
      -1,
      41,
      42,
      43,
      0,
      1,
      2,
      3,
      4,
      5,
      6,
      7,
      8,
      9,
      44,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      10,
      11,
      12,
      13,
      14,
      15,
      16,
      17,
      18,
      19,
      20,
      21,
      22,
      23,
      24,
      25,
      26,
      27,
      28,
      29,
      30,
      31,
      32,
      33,
      34,
      35,
      -1,
      -1,
      -1,
      -1,
      -1
   };

   static int a(int var0) {
      if (var0 < a.length) {
         var0 = a[var0];
      } else {
         var0 = -1;
      }

      return var0;
   }

   private static int a(BitArray var0, ErrorCorrectionLevel var1, Version var2, ByteMatrix var3) throws WriterException {
      int var5 = Integer.MAX_VALUE;
      int var6 = -1;

      for (int var4 = 0; var4 < 8; var4++) {
         MatrixUtil.a(var0, var1, var2, var4, var3);
         int var7 = a(var3);
         if (var7 < var5) {
            var6 = var4;
            var5 = var7;
         }
      }

      return var6;
   }

   private static int a(ByteMatrix var0) {
      return MaskUtil.a(var0) + MaskUtil.b(var0) + MaskUtil.c(var0) + MaskUtil.d(var0);
   }

   static BitArray a(BitArray var0, int var1, int var2, int var3) throws WriterException {
      if (var0.b() != var2) {
         throw new WriterException("Number of bits and data bytes does not match");
      }

      ArrayList var9 = new ArrayList(var3);
      int var7 = 0;
      int var4 = 0;
      int var6 = 0;
      int var5 = 0;

      while (var7 < var3) {
         int[] var11 = new int[1];
         int[] var12 = new int[1];
         a(var1, var2, var3, var7, var11, var12);
         int var8 = var11[0];
         byte[] var10 = new byte[var8];
         var0.a(var5 * 8, var10, 0, var8);
         byte[] var21 = a(var10, var12[0]);
         var9.add(new BlockPair(var10, var21));
         var6 = Math.max(var6, var8);
         var4 = Math.max(var4, var21.length);
         var8 = var11[0];
         var7++;
         var5 += var8;
      }

      if (var2 != var5) {
         throw new WriterException("Data bytes does not match offset");
      }

      var0 = new BitArray();

      for (int var14 = 0; var14 < var6; var14++) {
         Iterator var19 = var9.iterator();

         while (var19.hasNext()) {
            byte[] var17 = ((BlockPair)var19.next()).a();
            if (var14 < var17.length) {
               var0.a(var17[var14], 8);
            }
         }
      }

      for (int var15 = 0; var15 < var4; var15++) {
         Iterator var20 = var9.iterator();

         while (var20.hasNext()) {
            byte[] var18 = ((BlockPair)var20.next()).b();
            if (var15 < var18.length) {
               var0.a(var18[var15], 8);
            }
         }
      }

      if (var1 != var0.b()) {
         throw new WriterException("Interleaving error: " + var1 + " and " + var0.b() + " differ.");
      } else {
         return var0;
      }
   }

   private static Mode a(String var0, String var1) {
      int var2 = 0;
      Mode var6;
      if ("Shift_JIS".equals(var1)) {
         if (a(var0)) {
            var6 = Mode.KANJI;
         } else {
            var6 = Mode.BYTE;
         }
      } else {
         boolean var4 = false;
         boolean var3 = false;

         while (true) {
            if (var2 >= var0.length()) {
               if (var4) {
                  var6 = Mode.ALPHANUMERIC;
               } else if (var3) {
                  var6 = Mode.NUMERIC;
               } else {
                  var6 = Mode.BYTE;
               }
               break;
            }

            char var5 = var0.charAt(var2);
            if (var5 >= '0' && var5 <= '9') {
               var3 = true;
            } else {
               if (a(var5) == -1) {
                  var6 = Mode.BYTE;
                  break;
               }

               var4 = true;
            }

            var2++;
         }
      }

      return var6;
   }

   private static Version a(int var0, ErrorCorrectionLevel var1) throws WriterException {
      for (int var2 = 1; var2 <= 40; var2++) {
         Version var3 = Version.a(var2);
         if (var3.b() - var3.a(var1).c() >= (var0 + 7) / 8) {
            return var3;
         }
      }

      throw new WriterException("Data too big");
   }

   public static QRCode a(String var0, ErrorCorrectionLevel var1, Map<EncodeHintType, ?> var2) throws WriterException {
      String var10;
      if (var2 == null) {
         var10 = null;
      } else {
         var10 = (String)var2.get(EncodeHintType.CHARACTER_SET);
      }

      String var4 = var10;
      if (var10 == null) {
         var4 = "ISO-8859-1";
      }

      Mode var11 = a(var0, var4);
      BitArray var5 = new BitArray();
      if (var11 == Mode.BYTE && !"ISO-8859-1".equals(var4)) {
         CharacterSetECI var6 = CharacterSetECI.getCharacterSetECIByName(var4);
         if (var6 != null) {
            a(var6, var5);
         }
      }

      a(var11, var5);
      BitArray var20 = new BitArray();
      a(var0, var11, var20, var4);
      Version var17 = a(var5.a() + var11.getCharacterCountBits(Version.a(1)) + var20.a(), var1);
      int var3 = var5.a();
      Version var18 = a(var11.getCharacterCountBits(var17) + var3 + var20.a(), var1);
      BitArray var7 = new BitArray();
      var7.a(var5);
      if (var11 == Mode.BYTE) {
         var3 = var20.b();
      } else {
         var3 = var0.length();
      }

      a(var3, var18, var11, var7);
      var7.a(var20);
      Version.ECBlocks var8 = var18.a(var1);
      var3 = var18.b() - var8.c();
      a(var3, var7);
      var5 = a(var7, var18.b(), var3, var8.b());
      QRCode var9 = new QRCode();
      var9.a(var1);
      var9.a(var11);
      var9.a(var18);
      var3 = var18.c();
      ByteMatrix var12 = new ByteMatrix(var3, var3);
      var3 = a(var5, var1, var18, var12);
      var9.a(var3);
      MatrixUtil.a(var5, var1, var18, var3, var12);
      var9.a(var12);
      return var9;
   }

   static void a(int var0, int var1, int var2, int var3, int[] var4, int[] var5) throws WriterException {
      if (var3 >= var2) {
         throw new WriterException("Block ID too large");
      }

      int var6 = var0 % var2;
      int var7 = var2 - var6;
      int var10 = var0 / var2;
      var1 /= var2;
      int var9 = var1 + 1;
      int var8 = var10 - var1;
      var10 = var10 + 1 - var9;
      if (var8 != var10) {
         throw new WriterException("EC bytes mismatch");
      }

      if (var2 != var7 + var6) {
         throw new WriterException("RS blocks mismatch");
      }

      if (var0 != var6 * (var9 + var10) + (var1 + var8) * var7) {
         throw new WriterException("Total bytes mismatch");
      }

      if (var3 < var7) {
         var4[0] = var1;
         var5[0] = var8;
      } else {
         var4[0] = var9;
         var5[0] = var10;
      }
   }

   static void a(int var0, BitArray var1) throws WriterException {
      int var4 = var0 * 8;
      if (var1.a() > var4) {
         throw new WriterException("data bits cannot fit in the QR Code" + var1.a() + " > " + var4);
      }

      for (int var2 = 0; var2 < 4 && var1.a() < var4; var2++) {
         var1.a(false);
      }

      int var6 = var1.a() & 7;
      if (var6 > 0) {
         while (var6 < 8) {
            var1.a(false);
            var6++;
         }
      }

      int var5 = var1.b();

      for (int var7 = 0; var7 < var0 - var5; var7++) {
         short var3;
         if ((var7 & 1) == 0) {
            var3 = 236;
         } else {
            var3 = 17;
         }

         var1.a(var3, 8);
      }

      if (var1.a() != var4) {
         throw new WriterException("Bits size does not equal capacity");
      }
   }

   static void a(int var0, Version var1, Mode var2, BitArray var3) throws WriterException {
      int var4 = var2.getCharacterCountBits(var1);
      if (var0 >= 1 << var4) {
         throw new WriterException(var0 + " is bigger than " + ((1 << var4) - 1));
      }

      var3.a(var0, var4);
   }

   private static void a(CharacterSetECI var0, BitArray var1) {
      var1.a(Mode.ECI.getBits(), 4);
      var1.a(var0.getValue(), 8);
   }

   static void a(Mode var0, BitArray var1) {
      var1.a(var0.getBits(), 4);
   }

   static void a(CharSequence var0, BitArray var1) {
      int var3 = var0.length();
      int var2 = 0;

      while (var2 < var3) {
         int var4 = var0.charAt(var2) - '0';
         if (var2 + 2 < var3) {
            var1.a(var4 * 100 + (var0.charAt(var2 + 1) - '0') * 10 + (var0.charAt(var2 + 2) - '0'), 10);
            var2 += 3;
         } else if (var2 + 1 < var3) {
            var1.a(var4 * 10 + (var0.charAt(var2 + 1) - '0'), 7);
            var2 += 2;
         } else {
            var1.a(var4, 4);
            var2++;
         }
      }
   }

   static void a(String var0, BitArray var1) throws WriterException {
      try {
         var6 = var0.getBytes("Shift_JIS");
      } catch (UnsupportedEncodingException var5) {
         throw new WriterException(var5);
      }

      int var4 = var6.length;

      for (byte var3 = 0; var3 < var4; var3 += 2) {
         int var2 = (var6[var3] & 255) << 8 | var6[var3 + 1] & 255;
         if (var2 >= 33088 && var2 <= 40956) {
            var2 -= 33088;
         } else if (var2 >= 57408 && var2 <= 60351) {
            var2 -= 49472;
         } else {
            var2 = -1;
         }

         if (var2 == -1) {
            throw new WriterException("Invalid byte sequence");
         }

         var1.a((var2 & 0xFF) + (var2 >> 8) * 192, 13);
      }
   }

   static void a(String var0, BitArray var1, String var2) throws WriterException {
      try {
         var6 = var0.getBytes(var2);
      } catch (UnsupportedEncodingException var5) {
         throw new WriterException(var5);
      }

      int var4 = var6.length;

      for (int var3 = 0; var3 < var4; var3++) {
         var1.a(var6[var3], 8);
      }
   }

   static void a(String var0, Mode var1, BitArray var2, String var3) throws WriterException {
      switch (<unrepresentable>.a[var1.ordinal()]) {
         case 1:
            a((CharSequence)var0, var2);
            break;
         case 2:
            b(var0, var2);
            break;
         case 3:
            a(var0, var2, var3);
            break;
         case 4:
            a(var0, var2);
            break;
         default:
            throw new WriterException("Invalid mode: " + var1);
      }
   }

   private static boolean a(String var0) {
      boolean var5 = false;

      try {
         var7 = var0.getBytes("Shift_JIS");
      } catch (UnsupportedEncodingException var6) {
         return var5;
      }

      int var2 = var7.length;
      boolean var4;
      if (var2 % 2 != 0) {
         var4 = var5;
      } else {
         byte var1 = 0;

         while (true) {
            if (var1 >= var2) {
               var4 = true;
               break;
            }

            int var3 = var7[var1] & 255;
            if (var3 < 129 || var3 > 159) {
               var4 = var5;
               if (var3 < 224) {
                  break;
               }

               var4 = var5;
               if (var3 > 235) {
                  break;
               }
            }

            var1 += 2;
         }
      }

      return var4;
   }

   static byte[] a(byte[] var0, int var1) {
      byte var3 = 0;
      int var4 = var0.length;
      int[] var5 = new int[var4 + var1];

      for (int var2 = 0; var2 < var4; var2++) {
         var5[var2] = var0[var2] & 255;
      }

      new ReedSolomonEncoder(GenericGF.e).a(var5, var1);
      var0 = new byte[var1];

      for (int var7 = var3; var7 < var1; var7++) {
         var0[var7] = (byte)var5[var4 + var7];
      }

      return var0;
   }

   static void b(CharSequence var0, BitArray var1) throws WriterException {
      int var3 = var0.length();
      int var2 = 0;

      while (var2 < var3) {
         int var4 = a(var0.charAt(var2));
         if (var4 == -1) {
            throw new WriterException();
         }

         if (var2 + 1 < var3) {
            int var5 = a(var0.charAt(var2 + 1));
            if (var5 == -1) {
               throw new WriterException();
            }

            var1.a(var4 * 45 + var5, 11);
            var2 += 2;
         } else {
            var1.a(var4, 6);
            var2++;
         }
      }
   }
}
