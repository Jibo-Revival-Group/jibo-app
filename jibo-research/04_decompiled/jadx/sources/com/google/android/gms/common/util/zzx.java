package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.internal.zzbhf;

/* JADX INFO: loaded from: classes.dex */
public final class zzx {
    /* JADX INFO: renamed from: a */
    public static boolean m7524a(Context context, int i) {
        if (!m7525a(context, i, "com.google.android.gms")) {
            return false;
        }
        try {
            return com.google.android.gms.common.zzq.m7546a(context).m7551a(context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (PackageManager.NameNotFoundException e) {
            if (!Log.isLoggable("UidVerifier", 3)) {
                return false;
            }
            Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            return false;
        }
    }

    @TargetApi(19)
    /* JADX INFO: renamed from: a */
    public static boolean m7525a(Context context, int i, String str) {
        return zzbhf.m7816a(context).m7812a(i, str);
    }
}
