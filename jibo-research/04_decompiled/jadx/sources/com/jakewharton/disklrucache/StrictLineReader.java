package com.jakewharton.disklrucache;

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
    private final InputStream f9164a;

    /* JADX INFO: renamed from: b */
    private final Charset f9165b;

    /* JADX INFO: renamed from: c */
    private byte[] f9166c;

    /* JADX INFO: renamed from: d */
    private int f9167d;

    /* JADX INFO: renamed from: e */
    private int f9168e;

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
        if (!charset.equals(Util.f9170a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f9164a = inputStream;
        this.f9165b = charset;
        this.f9166c = new byte[i];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f9164a) {
            if (this.f9166c != null) {
                this.f9166c = null;
                this.f9164a.close();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public String m9824a() throws IOException {
        int i;
        String string;
        synchronized (this.f9164a) {
            if (this.f9166c == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.f9167d >= this.f9168e) {
                m9823b();
            }
            int i2 = this.f9167d;
            while (true) {
                if (i2 != this.f9168e) {
                    if (this.f9166c[i2] != 10) {
                        i2++;
                    } else {
                        string = new String(this.f9166c, this.f9167d, ((i2 == this.f9167d || this.f9166c[i2 + (-1)] != 13) ? i2 : i2 - 1) - this.f9167d, this.f9165b.name());
                        this.f9167d = i2 + 1;
                    }
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.f9168e - this.f9167d) + 80) { // from class: com.jakewharton.disklrucache.StrictLineReader.1
                        @Override // java.io.ByteArrayOutputStream
                        public String toString() {
                            try {
                                return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + (-1)] != 13) ? this.count : this.count - 1, StrictLineReader.this.f9165b.name());
                            } catch (UnsupportedEncodingException e) {
                                throw new AssertionError(e);
                            }
                        }
                    };
                    loop1: while (true) {
                        byteArrayOutputStream.write(this.f9166c, this.f9167d, this.f9168e - this.f9167d);
                        this.f9168e = -1;
                        m9823b();
                        i = this.f9167d;
                        while (i != this.f9168e) {
                            if (this.f9166c[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                    if (i != this.f9167d) {
                        byteArrayOutputStream.write(this.f9166c, this.f9167d, i - this.f9167d);
                    }
                    this.f9167d = i + 1;
                    string = byteArrayOutputStream.toString();
                }
            }
            return string;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m9823b() throws IOException {
        int i = this.f9164a.read(this.f9166c, 0, this.f9166c.length);
        if (i == -1) {
            throw new EOFException();
        }
        this.f9167d = 0;
        this.f9168e = i;
    }
}
