package com.amazonaws.util;

class Base64Codec {
   private final byte[] ALPAHBETS = CodecUtils.toBytesDirect("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");

   public byte[] encode(byte[] var1) {
      byte var2 = 0;
      byte var3 = 0;
      int var5 = var1.length / 3;
      int var4 = var1.length % 3;
      if (var4 == 0) {
         byte[] var6 = new byte[var5 * 4];

         for (byte var8 = 0; var8 < var1.length; var3 += 4) {
            this.encode3bytes(var1, var8, var6, var3);
            var8 += 3;
         }

         var1 = var6;
      } else {
         byte[] var10 = new byte[(var5 + 1) * 4];

         for (var3 = 0; var3 < var1.length - var4; var2 += 4) {
            this.encode3bytes(var1, var3, var10, var2);
            var3 += 3;
         }

         switch (var4) {
            case 1:
               this.encode1byte(var1, var3, var10, var2);
               break;
            case 2:
               this.encode2bytes(var1, var3, var10, var2);
         }

         var1 = var10;
      }

      return var1;
   }

   void encode1byte(byte[] var1, int var2, byte[] var3, int var4) {
      int var5 = var4 + 1;
      byte[] var6 = this.ALPAHBETS;
      byte var7 = var1[var2];
      var3[var4] = var6[var7 >>> 2 & 63];
      var4 = var5 + 1;
      var3[var5] = this.ALPAHBETS[(var7 & 3) << 4];
      var3[var4] = 61;
      var3[var4 + 1] = 61;
   }

   void encode2bytes(byte[] var1, int var2, byte[] var3, int var4) {
      int var5 = var4 + 1;
      byte[] var7 = this.ALPAHBETS;
      byte var6 = var1[var2];
      var3[var4] = var7[var6 >>> 2 & 63];
      var4 = var5 + 1;
      var7 = this.ALPAHBETS;
      byte var8 = var1[var2 + 1];
      var3[var5] = var7[(var6 & 3) << 4 | var8 >>> 4 & 15];
      var3[var4] = this.ALPAHBETS[(var8 & 15) << 2];
      var3[var4 + 1] = 61;
   }

   void encode3bytes(byte[] var1, int var2, byte[] var3, int var4) {
      int var6 = var4 + 1;
      byte[] var8 = this.ALPAHBETS;
      int var5 = var2 + 1;
      byte var9 = var1[var2];
      var3[var4] = var8[var9 >>> 2 & 63];
      var4 = var6 + 1;
      var8 = this.ALPAHBETS;
      byte var7 = var1[var5];
      var3[var6] = var8[(var9 & 3) << 4 | var7 >>> 4 & 15];
      var8 = this.ALPAHBETS;
      var9 = var1[var5 + 1];
      var3[var4] = var8[(var7 & 15) << 2 | var9 >>> 6 & 3];
      var3[var4 + 1] = this.ALPAHBETS[var9 & 63];
   }
}
