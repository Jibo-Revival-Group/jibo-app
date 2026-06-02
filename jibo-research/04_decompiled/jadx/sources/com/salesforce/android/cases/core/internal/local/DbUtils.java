package com.salesforce.android.cases.core.internal.local;

import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class DbUtils {
    /* JADX INFO: renamed from: a */
    public static boolean m12369a(UserAccount userAccount) {
        List<UserAccount> listM14277d = SalesforceSDKManager.m14403a().m14450o().m14277d();
        return listM14277d != null && listM14277d.contains(userAccount);
    }
}
