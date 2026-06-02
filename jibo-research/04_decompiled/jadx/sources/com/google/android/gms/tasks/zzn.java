package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class zzn<TResult> extends Task<TResult> {

    /* JADX INFO: renamed from: a */
    private final Object f8426a = new Object();

    /* JADX INFO: renamed from: b */
    private final zzl<TResult> f8427b = new zzl<>();

    /* JADX INFO: renamed from: c */
    private boolean f8428c;

    /* JADX INFO: renamed from: d */
    private TResult f8429d;

    /* JADX INFO: renamed from: e */
    private Exception f8430e;

    zzn() {
    }

    /* JADX INFO: renamed from: e */
    private final void m8956e() {
        zzbq.m7379a(this.f8428c, "Task is not yet complete");
    }

    /* JADX INFO: renamed from: f */
    private final void m8957f() {
        zzbq.m7379a(!this.f8428c, "Task is already complete");
    }

    /* JADX INFO: renamed from: g */
    private final void m8958g() {
        synchronized (this.f8426a) {
            if (this.f8428c) {
                this.f8427b.m8954a(this);
            }
        }
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: a */
    public final Task<TResult> mo8926a(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.f8427b.m8955a(new zze(executor, onCompleteListener));
        m8958g();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: a */
    public final Task<TResult> mo8927a(Executor executor, OnFailureListener onFailureListener) {
        this.f8427b.m8955a(new zzg(executor, onFailureListener));
        m8958g();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: a */
    public final Task<TResult> mo8928a(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        this.f8427b.m8955a(new zzi(executor, onSuccessListener));
        m8958g();
        return this;
    }

    /* JADX INFO: renamed from: a */
    public final void m8959a(Exception exc) {
        zzbq.m7374a(exc, "Exception must not be null");
        synchronized (this.f8426a) {
            m8957f();
            this.f8428c = true;
            this.f8430e = exc;
        }
        this.f8427b.m8954a(this);
    }

    /* JADX INFO: renamed from: a */
    public final void m8960a(TResult tresult) {
        synchronized (this.f8426a) {
            m8957f();
            this.f8428c = true;
            this.f8429d = tresult;
        }
        this.f8427b.m8954a(this);
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: a */
    public final boolean mo8929a() {
        boolean z;
        synchronized (this.f8426a) {
            z = this.f8428c;
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: b */
    public final boolean mo8930b() {
        boolean z;
        synchronized (this.f8426a) {
            z = this.f8428c && this.f8430e == null;
        }
        return z;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m8961b(Exception exc) {
        boolean z = true;
        zzbq.m7374a(exc, "Exception must not be null");
        synchronized (this.f8426a) {
            if (this.f8428c) {
                z = false;
            } else {
                this.f8428c = true;
                this.f8430e = exc;
                this.f8427b.m8954a(this);
            }
        }
        return z;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m8962b(TResult tresult) {
        boolean z = true;
        synchronized (this.f8426a) {
            if (this.f8428c) {
                z = false;
            } else {
                this.f8428c = true;
                this.f8429d = tresult;
                this.f8427b.m8954a(this);
            }
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: c */
    public final TResult mo8931c() {
        TResult tresult;
        synchronized (this.f8426a) {
            m8956e();
            if (this.f8430e != null) {
                throw new RuntimeExecutionException(this.f8430e);
            }
            tresult = this.f8429d;
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: d */
    public final Exception mo8932d() {
        Exception exc;
        synchronized (this.f8426a) {
            exc = this.f8430e;
        }
        return exc;
    }
}
