package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzba;
import com.google.android.gms.common.internal.zzbb;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamite.DynamiteModule;

/* JADX INFO: loaded from: classes.dex */
final class zzg {

    /* JADX INFO: renamed from: a */
    private static zzba f6705a;

    /* JADX INFO: renamed from: b */
    private static final Object f6706b = new Object();

    /* JADX INFO: renamed from: c */
    private static Context f6707c;

    /* JADX INFO: renamed from: a */
    static synchronized void m7536a(Context context) {
        if (f6707c != null) {
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        } else if (context != null) {
            f6707c = context.getApplicationContext();
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m7537a() {
        boolean z = true;
        if (f6705a == null) {
            zzbq.m7373a(f6707c);
            synchronized (f6706b) {
                if (f6705a == null) {
                    try {
                        f6705a = zzbb.m7365a(DynamiteModule.m7559a(f6707c, DynamiteModule.f6725c, "com.google.android.gms.googlecertificates").m7568a("com.google.android.gms.common.GoogleCertificatesImpl"));
                    } catch (DynamiteModule.zzc e) {
                        Log.e("GoogleCertificates", "Failed to load com.google.android.gms.googlecertificates", e);
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    static boolean m7538a(String str, zzh zzhVar) {
        return m7539a(str, zzhVar, false);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m7539a(String str, zzh zzhVar, boolean z) {
        if (!m7537a()) {
            return false;
        }
        zzbq.m7373a(f6707c);
        try {
            return f6705a.mo7364a(new zzn(str, zzhVar, z), com.google.android.gms.dynamic.zzn.m7553a(f6707c.getPackageManager()));
        } catch (RemoteException e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    static boolean m7540b(String str, zzh zzhVar) {
        return m7539a(str, zzhVar, true);
    }
}
