package com.salesforce.androidsdk.accounts;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.share.internal.ShareConstants;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ClientManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public class UserAccountManager {

    /* JADX INFO: renamed from: a */
    private static UserAccountManager f13985a;

    /* JADX INFO: renamed from: b */
    private Context f13986b = SalesforceSDKManager.m14403a().m14446k();

    /* JADX INFO: renamed from: c */
    private AccountManager f13987c = AccountManager.get(this.f13986b);

    /* JADX INFO: renamed from: d */
    private String f13988d = SalesforceSDKManager.m14403a().m14420B();

    /* JADX INFO: renamed from: a */
    public static UserAccountManager m14264a() {
        if (f13985a == null) {
            f13985a = new UserAccountManager();
        }
        return f13985a;
    }

    protected UserAccountManager() {
    }

    /* JADX INFO: renamed from: a */
    public void m14272a(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.f13986b.getSharedPreferences("current_user_info", 0).edit();
        editorEdit.putString(AccessToken.USER_ID_KEY, str);
        editorEdit.putString("org_id", str2);
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: b */
    public UserAccount m14275b() {
        return m14266a(m14276c());
    }

    /* JADX INFO: renamed from: c */
    public Account m14276c() {
        Account[] accountsByType = this.f13987c.getAccountsByType(this.f13988d);
        if (accountsByType == null || accountsByType.length == 0) {
            return null;
        }
        SharedPreferences sharedPreferences = this.f13986b.getSharedPreferences("current_user_info", 0);
        String string = sharedPreferences.getString(AccessToken.USER_ID_KEY, "");
        String string2 = sharedPreferences.getString("org_id", "");
        for (Account account : accountsByType) {
            if (account != null) {
                String strM14455t = SalesforceSDKManager.m14403a().m14455t();
                String strM14418e = SalesforceSDKManager.m14418e(this.f13987c.getUserData(account, "orgId"), strM14455t);
                if (string.trim().equals(SalesforceSDKManager.m14418e(this.f13987c.getUserData(account, "userId"), strM14455t)) && string2.trim().equals(strM14418e)) {
                    return account;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    public List<UserAccount> m14277d() {
        Account[] accountsByType = this.f13987c.getAccountsByType(this.f13988d);
        if (accountsByType == null || accountsByType.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Account account : accountsByType) {
            UserAccount userAccountM14266a = m14266a(account);
            if (userAccountM14266a != null) {
                arrayList.add(userAccountM14266a);
            }
        }
        if (arrayList.size() != 0) {
            return arrayList;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public boolean m14273a(UserAccount userAccount) {
        if (userAccount == null) {
            return false;
        }
        List<UserAccount> listM14277d = m14277d();
        if (listM14277d == null || listM14277d.size() == 0) {
            return false;
        }
        Iterator<UserAccount> it = listM14277d.iterator();
        while (it.hasNext()) {
            if (userAccount.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public void m14269a(UserAccount userAccount, int i, Bundle bundle) {
        if (userAccount == null || !m14273a(userAccount)) {
            m14278e();
            return;
        }
        if (!userAccount.equals(m14275b())) {
            ClientManager clientManager = new ClientManager(this.f13986b, this.f13988d, SalesforceSDKManager.m14403a().m14443h(), true);
            Account accountM14566b = clientManager.m14566b(userAccount.m14249i());
            m14272a(userAccount.m14247g(), userAccount.m14246f());
            clientManager.m14560a(accountM14566b);
            m14267a(i, bundle);
        }
    }

    /* JADX INFO: renamed from: e */
    public void m14278e() {
        m14265a(SalesforceSDKManager.m14403a().m14443h().m14589i());
    }

    /* JADX INFO: renamed from: a */
    private void m14265a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Intent intent = new Intent(this.f13986b, SalesforceSDKManager.m14403a().m14440f());
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.putExtras(bundle);
        bundle2.putParcelable("intent", intent);
        this.f13986b.startActivity(intent);
    }

    /* JADX INFO: renamed from: a */
    public void m14268a(Activity activity) {
        SalesforceSDKManager.m14403a().m14428a(activity);
    }

    /* JADX INFO: renamed from: a */
    public void m14270a(UserAccount userAccount, Activity activity) {
        SalesforceSDKManager.m14403a().m14426a(m14274b(userAccount), activity);
    }

    /* JADX INFO: renamed from: a */
    public void m14271a(UserAccount userAccount, Activity activity, boolean z) {
        SalesforceSDKManager.m14403a().m14427a(m14274b(userAccount), activity, z);
    }

    /* JADX INFO: renamed from: a */
    public UserAccount m14266a(Account account) {
        if (account == null) {
            return null;
        }
        String strM14455t = SalesforceSDKManager.m14403a().m14455t();
        String strM14418e = SalesforceSDKManager.m14418e(this.f13987c.getUserData(account, "authtoken"), strM14455t);
        String strM14418e2 = SalesforceSDKManager.m14418e(this.f13987c.getPassword(account), strM14455t);
        String strM14418e3 = SalesforceSDKManager.m14418e(this.f13987c.getUserData(account, "loginUrl"), strM14455t);
        String strM14418e4 = SalesforceSDKManager.m14418e(this.f13987c.getUserData(account, ShareConstants.WEB_DIALOG_PARAM_ID), strM14455t);
        String strM14418e5 = SalesforceSDKManager.m14418e(this.f13987c.getUserData(account, "instanceUrl"), strM14455t);
        String strM14418e6 = SalesforceSDKManager.m14418e(this.f13987c.getUserData(account, "orgId"), strM14455t);
        String strM14418e7 = SalesforceSDKManager.m14418e(this.f13987c.getUserData(account, "userId"), strM14455t);
        String strM14418e8 = SalesforceSDKManager.m14418e(this.f13987c.getUserData(account, "username"), strM14455t);
        String userData = this.f13987c.getUserData(account, "authAccount");
        String strM14418e9 = SalesforceSDKManager.m14418e(this.f13987c.getUserData(account, "clientId"), strM14455t);
        String strM14418e10 = SalesforceSDKManager.m14418e(this.f13987c.getUserData(account, "last_name"), strM14455t);
        String strM14418e11 = SalesforceSDKManager.m14418e(this.f13987c.getUserData(account, "email"), strM14455t);
        String userData2 = this.f13987c.getUserData(account, "first_name");
        String strM14418e12 = null;
        if (userData2 != null) {
            strM14418e12 = SalesforceSDKManager.m14418e(userData2, strM14455t);
        }
        String strM14418e13 = null;
        if (this.f13987c.getUserData(account, "display_name") != null) {
            strM14418e13 = SalesforceSDKManager.m14418e(this.f13987c.getUserData(account, "display_name"), strM14455t);
        }
        String userData3 = this.f13987c.getUserData(account, "photoUrl");
        String strM14418e14 = null;
        if (userData3 != null) {
            strM14418e14 = SalesforceSDKManager.m14418e(userData3, strM14455t);
        }
        String userData4 = this.f13987c.getUserData(account, "thumbnailUrl");
        String strM14418e15 = null;
        if (userData4 != null) {
            strM14418e15 = SalesforceSDKManager.m14418e(userData4, strM14455t);
        }
        HashMap map = null;
        List<String> listM14457v = SalesforceSDKManager.m14403a().m14457v();
        if (listM14457v != null && !listM14457v.isEmpty()) {
            map = new HashMap();
            for (String str : listM14457v) {
                if (!TextUtils.isEmpty(str)) {
                    String userData5 = this.f13987c.getUserData(account, str);
                    String strM14418e16 = null;
                    if (userData5 != null) {
                        strM14418e16 = SalesforceSDKManager.m14418e(userData5, strM14455t);
                    }
                    map.put(str, strM14418e16);
                }
            }
        }
        String userData6 = this.f13987c.getUserData(account, "communityId");
        String strM14418e17 = null;
        if (userData6 != null) {
            strM14418e17 = SalesforceSDKManager.m14418e(userData6, strM14455t);
        }
        String userData7 = this.f13987c.getUserData(account, "communityUrl");
        String strM14418e18 = null;
        if (userData7 != null) {
            strM14418e18 = SalesforceSDKManager.m14418e(userData7, strM14455t);
        }
        if (strM14418e == null || strM14418e5 == null || strM14418e7 == null || strM14418e6 == null) {
            return null;
        }
        return new UserAccount(strM14418e, strM14418e2, strM14418e3, strM14418e4, strM14418e5, strM14418e6, strM14418e7, strM14418e8, userData, strM14418e9, strM14418e17, strM14418e18, strM14418e12, strM14418e10, strM14418e13, strM14418e11, strM14418e14, strM14418e15, map);
    }

    /* JADX INFO: renamed from: b */
    public Account m14274b(UserAccount userAccount) {
        Account[] accountsByType = this.f13987c.getAccountsByType(this.f13988d);
        if (userAccount == null) {
            return null;
        }
        if (accountsByType == null || accountsByType.length == 0) {
            return null;
        }
        String strM14247g = userAccount.m14247g() == null ? "" : userAccount.m14247g();
        String strM14246f = userAccount.m14246f() == null ? "" : userAccount.m14246f();
        for (Account account : accountsByType) {
            if (account != null) {
                String strM14455t = SalesforceSDKManager.m14403a().m14455t();
                String strM14418e = SalesforceSDKManager.m14418e(this.f13987c.getUserData(account, "orgId"), strM14455t);
                if (strM14247g.trim().equals(SalesforceSDKManager.m14418e(this.f13987c.getUserData(account, "userId"), strM14455t).trim()) && strM14246f.trim().equals(strM14418e.trim())) {
                    return account;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public final void m14267a(int i, Bundle bundle) {
        Intent intent = new Intent("com.salesforce.USERSWITCHED");
        intent.setPackage(this.f13986b.getPackageName());
        intent.putExtra("com.salesforce.USER_SWITCH_TYPE", i);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        SalesforceSDKManager.m14403a().m14446k().sendBroadcast(intent);
    }
}
