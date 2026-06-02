package com.salesforce.android.knowledge.core.requests;

import com.salesforce.android.knowledge.core.KnowledgeClient;
import com.salesforce.android.knowledge.core.model.DataCategoryGroup;
import com.salesforce.android.knowledge.core.requests.KnowledgeRequest;
import com.salesforce.android.service.common.utilities.control.Async;

/* JADX INFO: loaded from: classes.dex */
public class DataCategoryGroupRequest extends KnowledgeRequest {

    /* JADX INFO: renamed from: a */
    private final String f13060a;

    DataCategoryGroupRequest(Builder builder) {
        super(builder);
        this.f13060a = builder.f13061a;
    }

    /* JADX INFO: renamed from: a */
    public static Builder m13334a(String str) {
        return new Builder(str);
    }

    /* JADX INFO: renamed from: a */
    public String m13335a() {
        return this.f13060a;
    }

    public static class Builder extends KnowledgeRequest.KnowledgeRequestBuilder<Builder> {

        /* JADX INFO: renamed from: a */
        final String f13061a;

        Builder(String str) {
            this.f13061a = str;
        }

        /* JADX INFO: renamed from: a */
        public Async<DataCategoryGroup> m13337a(KnowledgeClient knowledgeClient) {
            return knowledgeClient.mo13068a(m13336a());
        }

        /* JADX INFO: renamed from: a */
        public DataCategoryGroupRequest m13336a() {
            return new DataCategoryGroupRequest(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Builder mo12627c() {
            return this;
        }
    }
}
