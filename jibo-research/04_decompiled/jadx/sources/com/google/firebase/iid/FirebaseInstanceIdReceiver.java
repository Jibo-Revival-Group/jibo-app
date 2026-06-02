package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Base64;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class FirebaseInstanceIdReceiver extends WakefulBroadcastReceiver {

    /* JADX INFO: renamed from: a */
    private static boolean f8628a = false;

    /* JADX INFO: renamed from: b */
    private static zzh f8629b;

    /* JADX INFO: renamed from: c */
    private static zzh f8630c;

    /* JADX INFO: renamed from: a */
    private static synchronized zzh m9113a(Context context, String str) {
        zzh zzhVar;
        if ("com.google.firebase.MESSAGING_EVENT".equals(str)) {
            if (f8630c == null) {
                f8630c = new zzh(context, str);
            }
            zzhVar = f8630c;
        } else {
            if (f8629b == null) {
                f8629b = new zzh(context, str);
            }
            zzhVar = f8629b;
        }
        return zzhVar;
    }

    /* JADX INFO: renamed from: a */
    private final void m9114a(Context context, Intent intent, String str) {
        String str2 = null;
        boolean z = false;
        int iM9173a = -1;
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if (Build.VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        if ("google.com/iid".equals(intent.getStringExtra("from")) || "com.google.firebase.INSTANCE_ID_EVENT".equals(str)) {
            str2 = "com.google.firebase.INSTANCE_ID_EVENT";
        } else if ("com.google.android.c2dm.intent.RECEIVE".equals(str) || "com.google.firebase.MESSAGING_EVENT".equals(str)) {
            str2 = "com.google.firebase.MESSAGING_EVENT";
        } else {
            Log.d("FirebaseInstanceId", "Unexpected intent");
        }
        if (str2 != null) {
            if (com.google.android.gms.common.util.zzq.m7517h() && context.getApplicationInfo().targetSdkVersion >= 26) {
                z = true;
            }
            if (z) {
                if (isOrderedBroadcast()) {
                    setResultCode(-1);
                }
                m9113a(context, str2).m9132a(intent, goAsync());
            } else {
                iM9173a = zzx.m9172a().m9173a(context, str2, intent);
            }
        }
        if (isOrderedBroadcast()) {
            setResultCode(iM9173a);
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
        if (parcelableExtra instanceof Intent) {
            m9114a(context, (Intent) parcelableExtra, intent.getAction());
        } else {
            m9114a(context, intent, intent.getAction());
        }
    }
}
