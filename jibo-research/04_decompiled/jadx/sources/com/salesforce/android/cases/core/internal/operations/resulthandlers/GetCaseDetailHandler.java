package com.salesforce.android.cases.core.internal.operations.resulthandlers;

import com.salesforce.android.cases.core.internal.model.CompleteCaseFeedModel;
import com.salesforce.android.cases.core.internal.operations.MultipartOperationObserver;
import com.salesforce.android.cases.core.model.CaseDetailRecord;
import com.salesforce.android.service.common.utilities.control.Async;

/* JADX INFO: loaded from: classes.dex */
public class GetCaseDetailHandler extends AbstractMultipartRequestHandler<CaseDetailRecord> {

    /* JADX INFO: renamed from: b */
    private final CompleteCaseFeedModel f12549b;

    @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo9875a(Async async, Object obj) {
        m12586a((Async<?>) async, (CaseDetailRecord) obj);
    }

    public GetCaseDetailHandler(MultipartOperationObserver multipartOperationObserver, CompleteCaseFeedModel completeCaseFeedModel) {
        super(multipartOperationObserver);
        this.f12549b = completeCaseFeedModel;
    }

    /* JADX INFO: renamed from: a */
    public void m12586a(Async<?> async, CaseDetailRecord caseDetailRecord) {
        this.f12549b.m12479a(caseDetailRecord);
        this.f12546a.mo12558g();
    }
}
