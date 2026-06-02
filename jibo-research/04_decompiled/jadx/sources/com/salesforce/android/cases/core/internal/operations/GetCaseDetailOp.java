package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.model.CaseDetailRecord;
import com.salesforce.android.cases.core.requests.CaseDetailRequest;
import com.salesforce.android.service.common.utilities.control.Async;

/* JADX INFO: loaded from: classes.dex */
public class GetCaseDetailOp extends CaseFetchSaveOperation<CaseDetailRequest, CaseDetailRecord> {
    public GetCaseDetailOp(CaseDetailRequest caseDetailRequest, LocalRepository localRepository, RemoteRepository remoteRepository) {
        super(caseDetailRequest, localRepository, remoteRepository);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<CaseDetailRecord> mo12510a(RemoteRepository remoteRepository, CaseDetailRequest caseDetailRequest) {
        return remoteRepository.m12594a(caseDetailRequest);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<CaseDetailRecord> mo12508a(LocalRepository localRepository, CaseDetailRequest caseDetailRequest) {
        return localRepository.mo12375a(caseDetailRequest);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<Void> mo12509a(LocalRepository localRepository, CaseDetailRequest caseDetailRequest, CaseDetailRecord caseDetailRecord) {
        return localRepository.mo12376a(caseDetailRequest, caseDetailRecord);
    }

    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: b */
    protected String mo12514b() {
        return "Cannot Get Case Detail, Offline";
    }
}
