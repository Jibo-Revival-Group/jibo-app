package com.salesforce.android.knowledge.ui.internal.articlelist;

import android.graphics.drawable.Drawable;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.ui.internal.toolbar.ToolbarPresenter;

public interface ArticleListPresenter extends ToolbarPresenter<ArticleListView> {
   void a();

   void a(ArticleSummary var1);

   Drawable b(ArticleSummary var1);
}
