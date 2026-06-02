package com.salesforce.android.cases.core.internal.operations.resulthandlers;

import com.salesforce.android.cases.core.internal.model.CompleteCaseFeedModel;
import com.salesforce.android.cases.core.internal.operations.MultipartOperationObserver;
import com.salesforce.android.cases.core.model.CaseLayoutData;
import com.salesforce.android.service.common.utilities.control.Async;

/* JADX INFO: loaded from: classes.dex */
public class CreateCaseQuickActionHandler extends AbstractMultipartRequestHandler<CaseLayoutData> {

    /* JADX INFO: renamed from: b */
    private final CompleteCaseFeedModel f12547b;

    @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo9875a(Async async, Object obj) {
        m12584a((Async<?>) async, (CaseLayoutData) obj);
    }

    public CreateCaseQuickActionHandler(MultipartOperationObserver multipartOperationObserver, CompleteCaseFeedModel completeCaseFeedModel) {
        super(multipartOperationObserver);
        this.f12547b = completeCaseFeedModel;
    }

    /* JADX INFO: renamed from: a */
    public void m12584a(Async<?> async, CaseLayoutData caseLayoutData) {
        this.f12547b.m12481a(caseLayoutData);
        this.f12546a.mo12558g();
    }
}
