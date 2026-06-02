package com.salesforce.android.cases.core.internal.operations.resulthandlers;

import com.salesforce.android.cases.core.internal.model.CompleteCaseFeedModel;
import com.salesforce.android.cases.core.internal.operations.MultipartOperationObserver;
import com.salesforce.android.cases.core.model.CaseFeed;
import com.salesforce.android.service.common.utilities.control.Async;

/* JADX INFO: loaded from: classes.dex */
public class GetCaseFeedHandler extends AbstractMultipartRequestHandler<CaseFeed> {

    /* JADX INFO: renamed from: b */
    private final CompleteCaseFeedModel f12550b;

    @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo9875a(Async async, Object obj) {
        m12587a((Async<?>) async, (CaseFeed) obj);
    }

    public GetCaseFeedHandler(MultipartOperationObserver multipartOperationObserver, CompleteCaseFeedModel completeCaseFeedModel) {
        super(multipartOperationObserver);
        this.f12550b = completeCaseFeedModel;
    }

    /* JADX INFO: renamed from: a */
    public void m12587a(Async<?> async, CaseFeed caseFeed) {
        this.f12550b.m12480a(caseFeed);
        this.f12546a.mo12558g();
    }
}
