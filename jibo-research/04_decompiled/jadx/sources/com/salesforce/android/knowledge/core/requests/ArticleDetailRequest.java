package com.salesforce.android.knowledge.core.requests;

import com.salesforce.android.knowledge.core.KnowledgeClient;
import com.salesforce.android.knowledge.core.model.ArticleDetails;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.core.requests.KnowledgeRequest;
import com.salesforce.android.service.common.utilities.control.Async;

/* JADX INFO: loaded from: classes.dex */
public class ArticleDetailRequest extends KnowledgeRequest {

    /* JADX INFO: renamed from: a */
    final String f13036a;

    /* JADX INFO: renamed from: b */
    final boolean f13037b;

    ArticleDetailRequest(Builder builder) {
        super(builder);
        this.f13036a = builder.f13038a;
        this.f13037b = builder.f13039b;
    }

    /* JADX INFO: renamed from: a */
    public static Builder m13303a(ArticleSummary articleSummary) {
        return new Builder(articleSummary.mo13217g());
    }

    /* JADX INFO: renamed from: a */
    public String m13304a() {
        return this.f13036a;
    }

    /* JADX INFO: renamed from: b */
    public boolean m13305b() {
        return this.f13037b;
    }

    public static class Builder extends KnowledgeRequest.KnowledgeRequestBuilder<Builder> {

        /* JADX INFO: renamed from: a */
        final String f13038a;

        /* JADX INFO: renamed from: b */
        boolean f13039b = true;

        Builder(String str) {
            this.f13038a = str;
        }

        /* JADX INFO: renamed from: a */
        public Async<ArticleDetails> m13307a(KnowledgeClient knowledgeClient) {
            return knowledgeClient.mo13065a(m13306a());
        }

        /* JADX INFO: renamed from: a */
        public ArticleDetailRequest m13306a() {
            return new ArticleDetailRequest(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Builder mo12627c() {
            return this;
        }
    }
}
