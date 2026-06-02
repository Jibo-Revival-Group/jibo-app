package com.amazonaws.util;

/* JADX INFO: loaded from: classes.dex */
public enum Base64 {
    ;

    private static final Base64Codec codec = new Base64Codec();

    public static String encodeAsString(byte... bArr) {
        if (bArr == null) {
            return null;
        }
        return bArr.length == 0 ? "" : CodecUtils.toStringDirect(codec.encode(bArr));
    }
}
