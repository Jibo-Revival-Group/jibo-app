package com.salesforce.android.cases.ui.internal.features.caselist;

import com.salesforce.android.cases.core.internal.util.StringUtils;
import com.salesforce.android.cases.core.model.CaseListRecord;
import com.salesforce.android.cases.core.model.ListViewDescribe;
import com.salesforce.android.cases.core.model.PushNotification;
import com.salesforce.android.cases.core.requests.CaseListRequest;
import com.salesforce.android.cases.core.requests.ListViewDescribeRequest;
import com.salesforce.android.cases.core.requests.ListViewRequest;
import com.salesforce.android.cases.core.requests.SetCaseHiddenRequest;
import com.salesforce.android.cases.core.requests.SetCaseLastReadDateRequest;
import com.salesforce.android.cases.ui.CaseUIClient;
import com.salesforce.android.cases.ui.CasesUIAnalyticsEmit;
import com.salesforce.android.cases.ui.internal.features.caselist.viewmodel.CaseListItemViewModel;
import com.salesforce.android.cases.ui.internal.features.caselist.viewmodel.CaseListViewModel;
import com.salesforce.android.cases.ui.internal.features.shared.AbstractHandler;
import com.salesforce.android.cases.ui.internal.features.shared.PushNotificationBroadcastReceiver;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.functional.Function;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class CaseListPresenter implements CaseListContract.Presenter {
   PushNotificationBroadcastReceiver a;
   CaseListContract.View b;
   WeakReference<CaseListContract.Presenter.Listener> c;
   CaseListPresenter.CaseListDataHandler d;
   CaseListPresenter.CaseListLabelHandler e;
   boolean f;
   boolean g;
   CaseListViewModel h;
   private final Comparator<CaseListItemViewModel> i = new CaseListPresenter.CaseListComparator();
   private final ServiceLogger j = ServiceLogging.a(CaseListPresenter.class);
   private final CaseUIClient k;

   public CaseListPresenter(CaseUIClient var1) {
      this.d = new CaseListPresenter.CaseListDataHandler(this);
      this.e = new CaseListPresenter.CaseListLabelHandler(this);
      this.k = var1;
      this.b = new NullCaseListContractView();
      this.a = new PushNotificationBroadcastReceiver(this) {
         final CaseListPresenter a;

         {
            this.a = var1;
         }

         @Override
         public void a(PushNotification var1) {
            this.a.b.n();
         }
      };
   }

   private void a(CaseListViewModel var1) {
      String var3 = this.k.b();
      String var4 = this.k.d();
      String var5 = this.k.c();
      String var2;
      if (this.k.e()) {
         var2 = "authenticated";
      } else {
         var2 = "guest";
      }

      CasesUIAnalyticsEmit.a(var3, var4, var5, var2, "list_loaded", var1.a().size());
      this.b.c();
      if (var1.a().isEmpty()) {
         this.b.h();
      } else {
         this.b.i();
         this.b.a(var1);
      }

      this.b.f();
   }

   private void a(String var1) {
      this.b.setTitle(var1);
   }

   private void d(CaseListItemViewModel var1) {
      if (!StringUtils.a(var1.c())) {
         CaseListPresenter.SetCaseReadHandler var3 = new CaseListPresenter.SetCaseReadHandler(this, var1);
         Date var2;
         if (var1.g() == null) {
            var2 = new Date();
         } else {
            var2 = var1.g();
         }

         this.k.a().a(SetCaseLastReadDateRequest.a(var1.c(), var2)).a(var3).a(var3);
      }
   }

   private void e(CaseListItemViewModel var1) {
      this.b.a(var1);
   }

   private void f(CaseListItemViewModel var1) {
      this.h.a().remove(var1);
      this.b.b(var1);
      this.b.c(var1);
      this.d(var1);
   }

   private void g(CaseListItemViewModel var1) {
      List var3 = this.h.a();
      var3.add(var1);
      Collections.sort(var3, this.i);
      int var2 = var3.indexOf(var1);
      if (var2 >= 0) {
         this.b.a(var1, var2);
      }
   }

   private void j() {
      if (this.f) {
         this.b.m_();
      } else {
         this.b.l_();
         this.b.g();
      }
   }

   private void k() {
      if (this.f) {
         this.b.m();
      } else {
         this.b.l();
      }

      this.b.f();
      this.m();
   }

   private void l() {
      if (this.f) {
         this.b.k();
      } else {
         this.b.j();
      }

      this.b.f();
      this.m();
   }

   private void m() {
      if (this.f) {
         this.b.e();
         this.f = false;
      } else {
         this.b.c();
      }
   }

   private void n() {
      if (this.c != null && this.c.get() != null) {
         String var3 = this.k.b();
         String var4 = this.k.d();
         String var2 = this.k.c();
         String var1;
         if (this.k.e()) {
            var1 = "authenticated";
         } else {
            var1 = "guest";
         }

         CasesUIAnalyticsEmit.a(var3, var4, var2, var1, "list_dismissed", (Integer)null);
         this.c.get().d();
      }
   }

   @Override
   public void a() {
      if (this.b.getContext() != null) {
         this.k.b(this.b.getContext());
      }
   }

   @Override
   public void a(CaseListContract.Presenter.Listener var1) {
      this.c = new WeakReference<>(var1);
   }

   public void a(CaseListContract.View var1) {
      var1.setPresenter(this);
      this.b = var1;
      this.d.d();
      this.e.d();
      this.g = false;
      this.a.a(var1.getContext());
      String var3 = this.k.b();
      String var4 = this.k.d();
      String var2 = this.k.c();
      String var5;
      if (this.k.e()) {
         var5 = "authenticated";
      } else {
         var5 = "guest";
      }

      CasesUIAnalyticsEmit.a(var3, var4, var2, var5, "list_launched", (Integer)null);
   }

   @Override
   public void a(CaseListItemViewModel var1) {
      String var2 = var1.c();
      if (StringUtils.a(var2)) {
         this.j.d("Case list item without case id was clicked.");
      } else {
         this.d(var1);
         if (this.b.getContext() != null) {
            this.k.a(this.b.getContext(), var2);
         }
      }
   }

   public void a(Void var1) {
   }

   @Override
   public void b() {
      this.n();
   }

   @Override
   public void b(CaseListItemViewModel var1) {
      String var2 = var1.c();
      if (StringUtils.a(var2)) {
         this.j.d("Case list item without case id was swiped.");
      } else {
         CaseListPresenter.SetCaseHiddenHandler var3 = new CaseListPresenter.SetCaseHiddenHandler(this, var1, true);
         this.k.a().a(SetCaseHiddenRequest.a(var2, true)).a(var3).a(var3);
      }
   }

   @Override
   public void c() {
      this.h();
   }

   @Override
   public void c(CaseListItemViewModel var1) {
      if (this.h != null) {
         String var2 = var1.c();
         if (StringUtils.a(var2)) {
            this.j.d("Case list item without case id was unhidden.");
         } else {
            CaseListPresenter.SetCaseHiddenHandler var3 = new CaseListPresenter.SetCaseHiddenHandler(this, var1, false);
            this.k.a().a(SetCaseHiddenRequest.a(var2, false)).a(var3).a(var3);
         }
      }
   }

   @Override
   public void d() {
      this.g = true;
   }

   @Override
   public void e() {
      this.a.b(this.b.getContext());
      this.b = new NullCaseListContractView();
      this.d.e();
      this.e.e();
   }

   @Override
   public void f() {
      this.h();
   }

   @Override
   public void g() {
      if (this.c != null) {
         this.c.clear();
         this.c = null;
      }
   }

   @Override
   public void h() {
      if (!this.d.h()) {
         this.f = true;
         this.d.e();
         this.d.d();
      }
   }

   @Override
   public void i() {
      if (this.g) {
         this.h();
      }
   }

   private static class CaseListComparator implements Comparator<CaseListItemViewModel> {
      private CaseListComparator() {
      }

      public int a(CaseListItemViewModel var1, CaseListItemViewModel var2) {
         Date var4 = var1.g();
         Date var5 = var2.g();
         int var3;
         if (var5 != null && var4 != null) {
            var3 = var5.compareTo(var4);
         } else {
            var3 = -1;
         }

         return var3;
      }
   }

   class CaseListDataHandler extends AbstractHandler<CaseListViewModel> {
      final CaseListPresenter a;

      CaseListDataHandler(CaseListPresenter var1) {
         this.a = var1;
      }

      @Override
      protected Async<CaseListViewModel> a() {
         return this.a.k.a().a(ListViewRequest.a(this.a.k.d())).b(new CaseListPresenter.CaseListDataHandler.GetListViewDescribeFunction(this));
      }

      protected void a(CaseListViewModel var1) {
         this.a.a(var1);
      }

      @Override
      public void a(Async<?> var1) {
         this.a.m();
      }

      @Override
      protected void a(Throwable var1) {
         this.a.l();
      }

      @Override
      protected void b() {
         this.a.j();
      }

      @Override
      protected void c() {
         this.a.k();
      }

      private class CreateCaseListItemViewModelsFunction implements Function<List<CaseListRecord>, CaseListViewModel> {
         final CaseListPresenter.CaseListDataHandler a;

         private CreateCaseListItemViewModelsFunction(CaseListPresenter.CaseListDataHandler var1) {
            this.a = var1;
         }

         public CaseListViewModel a(List<CaseListRecord> var1) {
            ArrayList var2 = new ArrayList(var1.size());

            for (CaseListRecord var3 : var1) {
               if (!var3.f() && this.a.a.b.getContext() != null) {
                  var2.add(new CaseListItemViewModel(this.a.a.b.getContext().getApplicationContext(), var3));
               }
            }

            Collections.sort(var2, this.a.a.i);
            this.a.a.h = new CaseListViewModel(var2);
            return this.a.a.h;
         }
      }

      private class GetCaseListFunction implements Function<ListViewDescribe, Async<? extends CaseListViewModel>> {
         final CaseListPresenter.CaseListDataHandler a;

         private GetCaseListFunction(CaseListPresenter.CaseListDataHandler var1) {
            this.a = var1;
         }

         public Async<? extends CaseListViewModel> a(ListViewDescribe var1) {
            return this.a.a.k.a().a(CaseListRequest.a(var1.a())).a(this.a.new CreateCaseListItemViewModelsFunction(this.a));
         }
      }

      private class GetListViewDescribeFunction implements Function<String, Async<? extends CaseListViewModel>> {
         final CaseListPresenter.CaseListDataHandler a;

         private GetListViewDescribeFunction(CaseListPresenter.CaseListDataHandler var1) {
            this.a = var1;
         }

         public Async<? extends CaseListViewModel> a(String var1) {
            return this.a.a.k.a().a(ListViewDescribeRequest.a(var1)).b(this.a.new GetCaseListFunction(this.a));
         }
      }
   }

   class CaseListLabelHandler extends AbstractHandler<String> {
      final CaseListPresenter a;

      CaseListLabelHandler(CaseListPresenter var1) {
         this.a = var1;
      }

      @Override
      protected Async<String> a() {
         return this.a.k.a().b(ListViewRequest.a(this.a.k.d()));
      }

      protected void a(String var1) {
         this.a.a(var1);
      }

      @Override
      protected void a(Throwable var1) {
      }

      @Override
      protected void b() {
      }

      @Override
      protected void c() {
      }
   }

   private class SetCaseHiddenHandler implements Async.CompletionHandler, Async.ErrorHandler {
      final CaseListPresenter a;
      private final CaseListItemViewModel b;
      private final boolean c;

      SetCaseHiddenHandler(CaseListPresenter var1, CaseListItemViewModel var2, boolean var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      @Override
      public void a(Async<?> var1) {
         this.a.j.c("Successfully set case {} hidden to {}.", this.b.c(), this.c);
         if (this.c) {
            this.a.f(this.b);
         } else {
            this.a.g(this.b);
         }
      }

      @Override
      public void a(Async<?> var1, Throwable var2) {
         this.a.j.d("An error occurred while trying to set case {} hidden to {}.\n\n{}", this.b.c(), this.c, var2.getMessage());
      }
   }

   private class SetCaseReadHandler implements Async.CompletionHandler, Async.ErrorHandler {
      final CaseListPresenter a;
      private final CaseListItemViewModel b;

      SetCaseReadHandler(CaseListPresenter var1, CaseListItemViewModel var2) {
         this.a = var1;
         this.b = var2;
      }

      @Override
      public void a(Async<?> var1) {
         this.a.j.c("Successfully updated case last read date.");
         this.b.a(false);
         this.a.e(this.b);
      }

      @Override
      public void a(Async<?> var1, Throwable var2) {
         this.a.j.d("An error occurred while trying to update a case last read date.\n\n{}", var2.getMessage());
      }
   }
}
