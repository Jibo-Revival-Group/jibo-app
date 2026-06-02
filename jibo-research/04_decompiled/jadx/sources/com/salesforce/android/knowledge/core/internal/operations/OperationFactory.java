package com.salesforce.android.knowledge.core.internal.operations;

import com.salesforce.android.knowledge.core.internal.http.HttpService;
import com.salesforce.android.knowledge.core.internal.p021db.DbService;
import com.salesforce.android.knowledge.core.model.ArticleDetails;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.core.model.DataCategoryGroup;
import com.salesforce.android.knowledge.core.model.DataCategoryList;
import com.salesforce.android.knowledge.core.offline.OfflineResourceCacher;
import com.salesforce.android.knowledge.core.requests.ArticleDetailRequest;
import com.salesforce.android.knowledge.core.requests.ArticleListRequest;
import com.salesforce.android.knowledge.core.requests.DataCategoriesRequest;
import com.salesforce.android.knowledge.core.requests.DataCategoryGroupRequest;
import com.salesforce.android.service.common.fetchsave.internal.operations.Operation;

/* JADX INFO: loaded from: classes.dex */
public class OperationFactory {
    /* JADX INFO: renamed from: a */
    public Operation<ArticleList> m13270a(ArticleListRequest articleListRequest, DbService dbService, HttpService httpService) {
        return new ArticlesOp(articleListRequest, dbService, httpService);
    }

    /* JADX INFO: renamed from: a */
    public Operation<DataCategoryGroup> m13272a(DataCategoryGroupRequest dataCategoryGroupRequest, DbService dbService, HttpService httpService) {
        return new DataCategoryGroupOp(dataCategoryGroupRequest, dbService, httpService);
    }

    /* JADX INFO: renamed from: a */
    public Operation<ArticleDetails> m13269a(ArticleDetailRequest articleDetailRequest, DbService dbService, HttpService httpService, OfflineResourceCacher offlineResourceCacher) {
        return new ArticleDetailsOp(articleDetailRequest, dbService, httpService, offlineResourceCacher);
    }

    /* JADX INFO: renamed from: a */
    public Operation<DataCategoryList> m13271a(DataCategoriesRequest dataCategoriesRequest, DbService dbService, HttpService httpService) {
        return new DataCategoriesOp(dataCategoriesRequest, dbService, httpService);
    }
}
