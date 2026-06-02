package com.google.android.gms.gcm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.zzq;
import com.yalantis.ucrop.util.FileUtils;

/* JADX INFO: loaded from: classes.dex */
public class GcmReceiver extends WakefulBroadcastReceiver {

    /* JADX INFO: renamed from: a */
    private static boolean f6758a = false;

    /* JADX INFO: renamed from: b */
    private static com.google.android.gms.iid.zzh f6759b;

    /* JADX INFO: renamed from: c */
    private static com.google.android.gms.iid.zzh f6760c;

    /* JADX INFO: renamed from: a */
    private final synchronized com.google.android.gms.iid.zzh m7585a(Context context, String str) {
        com.google.android.gms.iid.zzh zzhVar;
        if ("com.google.android.c2dm.intent.RECEIVE".equals(str)) {
            if (f6760c == null) {
                f6760c = new com.google.android.gms.iid.zzh(context, str);
            }
            zzhVar = f6760c;
        } else {
            if (f6759b == null) {
                f6759b = new com.google.android.gms.iid.zzh(context, str);
            }
            zzhVar = f6759b;
        }
        return zzhVar;
    }

    /* JADX INFO: renamed from: b */
    private final void m7586b(Context context, Intent intent) {
        ComponentName componentNameStartService;
        if (isOrderedBroadcast()) {
            setResultCode(500);
        }
        ResolveInfo resolveInfoResolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveInfoResolveService == null || resolveInfoResolveService.serviceInfo == null) {
            Log.e("GcmReceiver", "Failed to resolve target intent service, skipping classname enforcement");
        } else {
            ServiceInfo serviceInfo = resolveInfoResolveService.serviceInfo;
            if (!context.getPackageName().equals(serviceInfo.packageName) || serviceInfo.name == null) {
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                Log.e("GcmReceiver", new StringBuilder(String.valueOf(str).length() + 94 + String.valueOf(str2).length()).append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ").append(str).append("/").append(str2).toString());
            } else {
                String strConcat = serviceInfo.name;
                if (strConcat.startsWith(FileUtils.HIDDEN_PREFIX)) {
                    String strValueOf = String.valueOf(context.getPackageName());
                    String strValueOf2 = String.valueOf(strConcat);
                    strConcat = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
                }
                if (Log.isLoggable("GcmReceiver", 3)) {
                    String strValueOf3 = String.valueOf(strConcat);
                    Log.d("GcmReceiver", strValueOf3.length() != 0 ? "Restricting intent to a specific service: ".concat(strValueOf3) : new String("Restricting intent to a specific service: "));
                }
                intent.setClassName(context.getPackageName(), strConcat);
            }
        }
        try {
            if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                componentNameStartService = m1900a_(context, intent);
            } else {
                componentNameStartService = context.startService(intent);
                Log.d("GcmReceiver", "Missing wake lock permission, service start may be delayed");
            }
            if (componentNameStartService != null) {
                if (isOrderedBroadcast()) {
                    setResultCode(-1);
                }
            } else {
                Log.e("GcmReceiver", "Error while delivering the message: ServiceIntent not found.");
                if (isOrderedBroadcast()) {
                    setResultCode(404);
                }
            }
        } catch (SecurityException e) {
            Log.e("GcmReceiver", "Error while delivering the message to the serviceIntent", e);
            if (isOrderedBroadcast()) {
                setResultCode(401);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z = false;
        if (Log.isLoggable("GcmReceiver", 3)) {
            Log.d("GcmReceiver", "received new intent");
        }
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if (Build.VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        String stringExtra = intent.getStringExtra("from");
        if ("google.com/iid".equals(stringExtra) || "gcm.googleapis.com/refresh".equals(stringExtra)) {
            intent.setAction("com.google.android.gms.iid.InstanceID");
        }
        String stringExtra2 = intent.getStringExtra("gcm.rawData64");
        if (stringExtra2 != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra2, 0));
            intent.removeExtra("gcm.rawData64");
        }
        if (zzq.m7517h() && context.getApplicationInfo().targetSdkVersion > 25) {
            z = true;
        }
        if (z) {
            if (isOrderedBroadcast()) {
                setResultCode(-1);
            }
            m7585a(context, intent.getAction()).m7623a(intent, goAsync());
            return;
        }
        if ("com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            m7586b(context, intent);
        } else {
            m7586b(context, intent);
        }
        if (isOrderedBroadcast() && getResultCode() == 0) {
            setResultCode(-1);
        }
    }
}
