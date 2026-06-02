package com.salesforce.android.knowledge.p022ui.internal.navigation;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import com.salesforce.android.knowledge.p022ui.internal.ViewBinder;
import com.salesforce.android.knowledge.p022ui.internal.articledetail.ArticleDetailPresenter;
import com.salesforce.android.knowledge.p022ui.internal.articledetail.ArticleDetailViewBinder;
import com.salesforce.android.knowledge.p022ui.internal.articlelist.ArticleListPresenter;
import com.salesforce.android.knowledge.p022ui.internal.articlelist.ArticleListViewBinder;
import com.salesforce.android.knowledge.p022ui.internal.categorydetail.CategoryDetailPresenter;
import com.salesforce.android.knowledge.p022ui.internal.categorydetail.CategoryDetailViewBinder;
import com.salesforce.android.knowledge.p022ui.internal.home.HomePresenter;
import com.salesforce.android.knowledge.p022ui.internal.home.HomeViewBinder;
import com.salesforce.android.knowledge.p022ui.internal.presenter.Presenter;
import com.salesforce.android.knowledge.p022ui.internal.search.SearchPresenter;
import com.salesforce.android.knowledge.p022ui.internal.search.SearchViewBinder;

/* JADX INFO: loaded from: classes.dex */
public class ViewBinderFactory {
    /* JADX INFO: renamed from: a */
    public ViewBinder m13651a(Context context, Presenter<?> presenter) {
        if (presenter instanceof HomePresenter) {
            return HomeViewBinder.m13581a(context, (HomePresenter) presenter);
        }
        if (presenter instanceof ArticleDetailPresenter) {
            return ArticleDetailViewBinder.m13455a((ArticleDetailPresenter) presenter);
        }
        if (presenter instanceof ArticleListPresenter) {
            return ArticleListViewBinder.m13475a(context, (ArticleListPresenter) presenter);
        }
        if (presenter instanceof CategoryDetailPresenter) {
            return CategoryDetailViewBinder.m13518a((CategoryDetailPresenter) presenter);
        }
        if (presenter instanceof SearchPresenter) {
            return SearchViewBinder.m13683a((SearchPresenter) presenter, (InputMethodManager) context.getSystemService("input_method"));
        }
        throw new IllegalArgumentException("Unknown Presenter type");
    }
}
