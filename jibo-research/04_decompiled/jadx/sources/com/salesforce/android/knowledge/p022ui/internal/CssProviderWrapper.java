package com.salesforce.android.knowledge.p022ui.internal;

import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.p022ui.KnowledgeCssProvider;

/* JADX INFO: loaded from: classes.dex */
public class CssProviderWrapper implements KnowledgeCssProvider {

    /* JADX INFO: renamed from: a */
    private final KnowledgeCssProvider f13098a;

    private CssProviderWrapper(KnowledgeCssProvider knowledgeCssProvider) {
        this.f13098a = knowledgeCssProvider;
    }

    /* JADX INFO: renamed from: a */
    public static CssProviderWrapper m13410a(KnowledgeCssProvider knowledgeCssProvider) {
        return new CssProviderWrapper(knowledgeCssProvider);
    }

    @Override // com.salesforce.android.knowledge.p022ui.KnowledgeCssProvider
    /* JADX INFO: renamed from: a */
    public String mo13353a(ArticleSummary articleSummary) {
        String strMo13353a;
        return (this.f13098a == null || (strMo13353a = this.f13098a.mo13353a(articleSummary)) == null) ? "" : strMo13353a;
    }
}
