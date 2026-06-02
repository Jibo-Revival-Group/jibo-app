package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.model.DefaultValues;
import com.salesforce.android.cases.core.requests.DefaultValuesRequest;
import com.salesforce.android.service.common.utilities.control.Async;

/* JADX INFO: loaded from: classes.dex */
public class GetDefaultValuesOp extends CaseFetchSaveOperation<DefaultValuesRequest, DefaultValues> {
    public GetDefaultValuesOp(DefaultValuesRequest defaultValuesRequest, LocalRepository localRepository, RemoteRepository remoteRepository) {
        super(defaultValuesRequest, localRepository, remoteRepository);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<DefaultValues> mo12510a(RemoteRepository remoteRepository, DefaultValuesRequest defaultValuesRequest) {
        return remoteRepository.m12600a(defaultValuesRequest);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<DefaultValues> mo12508a(LocalRepository localRepository, DefaultValuesRequest defaultValuesRequest) {
        return localRepository.mo12384a(defaultValuesRequest);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<Void> mo12509a(LocalRepository localRepository, DefaultValuesRequest defaultValuesRequest, DefaultValues defaultValues) {
        return localRepository.mo12385a(defaultValuesRequest, defaultValues);
    }

    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: b */
    protected String mo12514b() {
        return "Cannot Get Default Values, Offline";
    }
}
