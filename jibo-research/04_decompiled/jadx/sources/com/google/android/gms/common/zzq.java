package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbhf;

/* JADX INFO: loaded from: classes.dex */
public class zzq {

    /* JADX INFO: renamed from: a */
    private static zzq f6716a;

    /* JADX INFO: renamed from: b */
    private final Context f6717b;

    private zzq(Context context) {
        this.f6717b = context.getApplicationContext();
    }

    /* JADX INFO: renamed from: a */
    static zzh m7545a(PackageInfo packageInfo, zzh... zzhVarArr) {
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zzi zziVar = new zzi(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < zzhVarArr.length; i++) {
            if (zzhVarArr[i].equals(zziVar)) {
                return zzhVarArr[i];
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static zzq m7546a(Context context) {
        zzbq.m7373a(context);
        synchronized (zzq.class) {
            if (f6716a == null) {
                zzg.m7536a(context);
                f6716a = new zzq(context);
            }
        }
        return f6716a;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m7547a(PackageInfo packageInfo, boolean z) {
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z ? m7545a(packageInfo, zzk.f6712a) : m7545a(packageInfo, zzk.f6712a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private final boolean m7548a(String str) {
        try {
            PackageInfo packageInfoM7814b = zzbhf.m7816a(this.f6717b).m7814b(str, 64);
            if (packageInfoM7814b == null) {
                return false;
            }
            if (zzp.zzch(this.f6717b)) {
                return m7549b(packageInfoM7814b, true);
            }
            boolean zM7549b = m7549b(packageInfoM7814b, false);
            if (!zM7549b && m7549b(packageInfoM7814b, true)) {
                Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
            }
            return zM7549b;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    private static boolean m7549b(PackageInfo packageInfo, boolean z) {
        boolean zM7540b = false;
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
        } else {
            zzi zziVar = new zzi(packageInfo.signatures[0].toByteArray());
            String str = packageInfo.packageName;
            zM7540b = z ? zzg.m7540b(str, zziVar) : zzg.m7538a(str, zziVar);
            if (!zM7540b) {
                Log.d("GoogleSignatureVerifier", new StringBuilder(27).append("Cert not in list. atk=").append(z).toString());
            }
        }
        return zM7540b;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m7550a(int i) {
        String[] strArrM7813a = zzbhf.m7816a(this.f6717b).m7813a(i);
        if (strArrM7813a == null || strArrM7813a.length == 0) {
            return false;
        }
        for (String str : strArrM7813a) {
            if (m7548a(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m7551a(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (m7547a(packageInfo, false)) {
            return true;
        }
        if (!m7547a(packageInfo, true)) {
            return false;
        }
        if (zzp.zzch(this.f6717b)) {
            return true;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return false;
    }
}
