package com.salesforce.android.knowledge.core.requests;

import com.salesforce.android.knowledge.core.KnowledgeClient;
import com.salesforce.android.knowledge.core.model.DataCategoryList;
import com.salesforce.android.knowledge.core.requests.KnowledgeRequest;
import com.salesforce.android.service.common.utilities.control.Async;

/* JADX INFO: loaded from: classes.dex */
public class DataCategoriesRequest extends KnowledgeRequest {

    /* JADX INFO: renamed from: a */
    private final String f13056a;

    /* JADX INFO: renamed from: b */
    private final String f13057b;

    DataCategoriesRequest(Builder builder) {
        super(builder);
        this.f13057b = builder.f13059b;
        this.f13056a = builder.f13058a;
    }

    /* JADX INFO: renamed from: a */
    public static Builder m13328a(String str, String str2) {
        return new Builder(str, str2);
    }

    /* JADX INFO: renamed from: a */
    public String m13329a() {
        return this.f13057b;
    }

    /* JADX INFO: renamed from: b */
    public String m13330b() {
        return this.f13056a;
    }

    public static class Builder extends KnowledgeRequest.KnowledgeRequestBuilder<Builder> {

        /* JADX INFO: renamed from: a */
        final String f13058a;

        /* JADX INFO: renamed from: b */
        final String f13059b;

        Builder(String str, String str2) {
            this.f13058a = str;
            this.f13059b = str2;
        }

        /* JADX INFO: renamed from: a */
        public Async<DataCategoryList> m13332a(KnowledgeClient knowledgeClient) {
            return knowledgeClient.mo13067a(m13331a());
        }

        /* JADX INFO: renamed from: a */
        public DataCategoriesRequest m13331a() {
            return new DataCategoriesRequest(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Builder mo12627c() {
            return this;
        }
    }
}
