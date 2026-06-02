package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.util.zzq;

/* JADX INFO: loaded from: classes.dex */
public final class zzbhd {

    /* JADX INFO: renamed from: a */
    private static Context f6984a;

    /* JADX INFO: renamed from: b */
    private static Boolean f6985b;

    /* JADX INFO: renamed from: a */
    public static synchronized boolean m7808a(Context context) {
        boolean zBooleanValue;
        Context applicationContext = context.getApplicationContext();
        if (f6984a == null || f6985b == null || f6984a != applicationContext) {
            f6985b = null;
            if (zzq.m7517h()) {
                f6985b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
            } else {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    f6985b = true;
                } catch (ClassNotFoundException e) {
                    f6985b = false;
                }
            }
            f6984a = applicationContext;
            zBooleanValue = f6985b.booleanValue();
        } else {
            zBooleanValue = f6985b.booleanValue();
        }
        return zBooleanValue;
    }
}
