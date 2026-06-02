package com.salesforce.android.cases.core.requests;

import com.salesforce.android.cases.core.FetchSaveRequestBuilder;

/* JADX INFO: loaded from: classes.dex */
public abstract class NoCacheRequestBuilder<T extends FetchSaveRequestBuilder<T>> extends FetchSaveRequestBuilder<T> {
    @Override // com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final T mo12688d(boolean z) {
        throw new IllegalStateException("Cannot set return cached results on NoCacheRequest");
    }

    @Override // com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final T mo12687c(boolean z) {
        throw new IllegalStateException("Cannot set cache results on NoCacheRequest");
    }

    @Override // com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder
    /* JADX INFO: renamed from: d */
    public final boolean mo12682d() {
        return false;
    }

    @Override // com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder
    /* JADX INFO: renamed from: f_ */
    public final boolean mo12684f_() {
        return false;
    }
}
