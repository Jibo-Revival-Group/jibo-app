package com.salesforce.android.knowledge.ui.internal.navigation;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import com.salesforce.android.knowledge.ui.internal.ViewBinder;
import com.salesforce.android.knowledge.ui.internal.articledetail.ArticleDetailPresenter;
import com.salesforce.android.knowledge.ui.internal.articledetail.ArticleDetailViewBinder;
import com.salesforce.android.knowledge.ui.internal.articlelist.ArticleListPresenter;
import com.salesforce.android.knowledge.ui.internal.articlelist.ArticleListViewBinder;
import com.salesforce.android.knowledge.ui.internal.categorydetail.CategoryDetailPresenter;
import com.salesforce.android.knowledge.ui.internal.categorydetail.CategoryDetailViewBinder;
import com.salesforce.android.knowledge.ui.internal.home.HomePresenter;
import com.salesforce.android.knowledge.ui.internal.home.HomeViewBinder;
import com.salesforce.android.knowledge.ui.internal.presenter.Presenter;
import com.salesforce.android.knowledge.ui.internal.search.SearchPresenter;
import com.salesforce.android.knowledge.ui.internal.search.SearchViewBinder;

public class ViewBinderFactory {
   public ViewBinder a(Context var1, Presenter<?> var2) {
      ViewBinder var3;
      if (var2 instanceof HomePresenter) {
         var3 = HomeViewBinder.a(var1, (HomePresenter)var2);
      } else if (var2 instanceof ArticleDetailPresenter) {
         var3 = ArticleDetailViewBinder.a((ArticleDetailPresenter)var2);
      } else if (var2 instanceof ArticleListPresenter) {
         var3 = ArticleListViewBinder.a(var1, (ArticleListPresenter)var2);
      } else if (var2 instanceof CategoryDetailPresenter) {
         var3 = CategoryDetailViewBinder.a((CategoryDetailPresenter)var2);
      } else {
         if (!(var2 instanceof SearchPresenter)) {
            throw new IllegalArgumentException("Unknown Presenter type");
         }

         var3 = SearchViewBinder.a((SearchPresenter)var2, (InputMethodManager)var1.getSystemService("input_method"));
      }

      return var3;
   }
}
