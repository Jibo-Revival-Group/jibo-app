package com.salesforce.android.cases.ui.internal.features.publisher;

import android.os.Looper;
import com.salesforce.android.cases.core.internal.model.CreateCaseRecordModel;
import com.salesforce.android.cases.core.model.CaseField;
import com.salesforce.android.cases.core.model.CaseLayoutData;
import com.salesforce.android.cases.core.model.CreateCaseRecordResult;
import com.salesforce.android.cases.core.model.DefaultValues;
import com.salesforce.android.cases.core.requests.CreateCaseQuickActionRequest;
import com.salesforce.android.cases.core.requests.CreateCaseRecordRequest;
import com.salesforce.android.cases.core.requests.DefaultValuesRequest;
import com.salesforce.android.cases.ui.CaseUIClient;
import com.salesforce.android.cases.ui.CasesUIAnalyticsEmit;
import com.salesforce.android.cases.ui.internal.features.publisher.viewmodel.CaseFieldViewModel;
import com.salesforce.android.cases.ui.internal.features.shared.AbstractHandler;
import com.salesforce.android.cases.ui.internal.utils.CollectionUtils;
import com.salesforce.android.cases.ui.internal.utils.HandlerFactory;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.functional.Function;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CasePublisherPresenter implements CasePublisherContract.Presenter {
   List<CaseFieldViewModel> a;
   String b;
   WeakReference<CasePublisherContract.Presenter.Listener> c;
   CasePublisherContract.View d;
   CasePublisherPresenter.CaseLayoutDataHandler e = new CasePublisherPresenter.CaseLayoutDataHandler(this);
   CasePublisherPresenter.CreateCaseHandler f = new CasePublisherPresenter.CreateCaseHandler(this);
   boolean g;
   private final CaseUIClient h;
   private final HandlerFactory i;
   private List<CaseField> j;

   public CasePublisherPresenter(CaseUIClient var1, HandlerFactory var2) {
      this.h = var1;
      this.i = var2;
      this.d = new NulledCasePublisherView();
   }

   private void a(CreateCaseRecordModel var1) {
      this.f.a = var1;
      this.n();
      CasesUIAnalyticsEmit.a(this.h.b(), this.h.d(), this.h.c(), this.r(), "submit_started", null, null, 0);
      this.i.a(Looper.getMainLooper()).postDelayed(new Runnable(this) {
         final CasePublisherPresenter a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            this.a.f.d();
         }
      }, 1500L);
   }

   private void a(CaseLayoutData var1) {
      CasesUIAnalyticsEmit.a(this.h.b(), this.h.d(), this.h.c(), this.r(), "publisher_loaded");
      this.b(var1);
      this.d.q_();
      this.d.c();
      if (!this.f.i()) {
         this.d.m();
      }
   }

   private void a(String var1) {
      int var2 = this.s();
      CasesUIAnalyticsEmit.a(this.h.b(), this.h.d(), this.h.c(), this.r(), "submit_complete", "success", var1, var2);
      this.g = true;
      this.d.r_();
      this.d.k();
      if (this.h.e()) {
         this.q();
      } else {
         this.d.g();
      }
   }

   private int b(String var1) {
      return var1.trim().split("\\s+").length;
   }

   private void b(CaseLayoutData var1) {
      this.a = new ArrayList<>();
      this.j = new ArrayList<>();

      for (CaseField var3 : var1.a()) {
         if (var3.f().isTextField() && !this.h.e()) {
            var3.a(null);
         }

         if (!var3.e()) {
            if (this.p().containsKey(var3.a())) {
               var3.a(true);
               var3.a(this.p().get(var3.a()));
               this.j.add(var3);
            } else {
               CaseFieldViewModel var4;
               switch (<unrepresentable>.a[var3.f().ordinal()]) {
                  case 1:
                  case 2:
                  case 3:
                     var4 = this.d.a(var3);
                     break;
                  case 4:
                     var4 = this.d.b(var3);
                     break;
                  default:
                     var4 = null;
               }

               if (var4 != null) {
                  if (var3.a().equals(this.b)) {
                     var4.c();
                  }

                  this.a.add(var4);
               }
            }
         }
      }
   }

   private void i() {
      this.d.p_();
      this.d.l();
   }

   private void j() {
      this.d.q_();
      this.d.e();
   }

   private void k() {
      this.d.q_();
      this.d.f();
   }

   private void l() {
      this.f.e();
      this.d.i();
      if (this.m()) {
         CreateCaseRecordModel.Builder var1 = new CreateCaseRecordModel.Builder();

         for (CaseFieldViewModel var3 : this.a) {
            var1.a(var3.d().a(), var3.f());
         }

         if (this.j != null) {
            for (CaseField var5 : this.j) {
               var1.a(var5.a(), var5.h());
            }
         }

         this.a(var1.a());
      }
   }

   private boolean m() {
      Iterator var2 = this.a.iterator();

      boolean var1;
      while (true) {
         if (var2.hasNext()) {
            CaseFieldViewModel var3 = (CaseFieldViewModel)var2.next();
            if (var3.e()) {
               continue;
            }

            var3.c();
            var1 = false;
            break;
         }

         var1 = true;
         break;
      }

      return var1;
   }

   private void n() {
      this.g = false;
      this.d.j();
      this.d.l();
   }

   private void o() {
      int var1 = this.s();
      CasesUIAnalyticsEmit.a(this.h.b(), this.h.d(), this.h.c(), this.r(), "submit_complete", "failure", null, var1);
      this.g = false;
      this.d.k();
      this.d.h();
      this.d.m();
   }

   private Map<String, String> p() {
      Map var1;
      if (this.h.a().a() != null && this.h.a().a().a() != null) {
         var1 = this.h.a().a().a();
      } else {
         var1 = Collections.emptyMap();
      }

      return var1;
   }

   private void q() {
      String var1 = this.h.b();
      String var4 = this.h.d();
      String var2 = this.h.c();
      String var3 = this.r();
      CasesUIAnalyticsEmit.a(var1, var4, var2, var3, "publisher_dismissed");
      CasesUIAnalyticsEmit.a(var1, var4, var2, var3, this.s());
      if (this.c != null && this.c.get() != null) {
         this.c.get().d();
      }
   }

   private String r() {
      String var1;
      if (this.h.e()) {
         var1 = "authenticated";
      } else {
         var1 = "guest";
      }

      return var1;
   }

   private int s() {
      int var1 = 0;
      if (this.a != null) {
         Iterator var2 = this.a.iterator();
         var1 = 0;

         while (var2.hasNext()) {
            String var3 = ((CaseFieldViewModel)var2.next()).f();
            if (var3 != null && !var3.trim().isEmpty()) {
               var1 += this.b(var3);
            }
         }
      }

      return var1;
   }

   @Override
   public void a() {
      this.l();
   }

   @Override
   public void a(CasePublisherContract.Presenter.Listener var1) {
      this.c = new WeakReference<>(var1);
   }

   public void a(CasePublisherContract.View var1) {
      var1.setPresenter(this);
      this.d = var1;
      this.e.d();
      if (this.f.i()) {
         this.f.d();
      }

      CasesUIAnalyticsEmit.a(this.h.b(), this.h.d(), this.h.c(), this.r(), "publisher_launched");
   }

   public void a(Void var1) {
   }

   @Override
   public void b() {
      this.q();
   }

   @Override
   public void c() {
      this.l();
   }

   @Override
   public void d() {
      if (!CollectionUtils.a(this.a)) {
         for (CaseFieldViewModel var1 : this.a) {
            if (var1.b()) {
               this.b = var1.d().a();
               break;
            }
         }
      }
   }

   @Override
   public void e() {
      this.d = new NulledCasePublisherView();
      this.e.e();
      this.f.e();
   }

   @Override
   public void f() {
      if (this.c != null) {
         this.c.clear();
         this.c = null;
      }
   }

   @Override
   public boolean g() {
      if (!this.g && !CollectionUtils.a(this.a)) {
         Iterator var2 = this.a.iterator();

         while (var2.hasNext()) {
            if (((CaseFieldViewModel)var2.next()).g()) {
               this.d.n();
               return true;
            }
         }
      }

      this.q();
      return false;
   }

   @Override
   public void h() {
      this.q();
   }

   class CaseLayoutDataHandler extends AbstractHandler<CaseLayoutData> {
      final CasePublisherPresenter a;

      CaseLayoutDataHandler(CasePublisherPresenter var1) {
         this.a = var1;
      }

      @Override
      protected Async<CaseLayoutData> a() {
         Async var1;
         if (this.a.h.e()) {
            var1 = this.a.h.a().a(DefaultValuesRequest.a(this.a.h.c())).b(new Function<DefaultValues, Async<? extends CaseLayoutData>>(this) {
               final CasePublisherPresenter.CaseLayoutDataHandler a;

               {
                  this.a = var1;
               }

               public Async<? extends CaseLayoutData> a(DefaultValues var1) {
                  return this.a.a.h.a().a(CreateCaseQuickActionRequest.a(this.a.a.h.c())).a(new Function<CaseLayoutData, CaseLayoutData>(this, var1) {
                     final DefaultValues a;
                     final <unrepresentable> b;

                     {
                        this.b = var1;
                        this.a = var2;
                     }

                     public CaseLayoutData a(CaseLayoutData var1) {
                        Map var4 = this.a.a();

                        for (CaseField var3 : var1.a()) {
                           if (var4.containsKey(var3.a())) {
                              var3.a((String)var4.get(var3.a()));
                           }
                        }

                        return var1;
                     }
                  });
               }
            });
         } else {
            var1 = this.a.h.a().a(CreateCaseQuickActionRequest.a(this.a.h.c()));
         }

         return var1;
      }

      protected void a(CaseLayoutData var1) {
         this.a.a(var1);
      }

      @Override
      protected void a(Throwable var1) {
         this.a.j();
      }

      @Override
      protected void b() {
         this.a.i();
      }

      @Override
      protected void c() {
         this.a.k();
      }
   }

   class CreateCaseHandler extends AbstractHandler<CreateCaseRecordResult> {
      CreateCaseRecordModel a;
      final CasePublisherPresenter b;

      CreateCaseHandler(CasePublisherPresenter var1) {
         this.b = var1;
      }

      @Override
      protected Async<CreateCaseRecordResult> a() {
         return this.b.h.a().a(new CreateCaseRecordRequest.NewCaseRecordRequestBuilder(this.b.h.c(), this.a).b());
      }

      protected void a(CreateCaseRecordResult var1) {
         this.b.a(var1.a());
      }

      @Override
      protected void a(Throwable var1) {
         this.b.o();
      }

      @Override
      protected void b() {
         this.b.n();
      }

      @Override
      protected void c() {
         this.b.o();
      }
   }
}
