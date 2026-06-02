package com.salesforce.android.knowledge.core.internal.model;

import com.salesforce.android.knowledge.core.internal.http.response.ArticlesResponse;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.core.requests.ArticleListRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArticleListModel implements ArticleList {
   private final List<ArticleSummary> a;
   private final int b;
   private final boolean c;

   private ArticleListModel(ArticleListRequest var1, List<ArticleSummaryModel> var2, boolean var3) {
      ArrayList var4 = new ArrayList(var2.size());
      var4.addAll(var2);
      this.a = Collections.unmodifiableList(var4);
      this.b = var1.b();
      this.c = var3;
   }

   public static ArticleListModel a(ArticleListRequest var0, ArticlesResponse var1) {
      List var4 = var1.b();
      ArrayList var3 = new ArrayList(var4.size());
      Iterator var5 = var4.iterator();

      while (var5.hasNext()) {
         var3.add(ArticleSummaryModel.a((ArticlesResponse.Article)var5.next()));
      }

      boolean var2;
      if (var1.a() != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      return new ArticleListModel(var0, var3, var2);
   }

   public static ArticleListModel a(ArticleListRequest var0, List<ArticleSummaryModel> var1, boolean var2) {
      return new ArticleListModel(var0, var1, var2);
   }

   @Override
   public List<ArticleSummary> a() {
      return this.a;
   }

   @Override
   public int b() {
      return this.b;
   }

   @Override
   public boolean c() {
      return this.c;
   }
}
