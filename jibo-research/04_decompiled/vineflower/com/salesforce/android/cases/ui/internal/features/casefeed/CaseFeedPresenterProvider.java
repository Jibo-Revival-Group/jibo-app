package com.salesforce.android.cases.ui.internal.features.casefeed;

import com.salesforce.android.cases.ui.CaseUIClient;
import com.salesforce.android.cases.ui.internal.features.shared.BasePresenter;
import com.salesforce.android.cases.ui.internal.features.shared.provider.PresenterProvider;

public class CaseFeedPresenterProvider implements PresenterProvider<CaseFeedContract.Presenter> {
   public CaseFeedContract.Presenter a(CaseUIClient var1) {
      return new CaseFeedPresenter(var1);
   }

   @Override
   public boolean a(Class<? extends BasePresenter> var1) {
      return var1.isAssignableFrom(CaseFeedContract.Presenter.class);
   }
}
