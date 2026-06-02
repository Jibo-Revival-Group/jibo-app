package com.salesforce.android.knowledge.ui.internal.articledetail;

import android.graphics.drawable.Drawable;
import com.salesforce.android.knowledge.core.model.ArticleDetails;
import com.salesforce.android.knowledge.ui.KnowledgeUIClient;
import com.salesforce.android.knowledge.ui.internal.AbstractView;
import com.salesforce.android.knowledge.ui.internal.toolbar.ToolbarView;
import com.salesforce.android.service.common.utilities.control.Async;

interface ArticleDetailView extends AbstractView, ToolbarView {
   Async<Void> a(KnowledgeUIClient var1, ArticleDetails var2);

   void a(int var1);

   void a(Drawable var1);

   void a(String var1);
}
