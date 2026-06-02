package com.salesforce.androidsdk.app;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.salesforce.androidsdk.security.PasscodeManager;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceSDKUpgradeManager {

    /* JADX INFO: renamed from: a */
    private static SalesforceSDKUpgradeManager f14137a = null;

    /* JADX INFO: renamed from: a */
    public static synchronized SalesforceSDKUpgradeManager m14463a() {
        if (f14137a == null) {
            f14137a = new SalesforceSDKUpgradeManager();
        }
        return f14137a;
    }

    /* JADX INFO: renamed from: b */
    public void mo14466b() {
        m14467c();
    }

    /* JADX INFO: renamed from: c */
    protected synchronized void m14467c() {
        String strM14468d = m14468d();
        if (!strM14468d.equals("5.3.0")) {
            m14465a("acc_mgr_version", "5.3.0");
            if (TextUtils.isEmpty(strM14468d)) {
                strM14468d = m14468d();
            }
            try {
                if (Double.parseDouble(strM14468d.substring(0, 3)) < 2.2d) {
                    mo14469e();
                }
            } catch (NumberFormatException e) {
                SalesforceSDKLogger.m15016a("SalesforceSDKUpgradeManager", "Failed to parse installed version", e);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected synchronized void m14465a(String str, String str2) {
        SalesforceSDKManager.m14403a().m14446k().getSharedPreferences("version_info", 0).edit().putString(str, str2).commit();
    }

    /* JADX INFO: renamed from: d */
    public String m14468d() {
        return m14464a("acc_mgr_version");
    }

    /* JADX INFO: renamed from: a */
    protected String m14464a(String str) {
        return SalesforceSDKManager.m14403a().m14446k().getSharedPreferences("version_info", 0).getString(str, "");
    }

    /* JADX INFO: renamed from: e */
    protected void mo14469e() {
        AccountManager accountManager = AccountManager.get(SalesforceSDKManager.m14403a().m14446k());
        Account[] accountsByType = accountManager.getAccountsByType(SalesforceSDKManager.m14403a().m14420B());
        if (accountsByType != null && accountsByType.length > 0) {
            Account account = accountsByType[0];
            SalesforceSDKManager.m14403a().m14450o().m14272a(SalesforceSDKManager.m14418e(accountManager.getUserData(account, "userId"), SalesforceSDKManager.m14403a().m14455t()), SalesforceSDKManager.m14418e(accountManager.getUserData(account, "orgId"), SalesforceSDKManager.m14403a().m14455t()));
            String str = SalesforceSDKManager.m14403a().m14446k().getApplicationInfo().dataDir + "/shared_prefs";
            File file = new File(str, "gcm_prefs.xml");
            if (file.exists()) {
                file.renameTo(new File(str, "gcm_prefs" + SalesforceSDKManager.m14403a().m14450o().m14266a(account).m14261u() + ".xml"));
            }
            SalesforceSDKManager.m14403a().m14451p().m14498a(SalesforceSDKManager.m14403a().m14451p().m14497a(null), SalesforceSDKManager.m14403a().m14450o().m14266a(account));
            SharedPreferences.Editor editorEdit = SalesforceSDKManager.m14403a().m14446k().getSharedPreferences("admin_prefs", 0).edit();
            editorEdit.clear();
            editorEdit.commit();
            PasscodeManager passcodeManagerM14449n = SalesforceSDKManager.m14403a().m14449n();
            passcodeManagerM14449n.m14638a(SalesforceSDKManager.m14403a().m14450o().m14275b(), passcodeManagerM14449n.m14656g(), passcodeManagerM14449n.m14657h());
        }
        SharedPreferences.Editor editorEdit2 = SalesforceSDKManager.m14403a().m14446k().getSharedPreferences("server_url_prefs", 0).edit();
        editorEdit2.clear();
        editorEdit2.commit();
    }
}
