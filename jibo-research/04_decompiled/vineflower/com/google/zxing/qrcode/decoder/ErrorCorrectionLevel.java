package com.google.zxing.qrcode.decoder;

public enum ErrorCorrectionLevel {
   H(2),
   L(1),
   M(0),
   Q(3);

   private static final ErrorCorrectionLevel[] $VALUES = new ErrorCorrectionLevel[]{
      ErrorCorrectionLevel.L, ErrorCorrectionLevel.M, ErrorCorrectionLevel.Q, ErrorCorrectionLevel.H
   };
   private static final ErrorCorrectionLevel[] FOR_BITS = new ErrorCorrectionLevel[]{
      ErrorCorrectionLevel.M, ErrorCorrectionLevel.L, ErrorCorrectionLevel.H, ErrorCorrectionLevel.Q
   };
   private final int bits;

   ErrorCorrectionLevel(int var3) {
      this.bits = var3;
   }

   public static ErrorCorrectionLevel forBits(int var0) {
      if (var0 >= 0 && var0 < FOR_BITS.length) {
         return FOR_BITS[var0];
      } else {
         throw new IllegalArgumentException();
      }
   }

   public int getBits() {
      return this.bits;
   }
}
