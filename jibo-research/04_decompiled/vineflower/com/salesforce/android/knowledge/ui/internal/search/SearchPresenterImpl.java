package com.salesforce.android.knowledge.ui.internal.search;

import android.graphics.drawable.Drawable;
import com.salesforce.android.knowledge.core.KnowledgeClient;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.core.requests.ArticleListRequest;
import com.salesforce.android.knowledge.ui.KnowledgeUIAnalyticsEmit;
import com.salesforce.android.knowledge.ui.internal.client.KnowledgeUIClientImpl;
import com.salesforce.android.service.common.utilities.control.Async;
import java.util.ArrayList;
import java.util.List;

public class SearchPresenterImpl implements SearchPresenter, Async.CompletionHandler, Async.ErrorHandler, Async.ResultHandler<ArticleList> {
   static final boolean a;
   private final KnowledgeUIClientImpl b;
   private final KnowledgeClient c;
   private SearchView d;
   private Async<ArticleList> e;
   private List<ArticleSummary> f = new ArrayList<>();
   private CharSequence g = "";
   private int h = 1;
   private boolean i;
   private boolean j = true;

   static {
      boolean var0;
      if (!SearchPresenterImpl.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      a = var0;
   }

   SearchPresenterImpl(KnowledgeUIClientImpl var1) {
      this.b = var1;
      this.c = var1.c();
   }

   public static SearchPresenter a(KnowledgeUIClientImpl var0) {
      return new SearchPresenterImpl(var0);
   }

   private void d() {
      this.f.clear();
      this.h = 1;
      if (this.d != null) {
         this.d.c();
      }
   }

   private void e() {
      this.e = ArticleListRequest.a().b(20).a(this.h).a(this.g).a(this.c).b(this);
   }

   private void f() {
      if (this.d != null) {
         boolean var1;
         if (this.e != null && this.e.f()) {
            var1 = true;
         } else {
            var1 = false;
         }

         boolean var2;
         if (this.e != null && this.e.e()) {
            var2 = true;
         } else {
            var2 = false;
         }

         if (var1) {
            this.d.a(4);
         } else if (this.g.length() <= 1) {
            this.d.a(0);
         } else if (var2) {
            this.d.a(3);
         } else if (this.f.size() == 0) {
            this.d.a(1);
         } else {
            this.d.a(2);
         }
      }
   }

   @Override
   public void a() {
      this.h++;
      this.e();
   }

   @Override
   public void a(ArticleSummary var1) {
      if (!a && this.d == null) {
         throw new AssertionError();
      }

      this.b.i().a(var1);
   }

   public void a(SearchView var1) {
      this.d = var1;
      this.d.a(this.f, this.i);
      this.d.a(this.g);
      this.f();
      if (this.j) {
         KnowledgeUIAnalyticsEmit.e();
         this.j = false;
      }
   }

   @Override
   public void a(Async<?> var1) {
      this.f();
   }

   public void a(Async<?> var1, ArticleList var2) {
      this.f.addAll(var2.a());
      this.i = var2.c();
      if (this.d != null) {
         if (var2.b() == 1) {
            this.d.a(var2.a(), this.i);
         } else {
            this.d.b(var2.a(), this.i);
         }

         KnowledgeUIAnalyticsEmit.d();
      }
   }

   @Override
   public void a(Async<?> var1, Throwable var2) {
      this.f();
   }

   @Override
   public void a(CharSequence var1) {
      if (!a && this.d == null) {
         throw new AssertionError();
      }

      if (!var1.equals(this.g)) {
         if (this.e != null) {
            this.e.c();
         }

         this.g = var1;
         if (var1.length() == 0) {
            KnowledgeUIAnalyticsEmit.h();
         } else if (var1.length() > 1) {
            KnowledgeUIAnalyticsEmit.a(var1);
            this.d();
            this.e();
         }

         this.f();
      }
   }

   @Override
   public Drawable b(ArticleSummary var1) {
      if (!a && this.d == null) {
         throw new AssertionError();
      } else {
         return this.b.g().a(this.d.a(), var1);
      }
   }

   @Override
   public void b() {
      KnowledgeUIAnalyticsEmit.l();
   }

   public void b(SearchView var1) {
      if (this.d == var1) {
         this.d = null;
      }
   }

   @Override
   public void c() {
      if (this.e != null) {
         this.e.c();
         this.e = null;
      }
   }
}
