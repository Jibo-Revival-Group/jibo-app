package com.salesforce.android.cases.p020ui;

import android.annotation.SuppressLint;
import android.content.Context;
import com.salesforce.android.cases.core.CaseClient;
import com.salesforce.android.cases.core.CaseCore;
import com.salesforce.android.cases.core.internal.client.CaseClientImpl;
import com.salesforce.android.cases.core.internal.util.ReturnValue;
import com.salesforce.android.cases.p020ui.internal.client.CaseUIClientImpl;
import com.salesforce.android.service.common.utilities.control.Async;

/* JADX INFO: loaded from: classes.dex */
public class CaseUI {

    /* JADX INFO: renamed from: a */
    @SuppressLint({"StaticFieldLeak"})
    static CaseUI f12609a;

    /* JADX INFO: renamed from: b */
    private Context f12610b;

    /* JADX INFO: renamed from: c */
    private CaseUIConfiguration f12611c;

    /* JADX INFO: renamed from: d */
    private CaseUIClient f12612d;

    private CaseUI(Context context) {
        this.f12610b = context.getApplicationContext();
    }

    /* JADX INFO: renamed from: a */
    public static CaseUI m12706a(Context context) {
        if (f12609a == null) {
            f12609a = new CaseUI(context);
        }
        return f12609a;
    }

    /* JADX INFO: renamed from: a */
    public CaseUI m12711a(CaseUIConfiguration caseUIConfiguration) {
        this.f12611c = caseUIConfiguration;
        m12709b();
        return this;
    }

    /* JADX INFO: renamed from: a */
    public Async<CaseUIClient> m12712a() {
        if (this.f12611c == null) {
            throw new IllegalStateException("You must configure with a CaseUIConfiguration prior to retrieving a CaseUIClient.");
        }
        final ReturnValue returnValue = new ReturnValue();
        if (this.f12612d != null) {
            returnValue.mo12614b(this.f12612d);
        } else {
            CaseCore.m12187a(this.f12611c.m12727c()).m12188a(this.f12610b).mo14074a(new Async.ResultHandler<CaseClient>() { // from class: com.salesforce.android.cases.ui.CaseUI.2
                @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
                /* JADX INFO: renamed from: a */
                public /* bridge */ /* synthetic */ void mo9875a(Async async, CaseClient caseClient) {
                    a2((Async<?>) async, caseClient);
                }

                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
                public void a2(Async<?> async, CaseClient caseClient) {
                    CaseUI.this.f12612d = CaseUIClientImpl.m12736a(CaseUI.this.f12610b, CaseUI.this.f12611c, caseClient);
                    if (caseClient instanceof CaseClientImpl) {
                        ((CaseClientImpl) caseClient).m12199a((CaseUIClientImpl) CaseUI.this.f12612d);
                    }
                    returnValue.mo12614b(CaseUI.this.f12612d);
                }
            }).mo14073a(new Async.ErrorHandler() { // from class: com.salesforce.android.cases.ui.CaseUI.1
                @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
                /* JADX INFO: renamed from: a */
                public void mo12581a(Async<?> async, Throwable th) {
                    returnValue.mo12615b(th);
                }
            });
        }
        return returnValue;
    }

    /* JADX INFO: renamed from: b */
    private void m12709b() {
        if (this.f12612d != null) {
            this.f12612d.mo12721f();
            this.f12612d = null;
        }
    }
}
