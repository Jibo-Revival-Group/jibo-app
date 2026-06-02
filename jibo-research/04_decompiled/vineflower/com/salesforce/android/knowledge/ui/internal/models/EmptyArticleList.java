package com.salesforce.android.knowledge.ui.internal.models;

import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import java.util.Collections;
import java.util.List;

public class EmptyArticleList implements ArticleList {
   private final List<ArticleSummary> a = Collections.emptyList();

   @Override
   public List<ArticleSummary> a() {
      return this.a;
   }

   @Override
   public int b() {
      return 0;
   }

   @Override
   public boolean c() {
      return false;
   }
}
