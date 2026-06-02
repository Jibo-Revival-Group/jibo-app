package com.salesforce.android.knowledge.p022ui.internal.models;

import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class EmptyArticleList implements ArticleList {

    /* JADX INFO: renamed from: a */
    private final List<ArticleSummary> f13368a = Collections.emptyList();

    @Override // com.salesforce.android.knowledge.core.model.ArticleList
    /* JADX INFO: renamed from: a */
    public List<ArticleSummary> mo13212a() {
        return this.f13368a;
    }

    @Override // com.salesforce.android.knowledge.core.model.ArticleList
    /* JADX INFO: renamed from: b */
    public int mo13213b() {
        return 0;
    }

    @Override // com.salesforce.android.knowledge.core.model.ArticleList
    /* JADX INFO: renamed from: c */
    public boolean mo13214c() {
        return false;
    }
}
