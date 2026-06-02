package com.google.android.gms.common.util;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class zzq {
    /* JADX INFO: renamed from: a */
    public static boolean m7510a() {
        return Build.VERSION.SDK_INT >= 15;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m7511b() {
        return Build.VERSION.SDK_INT >= 16;
    }

    /* JADX INFO: renamed from: c */
    public static boolean m7512c() {
        return Build.VERSION.SDK_INT >= 18;
    }

    /* JADX INFO: renamed from: d */
    public static boolean m7513d() {
        return Build.VERSION.SDK_INT >= 19;
    }

    /* JADX INFO: renamed from: e */
    public static boolean m7514e() {
        return Build.VERSION.SDK_INT >= 20;
    }

    /* JADX INFO: renamed from: f */
    public static boolean m7515f() {
        return Build.VERSION.SDK_INT >= 21;
    }

    /* JADX INFO: renamed from: g */
    public static boolean m7516g() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* JADX INFO: renamed from: h */
    public static boolean m7517h() {
        return Build.VERSION.SDK_INT >= 26 || "O".equals(Build.VERSION.CODENAME) || Build.VERSION.CODENAME.startsWith("OMR") || Build.VERSION.CODENAME.startsWith("ODR");
    }
}
