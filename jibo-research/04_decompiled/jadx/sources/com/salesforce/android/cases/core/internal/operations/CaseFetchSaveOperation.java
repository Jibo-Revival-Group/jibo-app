package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.service.common.fetchsave.exceptions.OfflineException;
import com.salesforce.android.service.common.fetchsave.internal.http.HttpService;
import com.salesforce.android.service.common.fetchsave.internal.operations.FetchSaveOp;
import com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;

/* JADX INFO: loaded from: classes.dex */
abstract class CaseFetchSaveOperation<S extends FetchSaveRequest, T> extends FetchSaveOp<S, T> {

    /* JADX INFO: renamed from: a */
    final LocalRepository f12516a;

    /* JADX INFO: renamed from: b */
    private final RemoteRepository f12517b;

    /* JADX INFO: renamed from: c */
    private final ServiceLogger f12518c;

    /* JADX INFO: renamed from: a */
    protected abstract Async<T> mo12510a(RemoteRepository remoteRepository, S s);

    /* JADX INFO: renamed from: b */
    protected abstract String mo12514b();

    public CaseFetchSaveOperation(S s, LocalRepository localRepository, RemoteRepository remoteRepository) {
        super(s);
        this.f12518c = ServiceLogging.m14203a((Class<?>) CaseFetchSaveOperation.class);
        this.f12516a = localRepository;
        this.f12517b = remoteRepository;
    }

    /* JADX INFO: renamed from: a */
    protected Async<T> mo12508a(LocalRepository localRepository, S s) {
        return BasicAsync.m14087h();
    }

    /* JADX INFO: renamed from: a */
    protected Async<Void> mo12509a(LocalRepository localRepository, S s, T t) {
        return BasicAsync.m14087h();
    }

    @Override // com.salesforce.android.service.common.fetchsave.internal.operations.FetchSaveOp
    /* JADX INFO: renamed from: a */
    protected Async<T> mo12511a(S s) {
        if (this.f12516a == null) {
            throw new IllegalStateException("Operations that support caching must provide a LocalRepository.");
        }
        return mo12508a(this.f12516a, s);
    }

    @Override // com.salesforce.android.service.common.fetchsave.internal.operations.FetchSaveOp
    /* JADX INFO: renamed from: b */
    protected Async<T> mo12513b(S s) {
        return mo12510a(this.f12517b, s);
    }

    @Override // com.salesforce.android.service.common.fetchsave.internal.operations.FetchSaveOp
    /* JADX INFO: renamed from: a */
    protected Async<Void> mo12512a(S s, T t) {
        if (this.f12516a == null) {
            throw new IllegalStateException("Operations that support caching must provide a LocalRepository.");
        }
        return mo12509a(this.f12516a, s, t);
    }

    @Override // com.salesforce.android.service.common.fetchsave.internal.operations.FetchSaveOp
    /* JADX INFO: renamed from: a */
    protected OfflineException mo12507a() {
        return new OfflineException(mo12514b());
    }

    @Override // com.salesforce.android.service.common.fetchsave.internal.operations.FetchSaveOp
    /* JADX INFO: renamed from: c */
    protected HttpService mo12515c() {
        return this.f12517b;
    }
}
