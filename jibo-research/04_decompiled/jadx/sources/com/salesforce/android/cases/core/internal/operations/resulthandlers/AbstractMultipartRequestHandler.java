package com.salesforce.android.cases.core.internal.operations.resulthandlers;

import com.salesforce.android.cases.core.internal.operations.MultipartOperationObserver;
import com.salesforce.android.service.common.utilities.control.Async;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractMultipartRequestHandler<T> implements Async.Handler<T> {

    /* JADX INFO: renamed from: a */
    final MultipartOperationObserver f12546a;

    public AbstractMultipartRequestHandler(MultipartOperationObserver multipartOperationObserver) {
        this.f12546a = multipartOperationObserver;
    }

    @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
    /* JADX INFO: renamed from: a */
    public void mo12580a(Async<?> async) {
        this.f12546a.mo12552a(async);
    }

    @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
    /* JADX INFO: renamed from: a */
    public void mo12581a(Async<?> async, Throwable th) {
        this.f12546a.mo12553a(th);
    }
}
