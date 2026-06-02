package com.jibo.utils;

import android.content.Context;
import android.support.v4.content.ContextCompat;

/* JADX INFO: loaded from: classes.dex */
public class PermissionUtil {
    /* JADX INFO: renamed from: a */
    public static boolean m11420a(Context context) {
        return ContextCompat.m1837b(context, "android.permission.READ_EXTERNAL_STORAGE") + ContextCompat.m1837b(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m11421b(Context context) {
        return ContextCompat.m1837b(context, "android.permission.ACCESS_COARSE_LOCATION") + ContextCompat.m1837b(context, "android.permission.ACCESS_FINE_LOCATION") == 0;
    }
}
