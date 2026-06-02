package com.fasterxml.jackson.core.p000io;

import com.facebook.internal.NativeProtocol;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public final class UTF8Writer extends Writer {

    /* JADX INFO: renamed from: a */
    private final IOContext f5522a;

    /* JADX INFO: renamed from: b */
    private OutputStream f5523b;

    /* JADX INFO: renamed from: c */
    private byte[] f5524c;

    /* JADX INFO: renamed from: d */
    private final int f5525d;

    /* JADX INFO: renamed from: f */
    private int f5527f = 0;

    /* JADX INFO: renamed from: e */
    private int f5526e = 0;

    public UTF8Writer(IOContext iOContext, OutputStream outputStream) {
        this.f5522a = iOContext;
        this.f5523b = outputStream;
        this.f5524c = iOContext.m6170f();
        this.f5525d = this.f5524c.length - 4;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c) throws IOException {
        write(c);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f5523b != null) {
            if (this.f5526e > 0) {
                this.f5523b.write(this.f5524c, 0, this.f5526e);
                this.f5526e = 0;
            }
            OutputStream outputStream = this.f5523b;
            this.f5523b = null;
            byte[] bArr = this.f5524c;
            if (bArr != null) {
                this.f5524c = null;
                this.f5522a.m6164b(bArr);
            }
            outputStream.close();
            int i = this.f5527f;
            this.f5527f = 0;
            if (i > 0) {
                m6205b(i);
            }
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        if (this.f5523b != null) {
            if (this.f5526e > 0) {
                this.f5523b.write(this.f5524c, 0, this.f5526e);
                this.f5526e = 0;
            }
            this.f5523b.flush();
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOException {
        write(cArr, 0, cArr.length);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        char c;
        if (i2 < 2) {
            if (i2 == 1) {
                write(cArr[i]);
                return;
            }
            return;
        }
        if (this.f5527f > 0) {
            i2--;
            write(m6207a(cArr[i]));
            i++;
        }
        int i3 = this.f5526e;
        byte[] bArr = this.f5524c;
        int i4 = this.f5525d;
        int i5 = i2 + i;
        int i6 = i;
        while (i6 < i5) {
            if (i3 >= i4) {
                this.f5523b.write(bArr, 0, i3);
                i3 = 0;
            }
            int i7 = i6 + 1;
            char c2 = cArr[i6];
            if (c2 < 128) {
                int i8 = i3 + 1;
                bArr[i3] = (byte) c2;
                int i9 = i5 - i7;
                int i10 = i4 - i8;
                if (i9 <= i10) {
                    i10 = i9;
                }
                int i11 = i10 + i7;
                int i12 = i8;
                int i13 = i7;
                while (i13 < i11) {
                    int i14 = i13 + 1;
                    char c3 = cArr[i13];
                    if (c3 >= 128) {
                        i3 = i12;
                        i6 = i14;
                        c = c3;
                    } else {
                        bArr[i12] = (byte) c3;
                        i12++;
                        i13 = i14;
                    }
                }
                int i15 = i12;
                i6 = i13;
                i3 = i15;
            } else {
                i6 = i7;
                c = c2;
            }
            if (c < 2048) {
                int i16 = i3 + 1;
                bArr[i3] = (byte) ((c >> 6) | 192);
                i3 = i16 + 1;
                bArr[i16] = (byte) ((c & '?') | 128);
            } else if (c < 55296 || c > 57343) {
                int i17 = i3 + 1;
                bArr[i3] = (byte) ((c >> '\f') | 224);
                int i18 = i17 + 1;
                bArr[i17] = (byte) (((c >> 6) & 63) | 128);
                i3 = i18 + 1;
                bArr[i18] = (byte) ((c & '?') | 128);
            } else {
                if (c > 56319) {
                    this.f5526e = i3;
                    m6205b(c);
                }
                this.f5527f = c;
                if (i6 >= i5) {
                    break;
                }
                int i19 = i6 + 1;
                int iM6207a = m6207a(cArr[i6]);
                if (iM6207a > 1114111) {
                    this.f5526e = i3;
                    m6205b(iM6207a);
                }
                int i20 = i3 + 1;
                bArr[i3] = (byte) ((iM6207a >> 18) | 240);
                int i21 = i20 + 1;
                bArr[i20] = (byte) (((iM6207a >> 12) & 63) | 128);
                int i22 = i21 + 1;
                bArr[i21] = (byte) (((iM6207a >> 6) & 63) | 128);
                i3 = i22 + 1;
                bArr[i22] = (byte) ((iM6207a & 63) | 128);
                i6 = i19;
            }
        }
        this.f5526e = i3;
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        int i2;
        if (this.f5527f > 0) {
            i = m6207a(i);
        } else if (i >= 55296 && i <= 57343) {
            if (i > 56319) {
                m6205b(i);
            }
            this.f5527f = i;
            return;
        }
        if (this.f5526e >= this.f5525d) {
            this.f5523b.write(this.f5524c, 0, this.f5526e);
            this.f5526e = 0;
        }
        if (i < 128) {
            byte[] bArr = this.f5524c;
            int i3 = this.f5526e;
            this.f5526e = i3 + 1;
            bArr[i3] = (byte) i;
            return;
        }
        int i4 = this.f5526e;
        if (i < 2048) {
            int i5 = i4 + 1;
            this.f5524c[i4] = (byte) ((i >> 6) | 192);
            i2 = i5 + 1;
            this.f5524c[i5] = (byte) ((i & 63) | 128);
        } else if (i <= 65535) {
            int i6 = i4 + 1;
            this.f5524c[i4] = (byte) ((i >> 12) | 224);
            int i7 = i6 + 1;
            this.f5524c[i6] = (byte) (((i >> 6) & 63) | 128);
            i2 = i7 + 1;
            this.f5524c[i7] = (byte) ((i & 63) | 128);
        } else {
            if (i > 1114111) {
                m6205b(i);
            }
            int i8 = i4 + 1;
            this.f5524c[i4] = (byte) ((i >> 18) | 240);
            int i9 = i8 + 1;
            this.f5524c[i8] = (byte) (((i >> 12) & 63) | 128);
            int i10 = i9 + 1;
            this.f5524c[i9] = (byte) (((i >> 6) & 63) | 128);
            i2 = i10 + 1;
            this.f5524c[i10] = (byte) ((i & 63) | 128);
        }
        this.f5526e = i2;
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        write(str, 0, str.length());
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) throws IOException {
        char c;
        if (i2 < 2) {
            if (i2 == 1) {
                write(str.charAt(i));
                return;
            }
            return;
        }
        if (this.f5527f > 0) {
            i2--;
            write(m6207a(str.charAt(i)));
            i++;
        }
        int i3 = this.f5526e;
        byte[] bArr = this.f5524c;
        int i4 = this.f5525d;
        int i5 = i2 + i;
        int i6 = i;
        while (i6 < i5) {
            if (i3 >= i4) {
                this.f5523b.write(bArr, 0, i3);
                i3 = 0;
            }
            int i7 = i6 + 1;
            char cCharAt = str.charAt(i6);
            if (cCharAt < 128) {
                int i8 = i3 + 1;
                bArr[i3] = (byte) cCharAt;
                int i9 = i5 - i7;
                int i10 = i4 - i8;
                if (i9 <= i10) {
                    i10 = i9;
                }
                int i11 = i10 + i7;
                int i12 = i8;
                int i13 = i7;
                while (i13 < i11) {
                    int i14 = i13 + 1;
                    char cCharAt2 = str.charAt(i13);
                    if (cCharAt2 >= 128) {
                        i3 = i12;
                        i6 = i14;
                        c = cCharAt2;
                    } else {
                        bArr[i12] = (byte) cCharAt2;
                        i12++;
                        i13 = i14;
                    }
                }
                int i15 = i12;
                i6 = i13;
                i3 = i15;
            } else {
                i6 = i7;
                c = cCharAt;
            }
            if (c < 2048) {
                int i16 = i3 + 1;
                bArr[i3] = (byte) ((c >> 6) | 192);
                i3 = i16 + 1;
                bArr[i16] = (byte) ((c & '?') | 128);
            } else if (c < 55296 || c > 57343) {
                int i17 = i3 + 1;
                bArr[i3] = (byte) ((c >> '\f') | 224);
                int i18 = i17 + 1;
                bArr[i17] = (byte) (((c >> 6) & 63) | 128);
                i3 = i18 + 1;
                bArr[i18] = (byte) ((c & '?') | 128);
            } else {
                if (c > 56319) {
                    this.f5526e = i3;
                    m6205b(c);
                }
                this.f5527f = c;
                if (i6 >= i5) {
                    break;
                }
                int i19 = i6 + 1;
                int iM6207a = m6207a(str.charAt(i6));
                if (iM6207a > 1114111) {
                    this.f5526e = i3;
                    m6205b(iM6207a);
                }
                int i20 = i3 + 1;
                bArr[i3] = (byte) ((iM6207a >> 18) | 240);
                int i21 = i20 + 1;
                bArr[i20] = (byte) (((iM6207a >> 12) & 63) | 128);
                int i22 = i21 + 1;
                bArr[i21] = (byte) (((iM6207a >> 6) & 63) | 128);
                i3 = i22 + 1;
                bArr[i22] = (byte) ((iM6207a & 63) | 128);
                i6 = i19;
            }
        }
        this.f5526e = i3;
    }

    /* JADX INFO: renamed from: a */
    protected int m6207a(int i) throws IOException {
        int i2 = this.f5527f;
        this.f5527f = 0;
        if (i < 56320 || i > 57343) {
            throw new IOException("Broken surrogate pair: first char 0x" + Integer.toHexString(i2) + ", second 0x" + Integer.toHexString(i) + "; illegal combination");
        }
        return ((i2 - 55296) << 10) + NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST + (i - 56320);
    }

    /* JADX INFO: renamed from: b */
    protected static void m6205b(int i) throws IOException {
        throw new IOException(m6206c(i));
    }

    /* JADX INFO: renamed from: c */
    protected static String m6206c(int i) {
        if (i > 1114111) {
            return "Illegal character point (0x" + Integer.toHexString(i) + ") to output; max is 0x10FFFF as per RFC 4627";
        }
        if (i >= 55296) {
            if (i <= 56319) {
                return "Unmatched first part of surrogate pair (0x" + Integer.toHexString(i) + ")";
            }
            return "Unmatched second part of surrogate pair (0x" + Integer.toHexString(i) + ")";
        }
        return "Illegal character point (0x" + Integer.toHexString(i) + ") to output";
    }
}
