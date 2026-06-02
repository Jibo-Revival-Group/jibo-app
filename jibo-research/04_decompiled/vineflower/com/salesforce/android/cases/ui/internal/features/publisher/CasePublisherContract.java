package com.salesforce.android.cases.ui.internal.features.publisher;

import android.support.v4.app.FragmentManager;
import com.salesforce.android.cases.core.model.CaseField;
import com.salesforce.android.cases.ui.internal.features.publisher.viewmodel.CasePickListViewModel;
import com.salesforce.android.cases.ui.internal.features.publisher.viewmodel.CaseTextInputViewModel;
import com.salesforce.android.cases.ui.internal.features.shared.BasePresenter;
import com.salesforce.android.cases.ui.internal.features.shared.BaseView;

public interface CasePublisherContract {
   interface Presenter extends BasePresenter<Void, CasePublisherContract.View> {
      void a();

      void a(CasePublisherContract.Presenter.Listener var1);

      void b();

      void c();

      void f();

      boolean g();

      void h();

      interface Listener {
         void d();
      }
   }

   interface View extends BaseView {
      CaseTextInputViewModel a(CaseField var1);

      CasePickListViewModel b(CaseField var1);

      void c();

      void e();

      void f();

      void g();

      void h();

      void i();

      void j();

      void k();

      void l();

      void m();

      void n();

      void p_();

      void q_();

      void r_();

      void setFragmentManager(FragmentManager var1);

      void setPresenter(CasePublisherContract.Presenter var1);
   }
}
