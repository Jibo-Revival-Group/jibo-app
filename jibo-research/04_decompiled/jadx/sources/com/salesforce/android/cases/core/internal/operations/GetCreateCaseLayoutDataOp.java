package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.local.DbUtils;
import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.model.CaseLayoutData;
import com.salesforce.android.cases.core.requests.CreateCaseQuickActionRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.androidsdk.accounts.UserAccount;

/* JADX INFO: loaded from: classes.dex */
class GetCreateCaseLayoutDataOp extends CaseFetchSaveOperation<CreateCaseQuickActionRequest, CaseLayoutData> {

    /* JADX INFO: renamed from: b */
    private ServiceLogger f12531b;

    /* JADX INFO: renamed from: c */
    private final UserAccount f12532c;

    public GetCreateCaseLayoutDataOp(CreateCaseQuickActionRequest createCaseQuickActionRequest, LocalRepository localRepository, RemoteRepository remoteRepository, UserAccount userAccount) {
        super(createCaseQuickActionRequest, localRepository, remoteRepository);
        this.f12531b = ServiceLogging.m14203a((Class<?>) GetCreateCaseLayoutDataOp.class);
        this.f12532c = userAccount;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<CaseLayoutData> mo12510a(RemoteRepository remoteRepository, CreateCaseQuickActionRequest createCaseQuickActionRequest) {
        return remoteRepository.m12598a(createCaseQuickActionRequest);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<Void> mo12509a(LocalRepository localRepository, CreateCaseQuickActionRequest createCaseQuickActionRequest, CaseLayoutData caseLayoutData) {
        if (DbUtils.m12369a(this.f12532c)) {
            return localRepository.mo12383a(createCaseQuickActionRequest, caseLayoutData);
        }
        this.f12531b.mo14190c("Unable to store Case Layout while unauthenticated.");
        return BasicAsync.m14087h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<CaseLayoutData> mo12508a(LocalRepository localRepository, CreateCaseQuickActionRequest createCaseQuickActionRequest) {
        return localRepository.mo12382a(createCaseQuickActionRequest);
    }

    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: b */
    protected String mo12514b() {
        return "Cannot Get Case Layout Data, Offline";
    }
}
