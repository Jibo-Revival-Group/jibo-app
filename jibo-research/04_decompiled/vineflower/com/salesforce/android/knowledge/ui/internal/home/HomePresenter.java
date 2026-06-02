package com.salesforce.android.knowledge.ui.internal.home;

import android.graphics.drawable.Drawable;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.ui.internal.models.DataCategoryInfo;
import com.salesforce.android.knowledge.ui.internal.presenter.Presenter;

public interface HomePresenter extends Presenter<HomeView> {
   void a();

   void a(ArticleSummary var1);

   void a(DataCategoryInfo var1);

   Drawable b(ArticleSummary var1);

   void b(DataCategoryInfo var1);

   boolean c(DataCategoryInfo var1);

   void d();
}
