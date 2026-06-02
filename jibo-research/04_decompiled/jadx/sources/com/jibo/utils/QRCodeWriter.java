package com.jibo.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.QRCode;

/* JADX INFO: loaded from: classes.dex */
public class QRCodeWriter {
    /* JADX INFO: renamed from: a */
    public BitMatrix m11423a(String str, BarcodeFormat barcodeFormat, int i, int i2) throws WriterException {
        return m11424a(str, barcodeFormat, i, i2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0085 A[PHI: r1
      0x0085: PHI (r1v7 com.google.zxing.qrcode.decoder.ErrorCorrectionLevel) = 
      (r1v6 com.google.zxing.qrcode.decoder.ErrorCorrectionLevel)
      (r1v10 com.google.zxing.qrcode.decoder.ErrorCorrectionLevel)
     binds: [B:15:0x0055, B:20:0x006a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.zxing.common.BitMatrix m11424a(java.lang.String r6, com.google.zxing.BarcodeFormat r7, int r8, int r9, java.util.Map<com.google.zxing.EncodeHintType, ?> r10) throws com.google.zxing.WriterException {
        /*
            r5 = this;
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto Le
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Found empty contents"
            r0.<init>(r1)
            throw r0
        Le:
            com.google.zxing.BarcodeFormat r0 = com.google.zxing.BarcodeFormat.QR_CODE
            if (r7 == r0) goto L2b
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Can only encode QR_CODE, but got "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r7)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L2b:
            if (r8 < 0) goto L2f
            if (r9 >= 0) goto L52
        L2f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Requested dimensions are too small: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r8)
            r2 = 120(0x78, float:1.68E-43)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r9)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L52:
            com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r1 = com.google.zxing.qrcode.decoder.ErrorCorrectionLevel.L
            r2 = 0
            if (r10 == 0) goto L85
            com.google.zxing.EncodeHintType r0 = com.google.zxing.EncodeHintType.ERROR_CORRECTION
            java.lang.Object r0 = r10.get(r0)
            com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r0 = (com.google.zxing.qrcode.decoder.ErrorCorrectionLevel) r0
            if (r0 == 0) goto L62
            r1 = r0
        L62:
            com.google.zxing.EncodeHintType r0 = com.google.zxing.EncodeHintType.MARGIN
            java.lang.Object r0 = r10.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            if (r0 == 0) goto L85
            int r0 = r0.intValue()
        L70:
            java.util.Hashtable r2 = new java.util.Hashtable
            r2.<init>()
            com.google.zxing.EncodeHintType r3 = com.google.zxing.EncodeHintType.CHARACTER_SET
            java.lang.String r4 = "utf-8"
            r2.put(r3, r4)
            com.google.zxing.qrcode.encoder.QRCode r1 = com.google.zxing.qrcode.encoder.Encoder.m9726a(r6, r1, r2)
            com.google.zxing.common.BitMatrix r0 = m11422a(r1, r8, r9, r0)
            return r0
        L85:
            r0 = r2
            goto L70
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jibo.utils.QRCodeWriter.m11424a(java.lang.String, com.google.zxing.BarcodeFormat, int, int, java.util.Map):com.google.zxing.common.BitMatrix");
    }

    /* JADX INFO: renamed from: a */
    private static BitMatrix m11422a(QRCode qRCode, int i, int i2, int i3) {
        ByteMatrix byteMatrixM9767a = qRCode.m9767a();
        if (byteMatrixM9767a == null) {
            throw new IllegalStateException();
        }
        int iM9718b = byteMatrixM9767a.m9718b();
        int iM9714a = byteMatrixM9767a.m9714a();
        int i4 = (i3 * 2) + iM9718b;
        int i5 = (i3 * 2) + iM9714a;
        int iMax = Math.max(i, i4);
        int iMax2 = Math.max(i2, i5);
        int iMin = Math.min(iMax / i4, iMax2 / i5);
        int i6 = (iMax - (iM9718b * iMin)) / 2;
        BitMatrix bitMatrix = new BitMatrix(iMax, iMax2);
        int i7 = (iMax2 - (iM9714a * iMin)) / 2;
        for (int i8 = 0; i8 < iM9714a; i8++) {
            int i9 = 0;
            int i10 = i6;
            while (i9 < iM9718b) {
                if (byteMatrixM9767a.m9713a(i9, i8) == 1) {
                    bitMatrix.m9677a(i10, i7, iMin, iMin);
                }
                i9++;
                i10 += iMin;
            }
            i7 += iMin;
        }
        return bitMatrix;
    }
}
