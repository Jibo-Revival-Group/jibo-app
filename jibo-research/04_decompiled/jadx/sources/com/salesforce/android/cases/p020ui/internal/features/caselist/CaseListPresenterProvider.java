package com.salesforce.android.cases.p020ui.internal.features.caselist;

import com.salesforce.android.cases.p020ui.CaseUIClient;
import com.salesforce.android.cases.p020ui.internal.features.caselist.CaseListContract;
import com.salesforce.android.cases.p020ui.internal.features.shared.BasePresenter;
import com.salesforce.android.cases.p020ui.internal.features.shared.provider.PresenterProvider;

/* JADX INFO: loaded from: classes.dex */
public class CaseListPresenterProvider implements PresenterProvider<CaseListContract.Presenter> {
    @Override // com.salesforce.android.cases.p020ui.internal.features.shared.provider.PresenterProvider
    /* JADX INFO: renamed from: a */
    public boolean mo12800a(Class<? extends BasePresenter> cls) {
        return cls.isAssignableFrom(CaseListContract.Presenter.class);
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.shared.provider.PresenterProvider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public CaseListContract.Presenter mo12801b(CaseUIClient caseUIClient) {
        return new CaseListPresenter(caseUIClient);
    }
}
