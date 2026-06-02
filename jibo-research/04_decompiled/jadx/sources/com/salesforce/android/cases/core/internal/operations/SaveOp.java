package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.requests.SaveRequest;
import com.salesforce.android.service.common.fetchsave.internal.operations.Operation;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;

/* JADX INFO: loaded from: classes.dex */
abstract class SaveOp<S extends SaveRequest, T> implements Operation<T> {

    /* JADX INFO: renamed from: a */
    private final S f12540a;

    /* JADX INFO: renamed from: b */
    private final LocalRepository f12541b;

    /* JADX INFO: renamed from: c */
    private final RemoteRepository f12542c;

    /* JADX INFO: renamed from: d */
    private final BasicAsync<T> f12543d = BasicAsync.m14086g();

    public SaveOp(S s, LocalRepository localRepository, RemoteRepository remoteRepository) {
        this.f12540a = s;
        this.f12541b = localRepository;
        this.f12542c = remoteRepository;
    }

    @Override // com.salesforce.android.service.common.fetchsave.internal.operations.Operation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public SaveOp<S, T> mo12556e() {
        if (this.f12540a.m12689a()) {
            mo12578a(this.f12541b, this.f12540a).mo14077b(new LocalRepositoryHandler());
        } else if (this.f12540a.m12690b()) {
            m12579a(this.f12542c, this.f12540a).mo14077b(new RemoteRepositoryHandler());
        }
        return this;
    }

    @Override // com.salesforce.android.service.common.fetchsave.internal.operations.Operation
    /* JADX INFO: renamed from: f */
    public Async<T> mo12557f() {
        return this.f12543d;
    }

    /* JADX INFO: renamed from: a */
    protected Async<T> mo12578a(LocalRepository localRepository, S s) {
        return BasicAsync.m14087h();
    }

    /* JADX INFO: renamed from: a */
    protected Async<T> m12579a(RemoteRepository remoteRepository, S s) {
        return BasicAsync.m14087h();
    }

    private class LocalRepositoryHandler implements Async.Handler<T> {
        private LocalRepositoryHandler() {
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
        /* JADX INFO: renamed from: a */
        public void mo12581a(Async<?> async, Throwable th) {
            SaveOp.this.f12543d.mo12615b(th);
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
        /* JADX INFO: renamed from: a */
        public void mo9875a(Async<?> async, T t) {
            SaveOp.this.f12543d.mo12614b(t);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
        /* JADX INFO: renamed from: a */
        public void mo12580a(Async<?> async) {
            if (SaveOp.this.f12540a.m12690b()) {
                SaveOp.this.m12579a(SaveOp.this.f12542c, SaveOp.this.f12540a).mo14077b(new RemoteRepositoryHandler());
            } else {
                SaveOp.this.f12543d.mo12613b();
            }
        }
    }

    private class RemoteRepositoryHandler implements Async.Handler<T> {
        private RemoteRepositoryHandler() {
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
        /* JADX INFO: renamed from: a */
        public void mo12581a(Async<?> async, Throwable th) {
            SaveOp.this.f12543d.mo12615b(th);
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
        /* JADX INFO: renamed from: a */
        public void mo9875a(Async<?> async, T t) {
            SaveOp.this.f12543d.mo12614b(t);
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
        /* JADX INFO: renamed from: a */
        public void mo12580a(Async<?> async) {
            SaveOp.this.f12543d.mo12613b();
        }
    }
}
