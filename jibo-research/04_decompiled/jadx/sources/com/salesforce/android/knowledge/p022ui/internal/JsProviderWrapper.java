package com.salesforce.android.knowledge.p022ui.internal;

import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.p022ui.KnowledgeJsProvider;

/* JADX INFO: loaded from: classes.dex */
public class JsProviderWrapper implements KnowledgeJsProvider {

    /* JADX INFO: renamed from: a */
    private final KnowledgeJsProvider f13100a;

    private JsProviderWrapper(KnowledgeJsProvider knowledgeJsProvider) {
        this.f13100a = knowledgeJsProvider;
    }

    /* JADX INFO: renamed from: a */
    public static JsProviderWrapper m13412a(KnowledgeJsProvider knowledgeJsProvider) {
        return new JsProviderWrapper(knowledgeJsProvider);
    }

    @Override // com.salesforce.android.knowledge.p022ui.KnowledgeJsProvider
    /* JADX INFO: renamed from: a */
    public String mo13356a(ArticleSummary articleSummary) {
        String strMo13356a;
        return (this.f13100a == null || (strMo13356a = this.f13100a.mo13356a(articleSummary)) == null) ? "" : strMo13356a;
    }
}
