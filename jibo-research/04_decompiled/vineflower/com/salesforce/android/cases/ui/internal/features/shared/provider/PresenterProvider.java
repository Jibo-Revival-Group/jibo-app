package com.salesforce.android.cases.ui.internal.features.shared.provider;

import com.salesforce.android.cases.ui.CaseUIClient;
import com.salesforce.android.cases.ui.internal.features.shared.BasePresenter;

public interface PresenterProvider<P extends BasePresenter> {
   boolean a(Class<? extends BasePresenter> var1);

   P b(CaseUIClient var1);
}
