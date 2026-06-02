package com.salesforce.androidsdk.push;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.iid.InstanceID;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class PushMessaging {

    /* JADX INFO: renamed from: a */
    private static final ExecutorService f14197a = Executors.newFixedThreadPool(2);

    /* JADX INFO: renamed from: a */
    public static void m14534a(Context context, UserAccount userAccount) {
        if (userAccount != null && !m14544f(context, userAccount)) {
            m14538a(context, true, userAccount);
            if (m14539a(context)) {
                context.startService(new Intent(context, (Class<?>) SFDCRegistrationIntentService.class));
                return;
            }
            return;
        }
        m14541c(context, userAccount);
    }

    /* JADX INFO: renamed from: b */
    public static void m14540b(Context context, UserAccount userAccount) {
        if (m14544f(context, userAccount)) {
            m14538a(context, true, userAccount);
            final InstanceID instanceIDM7604c = InstanceID.m7604c(context);
            f14197a.execute(new Runnable() { // from class: com.salesforce.androidsdk.push.PushMessaging.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        instanceIDM7604c.m7607a();
                    } catch (IOException e) {
                        SalesforceSDKLogger.m15016a("PushMessaging", "Error deleting InstanceID", e);
                    }
                }
            });
            m14542d(context, userAccount);
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m14541c(Context context, UserAccount userAccount) {
        m14535a(context, userAccount, new Intent("com.salesforce.mobilesdk.c2dm.intent.RETRY"));
    }

    /* JADX INFO: renamed from: d */
    public static void m14542d(Context context, UserAccount userAccount) {
        m14535a(context, userAccount, new Intent("com.salesforce.mobilesdk.c2dm.intent.UNREGISTER"));
    }

    /* JADX INFO: renamed from: a */
    private static void m14535a(Context context, UserAccount userAccount, Intent intent) {
        if (userAccount == null) {
            Bundle bundle = new Bundle();
            bundle.putString("account_bundle", "all_accounts");
            intent.putExtra("account_bundle", bundle);
            PushService.m14548a(intent);
            return;
        }
        if (m14544f(context, userAccount)) {
            intent.putExtra("account_bundle", userAccount.m14263w());
            PushService.m14548a(intent);
        }
    }

    /* JADX INFO: renamed from: e */
    public static String m14543e(Context context, UserAccount userAccount) {
        return context.getSharedPreferences(m14533a(userAccount), 0).getString("c2dm_registration_id", null);
    }

    /* JADX INFO: renamed from: a */
    public static void m14536a(Context context, String str, UserAccount userAccount) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(m14533a(userAccount), 0).edit();
        editorEdit.putString("c2dm_registration_id", str);
        editorEdit.putLong("backoff", 30000L);
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: f */
    public static boolean m14544f(Context context, UserAccount userAccount) {
        return context.getSharedPreferences(m14533a(userAccount), 0).getString("c2dm_registration_id", null) != null;
    }

    /* JADX INFO: renamed from: g */
    public static String m14545g(Context context, UserAccount userAccount) {
        return context.getSharedPreferences(m14533a(userAccount), 0).getString("deviceId", null);
    }

    /* JADX INFO: renamed from: a */
    public static void m14538a(Context context, boolean z, UserAccount userAccount) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(m14533a(userAccount), 0).edit();
        editorEdit.putBoolean("inprogress", z);
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: h */
    public static void m14546h(Context context, UserAccount userAccount) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(m14533a(userAccount), 0).edit();
        editorEdit.clear();
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: a */
    static void m14537a(Context context, String str, String str2, UserAccount userAccount) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(m14533a(userAccount), 0).edit();
        editorEdit.putString("c2dm_registration_id", str);
        editorEdit.putString("deviceId", str2);
        editorEdit.putLong("backoff", 30000L);
        editorEdit.putLong("last_registration_change", System.currentTimeMillis());
        editorEdit.putBoolean("inprogress", false);
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: a */
    private static String m14533a(UserAccount userAccount) {
        return userAccount != null ? "gcm_prefs" + userAccount.m14261u() : "gcm_prefs";
    }

    /* JADX INFO: renamed from: a */
    private static boolean m14539a(Context context) {
        return GoogleApiAvailability.m6828a().mo6834a(context) == 0;
    }
}
