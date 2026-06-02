package com.mixpanel.android.java_websocket.util;

import android.annotation.SuppressLint;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"Assert"})
public class Base64 {

    /* JADX INFO: renamed from: a */
    static final /* synthetic */ boolean f11792a;

    /* JADX INFO: renamed from: b */
    private static final byte[] f11793b;

    /* JADX INFO: renamed from: c */
    private static final byte[] f11794c;

    /* JADX INFO: renamed from: d */
    private static final byte[] f11795d;

    /* JADX INFO: renamed from: e */
    private static final byte[] f11796e;

    /* JADX INFO: renamed from: f */
    private static final byte[] f11797f;

    /* JADX INFO: renamed from: g */
    private static final byte[] f11798g;

    static {
        f11792a = !Base64.class.desiredAssertionStatus();
        f11793b = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        f11794c = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        f11795d = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        f11796e = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        f11797f = new byte[]{45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
        f11798g = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    }

    /* JADX INFO: renamed from: b */
    private static final byte[] m11650b(int i) {
        if ((i & 16) == 16) {
            return f11795d;
        }
        if ((i & 32) == 32) {
            return f11797f;
        }
        return f11793b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public static final byte[] m11653c(int i) {
        if ((i & 16) == 16) {
            return f11796e;
        }
        if ((i & 32) == 32) {
            return f11798g;
        }
        return f11794c;
    }

    private Base64() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static byte[] m11652b(byte[] bArr, byte[] bArr2, int i, int i2) {
        m11647a(bArr2, 0, i, bArr, 0, i2);
        return bArr;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX INFO: renamed from: a */
    private static byte[] m11647a(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        byte[] bArrM11650b = m11650b(i4);
        int i5 = (i2 > 2 ? (bArr[i + 2] << 24) >>> 24 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0) | (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0);
        switch (i2) {
            case 1:
                bArr2[i3] = bArrM11650b[i5 >>> 18];
                bArr2[i3 + 1] = bArrM11650b[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = 61;
                bArr2[i3 + 3] = 61;
                return bArr2;
            case 2:
                bArr2[i3] = bArrM11650b[i5 >>> 18];
                bArr2[i3 + 1] = bArrM11650b[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = bArrM11650b[(i5 >>> 6) & 63];
                bArr2[i3 + 3] = 61;
                return bArr2;
            case 3:
                bArr2[i3] = bArrM11650b[i5 >>> 18];
                bArr2[i3 + 1] = bArrM11650b[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = bArrM11650b[(i5 >>> 6) & 63];
                bArr2[i3 + 3] = bArrM11650b[i5 & 63];
                return bArr2;
            default:
                return bArr2;
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m11644a(byte[] bArr) throws Throwable {
        String strM11645a = null;
        try {
            strM11645a = m11645a(bArr, 0, bArr.length, 0);
        } catch (IOException e) {
            if (!f11792a) {
                throw new AssertionError(e.getMessage());
            }
        }
        if (f11792a || strM11645a != null) {
            return strM11645a;
        }
        throw new AssertionError();
    }

    /* JADX INFO: renamed from: a */
    public static String m11645a(byte[] bArr, int i, int i2, int i3) throws Throwable {
        byte[] bArrM11651b = m11651b(bArr, i, i2, i3);
        try {
            return new String(bArrM11651b, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            return new String(bArrM11651b);
        }
    }

    /* JADX INFO: renamed from: b */
    public static byte[] m11651b(byte[] bArr, int i, int i2, int i3) throws Throwable {
        OutputStream outputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        if (bArr == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        }
        if (i < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i);
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Cannot have length offset: " + i2);
        }
        if (i + i2 > bArr.length) {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length)));
        }
        if ((i3 & 2) == 0) {
            boolean z = (i3 & 8) != 0;
            int i4 = (i2 % 3 > 0 ? 4 : 0) + ((i2 / 3) * 4);
            if (z) {
                i4 += i4 / 76;
            }
            byte[] bArr2 = new byte[i4];
            int i5 = i2 - 2;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (i8 < i5) {
                m11647a(bArr, i8 + i, 3, bArr2, i7, i3);
                int i9 = i6 + 4;
                if (z && i9 >= 76) {
                    bArr2[i7 + 4] = 10;
                    i7++;
                    i9 = 0;
                }
                i7 += 4;
                i6 = i9;
                i8 += 3;
            }
            if (i8 < i2) {
                m11647a(bArr, i8 + i, i2 - i8, bArr2, i7, i3);
                i7 += 4;
            }
            if (i7 > bArr2.length - 1) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i7];
            System.arraycopy(bArr2, 0, bArr3, 0, i7);
            return bArr3;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                outputStream = new OutputStream(byteArrayOutputStream, i3 | 1);
                try {
                    gZIPOutputStream = new GZIPOutputStream(outputStream);
                } catch (IOException e) {
                    e = e;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e = e2;
                outputStream = null;
                byteArrayOutputStream2 = byteArrayOutputStream;
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
            }
        } catch (IOException e3) {
            e = e3;
            outputStream = null;
            byteArrayOutputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
            byteArrayOutputStream = null;
        }
        try {
            gZIPOutputStream.write(bArr, i, i2);
            gZIPOutputStream.close();
            try {
                gZIPOutputStream.close();
            } catch (Exception e4) {
            }
            try {
                outputStream.close();
            } catch (Exception e5) {
            }
            try {
                byteArrayOutputStream.close();
            } catch (Exception e6) {
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e7) {
            e = e7;
            gZIPOutputStream2 = gZIPOutputStream;
            byteArrayOutputStream2 = byteArrayOutputStream;
            try {
                throw e;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = byteArrayOutputStream2;
                try {
                    gZIPOutputStream2.close();
                } catch (Exception e8) {
                }
                try {
                    outputStream.close();
                } catch (Exception e9) {
                }
                try {
                    byteArrayOutputStream.close();
                    throw th;
                } catch (Exception e10) {
                    throw th;
                }
            }
        } catch (Throwable th5) {
            th = th5;
            gZIPOutputStream2 = gZIPOutputStream;
            gZIPOutputStream2.close();
            outputStream.close();
            byteArrayOutputStream.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static int m11649b(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (bArr == null) {
            throw new NullPointerException("Source array was null.");
        }
        if (bArr2 == null) {
            throw new NullPointerException("Destination array was null.");
        }
        if (i < 0 || i + 3 >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i)));
        }
        if (i2 < 0 || i2 + 2 >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i2)));
        }
        byte[] bArrM11653c = m11653c(i3);
        if (bArr[i + 2] == 61) {
            bArr2[i2] = (byte) ((((bArrM11653c[bArr[i]] & 255) << 18) | ((bArrM11653c[bArr[i + 1]] & 255) << 12)) >>> 16);
            return 1;
        }
        if (bArr[i + 3] == 61) {
            int i4 = ((bArrM11653c[bArr[i]] & 255) << 18) | ((bArrM11653c[bArr[i + 1]] & 255) << 12) | ((bArrM11653c[bArr[i + 2]] & 255) << 6);
            bArr2[i2] = (byte) (i4 >>> 16);
            bArr2[i2 + 1] = (byte) (i4 >>> 8);
            return 2;
        }
        int i5 = ((bArrM11653c[bArr[i]] & 255) << 18) | ((bArrM11653c[bArr[i + 1]] & 255) << 12) | ((bArrM11653c[bArr[i + 2]] & 255) << 6) | (bArrM11653c[bArr[i + 3]] & 255);
        bArr2[i2] = (byte) (i5 >> 16);
        bArr2[i2 + 1] = (byte) (i5 >> 8);
        bArr2[i2 + 2] = (byte) i5;
        return 3;
    }

    public static class OutputStream extends FilterOutputStream {

        /* JADX INFO: renamed from: a */
        private boolean f11799a;

        /* JADX INFO: renamed from: b */
        private int f11800b;

        /* JADX INFO: renamed from: c */
        private byte[] f11801c;

        /* JADX INFO: renamed from: d */
        private int f11802d;

        /* JADX INFO: renamed from: e */
        private int f11803e;

        /* JADX INFO: renamed from: f */
        private boolean f11804f;

        /* JADX INFO: renamed from: g */
        private byte[] f11805g;

        /* JADX INFO: renamed from: h */
        private boolean f11806h;

        /* JADX INFO: renamed from: i */
        private int f11807i;

        /* JADX INFO: renamed from: j */
        private byte[] f11808j;

        public OutputStream(java.io.OutputStream outputStream, int i) {
            super(outputStream);
            this.f11804f = (i & 8) != 0;
            this.f11799a = (i & 1) != 0;
            this.f11802d = this.f11799a ? 3 : 4;
            this.f11801c = new byte[this.f11802d];
            this.f11800b = 0;
            this.f11803e = 0;
            this.f11806h = false;
            this.f11805g = new byte[4];
            this.f11807i = i;
            this.f11808j = Base64.m11653c(i);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            if (this.f11806h) {
                this.out.write(i);
                return;
            }
            if (this.f11799a) {
                byte[] bArr = this.f11801c;
                int i2 = this.f11800b;
                this.f11800b = i2 + 1;
                bArr[i2] = (byte) i;
                if (this.f11800b >= this.f11802d) {
                    this.out.write(Base64.m11652b(this.f11805g, this.f11801c, this.f11802d, this.f11807i));
                    this.f11803e += 4;
                    if (this.f11804f && this.f11803e >= 76) {
                        this.out.write(10);
                        this.f11803e = 0;
                    }
                    this.f11800b = 0;
                    return;
                }
                return;
            }
            if (this.f11808j[i & 127] > -5) {
                byte[] bArr2 = this.f11801c;
                int i3 = this.f11800b;
                this.f11800b = i3 + 1;
                bArr2[i3] = (byte) i;
                if (this.f11800b >= this.f11802d) {
                    this.out.write(this.f11805g, 0, Base64.m11649b(this.f11801c, 0, this.f11805g, 0, this.f11807i));
                    this.f11800b = 0;
                    return;
                }
                return;
            }
            if (this.f11808j[i & 127] != -5) {
                throw new IOException("Invalid character in Base64 data.");
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.f11806h) {
                this.out.write(bArr, i, i2);
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }

        /* JADX INFO: renamed from: a */
        public void m11654a() throws IOException {
            if (this.f11800b > 0) {
                if (this.f11799a) {
                    this.out.write(Base64.m11652b(this.f11805g, this.f11801c, this.f11800b, this.f11807i));
                    this.f11800b = 0;
                    return;
                }
                throw new IOException("Base64 input not properly padded.");
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            m11654a();
            super.close();
            this.f11801c = null;
            this.out = null;
        }
    }
}
