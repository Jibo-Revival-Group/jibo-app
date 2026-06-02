package com.salesforce.android.knowledge.core.internal.operations;

import com.salesforce.android.knowledge.core.internal.http.HttpService;
import com.salesforce.android.knowledge.core.internal.http.response.ArticlesResponse;
import com.salesforce.android.knowledge.core.internal.model.ArticleListModel;
import com.salesforce.android.knowledge.core.internal.p021db.DbService;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.core.requests.ArticleListRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.functional.Function;

/* JADX INFO: loaded from: classes.dex */
class ArticlesOp extends KnowledgeFetchSaveOp<ArticleListRequest, ArticleList> {
    public ArticlesOp(ArticleListRequest articleListRequest, DbService dbService, HttpService httpService) {
        super(articleListRequest, dbService, httpService);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.knowledge.core.internal.operations.KnowledgeFetchSaveOp
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<ArticleList> mo13258a(DbService dbService, ArticleListRequest articleListRequest) {
        return dbService.m13135a(articleListRequest);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.knowledge.core.internal.operations.KnowledgeFetchSaveOp
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<ArticleList> mo13261a(HttpService httpService, final ArticleListRequest articleListRequest) {
        return httpService.m13150a(articleListRequest).mo14076a(new Function<ArticlesResponse, ArticleList>() { // from class: com.salesforce.android.knowledge.core.internal.operations.ArticlesOp.1
            @Override // com.salesforce.android.service.common.utilities.functional.Function
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public ArticleList mo12236a(ArticlesResponse articlesResponse) {
                return ArticleListModel.m13210a(articleListRequest, articlesResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.knowledge.core.internal.operations.KnowledgeFetchSaveOp
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<Void> mo13259a(DbService dbService, ArticleListRequest articleListRequest, ArticleList articleList) {
        return dbService.m13136a(articleListRequest, articleList);
    }

    @Override // com.salesforce.android.knowledge.core.internal.operations.KnowledgeFetchSaveOp
    /* JADX INFO: renamed from: b */
    protected String mo13262b() {
        return "Could not fetch Articles";
    }
}
