package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

/* JADX INFO: loaded from: classes2.dex */
public final class StreamAllocation {

    /* JADX INFO: renamed from: b */
    static final /* synthetic */ boolean f15351b;

    /* JADX INFO: renamed from: a */
    public final Address f15352a;

    /* JADX INFO: renamed from: c */
    private Route f15353c;

    /* JADX INFO: renamed from: d */
    private final ConnectionPool f15354d;

    /* JADX INFO: renamed from: e */
    private final Object f15355e;

    /* JADX INFO: renamed from: f */
    private final RouteSelector f15356f;

    /* JADX INFO: renamed from: g */
    private int f15357g;

    /* JADX INFO: renamed from: h */
    private RealConnection f15358h;

    /* JADX INFO: renamed from: i */
    private boolean f15359i;

    /* JADX INFO: renamed from: j */
    private boolean f15360j;

    /* JADX INFO: renamed from: k */
    private HttpCodec f15361k;

    static {
        f15351b = !StreamAllocation.class.desiredAssertionStatus();
    }

    public StreamAllocation(ConnectionPool connectionPool, Address address, Object obj) {
        this.f15354d = connectionPool;
        this.f15352a = address;
        this.f15356f = new RouteSelector(address, m15945g());
        this.f15355e = obj;
    }

    /* JADX INFO: renamed from: a */
    public HttpCodec m15947a(OkHttpClient okHttpClient, boolean z) {
        try {
            HttpCodec httpCodecM15912a = m15943a(okHttpClient.m15707a(), okHttpClient.m15708b(), okHttpClient.m15709c(), okHttpClient.m15724r(), z).m15912a(okHttpClient, this);
            synchronized (this.f15354d) {
                this.f15361k = httpCodecM15912a;
            }
            return httpCodecM15912a;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    /* JADX INFO: renamed from: a */
    private RealConnection m15943a(int i, int i2, int i3, boolean z, boolean z2) throws Throwable {
        RealConnection realConnectionM15942a;
        while (true) {
            realConnectionM15942a = m15942a(i, i2, i3, z);
            synchronized (this.f15354d) {
                if (realConnectionM15942a.f15326b != 0) {
                    if (realConnectionM15942a.m15918a(z2)) {
                        break;
                    }
                    m15954d();
                } else {
                    break;
                }
            }
        }
        return realConnectionM15942a;
    }

    /* JADX INFO: renamed from: a */
    private RealConnection m15942a(int i, int i2, int i3, boolean z) throws Throwable {
        Socket socket = null;
        synchronized (this.f15354d) {
            if (this.f15359i) {
                throw new IllegalStateException("released");
            }
            if (this.f15361k != null) {
                throw new IllegalStateException("codec != null");
            }
            if (this.f15360j) {
                throw new IOException("Canceled");
            }
            RealConnection realConnection = this.f15358h;
            if (realConnection == null || realConnection.f15325a) {
                Internal.f15235a.mo15734a(this.f15354d, this.f15352a, this, null);
                if (this.f15358h != null) {
                    realConnection = this.f15358h;
                } else {
                    Route routeM15940b = this.f15353c;
                    if (routeM15940b == null) {
                        routeM15940b = this.f15356f.m15940b();
                    }
                    synchronized (this.f15354d) {
                        if (this.f15360j) {
                            throw new IOException("Canceled");
                        }
                        Internal.f15235a.mo15734a(this.f15354d, this.f15352a, this, routeM15940b);
                        if (this.f15358h != null) {
                            realConnection = this.f15358h;
                        } else {
                            this.f15353c = routeM15940b;
                            this.f15357g = 0;
                            RealConnection realConnection2 = new RealConnection(this.f15354d, routeM15940b);
                            m15949a(realConnection2);
                            realConnection2.m15913a(i, i2, i3, z);
                            m15945g().m15924b(realConnection2.mo15554a());
                            synchronized (this.f15354d) {
                                Internal.f15235a.mo15741b(this.f15354d, realConnection2);
                                if (realConnection2.m15922f()) {
                                    Socket socketMo15733a = Internal.f15235a.mo15733a(this.f15354d, this.f15352a, this);
                                    realConnection = this.f15358h;
                                    socket = socketMo15733a;
                                } else {
                                    realConnection = realConnection2;
                                }
                            }
                            Util.m15844a(socket);
                        }
                    }
                }
            }
            return realConnection;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m15950a(boolean z, HttpCodec httpCodec) {
        Socket socketM15941a;
        synchronized (this.f15354d) {
            if (httpCodec != null) {
                if (httpCodec == this.f15361k) {
                    if (!z) {
                        this.f15358h.f15326b++;
                    }
                    socketM15941a = m15941a(z, false, true);
                }
            }
            throw new IllegalStateException("expected " + this.f15361k + " but was " + httpCodec);
        }
        Util.m15844a(socketM15941a);
    }

    /* JADX INFO: renamed from: a */
    public HttpCodec m15946a() {
        HttpCodec httpCodec;
        synchronized (this.f15354d) {
            httpCodec = this.f15361k;
        }
        return httpCodec;
    }

    /* JADX INFO: renamed from: g */
    private RouteDatabase m15945g() {
        return Internal.f15235a.mo15735a(this.f15354d);
    }

    /* JADX INFO: renamed from: b */
    public synchronized RealConnection m15952b() {
        return this.f15358h;
    }

    /* JADX INFO: renamed from: c */
    public void m15953c() {
        Socket socketM15941a;
        synchronized (this.f15354d) {
            socketM15941a = m15941a(false, true, false);
        }
        Util.m15844a(socketM15941a);
    }

    /* JADX INFO: renamed from: d */
    public void m15954d() {
        Socket socketM15941a;
        synchronized (this.f15354d) {
            socketM15941a = m15941a(true, false, false);
        }
        Util.m15844a(socketM15941a);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0061  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.net.Socket m15941a(boolean r5, boolean r6, boolean r7) {
        /*
            r4 = this;
            r2 = 1
            r1 = 0
            boolean r0 = okhttp3.internal.connection.StreamAllocation.f15351b
            if (r0 != 0) goto L14
            okhttp3.ConnectionPool r0 = r4.f15354d
            boolean r0 = java.lang.Thread.holdsLock(r0)
            if (r0 != 0) goto L14
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L14:
            if (r7 == 0) goto L18
            r4.f15361k = r1
        L18:
            if (r6 == 0) goto L1c
            r4.f15359i = r2
        L1c:
            okhttp3.internal.connection.RealConnection r0 = r4.f15358h
            if (r0 == 0) goto L60
            if (r5 == 0) goto L26
            okhttp3.internal.connection.RealConnection r0 = r4.f15358h
            r0.f15325a = r2
        L26:
            okhttp3.internal.http.HttpCodec r0 = r4.f15361k
            if (r0 != 0) goto L60
            boolean r0 = r4.f15359i
            if (r0 != 0) goto L34
            okhttp3.internal.connection.RealConnection r0 = r4.f15358h
            boolean r0 = r0.f15325a
            if (r0 == 0) goto L60
        L34:
            okhttp3.internal.connection.RealConnection r0 = r4.f15358h
            r4.m15944c(r0)
            okhttp3.internal.connection.RealConnection r0 = r4.f15358h
            java.util.List<java.lang.ref.Reference<okhttp3.internal.connection.StreamAllocation>> r0 = r0.f15328d
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L61
            okhttp3.internal.connection.RealConnection r0 = r4.f15358h
            long r2 = java.lang.System.nanoTime()
            r0.f15329e = r2
            okhttp3.internal.Internal r0 = okhttp3.internal.Internal.f15235a
            okhttp3.ConnectionPool r2 = r4.f15354d
            okhttp3.internal.connection.RealConnection r3 = r4.f15358h
            boolean r0 = r0.mo15740a(r2, r3)
            if (r0 == 0) goto L61
            okhttp3.internal.connection.RealConnection r0 = r4.f15358h
            java.net.Socket r0 = r0.m15920d()
        L5d:
            r4.f15358h = r1
            r1 = r0
        L60:
            return r1
        L61:
            r0 = r1
            goto L5d
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.StreamAllocation.m15941a(boolean, boolean, boolean):java.net.Socket");
    }

    /* JADX INFO: renamed from: e */
    public void m15955e() {
        HttpCodec httpCodec;
        RealConnection realConnection;
        synchronized (this.f15354d) {
            this.f15360j = true;
            httpCodec = this.f15361k;
            realConnection = this.f15358h;
        }
        if (httpCodec != null) {
            httpCodec.mo15964c();
        } else if (realConnection != null) {
            realConnection.m15919c();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m15948a(IOException iOException) {
        Socket socketM15941a;
        boolean z = false;
        synchronized (this.f15354d) {
            if (iOException instanceof StreamResetException) {
                StreamResetException streamResetException = (StreamResetException) iOException;
                if (streamResetException.f15577a == ErrorCode.REFUSED_STREAM) {
                    this.f15357g++;
                }
                if (streamResetException.f15577a != ErrorCode.REFUSED_STREAM || this.f15357g > 1) {
                    this.f15353c = null;
                    z = true;
                }
                socketM15941a = m15941a(z, false, true);
            } else {
                if (this.f15358h != null && (!this.f15358h.m15922f() || (iOException instanceof ConnectionShutdownException))) {
                    if (this.f15358h.f15326b == 0) {
                        if (this.f15353c != null && iOException != null) {
                            this.f15356f.m15938a(this.f15353c, iOException);
                        }
                        this.f15353c = null;
                    }
                    z = true;
                }
                socketM15941a = m15941a(z, false, true);
            }
        }
        Util.m15844a(socketM15941a);
    }

    /* JADX INFO: renamed from: a */
    public void m15949a(RealConnection realConnection) {
        if (!f15351b && !Thread.holdsLock(this.f15354d)) {
            throw new AssertionError();
        }
        if (this.f15358h != null) {
            throw new IllegalStateException();
        }
        this.f15358h = realConnection;
        realConnection.f15328d.add(new StreamAllocationReference(this, this.f15355e));
    }

    /* JADX INFO: renamed from: c */
    private void m15944c(RealConnection realConnection) {
        int size = realConnection.f15328d.size();
        for (int i = 0; i < size; i++) {
            if (realConnection.f15328d.get(i).get() == this) {
                realConnection.f15328d.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: renamed from: b */
    public Socket m15951b(RealConnection realConnection) {
        if (!f15351b && !Thread.holdsLock(this.f15354d)) {
            throw new AssertionError();
        }
        if (this.f15361k != null || this.f15358h.f15328d.size() != 1) {
            throw new IllegalStateException();
        }
        Reference<StreamAllocation> reference = this.f15358h.f15328d.get(0);
        Socket socketM15941a = m15941a(true, false, false);
        this.f15358h = realConnection;
        realConnection.f15328d.add(reference);
        return socketM15941a;
    }

    /* JADX INFO: renamed from: f */
    public boolean m15956f() {
        return this.f15353c != null || this.f15356f.m15939a();
    }

    public String toString() {
        RealConnection realConnectionM15952b = m15952b();
        return realConnectionM15952b != null ? realConnectionM15952b.toString() : this.f15352a.toString();
    }

    public static final class StreamAllocationReference extends WeakReference<StreamAllocation> {

        /* JADX INFO: renamed from: a */
        public final Object f15362a;

        StreamAllocationReference(StreamAllocation streamAllocation, Object obj) {
            super(streamAllocation);
            this.f15362a = obj;
        }
    }
}
