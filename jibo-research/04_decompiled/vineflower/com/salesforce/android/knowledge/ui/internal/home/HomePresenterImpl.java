package com.salesforce.android.knowledge.ui.internal.home;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.core.model.DataCategoryGroup;
import com.salesforce.android.knowledge.core.model.DataCategoryList;
import com.salesforce.android.knowledge.core.requests.ArticleListRequest;
import com.salesforce.android.knowledge.core.requests.DataCategoriesRequest;
import com.salesforce.android.knowledge.core.requests.DataCategoryGroupRequest;
import com.salesforce.android.knowledge.ui.KnowledgeUIAnalyticsEmit;
import com.salesforce.android.knowledge.ui.R;
import com.salesforce.android.knowledge.ui.internal.AbstractHandler;
import com.salesforce.android.knowledge.ui.internal.client.KnowledgeUIClientImpl;
import com.salesforce.android.knowledge.ui.internal.models.DataCategoryInfo;
import com.salesforce.android.knowledge.ui.internal.models.EmptyArticleList;
import com.salesforce.android.knowledge.ui.internal.models.Models;
import com.salesforce.android.service.common.utilities.control.Async;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HomePresenterImpl implements HomePresenter {
   static final boolean k;
   final KnowledgeUIClientImpl a;
   final String b;
   final ColorCalculator c;
   HomePresenterImpl.DataCategoryGroupHandler d = new HomePresenterImpl.DataCategoryGroupHandler(this);
   HomePresenterImpl.DataCategoryHandler e = new HomePresenterImpl.DataCategoryHandler(this);
   final Set<HomePresenterImpl.ArticleListHandler> f = new HashSet<>();
   final Map<DataCategoryInfo, ArticleList> g = new HashMap<>();
   HomeView h;
   DataCategoryInfo i;
   List<DataCategoryInfo> j = new ArrayList<>();

   static {
      boolean var0;
      if (!HomePresenterImpl.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      k = var0;
   }

   HomePresenterImpl(HomePresenterImpl.Builder var1) {
      this.a = var1.a;
      this.b = var1.b;
      this.c = var1.c;
   }

   public static HomePresenterImpl.Builder a(KnowledgeUIClientImpl var0, String var1) {
      return new HomePresenterImpl.Builder(var0, var1);
   }

   @Override
   public void a() {
      this.a.n();
   }

   @Override
   public void a(ArticleSummary var1) {
      this.a.i().a(var1);
   }

   public void a(HomeView var1) {
      this.h = var1;
      this.e();
      KnowledgeUIAnalyticsEmit.g(this.a.f().f(), this.b);
   }

   @Override
   public void a(DataCategoryInfo var1) {
      if (!k && this.h == null) {
         throw new AssertionError();
      }

      KnowledgeUIAnalyticsEmit.m(var1.b(), var1.a());
      if (var1 == this.i) {
         this.h.a(var1);
         this.i = null;
         KnowledgeUIAnalyticsEmit.a(var1.b(), var1.a());
      } else {
         if (this.i != null) {
            this.h.a(this.i);
            KnowledgeUIAnalyticsEmit.a(this.i.b(), this.i.a());
         }

         ArticleList var2 = this.g.get(var1);
         this.h.a(var1, var2);
         this.i = var1;
         KnowledgeUIAnalyticsEmit.b(var1.b(), var1.a());
      }
   }

   @Override
   public Drawable b(ArticleSummary var1) {
      if (!k && this.h == null) {
         throw new AssertionError();
      } else {
         return this.a.g().a(this.h.a(), var1);
      }
   }

   @Override
   public void b() {
      KnowledgeUIAnalyticsEmit.j();
      this.d.a();
   }

   public void b(HomeView var1) {
      this.h = null;
   }

   @Override
   public void b(DataCategoryInfo var1) {
      if (!k && this.h == null) {
         throw new AssertionError();
      }

      if (var1.c() > 0) {
         this.a.i().b(var1);
      } else {
         this.a.i().a(var1);
      }
   }

   @Override
   public void c() {
      this.e.b();
      Iterator var1 = this.f.iterator();

      while (var1.hasNext()) {
         ((HomePresenterImpl.ArticleListHandler)var1.next()).b();
      }
   }

   @Override
   public boolean c(DataCategoryInfo var1) {
      boolean var2;
      if (var1 == this.i) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public void d() {
      this.a.i().a();
   }

   void e() {
      if (this.h != null) {
         boolean var1;
         if (!this.a.b(this.h.a())) {
            var1 = true;
         } else {
            var1 = false;
         }

         boolean var2;
         if (!this.d.e() && !this.e.e()) {
            var2 = false;
         } else {
            var2 = true;
         }

         if (this.d.f() || this.e.f()) {
            this.h.a(0);
         } else if (var1 && var2) {
            this.h.a(4);
         } else if (var2) {
            this.h.a(3);
         } else if (!this.j.isEmpty()) {
            this.h.a(this.j);
            this.h.a(1);
            if (this.i != null) {
               ArticleList var3 = this.g.get(this.i);
               this.h.a(this.i, var3);
            }
         }
      }
   }

   class ArticleListHandler extends AbstractHandler<ArticleList> {
      final HomePresenterImpl a;
      private final DataCategoryInfo b;

      ArticleListHandler(HomePresenterImpl var1, DataCategoryInfo var2) {
         this.a = var1;
         this.b = var2;
      }

      @Override
      public void a(Async<?> var1) {
      }

      public void a(Async<?> var1, ArticleList var2) {
         this.a.g.put(this.b, var2);
      }

      @Override
      public void a(Async<?> var1, Throwable var2) {
         this.a.g.put(this.b, new EmptyArticleList());
      }

      @Override
      protected Async<ArticleList> c() {
         return ArticleListRequest.a().a(this.a.a.f().f(), this.b.a()).c(1).b(3).a(this.a.a.c());
      }
   }

   public static class Builder {
      final KnowledgeUIClientImpl a;
      final String b;
      ColorCalculator c;

      Builder(KnowledgeUIClientImpl var1, String var2) {
         this.a = var1;
         this.b = var2;
      }

      public HomePresenter a() {
         if (this.c == null) {
            throw new IllegalStateException("Must supply a color calculator");
         } else {
            return new HomePresenterImpl(this);
         }
      }

      public HomePresenterImpl.Builder a(Context var1) {
         this.c = new ColorCalculator(ContextCompat.c(var1, R.color.salesforce_brand_primary), 10, 8);
         return this;
      }
   }

   class DataCategoryGroupHandler extends AbstractHandler<DataCategoryGroup> {
      final HomePresenterImpl a;

      DataCategoryGroupHandler(HomePresenterImpl var1) {
         this.a = var1;
      }

      @Override
      public void a(Async<?> var1) {
         this.a.e.a();
      }

      public void a(Async<?> var1, DataCategoryGroup var2) {
      }

      @Override
      public void a(Async<?> var1, Throwable var2) {
         this.a.e();
      }

      @Override
      protected Async<DataCategoryGroup> c() {
         return DataCategoryGroupRequest.a(this.a.a.f().f()).a(this.a.a.c());
      }
   }

   class DataCategoryHandler extends AbstractHandler<DataCategoryList> {
      final HomePresenterImpl a;

      DataCategoryHandler(HomePresenterImpl var1) {
         this.a = var1;
      }

      private void g() {
         KnowledgeUIAnalyticsEmit.c();
      }

      @Override
      public void a(Async<?> var1) {
         this.a.e();
         this.g();

         for (DataCategoryInfo var2 : this.a.j) {
            HomePresenterImpl.ArticleListHandler var4 = this.a.new ArticleListHandler(this.a, var2);
            var4.a();
            this.a.f.add(var4);
         }
      }

      public void a(Async<?> var1, DataCategoryList var2) {
         List var3 = var2.a();
         this.a.j = Models.a(var3, this.a.c, this.a.a.g());
      }

      @Override
      public void a(Async<?> var1, Throwable var2) {
         this.a.e();
         this.g();
      }

      @Override
      protected Async<DataCategoryList> c() {
         return DataCategoriesRequest.a(this.a.a.f().f(), this.a.b).a(this.a.a.c());
      }
   }
}
