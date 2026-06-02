package com.google.android.gms.internal;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfjk {

    /* JADX INFO: renamed from: a */
    private final ByteBuffer f7950a;

    private zzfjk(ByteBuffer byteBuffer) {
        this.f7950a = byteBuffer;
        this.f7950a.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzfjk(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    /* JADX INFO: renamed from: a */
    public static int m8642a(int i) {
        if (i >= 0) {
            return m8659d(i);
        }
        return 10;
    }

    /* JADX INFO: renamed from: a */
    public static int m8643a(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    /* JADX INFO: renamed from: a */
    private static int m8644a(CharSequence charSequence) {
        int i;
        int i2 = 0;
        int length = charSequence.length();
        int i3 = 0;
        while (i3 < length && charSequence.charAt(i3) < 128) {
            i3++;
        }
        int i4 = length;
        while (true) {
            if (i3 >= length) {
                i = i4;
                break;
            }
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt < 2048) {
                i4 += (127 - cCharAt) >>> 31;
                i3++;
            } else {
                int length2 = charSequence.length();
                while (i3 < length2) {
                    char cCharAt2 = charSequence.charAt(i3);
                    if (cCharAt2 < 2048) {
                        i2 += (127 - cCharAt2) >>> 31;
                    } else {
                        i2 += 2;
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i3) < 65536) {
                                throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i3).toString());
                            }
                            i3++;
                        }
                    }
                    i3++;
                }
                i = i4 + i2;
            }
        }
        if (i >= length) {
            return i;
        }
        throw new IllegalArgumentException(new StringBuilder(54).append("UTF-8 length does not fit in int: ").append(((long) i) + 4294967296L).toString());
    }

    /* JADX INFO: renamed from: a */
    private static int m8645a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int i3;
        int length = charSequence.length();
        int i4 = 0;
        int i5 = i + i2;
        while (i4 < length && i4 + i < i5) {
            char cCharAt = charSequence.charAt(i4);
            if (cCharAt >= 128) {
                break;
            }
            bArr[i + i4] = (byte) cCharAt;
            i4++;
        }
        if (i4 == length) {
            return i + length;
        }
        int i6 = i + i4;
        while (i4 < length) {
            char cCharAt2 = charSequence.charAt(i4);
            if (cCharAt2 < 128 && i6 < i5) {
                i3 = i6 + 1;
                bArr[i6] = (byte) cCharAt2;
            } else if (cCharAt2 < 2048 && i6 <= i5 - 2) {
                int i7 = i6 + 1;
                bArr[i6] = (byte) ((cCharAt2 >>> 6) | 960);
                i3 = i7 + 1;
                bArr[i7] = (byte) ((cCharAt2 & '?') | 128);
            } else {
                if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i6 > i5 - 3) {
                    if (i6 > i5 - 4) {
                        throw new ArrayIndexOutOfBoundsException(new StringBuilder(37).append("Failed writing ").append(cCharAt2).append(" at index ").append(i6).toString());
                    }
                    if (i4 + 1 != charSequence.length()) {
                        i4++;
                        char cCharAt3 = charSequence.charAt(i4);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            int i8 = i6 + 1;
                            bArr[i6] = (byte) ((codePoint >>> 18) | 240);
                            int i9 = i8 + 1;
                            bArr[i8] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i10 = i9 + 1;
                            bArr[i9] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i3 = i10 + 1;
                            bArr[i10] = (byte) ((codePoint & 63) | 128);
                        }
                    }
                    throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i4 - 1).toString());
                }
                int i11 = i6 + 1;
                bArr[i6] = (byte) ((cCharAt2 >>> '\f') | 480);
                int i12 = i11 + 1;
                bArr[i11] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                i3 = i12 + 1;
                bArr[i12] = (byte) ((cCharAt2 & '?') | 128);
            }
            i4++;
            i6 = i3;
        }
        return i6;
    }

    /* JADX INFO: renamed from: a */
    public static int m8646a(String str) {
        int iM8644a = m8644a((CharSequence) str);
        return iM8644a + m8659d(iM8644a);
    }

    /* JADX INFO: renamed from: a */
    public static zzfjk m8647a(byte[] bArr) {
        return m8648a(bArr, 0, bArr.length);
    }

    /* JADX INFO: renamed from: a */
    public static zzfjk m8648a(byte[] bArr, int i, int i2) {
        return new zzfjk(bArr, 0, i2);
    }

    /* JADX INFO: renamed from: a */
    private static void m8649a(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        if (!byteBuffer.hasArray()) {
            m8657b(charSequence, byteBuffer);
            return;
        }
        try {
            byteBuffer.position(m8645a(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
        } catch (ArrayIndexOutOfBoundsException e) {
            BufferOverflowException bufferOverflowException = new BufferOverflowException();
            bufferOverflowException.initCause(e);
            throw bufferOverflowException;
        }
    }

    /* JADX INFO: renamed from: b */
    public static int m8650b(int i) {
        return m8659d(i << 3);
    }

    /* JADX INFO: renamed from: b */
    public static int m8651b(int i, int i2) {
        return m8650b(i) + m8642a(i2);
    }

    /* JADX INFO: renamed from: b */
    public static int m8652b(int i, zzfjs zzfjsVar) {
        int iM8650b = m8650b(i);
        int iM8713f = zzfjsVar.m8713f();
        return iM8650b + iM8713f + m8659d(iM8713f);
    }

    /* JADX INFO: renamed from: b */
    public static int m8653b(int i, String str) {
        return m8650b(i) + m8646a(str);
    }

    /* JADX INFO: renamed from: b */
    public static int m8654b(int i, byte[] bArr) {
        return m8650b(i) + m8655b(bArr);
    }

    /* JADX INFO: renamed from: b */
    public static int m8655b(byte[] bArr) {
        return m8659d(bArr.length) + bArr.length;
    }

    /* JADX INFO: renamed from: b */
    private final void m8656b(long j) throws IOException {
        while (((-128) & j) != 0) {
            m8663e((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m8663e((int) j);
    }

    /* JADX INFO: renamed from: b */
    private static void m8657b(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt < 128) {
                byteBuffer.put((byte) cCharAt);
            } else if (cCharAt < 2048) {
                byteBuffer.put((byte) ((cCharAt >>> 6) | 960));
                byteBuffer.put((byte) ((cCharAt & '?') | 128));
            } else {
                if (cCharAt >= 55296 && 57343 >= cCharAt) {
                    if (i + 1 != charSequence.length()) {
                        i++;
                        char cCharAt2 = charSequence.charAt(i);
                        if (Character.isSurrogatePair(cCharAt, cCharAt2)) {
                            int codePoint = Character.toCodePoint(cCharAt, cCharAt2);
                            byteBuffer.put((byte) ((codePoint >>> 18) | 240));
                            byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                            byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                            byteBuffer.put((byte) ((codePoint & 63) | 128));
                        }
                    }
                    throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i - 1).toString());
                }
                byteBuffer.put((byte) ((cCharAt >>> '\f') | 480));
                byteBuffer.put((byte) (((cCharAt >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((cCharAt & '?') | 128));
            }
            i++;
        }
    }

    /* JADX INFO: renamed from: c */
    private final void m8658c(long j) throws IOException {
        if (this.f7950a.remaining() < 8) {
            throw new zzfjl(this.f7950a.position(), this.f7950a.limit());
        }
        this.f7950a.putLong(j);
    }

    /* JADX INFO: renamed from: d */
    public static int m8659d(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return ((-268435456) & i) == 0 ? 4 : 5;
    }

    /* JADX INFO: renamed from: d */
    public static int m8660d(int i, long j) {
        return m8650b(i) + m8643a(j);
    }

    /* JADX INFO: renamed from: d */
    private static long m8661d(long j) {
        return (j << 1) ^ (j >> 63);
    }

    /* JADX INFO: renamed from: e */
    public static int m8662e(int i, long j) {
        return m8650b(i) + m8643a(m8661d(j));
    }

    /* JADX INFO: renamed from: e */
    private final void m8663e(int i) throws IOException {
        byte b = (byte) i;
        if (!this.f7950a.hasRemaining()) {
            throw new zzfjl(this.f7950a.position(), this.f7950a.limit());
        }
        this.f7950a.put(b);
    }

    /* JADX INFO: renamed from: a */
    public final void m8664a() {
        if (this.f7950a.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", Integer.valueOf(this.f7950a.remaining())));
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m8665a(int i, double d) throws IOException {
        m8676c(i, 1);
        m8658c(Double.doubleToLongBits(d));
    }

    /* JADX INFO: renamed from: a */
    public final void m8666a(int i, float f) throws IOException {
        m8676c(i, 5);
        int iFloatToIntBits = Float.floatToIntBits(f);
        if (this.f7950a.remaining() < 4) {
            throw new zzfjl(this.f7950a.position(), this.f7950a.limit());
        }
        this.f7950a.putInt(iFloatToIntBits);
    }

    /* JADX INFO: renamed from: a */
    public final void m8667a(int i, int i2) throws IOException {
        m8676c(i, 0);
        if (i2 >= 0) {
            m8675c(i2);
        } else {
            m8656b(i2);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m8668a(int i, long j) throws IOException {
        m8676c(i, 0);
        m8656b(j);
    }

    /* JADX INFO: renamed from: a */
    public final void m8669a(int i, zzfjs zzfjsVar) throws IOException {
        m8676c(i, 2);
        m8673a(zzfjsVar);
    }

    /* JADX INFO: renamed from: a */
    public final void m8670a(int i, String str) throws IOException {
        m8676c(i, 2);
        try {
            int iM8659d = m8659d(str.length());
            if (iM8659d != m8659d(str.length() * 3)) {
                m8675c(m8644a((CharSequence) str));
                m8649a(str, this.f7950a);
                return;
            }
            int iPosition = this.f7950a.position();
            if (this.f7950a.remaining() < iM8659d) {
                throw new zzfjl(iM8659d + iPosition, this.f7950a.limit());
            }
            this.f7950a.position(iPosition + iM8659d);
            m8649a(str, this.f7950a);
            int iPosition2 = this.f7950a.position();
            this.f7950a.position(iPosition);
            m8675c((iPosition2 - iPosition) - iM8659d);
            this.f7950a.position(iPosition2);
        } catch (BufferOverflowException e) {
            zzfjl zzfjlVar = new zzfjl(this.f7950a.position(), this.f7950a.limit());
            zzfjlVar.initCause(e);
            throw zzfjlVar;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m8671a(int i, boolean z) throws IOException {
        m8676c(i, 0);
        byte b = (byte) (z ? 1 : 0);
        if (!this.f7950a.hasRemaining()) {
            throw new zzfjl(this.f7950a.position(), this.f7950a.limit());
        }
        this.f7950a.put(b);
    }

    /* JADX INFO: renamed from: a */
    public final void m8672a(int i, byte[] bArr) throws IOException {
        m8676c(i, 2);
        m8675c(bArr.length);
        m8678c(bArr);
    }

    /* JADX INFO: renamed from: a */
    public final void m8673a(zzfjs zzfjsVar) throws IOException {
        m8675c(zzfjsVar.m8712e());
        zzfjsVar.mo8447a(this);
    }

    /* JADX INFO: renamed from: b */
    public final void m8674b(int i, long j) throws IOException {
        m8676c(i, 0);
        m8656b(j);
    }

    /* JADX INFO: renamed from: c */
    public final void m8675c(int i) throws IOException {
        while ((i & (-128)) != 0) {
            m8663e((i & 127) | 128);
            i >>>= 7;
        }
        m8663e(i);
    }

    /* JADX INFO: renamed from: c */
    public final void m8676c(int i, int i2) throws IOException {
        m8675c((i << 3) | i2);
    }

    /* JADX INFO: renamed from: c */
    public final void m8677c(int i, long j) throws IOException {
        m8676c(i, 0);
        m8656b(m8661d(j));
    }

    /* JADX INFO: renamed from: c */
    public final void m8678c(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.f7950a.remaining() < length) {
            throw new zzfjl(this.f7950a.position(), this.f7950a.limit());
        }
        this.f7950a.put(bArr, 0, length);
    }
}
