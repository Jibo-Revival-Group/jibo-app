package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ResponseBody implements Closeable {

    /* JADX INFO: renamed from: a */
    private Reader f15224a;

    /* JADX INFO: renamed from: a */
    public abstract MediaType mo15511a();

    /* JADX INFO: renamed from: b */
    public abstract long mo15512b();

    /* JADX INFO: renamed from: c */
    public abstract BufferedSource mo15513c();

    /* JADX INFO: renamed from: d */
    public final byte[] m15824d() throws IOException {
        long jMo15512b = mo15512b();
        if (jMo15512b > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + jMo15512b);
        }
        BufferedSource bufferedSourceMo15513c = mo15513c();
        try {
            byte[] bArrMo16309t = bufferedSourceMo15513c.mo16309t();
            Util.m15843a(bufferedSourceMo15513c);
            if (jMo15512b != -1 && jMo15512b != bArrMo16309t.length) {
                throw new IOException("Content-Length (" + jMo15512b + ") and stream length (" + bArrMo16309t.length + ") disagree");
            }
            return bArrMo16309t;
        } catch (Throwable th) {
            Util.m15843a(bufferedSourceMo15513c);
            throw th;
        }
    }

    /* JADX INFO: renamed from: e */
    public final Reader m15825e() {
        Reader reader = this.f15224a;
        if (reader != null) {
            return reader;
        }
        BomAwareReader bomAwareReader = new BomAwareReader(mo15513c(), m15823g());
        this.f15224a = bomAwareReader;
        return bomAwareReader;
    }

    /* JADX INFO: renamed from: f */
    public final String m15826f() throws IOException {
        BufferedSource bufferedSourceMo15513c = mo15513c();
        try {
            return bufferedSourceMo15513c.mo16253a(Util.m15838a(bufferedSourceMo15513c, m15823g()));
        } finally {
            Util.m15843a(bufferedSourceMo15513c);
        }
    }

    /* JADX INFO: renamed from: g */
    private Charset m15823g() {
        MediaType mediaTypeMo15511a = mo15511a();
        return mediaTypeMo15511a != null ? mediaTypeMo15511a.m15697a(Util.f15241e) : Util.f15241e;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.m15843a(mo15513c());
    }

    /* JADX INFO: renamed from: a */
    public static ResponseBody m15822a(MediaType mediaType, byte[] bArr) {
        return m15821a(mediaType, bArr.length, new Buffer().mo16273c(bArr));
    }

    /* JADX INFO: renamed from: a */
    public static ResponseBody m15821a(final MediaType mediaType, final long j, final BufferedSource bufferedSource) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        return new ResponseBody() { // from class: okhttp3.ResponseBody.1
            @Override // okhttp3.ResponseBody
            /* JADX INFO: renamed from: a */
            public MediaType mo15511a() {
                return mediaType;
            }

            @Override // okhttp3.ResponseBody
            /* JADX INFO: renamed from: b */
            public long mo15512b() {
                return j;
            }

            @Override // okhttp3.ResponseBody
            /* JADX INFO: renamed from: c */
            public BufferedSource mo15513c() {
                return bufferedSource;
            }
        };
    }

    static final class BomAwareReader extends Reader {

        /* JADX INFO: renamed from: a */
        private final BufferedSource f15228a;

        /* JADX INFO: renamed from: b */
        private final Charset f15229b;

        /* JADX INFO: renamed from: c */
        private boolean f15230c;

        /* JADX INFO: renamed from: d */
        private Reader f15231d;

        BomAwareReader(BufferedSource bufferedSource, Charset charset) {
            this.f15228a = bufferedSource;
            this.f15229b = charset;
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            if (this.f15230c) {
                throw new IOException("Stream closed");
            }
            Reader inputStreamReader = this.f15231d;
            if (inputStreamReader == null) {
                inputStreamReader = new InputStreamReader(this.f15228a.mo16284g(), Util.m15838a(this.f15228a, this.f15229b));
                this.f15231d = inputStreamReader;
            }
            return inputStreamReader.read(cArr, i, i2);
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f15230c = true;
            if (this.f15231d != null) {
                this.f15231d.close();
            } else {
                this.f15228a.close();
            }
        }
    }
}
