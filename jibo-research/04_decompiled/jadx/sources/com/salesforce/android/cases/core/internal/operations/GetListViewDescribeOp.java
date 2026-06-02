package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.model.ListViewDescribe;
import com.salesforce.android.cases.core.requests.ListViewDescribeRequest;
import com.salesforce.android.service.common.utilities.control.Async;

/* JADX INFO: loaded from: classes.dex */
public class GetListViewDescribeOp extends CaseFetchSaveOperation<ListViewDescribeRequest, ListViewDescribe> {
    public GetListViewDescribeOp(ListViewDescribeRequest listViewDescribeRequest, LocalRepository localRepository, RemoteRepository remoteRepository) {
        super(listViewDescribeRequest, localRepository, remoteRepository);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<ListViewDescribe> mo12510a(RemoteRepository remoteRepository, ListViewDescribeRequest listViewDescribeRequest) {
        return remoteRepository.m12601a(listViewDescribeRequest);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<ListViewDescribe> mo12508a(LocalRepository localRepository, ListViewDescribeRequest listViewDescribeRequest) {
        return localRepository.mo12386a(listViewDescribeRequest);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<Void> mo12509a(LocalRepository localRepository, ListViewDescribeRequest listViewDescribeRequest, ListViewDescribe listViewDescribe) {
        return localRepository.mo12387a(listViewDescribeRequest, listViewDescribe);
    }

    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: b */
    protected String mo12514b() {
        return "Cannot Get List View Description, Offline";
    }
}
