package com.salesforce.android.knowledge.p022ui.internal.presenter;

import android.content.Context;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.p022ui.internal.articledetail.ArticleDetailPresenter;
import com.salesforce.android.knowledge.p022ui.internal.articledetail.ArticleDetailPresenterImpl;
import com.salesforce.android.knowledge.p022ui.internal.articlelist.ArticleListPresenter;
import com.salesforce.android.knowledge.p022ui.internal.articlelist.ArticleListPresenterImpl;
import com.salesforce.android.knowledge.p022ui.internal.categorydetail.CategoryDetailPresenter;
import com.salesforce.android.knowledge.p022ui.internal.categorydetail.CategoryDetailPresenterImpl;
import com.salesforce.android.knowledge.p022ui.internal.client.KnowledgeUIClientImpl;
import com.salesforce.android.knowledge.p022ui.internal.home.HomePresenter;
import com.salesforce.android.knowledge.p022ui.internal.home.HomePresenterImpl;
import com.salesforce.android.knowledge.p022ui.internal.models.DataCategoryInfo;
import com.salesforce.android.knowledge.p022ui.internal.search.SearchPresenter;
import com.salesforce.android.knowledge.p022ui.internal.search.SearchPresenterImpl;

/* JADX INFO: loaded from: classes.dex */
public class PresenterFactory {

    /* JADX INFO: renamed from: a */
    private final KnowledgeUIClientImpl f13383a;

    /* JADX INFO: renamed from: a */
    public static PresenterFactory m13655a(KnowledgeUIClientImpl knowledgeUIClientImpl) {
        return new PresenterFactory(knowledgeUIClientImpl);
    }

    private PresenterFactory(KnowledgeUIClientImpl knowledgeUIClientImpl) {
        this.f13383a = knowledgeUIClientImpl;
    }

    /* JADX INFO: renamed from: a */
    public HomePresenter m13658a(Context context, String str) {
        return HomePresenterImpl.m13569a(this.f13383a, str).m13573a(context).m13572a();
    }

    /* JADX INFO: renamed from: a */
    public ArticleDetailPresenter m13656a(ArticleSummary articleSummary) {
        return ArticleDetailPresenterImpl.m13437a(this.f13383a, articleSummary).m13450a();
    }

    /* JADX INFO: renamed from: a */
    public ArticleListPresenter m13657a(DataCategoryInfo dataCategoryInfo) {
        return ArticleListPresenterImpl.m13465a(this.f13383a, dataCategoryInfo);
    }

    /* JADX INFO: renamed from: b */
    public CategoryDetailPresenter m13660b(DataCategoryInfo dataCategoryInfo) {
        return CategoryDetailPresenterImpl.m13506a(this.f13383a, dataCategoryInfo);
    }

    /* JADX INFO: renamed from: a */
    public SearchPresenter m13659a() {
        return SearchPresenterImpl.m13674a(this.f13383a);
    }
}
