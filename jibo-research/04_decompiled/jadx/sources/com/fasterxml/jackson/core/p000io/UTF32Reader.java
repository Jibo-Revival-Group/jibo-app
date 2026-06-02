package com.fasterxml.jackson.core.p000io;

import com.facebook.internal.NativeProtocol;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* JADX INFO: loaded from: classes.dex */
public class UTF32Reader extends Reader {

    /* JADX INFO: renamed from: a */
    protected final IOContext f5511a;

    /* JADX INFO: renamed from: b */
    protected InputStream f5512b;

    /* JADX INFO: renamed from: c */
    protected byte[] f5513c;

    /* JADX INFO: renamed from: d */
    protected int f5514d;

    /* JADX INFO: renamed from: e */
    protected int f5515e;

    /* JADX INFO: renamed from: f */
    protected final boolean f5516f;

    /* JADX INFO: renamed from: j */
    protected final boolean f5520j;

    /* JADX INFO: renamed from: g */
    protected char f5517g = 0;

    /* JADX INFO: renamed from: h */
    protected int f5518h = 0;

    /* JADX INFO: renamed from: i */
    protected int f5519i = 0;

    /* JADX INFO: renamed from: k */
    protected char[] f5521k = null;

    public UTF32Reader(IOContext iOContext, InputStream inputStream, byte[] bArr, int i, int i2, boolean z) {
        this.f5511a = iOContext;
        this.f5512b = inputStream;
        this.f5513c = bArr;
        this.f5514d = i;
        this.f5515e = i2;
        this.f5516f = z;
        this.f5520j = inputStream != null;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.f5512b;
        if (inputStream != null) {
            this.f5512b = null;
            m6199a();
            inputStream.close();
        }
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        if (this.f5521k == null) {
            this.f5521k = new char[1];
        }
        if (read(this.f5521k, 0, 1) < 1) {
            return -1;
        }
        return this.f5521k[0];
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        int i3;
        int i4;
        int i5;
        if (this.f5513c == null) {
            return -1;
        }
        if (i2 >= 1) {
            if (i < 0 || i + i2 > cArr.length) {
                m6202a(cArr, i, i2);
            }
            int i6 = i2 + i;
            if (this.f5517g != 0) {
                i3 = i + 1;
                cArr[i] = this.f5517g;
                this.f5517g = (char) 0;
            } else {
                int i7 = this.f5515e - this.f5514d;
                if (i7 < 4 && !m6203a(i7)) {
                    return -1;
                }
                i3 = i;
            }
            while (true) {
                if (i3 >= i6) {
                    i4 = i3;
                    break;
                }
                int i8 = this.f5514d;
                if (this.f5516f) {
                    i5 = (this.f5513c[i8 + 3] & 255) | (this.f5513c[i8] << 24) | ((this.f5513c[i8 + 1] & 255) << 16) | ((this.f5513c[i8 + 2] & 255) << 8);
                } else {
                    i5 = (this.f5513c[i8 + 3] << 24) | (this.f5513c[i8] & 255) | ((this.f5513c[i8 + 1] & 255) << 8) | ((this.f5513c[i8 + 2] & 255) << 16);
                }
                this.f5514d += 4;
                if (i5 > 65535) {
                    if (i5 > 1114111) {
                        m6201a(i5, i3 - i, "(above " + Integer.toHexString(1114111) + ") ");
                    }
                    int i9 = i5 - NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                    i4 = i3 + 1;
                    cArr[i3] = (char) (55296 + (i9 >> 10));
                    i5 = (i9 & 1023) | 56320;
                    if (i4 >= i6) {
                        this.f5517g = (char) i5;
                        break;
                    }
                } else {
                    i4 = i3;
                }
                i3 = i4 + 1;
                cArr[i4] = (char) i5;
                if (this.f5514d >= this.f5515e) {
                    i4 = i3;
                    break;
                }
            }
            int i10 = i4 - i;
            this.f5518h += i10;
            return i10;
        }
        return i2;
    }

    /* JADX INFO: renamed from: a */
    private void m6200a(int i, int i2) throws IOException {
        throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + i + ", needed " + i2 + ", at char #" + this.f5518h + ", byte #" + (this.f5519i + i) + ")");
    }

    /* JADX INFO: renamed from: a */
    private void m6201a(int i, int i2, String str) throws IOException {
        throw new CharConversionException("Invalid UTF-32 character 0x" + Integer.toHexString(i) + str + " at char #" + (this.f5518h + i2) + ", byte #" + ((this.f5519i + this.f5514d) - 1) + ")");
    }

    /* JADX INFO: renamed from: a */
    private boolean m6203a(int i) throws IOException {
        this.f5519i += this.f5515e - i;
        if (i > 0) {
            if (this.f5514d > 0) {
                System.arraycopy(this.f5513c, this.f5514d, this.f5513c, 0, i);
                this.f5514d = 0;
            }
            this.f5515e = i;
        } else {
            this.f5514d = 0;
            int i2 = this.f5512b == null ? -1 : this.f5512b.read(this.f5513c);
            if (i2 < 1) {
                this.f5515e = 0;
                if (i2 < 0) {
                    if (!this.f5520j) {
                        return false;
                    }
                    m6199a();
                    return false;
                }
                m6204b();
            }
            this.f5515e = i2;
        }
        while (this.f5515e < 4) {
            int i3 = this.f5512b == null ? -1 : this.f5512b.read(this.f5513c, this.f5515e, this.f5513c.length - this.f5515e);
            if (i3 < 1) {
                if (i3 < 0) {
                    if (this.f5520j) {
                        m6199a();
                    }
                    m6200a(this.f5515e, 4);
                }
                m6204b();
            }
            this.f5515e = i3 + this.f5515e;
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m6199a() {
        byte[] bArr = this.f5513c;
        if (bArr != null) {
            this.f5513c = null;
            this.f5511a.m6158a(bArr);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m6202a(char[] cArr, int i, int i2) throws IOException {
        throw new ArrayIndexOutOfBoundsException("read(buf," + i + "," + i2 + "), cbuf[" + cArr.length + "]");
    }

    /* JADX INFO: renamed from: b */
    private void m6204b() throws IOException {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }
}
