package com.salesforce.android.cases.core.internal.operations.resulthandlers;

import com.salesforce.android.cases.core.internal.model.CompleteCaseFeedModel;
import com.salesforce.android.cases.core.internal.operations.MultipartOperationObserver;
import com.salesforce.android.cases.core.model.DefaultValues;
import com.salesforce.android.service.common.utilities.control.Async;

/* JADX INFO: loaded from: classes.dex */
public class DefaultValuesHandler extends AbstractMultipartRequestHandler<DefaultValues> {

    /* JADX INFO: renamed from: b */
    private final CompleteCaseFeedModel f12548b;

    @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo9875a(Async async, Object obj) {
        m12585a((Async<?>) async, (DefaultValues) obj);
    }

    public DefaultValuesHandler(MultipartOperationObserver multipartOperationObserver, CompleteCaseFeedModel completeCaseFeedModel) {
        super(multipartOperationObserver);
        this.f12548b = completeCaseFeedModel;
    }

    /* JADX INFO: renamed from: a */
    public void m12585a(Async<?> async, DefaultValues defaultValues) {
        this.f12548b.m12482a(defaultValues);
        this.f12546a.mo12558g();
    }
}
