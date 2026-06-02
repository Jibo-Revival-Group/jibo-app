package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.requests.SetCaseHiddenRequest;
import com.salesforce.android.service.common.utilities.control.Async;

/* JADX INFO: loaded from: classes.dex */
public class SetCaseHiddenOp extends SaveOp<SetCaseHiddenRequest, Void> {
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

    public SetCaseHiddenOp(SetCaseHiddenRequest setCaseHiddenRequest, LocalRepository localRepository, RemoteRepository remoteRepository) {
        super(setCaseHiddenRequest, localRepository, remoteRepository);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.core.internal.operations.SaveOp
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<Void> mo12578a(LocalRepository localRepository, SetCaseHiddenRequest setCaseHiddenRequest) {
        return localRepository.mo12391a(setCaseHiddenRequest.m12692c(), setCaseHiddenRequest.m12693d());
    }
}
