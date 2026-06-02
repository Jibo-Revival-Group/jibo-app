package com.amazonaws.internal;

import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class SdkDigestInputStream extends DigestInputStream {
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !SdkDigestInputStream.class.desiredAssertionStatus();
    }

    public SdkDigestInputStream(InputStream inputStream, MessageDigest messageDigest) {
        super(inputStream, messageDigest);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j) {
        if (j <= 0) {
            return j;
        }
        byte[] bArr = new byte[(int) Math.min(2048L, j)];
        long j2 = j;
        while (j2 > 0) {
            int i = read(bArr, 0, (int) Math.min(j2, bArr.length));
            if (i == -1) {
                return j2 == j ? -1L : j - j2;
            }
            j2 -= (long) i;
        }
        if ($assertionsDisabled || j2 == 0) {
            return j;
        }
        throw new AssertionError();
    }
}
