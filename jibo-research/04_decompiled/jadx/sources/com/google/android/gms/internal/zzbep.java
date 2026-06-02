package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public final class zzbep {
    /* JADX INFO: renamed from: a */
    private static int m7682a(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24);
    }

    /* JADX INFO: renamed from: a */
    private static long m7683a(long j, long j2, long j3) {
        long j4 = (j ^ j2) * j3;
        long j5 = ((j4 ^ (j4 >>> 47)) ^ j2) * j3;
        return (j5 ^ (j5 >>> 47)) * j3;
    }

    /* JADX INFO: renamed from: a */
    public static long m7684a(byte[] bArr) {
        int length = bArr.length;
        if (length < 0 || length > bArr.length) {
            throw new IndexOutOfBoundsException(new StringBuilder(67).append("Out of bound index with offput: 0 and length: ").append(length).toString());
        }
        if (length > 32) {
            if (length > 64) {
                return m7685a(bArr, 0, length);
            }
            long j = (-7286425919675154353L) + ((long) (length << 1));
            long jM7687b = m7687b(bArr, 0) * (-7286425919675154353L);
            long jM7687b2 = m7687b(bArr, 8);
            long jM7687b3 = m7687b(bArr, (length + 0) - 8) * j;
            long jM7687b4 = (m7687b(bArr, (length + 0) - 16) * (-7286425919675154353L)) + Long.rotateRight(jM7687b + jM7687b2, 43) + Long.rotateRight(jM7687b3, 30);
            long jM7683a = m7683a(jM7687b4, Long.rotateRight(jM7687b2 - 7286425919675154353L, 18) + jM7687b + jM7687b3, j);
            long jM7687b5 = m7687b(bArr, 16) * j;
            long jM7687b6 = m7687b(bArr, 24);
            long jM7687b7 = (jM7687b4 + m7687b(bArr, (length + 0) - 32)) * j;
            return m7683a(((m7687b(bArr, (length + 0) - 24) + jM7683a) * j) + Long.rotateRight(jM7687b5 + jM7687b6, 43) + Long.rotateRight(jM7687b7, 30), Long.rotateRight(jM7687b6 + jM7687b, 18) + jM7687b5 + jM7687b7, j);
        }
        if (length > 16) {
            long j2 = (-7286425919675154353L) + ((long) (length << 1));
            long jM7687b8 = (-5435081209227447693L) * m7687b(bArr, 0);
            long jM7687b9 = m7687b(bArr, 8);
            long jM7687b10 = m7687b(bArr, (length + 0) - 8) * j2;
            return m7683a((m7687b(bArr, (length + 0) - 16) * (-7286425919675154353L)) + Long.rotateRight(jM7687b8 + jM7687b9, 43) + Long.rotateRight(jM7687b10, 30), jM7687b8 + Long.rotateRight((-7286425919675154353L) + jM7687b9, 18) + jM7687b10, j2);
        }
        if (length >= 8) {
            long j3 = (-7286425919675154353L) + ((long) (length << 1));
            long jM7687b11 = (-7286425919675154353L) + m7687b(bArr, 0);
            long jM7687b12 = m7687b(bArr, (length + 0) - 8);
            return m7683a((Long.rotateRight(jM7687b12, 37) * j3) + jM7687b11, (Long.rotateRight(jM7687b11, 25) + jM7687b12) * j3, j3);
        }
        if (length >= 4) {
            return m7683a(((((long) m7682a(bArr, 0)) & 4294967295L) << 3) + ((long) length), ((long) m7682a(bArr, (length + 0) - 4)) & 4294967295L, (-7286425919675154353L) + ((long) (length << 1)));
        }
        if (length <= 0) {
            return -7286425919675154353L;
        }
        long j4 = (((long) (((bArr[(length - 1) + 0] & 255) << 2) + length)) * (-4348849565147123417L)) ^ (((long) ((bArr[0] & 255) + ((bArr[(length >> 1) + 0] & 255) << 8))) * (-7286425919675154353L));
        return (j4 ^ (j4 >>> 47)) * (-7286425919675154353L);
    }

    /* JADX INFO: renamed from: a */
    private static long m7685a(byte[] bArr, int i, int i2) {
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        int i3 = (((i2 - 1) / 64) << 6) + 0;
        int i4 = (((i2 - 1) & 63) + i3) - 63;
        long jM7687b = 95310865018149119L + m7687b(bArr, 0);
        long j = 2480279821605975764L;
        long j2 = 1390051526045402406L;
        int i5 = i;
        while (true) {
            long jRotateRight = Long.rotateRight(jM7687b + j + jArr[0] + m7687b(bArr, i5 + 8), 37) * (-5435081209227447693L);
            long jRotateRight2 = Long.rotateRight(j + jArr[1] + m7687b(bArr, i5 + 48), 42) * (-5435081209227447693L);
            long j3 = jRotateRight ^ jArr2[1];
            long jM7687b2 = jRotateRight2 + jArr[0] + m7687b(bArr, i5 + 40);
            long jRotateRight3 = Long.rotateRight(j2 + jArr2[0], 33) * (-5435081209227447693L);
            m7686a(bArr, i5, jArr[1] * (-5435081209227447693L), jArr2[0] + j3, jArr);
            m7686a(bArr, i5 + 32, jRotateRight3 + jArr2[1], jM7687b2 + m7687b(bArr, i5 + 16), jArr2);
            i5 += 64;
            if (i5 == i3) {
                long j4 = (-5435081209227447693L) + ((255 & j3) << 1);
                jArr2[0] = jArr2[0] + ((long) ((i2 - 1) & 63));
                jArr[0] = jArr[0] + jArr2[0];
                jArr2[0] = jArr2[0] + jArr[0];
                long jRotateRight4 = Long.rotateRight(jRotateRight3 + jM7687b2 + jArr[0] + m7687b(bArr, i4 + 8), 37) * j4;
                long jRotateRight5 = Long.rotateRight(jArr[1] + jM7687b2 + m7687b(bArr, i4 + 48), 42) * j4;
                long j5 = jRotateRight4 ^ (jArr2[1] * 9);
                long jM7687b3 = jRotateRight5 + (jArr[0] * 9) + m7687b(bArr, i4 + 40);
                long jRotateRight6 = Long.rotateRight(jArr2[0] + j3, 33) * j4;
                m7686a(bArr, i4, jArr[1] * j4, j5 + jArr2[0], jArr);
                m7686a(bArr, i4 + 32, jRotateRight6 + jArr2[1], jM7687b3 + m7687b(bArr, i4 + 16), jArr2);
                return m7683a(m7683a(jArr[0], jArr2[0], j4) + (((jM7687b3 >>> 47) ^ jM7687b3) * (-4348849565147123417L)) + j5, m7683a(jArr[1], jArr2[1], j4) + jRotateRight6, j4);
            }
            j2 = j3;
            j = jM7687b2;
            jM7687b = jRotateRight3;
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m7686a(byte[] bArr, int i, long j, long j2, long[] jArr) {
        long jM7687b = m7687b(bArr, i);
        long jM7687b2 = m7687b(bArr, i + 8);
        long jM7687b3 = m7687b(bArr, i + 16);
        long jM7687b4 = m7687b(bArr, i + 24);
        long j3 = jM7687b + j;
        long j4 = jM7687b2 + j3 + jM7687b3;
        long jRotateRight = Long.rotateRight(j4, 44) + Long.rotateRight(j2 + j3 + jM7687b4, 21);
        jArr[0] = j4 + jM7687b4;
        jArr[1] = j3 + jRotateRight;
    }

    /* JADX INFO: renamed from: b */
    private static long m7687b(byte[] bArr, int i) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i, 8);
        byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
        return byteBufferWrap.getLong();
    }
}
