package com.salesforce.android.cases.core.requests;

import com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest;

/* JADX INFO: loaded from: classes.dex */
public class CaseFeedRequest extends FetchSaveRequest {

    /* JADX INFO: renamed from: a */
    private final String f12569a;

    /* JADX INFO: renamed from: b */
    private final String f12570b;

    CaseFeedRequest(CaseFeedRequestBuilder caseFeedRequestBuilder) {
        super(caseFeedRequestBuilder);
        this.f12569a = caseFeedRequestBuilder.f12571a;
        this.f12570b = caseFeedRequestBuilder.f12572b;
    }

    /* JADX INFO: renamed from: a */
    public String m12628a() {
        return this.f12569a;
    }

    /* JADX INFO: renamed from: b */
    public String m12629b() {
        return this.f12570b;
    }

    public static class CaseFeedRequestBuilder extends FetchSaveRequest.FetchSaveRequestBuilder<CaseFeedRequestBuilder> {

        /* JADX INFO: renamed from: a */
        private String f12571a;

        /* JADX INFO: renamed from: b */
        private String f12572b;

        public CaseFeedRequestBuilder(String str, String str2) {
            this.f12571a = str;
            this.f12572b = str2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CaseFeedRequestBuilder mo12627c() {
            return this;
        }

        /* JADX INFO: renamed from: b */
        public CaseFeedRequest m12633b() {
            return new CaseFeedRequest(this);
        }
    }
}
