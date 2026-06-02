package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.model.ListView;
import com.salesforce.android.cases.core.requests.ListViewRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.functional.Function;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GetListViewIdOp extends CaseFetchSaveOperation<ListViewRequest, String> {
    public GetListViewIdOp(ListViewRequest listViewRequest, LocalRepository localRepository, RemoteRepository remoteRepository) {
        super(listViewRequest, localRepository, remoteRepository);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<String> mo12508a(LocalRepository localRepository, ListViewRequest listViewRequest) {
        return localRepository.mo12388a(listViewRequest);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<Void> mo12509a(LocalRepository localRepository, ListViewRequest listViewRequest, String str) {
        return localRepository.mo12389a(listViewRequest, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<String> mo12510a(RemoteRepository remoteRepository, final ListViewRequest listViewRequest) {
        return remoteRepository.m12602b().mo14076a(new Function<List<ListView>, String>() { // from class: com.salesforce.android.cases.core.internal.operations.GetListViewIdOp.1
            @Override // com.salesforce.android.service.common.utilities.functional.Function
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public String mo12236a(List<ListView> list) {
                for (ListView listView : list) {
                    if (listView.mo12502a().equals(listViewRequest.m12679a())) {
                        return listView.mo12503b();
                    }
                }
                return "";
            }
        });
    }

    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: b */
    protected String mo12514b() {
        return "Cannot Get List View Id, Offline";
    }
}
