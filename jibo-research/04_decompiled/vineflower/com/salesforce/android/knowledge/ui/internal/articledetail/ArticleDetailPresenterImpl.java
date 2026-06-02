package com.salesforce.android.knowledge.ui.internal.articledetail;

import android.graphics.drawable.Drawable;
import com.salesforce.android.knowledge.core.exceptions.KnowledgeOfflineException;
import com.salesforce.android.knowledge.core.model.ArticleDetails;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.core.requests.ArticleDetailRequest;
import com.salesforce.android.knowledge.ui.KnowledgeUIAnalyticsEmit;
import com.salesforce.android.knowledge.ui.internal.AbstractHandler;
import com.salesforce.android.knowledge.ui.internal.client.KnowledgeUIClientImpl;
import com.salesforce.android.knowledge.ui.internal.minimize.MinimizeContext;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;

public class ArticleDetailPresenterImpl implements ArticleDetailPresenter {
   static final ServiceLogger a;
   static final boolean i;
   final KnowledgeUIClientImpl b;
   final ArticleSummary c;
   final ArticleDetailPresenterImpl.ArticleDetailsHandler d = new ArticleDetailPresenterImpl.ArticleDetailsHandler(this);
   ArticleDetailView e;
   ArticleDetails f;
   Drawable g;
   boolean h;

   static {
      boolean var0;
      if (!ArticleDetailPresenterImpl.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      i = var0;
      a = ServiceLogging.a(ArticleDetailPresenterImpl.class);
   }

   ArticleDetailPresenterImpl(ArticleDetailPresenterImpl.Builder var1) {
      this.b = var1.a;
      this.c = var1.b;
   }

   public static ArticleDetailPresenterImpl.Builder a(KnowledgeUIClientImpl var0, ArticleSummary var1) {
      return new ArticleDetailPresenterImpl.Builder(var0, var1);
   }

   private void c(ArticleDetailView var1) {
      var1.a(this.c.i());
      var1.a(this.b.i().b());
      if (this.g != null) {
         var1.a(this.g);
      }
   }

   @Override
   public void a() {
      if (!i && this.e == null) {
         throw new AssertionError();
      }

      this.b.j().a(MinimizeContext.a(this.g, this.c));
   }

   public void a(ArticleDetailView var1) {
      this.e = var1;
      this.g = this.b.g().a(var1.a(), this.c);
      this.c(this.e);
      this.f();
   }

   @Override
   public void b() {
      KnowledgeUIAnalyticsEmit.j(this.c.g(), this.c.i());
      this.d.a();
   }

   public void b(ArticleDetailView var1) {
      if (var1 == this.e) {
         this.e = null;
      }
   }

   @Override
   public void c() {
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
      if (this.e != null) {
         boolean var1;
         if (!this.d.d() || this.f != null && !this.f.f().isEmpty()) {
            var1 = false;
         } else {
            var1 = true;
         }

         if (this.d.e() && this.h) {
            this.e.a(4);
         } else if (this.d.e()) {
            this.e.a(3);
         } else if (var1) {
            this.e.a(2);
         } else if (this.f != null) {
            this.e.a(this.b, this.f).a(new Async.CompletionHandler(this) {
               final ArticleDetailPresenterImpl a;

               {
                  this.a = var1;
               }

               @Override
               public void a(Async<?> var1) {
                  if (this.a.e != null) {
                     this.a.e.a(1);
                  }
               }
            }).a(new Async.ErrorHandler(this) {
               final ArticleDetailPresenterImpl a;

               {
                  this.a = var1;
               }

               @Override
               public void a(Async<?> var1, Throwable var2) {
                  ArticleDetailPresenterImpl.a.b("Error encountered loading WebView. {}", var2.getLocalizedMessage());
               }
            });
         }
      }
   }

   class ArticleDetailsHandler extends AbstractHandler<ArticleDetails> {
      final ArticleDetailPresenterImpl a;

      ArticleDetailsHandler(ArticleDetailPresenterImpl var1) {
         this.a = var1;
      }

      private void g() {
         KnowledgeUIAnalyticsEmit.c(this.a.c.g(), this.a.c.i());
      }

      @Override
      public void a(Async<?> var1) {
         this.a.f();
         this.g();
      }

      public void a(Async<?> var1, ArticleDetails var2) {
         this.a.f = var2;
      }

      @Override
      public void a(Async<?> var1, Throwable var2) {
         ArticleDetailPresenterImpl.a.d("Error fetching article details: {}", var2.getMessage());
         this.a.h = var2 instanceof KnowledgeOfflineException;
         this.a.f();
         this.g();
      }

      @Override
      protected Async<ArticleDetails> c() {
         return ArticleDetailRequest.a(this.a.c).a(this.a.b.c());
      }
   }

   public static class Builder {
      final KnowledgeUIClientImpl a;
      final ArticleSummary b;

      Builder(KnowledgeUIClientImpl var1, ArticleSummary var2) {
         this.a = var1;
         this.b = var2;
      }

      public ArticleDetailPresenter a() {
         return new ArticleDetailPresenterImpl(this);
      }
   }
}
