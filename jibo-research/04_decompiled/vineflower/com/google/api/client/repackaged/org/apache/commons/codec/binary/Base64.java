package com.google.api.client.repackaged.org.apache.commons.codec.binary;

import java.math.BigInteger;

public class Base64 extends BaseNCodec {
   private static final int BITS_PER_ENCODED_BYTE = 6;
   private static final int BYTES_PER_ENCODED_BLOCK = 4;
   private static final int BYTES_PER_UNENCODED_BLOCK = 3;
   static final byte[] CHUNK_SEPARATOR = new byte[]{13, 10};
   private static final byte[] DECODE_TABLE = new byte[]{
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
      62,
      -1,
      62,
      -1,
      63,
      52,
      53,
      54,
      55,
      56,
      57,
      58,
      59,
      60,
      61,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
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
      -1,
      -1,
      -1,
      -1,
      63,
      -1,
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
      36,
      37,
      38,
      39,
      40,
      41,
      42,
      43,
      44,
      45,
      46,
      47,
      48,
      49,
      50,
      51
   };
   private static final int MASK_6BITS = 63;
   private static final byte[] STANDARD_ENCODE_TABLE = new byte[]{
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
   private static final byte[] URL_SAFE_ENCODE_TABLE = new byte[]{
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
   private int bitWorkArea;
   private final int decodeSize;
   private final byte[] decodeTable;
   private final int encodeSize;
   private final byte[] encodeTable;
   private final byte[] lineSeparator;

   public Base64() {
      this(0);
   }

   public Base64(int var1) {
      this(var1, CHUNK_SEPARATOR);
   }

   public Base64(int var1, byte[] var2) {
      this(var1, var2, false);
   }

   public Base64(int var1, byte[] var2, boolean var3) {
      int var4;
      if (var2 == null) {
         var4 = 0;
      } else {
         var4 = var2.length;
      }

      super(3, 4, var1, var4);
      this.decodeTable = DECODE_TABLE;
      if (var2 != null) {
         if (this.containsAlphabetOrPad(var2)) {
            String var5 = StringUtils.newStringUtf8(var2);
            throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + var5 + "]");
         }

         if (var1 > 0) {
            this.encodeSize = var2.length + 4;
            this.lineSeparator = new byte[var2.length];
            System.arraycopy(var2, 0, this.lineSeparator, 0, var2.length);
         } else {
            this.encodeSize = 4;
            this.lineSeparator = null;
         }
      } else {
         this.encodeSize = 4;
         this.lineSeparator = null;
      }

      this.decodeSize = this.encodeSize - 1;
      if (var3) {
         var2 = URL_SAFE_ENCODE_TABLE;
      } else {
         var2 = STANDARD_ENCODE_TABLE;
      }

      this.encodeTable = var2;
   }

   public Base64(boolean var1) {
      this(76, CHUNK_SEPARATOR, var1);
   }

   public static byte[] decodeBase64(String var0) {
      return new Base64().decode(var0);
   }

   public static byte[] decodeBase64(byte[] var0) {
      return new Base64().decode(var0);
   }

   public static BigInteger decodeInteger(byte[] var0) {
      return new BigInteger(1, decodeBase64(var0));
   }

   public static byte[] encodeBase64(byte[] var0) {
      return encodeBase64(var0, false);
   }

   public static byte[] encodeBase64(byte[] var0, boolean var1) {
      return encodeBase64(var0, var1, false);
   }

   public static byte[] encodeBase64(byte[] var0, boolean var1, boolean var2) {
      return encodeBase64(var0, var1, var2, Integer.MAX_VALUE);
   }

   public static byte[] encodeBase64(byte[] var0, boolean var1, boolean var2, int var3) {
      byte[] var6 = var0;
      if (var0 != null) {
         if (var0.length == 0) {
            var6 = var0;
         } else {
            Base64 var7;
            if (var1) {
               var7 = new Base64(var2);
            } else {
               var7 = new Base64(0, CHUNK_SEPARATOR, var2);
            }

            long var4 = var7.getEncodedLength(var0);
            if (var4 > var3) {
               throw new IllegalArgumentException(
                  "Input array too big, the output array would be bigger (" + var4 + ") than the specified maximum size of " + var3
               );
            }

            var6 = var7.encode(var0);
         }
      }

      return var6;
   }

   public static byte[] encodeBase64Chunked(byte[] var0) {
      return encodeBase64(var0, true);
   }

   public static String encodeBase64String(byte[] var0) {
      return StringUtils.newStringUtf8(encodeBase64(var0, false));
   }

   public static byte[] encodeBase64URLSafe(byte[] var0) {
      return encodeBase64(var0, false, true);
   }

   public static String encodeBase64URLSafeString(byte[] var0) {
      return StringUtils.newStringUtf8(encodeBase64(var0, false, true));
   }

   public static byte[] encodeInteger(BigInteger var0) {
      if (var0 == null) {
         throw new NullPointerException("encodeInteger called with null parameter");
      } else {
         return encodeBase64(toIntegerBytes(var0), false);
      }
   }

   public static boolean isArrayByteBase64(byte[] var0) {
      return isBase64(var0);
   }

   public static boolean isBase64(byte var0) {
      boolean var1;
      if (var0 != 61 && (var0 < 0 || var0 >= DECODE_TABLE.length || DECODE_TABLE[var0] == -1)) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public static boolean isBase64(String var0) {
      return isBase64(StringUtils.getBytesUtf8(var0));
   }

   public static boolean isBase64(byte[] var0) {
      boolean var2 = false;
      int var1 = 0;

      while (true) {
         if (var1 >= var0.length) {
            var2 = true;
            break;
         }

         if (!isBase64(var0[var1]) && !isWhiteSpace(var0[var1])) {
            break;
         }

         var1++;
      }

      return var2;
   }

   static byte[] toIntegerBytes(BigInteger var0) {
      int var4 = var0.bitLength() + 7 >> 3 << 3;
      byte[] var5 = var0.toByteArray();
      byte[] var6;
      if (var0.bitLength() % 8 != 0 && var0.bitLength() / 8 + 1 == var4 / 8) {
         var6 = var5;
      } else {
         byte var2 = 0;
         int var3 = var5.length;
         int var1 = var3;
         if (var0.bitLength() % 8 == 0) {
            var2 = 1;
            var1 = var3 - 1;
         }

         var3 = var4 / 8;
         var6 = new byte[var4 / 8];
         System.arraycopy(var5, var2, var6, var3 - var1, var1);
      }

      return var6;
   }

   @Override
   void decode(byte[] var1, int var2, int var3) {
      if (!this.eof) {
         if (var3 < 0) {
            this.eof = true;
         }

         int var4 = 0;

         while (var4 < var3) {
            this.ensureBufferSize(this.decodeSize);
            int var5 = var1[var2];
            if (var5 == 61) {
               this.eof = true;
               break;
            }

            if (var5 >= 0 && var5 < DECODE_TABLE.length) {
               var5 = DECODE_TABLE[var5];
               if (var5 >= 0) {
                  this.modulus = (this.modulus + 1) % 4;
                  this.bitWorkArea = var5 + (this.bitWorkArea << 6);
                  if (this.modulus == 0) {
                     byte[] var6 = this.buffer;
                     var5 = this.pos++;
                     var6[var5] = (byte)(this.bitWorkArea >> 16 & 0xFF);
                     var6 = this.buffer;
                     var5 = this.pos++;
                     var6[var5] = (byte)(this.bitWorkArea >> 8 & 0xFF);
                     var6 = this.buffer;
                     var5 = this.pos++;
                     var6[var5] = (byte)(this.bitWorkArea & 0xFF);
                  }
               }
            }

            var4++;
            var2++;
         }

         if (this.eof && this.modulus != 0) {
            this.ensureBufferSize(this.decodeSize);
            switch (this.modulus) {
               case 2:
                  this.bitWorkArea >>= 4;
                  var1 = this.buffer;
                  var2 = this.pos++;
                  var1[var2] = (byte)(this.bitWorkArea & 0xFF);
                  break;
               case 3:
                  this.bitWorkArea >>= 2;
                  var1 = this.buffer;
                  var2 = this.pos++;
                  var1[var2] = (byte)(this.bitWorkArea >> 8 & 0xFF);
                  var1 = this.buffer;
                  var2 = this.pos++;
                  var1[var2] = (byte)(this.bitWorkArea & 0xFF);
            }
         }
      }
   }

   @Override
   void encode(byte[] var1, int var2, int var3) {
      if (!this.eof) {
         if (var3 < 0) {
            this.eof = true;
            if (this.modulus != 0 || this.lineLength != 0) {
               this.ensureBufferSize(this.encodeSize);
               var2 = this.pos;
               switch (this.modulus) {
                  case 1:
                     var1 = this.buffer;
                     var3 = this.pos++;
                     var1[var3] = this.encodeTable[this.bitWorkArea >> 2 & 63];
                     var1 = this.buffer;
                     var3 = this.pos++;
                     var1[var3] = this.encodeTable[this.bitWorkArea << 4 & 63];
                     if (this.encodeTable == STANDARD_ENCODE_TABLE) {
                        var1 = this.buffer;
                        var3 = this.pos++;
                        var1[var3] = 61;
                        var1 = this.buffer;
                        var3 = this.pos++;
                        var1[var3] = 61;
                     }
                     break;
                  case 2:
                     var1 = this.buffer;
                     var3 = this.pos++;
                     var1[var3] = this.encodeTable[this.bitWorkArea >> 10 & 63];
                     var1 = this.buffer;
                     var3 = this.pos++;
                     var1[var3] = this.encodeTable[this.bitWorkArea >> 4 & 63];
                     var1 = this.buffer;
                     var3 = this.pos++;
                     var1[var3] = this.encodeTable[this.bitWorkArea << 2 & 63];
                     if (this.encodeTable == STANDARD_ENCODE_TABLE) {
                        var1 = this.buffer;
                        var3 = this.pos++;
                        var1[var3] = 61;
                     }
               }

               var3 = this.currentLinePos;
               this.currentLinePos = this.pos - var2 + var3;
               if (this.lineLength > 0 && this.currentLinePos > 0) {
                  System.arraycopy(this.lineSeparator, 0, this.buffer, this.pos, this.lineSeparator.length);
                  this.pos = this.pos + this.lineSeparator.length;
               }
            }
         } else {
            int var4 = 0;

            while (var4 < var3) {
               this.ensureBufferSize(this.encodeSize);
               this.modulus = (this.modulus + 1) % 3;
               byte var6 = var1[var2];
               int var5 = var6;
               if (var6 < 0) {
                  var5 = var6 + 256;
               }

               this.bitWorkArea = var5 + (this.bitWorkArea << 8);
               if (this.modulus == 0) {
                  byte[] var7 = this.buffer;
                  var5 = this.pos++;
                  var7[var5] = this.encodeTable[this.bitWorkArea >> 18 & 63];
                  var7 = this.buffer;
                  var5 = this.pos++;
                  var7[var5] = this.encodeTable[this.bitWorkArea >> 12 & 63];
                  var7 = this.buffer;
                  var5 = this.pos++;
                  var7[var5] = this.encodeTable[this.bitWorkArea >> 6 & 63];
                  var7 = this.buffer;
                  var5 = this.pos++;
                  var7[var5] = this.encodeTable[this.bitWorkArea & 63];
                  this.currentLinePos += 4;
                  if (this.lineLength > 0 && this.lineLength <= this.currentLinePos) {
                     System.arraycopy(this.lineSeparator, 0, this.buffer, this.pos, this.lineSeparator.length);
                     this.pos = this.pos + this.lineSeparator.length;
                     this.currentLinePos = 0;
                  }
               }

               var4++;
               var2++;
            }
         }
      }
   }

   @Override
   protected boolean isInAlphabet(byte var1) {
      boolean var2;
      if (var1 >= 0 && var1 < this.decodeTable.length && this.decodeTable[var1] != -1) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public boolean isUrlSafe() {
      boolean var1;
      if (this.encodeTable == URL_SAFE_ENCODE_TABLE) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }
}
