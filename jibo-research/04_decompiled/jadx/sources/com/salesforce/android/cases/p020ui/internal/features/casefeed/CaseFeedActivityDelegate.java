package com.salesforce.android.cases.p020ui.internal.features.casefeed;

import com.salesforce.android.cases.p020ui.internal.features.casefeed.CaseFeedContract;
import com.salesforce.android.cases.p020ui.internal.features.shared.BaseActivityDelegate;

/* JADX INFO: loaded from: classes.dex */
class CaseFeedActivityDelegate extends BaseActivityDelegate<CaseFeedActivity, CaseFeedContract.Presenter> implements CaseFeedContract.Presenter.Listener {

    /* JADX INFO: renamed from: a */
    private CaseFeedActivity f12632a;

    /* JADX INFO: renamed from: b */
    private CaseFeedContract.Presenter f12633b;

    CaseFeedActivityDelegate(CaseFeedActivity caseFeedActivity) {
        super(caseFeedActivity, CaseFeedContract.Presenter.class);
        this.f12632a = caseFeedActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.p020ui.internal.features.shared.BaseActivityDelegate
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo12746a(CaseFeedContract.Presenter presenter) {
        this.f12633b = presenter;
        presenter.mo12750a((CaseFeedContract.Presenter.Listener) this);
        presenter.mo12786a(this.f12632a.m12743a());
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.shared.BaseActivityDelegate
    /* JADX INFO: renamed from: a */
    public void mo12744a() {
        if (this.f12633b != null) {
            this.f12633b.mo12752b();
        }
    }

    @Override // com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedContract.Presenter.Listener
    /* JADX INFO: renamed from: b */
    public void mo12747b() {
        this.f12632a.finish();
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.shared.BaseActivityDelegate
    /* JADX INFO: renamed from: c */
    public boolean mo12748c() {
        if (this.f12633b != null) {
            this.f12633b.mo12749a();
            return false;
        }
        return false;
    }
}
