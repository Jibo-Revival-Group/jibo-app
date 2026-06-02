package com.salesforce.android.knowledge.core.internal.operations;

import com.salesforce.android.knowledge.core.internal.db.DbService;
import com.salesforce.android.knowledge.core.internal.http.HttpService;
import com.salesforce.android.knowledge.core.internal.http.response.ArticlesResponse;
import com.salesforce.android.knowledge.core.internal.model.ArticleListModel;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.core.requests.ArticleListRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.functional.Function;

class ArticlesOp extends KnowledgeFetchSaveOp<ArticleListRequest, ArticleList> {
   public ArticlesOp(ArticleListRequest var1, DbService var2, HttpService var3) {
      super(var1, var2, var3);
   }

   protected Async<ArticleList> a(DbService var1, ArticleListRequest var2) {
      return var1.a(var2);
   }

   protected Async<Void> a(DbService var1, ArticleListRequest var2, ArticleList var3) {
      return var1.a(var2, var3);
   }

   protected Async<ArticleList> a(HttpService var1, ArticleListRequest var2) {
      return var1.a(var2).a(new Function<ArticlesResponse, ArticleList>(this, var2) {
         final ArticleListRequest a;
         final ArticlesOp b;

         {
            this.b = var1;
            this.a = var2x;
         }

         public ArticleList a(ArticlesResponse var1) {
            return ArticleListModel.a(this.a, var1);
         }
      });
   }

   @Override
   protected String b() {
      return "Could not fetch Articles";
   }
}
