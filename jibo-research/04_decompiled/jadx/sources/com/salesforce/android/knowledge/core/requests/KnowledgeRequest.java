package com.salesforce.android.knowledge.core.requests;

import com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest;

/* JADX INFO: loaded from: classes.dex */
public abstract class KnowledgeRequest extends FetchSaveRequest {

    public static abstract class KnowledgeRequestBuilder<T extends KnowledgeRequestBuilder<T>> extends FetchSaveRequest.FetchSaveRequestBuilder<T> {
    }

    protected KnowledgeRequest(KnowledgeRequestBuilder knowledgeRequestBuilder) {
        super(knowledgeRequestBuilder);
    }
}
