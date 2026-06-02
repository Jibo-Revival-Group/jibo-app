package com.salesforce.android.cases.core.requests;

import com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest;

/* JADX INFO: loaded from: classes.dex */
public class CaseDetailRequest extends FetchSaveRequest {

    /* JADX INFO: renamed from: a */
    private final String f12567a;

    CaseDetailRequest(CaseDetailRequestBuilder caseDetailRequestBuilder) {
        super(caseDetailRequestBuilder);
        this.f12567a = caseDetailRequestBuilder.f12568a;
    }

    /* JADX INFO: renamed from: a */
    public String m12623a() {
        return this.f12567a;
    }

    public static class CaseDetailRequestBuilder extends FetchSaveRequest.FetchSaveRequestBuilder<CaseDetailRequestBuilder> {

        /* JADX INFO: renamed from: a */
        private final String f12568a;

        public CaseDetailRequestBuilder(String str) {
            this.f12568a = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CaseDetailRequestBuilder mo12627c() {
            return this;
        }

        /* JADX INFO: renamed from: b */
        public CaseDetailRequest m12626b() {
            return new CaseDetailRequest(this);
        }
    }
}
