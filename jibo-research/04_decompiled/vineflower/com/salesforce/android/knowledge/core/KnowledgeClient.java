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

public interface KnowledgeClient {
   Async<ArticleDetails> a(ArticleDetailRequest var1);

   Async<ArticleList> a(ArticleListRequest var1);

   Async<DataCategoryList> a(DataCategoriesRequest var1);

   Async<DataCategoryGroup> a(DataCategoryGroupRequest var1);

   String a();

   void a(LogoutListener var1);

   OfflineResourceCacher b();

   void c();
}
