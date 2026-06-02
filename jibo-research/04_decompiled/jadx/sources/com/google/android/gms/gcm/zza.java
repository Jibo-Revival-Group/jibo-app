package com.google.android.gms.gcm;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.atomic.AtomicInteger;
import net.sqlcipher.database.SQLiteDatabase;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
final class zza {

    /* JADX INFO: renamed from: a */
    static zza f6776a;

    /* JADX INFO: renamed from: b */
    private final Context f6777b;

    /* JADX INFO: renamed from: c */
    private String f6778c;

    /* JADX INFO: renamed from: d */
    private final AtomicInteger f6779d = new AtomicInteger((int) SystemClock.elapsedRealtime());

    private zza(Context context) {
        this.f6777b = context.getApplicationContext();
    }

    /* JADX INFO: renamed from: a */
    private final Bundle m7591a() {
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = this.f6777b.getPackageManager().getApplicationInfo(this.f6777b.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
        }
        return (applicationInfo == null || applicationInfo.metaData == null) ? Bundle.EMPTY : applicationInfo.metaData;
    }

    /* JADX INFO: renamed from: a */
    static synchronized zza m7592a(Context context) {
        if (f6776a == null) {
            f6776a = new zza(context);
        }
        return f6776a;
    }

    /* JADX INFO: renamed from: a */
    static String m7593a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    /* JADX INFO: renamed from: a */
    static void m7594a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Iterator<String> it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            String string = bundle.getString(next);
            if (next.startsWith("gcm.notification.")) {
                next = next.replace("gcm.notification.", "gcm.n.");
            }
            if (next.startsWith("gcm.n.")) {
                if (!"gcm.n.e".equals(next)) {
                    bundle2.putString(next.substring(6), string);
                }
                it.remove();
            }
        }
        String string2 = bundle2.getString("sound2");
        if (string2 != null) {
            bundle2.remove("sound2");
            bundle2.putString("sound", string2);
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("notification", bundle2);
    }

    /* JADX INFO: renamed from: b */
    private final String m7595b(Bundle bundle, String str) {
        String strM7593a = m7593a(bundle, str);
        if (!TextUtils.isEmpty(strM7593a)) {
            return strM7593a;
        }
        String strValueOf = String.valueOf(str);
        String strValueOf2 = String.valueOf("_loc_key");
        String strM7593a2 = m7593a(bundle, strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf));
        if (TextUtils.isEmpty(strM7593a2)) {
            return null;
        }
        Resources resources = this.f6777b.getResources();
        int identifier = resources.getIdentifier(strM7593a2, "string", this.f6777b.getPackageName());
        if (identifier == 0) {
            String strValueOf3 = String.valueOf(str);
            String strValueOf4 = String.valueOf("_loc_key");
            String strSubstring = (strValueOf4.length() != 0 ? strValueOf3.concat(strValueOf4) : new String(strValueOf3)).substring(6);
            Log.w("GcmNotification", new StringBuilder(String.valueOf(strSubstring).length() + 49 + String.valueOf(strM7593a2).length()).append(strSubstring).append(" resource not found: ").append(strM7593a2).append(" Default value will be used.").toString());
            return null;
        }
        String strValueOf5 = String.valueOf(str);
        String strValueOf6 = String.valueOf("_loc_args");
        String strM7593a3 = m7593a(bundle, strValueOf6.length() != 0 ? strValueOf5.concat(strValueOf6) : new String(strValueOf5));
        if (TextUtils.isEmpty(strM7593a3)) {
            return resources.getString(identifier);
        }
        try {
            JSONArray jSONArray = new JSONArray(strM7593a3);
            Object[] objArr = new String[jSONArray.length()];
            for (int i = 0; i < objArr.length; i++) {
                objArr[i] = jSONArray.opt(i);
            }
            return resources.getString(identifier, objArr);
        } catch (MissingFormatArgumentException e) {
            Log.w("GcmNotification", new StringBuilder(String.valueOf(strM7593a2).length() + 58 + String.valueOf(strM7593a3).length()).append("Missing format argument for ").append(strM7593a2).append(": ").append(strM7593a3).append(" Default value will be used.").toString(), e);
            return null;
        } catch (JSONException e2) {
            String strValueOf7 = String.valueOf(str);
            String strValueOf8 = String.valueOf("_loc_args");
            String strSubstring2 = (strValueOf8.length() != 0 ? strValueOf7.concat(strValueOf8) : new String(strValueOf7)).substring(6);
            Log.w("GcmNotification", new StringBuilder(String.valueOf(strSubstring2).length() + 41 + String.valueOf(strM7593a3).length()).append("Malformed ").append(strSubstring2).append(": ").append(strM7593a3).append("  Default value will be used.").toString());
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    static boolean m7596b(Context context) {
        if (((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        int iMyPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    return runningAppProcessInfo.importance == 100;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: c */
    private final PendingIntent m7597c(Bundle bundle) {
        Intent intent;
        String strM7593a = m7593a(bundle, "gcm.n.click_action");
        if (TextUtils.isEmpty(strM7593a)) {
            Intent launchIntentForPackage = this.f6777b.getPackageManager().getLaunchIntentForPackage(this.f6777b.getPackageName());
            if (launchIntentForPackage == null) {
                Log.w("GcmNotification", "No activity found to launch app");
                return null;
            }
            intent = launchIntentForPackage;
        } else {
            Intent intent2 = new Intent(strM7593a);
            intent2.setPackage(this.f6777b.getPackageName());
            intent2.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent = intent2;
        }
        Bundle bundle2 = new Bundle(bundle);
        GcmListenerService.m7580a(bundle2);
        intent.putExtras(bundle2);
        for (String str : bundle2.keySet()) {
            if (str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                intent.removeExtra(str);
            }
        }
        return PendingIntent.getActivity(this.f6777b, this.f6779d.getAndIncrement(), intent, 1073741824);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0209  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final boolean m7598b(android.os.Bundle r14) {
        /*
            Method dump skipped, instruction units count: 668
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.gcm.zza.m7598b(android.os.Bundle):boolean");
    }
}
