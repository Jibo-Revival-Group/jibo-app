package com.salesforce.android.knowledge.ui.internal.categorydetail;

import android.graphics.drawable.Drawable;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.ui.internal.models.DataCategoryInfo;
import com.salesforce.android.knowledge.ui.internal.toolbar.ToolbarPresenter;

public interface CategoryDetailPresenter extends ToolbarPresenter<CategoryDetailView> {
   void a();

   void a(ArticleSummary var1);

   void a(DataCategoryInfo var1);

   Drawable b(ArticleSummary var1);
}
