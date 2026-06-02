package com.salesforce.android.knowledge.core.internal.operations;

import com.salesforce.android.knowledge.core.internal.db.DbService;
import com.salesforce.android.knowledge.core.internal.http.HttpService;
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

public class OperationFactory {
   public Operation<ArticleDetails> a(ArticleDetailRequest var1, DbService var2, HttpService var3, OfflineResourceCacher var4) {
      return new ArticleDetailsOp(var1, var2, var3, var4);
   }

   public Operation<ArticleList> a(ArticleListRequest var1, DbService var2, HttpService var3) {
      return new ArticlesOp(var1, var2, var3);
   }

   public Operation<DataCategoryList> a(DataCategoriesRequest var1, DbService var2, HttpService var3) {
      return new DataCategoriesOp(var1, var2, var3);
   }

   public Operation<DataCategoryGroup> a(DataCategoryGroupRequest var1, DbService var2, HttpService var3) {
      return new DataCategoryGroupOp(var1, var2, var3);
   }
}
