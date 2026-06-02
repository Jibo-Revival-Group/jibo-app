package okhttp3;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.platform.Platform;

/* JADX INFO: loaded from: classes2.dex */
public final class ConnectionPool {

    /* JADX INFO: renamed from: c */
    static final /* synthetic */ boolean f15020c;

    /* JADX INFO: renamed from: d */
    private static final Executor f15021d;

    /* JADX INFO: renamed from: a */
    final RouteDatabase f15022a;

    /* JADX INFO: renamed from: b */
    boolean f15023b;

    /* JADX INFO: renamed from: e */
    private final int f15024e;

    /* JADX INFO: renamed from: f */
    private final long f15025f;

    /* JADX INFO: renamed from: g */
    private final Runnable f15026g;

    /* JADX INFO: renamed from: h */
    private final Deque<RealConnection> f15027h;

    static {
        f15020c = !ConnectionPool.class.desiredAssertionStatus();
        f15021d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.m15841a("OkHttp ConnectionPool", true));
    }

    public ConnectionPool() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public ConnectionPool(int i, long j, TimeUnit timeUnit) {
        this.f15026g = new Runnable() { // from class: okhttp3.ConnectionPool.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    long jM15557a = ConnectionPool.this.m15557a(System.nanoTime());
                    if (jM15557a == -1) {
                        return;
                    }
                    if (jM15557a > 0) {
                        long j2 = jM15557a / 1000000;
                        long j3 = jM15557a - (j2 * 1000000);
                        synchronized (ConnectionPool.this) {
                            try {
                                ConnectionPool.this.wait(j2, (int) j3);
                            } catch (InterruptedException e) {
                            }
                        }
                    }
                }
            }
        };
        this.f15027h = new ArrayDeque();
        this.f15022a = new RouteDatabase();
        this.f15024e = i;
        this.f15025f = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
        }
    }

    /* JADX INFO: renamed from: a */
    RealConnection m15559a(Address address, StreamAllocation streamAllocation, Route route) {
        if (!f15020c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (RealConnection realConnection : this.f15027h) {
            if (realConnection.m15916a(address, route)) {
                streamAllocation.m15949a(realConnection);
                return realConnection;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    Socket m15558a(Address address, StreamAllocation streamAllocation) {
        if (!f15020c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (RealConnection realConnection : this.f15027h) {
            if (realConnection.m15916a(address, (Route) null) && realConnection.m15922f() && realConnection != streamAllocation.m15952b()) {
                return streamAllocation.m15951b(realConnection);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    void m15560a(RealConnection realConnection) {
        if (!f15020c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.f15023b) {
            this.f15023b = true;
            f15021d.execute(this.f15026g);
        }
        this.f15027h.add(realConnection);
    }

    /* JADX INFO: renamed from: b */
    boolean m15561b(RealConnection realConnection) {
        if (!f15020c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (realConnection.f15325a || this.f15024e == 0) {
            this.f15027h.remove(realConnection);
            return true;
        }
        notifyAll();
        return false;
    }

    /* JADX INFO: renamed from: a */
    long m15557a(long j) {
        RealConnection realConnection;
        long j2;
        RealConnection realConnection2 = null;
        long j3 = Long.MIN_VALUE;
        synchronized (this) {
            int i = 0;
            int i2 = 0;
            for (RealConnection realConnection3 : this.f15027h) {
                if (m15556a(realConnection3, j) > 0) {
                    i2++;
                } else {
                    int i3 = i + 1;
                    long j4 = j - realConnection3.f15329e;
                    if (j4 > j3) {
                        realConnection = realConnection3;
                        j2 = j4;
                    } else {
                        realConnection = realConnection2;
                        j2 = j3;
                    }
                    j3 = j2;
                    realConnection2 = realConnection;
                    i = i3;
                }
            }
            if (j3 >= this.f15025f || i > this.f15024e) {
                this.f15027h.remove(realConnection2);
                Util.m15844a(realConnection2.m15920d());
                return 0L;
            }
            if (i > 0) {
                return this.f15025f - j3;
            }
            if (i2 > 0) {
                return this.f15025f;
            }
            this.f15023b = false;
            return -1L;
        }
    }

    /* JADX INFO: renamed from: a */
    private int m15556a(RealConnection realConnection, long j) {
        List<Reference<StreamAllocation>> list = realConnection.f15328d;
        int i = 0;
        while (i < list.size()) {
            Reference<StreamAllocation> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                Platform.m16203b().mo16182a("A connection to " + realConnection.mo15554a().m15827a().m15482a() + " was leaked. Did you forget to close a response body?", ((StreamAllocation.StreamAllocationReference) reference).f15362a);
                list.remove(i);
                realConnection.f15325a = true;
                if (list.isEmpty()) {
                    realConnection.f15329e = j - this.f15025f;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
