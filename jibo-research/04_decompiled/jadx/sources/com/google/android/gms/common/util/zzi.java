package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzi {

    /* JADX INFO: renamed from: a */
    private static Boolean f6691a;

    /* JADX INFO: renamed from: b */
    private static Boolean f6692b;

    /* JADX INFO: renamed from: c */
    private static Boolean f6693c;

    @TargetApi(20)
    /* JADX INFO: renamed from: a */
    public static boolean m7502a(Context context) {
        if (f6691a == null) {
            f6691a = Boolean.valueOf(zzq.m7514e() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return f6691a.booleanValue();
    }

    @TargetApi(24)
    /* JADX INFO: renamed from: b */
    public static boolean m7503b(Context context) {
        return (!zzq.m7516g() || m7504c(context)) && m7502a(context);
    }

    @TargetApi(21)
    /* JADX INFO: renamed from: c */
    public static boolean m7504c(Context context) {
        if (f6692b == null) {
            f6692b = Boolean.valueOf(zzq.m7515f() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f6692b.booleanValue();
    }

    /* JADX INFO: renamed from: d */
    public static boolean m7505d(Context context) {
        if (f6693c == null) {
            f6693c = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return f6693c.booleanValue();
    }
}
