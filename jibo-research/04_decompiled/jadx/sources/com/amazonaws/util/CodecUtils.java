package com.amazonaws.util;

/* JADX INFO: loaded from: classes.dex */
public enum CodecUtils {
    ;

    public static byte[] toBytesDirect(String str) {
        char[] charArray = str.toCharArray();
        byte[] bArr = new byte[charArray.length];
        for (int i = 0; i < bArr.length; i++) {
            char c = charArray[i];
            if (c > 127) {
                throw new IllegalArgumentException("Invalid character found at position " + i + " for " + str);
            }
            bArr[i] = (byte) c;
        }
        return bArr;
    }

    public static String toStringDirect(byte[] bArr) {
        int i = 0;
        char[] cArr = new char[bArr.length];
        int length = bArr.length;
        int i2 = 0;
        while (i < length) {
            cArr[i2] = (char) bArr[i];
            i++;
            i2++;
        }
        return new String(cArr);
    }
}
