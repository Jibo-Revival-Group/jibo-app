package com.salesforce.android.cases.ui.internal.features.caselist;

import com.salesforce.android.cases.ui.CaseUIClient;
import com.salesforce.android.cases.ui.internal.features.shared.BasePresenter;
import com.salesforce.android.cases.ui.internal.features.shared.provider.PresenterProvider;

public class CaseListPresenterProvider implements PresenterProvider<CaseListContract.Presenter> {
   public CaseListContract.Presenter a(CaseUIClient var1) {
      return new CaseListPresenter(var1);
   }

   @Override
   public boolean a(Class<? extends BasePresenter> var1) {
      return var1.isAssignableFrom(CaseListContract.Presenter.class);
   }
}
