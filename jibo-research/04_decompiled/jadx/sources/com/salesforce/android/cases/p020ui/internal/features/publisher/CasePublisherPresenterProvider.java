package com.salesforce.android.cases.p020ui.internal.features.publisher;

import com.salesforce.android.cases.p020ui.CaseUIClient;
import com.salesforce.android.cases.p020ui.internal.features.publisher.CasePublisherContract;
import com.salesforce.android.cases.p020ui.internal.features.shared.BasePresenter;
import com.salesforce.android.cases.p020ui.internal.features.shared.provider.PresenterProvider;
import com.salesforce.android.cases.p020ui.internal.utils.HandlerFactory;

/* JADX INFO: loaded from: classes.dex */
public class CasePublisherPresenterProvider implements PresenterProvider<CasePublisherContract.Presenter> {
    @Override // com.salesforce.android.cases.p020ui.internal.features.shared.provider.PresenterProvider
    /* JADX INFO: renamed from: a */
    public boolean mo12800a(Class<? extends BasePresenter> cls) {
        return cls.isAssignableFrom(CasePublisherContract.Presenter.class);
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.shared.provider.PresenterProvider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public CasePublisherContract.Presenter mo12801b(CaseUIClient caseUIClient) {
        return new CasePublisherPresenter(caseUIClient, new HandlerFactory());
    }
}
