package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzag {

    /* JADX INFO: renamed from: a */
    private static final Object f6538a = new Object();

    /* JADX INFO: renamed from: b */
    private static zzag f6539b;

    /* JADX INFO: renamed from: a */
    public static zzag m7326a(Context context) {
        synchronized (f6538a) {
            if (f6539b == null) {
                f6539b = new zzai(context.getApplicationContext());
            }
        }
        return f6539b;
    }

    /* JADX INFO: renamed from: a */
    public final void m7327a(String str, String str2, int i, ServiceConnection serviceConnection, String str3) {
        mo7331b(new zzah(str, str2, i), serviceConnection, str3);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m7328a(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return mo7329a(new zzah(componentName, 129), serviceConnection, str);
    }

    /* JADX INFO: renamed from: a */
    protected abstract boolean mo7329a(zzah zzahVar, ServiceConnection serviceConnection, String str);

    /* JADX INFO: renamed from: b */
    public final void m7330b(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        mo7331b(new zzah(componentName, 129), serviceConnection, str);
    }

    /* JADX INFO: renamed from: b */
    protected abstract void mo7331b(zzah zzahVar, ServiceConnection serviceConnection, String str);
}
