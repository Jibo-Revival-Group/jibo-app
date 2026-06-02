package com.google.zxing.qrcode.encoder;

public final class ByteMatrix {
   private final byte[][] a;
   private final int b;
   private final int c;

   public ByteMatrix(int var1, int var2) {
      this.a = new byte[var2][var1];
      this.b = var1;
      this.c = var2;
   }

   public byte a(int var1, int var2) {
      return this.a[var2][var1];
   }

   public int a() {
      return this.c;
   }

   public void a(byte var1) {
      for (int var2 = 0; var2 < this.c; var2++) {
         for (int var3 = 0; var3 < this.b; var3++) {
            this.a[var2][var3] = var1;
         }
      }
   }

   public void a(int var1, int var2, int var3) {
      this.a[var2][var1] = (byte)var3;
   }

   public void a(int var1, int var2, boolean var3) {
      byte[] var4 = this.a[var2];
      byte var5;
      if (var3) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      var4[var1] = (byte)var5;
   }

   public int b() {
      return this.b;
   }

   public byte[][] c() {
      return this.a;
   }

   @Override
   public String toString() {
      StringBuilder var3 = new StringBuilder(this.b * 2 * this.c + 2);

      for (int var1 = 0; var1 < this.c; var1++) {
         for (int var2 = 0; var2 < this.b; var2++) {
            switch (this.a[var1][var2]) {
               case 0:
                  var3.append(" 0");
                  break;
               case 1:
                  var3.append(" 1");
                  break;
               default:
                  var3.append("  ");
            }
         }

         var3.append('\n');
      }

      return var3.toString();
   }
}
