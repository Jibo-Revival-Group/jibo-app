package com.salesforce.android.cases.core.requests;

import com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest;

/* JADX INFO: loaded from: classes.dex */
public class CaseListRequest extends FetchSaveRequest {

    /* JADX INFO: renamed from: a */
    private final String f12573a;

    CaseListRequest(CaseListRequestBuilder caseListRequestBuilder) {
        super(caseListRequestBuilder);
        this.f12573a = caseListRequestBuilder.f12574a;
    }

    /* JADX INFO: renamed from: a */
    public static CaseListRequest m12634a(String str) {
        return new CaseListRequestBuilder(str).mo12687c(true).mo12688d(true).m13742e(true).m12638b();
    }

    /* JADX INFO: renamed from: a */
    public String m12635a() {
        return this.f12573a;
    }

    public static class CaseListRequestBuilder extends FetchSaveRequest.FetchSaveRequestBuilder<CaseListRequestBuilder> {

        /* JADX INFO: renamed from: a */
        private String f12574a;

        public CaseListRequestBuilder(String str) {
            this.f12574a = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CaseListRequestBuilder mo12627c() {
            return this;
        }

        /* JADX INFO: renamed from: b */
        public CaseListRequest m12638b() {
            return new CaseListRequest(this);
        }
    }
}
