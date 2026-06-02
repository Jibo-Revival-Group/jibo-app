package com.crashlytics.android.core;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
final class ByteString {

    /* JADX INFO: renamed from: a */
    public static final ByteString f5143a = new ByteString(new byte[0]);

    /* JADX INFO: renamed from: b */
    private final byte[] f5144b;

    /* JADX INFO: renamed from: c */
    private volatile int f5145c = 0;

    private ByteString(byte[] bArr) {
        this.f5144b = bArr;
    }

    /* JADX INFO: renamed from: a */
    public int m5713a() {
        return this.f5144b.length;
    }

    /* JADX INFO: renamed from: a */
    public static ByteString m5712a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new ByteString(bArr2);
    }

    /* JADX INFO: renamed from: a */
    public static ByteString m5711a(String str) {
        try {
            return new ByteString(str.getBytes(HTTP.UTF_8));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5714a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f5144b, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        int length = this.f5144b.length;
        if (length != byteString.f5144b.length) {
            return false;
        }
        byte[] bArr = this.f5144b;
        byte[] bArr2 = byteString.f5144b;
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.f5145c;
        if (i == 0) {
            byte[] bArr = this.f5144b;
            int length = this.f5144b.length;
            int i2 = 0;
            i = length;
            while (i2 < length) {
                int i3 = bArr[i2] + (i * 31);
                i2++;
                i = i3;
            }
            if (i == 0) {
                i = 1;
            }
            this.f5145c = i;
        }
        return i;
    }

    /* JADX INFO: renamed from: b */
    public InputStream m5715b() {
        return new ByteArrayInputStream(this.f5144b);
    }
}
