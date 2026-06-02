package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.requests.SetCaseLastReadDateRequest;
import com.salesforce.android.service.common.utilities.control.Async;

/* JADX INFO: loaded from: classes.dex */
public class SetCaseLastReadDateOp extends SaveOp<SetCaseLastReadDateRequest, Void> {
    @Override // com.salesforce.android.cases.core.internal.operations.SaveOp
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ SaveOp mo12556e() {
        return super.mo12556e();
    }

    @Override // com.salesforce.android.cases.core.internal.operations.SaveOp, com.salesforce.android.service.common.fetchsave.internal.operations.Operation
    /* JADX INFO: renamed from: f */
    public /* bridge */ /* synthetic */ Async mo12557f() {
        return super.mo12557f();
    }

    public SetCaseLastReadDateOp(SetCaseLastReadDateRequest setCaseLastReadDateRequest, LocalRepository localRepository, RemoteRepository remoteRepository) {
        super(setCaseLastReadDateRequest, localRepository, remoteRepository);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.core.internal.operations.SaveOp
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<Void> mo12578a(LocalRepository localRepository, SetCaseLastReadDateRequest setCaseLastReadDateRequest) {
        return localRepository.mo12390a(setCaseLastReadDateRequest.m12699c(), setCaseLastReadDateRequest.m12700d());
    }
}
