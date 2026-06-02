package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.util.zzq;

/* JADX INFO: loaded from: classes.dex */
public final class zzbhe {

    /* JADX INFO: renamed from: a */
    private Context f6986a;

    public zzbhe(Context context) {
        this.f6986a = context;
    }

    /* JADX INFO: renamed from: a */
    public final int m7809a(String str) {
        return this.f6986a.checkCallingOrSelfPermission(str);
    }

    /* JADX INFO: renamed from: a */
    public final ApplicationInfo m7810a(String str, int i) throws PackageManager.NameNotFoundException {
        return this.f6986a.getPackageManager().getApplicationInfo(str, i);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m7811a() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return zzbhd.m7808a(this.f6986a);
        }
        if (!zzq.m7517h() || (nameForUid = this.f6986a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.f6986a.getPackageManager().isInstantApp(nameForUid);
    }

    @TargetApi(19)
    /* JADX INFO: renamed from: a */
    public final boolean m7812a(int i, String str) {
        if (zzq.m7513d()) {
            try {
                ((AppOpsManager) this.f6986a.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException e) {
                return false;
            }
        }
        String[] packagesForUid = this.f6986a.getPackageManager().getPackagesForUid(i);
        if (str == null || packagesForUid == null) {
            return false;
        }
        for (String str2 : packagesForUid) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public final String[] m7813a(int i) {
        return this.f6986a.getPackageManager().getPackagesForUid(i);
    }

    /* JADX INFO: renamed from: b */
    public final PackageInfo m7814b(String str, int i) throws PackageManager.NameNotFoundException {
        return this.f6986a.getPackageManager().getPackageInfo(str, i);
    }

    /* JADX INFO: renamed from: b */
    public final CharSequence m7815b(String str) throws PackageManager.NameNotFoundException {
        return this.f6986a.getPackageManager().getApplicationLabel(this.f6986a.getPackageManager().getApplicationInfo(str, 0));
    }
}
