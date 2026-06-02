package com.salesforce.android.service.common.fetchsave.internal.operations;

import com.salesforce.android.service.common.fetchsave.exceptions.OfflineException;
import com.salesforce.android.service.common.fetchsave.internal.http.HttpService;
import com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;

/* JADX INFO: loaded from: classes.dex */
public abstract class FetchSaveOp<S extends FetchSaveRequest, T> implements Operation<T> {

    /* JADX INFO: renamed from: a */
    private final S f13443a;

    /* JADX INFO: renamed from: b */
    private Async<Void> f13444b;

    /* JADX INFO: renamed from: c */
    private T f13445c;

    /* JADX INFO: renamed from: d */
    private boolean f13446d;

    /* JADX INFO: renamed from: e */
    private final BasicAsync<T> f13447e = BasicAsync.m14086g();

    /* JADX INFO: renamed from: a */
    protected abstract OfflineException mo12507a();

    /* JADX INFO: renamed from: a */
    protected abstract Async<T> mo12511a(S s);

    /* JADX INFO: renamed from: a */
    protected abstract Async<Void> mo12512a(S s, T t);

    /* JADX INFO: renamed from: b */
    protected abstract Async<T> mo12513b(S s);

    /* JADX INFO: renamed from: c */
    protected abstract HttpService mo12515c();

    public FetchSaveOp(S s) {
        this.f13443a = s;
    }

    @Override // com.salesforce.android.service.common.fetchsave.internal.operations.Operation
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public FetchSaveOp<S, T> mo12556e() {
        this.f13446d = mo12515c().mo12603c();
        if (this.f13443a.m13740m()) {
            m13734h();
        } else {
            m13735i();
        }
        return this;
    }

    @Override // com.salesforce.android.service.common.fetchsave.internal.operations.Operation
    /* JADX INFO: renamed from: f */
    public Async<T> mo12557f() {
        return this.f13447e;
    }

    /* JADX INFO: renamed from: a */
    void m13724a(T t) {
        this.f13447e.mo12614b(t);
    }

    /* JADX INFO: renamed from: a */
    void m13725a(Throwable th) {
        this.f13447e.mo12615b(th);
    }

    /* JADX INFO: renamed from: g */
    void m13733g() {
        this.f13447e.mo12613b();
    }

    /* JADX INFO: renamed from: h */
    void m13734h() {
        mo12511a((FetchSaveRequest) this.f13443a).mo14077b(new DbHandler());
    }

    /* JADX INFO: renamed from: i */
    void m13735i() {
        mo12513b((FetchSaveRequest) this.f13443a).mo14077b(new HttpHandler());
    }

    /* JADX INFO: renamed from: b */
    void m13726b(T t) {
        SaveHandler saveHandler = new SaveHandler();
        this.f13444b = mo12512a(this.f13443a, t).mo14072a((Async.CompletionHandler) saveHandler).mo14073a((Async.ErrorHandler) saveHandler);
    }

    /* JADX INFO: renamed from: b */
    void m13727b(Throwable th) {
        if (this.f13446d) {
            m13735i();
        } else {
            m13725a(th);
        }
    }

    /* JADX INFO: renamed from: c */
    void m13728c(T t) {
        this.f13445c = t;
        if (this.f13443a.m13741n() || !this.f13446d) {
            m13724a(t);
        }
    }

    /* JADX INFO: renamed from: j */
    void m13736j() {
        if (this.f13446d) {
            m13735i();
        } else if (this.f13445c == null) {
            m13725a((Throwable) mo12507a());
        } else {
            m13733g();
        }
    }

    /* JADX INFO: renamed from: c */
    void m13729c(Throwable th) {
        if (this.f13445c != null) {
            if (!this.f13443a.m13741n()) {
                m13724a(this.f13445c);
            }
            m13733g();
            return;
        }
        m13725a(th);
    }

    /* JADX INFO: renamed from: d */
    void m13731d(T t) {
        m13724a(t);
        if (this.f13443a.m13739l()) {
            m13726b(t);
        }
    }

    /* JADX INFO: renamed from: k */
    void m13737k() {
        if (this.f13444b == null) {
            m13733g();
        }
    }

    /* JADX INFO: renamed from: d */
    void m13732d(Throwable th) {
        m13725a(th);
    }

    /* JADX INFO: renamed from: l */
    void m13738l() {
        m13733g();
    }

    class DbHandler implements Async.Handler<T> {
        DbHandler() {
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
        /* JADX INFO: renamed from: a */
        public void mo12581a(Async<?> async, Throwable th) {
            FetchSaveOp.this.m13727b(th);
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
        /* JADX INFO: renamed from: a */
        public void mo9875a(Async<?> async, T t) {
            FetchSaveOp.this.m13728c(t);
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
        /* JADX INFO: renamed from: a */
        public void mo12580a(Async<?> async) {
            FetchSaveOp.this.m13736j();
        }
    }

    class HttpHandler implements Async.Handler<T> {
        HttpHandler() {
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
        /* JADX INFO: renamed from: a */
        public void mo12581a(Async<?> async, Throwable th) {
            FetchSaveOp.this.m13729c(th);
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
        /* JADX INFO: renamed from: a */
        public void mo9875a(Async<?> async, T t) {
            FetchSaveOp.this.m13731d(t);
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
        /* JADX INFO: renamed from: a */
        public void mo12580a(Async<?> async) {
            FetchSaveOp.this.m13737k();
        }
    }

    class SaveHandler implements Async.CompletionHandler, Async.ErrorHandler {
        SaveHandler() {
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
        /* JADX INFO: renamed from: a */
        public void mo12581a(Async<?> async, Throwable th) {
            FetchSaveOp.this.m13732d(th);
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
        /* JADX INFO: renamed from: a */
        public void mo12580a(Async<?> async) {
            FetchSaveOp.this.m13738l();
        }
    }
}
