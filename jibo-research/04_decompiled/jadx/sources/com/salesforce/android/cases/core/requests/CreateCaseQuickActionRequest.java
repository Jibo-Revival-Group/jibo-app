package com.salesforce.android.cases.core.requests;

import com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest;

/* JADX INFO: loaded from: classes.dex */
public class CreateCaseQuickActionRequest extends FetchSaveRequest {

    /* JADX INFO: renamed from: a */
    private final String f12587a;

    CreateCaseQuickActionRequest(CreateCaseQuickActionRequestBuilder createCaseQuickActionRequestBuilder) {
        super(createCaseQuickActionRequestBuilder);
        this.f12587a = createCaseQuickActionRequestBuilder.f12588a;
    }

    /* JADX INFO: renamed from: a */
    public static CreateCaseQuickActionRequest m12657a(String str) {
        return new CreateCaseQuickActionRequestBuilder(str).mo12687c(true).mo12688d(true).m12661b();
    }

    /* JADX INFO: renamed from: a */
    public String m12658a() {
        return this.f12587a;
    }

    public static class CreateCaseQuickActionRequestBuilder extends FetchSaveRequest.FetchSaveRequestBuilder<CreateCaseQuickActionRequestBuilder> {

        /* JADX INFO: renamed from: a */
        private final String f12588a;

        public CreateCaseQuickActionRequestBuilder(String str) {
            this.f12588a = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CreateCaseQuickActionRequestBuilder mo12627c() {
            return this;
        }

        /* JADX INFO: renamed from: b */
        public CreateCaseQuickActionRequest m12661b() {
            return new CreateCaseQuickActionRequest(this);
        }
    }
}
