package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
final class zzcik<V> extends FutureTask<V> implements Comparable<zzcik> {

    /* JADX INFO: renamed from: a */
    final boolean f7326a;

    /* JADX INFO: renamed from: b */
    private final long f7327b;

    /* JADX INFO: renamed from: c */
    private final String f7328c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ zzcih f7329d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzcik(zzcih zzcihVar, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        this.f7329d = zzcihVar;
        zzbq.m7373a(str);
        this.f7327b = zzcih.f7313k.getAndIncrement();
        this.f7328c = str;
        this.f7326a = false;
        if (this.f7327b == Long.MAX_VALUE) {
            zzcihVar.mo7872t().m8106y().m8108a("Tasks index overflow");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzcik(zzcih zzcihVar, Callable<V> callable, boolean z, String str) {
        super(callable);
        this.f7329d = zzcihVar;
        zzbq.m7373a(str);
        this.f7327b = zzcih.f7313k.getAndIncrement();
        this.f7328c = str;
        this.f7326a = z;
        if (this.f7327b == Long.MAX_VALUE) {
            zzcihVar.mo7872t().m8106y().m8108a("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(zzcik zzcikVar) {
        zzcik zzcikVar2 = zzcikVar;
        if (this.f7326a != zzcikVar2.f7326a) {
            return this.f7326a ? -1 : 1;
        }
        if (this.f7327b < zzcikVar2.f7327b) {
            return -1;
        }
        if (this.f7327b > zzcikVar2.f7327b) {
            return 1;
        }
        this.f7329d.mo7872t().m8107z().m8109a("Two tasks share the same index. index", Long.valueOf(this.f7327b));
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable th) {
        this.f7329d.mo7872t().m8106y().m8109a(this.f7328c, th);
        if (th instanceof zzcii) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }
}
