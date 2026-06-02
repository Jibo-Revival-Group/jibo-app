package com.salesforce.android.service.common.utilities.hashing;

/* JADX INFO: loaded from: classes.dex */
public class Murmur3_32 {
    /* JADX INFO: renamed from: a */
    public static int m14101a(CharSequence charSequence, int i) {
        return m14102a(charSequence, 0, charSequence.length(), i);
    }

    /* JADX INFO: renamed from: a */
    public static int m14102a(CharSequence charSequence, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = i + i2;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = i3;
        while (i < i10) {
            int i15 = i + 1;
            char cCharAt = charSequence.charAt(i);
            if (cCharAt < 128) {
                i4 = cCharAt;
                i5 = i15;
                i6 = 8;
            } else if (cCharAt < 2048) {
                i4 = (((cCharAt & '?') | 128) << 8) | (cCharAt >> 6) | 192;
                i5 = i15;
                i6 = 16;
            } else if (cCharAt < 55296 || cCharAt > 57343 || i15 >= i10) {
                i4 = (((cCharAt & '?') | 128) << 16) | (cCharAt >> '\f') | 224 | ((((cCharAt >> 6) & 63) | 128) << 8);
                i5 = i15;
                i6 = 24;
            } else {
                int i16 = i15 + 1;
                int iCharAt = (charSequence.charAt(i15) & 1023) + ((cCharAt - 55232) << 10);
                i6 = 32;
                i5 = i16;
                i4 = (((iCharAt >> 18) | 240) & 255) | ((((iCharAt >> 12) & 63) | 128) << 8) | ((((iCharAt >> 6) & 63) | 128) << 16) | (((iCharAt & 63) | 128) << 24);
            }
            int i17 = i13 | (i4 << i12);
            int i18 = i12 + i6;
            if (i18 >= 32) {
                int i19 = i17 * (-862048943);
                int i20 = (((i19 >>> 17) | (i19 << 15)) * 461845907) ^ i14;
                i14 = (-430675100) + (((i20 >>> 19) | (i20 << 13)) * 5);
                int i21 = i18 - 32;
                if (i21 != 0) {
                    i9 = i4 >>> (i6 - i21);
                } else {
                    i9 = 0;
                }
                i7 = i11 + 4;
                i8 = i21;
                i17 = i9;
            } else {
                i7 = i11;
                i8 = i18;
            }
            i12 = i8;
            i13 = i17;
            i = i5;
            i11 = i7;
        }
        if (i12 > 0) {
            i11 += i12 >> 3;
            int i22 = (-862048943) * i13;
            i14 ^= ((i22 >>> 17) | (i22 << 15)) * 461845907;
        }
        int i23 = i14 ^ i11;
        int i24 = (i23 ^ (i23 >>> 16)) * (-2048144789);
        int i25 = (i24 ^ (i24 >>> 13)) * (-1028477387);
        return i25 ^ (i25 >>> 16);
    }
}
