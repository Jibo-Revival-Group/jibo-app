package com.jibo.utils;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class LogUtils {

    /* JADX INFO: renamed from: a */
    private static final int f11682a = "JB_".length();

    /* JADX INFO: renamed from: a */
    public static String m11406a(String str) {
        return str.length() > 23 - f11682a ? "JB_" + str.substring(0, (23 - f11682a) - 1) : "JB_" + str;
    }

    /* JADX INFO: renamed from: a */
    public static String m11405a(Class cls) {
        return m11406a(cls.getSimpleName());
    }

    /* JADX INFO: renamed from: a */
    public static void m11407a(String str, String str2) {
        if (Log.isLoggable(str, 3)) {
            Log.d(str, str2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m11408a(String str, String str2, Throwable th) {
        if (Log.isLoggable(str, 3)) {
            Log.d(str, str2, th);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m11409b(String str, String str2) {
        if (Log.isLoggable(str, 2)) {
            Log.v(str, str2);
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m11411c(String str, String str2) {
        Log.i(str, str2);
    }

    /* JADX INFO: renamed from: d */
    public static void m11412d(String str, String str2) {
        Log.e(str, str2);
    }

    /* JADX INFO: renamed from: b */
    public static void m11410b(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }
}
