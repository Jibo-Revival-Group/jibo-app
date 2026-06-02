package com.salesforce.android.cases.core.requests;

import com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest;

/* JADX INFO: loaded from: classes.dex */
public class CompleteCaseFeedRequest extends FetchSaveRequest {

    /* JADX INFO: renamed from: a */
    private final String f12581a;

    /* JADX INFO: renamed from: b */
    private final String f12582b;

    /* JADX INFO: renamed from: c */
    private final String f12583c;

    CompleteCaseFeedRequest(CompleteCaseFeedRequestBuilder completeCaseFeedRequestBuilder) {
        super(completeCaseFeedRequestBuilder);
        this.f12581a = completeCaseFeedRequestBuilder.f12584a;
        this.f12582b = completeCaseFeedRequestBuilder.f12585b;
        this.f12583c = completeCaseFeedRequestBuilder.f12586c;
    }

    /* JADX INFO: renamed from: a */
    public String m12649a() {
        return this.f12581a;
    }

    /* JADX INFO: renamed from: b */
    public String m12650b() {
        return this.f12582b;
    }

    /* JADX INFO: renamed from: c */
    public String m12651c() {
        return this.f12583c;
    }

    public static class CompleteCaseFeedRequestBuilder extends FetchSaveRequest.FetchSaveRequestBuilder<CompleteCaseFeedRequestBuilder> {

        /* JADX INFO: renamed from: a */
        private final String f12584a;

        /* JADX INFO: renamed from: b */
        private final String f12585b;

        /* JADX INFO: renamed from: c */
        private final String f12586c;

        public CompleteCaseFeedRequestBuilder(String str, String str2, String str3) {
            this.f12584a = str;
            this.f12585b = str2;
            this.f12586c = str3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CompleteCaseFeedRequestBuilder mo12627c() {
            return this;
        }

        /* JADX INFO: renamed from: b */
        public CompleteCaseFeedRequest m12656b() {
            return new CompleteCaseFeedRequest(this);
        }
    }
}
