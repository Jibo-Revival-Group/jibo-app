package com.salesforce.android.knowledge.ui.internal.navigation;

import android.content.Context;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.ui.KnowledgeScene;
import com.salesforce.android.knowledge.ui.KnowledgeUIAnalyticsEmit;
import com.salesforce.android.knowledge.ui.internal.articledetail.ArticleDetailPresenter;
import com.salesforce.android.knowledge.ui.internal.articlelist.ArticleListPresenter;
import com.salesforce.android.knowledge.ui.internal.categorydetail.CategoryDetailPresenter;
import com.salesforce.android.knowledge.ui.internal.client.KnowledgeUIClientImpl;
import com.salesforce.android.knowledge.ui.internal.home.HomePresenter;
import com.salesforce.android.knowledge.ui.internal.models.DataCategoryInfo;
import com.salesforce.android.knowledge.ui.internal.presenter.Presenter;
import com.salesforce.android.knowledge.ui.internal.search.SearchPresenter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Navigator {
   private final KnowledgeUIClientImpl a;
   private final NavigationStack b;
   private final ViewBinderFactory c;
   private final Set<Navigator.Listener> d;

   Navigator(Navigator.Builder var1) {
      this.a = var1.a;
      this.b = var1.b;
      this.c = var1.c;
      this.d = Collections.unmodifiableSet(new HashSet<>(var1.d));
   }

   public static Navigator.Builder a(KnowledgeUIClientImpl var0) {
      return new Navigator.Builder(var0);
   }

   private void a(KnowledgeScene var1, KnowledgeScene var2) {
      Iterator var3 = this.d.iterator();

      while (var3.hasNext()) {
         ((Navigator.Listener)var3.next()).a(var1, var2);
      }
   }

   private void a(KnowledgeScene var1, Presenter<?> var2) {
      KnowledgeScene var3;
      if (this.b.isEmpty()) {
         var3 = KnowledgeScene.SCENE_NONE;
      } else {
         var3 = this.b.peek().b();
      }

      this.b.a(new NavigationStack.Entry(var1, var2));
      this.a(var3, var1);
   }

   private void b(KnowledgeScene var1, KnowledgeScene var2) {
      KnowledgeUIAnalyticsEmit.a(var1, var2);
      Iterator var3 = this.d.iterator();

      while (var3.hasNext()) {
         ((Navigator.Listener)var3.next()).b(var1, var2);
      }
   }

   public ViewState a(Context var1) {
      NavigationStack.Entry var2 = this.b.peek();
      return new ViewState(this.c.a(var1, var2.a()), var2.c());
   }

   public void a() {
      this.b.a(KnowledgeScene.SCENE_SEARCH);
      SearchPresenter var1 = this.a.h().a();
      this.a(KnowledgeScene.SCENE_SEARCH, var1);
   }

   public void a(Context var1, String var2) {
      if (this.b.isEmpty()) {
         this.b(var1, var2);
      }
   }

   public void a(ArticleSummary var1) {
      ArticleDetailPresenter var2 = this.a.h().a(var1);
      this.a(KnowledgeScene.SCENE_ARTICLE_DETAIL, var2);
   }

   public void a(DataCategoryInfo var1) {
      ArticleListPresenter var2 = this.a.h().a(var1);
      this.a(KnowledgeScene.SCENE_ARTICLE_LIST, var2);
   }

   public void b(Context var1, String var2) {
      HomePresenter var3 = this.a.h().a(var1, var2);
      this.a(KnowledgeScene.SCENE_HOME, var3);
   }

   public void b(DataCategoryInfo var1) {
      CategoryDetailPresenter var2 = this.a.h().b(var1);
      this.a(KnowledgeScene.SCENE_CATEGORY_DETAIL, var2);
   }

   public boolean b() {
      NavigationStack.Entry var2 = this.b.b();
      boolean var1;
      if (var2 != null && var2.b() == KnowledgeScene.SCENE_HOME) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean c() {
      return this.b.isEmpty();
   }

   public void d() {
      if (!this.c()) {
         this.b(this.b.c().b(), this.b.a());
      }
   }

   public KnowledgeScene e() {
      return this.b.a();
   }

   public void f() {
      while (!this.b.isEmpty()) {
         this.b.c();
      }
   }

   public static class Builder {
      final KnowledgeUIClientImpl a;
      NavigationStack b;
      ViewBinderFactory c;
      final Set<Navigator.Listener> d = new HashSet<>();

      public Builder(KnowledgeUIClientImpl var1) {
         this.a = var1;
      }

      public Navigator.Builder a(Navigator.Listener var1) {
         this.d.add(var1);
         return this;
      }

      public Navigator a() {
         if (this.b == null) {
            this.b = new NavigationStack();
         }

         if (this.c == null) {
            this.c = new ViewBinderFactory();
         }

         return new Navigator(this);
      }
   }

   public interface Listener {
      void a(KnowledgeScene var1, KnowledgeScene var2);

      void b(KnowledgeScene var1, KnowledgeScene var2);
   }
}
