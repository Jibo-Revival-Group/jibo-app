package com.salesforce.android.cases.core.requests;

import com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest;

/* JADX INFO: loaded from: classes.dex */
public class CommunitiesListRequest extends FetchSaveRequest {
    CommunitiesListRequest(FetchSaveRequest.FetchSaveRequestBuilder fetchSaveRequestBuilder) {
        super(fetchSaveRequestBuilder);
    }

    public static class CommunitiesListRequestBuilder extends FetchSaveRequest.FetchSaveRequestBuilder<CommunitiesListRequestBuilder> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommunitiesListRequestBuilder mo12627c() {
            return this;
        }

        /* JADX INFO: renamed from: b */
        public CommunitiesListRequest m12648b() {
            return new CommunitiesListRequest(this);
        }
    }
}
