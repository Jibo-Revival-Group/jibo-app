package com.salesforce.android.cases.p020ui.internal.features.shared.provider;

import com.salesforce.android.cases.p020ui.CaseUIClient;
import com.salesforce.android.cases.p020ui.internal.features.shared.BasePresenter;

/* JADX INFO: loaded from: classes.dex */
public interface PresenterProvider<P extends BasePresenter> {
    /* JADX INFO: renamed from: a */
    boolean mo12800a(Class<? extends BasePresenter> cls);

    /* JADX INFO: renamed from: b */
    P mo12801b(CaseUIClient caseUIClient);
}
