package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class AsyncTimeout extends Timeout {

    /* JADX INFO: renamed from: b */
    static AsyncTimeout f15630b;

    /* JADX INFO: renamed from: e */
    private boolean f15632e;

    /* JADX INFO: renamed from: f */
    private AsyncTimeout f15633f;

    /* JADX INFO: renamed from: g */
    private long f15634g;

    /* JADX INFO: renamed from: a */
    private static final long f15629a = TimeUnit.SECONDS.toMillis(60);

    /* JADX INFO: renamed from: d */
    private static final long f15631d = TimeUnit.MILLISECONDS.toNanos(f15629a);

    /* JADX INFO: renamed from: c */
    public final void m16242c() {
        if (this.f15632e) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long jX_ = mo16347x_();
        boolean zY_ = mo16348y_();
        if (jX_ != 0 || zY_) {
            this.f15632e = true;
            m16234a(this, jX_, zY_);
        }
    }

    /* JADX INFO: renamed from: a */
    private static synchronized void m16234a(AsyncTimeout asyncTimeout, long j, boolean z) {
        if (f15630b == null) {
            f15630b = new AsyncTimeout();
            new Watchdog().start();
        }
        long jNanoTime = System.nanoTime();
        if (j != 0 && z) {
            asyncTimeout.f15634g = Math.min(j, asyncTimeout.mo16344d() - jNanoTime) + jNanoTime;
        } else if (j != 0) {
            asyncTimeout.f15634g = jNanoTime + j;
        } else if (z) {
            asyncTimeout.f15634g = asyncTimeout.mo16344d();
        } else {
            throw new AssertionError();
        }
        long jM16236b = asyncTimeout.m16236b(jNanoTime);
        AsyncTimeout asyncTimeout2 = f15630b;
        while (asyncTimeout2.f15633f != null && jM16236b >= asyncTimeout2.f15633f.m16236b(jNanoTime)) {
            asyncTimeout2 = asyncTimeout2.f15633f;
        }
        asyncTimeout.f15633f = asyncTimeout2.f15633f;
        asyncTimeout2.f15633f = asyncTimeout;
        if (asyncTimeout2 == f15630b) {
            AsyncTimeout.class.notify();
        }
    }

    /* JADX INFO: renamed from: w_ */
    public final boolean m16243w_() {
        if (!this.f15632e) {
            return false;
        }
        this.f15632e = false;
        return m16235a(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000b, code lost:
    
        r0.f15633f = r3.f15633f;
        r3.f15633f = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
    
        r0 = false;
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static synchronized boolean m16235a(okio.AsyncTimeout r3) {
        /*
            java.lang.Class<okio.AsyncTimeout> r1 = okio.AsyncTimeout.class
            monitor-enter(r1)
            okio.AsyncTimeout r0 = okio.AsyncTimeout.f15630b     // Catch: java.lang.Throwable -> L1a
        L5:
            if (r0 == 0) goto L18
            okio.AsyncTimeout r2 = r0.f15633f     // Catch: java.lang.Throwable -> L1a
            if (r2 != r3) goto L15
            okio.AsyncTimeout r2 = r3.f15633f     // Catch: java.lang.Throwable -> L1a
            r0.f15633f = r2     // Catch: java.lang.Throwable -> L1a
            r0 = 0
            r3.f15633f = r0     // Catch: java.lang.Throwable -> L1a
            r0 = 0
        L13:
            monitor-exit(r1)
            return r0
        L15:
            okio.AsyncTimeout r0 = r0.f15633f     // Catch: java.lang.Throwable -> L1a
            goto L5
        L18:
            r0 = 1
            goto L13
        L1a:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.AsyncTimeout.m16235a(okio.AsyncTimeout):boolean");
    }

    /* JADX INFO: renamed from: b */
    private long m16236b(long j) {
        return this.f15634g - j;
    }

    /* JADX INFO: renamed from: a */
    protected void mo16126a() {
    }

    /* JADX INFO: renamed from: a */
    public final Sink m16238a(final Sink sink) {
        return new Sink() { // from class: okio.AsyncTimeout.1
            @Override // okio.Sink
            /* JADX INFO: renamed from: a_ */
            public void mo15902a_(Buffer buffer, long j) throws IOException {
                Util.m16387a(buffer.f15643b, 0L, j);
                long j2 = j;
                while (j2 > 0) {
                    Segment segment = buffer.f15642a;
                    long j3 = 0;
                    while (true) {
                        if (j3 >= 65536) {
                            break;
                        }
                        long j4 = ((long) (buffer.f15642a.f15686c - buffer.f15642a.f15685b)) + j3;
                        if (j4 >= j2) {
                            j3 = j2;
                            break;
                        } else {
                            segment = segment.f15689f;
                            j3 = j4;
                        }
                    }
                    AsyncTimeout.this.m16242c();
                    try {
                        try {
                            sink.mo15902a_(buffer, j3);
                            j2 -= j3;
                            AsyncTimeout.this.m16240a(true);
                        } catch (IOException e) {
                            throw AsyncTimeout.this.m16241b(e);
                        }
                    } catch (Throwable th) {
                        AsyncTimeout.this.m16240a(false);
                        throw th;
                    }
                }
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() throws IOException {
                AsyncTimeout.this.m16242c();
                try {
                    try {
                        sink.flush();
                        AsyncTimeout.this.m16240a(true);
                    } catch (IOException e) {
                        throw AsyncTimeout.this.m16241b(e);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.m16240a(false);
                    throw th;
                }
            }

            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                AsyncTimeout.this.m16242c();
                try {
                    try {
                        sink.close();
                        AsyncTimeout.this.m16240a(true);
                    } catch (IOException e) {
                        throw AsyncTimeout.this.m16241b(e);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.m16240a(false);
                    throw th;
                }
            }

            @Override // okio.Sink
            /* JADX INFO: renamed from: a */
            public Timeout mo16013a() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + sink + ")";
            }
        };
    }

    /* JADX INFO: renamed from: a */
    public final Source m16239a(final Source source) {
        return new Source() { // from class: okio.AsyncTimeout.2
            @Override // okio.Source
            /* JADX INFO: renamed from: a */
            public long mo15863a(Buffer buffer, long j) throws IOException {
                AsyncTimeout.this.m16242c();
                try {
                    try {
                        long jMo15863a = source.mo15863a(buffer, j);
                        AsyncTimeout.this.m16240a(true);
                        return jMo15863a;
                    } catch (IOException e) {
                        throw AsyncTimeout.this.m16241b(e);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.m16240a(false);
                    throw th;
                }
            }

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                try {
                    try {
                        source.close();
                        AsyncTimeout.this.m16240a(true);
                    } catch (IOException e) {
                        throw AsyncTimeout.this.m16241b(e);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.m16240a(false);
                    throw th;
                }
            }

            @Override // okio.Source
            /* JADX INFO: renamed from: a */
            public Timeout mo15864a() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + source + ")";
            }
        };
    }

    /* JADX INFO: renamed from: a */
    final void m16240a(boolean z) throws IOException {
        if (m16243w_() && z) {
            throw mo16125a((IOException) null);
        }
    }

    /* JADX INFO: renamed from: b */
    final IOException m16241b(IOException iOException) throws IOException {
        return !m16243w_() ? iOException : mo16125a(iOException);
    }

    /* JADX INFO: renamed from: a */
    protected IOException mo16125a(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    private static final class Watchdog extends Thread {
        Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x001a, code lost:
        
            r0.mo16126a();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<okio.AsyncTimeout> r1 = okio.AsyncTimeout.class
                monitor-enter(r1)     // Catch: java.lang.InterruptedException -> Le
                okio.AsyncTimeout r0 = okio.AsyncTimeout.m16237e()     // Catch: java.lang.Throwable -> Lb
                if (r0 != 0) goto L10
                monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb
                goto L0
            Lb:
                r0 = move-exception
                monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb
                throw r0     // Catch: java.lang.InterruptedException -> Le
            Le:
                r0 = move-exception
                goto L0
            L10:
                okio.AsyncTimeout r2 = okio.AsyncTimeout.f15630b     // Catch: java.lang.Throwable -> Lb
                if (r0 != r2) goto L19
                r0 = 0
                okio.AsyncTimeout.f15630b = r0     // Catch: java.lang.Throwable -> Lb
                monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb
                return
            L19:
                monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb
                r0.mo16126a()     // Catch: java.lang.InterruptedException -> Le
                goto L0
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.AsyncTimeout.Watchdog.run():void");
        }
    }

    /* JADX INFO: renamed from: e */
    static AsyncTimeout m16237e() throws InterruptedException {
        AsyncTimeout asyncTimeout = f15630b.f15633f;
        if (asyncTimeout == null) {
            long jNanoTime = System.nanoTime();
            AsyncTimeout.class.wait(f15629a);
            if (f15630b.f15633f != null || System.nanoTime() - jNanoTime < f15631d) {
                return null;
            }
            return f15630b;
        }
        long jM16236b = asyncTimeout.m16236b(System.nanoTime());
        if (jM16236b > 0) {
            long j = jM16236b / 1000000;
            AsyncTimeout.class.wait(j, (int) (jM16236b - (1000000 * j)));
            return null;
        }
        f15630b.f15633f = asyncTimeout.f15633f;
        asyncTimeout.f15633f = null;
        return asyncTimeout;
    }
}
