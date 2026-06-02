package com.salesforce.android.cases.core.internal.operations;

import android.support.v4.util.ArraySet;
import com.salesforce.android.service.common.fetchsave.internal.operations.Operation;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class MultipartOperation<T> implements MultipartOperationObserver, Operation<T> {

    /* JADX INFO: renamed from: c */
    private boolean f12539c;

    /* JADX INFO: renamed from: b */
    private final Set<Async> f12538b = Collections.synchronizedSet(new ArraySet());

    /* JADX INFO: renamed from: a */
    private final BasicAsync<T> f12537a = BasicAsync.m14086g();

    /* JADX INFO: renamed from: a */
    abstract void mo12533a();

    /* JADX INFO: renamed from: b */
    abstract boolean mo12534b();

    /* JADX INFO: renamed from: d */
    abstract T mo12536d();

    MultipartOperation() {
    }

    @Override // com.salesforce.android.service.common.fetchsave.internal.operations.Operation
    /* JADX INFO: renamed from: e */
    public final Operation<T> mo12556e() {
        mo12533a();
        this.f12539c = true;
        if (this.f12538b.isEmpty()) {
            this.f12537a.mo12613b();
        }
        return this;
    }

    @Override // com.salesforce.android.service.common.fetchsave.internal.operations.Operation
    /* JADX INFO: renamed from: f */
    public Async<T> mo12557f() {
        return this.f12537a;
    }

    @Override // com.salesforce.android.cases.core.internal.operations.MultipartOperationObserver
    /* JADX INFO: renamed from: a */
    public void mo12552a(Async<?> async) {
        this.f12538b.remove(async);
        if (this.f12538b.isEmpty() && this.f12539c) {
            this.f12537a.mo12613b();
        }
    }

    @Override // com.salesforce.android.cases.core.internal.operations.MultipartOperationObserver
    /* JADX INFO: renamed from: g */
    public void mo12558g() {
        if (mo12534b() && mo12536d() != null) {
            this.f12537a.mo12614b(mo12536d());
        }
    }

    @Override // com.salesforce.android.cases.core.internal.operations.MultipartOperationObserver
    /* JADX INFO: renamed from: a */
    public void mo12553a(Throwable th) {
        this.f12537a.mo12615b(th);
        this.f12537a.mo12613b();
        this.f12538b.clear();
    }

    @Override // com.salesforce.android.cases.core.internal.operations.MultipartOperationObserver
    /* JADX INFO: renamed from: b */
    public void mo12554b(Async<?> async) {
        async.mo14080c();
        mo12552a(async);
    }

    @Override // com.salesforce.android.cases.core.internal.operations.MultipartOperationObserver
    /* JADX INFO: renamed from: c */
    public void mo12555c(Async<?> async) {
        this.f12538b.add(async);
    }
}
