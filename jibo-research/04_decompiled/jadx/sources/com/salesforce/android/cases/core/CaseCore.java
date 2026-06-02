package com.salesforce.android.cases.core;

import android.content.Context;
import com.salesforce.android.cases.core.internal.client.CaseClientImpl;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class CaseCore {

    /* JADX INFO: renamed from: a */
    private final CaseConfiguration f12269a;

    /* JADX INFO: renamed from: a */
    public static CaseCore m12187a(CaseConfiguration caseConfiguration) {
        return new CaseCore(caseConfiguration);
    }

    private CaseCore(CaseConfiguration caseConfiguration) {
        this.f12269a = caseConfiguration;
    }

    /* JADX INFO: renamed from: a */
    public Async<CaseClient> m12188a(Context context) {
        try {
            return BasicAsync.m14084c(CaseClientImpl.m12196a(this.f12269a).m12200a(context).m12201a());
        } catch (IllegalStateException e) {
            return BasicAsync.m14085c((Throwable) e);
        } catch (GeneralSecurityException e2) {
            return BasicAsync.m14085c((Throwable) e2);
        }
    }
}
