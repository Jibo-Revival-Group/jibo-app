package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes2.dex */
public final class Http2Stream {

    /* JADX INFO: renamed from: i */
    static final /* synthetic */ boolean f15531i;

    /* JADX INFO: renamed from: b */
    long f15533b;

    /* JADX INFO: renamed from: c */
    final int f15534c;

    /* JADX INFO: renamed from: d */
    final Http2Connection f15535d;

    /* JADX INFO: renamed from: e */
    final FramingSink f15536e;

    /* JADX INFO: renamed from: j */
    private final List<Header> f15540j;

    /* JADX INFO: renamed from: k */
    private List<Header> f15541k;

    /* JADX INFO: renamed from: l */
    private boolean f15542l;

    /* JADX INFO: renamed from: m */
    private final FramingSource f15543m;

    /* JADX INFO: renamed from: a */
    long f15532a = 0;

    /* JADX INFO: renamed from: f */
    final StreamTimeout f15537f = new StreamTimeout();

    /* JADX INFO: renamed from: g */
    final StreamTimeout f15538g = new StreamTimeout();

    /* JADX INFO: renamed from: h */
    ErrorCode f15539h = null;

    static {
        f15531i = !Http2Stream.class.desiredAssertionStatus();
    }

    Http2Stream(int i, Http2Connection http2Connection, boolean z, boolean z2, List<Header> list) {
        if (http2Connection == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.f15534c = i;
        this.f15535d = http2Connection;
        this.f15533b = http2Connection.f15470m.m16166d();
        this.f15543m = new FramingSource(http2Connection.f15469l.m16166d());
        this.f15536e = new FramingSink();
        this.f15543m.f15551b = z2;
        this.f15536e.f15546b = z;
        this.f15540j = list;
    }

    /* JADX INFO: renamed from: a */
    public int m16103a() {
        return this.f15534c;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0024  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean m16109b() {
        /*
            r2 = this;
            r0 = 0
            monitor-enter(r2)
            okhttp3.internal.http2.ErrorCode r1 = r2.f15539h     // Catch: java.lang.Throwable -> L26
            if (r1 == 0) goto L8
        L6:
            monitor-exit(r2)
            return r0
        L8:
            okhttp3.internal.http2.Http2Stream$FramingSource r1 = r2.f15543m     // Catch: java.lang.Throwable -> L26
            boolean r1 = r1.f15551b     // Catch: java.lang.Throwable -> L26
            if (r1 != 0) goto L14
            okhttp3.internal.http2.Http2Stream$FramingSource r1 = r2.f15543m     // Catch: java.lang.Throwable -> L26
            boolean r1 = r1.f15550a     // Catch: java.lang.Throwable -> L26
            if (r1 == 0) goto L24
        L14:
            okhttp3.internal.http2.Http2Stream$FramingSink r1 = r2.f15536e     // Catch: java.lang.Throwable -> L26
            boolean r1 = r1.f15546b     // Catch: java.lang.Throwable -> L26
            if (r1 != 0) goto L20
            okhttp3.internal.http2.Http2Stream$FramingSink r1 = r2.f15536e     // Catch: java.lang.Throwable -> L26
            boolean r1 = r1.f15545a     // Catch: java.lang.Throwable -> L26
            if (r1 == 0) goto L24
        L20:
            boolean r1 = r2.f15542l     // Catch: java.lang.Throwable -> L26
            if (r1 != 0) goto L6
        L24:
            r0 = 1
            goto L6
        L26:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.m16109b():boolean");
    }

    /* JADX INFO: renamed from: c */
    public boolean m16111c() {
        return this.f15535d.f15459b == ((this.f15534c & 1) == 1);
    }

    /* JADX INFO: renamed from: d */
    public synchronized List<Header> m16112d() throws IOException {
        List<Header> list;
        if (!m16111c()) {
            throw new IllegalStateException("servers cannot read response headers");
        }
        this.f15537f.m16242c();
        while (this.f15541k == null && this.f15539h == null) {
            try {
                m16120l();
            } catch (Throwable th) {
                this.f15537f.m16127b();
                throw th;
            }
        }
        this.f15537f.m16127b();
        list = this.f15541k;
        if (list != null) {
            this.f15541k = null;
        } else {
            throw new StreamResetException(this.f15539h);
        }
        return list;
    }

    /* JADX INFO: renamed from: e */
    public Timeout m16113e() {
        return this.f15537f;
    }

    /* JADX INFO: renamed from: f */
    public Timeout m16114f() {
        return this.f15538g;
    }

    /* JADX INFO: renamed from: g */
    public Source m16115g() {
        return this.f15543m;
    }

    /* JADX INFO: renamed from: h */
    public Sink m16116h() {
        synchronized (this) {
            if (!this.f15542l && !m16111c()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f15536e;
    }

    /* JADX INFO: renamed from: a */
    public void m16106a(ErrorCode errorCode) throws IOException {
        if (m16102d(errorCode)) {
            this.f15535d.m16065b(this.f15534c, errorCode);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m16108b(ErrorCode errorCode) {
        if (m16102d(errorCode)) {
            this.f15535d.m16055a(this.f15534c, errorCode);
        }
    }

    /* JADX INFO: renamed from: d */
    private boolean m16102d(ErrorCode errorCode) {
        if (!f15531i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            if (this.f15539h != null) {
                return false;
            }
            if (this.f15543m.f15551b && this.f15536e.f15546b) {
                return false;
            }
            this.f15539h = errorCode;
            notifyAll();
            this.f15535d.m16063b(this.f15534c);
            return true;
        }
    }

    /* JADX INFO: renamed from: a */
    void m16105a(List<Header> list) {
        boolean zM16109b = true;
        if (!f15531i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.f15542l = true;
            if (this.f15541k == null) {
                this.f15541k = list;
                zM16109b = m16109b();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f15541k);
                arrayList.add(null);
                arrayList.addAll(list);
                this.f15541k = arrayList;
            }
        }
        if (!zM16109b) {
            this.f15535d.m16063b(this.f15534c);
        }
    }

    /* JADX INFO: renamed from: a */
    void m16107a(BufferedSource bufferedSource, int i) throws IOException {
        if (!f15531i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.f15543m.m16124a(bufferedSource, i);
    }

    /* JADX INFO: renamed from: i */
    void m16117i() {
        boolean zM16109b;
        if (!f15531i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.f15543m.f15551b = true;
            zM16109b = m16109b();
            notifyAll();
        }
        if (!zM16109b) {
            this.f15535d.m16063b(this.f15534c);
        }
    }

    /* JADX INFO: renamed from: c */
    synchronized void m16110c(ErrorCode errorCode) {
        if (this.f15539h == null) {
            this.f15539h = errorCode;
            notifyAll();
        }
    }

    private final class FramingSource implements Source {

        /* JADX INFO: renamed from: c */
        static final /* synthetic */ boolean f15549c;

        /* JADX INFO: renamed from: a */
        boolean f15550a;

        /* JADX INFO: renamed from: b */
        boolean f15551b;

        /* JADX INFO: renamed from: e */
        private final Buffer f15553e = new Buffer();

        /* JADX INFO: renamed from: f */
        private final Buffer f15554f = new Buffer();

        /* JADX INFO: renamed from: g */
        private final long f15555g;

        static {
            f15549c = !Http2Stream.class.desiredAssertionStatus();
        }

        FramingSource(long j) {
            this.f15555g = j;
        }

        @Override // okio.Source
        /* JADX INFO: renamed from: a */
        public long mo15863a(Buffer buffer, long j) throws IOException {
            long jMo15863a;
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            synchronized (Http2Stream.this) {
                m16122b();
                m16123c();
                if (this.f15554f.m16263b() == 0) {
                    jMo15863a = -1;
                } else {
                    jMo15863a = this.f15554f.mo15863a(buffer, Math.min(j, this.f15554f.m16263b()));
                    Http2Stream.this.f15532a += jMo15863a;
                    if (Http2Stream.this.f15532a >= Http2Stream.this.f15535d.f15469l.m16166d() / 2) {
                        Http2Stream.this.f15535d.m16052a(Http2Stream.this.f15534c, Http2Stream.this.f15532a);
                        Http2Stream.this.f15532a = 0L;
                    }
                    synchronized (Http2Stream.this.f15535d) {
                        Http2Stream.this.f15535d.f15467j += jMo15863a;
                        if (Http2Stream.this.f15535d.f15467j >= Http2Stream.this.f15535d.f15469l.m16166d() / 2) {
                            Http2Stream.this.f15535d.m16052a(0, Http2Stream.this.f15535d.f15467j);
                            Http2Stream.this.f15535d.f15467j = 0L;
                        }
                    }
                }
            }
            return jMo15863a;
        }

        /* JADX INFO: renamed from: b */
        private void m16122b() throws IOException {
            Http2Stream.this.f15537f.m16242c();
            while (this.f15554f.m16263b() == 0 && !this.f15551b && !this.f15550a && Http2Stream.this.f15539h == null) {
                try {
                    Http2Stream.this.m16120l();
                } finally {
                    Http2Stream.this.f15537f.m16127b();
                }
            }
        }

        /* JADX INFO: renamed from: a */
        void m16124a(BufferedSource bufferedSource, long j) throws IOException {
            boolean z;
            boolean z2;
            if (!f15549c && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            while (j > 0) {
                synchronized (Http2Stream.this) {
                    z = this.f15551b;
                    z2 = this.f15554f.m16263b() + j > this.f15555g;
                }
                if (z2) {
                    bufferedSource.mo16292i(j);
                    Http2Stream.this.m16108b(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    bufferedSource.mo16292i(j);
                    return;
                }
                long jA = bufferedSource.mo15863a(this.f15553e, j);
                if (jA == -1) {
                    throw new EOFException();
                }
                j -= jA;
                synchronized (Http2Stream.this) {
                    boolean z3 = this.f15554f.m16263b() == 0;
                    this.f15554f.m16251a((Source) this.f15553e);
                    if (z3) {
                        Http2Stream.this.notifyAll();
                    }
                }
            }
        }

        @Override // okio.Source
        /* JADX INFO: renamed from: a */
        public Timeout mo15864a() {
            return Http2Stream.this.f15537f;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (Http2Stream.this) {
                this.f15550a = true;
                this.f15554f.m16310u();
                Http2Stream.this.notifyAll();
            }
            Http2Stream.this.m16118j();
        }

        /* JADX INFO: renamed from: c */
        private void m16123c() throws IOException {
            if (this.f15550a) {
                throw new IOException("stream closed");
            }
            if (Http2Stream.this.f15539h != null) {
                throw new StreamResetException(Http2Stream.this.f15539h);
            }
        }
    }

    /* JADX INFO: renamed from: j */
    void m16118j() throws IOException {
        boolean z;
        boolean zM16109b;
        if (!f15531i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = !this.f15543m.f15551b && this.f15543m.f15550a && (this.f15536e.f15546b || this.f15536e.f15545a);
            zM16109b = m16109b();
        }
        if (z) {
            m16106a(ErrorCode.CANCEL);
        } else if (!zM16109b) {
            this.f15535d.m16063b(this.f15534c);
        }
    }

    final class FramingSink implements Sink {

        /* JADX INFO: renamed from: c */
        static final /* synthetic */ boolean f15544c;

        /* JADX INFO: renamed from: a */
        boolean f15545a;

        /* JADX INFO: renamed from: b */
        boolean f15546b;

        /* JADX INFO: renamed from: e */
        private final Buffer f15548e = new Buffer();

        static {
            f15544c = !Http2Stream.class.desiredAssertionStatus();
        }

        FramingSink() {
        }

        @Override // okio.Sink
        /* JADX INFO: renamed from: a_ */
        public void mo15902a_(Buffer buffer, long j) throws IOException {
            if (!f15544c && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            this.f15548e.mo15902a_(buffer, j);
            while (this.f15548e.m16263b() >= 16384) {
                m16121a(false);
            }
        }

        /* JADX INFO: renamed from: a */
        private void m16121a(boolean z) throws IOException {
            long jMin;
            synchronized (Http2Stream.this) {
                Http2Stream.this.f15538g.m16242c();
                while (Http2Stream.this.f15533b <= 0 && !this.f15546b && !this.f15545a && Http2Stream.this.f15539h == null) {
                    try {
                        Http2Stream.this.m16120l();
                    } finally {
                    }
                }
                Http2Stream.this.f15538g.m16127b();
                Http2Stream.this.m16119k();
                jMin = Math.min(Http2Stream.this.f15533b, this.f15548e.m16263b());
                Http2Stream.this.f15533b -= jMin;
            }
            Http2Stream.this.f15538g.m16242c();
            try {
                Http2Stream.this.f15535d.m16057a(Http2Stream.this.f15534c, z && jMin == this.f15548e.m16263b(), this.f15548e, jMin);
            } finally {
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (!f15544c && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            synchronized (Http2Stream.this) {
                Http2Stream.this.m16119k();
            }
            while (this.f15548e.m16263b() > 0) {
                m16121a(false);
                Http2Stream.this.f15535d.m16064b();
            }
        }

        @Override // okio.Sink
        /* JADX INFO: renamed from: a */
        public Timeout mo16013a() {
            return Http2Stream.this.f15538g;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!f15544c && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            synchronized (Http2Stream.this) {
                if (!this.f15545a) {
                    if (!Http2Stream.this.f15536e.f15546b) {
                        if (this.f15548e.m16263b() > 0) {
                            while (this.f15548e.m16263b() > 0) {
                                m16121a(true);
                            }
                        } else {
                            Http2Stream.this.f15535d.m16057a(Http2Stream.this.f15534c, true, (Buffer) null, 0L);
                        }
                    }
                    synchronized (Http2Stream.this) {
                        this.f15545a = true;
                    }
                    Http2Stream.this.f15535d.m16064b();
                    Http2Stream.this.m16118j();
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m16104a(long j) {
        this.f15533b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* JADX INFO: renamed from: k */
    void m16119k() throws IOException {
        if (this.f15536e.f15545a) {
            throw new IOException("stream closed");
        }
        if (this.f15536e.f15546b) {
            throw new IOException("stream finished");
        }
        if (this.f15539h != null) {
            throw new StreamResetException(this.f15539h);
        }
    }

    /* JADX INFO: renamed from: l */
    void m16120l() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new InterruptedIOException();
        }
    }

    class StreamTimeout extends AsyncTimeout {
        StreamTimeout() {
        }

        @Override // okio.AsyncTimeout
        /* JADX INFO: renamed from: a */
        protected void mo16126a() {
            Http2Stream.this.m16108b(ErrorCode.CANCEL);
        }

        @Override // okio.AsyncTimeout
        /* JADX INFO: renamed from: a */
        protected IOException mo16125a(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* JADX INFO: renamed from: b */
        public void m16127b() throws IOException {
            if (m16243w_()) {
                throw mo16125a((IOException) null);
            }
        }
    }
}
