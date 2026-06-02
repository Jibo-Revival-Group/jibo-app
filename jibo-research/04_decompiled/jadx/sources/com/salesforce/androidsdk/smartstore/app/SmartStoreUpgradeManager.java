package com.salesforce.androidsdk.smartstore.app;

import android.text.TextUtils;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.app.SalesforceSDKUpgradeManager;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class SmartStoreUpgradeManager extends SalesforceSDKUpgradeManager {

    /* JADX INFO: renamed from: a */
    private static SmartStoreUpgradeManager f14280a = null;

    /* JADX INFO: renamed from: f */
    public static synchronized SmartStoreUpgradeManager m14673f() {
        if (f14280a == null) {
            f14280a = new SmartStoreUpgradeManager();
        }
        return f14280a;
    }

    @Override // com.salesforce.androidsdk.app.SalesforceSDKUpgradeManager
    /* JADX INFO: renamed from: b */
    public void mo14466b() {
        super.mo14466b();
        m14674g();
    }

    /* JADX INFO: renamed from: g */
    protected synchronized void m14674g() {
        String strM14675h = m14675h();
        if (!strM14675h.equals("5.3.0")) {
            m14465a("smart_store_version", "5.3.0");
            if (TextUtils.isEmpty(strM14675h)) {
                m14675h();
            }
        }
    }

    /* JADX INFO: renamed from: h */
    public String m14675h() {
        return m14464a("smart_store_version");
    }

    @Override // com.salesforce.androidsdk.app.SalesforceSDKUpgradeManager
    /* JADX INFO: renamed from: e */
    protected void mo14469e() {
        UserAccount userAccountM14275b;
        super.mo14469e();
        String str = String.format("smartstore%s.db", "");
        if (SmartStoreSDKManager.m14661H().m14446k().getDatabasePath(str).exists() && (userAccountM14275b = SmartStoreSDKManager.m14661H().m14450o().m14275b()) != null) {
            String strM14241a = userAccountM14275b.m14241a(null);
            if (!TextUtils.isEmpty(strM14241a)) {
                String str2 = String.format("smartstore%s.db", strM14241a);
                String str3 = SmartStoreSDKManager.m14661H().m14446k().getApplicationInfo().dataDir + "/databases";
                new File(str3, str).renameTo(new File(str3, str2));
            }
        }
    }
}
