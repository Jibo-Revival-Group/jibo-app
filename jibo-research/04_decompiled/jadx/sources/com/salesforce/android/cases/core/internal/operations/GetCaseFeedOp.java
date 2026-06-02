package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.model.CaseFeed;
import com.salesforce.android.cases.core.requests.CaseFeedRequest;
import com.salesforce.android.service.common.utilities.control.Async;

/* JADX INFO: loaded from: classes.dex */
public class GetCaseFeedOp extends CaseFetchSaveOperation<CaseFeedRequest, CaseFeed> {
    public GetCaseFeedOp(CaseFeedRequest caseFeedRequest, LocalRepository localRepository, RemoteRepository remoteRepository) {
        super(caseFeedRequest, localRepository, remoteRepository);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<CaseFeed> mo12510a(RemoteRepository remoteRepository, CaseFeedRequest caseFeedRequest) {
        return remoteRepository.m12595a(caseFeedRequest);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<CaseFeed> mo12508a(LocalRepository localRepository, CaseFeedRequest caseFeedRequest) {
        return localRepository.mo12377a(caseFeedRequest);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<Void> mo12509a(LocalRepository localRepository, CaseFeedRequest caseFeedRequest, CaseFeed caseFeed) {
        return localRepository.mo12378a(caseFeedRequest, caseFeed);
    }

    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: b */
    protected String mo12514b() {
        return "Cannot Get Case Feed, Offline";
    }
}
