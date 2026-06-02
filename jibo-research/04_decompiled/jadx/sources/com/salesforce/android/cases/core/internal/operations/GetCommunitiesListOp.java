package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.model.Community;
import com.salesforce.android.cases.core.requests.CommunitiesListRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GetCommunitiesListOp extends CaseFetchSaveOperation<CommunitiesListRequest, List<Community>> {
    public GetCommunitiesListOp(CommunitiesListRequest communitiesListRequest, LocalRepository localRepository, RemoteRepository remoteRepository) {
        super(communitiesListRequest, localRepository, remoteRepository);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<List<Community>> mo12510a(RemoteRepository remoteRepository, CommunitiesListRequest communitiesListRequest) {
        return remoteRepository.m12593a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<List<Community>> mo12508a(LocalRepository localRepository, CommunitiesListRequest communitiesListRequest) {
        return localRepository.mo12395c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<Void> mo12509a(LocalRepository localRepository, CommunitiesListRequest communitiesListRequest, List<Community> list) {
        return localRepository.mo12381a(communitiesListRequest, list);
    }

    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: b */
    protected String mo12514b() {
        return "Cannot Get Communities List, Offline";
    }
}
