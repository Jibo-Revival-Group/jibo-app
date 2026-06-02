package com.salesforce.android.cases.ui.internal.features.casefeed;

import android.content.Context;
import android.text.TextUtils;
import com.salesforce.android.cases.core.model.CaseField;
import com.salesforce.android.cases.core.model.CommentPost;
import com.salesforce.android.cases.core.model.CompleteCaseFeed;
import com.salesforce.android.cases.core.model.PushNotification;
import com.salesforce.android.cases.core.requests.CommentPostRequest;
import com.salesforce.android.cases.core.requests.CompleteCaseFeedRequest;
import com.salesforce.android.cases.core.requests.SetCaseLastReadDateRequest;
import com.salesforce.android.cases.ui.CaseUIClient;
import com.salesforce.android.cases.ui.CasesUIAnalyticsEmit;
import com.salesforce.android.cases.ui.internal.features.casefeed.viewmodel.CaseFeedViewModel;
import com.salesforce.android.cases.ui.internal.features.shared.AbstractHandler;
import com.salesforce.android.cases.ui.internal.features.shared.PushNotificationBroadcastReceiver;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.functional.Function;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.lang.ref.WeakReference;
import java.util.Map;

public class CaseFeedPresenter implements CaseFeedContract.Presenter {
   final PushNotificationBroadcastReceiver a;
   CaseFeedPresenter.GetCaseFeedHandler b = new CaseFeedPresenter.GetCaseFeedHandler(this);
   CaseFeedContract.View c;
   WeakReference<CaseFeedContract.Presenter.Listener> d;
   CaseFeedViewModel e;
   boolean f;
   String g;
   private final CaseUIClient h;
   private final ServiceLogger i = ServiceLogging.a(CaseFeedPresenter.class);

   CaseFeedPresenter(CaseUIClient var1) {
      this.h = var1;
      this.c = new NullCaseFeedView();
      this.a = new PushNotificationBroadcastReceiver(this) {
         final CaseFeedPresenter a;

         {
            this.a = var1;
         }

         @Override
         public void a(PushNotification var1) {
            if (this.a.g != null && this.a.g.equals(var1.a())) {
               this.a.c();
            }
         }
      };
   }

   private void a(CaseFeedViewModel var1) {
      String var5 = this.h.b();
      String var3 = this.h.d();
      String var4 = this.h.c();
      String var2;
      if (this.h.e()) {
         var2 = "authenticated";
      } else {
         var2 = "guest";
      }

      CasesUIAnalyticsEmit.c(var5, var3, var4, var2, "detail_loaded", this.g);
      if (var1.b() != null) {
         this.c.setTitle(var1.b());
      }

      this.c.i_();
      this.c.e();
      this.c.f();
      this.c.j_();
      this.c.a(var1.a());
      if (this.f) {
         this.k();
         CaseFeedPresenter.SetCaseReadHandler var6 = new CaseFeedPresenter.SetCaseReadHandler(this, this.g);
         this.h.a().a(SetCaseLastReadDateRequest.a(this.g, var1.c())).a(var6).a(var6);
      }
   }

   private void g() {
      if (this.d != null && this.d.get() != null) {
         String var2 = this.h.b();
         String var3 = this.h.d();
         String var4 = this.h.c();
         String var1;
         if (this.h.e()) {
            var1 = "authenticated";
         } else {
            var1 = "guest";
         }

         CasesUIAnalyticsEmit.c(var2, var3, var4, var1, "detail_dismissed", this.g);
         this.d.get().b();
      }
   }

   private void h() {
      this.c.h_();
   }

   private void i() {
      this.c.i_();
      this.c.k_();
      this.c.f();
      this.c.g();
      if (this.f) {
         this.k();
      }
   }

   private void j() {
      this.c.i_();
      this.c.k_();
      this.c.e();
      this.c.h();
      if (this.f) {
         this.k();
      }
   }

   private void k() {
      this.c.i();
      this.f = false;
   }

   private void l() {
      String var2 = this.h.b();
      String var4 = this.h.d();
      String var3 = this.h.c();
      String var1;
      if (this.h.e()) {
         var1 = "authenticated";
      } else {
         var1 = "guest";
      }

      CasesUIAnalyticsEmit.a(var2, var4, var3, var1, "customer", this.g);
   }

   @Override
   public void a() {
      this.c.o();
      this.g();
   }

   @Override
   public void a(CaseFeedContract.Presenter.Listener var1) {
      this.d = new WeakReference<>(var1);
   }

   public void a(CaseFeedContract.View var1) {
      var1.setPresenter(this);
      this.c = var1;
      this.a.a(var1.getApplicationContext());
      String var2 = this.h.b();
      String var4 = this.h.d();
      String var3 = this.h.c();
      String var5;
      if (this.h.e()) {
         var5 = "authenticated";
      } else {
         var5 = "guest";
      }

      CasesUIAnalyticsEmit.c(var2, var4, var3, var5, "detail_launched", this.g);
   }

   @Override
   public void a(String var1) {
      if (!TextUtils.isEmpty(var1)) {
         this.c.l();
         CommentPostRequest var2 = new CommentPostRequest.CommentPostRequestBuilder(this.e.d(), this.g, var1).b();
         this.h.a().a(var2).a(new CaseFeedPresenter.PostCommentResult(this, this.e)).a(new CaseFeedPresenter.PostCommentError(this));
      }
   }

   @Override
   public void b() {
      if (this.d != null) {
         this.d.clear();
         this.d = null;
      }
   }

   public void b(String var1) {
      this.g = var1;
      this.f();
   }

   @Override
   public void c() {
      this.f = true;
      this.b.e();
      this.b.a(false);
   }

   @Override
   public void d() {
   }

   @Override
   public void e() {
      this.a.b(this.c.getApplicationContext());
      this.c = new NullCaseFeedView();
      this.b.e();
   }

   public void f() {
      this.b.a(true);
      this.f = false;
   }

   class GetCaseFeedHandler extends AbstractHandler<CaseFeedViewModel> {
      final CaseFeedPresenter a;
      private boolean b;

      GetCaseFeedHandler(CaseFeedPresenter var1) {
         this.a = var1;
      }

      @Override
      protected Async<CaseFeedViewModel> a() {
         return this.a
            .h
            .a()
            .a(new CompleteCaseFeedRequest.CompleteCaseFeedRequestBuilder(this.a.g, this.a.h.c(), this.a.h.b()).e(true).d(true).c(true).b())
            .a(new CaseFeedPresenter.MapCaseFeedViewModelFunction(this.a.c.getApplicationContext()));
      }

      protected void a(CaseFeedViewModel var1) {
         this.a.e = var1;
         this.a.a(var1);
      }

      @Override
      protected void a(Throwable var1) {
         this.a.i();
      }

      public void a(boolean var1) {
         this.b = var1;
         super.d();
      }

      @Override
      protected void b() {
         if (this.b) {
            this.a.h();
         }
      }

      @Override
      protected void c() {
         this.a.j();
      }
   }

   static class MapCaseFeedViewModelFunction implements Function<CompleteCaseFeed, CaseFeedViewModel> {
      private final Context a;

      MapCaseFeedViewModelFunction(Context var1) {
         this.a = var1.getApplicationContext();
      }

      public CaseFeedViewModel a(CompleteCaseFeed var1) {
         Map var4 = var1.g().a();

         for (CaseField var2 : var1.f().a()) {
            if (var4.containsKey(var2.a())) {
               var2.a((String)var4.get(var2.a()));
            }
         }

         return new CaseFeedViewModel(this.a, var1.e(), var1.f(), var1.d(), var1.c());
      }
   }

   class PostCommentError implements Async.ErrorHandler {
      final CaseFeedPresenter a;

      PostCommentError(CaseFeedPresenter var1) {
         this.a = var1;
      }

      @Override
      public void a(Async<?> var1, Throwable var2) {
         this.a.c.k();
         this.a.c.j();
         this.a.c.m();
      }
   }

   class PostCommentResult implements Async.ResultHandler<CommentPost> {
      final CaseFeedPresenter a;
      private final CaseFeedViewModel b;

      PostCommentResult(CaseFeedPresenter var1, CaseFeedViewModel var2) {
         this.a = var1;
         this.b = var2;
      }

      public void a(Async var1, CommentPost var2) {
         this.a.l();
         this.a.c.n();
         this.a.c.j();
         this.a.c.m();

         for (Object var4 : this.b.a(var2)) {
            this.a.c.a(var4);
         }
      }
   }

   private class SetCaseReadHandler implements Async.CompletionHandler, Async.ErrorHandler {
      final CaseFeedPresenter a;
      private final String b;

      SetCaseReadHandler(CaseFeedPresenter var1, String var2) {
         this.a = var1;
         this.b = var2;
      }

      @Override
      public void a(Async<?> var1) {
         this.a.i.c("Successfully updated case {} last read date.", this.b);
      }

      @Override
      public void a(Async<?> var1, Throwable var2) {
         this.a.i.d("An error occurred while trying to update case {} last read date.\n\n{}", this.b, var2.getMessage());
      }
   }
}
