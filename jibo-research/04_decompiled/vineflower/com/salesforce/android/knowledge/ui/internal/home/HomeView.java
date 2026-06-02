package com.salesforce.android.knowledge.ui.internal.home;

import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.ui.internal.AbstractView;
import com.salesforce.android.knowledge.ui.internal.models.DataCategoryInfo;
import java.util.List;

public interface HomeView extends AbstractView {
   void a(int var1);

   void a(DataCategoryInfo var1);

   void a(DataCategoryInfo var1, ArticleList var2);

   void a(List<DataCategoryInfo> var1);
}
