package com.salesforce.android.knowledge.core.internal.operations;

import com.salesforce.android.knowledge.core.internal.db.DbService;
import com.salesforce.android.knowledge.core.internal.http.HttpService;
import com.salesforce.android.knowledge.core.model.ArticleDetails;
import com.salesforce.android.knowledge.core.offline.OfflineResourceCacher;
import com.salesforce.android.knowledge.core.requests.ArticleDetailRequest;
import com.salesforce.android.service.common.utilities.control.Async;

class ArticleDetailsOp extends KnowledgeFetchSaveOp<ArticleDetailRequest, ArticleDetails> {
   private final OfflineResourceCacher a;

   ArticleDetailsOp(ArticleDetailRequest var1, DbService var2, HttpService var3, OfflineResourceCacher var4) {
      super(var1, var2, var3);
      this.a = var4;
   }

   protected Async<ArticleDetails> a(DbService var1, ArticleDetailRequest var2) {
      return var1.a(var2);
   }

   protected Async<Void> a(DbService var1, ArticleDetailRequest var2, ArticleDetails var3) {
      return var1.a(var3);
   }

   protected Async<ArticleDetails> a(HttpService var1, ArticleDetailRequest var2) {
      Async var3 = var1.a(var2);
      if (var2.b()) {
         var3.a(new Async.ResultHandler<ArticleDetails>(this) {
            final ArticleDetailsOp a;

            {
               this.a = var1;
            }

            public void a(Async<?> var1, ArticleDetails var2x) {
               this.a.a.a(var2x);
            }
         });
      }

      return var3;
   }

   @Override
   protected String b() {
      return "Could not fetch Article Details";
   }
}
