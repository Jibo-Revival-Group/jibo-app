package com.salesforce.android.knowledge.ui.internal.presenter;

import android.content.Context;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.ui.internal.articledetail.ArticleDetailPresenter;
import com.salesforce.android.knowledge.ui.internal.articledetail.ArticleDetailPresenterImpl;
import com.salesforce.android.knowledge.ui.internal.articlelist.ArticleListPresenter;
import com.salesforce.android.knowledge.ui.internal.articlelist.ArticleListPresenterImpl;
import com.salesforce.android.knowledge.ui.internal.categorydetail.CategoryDetailPresenter;
import com.salesforce.android.knowledge.ui.internal.categorydetail.CategoryDetailPresenterImpl;
import com.salesforce.android.knowledge.ui.internal.client.KnowledgeUIClientImpl;
import com.salesforce.android.knowledge.ui.internal.home.HomePresenter;
import com.salesforce.android.knowledge.ui.internal.home.HomePresenterImpl;
import com.salesforce.android.knowledge.ui.internal.models.DataCategoryInfo;
import com.salesforce.android.knowledge.ui.internal.search.SearchPresenter;
import com.salesforce.android.knowledge.ui.internal.search.SearchPresenterImpl;

public class PresenterFactory {
   private final KnowledgeUIClientImpl a;

   private PresenterFactory(KnowledgeUIClientImpl var1) {
      this.a = var1;
   }

   public static PresenterFactory a(KnowledgeUIClientImpl var0) {
      return new PresenterFactory(var0);
   }

   public ArticleDetailPresenter a(ArticleSummary var1) {
      return ArticleDetailPresenterImpl.a(this.a, var1).a();
   }

   public ArticleListPresenter a(DataCategoryInfo var1) {
      return ArticleListPresenterImpl.a(this.a, var1);
   }

   public HomePresenter a(Context var1, String var2) {
      return HomePresenterImpl.a(this.a, var2).a(var1).a();
   }

   public SearchPresenter a() {
      return SearchPresenterImpl.a(this.a);
   }

   public CategoryDetailPresenter b(DataCategoryInfo var1) {
      return CategoryDetailPresenterImpl.a(this.a, var1);
   }
}
