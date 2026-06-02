package com.salesforce.androidsdk.rest;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.NetworkErrorException;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.share.internal.ShareConstants;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.auth.HttpAccess;
import com.salesforce.androidsdk.auth.OAuth2;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ClientManager {

    /* JADX INFO: renamed from: a */
    private final AccountManager f14201a;

    /* JADX INFO: renamed from: b */
    private final String f14202b;

    /* JADX INFO: renamed from: c */
    private final LoginOptions f14203c;

    /* JADX INFO: renamed from: d */
    private final boolean f14204d;

    public interface RestClientCallback {
        /* JADX INFO: renamed from: a */
        void mo14590a(RestClient restClient);
    }

    public ClientManager(Context context, String str, LoginOptions loginOptions, boolean z) {
        this.f14201a = AccountManager.get(context);
        this.f14202b = str;
        this.f14203c = loginOptions;
        this.f14204d = z;
    }

    /* JADX INFO: renamed from: a */
    public void m14563a(Activity activity, RestClientCallback restClientCallback) {
        Account accountM14568c = m14568c();
        Bundle bundleM14589i = this.f14203c.m14589i();
        if (accountM14568c == null) {
            SalesforceSDKLogger.m15019c("ClientManager", "No account of type " + this.f14202b + " found");
            this.f14201a.addAccount(m14569d(), "authtoken", null, bundleM14589i, activity, new AccMgrCallback(restClientCallback), null);
        } else {
            SalesforceSDKLogger.m15019c("ClientManager", "Found account of type " + this.f14202b);
            restClientCallback.mo14590a(m14567b());
        }
    }

    /* JADX INFO: renamed from: a */
    public RestClient m14559a() {
        return new RestClient(new RestClient.UnauthenticatedClientInfo(), null, HttpAccess.f14141a, null);
    }

    /* JADX INFO: renamed from: b */
    public RestClient m14567b() {
        return m14560a(m14568c());
    }

    /* JADX INFO: renamed from: a */
    public RestClient m14561a(UserAccount userAccount) {
        return m14560a(m14566b(userAccount.m14249i()));
    }

    /* JADX INFO: renamed from: a */
    public RestClient m14560a(Account account) {
        String strM14455t;
        if (account == null) {
            AccountInfoNotFoundException accountInfoNotFoundException = new AccountInfoNotFoundException("No user account found");
            SalesforceSDKLogger.m15020c("ClientManager", "No user account found", accountInfoNotFoundException);
            throw accountInfoNotFoundException;
        }
        if (SalesforceSDKManager.m14403a().m14422D()) {
            AccountInfoNotFoundException accountInfoNotFoundException2 = new AccountInfoNotFoundException("User is logging out");
            SalesforceSDKLogger.m15020c("ClientManager", "User is logging out", accountInfoNotFoundException2);
            throw accountInfoNotFoundException2;
        }
        if (!SalesforceSDKManager.m14403a().m14421C()) {
            strM14455t = SalesforceSDKManager.m14403a().m14455t();
        } else {
            strM14455t = this.f14203c.f14216b;
        }
        String strM14418e = SalesforceSDKManager.m14418e(this.f14201a.getUserData(account, "authtoken"), strM14455t);
        String strM14418e2 = SalesforceSDKManager.m14418e(this.f14201a.getPassword(account), strM14455t);
        String strM14418e3 = SalesforceSDKManager.m14418e(this.f14201a.getUserData(account, "loginUrl"), strM14455t);
        String strM14418e4 = SalesforceSDKManager.m14418e(this.f14201a.getUserData(account, ShareConstants.WEB_DIALOG_PARAM_ID), strM14455t);
        String strM14418e5 = SalesforceSDKManager.m14418e(this.f14201a.getUserData(account, "instanceUrl"), strM14455t);
        String strM14418e6 = SalesforceSDKManager.m14418e(this.f14201a.getUserData(account, "orgId"), strM14455t);
        String strM14418e7 = SalesforceSDKManager.m14418e(this.f14201a.getUserData(account, "userId"), strM14455t);
        String strM14418e8 = SalesforceSDKManager.m14418e(this.f14201a.getUserData(account, "username"), strM14455t);
        String userData = this.f14201a.getUserData(account, "authAccount");
        String strM14418e9 = SalesforceSDKManager.m14418e(this.f14201a.getUserData(account, "clientId"), strM14455t);
        String strM14418e10 = SalesforceSDKManager.m14418e(this.f14201a.getUserData(account, "last_name"), strM14455t);
        String strM14418e11 = SalesforceSDKManager.m14418e(this.f14201a.getUserData(account, "email"), strM14455t);
        String userData2 = this.f14201a.getUserData(account, "first_name");
        String strM14418e12 = null;
        if (userData2 != null) {
            strM14418e12 = SalesforceSDKManager.m14418e(userData2, strM14455t);
        }
        String userData3 = this.f14201a.getUserData(account, "display_name");
        String strM14418e13 = null;
        if (userData3 != null) {
            strM14418e13 = SalesforceSDKManager.m14418e(userData3, strM14455t);
        }
        String userData4 = this.f14201a.getUserData(account, "photoUrl");
        String strM14418e14 = null;
        if (userData4 != null) {
            strM14418e14 = SalesforceSDKManager.m14418e(userData4, strM14455t);
        }
        String userData5 = this.f14201a.getUserData(account, "thumbnailUrl");
        String strM14418e15 = null;
        if (userData5 != null) {
            strM14418e15 = SalesforceSDKManager.m14418e(userData5, strM14455t);
        }
        List<String> listM14457v = SalesforceSDKManager.m14403a().m14457v();
        HashMap map = null;
        if (listM14457v != null && !listM14457v.isEmpty()) {
            map = new HashMap();
            for (String str : listM14457v) {
                String userData6 = this.f14201a.getUserData(account, str);
                if (userData6 != null) {
                    map.put(str, SalesforceSDKManager.m14418e(userData6, SalesforceSDKManager.m14403a().m14455t()));
                }
            }
        }
        String userData7 = this.f14201a.getUserData(account, "communityId");
        String strM14418e16 = null;
        if (userData7 != null) {
            strM14418e16 = SalesforceSDKManager.m14418e(userData7, strM14455t);
        }
        String userData8 = this.f14201a.getUserData(account, "communityUrl");
        String strM14418e17 = null;
        if (userData8 != null) {
            strM14418e17 = SalesforceSDKManager.m14418e(userData8, strM14455t);
        }
        if (strM14418e == null) {
            throw new AccountInfoNotFoundException("authtoken");
        }
        if (strM14418e5 == null) {
            throw new AccountInfoNotFoundException("instanceUrl");
        }
        if (strM14418e7 == null) {
            throw new AccountInfoNotFoundException("userId");
        }
        if (strM14418e6 == null) {
            throw new AccountInfoNotFoundException("orgId");
        }
        try {
            return new RestClient(new RestClient.ClientInfo(strM14418e9, new URI(strM14418e5), new URI(strM14418e3), new URI(strM14418e4), userData, strM14418e8, strM14418e7, strM14418e6, strM14418e16, strM14418e17, strM14418e12, strM14418e10, strM14418e13, strM14418e11, strM14418e14, strM14418e15, map), strM14418e, HttpAccess.f14141a, new AccMgrAuthTokenProvider(this, strM14418e5, strM14418e, strM14418e2));
        } catch (URISyntaxException e) {
            SalesforceSDKLogger.m15018b("ClientManager", "Invalid server URL", e);
            throw new AccountInfoNotFoundException("invalid server url", e);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m14564a(String str) {
        this.f14201a.invalidateAuthToken(m14569d(), str);
    }

    /* JADX INFO: renamed from: c */
    public Account m14568c() {
        return SalesforceSDKManager.m14403a().m14450o().m14276c();
    }

    /* JADX INFO: renamed from: b */
    public Account m14566b(String str) {
        Account[] accountsByType = this.f14201a.getAccountsByType(m14569d());
        if (accountsByType != null) {
            for (Account account : accountsByType) {
                if (account.name.equals(str)) {
                    return account;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void m14565a(Account[] accountArr) {
        ArrayList arrayList = new ArrayList();
        for (Account account : accountArr) {
            arrayList.add(this.f14201a.removeAccount(account, null, null));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                ((AccountManagerFuture) it.next()).getResult();
            } catch (Exception e) {
                SalesforceSDKLogger.m15018b("ClientManager", "Exception removing old account", e);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public Bundle m14558a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, Map<String, String> map) {
        Bundle bundle = new Bundle();
        bundle.putString("authAccount", str);
        bundle.putString("accountType", m14569d());
        bundle.putString("username", SalesforceSDKManager.m14417d(str2, str11));
        bundle.putString("loginUrl", SalesforceSDKManager.m14417d(str6, str11));
        bundle.putString(ShareConstants.WEB_DIALOG_PARAM_ID, SalesforceSDKManager.m14417d(str7, str11));
        bundle.putString("instanceUrl", SalesforceSDKManager.m14417d(str5, str11));
        bundle.putString("clientId", SalesforceSDKManager.m14417d(str8, str11));
        bundle.putString("orgId", SalesforceSDKManager.m14417d(str9, str11));
        bundle.putString("userId", SalesforceSDKManager.m14417d(str10, str11));
        if (str12 != null) {
            bundle.putString("clientSecret", SalesforceSDKManager.m14417d(str12, str11));
        }
        if (str13 != null) {
            bundle.putString("communityId", SalesforceSDKManager.m14417d(str13, str11));
        }
        if (str14 != null) {
            bundle.putString("communityUrl", SalesforceSDKManager.m14417d(str14, str11));
        }
        bundle.putString("authtoken", SalesforceSDKManager.m14417d(str4, str11));
        bundle.putString("first_name", SalesforceSDKManager.m14417d(str15, str11));
        bundle.putString("last_name", SalesforceSDKManager.m14417d(str16, str11));
        bundle.putString("display_name", SalesforceSDKManager.m14417d(str17, str11));
        bundle.putString("email", SalesforceSDKManager.m14417d(str18, str11));
        bundle.putString("photoUrl", SalesforceSDKManager.m14417d(str19, str11));
        bundle.putString("thumbnailUrl", SalesforceSDKManager.m14417d(str20, str11));
        List<String> listM14457v = SalesforceSDKManager.m14403a().m14457v();
        if (map != null && !map.isEmpty()) {
            for (String str21 : listM14457v) {
                String str22 = map.get(str21);
                if (str22 != null) {
                    bundle.putString(str21, SalesforceSDKManager.m14417d(str22, str11));
                }
            }
        }
        Account account = new Account(str, m14569d());
        this.f14201a.addAccountExplicitly(account, SalesforceSDKManager.m14417d(str3, str11), new Bundle());
        this.f14201a.setAuthToken(account, "authtoken", SalesforceSDKManager.m14417d(str4, str11));
        for (String str23 : bundle.keySet()) {
            this.f14201a.setUserData(account, str23, bundle.getString(str23));
        }
        SalesforceSDKManager.m14403a().m14450o().m14272a(str10, str9);
        return bundle;
    }

    /* JADX INFO: renamed from: d */
    public String m14569d() {
        return this.f14202b;
    }

    /* JADX INFO: renamed from: a */
    public static synchronized void m14556a(String str, String str2) {
        Account[] accountsByType;
        String strM14418e;
        String strM14418e2;
        String strM14418e3;
        String strM14418e4;
        HashMap map;
        String strM14418e5;
        String strM14418e6;
        String strM14418e7;
        AccountManager accountManager = AccountManager.get(SalesforceSDKManager.m14403a().m14446k());
        if (accountManager != null && (accountsByType = accountManager.getAccountsByType(SalesforceSDKManager.m14403a().m14420B())) != null && accountsByType.length > 0) {
            int length = accountsByType.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                Account account = accountsByType[i2];
                String strM14418e8 = SalesforceSDKManager.m14418e(accountManager.getUserData(account, "authtoken"), str);
                String strM14418e9 = SalesforceSDKManager.m14418e(accountManager.getPassword(account), str);
                String strM14418e10 = SalesforceSDKManager.m14418e(accountManager.getUserData(account, "loginUrl"), str);
                String strM14418e11 = SalesforceSDKManager.m14418e(accountManager.getUserData(account, ShareConstants.WEB_DIALOG_PARAM_ID), str);
                String strM14418e12 = SalesforceSDKManager.m14418e(accountManager.getUserData(account, "instanceUrl"), str);
                String strM14418e13 = SalesforceSDKManager.m14418e(accountManager.getUserData(account, "orgId"), str);
                String strM14418e14 = SalesforceSDKManager.m14418e(accountManager.getUserData(account, "userId"), str);
                String strM14418e15 = SalesforceSDKManager.m14418e(accountManager.getUserData(account, "username"), str);
                String strM14418e16 = SalesforceSDKManager.m14418e(accountManager.getUserData(account, "clientId"), str);
                String strM14418e17 = SalesforceSDKManager.m14418e(accountManager.getUserData(account, "last_name"), str);
                String strM14418e18 = SalesforceSDKManager.m14418e(accountManager.getUserData(account, "email"), str);
                String userData = accountManager.getUserData(account, "first_name");
                if (userData == null) {
                    strM14418e = null;
                } else {
                    strM14418e = SalesforceSDKManager.m14418e(userData, str);
                }
                String userData2 = accountManager.getUserData(account, "display_name");
                if (userData2 == null) {
                    strM14418e2 = null;
                } else {
                    strM14418e2 = SalesforceSDKManager.m14418e(userData2, str);
                }
                String userData3 = accountManager.getUserData(account, "photoUrl");
                if (userData3 == null) {
                    strM14418e3 = null;
                } else {
                    strM14418e3 = SalesforceSDKManager.m14418e(userData3, str);
                }
                String userData4 = accountManager.getUserData(account, "thumbnailUrl");
                if (userData4 == null) {
                    strM14418e4 = null;
                } else {
                    strM14418e4 = SalesforceSDKManager.m14418e(userData4, str);
                }
                List<String> listM14457v = SalesforceSDKManager.m14403a().m14457v();
                if (listM14457v == null || listM14457v.isEmpty()) {
                    map = null;
                } else {
                    HashMap map2 = new HashMap();
                    for (String str3 : listM14457v) {
                        String userData5 = accountManager.getUserData(account, str3);
                        if (userData5 != null) {
                            map2.put(str3, SalesforceSDKManager.m14418e(userData5, SalesforceSDKManager.m14403a().m14455t()));
                        }
                    }
                    map = map2;
                }
                String userData6 = accountManager.getUserData(account, "clientSecret");
                if (userData6 == null) {
                    strM14418e5 = null;
                } else {
                    strM14418e5 = SalesforceSDKManager.m14418e(userData6, str);
                }
                String userData7 = accountManager.getUserData(account, "communityId");
                if (userData7 == null) {
                    strM14418e6 = null;
                } else {
                    strM14418e6 = SalesforceSDKManager.m14418e(userData7, str);
                }
                String userData8 = accountManager.getUserData(account, "communityUrl");
                if (userData8 == null) {
                    strM14418e7 = null;
                } else {
                    strM14418e7 = SalesforceSDKManager.m14418e(userData8, str);
                }
                accountManager.setUserData(account, "authtoken", SalesforceSDKManager.m14417d(strM14418e8, str2));
                accountManager.setPassword(account, SalesforceSDKManager.m14417d(strM14418e9, str2));
                accountManager.setUserData(account, "loginUrl", SalesforceSDKManager.m14417d(strM14418e10, str2));
                accountManager.setUserData(account, ShareConstants.WEB_DIALOG_PARAM_ID, SalesforceSDKManager.m14417d(strM14418e11, str2));
                accountManager.setUserData(account, "instanceUrl", SalesforceSDKManager.m14417d(strM14418e12, str2));
                accountManager.setUserData(account, "orgId", SalesforceSDKManager.m14417d(strM14418e13, str2));
                accountManager.setUserData(account, "userId", SalesforceSDKManager.m14417d(strM14418e14, str2));
                accountManager.setUserData(account, "username", SalesforceSDKManager.m14417d(strM14418e15, str2));
                accountManager.setUserData(account, "clientId", SalesforceSDKManager.m14417d(strM14418e16, str2));
                accountManager.setUserData(account, "last_name", SalesforceSDKManager.m14417d(strM14418e17, str2));
                accountManager.setUserData(account, "email", SalesforceSDKManager.m14417d(strM14418e18, str2));
                if (strM14418e != null) {
                    accountManager.setUserData(account, "first_name", SalesforceSDKManager.m14417d(strM14418e, str2));
                }
                if (strM14418e2 != null) {
                    accountManager.setUserData(account, "display_name", SalesforceSDKManager.m14417d(strM14418e2, str2));
                }
                if (strM14418e3 != null) {
                    accountManager.setUserData(account, "photoUrl", SalesforceSDKManager.m14417d(strM14418e3, str2));
                }
                if (strM14418e4 != null) {
                    accountManager.setUserData(account, "thumbnailUrl", SalesforceSDKManager.m14417d(strM14418e4, str2));
                }
                if (map != null && !map.isEmpty()) {
                    for (String str4 : listM14457v) {
                        String str5 = (String) map.get(str4);
                        if (str5 != null) {
                            accountManager.setUserData(account, str4, SalesforceSDKManager.m14417d(str5, str2));
                        }
                    }
                }
                if (strM14418e5 != null) {
                    accountManager.setUserData(account, "clientSecret", SalesforceSDKManager.m14417d(strM14418e5, str2));
                }
                if (strM14418e6 != null) {
                    accountManager.setUserData(account, "communityId", SalesforceSDKManager.m14417d(strM14418e6, str2));
                }
                if (strM14418e7 != null) {
                    accountManager.setUserData(account, "communityUrl", SalesforceSDKManager.m14417d(strM14418e7, str2));
                }
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m14562a(Account account, AccountManagerCallback<Boolean> accountManagerCallback) {
        if (account != null) {
            this.f14201a.removeAccount(account, accountManagerCallback, null);
        }
    }

    private class AccMgrCallback implements AccountManagerCallback<Bundle> {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ boolean f14212a;

        /* JADX INFO: renamed from: c */
        private final RestClientCallback f14214c;

        static {
            f14212a = !ClientManager.class.desiredAssertionStatus();
        }

        AccMgrCallback(RestClientCallback restClientCallback) {
            if (!f14212a && restClientCallback == null) {
                throw new AssertionError("you must supply a RestClientAvailable instance");
            }
            this.f14214c = restClientCallback;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
            RestClient restClientM14567b = null;
            try {
                accountManagerFuture.getResult();
                restClientM14567b = ClientManager.this.m14567b();
            } catch (Exception e) {
                SalesforceSDKLogger.m15018b("ClientManager", "Exception thrown while creating rest client", e);
            }
            this.f14214c.mo14590a(restClientM14567b);
        }
    }

    public static class AccMgrAuthTokenProvider implements RestClient.AuthTokenProvider {

        /* JADX INFO: renamed from: a */
        private boolean f14205a;

        /* JADX INFO: renamed from: c */
        private final ClientManager f14207c;

        /* JADX INFO: renamed from: d */
        private String f14208d;

        /* JADX INFO: renamed from: e */
        private final String f14209e;

        /* JADX INFO: renamed from: f */
        private String f14210f;

        /* JADX INFO: renamed from: b */
        private final Object f14206b = new Object();

        /* JADX INFO: renamed from: g */
        private long f14211g = -1;

        public AccMgrAuthTokenProvider(ClientManager clientManager, String str, String str2, String str3) {
            this.f14207c = clientManager;
            this.f14209e = str3;
            this.f14208d = str2;
            this.f14210f = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:68:0x010b  */
        @Override // com.salesforce.androidsdk.rest.RestClient.AuthTokenProvider
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String mo14572a() throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 337
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.androidsdk.rest.ClientManager.AccMgrAuthTokenProvider.mo14572a():java.lang.String");
        }

        @Override // com.salesforce.androidsdk.rest.RestClient.AuthTokenProvider
        /* JADX INFO: renamed from: b */
        public long mo14573b() {
            return this.f14211g;
        }

        @Override // com.salesforce.androidsdk.rest.RestClient.AuthTokenProvider
        /* JADX INFO: renamed from: c */
        public String mo14574c() {
            return this.f14210f;
        }

        /* JADX INFO: renamed from: a */
        private Bundle m14570a(Account account) throws NetworkErrorException {
            HashMap map;
            String str;
            String strM14455t = SalesforceSDKManager.m14403a().m14455t();
            Bundle bundle = new Bundle();
            Context contextM14446k = SalesforceSDKManager.m14403a().m14446k();
            AccountManager accountManager = AccountManager.get(contextM14446k);
            String strM14418e = SalesforceSDKManager.m14418e(accountManager.getPassword(account), strM14455t);
            String strM14418e2 = SalesforceSDKManager.m14418e(accountManager.getUserData(account, "loginUrl"), strM14455t);
            String strM14418e3 = SalesforceSDKManager.m14418e(accountManager.getUserData(account, "clientId"), strM14455t);
            String strM14418e4 = SalesforceSDKManager.m14418e(accountManager.getUserData(account, "instanceUrl"), strM14455t);
            String userData = accountManager.getUserData(account, "clientSecret");
            String strM14418e5 = userData != null ? SalesforceSDKManager.m14418e(userData, strM14455t) : null;
            List<String> listM14457v = SalesforceSDKManager.m14403a().m14457v();
            if (listM14457v == null || listM14457v.isEmpty()) {
                map = null;
            } else {
                HashMap map2 = new HashMap();
                for (String str2 : listM14457v) {
                    String userData2 = accountManager.getUserData(account, str2);
                    if (userData2 != null) {
                        map2.put(str2, SalesforceSDKManager.m14418e(userData2, strM14455t));
                    }
                }
                map = map2;
            }
            try {
                OAuth2.TokenEndpointResponse tokenEndpointResponseM14479a = OAuth2.m14479a(HttpAccess.f14141a, new URI(strM14418e2), strM14418e3, strM14418e, strM14418e5, SalesforceSDKManager.m14403a().m14443h().m14588h());
                if (!strM14418e4.equalsIgnoreCase(tokenEndpointResponseM14479a.f14162c)) {
                    accountManager.setUserData(account, "instanceUrl", SalesforceSDKManager.m14417d(tokenEndpointResponseM14479a.f14162c, strM14455t));
                }
                accountManager.setUserData(account, "authtoken", SalesforceSDKManager.m14417d(tokenEndpointResponseM14479a.f14160a, strM14455t));
                bundle.putString("authtoken", SalesforceSDKManager.m14417d(tokenEndpointResponseM14479a.f14160a, strM14455t));
                bundle.putString("instanceUrl", SalesforceSDKManager.m14417d(tokenEndpointResponseM14479a.f14162c, strM14455t));
                if (listM14457v != null && !listM14457v.isEmpty()) {
                    for (String str3 : listM14457v) {
                        if (tokenEndpointResponseM14479a.f14170k != null && tokenEndpointResponseM14479a.f14170k.containsKey(str3)) {
                            String str4 = tokenEndpointResponseM14479a.f14170k.get(str3);
                            if (str4 != null) {
                                String strM14417d = SalesforceSDKManager.m14417d(str4, strM14455t);
                                bundle.putString(str3, strM14417d);
                                accountManager.setUserData(account, str3, strM14417d);
                            }
                        } else if (map != null && map.containsKey(str3) && (str = (String) map.get(str3)) != null) {
                            bundle.putString(str3, SalesforceSDKManager.m14417d(str, strM14455t));
                        }
                    }
                }
            } catch (OAuth2.OAuthFailedException e) {
                if (e.m14490a()) {
                    SalesforceSDKLogger.m15020c("ClientManager", "Invalid Refresh Token: (Error: " + e.m14491b().f14171a + ", Status Code: " + e.m14492c() + ")", e);
                    return m14571a(contextM14446k);
                }
                bundle.putString("errorCode", e.m14491b().f14171a);
                bundle.putString("errorMessage", e.m14491b().f14172b);
            } catch (Exception e2) {
                SalesforceSDKLogger.m15018b("ClientManager", "Exception thrown while getting new auth token", e2);
                throw new NetworkErrorException(e2);
            }
            return bundle;
        }

        /* JADX INFO: renamed from: a */
        private Bundle m14571a(Context context) {
            Bundle bundle = new Bundle();
            Intent intent = new Intent(context, SalesforceSDKManager.m14403a().m14440f());
            intent.setPackage(context.getPackageName());
            intent.setFlags(536870912);
            bundle.putParcelable("intent", intent);
            return bundle;
        }
    }

    public static class AccountInfoNotFoundException extends RuntimeException {
        AccountInfoNotFoundException(String str) {
            super(str);
        }

        public AccountInfoNotFoundException(String str, Throwable th) {
            super(str, th);
        }
    }

    public static class LoginOptions {

        /* JADX INFO: renamed from: a */
        private String f14215a;

        /* JADX INFO: renamed from: b */
        private String f14216b;

        /* JADX INFO: renamed from: c */
        private final String f14217c;

        /* JADX INFO: renamed from: d */
        private final String f14218d;

        /* JADX INFO: renamed from: e */
        private final String[] f14219e;

        /* JADX INFO: renamed from: f */
        private String f14220f;

        /* JADX INFO: renamed from: g */
        private String f14221g;

        /* JADX INFO: renamed from: h */
        private Map<String, String> f14222h;

        public LoginOptions(String str, String str2, String str3, String str4, String[] strArr) {
            this.f14215a = str;
            this.f14216b = str2;
            this.f14217c = str3;
            this.f14218d = str4;
            this.f14219e = strArr;
        }

        public LoginOptions(String str, String str2, String str3, String str4, String[] strArr, String str5) {
            this(str, str2, str3, str4, strArr);
            this.f14220f = str5;
        }

        public LoginOptions(String str, String str2, String str3, String str4, String[] strArr, String str5, String str6) {
            this(str, str2, str3, str4, strArr, str5);
            m14578a(str6);
        }

        public LoginOptions(String str, String str2, String str3, String str4, String[] strArr, String str5, String str6, Map<String, String> map) {
            this(str, str2, str3, str4, strArr, str5, str6);
            this.f14222h = map;
        }

        /* JADX INFO: renamed from: a */
        public void m14578a(String str) {
            this.f14221g = str;
        }

        /* JADX INFO: renamed from: b */
        public void m14580b(String str) {
            this.f14215a = str;
        }

        /* JADX INFO: renamed from: a */
        public String m14577a() {
            return this.f14215a;
        }

        /* JADX INFO: renamed from: c */
        public void m14582c(String str) {
            this.f14215a = str;
        }

        /* JADX INFO: renamed from: b */
        public String m14579b() {
            return this.f14216b;
        }

        /* JADX INFO: renamed from: d */
        public void m14584d(String str) {
            this.f14216b = str;
        }

        /* JADX INFO: renamed from: c */
        public String m14581c() {
            return this.f14217c;
        }

        /* JADX INFO: renamed from: d */
        public String m14583d() {
            return this.f14218d;
        }

        /* JADX INFO: renamed from: e */
        public String[] m14585e() {
            return this.f14219e;
        }

        /* JADX INFO: renamed from: f */
        public String m14586f() {
            return this.f14220f;
        }

        /* JADX INFO: renamed from: g */
        public String m14587g() {
            return this.f14221g;
        }

        /* JADX INFO: renamed from: h */
        public Map<String, String> m14588h() {
            return this.f14222h;
        }

        /* JADX INFO: renamed from: i */
        public Bundle m14589i() {
            Bundle bundle = new Bundle();
            bundle.putString("loginUrl", this.f14215a);
            bundle.putString("passcodeHash", this.f14216b);
            bundle.putString("oauthCallbackUrl", this.f14217c);
            bundle.putString("oauthClientId", this.f14218d);
            bundle.putStringArray("oauthScopes", this.f14219e);
            bundle.putString("clientSecret", this.f14220f);
            bundle.putString("jwt", this.f14221g);
            if (this.f14222h != null && this.f14222h.size() > 0) {
                HashMap map = new HashMap();
                map.putAll(this.f14222h);
                bundle.putSerializable("addlParams", map);
            }
            return bundle;
        }

        /* JADX INFO: renamed from: a */
        public static LoginOptions m14575a(Bundle bundle) {
            HashMap map = null;
            Serializable serializable = bundle.getSerializable("addlParams");
            if (serializable != null) {
                map = (HashMap) serializable;
            }
            return new LoginOptions(bundle.getString("loginUrl"), bundle.getString("passcodeHash"), bundle.getString("oauthCallbackUrl"), bundle.getString("oauthClientId"), bundle.getStringArray("oauthScopes"), bundle.getString("clientSecret"), bundle.getString("jwt"), map);
        }
    }
}
