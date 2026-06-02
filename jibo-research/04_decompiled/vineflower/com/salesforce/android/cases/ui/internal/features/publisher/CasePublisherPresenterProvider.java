package com.salesforce.android.cases.ui.internal.features.publisher;

import com.salesforce.android.cases.ui.CaseUIClient;
import com.salesforce.android.cases.ui.internal.features.shared.BasePresenter;
import com.salesforce.android.cases.ui.internal.features.shared.provider.PresenterProvider;
import com.salesforce.android.cases.ui.internal.utils.HandlerFactory;

public class CasePublisherPresenterProvider implements PresenterProvider<CasePublisherContract.Presenter> {
   public CasePublisherContract.Presenter a(CaseUIClient var1) {
      return new CasePublisherPresenter(var1, new HandlerFactory());
   }

   @Override
   public boolean a(Class<? extends BasePresenter> var1) {
      return var1.isAssignableFrom(CasePublisherContract.Presenter.class);
   }
}
