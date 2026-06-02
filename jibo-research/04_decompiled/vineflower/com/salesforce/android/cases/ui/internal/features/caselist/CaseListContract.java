package com.salesforce.android.cases.ui.internal.features.caselist;

import android.content.Context;
import com.salesforce.android.cases.ui.internal.features.caselist.viewmodel.CaseListItemViewModel;
import com.salesforce.android.cases.ui.internal.features.caselist.viewmodel.CaseListViewModel;
import com.salesforce.android.cases.ui.internal.features.shared.BasePresenter;
import com.salesforce.android.cases.ui.internal.features.shared.BaseView;

public interface CaseListContract {
   interface Presenter extends BasePresenter<Void, CaseListContract.View> {
      void a();

      void a(CaseListContract.Presenter.Listener var1);

      void a(CaseListItemViewModel var1);

      void b();

      void b(CaseListItemViewModel var1);

      void c();

      void c(CaseListItemViewModel var1);

      void f();

      void g();

      void h();

      void i();

      interface Listener {
         void d();
      }
   }

   interface View extends BaseView {
      void a(CaseListItemViewModel var1);

      void a(CaseListItemViewModel var1, int var2);

      void a(CaseListViewModel var1);

      void b(CaseListItemViewModel var1);

      void c();

      void c(CaseListItemViewModel var1);

      void e();

      void f();

      void g();

      Context getContext();

      void h();

      void i();

      void j();

      void k();

      void l();

      void l_();

      void m();

      void m_();

      void n();

      void setPresenter(CaseListContract.Presenter var1);

      void setTitle(String var1);
   }
}
