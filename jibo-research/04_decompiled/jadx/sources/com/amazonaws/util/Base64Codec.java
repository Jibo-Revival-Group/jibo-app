package com.amazonaws.util;

/* JADX INFO: loaded from: classes.dex */
class Base64Codec {
    private final byte[] ALPAHBETS = CodecUtils.toBytesDirect("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");

    Base64Codec() {
    }

    public byte[] encode(byte[] bArr) {
        int i = 0;
        int length = bArr.length / 3;
        int length2 = bArr.length % 3;
        if (length2 == 0) {
            byte[] bArr2 = new byte[length * 4];
            int i2 = 0;
            while (i2 < bArr.length) {
                encode3bytes(bArr, i2, bArr2, i);
                i2 += 3;
                i += 4;
            }
            return bArr2;
        }
        byte[] bArr3 = new byte[(length + 1) * 4];
        int i3 = 0;
        while (i3 < bArr.length - length2) {
            encode3bytes(bArr, i3, bArr3, i);
            i3 += 3;
            i += 4;
        }
        switch (length2) {
            case 1:
                encode1byte(bArr, i3, bArr3, i);
                break;
            case 2:
                encode2bytes(bArr, i3, bArr3, i);
                break;
        }
        return bArr3;
    }

    void encode1byte(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = i2 + 1;
        byte[] bArr3 = this.ALPAHBETS;
        byte b = bArr[i];
        bArr2[i2] = bArr3[(b >>> 2) & 63];
        int i4 = i3 + 1;
        bArr2[i3] = this.ALPAHBETS[(b & 3) << 4];
        bArr2[i4] = 61;
        bArr2[i4 + 1] = 61;
    }

    void encode2bytes(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = i2 + 1;
        byte[] bArr3 = this.ALPAHBETS;
        byte b = bArr[i];
        bArr2[i2] = bArr3[(b >>> 2) & 63];
        int i4 = i3 + 1;
        byte[] bArr4 = this.ALPAHBETS;
        byte b2 = bArr[i + 1];
        bArr2[i3] = bArr4[((b & 3) << 4) | ((b2 >>> 4) & 15)];
        bArr2[i4] = this.ALPAHBETS[(b2 & 15) << 2];
        bArr2[i4 + 1] = 61;
    }

    void encode3bytes(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = i2 + 1;
        byte[] bArr3 = this.ALPAHBETS;
        int i4 = i + 1;
        byte b = bArr[i];
        bArr2[i2] = bArr3[(b >>> 2) & 63];
        int i5 = i3 + 1;
        byte[] bArr4 = this.ALPAHBETS;
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        bArr2[i3] = bArr4[((b & 3) << 4) | ((b2 >>> 4) & 15)];
        byte[] bArr5 = this.ALPAHBETS;
        byte b3 = bArr[i6];
        bArr2[i5] = bArr5[((b2 & 15) << 2) | ((b3 >>> 6) & 3)];
        bArr2[i5 + 1] = this.ALPAHBETS[b3 & 63];
    }
}
