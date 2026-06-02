package com.bumptech.glide.disklrucache;

import com.facebook.internal.Utility;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
class StrictLineReader implements Closeable {

    /* JADX INFO: renamed from: a */
    private final InputStream f4775a;

    /* JADX INFO: renamed from: b */
    private final Charset f4776b;

    /* JADX INFO: renamed from: c */
    private byte[] f4777c;

    /* JADX INFO: renamed from: d */
    private int f4778d;

    /* JADX INFO: renamed from: e */
    private int f4779e;

    public StrictLineReader(InputStream inputStream, Charset charset) {
        this(inputStream, Utility.DEFAULT_STREAM_BUFFER_SIZE, charset);
    }

    public StrictLineReader(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(Util.f4781a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f4775a = inputStream;
        this.f4776b = charset;
        this.f4777c = new byte[i];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f4775a) {
            if (this.f4777c != null) {
                this.f4777c = null;
                this.f4775a.close();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public String m5342a() throws IOException {
        int i;
        String string;
        synchronized (this.f4775a) {
            if (this.f4777c == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.f4778d >= this.f4779e) {
                m5341c();
            }
            int i2 = this.f4778d;
            while (true) {
                if (i2 != this.f4779e) {
                    if (this.f4777c[i2] != 10) {
                        i2++;
                    } else {
                        string = new String(this.f4777c, this.f4778d, ((i2 == this.f4778d || this.f4777c[i2 + (-1)] != 13) ? i2 : i2 - 1) - this.f4778d, this.f4776b.name());
                        this.f4778d = i2 + 1;
                    }
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.f4779e - this.f4778d) + 80) { // from class: com.bumptech.glide.disklrucache.StrictLineReader.1
                        @Override // java.io.ByteArrayOutputStream
                        public String toString() {
                            try {
                                return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + (-1)] != 13) ? this.count : this.count - 1, StrictLineReader.this.f4776b.name());
                            } catch (UnsupportedEncodingException e) {
                                throw new AssertionError(e);
                            }
                        }
                    };
                    loop1: while (true) {
                        byteArrayOutputStream.write(this.f4777c, this.f4778d, this.f4779e - this.f4778d);
                        this.f4779e = -1;
                        m5341c();
                        i = this.f4778d;
                        while (i != this.f4779e) {
                            if (this.f4777c[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                    if (i != this.f4778d) {
                        byteArrayOutputStream.write(this.f4777c, this.f4778d, i - this.f4778d);
                    }
                    this.f4778d = i + 1;
                    string = byteArrayOutputStream.toString();
                }
            }
            return string;
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean m5343b() {
        return this.f4779e == -1;
    }

    /* JADX INFO: renamed from: c */
    private void m5341c() throws IOException {
        int i = this.f4775a.read(this.f4777c, 0, this.f4777c.length);
        if (i == -1) {
            throw new EOFException();
        }
        this.f4778d = 0;
        this.f4779e = i;
    }
}
