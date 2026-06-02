package okhttp3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.RealCall;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes2.dex */
public final class Dispatcher {

    /* JADX INFO: renamed from: c */
    private Runnable f15057c;

    /* JADX INFO: renamed from: d */
    private ExecutorService f15058d;

    /* JADX INFO: renamed from: a */
    private int f15055a = 64;

    /* JADX INFO: renamed from: b */
    private int f15056b = 5;

    /* JADX INFO: renamed from: e */
    private final Deque<RealCall.AsyncCall> f15059e = new ArrayDeque();

    /* JADX INFO: renamed from: f */
    private final Deque<RealCall.AsyncCall> f15060f = new ArrayDeque();

    /* JADX INFO: renamed from: g */
    private final Deque<RealCall> f15061g = new ArrayDeque();

    public Dispatcher(ExecutorService executorService) {
        this.f15058d = executorService;
    }

    public Dispatcher() {
    }

    /* JADX INFO: renamed from: a */
    public synchronized ExecutorService m15593a() {
        if (this.f15058d == null) {
            this.f15058d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.m15841a("OkHttp Dispatcher", false));
        }
        return this.f15058d;
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m15594a(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("max < 1: " + i);
        }
        this.f15055a = i;
        m15592d();
    }

    /* JADX INFO: renamed from: b */
    public synchronized void m15598b(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("max < 1: " + i);
        }
        this.f15056b = i;
        m15592d();
    }

    /* JADX INFO: renamed from: a */
    synchronized void m15595a(RealCall.AsyncCall asyncCall) {
        if (this.f15060f.size() < this.f15055a && m15591c(asyncCall) < this.f15056b) {
            this.f15060f.add(asyncCall);
            m15593a().execute(asyncCall);
        } else {
            this.f15059e.add(asyncCall);
        }
    }

    /* JADX INFO: renamed from: b */
    public synchronized void m15597b() {
        Iterator<RealCall.AsyncCall> it = this.f15059e.iterator();
        while (it.hasNext()) {
            it.next().m15762b().mo15538c();
        }
        Iterator<RealCall.AsyncCall> it2 = this.f15060f.iterator();
        while (it2.hasNext()) {
            it2.next().m15762b().mo15538c();
        }
        Iterator<RealCall> it3 = this.f15061g.iterator();
        while (it3.hasNext()) {
            it3.next().mo15538c();
        }
    }

    /* JADX INFO: renamed from: d */
    private void m15592d() {
        if (this.f15060f.size() < this.f15055a && !this.f15059e.isEmpty()) {
            Iterator<RealCall.AsyncCall> it = this.f15059e.iterator();
            while (it.hasNext()) {
                RealCall.AsyncCall next = it.next();
                if (m15591c(next) < this.f15056b) {
                    it.remove();
                    this.f15060f.add(next);
                    m15593a().execute(next);
                }
                if (this.f15060f.size() >= this.f15055a) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private int m15591c(RealCall.AsyncCall asyncCall) {
        int i = 0;
        Iterator<RealCall.AsyncCall> it = this.f15060f.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().m15761a().equals(asyncCall.m15761a()) ? i2 + 1 : i2;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    synchronized void m15596a(RealCall realCall) {
        this.f15061g.add(realCall);
    }

    /* JADX INFO: renamed from: b */
    void m15599b(RealCall.AsyncCall asyncCall) {
        m15590a(this.f15060f, asyncCall, true);
    }

    /* JADX INFO: renamed from: b */
    void m15600b(RealCall realCall) {
        m15590a(this.f15061g, realCall, false);
    }

    /* JADX INFO: renamed from: a */
    private <T> void m15590a(Deque<T> deque, T t, boolean z) {
        int iM15601c;
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            if (z) {
                m15592d();
            }
            iM15601c = m15601c();
            runnable = this.f15057c;
        }
        if (iM15601c == 0 && runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: renamed from: c */
    public synchronized int m15601c() {
        return this.f15060f.size() + this.f15061g.size();
    }
}
