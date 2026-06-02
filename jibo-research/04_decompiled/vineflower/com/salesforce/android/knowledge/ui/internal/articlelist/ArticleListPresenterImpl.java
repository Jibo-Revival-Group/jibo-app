package com.salesforce.android.knowledge.ui.internal.articlelist;

import android.graphics.drawable.Drawable;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.core.requests.ArticleListRequest;
import com.salesforce.android.knowledge.ui.KnowledgeUIAnalyticsEmit;
import com.salesforce.android.knowledge.ui.internal.AbstractHandler;
import com.salesforce.android.knowledge.ui.internal.client.KnowledgeUIClientImpl;
import com.salesforce.android.knowledge.ui.internal.models.DataCategoryInfo;
import com.salesforce.android.service.common.utilities.control.Async;
import java.util.LinkedList;
import java.util.List;

public class ArticleListPresenterImpl implements ArticleListPresenter {
   static final boolean g;
   final KnowledgeUIClientImpl a;
   final DataCategoryInfo b;
   List<ArticleSummary> c = new LinkedList<>();
   boolean d;
   int e = 1;
   ArticleListView f;
   private ArticleListPresenterImpl.ArticleListHandler h = new ArticleListPresenterImpl.ArticleListHandler(this, this.e);

   static {
      boolean var0;
      if (!ArticleListPresenterImpl.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      g = var0;
   }

   private ArticleListPresenterImpl(KnowledgeUIClientImpl var1, DataCategoryInfo var2) {
      this.a = var1;
      this.b = var2;
   }

   public static ArticleListPresenter a(KnowledgeUIClientImpl var0, DataCategoryInfo var1) {
      return new ArticleListPresenterImpl(var0, var1);
   }

   @Override
   public void a() {
      if (!this.h.f()) {
         KnowledgeUIAnalyticsEmit.n(this.b.b(), this.b.a());
         int var1 = this.e + 1;
         this.e = var1;
         this.h = new ArticleListPresenterImpl.ArticleListHandler(this, var1);
         this.h.a();
      }
   }

   @Override
   public void a(ArticleSummary var1) {
      this.a.i().a(var1);
   }

   public void a(ArticleListView var1) {
      this.f = var1;
      this.f.a(this.b.a(var1.a()));
      this.f.a(this.b.b());
      this.f.a(this.c, this.d);
      this.f.a(this.a.i().b());
      this.f();
   }

   @Override
   public Drawable b(ArticleSummary var1) {
      if (!g && this.f == null) {
         throw new AssertionError();
      } else {
         return this.a.g().a(this.f.a(), var1);
      }
   }

   @Override
   public void b() {
      KnowledgeUIAnalyticsEmit.k(this.b.b(), this.b.a());
      this.h.a();
   }

   public void b(ArticleListView var1) {
      if (var1 == this.f) {
         this.f = null;
      }
   }

   @Override
   public void c() {
      this.h.b();
      this.c.clear();
   }

   @Override
   public void d() {
      this.a.i().a();
   }

   @Override
   public void e() {
      this.a.i().d();
   }

   void f() {
      if (this.f != null) {
         if (this.h.f() && this.c.isEmpty()) {
            this.f.a(4);
         } else if (this.h.e()) {
            this.f.a(3);
         } else if (this.c.isEmpty()) {
            this.f.a(2);
         } else {
            this.f.a(1);
         }
      }
   }

   private class ArticleListHandler extends AbstractHandler<ArticleList> {
      final ArticleListPresenterImpl a;
      private final int b;

      ArticleListHandler(ArticleListPresenterImpl var1, int var2) {
         this.a = var1;
         this.b = var2;
      }

      private void g() {
         if (this.b == 1) {
            KnowledgeUIAnalyticsEmit.d(this.a.b.b(), this.a.b.a());
         } else {
            KnowledgeUIAnalyticsEmit.f(this.a.b.b(), this.a.b.a());
         }
      }

      @Override
      public void a(Async<?> var1) {
         this.a.f();
         this.g();
      }

      public void a(Async<?> var1, ArticleList var2) {
         this.a.c.addAll(var2.a());
         this.a.d = var2.c();
         if (this.a.f != null) {
            this.a.f.a(var2.a(), var2.c());
         }
      }

      @Override
      public void a(Async<?> var1, Throwable var2) {
         this.a.f();
         this.g();
      }

      @Override
      protected Async<ArticleList> c() {
         return ArticleListRequest.a().a(this.a.a.f().f(), this.a.b.a()).c(1).b(10).a(this.b).a(this.a.a.c());
      }
   }
}
