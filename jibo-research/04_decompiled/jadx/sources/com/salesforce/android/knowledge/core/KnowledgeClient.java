package com.salesforce.android.knowledge.core;

import com.salesforce.android.knowledge.core.model.ArticleDetails;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.core.model.DataCategoryGroup;
import com.salesforce.android.knowledge.core.model.DataCategoryList;
import com.salesforce.android.knowledge.core.offline.OfflineResourceCacher;
import com.salesforce.android.knowledge.core.requests.ArticleDetailRequest;
import com.salesforce.android.knowledge.core.requests.ArticleListRequest;
import com.salesforce.android.knowledge.core.requests.DataCategoriesRequest;
import com.salesforce.android.knowledge.core.requests.DataCategoryGroupRequest;
import com.salesforce.android.service.common.utilities.control.Async;

/* JADX INFO: loaded from: classes.dex */
public interface KnowledgeClient {
    /* JADX INFO: renamed from: a */
    Async<ArticleDetails> mo13065a(ArticleDetailRequest articleDetailRequest);

    /* JADX INFO: renamed from: a */
    Async<ArticleList> mo13066a(ArticleListRequest articleListRequest);

    /* JADX INFO: renamed from: a */
    Async<DataCategoryList> mo13067a(DataCategoriesRequest dataCategoriesRequest);

    /* JADX INFO: renamed from: a */
    Async<DataCategoryGroup> mo13068a(DataCategoryGroupRequest dataCategoryGroupRequest);

    /* JADX INFO: renamed from: a */
    String mo13069a();

    /* JADX INFO: renamed from: a */
    void mo13070a(LogoutListener logoutListener);

    /* JADX INFO: renamed from: b */
    OfflineResourceCacher mo13071b();

    /* JADX INFO: renamed from: c */
    void mo13072c();
}
