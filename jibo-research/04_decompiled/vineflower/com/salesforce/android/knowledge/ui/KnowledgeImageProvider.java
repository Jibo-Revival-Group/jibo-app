package com.salesforce.android.knowledge.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.core.model.DataCategorySummary;

public interface KnowledgeImageProvider {
   Drawable a(Context var1, ArticleSummary var2);

   Drawable a(Context var1, DataCategorySummary var2);
}
