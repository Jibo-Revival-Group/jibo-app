package com.google.zxing.qrcode.encoder;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;

public final class QRCode {
   private Mode a;
   private ErrorCorrectionLevel b;
   private Version c;
   private int d = -1;
   private ByteMatrix e;

   public static boolean b(int var0) {
      boolean var1;
      if (var0 >= 0 && var0 < 8) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public ByteMatrix a() {
      return this.e;
   }

   public void a(int var1) {
      this.d = var1;
   }

   public void a(ErrorCorrectionLevel var1) {
      this.b = var1;
   }

   public void a(Mode var1) {
      this.a = var1;
   }

   public void a(Version var1) {
      this.c = var1;
   }

   public void a(ByteMatrix var1) {
      this.e = var1;
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder(200);
      var1.append("<<\n");
      var1.append(" mode: ");
      var1.append(this.a);
      var1.append("\n ecLevel: ");
      var1.append(this.b);
      var1.append("\n version: ");
      var1.append(this.c);
      var1.append("\n maskPattern: ");
      var1.append(this.d);
      if (this.e == null) {
         var1.append("\n matrix: null\n");
      } else {
         var1.append("\n matrix:\n");
         var1.append(this.e);
      }

      var1.append(">>\n");
      return var1.toString();
   }
}
