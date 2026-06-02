package com.salesforce.android.cases.core.requests;

import com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest;

/* JADX INFO: loaded from: classes.dex */
public class DefaultValuesRequest extends FetchSaveRequest {

    /* JADX INFO: renamed from: a */
    private String f12593a;

    DefaultValuesRequest(DefaultValuesRequestBuilder defaultValuesRequestBuilder) {
        super(defaultValuesRequestBuilder);
        this.f12593a = defaultValuesRequestBuilder.f12594a;
    }

    /* JADX INFO: renamed from: a */
    public static DefaultValuesRequest m12668a(String str) {
        return new DefaultValuesRequestBuilder(str).mo12687c(true).mo12688d(true).m12672b();
    }

    /* JADX INFO: renamed from: a */
    public String m12669a() {
        return this.f12593a;
    }

    public static class DefaultValuesRequestBuilder extends FetchSaveRequest.FetchSaveRequestBuilder<DefaultValuesRequestBuilder> {

        /* JADX INFO: renamed from: a */
        private final String f12594a;

        public DefaultValuesRequestBuilder(String str) {
            this.f12594a = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DefaultValuesRequestBuilder mo12627c() {
            return this;
        }

        /* JADX INFO: renamed from: b */
        public DefaultValuesRequest m12672b() {
            return new DefaultValuesRequest(this);
        }
    }
}
