package com.salesforce.android.knowledge.ui.internal.articlelist;

import android.graphics.drawable.Drawable;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.ui.internal.AbstractView;
import com.salesforce.android.knowledge.ui.internal.toolbar.ToolbarView;
import java.util.List;

public interface ArticleListView extends AbstractView, ToolbarView {
   void a(int var1);

   void a(Drawable var1);

   void a(String var1);

   void a(List<ArticleSummary> var1, boolean var2);
}
