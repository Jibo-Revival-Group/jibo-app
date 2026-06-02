package com.google.zxing.qrcode.encoder;

final class BlockPair {
   private final byte[] a;
   private final byte[] b;

   BlockPair(byte[] var1, byte[] var2) {
      this.a = var1;
      this.b = var2;
   }

   public byte[] a() {
      return this.a;
   }

   public byte[] b() {
      return this.b;
   }
}
