package com.salesforce.android.knowledge.ui.internal.search;

import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.ui.internal.AbstractView;
import java.util.List;

interface SearchView extends AbstractView {
   void a(int var1);

   void a(CharSequence var1);

   void a(List<ArticleSummary> var1, boolean var2);

   void b(List<ArticleSummary> var1, boolean var2);

   void c();
}
