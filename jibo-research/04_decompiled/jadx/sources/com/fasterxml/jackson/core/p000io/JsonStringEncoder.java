package com.fasterxml.jackson.core.p000io;

import com.facebook.internal.NativeProtocol;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import java.lang.ref.SoftReference;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public final class JsonStringEncoder {

    /* JADX INFO: renamed from: b */
    protected ByteArrayBuilder f5487b;

    /* JADX INFO: renamed from: c */
    protected final char[] f5488c = new char[6];

    /* JADX INFO: renamed from: d */
    private static final char[] f5485d = CharTypes.m6150g();

    /* JADX INFO: renamed from: e */
    private static final byte[] f5486e = CharTypes.m6151h();

    /* JADX INFO: renamed from: a */
    protected static final ThreadLocal<SoftReference<JsonStringEncoder>> f5484a = new ThreadLocal<>();

    public JsonStringEncoder() {
        this.f5488c[0] = TokenParser.ESCAPE;
        this.f5488c[2] = '0';
        this.f5488c[3] = '0';
    }

    /* JADX INFO: renamed from: a */
    public static JsonStringEncoder m6176a() {
        SoftReference<JsonStringEncoder> softReference = f5484a.get();
        JsonStringEncoder jsonStringEncoder = softReference == null ? null : softReference.get();
        if (jsonStringEncoder == null) {
            JsonStringEncoder jsonStringEncoder2 = new JsonStringEncoder();
            f5484a.set(new SoftReference<>(jsonStringEncoder2));
            return jsonStringEncoder2;
        }
        return jsonStringEncoder;
    }

    /* JADX INFO: renamed from: a */
    public byte[] m6178a(String str) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        ByteArrayBuilder byteArrayBuilder = this.f5487b;
        if (byteArrayBuilder == null) {
            byteArrayBuilder = new ByteArrayBuilder(null);
            this.f5487b = byteArrayBuilder;
        }
        int length = str.length();
        byte[] bArrM6463c = byteArrayBuilder.m6463c();
        int length2 = bArrM6463c.length;
        int i6 = 0;
        int i7 = 0;
        loop0: while (true) {
            if (i7 >= length) {
                i = i6;
                break;
            }
            int i8 = i7 + 1;
            char cCharAt = str.charAt(i7);
            int i9 = length2;
            byte[] bArrM6464d = bArrM6463c;
            int i10 = i6;
            int length3 = i9;
            while (cCharAt <= 127) {
                if (i10 >= length3) {
                    bArrM6464d = byteArrayBuilder.m6464d();
                    length3 = bArrM6464d.length;
                    i10 = 0;
                }
                int i11 = i10 + 1;
                bArrM6464d[i10] = (byte) cCharAt;
                if (i8 >= length) {
                    i = i11;
                    break loop0;
                }
                cCharAt = str.charAt(i8);
                i8++;
                i10 = i11;
            }
            if (i10 >= length3) {
                bArrM6464d = byteArrayBuilder.m6464d();
                length3 = bArrM6464d.length;
                i2 = 0;
            } else {
                i2 = i10;
            }
            if (cCharAt < 2048) {
                i3 = i2 + 1;
                bArrM6464d[i2] = (byte) ((cCharAt >> 6) | 192);
                i4 = cCharAt;
                i7 = i8;
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                int i12 = i2 + 1;
                bArrM6464d[i2] = (byte) ((cCharAt >> '\f') | 224);
                if (i12 >= length3) {
                    bArrM6464d = byteArrayBuilder.m6464d();
                    length3 = bArrM6464d.length;
                    i12 = 0;
                }
                bArrM6464d[i12] = (byte) (((cCharAt >> 6) & 63) | 128);
                i3 = i12 + 1;
                i4 = cCharAt;
                i7 = i8;
            } else {
                if (cCharAt > 56319) {
                    m6177a(cCharAt);
                }
                if (i8 >= length) {
                    m6177a(cCharAt);
                }
                int i13 = i8 + 1;
                int iM6175a = m6175a(cCharAt, str.charAt(i8));
                if (iM6175a > 1114111) {
                    m6177a(iM6175a);
                }
                int i14 = i2 + 1;
                bArrM6464d[i2] = (byte) ((iM6175a >> 18) | 240);
                if (i14 >= length3) {
                    bArrM6464d = byteArrayBuilder.m6464d();
                    length3 = bArrM6464d.length;
                    i14 = 0;
                }
                int i15 = i14 + 1;
                bArrM6464d[i14] = (byte) (((iM6175a >> 12) & 63) | 128);
                if (i15 >= length3) {
                    bArrM6464d = byteArrayBuilder.m6464d();
                    length3 = bArrM6464d.length;
                    i5 = 0;
                } else {
                    i5 = i15;
                }
                bArrM6464d[i5] = (byte) (((iM6175a >> 6) & 63) | 128);
                i3 = i5 + 1;
                i4 = iM6175a;
                i7 = i13;
            }
            if (i3 >= length3) {
                bArrM6464d = byteArrayBuilder.m6464d();
                length3 = bArrM6464d.length;
                i3 = 0;
            }
            int i16 = i3 + 1;
            bArrM6464d[i3] = (byte) ((i4 & 63) | 128);
            bArrM6463c = bArrM6464d;
            length2 = length3;
            i6 = i16;
        }
        return this.f5487b.m6462b(i);
    }

    /* JADX INFO: renamed from: a */
    private static int m6175a(int i, int i2) {
        if (i2 < 56320 || i2 > 57343) {
            throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(i2) + "; illegal combination");
        }
        return NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST + ((i - 55296) << 10) + (i2 - 56320);
    }

    /* JADX INFO: renamed from: a */
    private static void m6177a(int i) {
        throw new IllegalArgumentException(UTF8Writer.m6206c(i));
    }
}
