package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import java.lang.Thread;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class zzcih extends zzcjl {

    /* JADX INFO: renamed from: k */
    private static final AtomicLong f7313k = new AtomicLong(Long.MIN_VALUE);

    /* JADX INFO: renamed from: a */
    private ExecutorService f7314a;

    /* JADX INFO: renamed from: b */
    private zzcil f7315b;

    /* JADX INFO: renamed from: c */
    private zzcil f7316c;

    /* JADX INFO: renamed from: d */
    private final PriorityBlockingQueue<zzcik<?>> f7317d;

    /* JADX INFO: renamed from: e */
    private final BlockingQueue<zzcik<?>> f7318e;

    /* JADX INFO: renamed from: f */
    private final Thread.UncaughtExceptionHandler f7319f;

    /* JADX INFO: renamed from: g */
    private final Thread.UncaughtExceptionHandler f7320g;

    /* JADX INFO: renamed from: h */
    private final Object f7321h;

    /* JADX INFO: renamed from: i */
    private final Semaphore f7322i;

    /* JADX INFO: renamed from: j */
    private volatile boolean f7323j;

    zzcih(zzcim zzcimVar) {
        super(zzcimVar);
        this.f7321h = new Object();
        this.f7322i = new Semaphore(2);
        this.f7317d = new PriorityBlockingQueue<>();
        this.f7318e = new LinkedBlockingQueue();
        this.f7319f = new zzcij(this, "Thread death: Uncaught exception on worker thread");
        this.f7320g = new zzcij(this, "Thread death: Uncaught exception on network thread");
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ zzcil m8162a(zzcih zzcihVar, zzcil zzcilVar) {
        zzcihVar.f7315b = null;
        return null;
    }

    /* JADX INFO: renamed from: a */
    private final void m8164a(zzcik<?> zzcikVar) {
        synchronized (this.f7321h) {
            this.f7317d.add(zzcikVar);
            if (this.f7315b == null) {
                this.f7315b = new zzcil(this, "Measurement Worker", this.f7317d);
                this.f7315b.setUncaughtExceptionHandler(this.f7319f);
                this.f7315b.start();
            } else {
                this.f7315b.m8178a();
            }
        }
    }

    /* JADX INFO: renamed from: b */
    static /* synthetic */ zzcil m8165b(zzcih zzcihVar, zzcil zzcilVar) {
        zzcihVar.f7316c = null;
        return null;
    }

    /* JADX INFO: renamed from: y */
    public static boolean m8170y() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* JADX INFO: renamed from: A */
    final ExecutorService m8171A() {
        ExecutorService executorService;
        synchronized (this.f7321h) {
            if (this.f7314a == null) {
                this.f7314a = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
            }
            executorService = this.f7314a;
        }
        return executorService;
    }

    /* JADX INFO: renamed from: a */
    public final <V> Future<V> m8172a(Callable<V> callable) throws IllegalStateException {
        m8259Q();
        zzbq.m7373a(callable);
        zzcik<?> zzcikVar = new zzcik<>(this, (Callable<?>) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f7315b) {
            if (!this.f7317d.isEmpty()) {
                mo7872t().m8097A().m8108a("Callable skipped the worker queue.");
            }
            zzcikVar.run();
        } else {
            m8164a(zzcikVar);
        }
        return zzcikVar;
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ void mo7850a() {
        super.mo7850a();
    }

    /* JADX INFO: renamed from: a */
    public final void m8173a(Runnable runnable) throws IllegalStateException {
        m8259Q();
        zzbq.m7373a(runnable);
        m8164a(new zzcik<>(this, runnable, false, "Task exception on worker thread"));
    }

    /* JADX INFO: renamed from: b */
    public final <V> Future<V> m8174b(Callable<V> callable) throws IllegalStateException {
        m8259Q();
        zzbq.m7373a(callable);
        zzcik<?> zzcikVar = new zzcik<>(this, (Callable<?>) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f7315b) {
            zzcikVar.run();
        } else {
            m8164a(zzcikVar);
        }
        return zzcikVar;
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: b */
    public final void mo7853b() {
        if (Thread.currentThread() != this.f7316c) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m8175b(Runnable runnable) throws IllegalStateException {
        m8259Q();
        zzbq.m7373a(runnable);
        zzcik<?> zzcikVar = new zzcik<>(this, runnable, false, "Task exception on network thread");
        synchronized (this.f7321h) {
            this.f7318e.add(zzcikVar);
            if (this.f7316c == null) {
                this.f7316c = new zzcil(this, "Measurement Network", this.f7318e);
                this.f7316c.setUncaughtExceptionHandler(this.f7320g);
                this.f7316c.start();
            } else {
                this.f7316c.m8178a();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: c */
    public final void mo7855c() {
        if (Thread.currentThread() != this.f7315b) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: d */
    public final /* bridge */ /* synthetic */ zzcgd mo7856d() {
        return super.mo7856d();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: e */
    public final /* bridge */ /* synthetic */ zzcgk mo7857e() {
        return super.mo7857e();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: f */
    public final /* bridge */ /* synthetic */ zzcjn mo7858f() {
        return super.mo7858f();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: g */
    public final /* bridge */ /* synthetic */ zzchh mo7859g() {
        return super.mo7859g();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: h */
    public final /* bridge */ /* synthetic */ zzcgu mo7860h() {
        return super.mo7860h();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: i */
    public final /* bridge */ /* synthetic */ zzckg mo7861i() {
        return super.mo7861i();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: j */
    public final /* bridge */ /* synthetic */ zzckc mo7862j() {
        return super.mo7862j();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: k */
    public final /* bridge */ /* synthetic */ zzd mo7863k() {
        return super.mo7863k();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: l */
    public final /* bridge */ /* synthetic */ Context mo7864l() {
        return super.mo7864l();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: m */
    public final /* bridge */ /* synthetic */ zzchi mo7865m() {
        return super.mo7865m();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: n */
    public final /* bridge */ /* synthetic */ zzcgo mo7866n() {
        return super.mo7866n();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: o */
    public final /* bridge */ /* synthetic */ zzchk mo7867o() {
        return super.mo7867o();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: p */
    public final /* bridge */ /* synthetic */ zzclq mo7868p() {
        return super.mo7868p();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: q */
    public final /* bridge */ /* synthetic */ zzcig mo7869q() {
        return super.mo7869q();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: r */
    public final /* bridge */ /* synthetic */ zzclf mo7870r() {
        return super.mo7870r();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: s */
    public final /* bridge */ /* synthetic */ zzcih mo7871s() {
        return super.mo7871s();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: t */
    public final /* bridge */ /* synthetic */ zzchm mo7872t() {
        return super.mo7872t();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: u */
    public final /* bridge */ /* synthetic */ zzchx mo7873u() {
        return super.mo7873u();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: v */
    public final /* bridge */ /* synthetic */ zzcgn mo7874v() {
        return super.mo7874v();
    }

    @Override // com.google.android.gms.internal.zzcjl
    /* JADX INFO: renamed from: w */
    protected final boolean mo7936w() {
        return false;
    }

    /* JADX INFO: renamed from: z */
    public final boolean m8176z() {
        return Thread.currentThread() == this.f7315b;
    }
}
