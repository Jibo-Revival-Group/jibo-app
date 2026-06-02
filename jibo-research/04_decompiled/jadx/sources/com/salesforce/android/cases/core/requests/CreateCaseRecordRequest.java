package com.salesforce.android.cases.core.requests;

import com.salesforce.android.cases.core.model.CreateCaseRecord;

/* JADX INFO: loaded from: classes.dex */
public class CreateCaseRecordRequest extends FetchSaveRequest {

    /* JADX INFO: renamed from: a */
    private final String f12589a;

    /* JADX INFO: renamed from: b */
    private final CreateCaseRecord f12590b;

    CreateCaseRecordRequest(NewCaseRecordRequestBuilder newCaseRecordRequestBuilder) {
        super(newCaseRecordRequestBuilder);
        this.f12589a = newCaseRecordRequestBuilder.f12591a;
        this.f12590b = newCaseRecordRequestBuilder.f12592b;
    }

    /* JADX INFO: renamed from: a */
    public String m12662a() {
        return this.f12589a;
    }

    /* JADX INFO: renamed from: b */
    public CreateCaseRecord m12663b() {
        return this.f12590b;
    }

    public static class NewCaseRecordRequestBuilder extends NoCacheRequestBuilder<NewCaseRecordRequestBuilder> {

        /* JADX INFO: renamed from: a */
        private final String f12591a;

        /* JADX INFO: renamed from: b */
        private final CreateCaseRecord f12592b;

        public NewCaseRecordRequestBuilder(String str, CreateCaseRecord createCaseRecord) {
            this.f12591a = str;
            this.f12592b = createCaseRecord;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public NewCaseRecordRequestBuilder mo12627c() {
            return this;
        }

        /* JADX INFO: renamed from: b */
        public CreateCaseRecordRequest m12667b() {
            return new CreateCaseRecordRequest(this);
        }
    }
}
