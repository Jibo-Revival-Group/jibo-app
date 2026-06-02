package com.salesforce.android.knowledge.core.internal.operations;

import com.salesforce.android.knowledge.core.internal.http.HttpService;
import com.salesforce.android.knowledge.core.internal.p021db.DbService;
import com.salesforce.android.knowledge.core.model.ArticleDetails;
import com.salesforce.android.knowledge.core.offline.OfflineResourceCacher;
import com.salesforce.android.knowledge.core.requests.ArticleDetailRequest;
import com.salesforce.android.service.common.utilities.control.Async;

/* JADX INFO: loaded from: classes.dex */
class ArticleDetailsOp extends KnowledgeFetchSaveOp<ArticleDetailRequest, ArticleDetails> {

    /* JADX INFO: renamed from: a */
    private final OfflineResourceCacher f12990a;

    ArticleDetailsOp(ArticleDetailRequest articleDetailRequest, DbService dbService, HttpService httpService, OfflineResourceCacher offlineResourceCacher) {
        super(articleDetailRequest, dbService, httpService);
        this.f12990a = offlineResourceCacher;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.knowledge.core.internal.operations.KnowledgeFetchSaveOp
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<ArticleDetails> mo13258a(DbService dbService, ArticleDetailRequest articleDetailRequest) {
        return dbService.m13134a(articleDetailRequest);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.knowledge.core.internal.operations.KnowledgeFetchSaveOp
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<ArticleDetails> mo13261a(HttpService httpService, ArticleDetailRequest articleDetailRequest) {
        Async<ArticleDetails> asyncM13149a = httpService.m13149a(articleDetailRequest);
        if (articleDetailRequest.m13305b()) {
            asyncM13149a.mo14074a(new Async.ResultHandler<ArticleDetails>() { // from class: com.salesforce.android.knowledge.core.internal.operations.ArticleDetailsOp.1
                @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
                /* JADX INFO: renamed from: a */
                public /* bridge */ /* synthetic */ void mo9875a(Async async, ArticleDetails articleDetails) {
                    a2((Async<?>) async, articleDetails);
                }

                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
                public void a2(Async<?> async, ArticleDetails articleDetails) {
                    ArticleDetailsOp.this.f12990a.m13294a(articleDetails);
                }
            });
        }
        return asyncM13149a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.knowledge.core.internal.operations.KnowledgeFetchSaveOp
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<Void> mo13259a(DbService dbService, ArticleDetailRequest articleDetailRequest, ArticleDetails articleDetails) {
        return dbService.m13132a(articleDetails);
    }

    @Override // com.salesforce.android.knowledge.core.internal.operations.KnowledgeFetchSaveOp
    /* JADX INFO: renamed from: b */
    protected String mo13262b() {
        return "Could not fetch Article Details";
    }
}
