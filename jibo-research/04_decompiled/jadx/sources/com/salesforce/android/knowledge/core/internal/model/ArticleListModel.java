package com.salesforce.android.knowledge.core.internal.model;

import com.salesforce.android.knowledge.core.internal.http.response.ArticlesResponse;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.core.requests.ArticleListRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ArticleListModel implements ArticleList {

    /* JADX INFO: renamed from: a */
    private final List<ArticleSummary> f12961a;

    /* JADX INFO: renamed from: b */
    private final int f12962b;

    /* JADX INFO: renamed from: c */
    private final boolean f12963c;

    private ArticleListModel(ArticleListRequest articleListRequest, List<ArticleSummaryModel> list, boolean z) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        this.f12961a = Collections.unmodifiableList(arrayList);
        this.f12962b = articleListRequest.m13310b();
        this.f12963c = z;
    }

    /* JADX INFO: renamed from: a */
    public static ArticleListModel m13210a(ArticleListRequest articleListRequest, ArticlesResponse articlesResponse) {
        List<ArticlesResponse.Article> listM13179b = articlesResponse.m13179b();
        ArrayList arrayList = new ArrayList(listM13179b.size());
        Iterator<ArticlesResponse.Article> it = listM13179b.iterator();
        while (it.hasNext()) {
            arrayList.add(ArticleSummaryModel.m13215a(it.next()));
        }
        return new ArticleListModel(articleListRequest, arrayList, articlesResponse.m13178a() != null);
    }

    /* JADX INFO: renamed from: a */
    public static ArticleListModel m13211a(ArticleListRequest articleListRequest, List<ArticleSummaryModel> list, boolean z) {
        return new ArticleListModel(articleListRequest, list, z);
    }

    @Override // com.salesforce.android.knowledge.core.model.ArticleList
    /* JADX INFO: renamed from: a */
    public List<ArticleSummary> mo13212a() {
        return this.f12961a;
    }

    @Override // com.salesforce.android.knowledge.core.model.ArticleList
    /* JADX INFO: renamed from: b */
    public int mo13213b() {
        return this.f12962b;
    }

    @Override // com.salesforce.android.knowledge.core.model.ArticleList
    /* JADX INFO: renamed from: c */
    public boolean mo13214c() {
        return this.f12963c;
    }
}
