package com.salesforce.android.cases.p020ui.internal.features.shared;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.salesforce.android.cases.p020ui.CaseUI;
import com.salesforce.android.cases.p020ui.CaseUIClient;
import com.salesforce.android.cases.p020ui.internal.client.CaseUIClientImpl;
import com.salesforce.android.cases.p020ui.internal.features.shared.BasePresenter;
import com.salesforce.android.cases.p020ui.internal.features.shared.manager.PresenterManager;
import com.salesforce.android.service.common.utilities.control.Async;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseActivityDelegate<A extends AppCompatActivity, P extends BasePresenter> {

    /* JADX INFO: renamed from: a */
    private A f12825a;

    /* JADX INFO: renamed from: b */
    private Class<P> f12826b;

    /* JADX INFO: renamed from: c */
    private P f12827c;

    /* JADX INFO: renamed from: d */
    private PresenterManager f12828d;

    /* JADX INFO: renamed from: a */
    protected abstract void mo12746a(P p);

    public BaseActivityDelegate(A a, Class<P> cls) {
        this.f12825a = a;
        this.f12826b = cls;
    }

    /* JADX INFO: renamed from: a */
    public void m13008a(Bundle bundle) {
        CaseUI.m12706a(this.f12825a).m12712a().mo14074a(new Async.ResultHandler<CaseUIClient>() { // from class: com.salesforce.android.cases.ui.internal.features.shared.BaseActivityDelegate.1
            @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
            /* JADX INFO: renamed from: a */
            public /* bridge */ /* synthetic */ void mo9875a(Async async, CaseUIClient caseUIClient) {
                a2((Async<?>) async, caseUIClient);
            }

            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
            public void a2(Async<?> async, CaseUIClient caseUIClient) {
                BaseActivityDelegate.this.m13006a(caseUIClient);
            }
        });
    }

    /* JADX INFO: renamed from: g_ */
    public void mo12836g_() {
    }

    /* JADX INFO: renamed from: b */
    public void m13009b(Bundle bundle) {
        if (this.f12827c != null) {
            this.f12827c.mo12789d();
        }
    }

    /* JADX INFO: renamed from: a */
    public void mo12744a() {
    }

    /* JADX INFO: renamed from: c */
    public boolean mo12748c() {
        return false;
    }

    /* JADX INFO: renamed from: e */
    public void m13010e() {
        this.f12828d.m13017a((Class<? extends BasePresenter>) this.f12826b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m13006a(CaseUIClient caseUIClient) {
        this.f12828d = ((CaseUIClientImpl) caseUIClient).m12739g();
        this.f12827c = (P) this.f12828d.m13016a(caseUIClient, this.f12826b);
        mo12746a(this.f12827c);
    }
}
