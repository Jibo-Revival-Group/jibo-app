package com.salesforce.android.cases.p020ui.internal.features.publisher;

import com.salesforce.android.cases.p020ui.internal.features.publisher.CasePublisherContract;
import com.salesforce.android.cases.p020ui.internal.features.shared.BaseActivityDelegate;

/* JADX INFO: loaded from: classes.dex */
public class CasePublisherActivityDelegate extends BaseActivityDelegate<CasePublisherActivity, CasePublisherContract.Presenter> implements CasePublisherContract.Presenter.Listener {

    /* JADX INFO: renamed from: a */
    private CasePublisherActivity f12775a;

    /* JADX INFO: renamed from: b */
    private CasePublisherContract.Presenter f12776b;

    public CasePublisherActivityDelegate(CasePublisherActivity casePublisherActivity) {
        super(casePublisherActivity, CasePublisherContract.Presenter.class);
        this.f12775a = casePublisherActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.p020ui.internal.features.shared.BaseActivityDelegate
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo12746a(CasePublisherContract.Presenter presenter) {
        this.f12776b = presenter;
        presenter.mo12933a((CasePublisherContract.Presenter.Listener) this);
        this.f12775a.m12929a().setFragmentManager(this.f12775a.getSupportFragmentManager());
        presenter.mo12786a(this.f12775a.m12929a());
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.shared.BaseActivityDelegate
    /* JADX INFO: renamed from: a */
    public void mo12744a() {
        if (this.f12776b != null) {
            this.f12776b.mo12936f();
        }
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.shared.BaseActivityDelegate
    /* JADX INFO: renamed from: c */
    public boolean mo12748c() {
        return this.f12776b != null && this.f12776b.mo12937g();
    }

    @Override // com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherContract.Presenter.Listener
    /* JADX INFO: renamed from: d */
    public void mo12931d() {
        this.f12775a.finish();
    }
}
