package com.jibo.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import java.util.Hashtable;
import java.util.Map;

public class QRCodeWriter {
   private static BitMatrix a(QRCode var0, int var1, int var2, int var3) {
      ByteMatrix var9 = var0.a();
      if (var9 == null) {
         throw new IllegalStateException();
      }

      int var7 = var9.b();
      int var6 = var9.a();
      int var4 = var3 * 2 + var7;
      int var5 = var3 * 2 + var6;
      var1 = Math.max(var1, var4);
      var3 = Math.max(var2, var5);
      int var8 = Math.min(var1 / var4, var3 / var5);
      var5 = (var1 - var7 * var8) / 2;
      var2 = (var3 - var6 * var8) / 2;
      BitMatrix var10 = new BitMatrix(var1, var3);

      for (int var12 = 0; var12 < var6; var12++) {
         var3 = 0;

         for (int var16 = var5; var3 < var7; var16 += var8) {
            if (var9.a(var3, var12) == 1) {
               var10.a(var16, var2, var8, var8);
            }

            var3++;
         }

         var2 += var8;
      }

      return var10;
   }

   public BitMatrix a(String var1, BarcodeFormat var2, int var3, int var4) throws WriterException {
      return this.a(var1, var2, var3, var4, null);
   }

   public BitMatrix a(String var1, BarcodeFormat var2, int var3, int var4, Map<EncodeHintType, ?> var5) throws WriterException {
      if (var1.isEmpty()) {
         throw new IllegalArgumentException("Found empty contents");
      }

      if (var2 != BarcodeFormat.QR_CODE) {
         throw new IllegalArgumentException("Can only encode QR_CODE, but got " + var2);
      }

      if (var3 >= 0 && var4 >= 0) {
         int var6;
         label24: {
            var8 = ErrorCorrectionLevel.L;
            ErrorCorrectionLevel var7 = var8;
            if (var5 != null) {
               var7 = (ErrorCorrectionLevel)var5.get(EncodeHintType.ERROR_CORRECTION);
               if (var7 != null) {
                  var8 = var7;
               }

               Integer var9 = (Integer)var5.get(EncodeHintType.MARGIN);
               var7 = var8;
               if (var9 != null) {
                  var6 = var9;
                  break label24;
               }
            }

            var6 = 0;
            var8 = var7;
         }

         var5 = new Hashtable();
         var5.put(EncodeHintType.CHARACTER_SET, "utf-8");
         return a(Encoder.a(var1, var8, var5), var3, var4, var6);
      } else {
         throw new IllegalArgumentException("Requested dimensions are too small: " + var3 + 'x' + var4);
      }
   }
}
