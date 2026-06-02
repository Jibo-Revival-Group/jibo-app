package com.salesforce.android.knowledge.ui.internal.categorydetail;

import android.graphics.drawable.Drawable;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.core.model.DataCategoryList;
import com.salesforce.android.knowledge.core.requests.ArticleListRequest;
import com.salesforce.android.knowledge.core.requests.DataCategoriesRequest;
import com.salesforce.android.knowledge.ui.KnowledgeUIAnalyticsEmit;
import com.salesforce.android.knowledge.ui.internal.AbstractHandler;
import com.salesforce.android.knowledge.ui.internal.client.KnowledgeUIClientImpl;
import com.salesforce.android.knowledge.ui.internal.models.DataCategoryInfo;
import com.salesforce.android.knowledge.ui.internal.models.Models;
import com.salesforce.android.service.common.utilities.control.Async;
import java.util.LinkedList;
import java.util.List;

public class CategoryDetailPresenterImpl implements CategoryDetailPresenter {
   static final boolean h;
   final DataCategoryInfo a;
   final KnowledgeUIClientImpl b;
   final CategoryDetailPresenterImpl.ArticleListHandler c = new CategoryDetailPresenterImpl.ArticleListHandler(this);
   final CategoryDetailPresenterImpl.CategoryListHandler d = new CategoryDetailPresenterImpl.CategoryListHandler(this);
   List<ArticleSummary> e = new LinkedList<>();
   List<DataCategoryInfo> f = new LinkedList<>();
   boolean g = false;
   private CategoryDetailView i;

   static {
      boolean var0;
      if (!CategoryDetailPresenterImpl.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      h = var0;
   }

   private CategoryDetailPresenterImpl(KnowledgeUIClientImpl var1, DataCategoryInfo var2) {
      this.b = var1;
      this.a = var2;
   }

   public static CategoryDetailPresenter a(KnowledgeUIClientImpl var0, DataCategoryInfo var1) {
      return new CategoryDetailPresenterImpl(var0, var1);
   }

   private void c(CategoryDetailView var1) {
      var1.a(this.a.b());
      var1.a(this.b.i().b());
      Drawable var2 = this.a.a(var1.a());
      if (var2 != null) {
         var1.a(var2);
      }
   }

   @Override
   public void a() {
      if (!h && this.i == null) {
         throw new AssertionError();
      }

      this.b.i().a(this.a);
   }

   @Override
   public void a(ArticleSummary var1) {
      if (!h && this.i == null) {
         throw new AssertionError();
      }

      this.b.i().a(var1);
   }

   public void a(CategoryDetailView var1) {
      this.i = var1;
      this.c(this.i);
      this.f();
   }

   @Override
   public void a(DataCategoryInfo var1) {
      if (var1.c() > 0) {
         this.b.i().b(var1);
      } else {
         this.b.i().a(var1);
      }
   }

   @Override
   public Drawable b(ArticleSummary var1) {
      if (!h && this.i == null) {
         throw new AssertionError();
      } else {
         return this.b.g().a(this.i.a(), var1);
      }
   }

   @Override
   public void b() {
      KnowledgeUIAnalyticsEmit.l(this.a.b(), this.a.a());
      this.c.a();
      this.d.a();
   }

   public void b(CategoryDetailView var1) {
      if (var1 == this.i) {
         this.i = null;
      }
   }

   @Override
   public void c() {
      this.c.b();
      this.d.b();
   }

   @Override
   public void d() {
      this.b.i().a();
   }

   @Override
   public void e() {
      this.b.i().d();
   }

   void f() {
      boolean var4 = false;
      if (this.i != null) {
         boolean var1;
         if (!this.c.e() && !this.d.e()) {
            var1 = false;
         } else {
            var1 = true;
         }

         boolean var2;
         if (this.c.d() && this.d.d()) {
            var2 = true;
         } else {
            var2 = false;
         }

         boolean var3 = var4;
         if (this.e.isEmpty()) {
            var3 = var4;
            if (this.f.isEmpty()) {
               var3 = true;
            }
         }

         if (var1) {
            this.i.a(3);
         } else if (var3 && var2) {
            this.i.a(2);
         } else if (var2) {
            this.i.a(this.e, this.f, this.g);
            this.i.a(1);
         }
      }
   }

   private class ArticleListHandler extends AbstractHandler<ArticleList> {
      final CategoryDetailPresenterImpl a;

      private ArticleListHandler(CategoryDetailPresenterImpl var1) {
         this.a = var1;
      }

      @Override
      public void a(Async<?> var1) {
         this.a.f();
      }

      public void a(Async<?> var1, ArticleList var2) {
         this.a.e = var2.a();
         this.a.g = var2.c();
      }

      @Override
      public void a(Async<?> var1, Throwable var2) {
         this.a.f();
      }

      @Override
      protected Async<ArticleList> c() {
         return ArticleListRequest.a().a(this.a.b.f().f(), this.a.a.a()).c(1).b(3).a(this.a.b.c());
      }
   }

   private class CategoryListHandler extends AbstractHandler<DataCategoryList> {
      final CategoryDetailPresenterImpl a;

      private CategoryListHandler(CategoryDetailPresenterImpl var1) {
         this.a = var1;
      }

      private void g() {
         KnowledgeUIAnalyticsEmit.e(this.a.a.b(), this.a.a.a());
      }

      @Override
      public void a(Async<?> var1) {
         this.a.f();
         this.g();
      }

      public void a(Async<?> var1, DataCategoryList var2) {
         this.a.f = Models.a(var2.a(), Models.a(this.a.a.d()), this.a.b.g());
      }

      @Override
      public void a(Async<?> var1, Throwable var2) {
         this.a.f();
         this.g();
      }

      @Override
      protected Async<DataCategoryList> c() {
         return DataCategoriesRequest.a(this.a.b.f().f(), this.a.a.a()).a(this.a.b.c());
      }
   }
}
