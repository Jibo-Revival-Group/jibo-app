package com.salesforce.android.cases.ui.internal.features.casefeed;

import android.content.Context;
import com.salesforce.android.cases.ui.internal.features.shared.BasePresenter;
import com.salesforce.android.cases.ui.internal.features.shared.BaseView;
import java.util.List;

public interface CaseFeedContract {
   interface Presenter extends BasePresenter<String, CaseFeedContract.View> {
      void a();

      void a(CaseFeedContract.Presenter.Listener var1);

      void a(String var1);

      void b();

      void c();

      interface Listener {
         void b();
      }
   }

   interface View extends BaseView {
      void a(Object var1);

      void a(List<Object> var1);

      void e();

      void f();

      void g();

      Context getApplicationContext();

      void h();

      void h_();

      void i();

      void i_();

      void j();

      void j_();

      void k();

      void k_();

      void l();

      void m();

      void n();

      void o();

      void setCaseId(String var1);

      void setPresenter(CaseFeedContract.Presenter var1);

      void setTitle(String var1);
   }
}
