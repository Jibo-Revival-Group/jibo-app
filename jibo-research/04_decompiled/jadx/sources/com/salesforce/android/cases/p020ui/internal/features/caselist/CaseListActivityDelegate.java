package com.salesforce.android.cases.p020ui.internal.features.caselist;

import com.salesforce.android.cases.p020ui.internal.features.caselist.CaseListContract;
import com.salesforce.android.cases.p020ui.internal.features.shared.BaseActivityDelegate;

/* JADX INFO: loaded from: classes.dex */
public class CaseListActivityDelegate extends BaseActivityDelegate<CaseListActivity, CaseListContract.Presenter> implements CaseListContract.Presenter.Listener {

    /* JADX INFO: renamed from: a */
    private CaseListActivity f12700a;

    /* JADX INFO: renamed from: b */
    private CaseListContract.Presenter f12701b;

    public CaseListActivityDelegate(CaseListActivity caseListActivity) {
        super(caseListActivity, CaseListContract.Presenter.class);
        this.f12700a = caseListActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.p020ui.internal.features.shared.BaseActivityDelegate
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo12746a(CaseListContract.Presenter presenter) {
        this.f12701b = presenter;
        presenter.mo12848a((CaseListContract.Presenter.Listener) this);
        presenter.mo12786a(this.f12700a.m12833a());
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.shared.BaseActivityDelegate
    /* JADX INFO: renamed from: g_ */
    public void mo12836g_() {
        if (this.f12701b != null) {
            this.f12701b.mo12857i();
        }
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.shared.BaseActivityDelegate
    /* JADX INFO: renamed from: a */
    public void mo12744a() {
        if (this.f12701b != null) {
            this.f12701b.mo12855g();
        }
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.Presenter.Listener
    /* JADX INFO: renamed from: d */
    public void mo12835d() {
        this.f12700a.finish();
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.shared.BaseActivityDelegate
    /* JADX INFO: renamed from: c */
    public boolean mo12748c() {
        if (this.f12701b != null) {
            this.f12701b.mo12850b();
            return false;
        }
        return false;
    }
}
