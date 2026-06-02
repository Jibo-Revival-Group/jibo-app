package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Http2Reader;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class Http2Connection implements Closeable {

    /* JADX INFO: renamed from: a */
    static final ExecutorService f15457a;

    /* JADX INFO: renamed from: s */
    static final /* synthetic */ boolean f15458s;

    /* JADX INFO: renamed from: b */
    final boolean f15459b;

    /* JADX INFO: renamed from: c */
    final Listener f15460c;

    /* JADX INFO: renamed from: e */
    final String f15462e;

    /* JADX INFO: renamed from: f */
    int f15463f;

    /* JADX INFO: renamed from: g */
    int f15464g;

    /* JADX INFO: renamed from: h */
    boolean f15465h;

    /* JADX INFO: renamed from: i */
    final PushObserver f15466i;

    /* JADX INFO: renamed from: k */
    long f15468k;

    /* JADX INFO: renamed from: o */
    final Socket f15472o;

    /* JADX INFO: renamed from: p */
    final Http2Writer f15473p;

    /* JADX INFO: renamed from: q */
    final ReaderRunnable f15474q;

    /* JADX INFO: renamed from: t */
    private final ExecutorService f15476t;

    /* JADX INFO: renamed from: u */
    private Map<Integer, Ping> f15477u;

    /* JADX INFO: renamed from: v */
    private int f15478v;

    /* JADX INFO: renamed from: d */
    final Map<Integer, Http2Stream> f15461d = new LinkedHashMap();

    /* JADX INFO: renamed from: j */
    long f15467j = 0;

    /* JADX INFO: renamed from: l */
    Settings f15469l = new Settings();

    /* JADX INFO: renamed from: m */
    final Settings f15470m = new Settings();

    /* JADX INFO: renamed from: n */
    boolean f15471n = false;

    /* JADX INFO: renamed from: r */
    final Set<Integer> f15475r = new LinkedHashSet();

    static {
        f15458s = !Http2Connection.class.desiredAssertionStatus();
        f15457a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.m15841a("OkHttp Http2Connection", true));
    }

    Http2Connection(Builder builder) {
        this.f15466i = builder.f15510f;
        this.f15459b = builder.f15511g;
        this.f15460c = builder.f15509e;
        this.f15464g = builder.f15511g ? 1 : 2;
        if (builder.f15511g) {
            this.f15464g += 2;
        }
        this.f15478v = builder.f15511g ? 1 : 2;
        if (builder.f15511g) {
            this.f15469l.m16158a(7, 16777216);
        }
        this.f15462e = builder.f15506b;
        this.f15476t = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.m15841a(Util.m15836a("OkHttp %s Push Observer", this.f15462e), true));
        this.f15470m.m16158a(7, 65535);
        this.f15470m.m16158a(5, 16384);
        this.f15468k = this.f15470m.m16166d();
        this.f15472o = builder.f15505a;
        this.f15473p = new Http2Writer(builder.f15508d, this.f15459b);
        this.f15474q = new ReaderRunnable(new Http2Reader(builder.f15507c, this.f15459b));
    }

    /* JADX INFO: renamed from: a */
    synchronized Http2Stream m16050a(int i) {
        return this.f15461d.get(Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: b */
    synchronized Http2Stream m16063b(int i) {
        Http2Stream http2StreamRemove;
        http2StreamRemove = this.f15461d.remove(Integer.valueOf(i));
        notifyAll();
        return http2StreamRemove;
    }

    /* JADX INFO: renamed from: a */
    public synchronized int m16049a() {
        return this.f15470m.m16165c(Integer.MAX_VALUE);
    }

    /* JADX INFO: renamed from: a */
    public Http2Stream m16051a(List<Header> list, boolean z) throws IOException {
        return m16048b(0, list, z);
    }

    /* JADX INFO: renamed from: b */
    private Http2Stream m16048b(int i, List<Header> list, boolean z) throws IOException {
        int i2;
        Http2Stream http2Stream;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.f15473p) {
            synchronized (this) {
                if (this.f15465h) {
                    throw new ConnectionShutdownException();
                }
                i2 = this.f15464g;
                this.f15464g += 2;
                http2Stream = new Http2Stream(i2, this, z3, false, list);
                z2 = !z || this.f15468k == 0 || http2Stream.f15533b == 0;
                if (http2Stream.m16109b()) {
                    this.f15461d.put(Integer.valueOf(i2), http2Stream);
                }
            }
            if (i == 0) {
                this.f15473p.m16139a(z3, i2, i, list);
            } else {
                if (this.f15459b) {
                    throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                }
                this.f15473p.m16133a(i, i2, list);
            }
        }
        if (z2) {
            this.f15473p.m16142b();
        }
        return http2Stream;
    }

    /* JADX INFO: renamed from: a */
    public void m16057a(int i, boolean z, Buffer buffer, long j) throws IOException {
        int iMin;
        if (j == 0) {
            this.f15473p.m16141a(z, i, buffer, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (this.f15468k <= 0) {
                    try {
                        if (!this.f15461d.containsKey(Integer.valueOf(i))) {
                            throw new IOException("stream closed");
                        }
                        wait();
                    } catch (InterruptedException e) {
                        throw new InterruptedIOException();
                    }
                }
                iMin = Math.min((int) Math.min(j, this.f15468k), this.f15473p.m16144c());
                this.f15468k -= (long) iMin;
            }
            j -= (long) iMin;
            this.f15473p.m16141a(z && j == 0, i, buffer, iMin);
        }
    }

    /* JADX INFO: renamed from: a */
    void m16058a(long j) {
        this.f15468k += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* JADX INFO: renamed from: a */
    void m16055a(final int i, final ErrorCode errorCode) {
        f15457a.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.f15462e, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.1
            @Override // okhttp3.internal.NamedRunnable
            /* JADX INFO: renamed from: c */
            public void mo15763c() {
                try {
                    Http2Connection.this.m16065b(i, errorCode);
                } catch (IOException e) {
                }
            }
        });
    }

    /* JADX INFO: renamed from: b */
    void m16065b(int i, ErrorCode errorCode) throws IOException {
        this.f15473p.m16135a(i, errorCode);
    }

    /* JADX INFO: renamed from: a */
    void m16052a(final int i, final long j) {
        f15457a.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.f15462e, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.2
            @Override // okhttp3.internal.NamedRunnable
            /* JADX INFO: renamed from: c */
            public void mo15763c() {
                try {
                    Http2Connection.this.f15473p.m16134a(i, j);
                } catch (IOException e) {
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    void m16062a(final boolean z, final int i, final int i2, final Ping ping) {
        f15457a.execute(new NamedRunnable("OkHttp %s ping %08x%08x", new Object[]{this.f15462e, Integer.valueOf(i), Integer.valueOf(i2)}) { // from class: okhttp3.internal.http2.Http2Connection.3
            @Override // okhttp3.internal.NamedRunnable
            /* JADX INFO: renamed from: c */
            public void mo15763c() {
                try {
                    Http2Connection.this.m16066b(z, i, i2, ping);
                } catch (IOException e) {
                }
            }
        });
    }

    /* JADX INFO: renamed from: b */
    void m16066b(boolean z, int i, int i2, Ping ping) throws IOException {
        synchronized (this.f15473p) {
            if (ping != null) {
                ping.m16151a();
                this.f15473p.m16138a(z, i, i2);
            } else {
                this.f15473p.m16138a(z, i, i2);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    synchronized Ping m16067c(int i) {
        return this.f15477u != null ? this.f15477u.remove(Integer.valueOf(i)) : null;
    }

    /* JADX INFO: renamed from: b */
    public void m16064b() throws IOException {
        this.f15473p.m16142b();
    }

    /* JADX INFO: renamed from: a */
    public void m16059a(ErrorCode errorCode) throws IOException {
        synchronized (this.f15473p) {
            synchronized (this) {
                if (!this.f15465h) {
                    this.f15465h = true;
                    this.f15473p.m16136a(this.f15463f, errorCode, Util.f15237a);
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        m16060a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    /* JADX INFO: renamed from: a */
    void m16060a(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        IOException iOException;
        Http2Stream[] http2StreamArr;
        Ping[] pingArr;
        if (!f15458s && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        try {
            m16059a(errorCode);
            iOException = null;
        } catch (IOException e) {
            iOException = e;
        }
        synchronized (this) {
            if (this.f15461d.isEmpty()) {
                http2StreamArr = null;
            } else {
                Http2Stream[] http2StreamArr2 = (Http2Stream[]) this.f15461d.values().toArray(new Http2Stream[this.f15461d.size()]);
                this.f15461d.clear();
                http2StreamArr = http2StreamArr2;
            }
            if (this.f15477u != null) {
                Ping[] pingArr2 = (Ping[]) this.f15477u.values().toArray(new Ping[this.f15477u.size()]);
                this.f15477u = null;
                pingArr = pingArr2;
            } else {
                pingArr = null;
            }
        }
        if (http2StreamArr != null) {
            IOException iOException2 = iOException;
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.m16106a(errorCode2);
                } catch (IOException e2) {
                    if (iOException2 != null) {
                        iOException2 = e2;
                    }
                }
            }
            iOException = iOException2;
        }
        if (pingArr != null) {
            for (Ping ping : pingArr) {
                ping.m16153c();
            }
        }
        try {
            this.f15473p.close();
            e = iOException;
        } catch (IOException e3) {
            e = e3;
            if (iOException != null) {
                e = iOException;
            }
        }
        try {
            this.f15472o.close();
        } catch (IOException e4) {
            e = e4;
        }
        if (e != null) {
            throw e;
        }
    }

    /* JADX INFO: renamed from: c */
    public void m16068c() throws IOException {
        m16061a(true);
    }

    /* JADX INFO: renamed from: a */
    void m16061a(boolean z) throws IOException {
        if (z) {
            this.f15473p.m16130a();
            this.f15473p.m16143b(this.f15469l);
            if (this.f15469l.m16166d() != 65535) {
                this.f15473p.m16134a(0, r0 - 65535);
            }
        }
        new Thread(this.f15474q).start();
    }

    /* JADX INFO: renamed from: d */
    public synchronized boolean m16070d() {
        return this.f15465h;
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        Socket f15505a;

        /* JADX INFO: renamed from: b */
        String f15506b;

        /* JADX INFO: renamed from: c */
        BufferedSource f15507c;

        /* JADX INFO: renamed from: d */
        BufferedSink f15508d;

        /* JADX INFO: renamed from: e */
        Listener f15509e = Listener.f15512f;

        /* JADX INFO: renamed from: f */
        PushObserver f15510f = PushObserver.f15574a;

        /* JADX INFO: renamed from: g */
        boolean f15511g;

        public Builder(boolean z) {
            this.f15511g = z;
        }

        /* JADX INFO: renamed from: a */
        public Builder m16072a(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.f15505a = socket;
            this.f15506b = str;
            this.f15507c = bufferedSource;
            this.f15508d = bufferedSink;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m16073a(Listener listener) {
            this.f15509e = listener;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Http2Connection m16074a() throws IOException {
            return new Http2Connection(this);
        }
    }

    class ReaderRunnable extends NamedRunnable implements Http2Reader.Handler {

        /* JADX INFO: renamed from: a */
        final Http2Reader f15513a;

        ReaderRunnable(Http2Reader http2Reader) {
            super("OkHttp %s", Http2Connection.this.f15462e);
            this.f15513a = http2Reader;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [okhttp3.internal.http2.ErrorCode] */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9, types: [okhttp3.internal.http2.ErrorCode] */
        /* JADX WARN: Type inference failed for: r1v1, types: [okhttp3.internal.http2.ErrorCode] */
        /* JADX WARN: Type inference failed for: r1v2, types: [okhttp3.internal.http2.ErrorCode] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r2v0, types: [okhttp3.internal.http2.ErrorCode] */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v3, types: [okhttp3.internal.http2.Http2Connection] */
        /* JADX WARN: Type inference failed for: r2v4, types: [okhttp3.internal.http2.ErrorCode] */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r2v8 */
        /* JADX WARN: Type inference failed for: r2v9, types: [okhttp3.internal.http2.Http2Connection] */
        /* JADX WARN: Type inference failed for: r3v0, types: [okhttp3.internal.http2.Http2Connection] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // okhttp3.internal.NamedRunnable
        /* JADX INFO: renamed from: c */
        protected void mo15763c() throws Throwable {
            ?? r1;
            ?? r0 = ErrorCode.INTERNAL_ERROR;
            ?? r2 = ErrorCode.INTERNAL_ERROR;
            try {
                try {
                    this.f15513a.m16099a(this);
                    while (this.f15513a.m16100a(false, (Http2Reader.Handler) this)) {
                    }
                    r0 = ErrorCode.NO_ERROR;
                    ErrorCode errorCode = ErrorCode.CANCEL;
                    try {
                        r2 = Http2Connection.this;
                        r2.m16060a(r0, errorCode);
                    } catch (IOException e) {
                    }
                    Http2Reader http2Reader = this.f15513a;
                    Util.m15843a(http2Reader);
                    r0 = http2Reader;
                    r2 = r2;
                } catch (Throwable th) {
                    r1 = r0;
                    th = th;
                    try {
                        Http2Connection.this.m16060a(r1, r2);
                    } catch (IOException e2) {
                    }
                    Util.m15843a(this.f15513a);
                    throw th;
                }
            } catch (IOException e3) {
                r1 = ErrorCode.PROTOCOL_ERROR;
                try {
                    ErrorCode errorCode2 = ErrorCode.PROTOCOL_ERROR;
                    try {
                        r2 = Http2Connection.this;
                        r2.m16060a(r1, errorCode2);
                    } catch (IOException e4) {
                    }
                    Http2Reader http2Reader2 = this.f15513a;
                    Util.m15843a(http2Reader2);
                    r0 = http2Reader2;
                    r2 = r2;
                } catch (Throwable th2) {
                    th = th2;
                    Http2Connection.this.m16060a(r1, r2);
                    Util.m15843a(this.f15513a);
                    throw th;
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        /* JADX INFO: renamed from: a */
        public void mo16084a(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
            if (Http2Connection.this.m16071d(i)) {
                Http2Connection.this.m16056a(i, bufferedSource, i2, z);
                return;
            }
            Http2Stream http2StreamM16050a = Http2Connection.this.m16050a(i);
            if (http2StreamM16050a == null) {
                Http2Connection.this.m16055a(i, ErrorCode.PROTOCOL_ERROR);
                bufferedSource.mo16292i(i2);
            } else {
                http2StreamM16050a.m16107a(bufferedSource, i2);
                if (z) {
                    http2StreamM16050a.m16117i();
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        /* JADX INFO: renamed from: a */
        public void mo16083a(boolean z, int i, int i2, List<Header> list) {
            if (Http2Connection.this.m16071d(i)) {
                Http2Connection.this.m16054a(i, list, z);
                return;
            }
            synchronized (Http2Connection.this) {
                if (!Http2Connection.this.f15465h) {
                    Http2Stream http2StreamM16050a = Http2Connection.this.m16050a(i);
                    if (http2StreamM16050a == null) {
                        if (i > Http2Connection.this.f15463f) {
                            if (i % 2 != Http2Connection.this.f15464g % 2) {
                                final Http2Stream http2Stream = new Http2Stream(i, Http2Connection.this, false, z, list);
                                Http2Connection.this.f15463f = i;
                                Http2Connection.this.f15461d.put(Integer.valueOf(i), http2Stream);
                                Http2Connection.f15457a.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{Http2Connection.this.f15462e, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.ReaderRunnable.1
                                    @Override // okhttp3.internal.NamedRunnable
                                    /* JADX INFO: renamed from: c */
                                    public void mo15763c() {
                                        try {
                                            Http2Connection.this.f15460c.mo15915a(http2Stream);
                                        } catch (IOException e) {
                                            Platform.m16203b().mo16181a(4, "Http2Connection.Listener failure for " + Http2Connection.this.f15462e, e);
                                            try {
                                                http2Stream.m16106a(ErrorCode.PROTOCOL_ERROR);
                                            } catch (IOException e2) {
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    } else {
                        http2StreamM16050a.m16105a(list);
                        if (z) {
                            http2StreamM16050a.m16117i();
                        }
                    }
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        /* JADX INFO: renamed from: a */
        public void mo16080a(int i, ErrorCode errorCode) {
            if (Http2Connection.this.m16071d(i)) {
                Http2Connection.this.m16069c(i, errorCode);
                return;
            }
            Http2Stream http2StreamM16063b = Http2Connection.this.m16063b(i);
            if (http2StreamM16063b != null) {
                http2StreamM16063b.m16110c(errorCode);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        /* JADX INFO: renamed from: a */
        public void mo16085a(boolean z, Settings settings) {
            Http2Stream[] http2StreamArr;
            long j;
            synchronized (Http2Connection.this) {
                int iM16166d = Http2Connection.this.f15470m.m16166d();
                if (z) {
                    Http2Connection.this.f15470m.m16159a();
                }
                Http2Connection.this.f15470m.m16160a(settings);
                m16075a(settings);
                int iM16166d2 = Http2Connection.this.f15470m.m16166d();
                if (iM16166d2 == -1 || iM16166d2 == iM16166d) {
                    http2StreamArr = null;
                    j = 0;
                } else {
                    long j2 = iM16166d2 - iM16166d;
                    if (!Http2Connection.this.f15471n) {
                        Http2Connection.this.m16058a(j2);
                        Http2Connection.this.f15471n = true;
                    }
                    if (Http2Connection.this.f15461d.isEmpty()) {
                        j = j2;
                        http2StreamArr = null;
                    } else {
                        j = j2;
                        http2StreamArr = (Http2Stream[]) Http2Connection.this.f15461d.values().toArray(new Http2Stream[Http2Connection.this.f15461d.size()]);
                    }
                }
                Http2Connection.f15457a.execute(new NamedRunnable("OkHttp %s settings", Http2Connection.this.f15462e) { // from class: okhttp3.internal.http2.Http2Connection.ReaderRunnable.2
                    @Override // okhttp3.internal.NamedRunnable
                    /* JADX INFO: renamed from: c */
                    public void mo15763c() {
                        Http2Connection.this.f15460c.mo15914a(Http2Connection.this);
                    }
                });
            }
            if (http2StreamArr != null && j != 0) {
                for (Http2Stream http2Stream : http2StreamArr) {
                    synchronized (http2Stream) {
                        http2Stream.m16104a(j);
                    }
                }
            }
        }

        /* JADX INFO: renamed from: a */
        private void m16075a(final Settings settings) {
            Http2Connection.f15457a.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{Http2Connection.this.f15462e}) { // from class: okhttp3.internal.http2.Http2Connection.ReaderRunnable.3
                @Override // okhttp3.internal.NamedRunnable
                /* JADX INFO: renamed from: c */
                public void mo15763c() {
                    try {
                        Http2Connection.this.f15473p.m16137a(settings);
                    } catch (IOException e) {
                    }
                }
            });
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        /* JADX INFO: renamed from: a */
        public void mo16076a() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        /* JADX INFO: renamed from: a */
        public void mo16082a(boolean z, int i, int i2) {
            if (z) {
                Ping pingM16067c = Http2Connection.this.m16067c(i);
                if (pingM16067c != null) {
                    pingM16067c.m16152b();
                    return;
                }
                return;
            }
            Http2Connection.this.m16062a(true, i, i2, (Ping) null);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        /* JADX INFO: renamed from: a */
        public void mo16081a(int i, ErrorCode errorCode, ByteString byteString) {
            Http2Stream[] http2StreamArr;
            if (byteString.mo16336h() > 0) {
            }
            synchronized (Http2Connection.this) {
                http2StreamArr = (Http2Stream[]) Http2Connection.this.f15461d.values().toArray(new Http2Stream[Http2Connection.this.f15461d.size()]);
                Http2Connection.this.f15465h = true;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.m16103a() > i && http2Stream.m16111c()) {
                    http2Stream.m16110c(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.m16063b(http2Stream.m16103a());
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        /* JADX INFO: renamed from: a */
        public void mo16079a(int i, long j) {
            if (i == 0) {
                synchronized (Http2Connection.this) {
                    Http2Connection.this.f15468k += j;
                    Http2Connection.this.notifyAll();
                }
                return;
            }
            Http2Stream http2StreamM16050a = Http2Connection.this.m16050a(i);
            if (http2StreamM16050a != null) {
                synchronized (http2StreamM16050a) {
                    http2StreamM16050a.m16104a(j);
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        /* JADX INFO: renamed from: a */
        public void mo16077a(int i, int i2, int i3, boolean z) {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        /* JADX INFO: renamed from: a */
        public void mo16078a(int i, int i2, List<Header> list) {
            Http2Connection.this.m16053a(i2, list);
        }
    }

    /* JADX INFO: renamed from: d */
    boolean m16071d(int i) {
        return i != 0 && (i & 1) == 0;
    }

    /* JADX INFO: renamed from: a */
    void m16053a(final int i, final List<Header> list) {
        synchronized (this) {
            if (this.f15475r.contains(Integer.valueOf(i))) {
                m16055a(i, ErrorCode.PROTOCOL_ERROR);
            } else {
                this.f15475r.add(Integer.valueOf(i));
                this.f15476t.execute(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.f15462e, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.4
                    @Override // okhttp3.internal.NamedRunnable
                    /* JADX INFO: renamed from: c */
                    public void mo15763c() {
                        if (Http2Connection.this.f15466i.mo16155a(i, list)) {
                            try {
                                Http2Connection.this.f15473p.m16135a(i, ErrorCode.CANCEL);
                                synchronized (Http2Connection.this) {
                                    Http2Connection.this.f15475r.remove(Integer.valueOf(i));
                                }
                            } catch (IOException e) {
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m16054a(final int i, final List<Header> list, final boolean z) {
        this.f15476t.execute(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.f15462e, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.5
            @Override // okhttp3.internal.NamedRunnable
            /* JADX INFO: renamed from: c */
            public void mo15763c() {
                boolean zMo16156a = Http2Connection.this.f15466i.mo16156a(i, list, z);
                if (zMo16156a) {
                    try {
                        Http2Connection.this.f15473p.m16135a(i, ErrorCode.CANCEL);
                    } catch (IOException e) {
                        return;
                    }
                }
                if (zMo16156a || z) {
                    synchronized (Http2Connection.this) {
                        Http2Connection.this.f15475r.remove(Integer.valueOf(i));
                    }
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    void m16056a(final int i, BufferedSource bufferedSource, final int i2, final boolean z) throws IOException {
        final Buffer buffer = new Buffer();
        bufferedSource.mo16259a(i2);
        bufferedSource.mo15863a(buffer, i2);
        if (buffer.m16263b() != i2) {
            throw new IOException(buffer.m16263b() + " != " + i2);
        }
        this.f15476t.execute(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.f15462e, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.6
            @Override // okhttp3.internal.NamedRunnable
            /* JADX INFO: renamed from: c */
            public void mo15763c() {
                try {
                    boolean zMo16157a = Http2Connection.this.f15466i.mo16157a(i, buffer, i2, z);
                    if (zMo16157a) {
                        Http2Connection.this.f15473p.m16135a(i, ErrorCode.CANCEL);
                    }
                    if (zMo16157a || z) {
                        synchronized (Http2Connection.this) {
                            Http2Connection.this.f15475r.remove(Integer.valueOf(i));
                        }
                    }
                } catch (IOException e) {
                }
            }
        });
    }

    /* JADX INFO: renamed from: c */
    void m16069c(final int i, final ErrorCode errorCode) {
        this.f15476t.execute(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.f15462e, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.7
            @Override // okhttp3.internal.NamedRunnable
            /* JADX INFO: renamed from: c */
            public void mo15763c() {
                Http2Connection.this.f15466i.mo16154a(i, errorCode);
                synchronized (Http2Connection.this) {
                    Http2Connection.this.f15475r.remove(Integer.valueOf(i));
                }
            }
        });
    }

    public static abstract class Listener {

        /* JADX INFO: renamed from: f */
        public static final Listener f15512f = new Listener() { // from class: okhttp3.internal.http2.Http2Connection.Listener.1
            @Override // okhttp3.internal.http2.Http2Connection.Listener
            /* JADX INFO: renamed from: a */
            public void mo15915a(Http2Stream http2Stream) throws IOException {
                http2Stream.m16106a(ErrorCode.REFUSED_STREAM);
            }
        };

        /* JADX INFO: renamed from: a */
        public abstract void mo15915a(Http2Stream http2Stream) throws IOException;

        /* JADX INFO: renamed from: a */
        public void mo15914a(Http2Connection http2Connection) {
        }
    }
}
