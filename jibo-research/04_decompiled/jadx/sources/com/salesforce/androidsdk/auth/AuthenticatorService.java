package com.salesforce.androidsdk.auth;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.accounts.NetworkErrorException;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.auth.OAuth2;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AuthenticatorService extends Service {

    /* JADX INFO: renamed from: a */
    private static Authenticator f14139a;

    /* JADX INFO: renamed from: a */
    private Authenticator m14472a() {
        if (f14139a == null) {
            f14139a = new Authenticator(this);
        }
        return f14139a;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if ("android.accounts.AccountAuthenticator".equals(intent.getAction())) {
            return m14472a().getIBinder();
        }
        return null;
    }

    private static class Authenticator extends AbstractAccountAuthenticator {

        /* JADX INFO: renamed from: a */
        private final Context f14140a;

        Authenticator(Context context) {
            super(context);
            this.f14140a = context;
        }

        @Override // android.accounts.AbstractAccountAuthenticator
        public Bundle addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) throws NetworkErrorException {
            if (m14474a(bundle)) {
                bundle.putAll(SalesforceSDKManager.m14403a().m14443h().m14589i());
            }
            return m14473a(accountAuthenticatorResponse, bundle);
        }

        /* JADX INFO: renamed from: a */
        private boolean m14474a(Bundle bundle) {
            return bundle.containsKey("androidPackageName") && "com.android.settings".equals(bundle.getString("androidPackageName"));
        }

        @Override // android.accounts.AbstractAccountAuthenticator
        public Bundle getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) throws NetworkErrorException {
            String strM14418e;
            String strM14418e2;
            String strM14418e3;
            String strM14418e4;
            HashMap map;
            String strM14418e5;
            String strM14418e6;
            String strM14417d;
            String str2;
            AccountManager accountManager = AccountManager.get(this.f14140a);
            String strM14455t = SalesforceSDKManager.m14403a().m14455t();
            String strM14418e7 = SalesforceSDKManager.m14418e(accountManager.getPassword(account), strM14455t);
            String strM14418e8 = SalesforceSDKManager.m14418e(accountManager.getUserData(account, "loginUrl"), strM14455t);
            String strM14418e9 = SalesforceSDKManager.m14418e(accountManager.getUserData(account, "clientId"), strM14455t);
            String strM14418e10 = SalesforceSDKManager.m14418e(accountManager.getUserData(account, "instanceUrl"), strM14455t);
            String strM14418e11 = SalesforceSDKManager.m14418e(accountManager.getUserData(account, "userId"), strM14455t);
            String strM14418e12 = SalesforceSDKManager.m14418e(accountManager.getUserData(account, "orgId"), strM14455t);
            String strM14418e13 = SalesforceSDKManager.m14418e(accountManager.getUserData(account, "username"), strM14455t);
            String strM14418e14 = SalesforceSDKManager.m14418e(accountManager.getUserData(account, "last_name"), strM14455t);
            String strM14418e15 = SalesforceSDKManager.m14418e(accountManager.getUserData(account, "email"), strM14455t);
            String userData = accountManager.getUserData(account, "first_name");
            if (userData == null) {
                strM14418e = null;
            } else {
                strM14418e = SalesforceSDKManager.m14418e(userData, strM14455t);
            }
            String userData2 = accountManager.getUserData(account, "display_name");
            if (userData2 == null) {
                strM14418e2 = null;
            } else {
                strM14418e2 = SalesforceSDKManager.m14418e(userData2, strM14455t);
            }
            String userData3 = accountManager.getUserData(account, "photoUrl");
            if (userData3 == null) {
                strM14418e3 = null;
            } else {
                strM14418e3 = SalesforceSDKManager.m14418e(userData3, strM14455t);
            }
            String userData4 = accountManager.getUserData(account, "thumbnailUrl");
            if (userData4 == null) {
                strM14418e4 = null;
            } else {
                strM14418e4 = SalesforceSDKManager.m14418e(userData4, strM14455t);
            }
            String userData5 = accountManager.getUserData(account, "clientSecret");
            String strM14418e16 = null;
            if (userData5 != null) {
                strM14418e16 = SalesforceSDKManager.m14418e(userData5, strM14455t);
            }
            List<String> listM14457v = SalesforceSDKManager.m14403a().m14457v();
            if (listM14457v == null || listM14457v.isEmpty()) {
                map = null;
            } else {
                HashMap map2 = new HashMap();
                for (String str3 : listM14457v) {
                    String userData6 = accountManager.getUserData(account, str3);
                    if (userData6 != null) {
                        map2.put(str3, SalesforceSDKManager.m14418e(userData6, SalesforceSDKManager.m14403a().m14455t()));
                    }
                }
                map = map2;
            }
            Map<String, String> mapM14588h = SalesforceSDKManager.m14403a().m14443h().m14588h();
            String userData7 = accountManager.getUserData(account, "communityId");
            if (userData7 == null) {
                strM14418e5 = null;
            } else {
                strM14418e5 = SalesforceSDKManager.m14418e(userData7, SalesforceSDKManager.m14403a().m14455t());
            }
            String userData8 = accountManager.getUserData(account, "communityUrl");
            if (userData8 == null) {
                strM14418e6 = null;
            } else {
                strM14418e6 = SalesforceSDKManager.m14418e(userData8, SalesforceSDKManager.m14403a().m14455t());
            }
            Bundle bundle2 = new Bundle();
            try {
                OAuth2.TokenEndpointResponse tokenEndpointResponseM14479a = OAuth2.m14479a(HttpAccess.f14141a, new URI(strM14418e8), strM14418e9, strM14418e7, strM14418e16, mapM14588h);
                if (!strM14418e10.equalsIgnoreCase(tokenEndpointResponseM14479a.f14162c)) {
                    accountManager.setUserData(account, "instanceUrl", SalesforceSDKManager.m14417d(tokenEndpointResponseM14479a.f14162c, strM14455t));
                }
                accountManager.setUserData(account, "authtoken", SalesforceSDKManager.m14417d(tokenEndpointResponseM14479a.f14160a, strM14455t));
                bundle2.putString("authAccount", account.name);
                bundle2.putString("accountType", account.type);
                bundle2.putString("authtoken", SalesforceSDKManager.m14417d(tokenEndpointResponseM14479a.f14160a, strM14455t));
                bundle2.putString("loginUrl", SalesforceSDKManager.m14417d(strM14418e8, strM14455t));
                bundle2.putString("instanceUrl", SalesforceSDKManager.m14417d(tokenEndpointResponseM14479a.f14162c, strM14455t));
                bundle2.putString("clientId", SalesforceSDKManager.m14417d(strM14418e9, strM14455t));
                bundle2.putString("username", SalesforceSDKManager.m14417d(strM14418e13, strM14455t));
                bundle2.putString("userId", SalesforceSDKManager.m14417d(strM14418e11, strM14455t));
                bundle2.putString("orgId", SalesforceSDKManager.m14417d(strM14418e12, strM14455t));
                bundle2.putString("last_name", SalesforceSDKManager.m14417d(strM14418e14, strM14455t));
                bundle2.putString("email", SalesforceSDKManager.m14417d(strM14418e15, strM14455t));
                String strM14417d2 = null;
                if (strM14418e != null) {
                    strM14417d2 = SalesforceSDKManager.m14417d(strM14418e, strM14455t);
                }
                bundle2.putString("first_name", strM14417d2);
                String strM14417d3 = null;
                if (strM14418e2 != null) {
                    strM14417d3 = SalesforceSDKManager.m14417d(strM14418e2, strM14455t);
                }
                bundle2.putString("display_name", strM14417d3);
                String strM14417d4 = null;
                if (strM14418e3 != null) {
                    strM14417d4 = SalesforceSDKManager.m14417d(strM14418e3, strM14455t);
                }
                bundle2.putString("photoUrl", strM14417d4);
                if (strM14418e4 == null) {
                    strM14417d = null;
                } else {
                    strM14417d = SalesforceSDKManager.m14417d(strM14418e4, strM14455t);
                }
                if (listM14457v != null && !listM14457v.isEmpty()) {
                    for (String str4 : listM14457v) {
                        if (tokenEndpointResponseM14479a.f14170k != null && tokenEndpointResponseM14479a.f14170k.containsKey(str4)) {
                            String str5 = tokenEndpointResponseM14479a.f14170k.get(str4);
                            if (str5 != null) {
                                String strM14417d5 = SalesforceSDKManager.m14417d(str5, strM14455t);
                                bundle2.putString(str4, strM14417d5);
                                accountManager.setUserData(account, str4, strM14417d5);
                            }
                        } else if (map != null && map.containsKey(str4) && (str2 = (String) map.get(str4)) != null) {
                            bundle2.putString(str4, SalesforceSDKManager.m14417d(str2, strM14455t));
                        }
                    }
                }
                bundle2.putString("thumbnailUrl", strM14417d);
                String strM14417d6 = null;
                if (strM14418e16 != null) {
                    strM14417d6 = SalesforceSDKManager.m14417d(strM14418e16, strM14455t);
                }
                bundle2.putString("clientSecret", strM14417d6);
                String strM14417d7 = null;
                if (strM14418e5 != null) {
                    strM14417d7 = SalesforceSDKManager.m14417d(strM14418e5, strM14455t);
                }
                bundle2.putString("communityId", strM14417d7);
                String strM14417d8 = null;
                if (strM14418e6 != null) {
                    strM14417d8 = SalesforceSDKManager.m14417d(strM14418e6, strM14455t);
                }
                bundle2.putString("communityUrl", strM14417d8);
            } catch (OAuth2.OAuthFailedException e) {
                if (e.m14490a()) {
                    SalesforceSDKLogger.m15020c("AuthenticatorService", "Invalid Refresh Token: (Error: " + e.f14158a.f14171a + ", Status Code: " + e.f14159b + ")", e);
                    return m14473a(accountAuthenticatorResponse, bundle);
                }
                bundle2.putString("errorCode", e.f14158a.f14171a);
                bundle2.putString("errorMessage", e.f14158a.f14172b);
            } catch (Exception e2) {
                SalesforceSDKLogger.m15018b("AuthenticatorService", "Exception thrown while getting new auth token", e2);
                throw new NetworkErrorException(e2);
            }
            return bundle2;
        }

        /* JADX INFO: renamed from: a */
        private Bundle m14473a(AccountAuthenticatorResponse accountAuthenticatorResponse, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            Intent intent = new Intent(this.f14140a, SalesforceSDKManager.m14403a().m14440f());
            intent.setPackage(this.f14140a.getPackageName());
            intent.setFlags(536870912);
            intent.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            bundle2.putParcelable("intent", intent);
            return bundle2;
        }

        @Override // android.accounts.AbstractAccountAuthenticator
        public Bundle updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) throws NetworkErrorException {
            return null;
        }

        @Override // android.accounts.AbstractAccountAuthenticator
        public Bundle confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) throws NetworkErrorException {
            return null;
        }

        @Override // android.accounts.AbstractAccountAuthenticator
        public Bundle editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
            return null;
        }

        @Override // android.accounts.AbstractAccountAuthenticator
        public String getAuthTokenLabel(String str) {
            return null;
        }

        @Override // android.accounts.AbstractAccountAuthenticator
        public Bundle hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String[] strArr) throws NetworkErrorException {
            return null;
        }
    }
}
