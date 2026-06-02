package com.salesforce.android.cases.p020ui.internal.features.shared;

import com.salesforce.android.service.common.fetchsave.exceptions.OfflineException;
import com.salesforce.android.service.common.utilities.control.Async;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractHandler<T> implements Async.CompletionHandler, Async.ErrorHandler, Async.ResultHandler<T> {

    /* JADX INFO: renamed from: c */
    Async<T> f12822c;

    /* JADX INFO: renamed from: d */
    T f12823d;

    /* JADX INFO: renamed from: e */
    Throwable f12824e;

    /* JADX INFO: renamed from: a */
    protected abstract Async<T> mo12793a();

    /* JADX INFO: renamed from: a */
    protected abstract void mo12794a(T t);

    /* JADX INFO: renamed from: a */
    protected abstract void mo12795a(Throwable th);

    /* JADX INFO: renamed from: b */
    protected abstract void mo12797b();

    /* JADX INFO: renamed from: c */
    protected abstract void mo12798c();

    /* JADX INFO: renamed from: d */
    public void m13000d() {
        if (this.f12822c != null) {
            if (this.f12822c.mo14082e()) {
                m12999b(this.f12824e);
                return;
            } else if (this.f12822c.mo14081d()) {
                mo12794a(this.f12823d);
                return;
            } else {
                mo12797b();
                return;
            }
        }
        mo12797b();
        this.f12822c = mo12793a();
        this.f12822c.mo14077b(this);
    }

    /* JADX INFO: renamed from: e */
    public void m13001e() {
        if (this.f12822c != null) {
            this.f12822c.mo14079c(this);
        }
        this.f12824e = null;
        this.f12823d = null;
        this.f12822c = null;
    }

    @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
    /* JADX INFO: renamed from: a */
    public void mo12580a(Async<?> async) {
    }

    @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
    /* JADX INFO: renamed from: a */
    public final void mo12581a(Async<?> async, Throwable th) {
        this.f12824e = th;
        m12999b(this.f12824e);
    }

    @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
    /* JADX INFO: renamed from: a */
    public final void mo9875a(Async<?> async, T t) {
        this.f12823d = t;
        mo12794a(this.f12823d);
    }

    /* JADX INFO: renamed from: f */
    public boolean m13002f() {
        return this.f12822c != null && this.f12822c.mo14081d();
    }

    /* JADX INFO: renamed from: g */
    public boolean m13003g() {
        return this.f12822c != null && this.f12822c.mo14082e();
    }

    /* JADX INFO: renamed from: h */
    public boolean m13004h() {
        return this.f12822c != null && this.f12822c.mo14083f();
    }

    /* JADX INFO: renamed from: i */
    public boolean m13005i() {
        return m13004h() || m13003g() || m13002f();
    }

    /* JADX INFO: renamed from: b */
    private void m12999b(Throwable th) {
        if ((th instanceof IOException) || (th instanceof OfflineException)) {
            mo12798c();
        } else {
            mo12795a(th);
        }
    }
}
