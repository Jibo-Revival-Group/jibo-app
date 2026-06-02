package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.zzbhf;

/* JADX INFO: loaded from: classes.dex */
public final class zzc {
    /* JADX INFO: renamed from: a */
    public static boolean m7495a(Context context, String str) {
        "com.google.android.gms".equals(str);
        try {
            return (zzbhf.m7816a(context).m7810a(str, 0).flags & 2097152) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
