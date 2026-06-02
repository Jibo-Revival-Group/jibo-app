package com.salesforce.androidsdk.push;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.accounts.UserAccountManager;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.auth.HttpAccess;
import com.salesforce.androidsdk.rest.ApiVersionStrings;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.rest.RestRequest;
import com.salesforce.androidsdk.rest.RestResponse;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.io.IOException;
import java.net.URI;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PushService extends IntentService {

    /* JADX INFO: renamed from: a */
    private static PowerManager.WakeLock f14199a;

    /* JADX INFO: renamed from: b */
    private Context f14200b;

    /* JADX INFO: renamed from: a */
    static void m14548a(Intent intent) {
        Context contextM14446k = SalesforceSDKManager.m14403a().m14446k();
        if (f14199a == null) {
            f14199a = ((PowerManager) contextM14446k.getSystemService("power")).newWakeLock(1, "PushService");
        }
        f14199a.acquire();
        intent.setClassName(contextM14446k, PushService.class.getName());
        if (contextM14446k.startService(intent) == null) {
            SalesforceSDKLogger.m15017b("PushService", "Could not start GCM service");
        }
    }

    public PushService() {
        super("PushService");
        this.f14200b = SalesforceSDKManager.m14403a().m14446k();
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("account_bundle");
        UserAccount userAccountM14275b = null;
        boolean z = false;
        if (bundleExtra != null) {
            if ("all_accounts".equals(bundleExtra.getString("account_bundle"))) {
                z = true;
            } else {
                userAccountM14275b = new UserAccount(bundleExtra);
            }
        }
        UserAccountManager userAccountManagerM14450o = SalesforceSDKManager.m14403a().m14450o();
        List<UserAccount> listM14277d = userAccountManagerM14450o.m14277d();
        try {
            boolean zEquals = "com.salesforce.mobilesdk.c2dm.intent.RETRY".equals(intent.getAction());
            boolean zEquals2 = "com.salesforce.mobilesdk.c2dm.intent.UNREGISTER".equals(intent.getAction());
            if (zEquals || zEquals2) {
                if (z) {
                    if (listM14277d != null) {
                        Iterator<UserAccount> it = listM14277d.iterator();
                        while (it.hasNext()) {
                            m14551a(zEquals, it.next());
                        }
                    }
                } else {
                    if (userAccountM14275b == null) {
                        userAccountM14275b = userAccountManagerM14450o.m14275b();
                    }
                    m14551a(zEquals, userAccountM14275b);
                }
            }
        } finally {
            if (f14199a != null && f14199a.isHeld()) {
                f14199a.release();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m14551a(boolean z, UserAccount userAccount) throws Throwable {
        if (z) {
            String strM14543e = PushMessaging.m14543e(this.f14200b, userAccount);
            if (strM14543e != null) {
                m14550a(strM14543e, userAccount);
                return;
            }
            return;
        }
        m14549a(userAccount);
    }

    /* JADX INFO: renamed from: a */
    private void m14547a(long j, UserAccount userAccount) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, (int) j);
        Intent intent = new Intent(this.f14200b, (Class<?>) SFDCRegistrationRetryAlarmReceiver.class);
        if (userAccount == null) {
            Bundle bundle = new Bundle();
            bundle.putString("account_bundle", "all_accounts");
            intent.putExtra("account_bundle", bundle);
        } else {
            intent.putExtra("account_bundle", userAccount.m14263w());
        }
        ((AlarmManager) this.f14200b.getSystemService("alarm")).set(0, calendar.getTimeInMillis(), PendingIntent.getBroadcast(this.f14200b, 1, intent, 1073741824));
    }

    /* JADX INFO: renamed from: a */
    private void m14550a(String str, UserAccount userAccount) throws Throwable {
        long j;
        Throwable th;
        if (userAccount == null) {
            SalesforceSDKLogger.m15015a("PushService", "Account is null, will retry registration later");
            return;
        }
        long j2 = 30000;
        try {
            String strM14553b = m14553b(str, userAccount);
            if (strM14553b != null) {
                j2 = 518400000;
                PushMessaging.m14537a(this.f14200b, str, strM14553b, userAccount);
            } else {
                PushMessaging.m14536a(this.f14200b, str, userAccount);
            }
            m14547a(j2, (UserAccount) null);
        } catch (Exception e) {
            j = 30000;
            try {
                SalesforceSDKLogger.m15016a("PushService", "Error occurred during SFDC registration", e);
                m14547a(30000L, (UserAccount) null);
            } catch (Throwable th2) {
                th = th2;
                m14547a(j, (UserAccount) null);
                throw th;
            }
        } catch (Throwable th3) {
            j = 30000;
            th = th3;
            m14547a(j, (UserAccount) null);
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m14549a(UserAccount userAccount) {
        try {
            m14554c(PushMessaging.m14545g(this.f14200b, userAccount), userAccount);
        } catch (Exception e) {
            SalesforceSDKLogger.m15016a("PushService", "Error occurred during SFDC unregistration", e);
        } finally {
            PushMessaging.m14546h(this.f14200b, userAccount);
            this.f14200b.sendBroadcast(new Intent("com.salesfore.mobilesdk.c2dm.UNREGISTERED").setPackage(this.f14200b.getPackageName()));
            this.f14200b.sendBroadcast(new Intent("com.salesfore.mobilesdk.c2dm.ACTUAL_UNREGISTERED").setPackage(this.f14200b.getPackageName()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005e  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String m14553b(java.lang.String r6, com.salesforce.androidsdk.accounts.UserAccount r7) {
        /*
            r5 = this;
            r1 = 0
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r2 = "ConnectionToken"
            r0.put(r2, r6)
            java.lang.String r2 = "ServiceType"
            java.lang.String r3 = "androidGcm"
            r0.put(r2, r3)
            com.salesforce.androidsdk.rest.RestClient r2 = r5.m14552b(r7)     // Catch: java.lang.Exception -> L55
            android.content.Context r3 = r5.f14200b     // Catch: java.lang.Exception -> L55
            java.lang.String r3 = com.salesforce.androidsdk.rest.ApiVersionStrings.m14555a(r3)     // Catch: java.lang.Exception -> L55
            java.lang.String r4 = "MobilePushServiceDevice"
            com.salesforce.androidsdk.rest.RestRequest r0 = com.salesforce.androidsdk.rest.RestRequest.m14614a(r3, r4, r0)     // Catch: java.lang.Exception -> L55
            if (r2 == 0) goto L49
            com.salesforce.androidsdk.rest.RestResponse r2 = r2.m14600b(r0)     // Catch: java.lang.Exception -> L55
            int r0 = r2.m14621a()     // Catch: java.lang.Exception -> L55
            r3 = 201(0xc9, float:2.82E-43)
            if (r0 != r3) goto L4a
            org.json.JSONObject r0 = r2.m14626f()     // Catch: java.lang.Exception -> L55
            if (r0 == 0) goto L5e
            java.lang.String r3 = "id"
            java.lang.String r0 = r0.getString(r3)     // Catch: java.lang.Exception -> L55
        L3c:
            r2.m14623c()     // Catch: java.lang.Exception -> L55
            com.salesforce.androidsdk.app.SalesforceSDKManager r2 = com.salesforce.androidsdk.app.SalesforceSDKManager.m14403a()     // Catch: java.lang.Exception -> L55
            java.lang.String r3 = "PN"
            r2.m14439e(r3)     // Catch: java.lang.Exception -> L55
            r1 = r0
        L49:
            return r1
        L4a:
            int r0 = r2.m14621a()     // Catch: java.lang.Exception -> L55
            r3 = 404(0x194, float:5.66E-43)
            if (r0 != r3) goto L5e
            java.lang.String r0 = "not_enabled"
            goto L3c
        L55:
            r0 = move-exception
            java.lang.String r2 = "PushService"
            java.lang.String r3 = "Push notification registration failed"
            com.salesforce.androidsdk.util.SalesforceSDKLogger.m15016a(r2, r3, r0)
            goto L49
        L5e:
            r0 = r1
            goto L3c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.androidsdk.push.PushService.m14553b(java.lang.String, com.salesforce.androidsdk.accounts.UserAccount):java.lang.String");
    }

    /* JADX INFO: renamed from: c */
    private boolean m14554c(String str, UserAccount userAccount) {
        RestRequest restRequestM14613a = RestRequest.m14613a(ApiVersionStrings.m14555a(this.f14200b), "MobilePushServiceDevice", str);
        try {
            RestClient restClientM14552b = m14552b(userAccount);
            if (restClientM14552b != null) {
                RestResponse restResponseM14600b = restClientM14552b.m14600b(restRequestM14613a);
                if (restResponseM14600b.m14621a() == 204) {
                    return true;
                }
                restResponseM14600b.m14623c();
            }
        } catch (IOException e) {
            SalesforceSDKLogger.m15016a("PushService", "Push notification unregistration failed", e);
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    private RestClient m14552b(UserAccount userAccount) {
        ClientManager clientManagerM14423E = SalesforceSDKManager.m14403a().m14423E();
        if (clientManagerM14423E != null) {
            try {
                return new RestClient(new RestClient.ClientInfo(userAccount.m14250j(), new URI(userAccount.m14245e()), new URI(userAccount.m14243c()), new URI(userAccount.m14244d()), userAccount.m14249i(), userAccount.m14248h(), userAccount.m14247g(), userAccount.m14246f(), userAccount.m14251k(), userAccount.m14252l(), userAccount.m14253m(), userAccount.m14255o(), userAccount.m14254n(), userAccount.m14256p(), userAccount.m14257q(), userAccount.m14258r(), userAccount.m14259s()), userAccount.m14240a(), HttpAccess.f14141a, new ClientManager.AccMgrAuthTokenProvider(clientManagerM14423E, userAccount.m14245e(), userAccount.m14240a(), userAccount.m14242b()));
            } catch (Exception e) {
                SalesforceSDKLogger.m15016a("PushService", "Failed to get rest client", e);
            }
        }
        return null;
    }

    public static class SFDCRegistrationRetryAlarmReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle bundleExtra;
            if (intent != null && (bundleExtra = intent.getBundleExtra("account_bundle")) != null) {
                if ("all_accounts".equals(bundleExtra.getString("account_bundle"))) {
                    PushMessaging.m14541c(context, null);
                } else {
                    PushMessaging.m14541c(context, new UserAccount(bundleExtra));
                }
            }
        }
    }
}
