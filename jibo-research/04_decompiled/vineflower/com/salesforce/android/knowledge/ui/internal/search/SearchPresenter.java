package com.salesforce.android.knowledge.ui.internal.search;

import android.graphics.drawable.Drawable;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.ui.internal.presenter.Presenter;

public interface SearchPresenter extends Presenter<SearchView> {
   void a();

   void a(ArticleSummary var1);

   void a(CharSequence var1);

   Drawable b(ArticleSummary var1);
}
