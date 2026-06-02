package com.mixpanel.android.util;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class MPLog {

    /* JADX INFO: renamed from: a */
    private static int f12089a = 5;

    /* JADX INFO: renamed from: a */
    public static void m12020a(int i) {
        f12089a = i;
    }

    /* JADX INFO: renamed from: a */
    public static void m12021a(String str, String str2) {
        if (m12025b(2)) {
            Log.v(str, str2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m12022a(String str, String str2, Throwable th) {
        if (m12025b(2)) {
            Log.v(str, str2, th);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m12023b(String str, String str2) {
        if (m12025b(3)) {
            Log.d(str, str2);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m12024b(String str, String str2, Throwable th) {
        if (m12025b(3)) {
            Log.d(str, str2, th);
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m12026c(String str, String str2) {
        if (m12025b(4)) {
            Log.i(str, str2);
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m12027c(String str, String str2, Throwable th) {
        if (m12025b(4)) {
            Log.i(str, str2, th);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m12028d(String str, String str2) {
        if (m12025b(5)) {
            Log.w(str, str2);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m12029d(String str, String str2, Throwable th) {
        if (m12025b(5)) {
            Log.w(str, str2, th);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m12030e(String str, String str2) {
        if (m12025b(6)) {
            Log.e(str, str2);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m12031e(String str, String str2, Throwable th) {
        if (m12025b(6)) {
            Log.e(str, str2, th);
        }
    }

    /* JADX INFO: renamed from: f */
    public static void m12032f(String str, String str2) {
        if (m12025b(6)) {
            Log.wtf(str, str2);
        }
    }

    /* JADX INFO: renamed from: f */
    public static void m12033f(String str, String str2, Throwable th) {
        if (m12025b(6)) {
            Log.wtf(str, str2, th);
        }
    }

    /* JADX INFO: renamed from: b */
    private static boolean m12025b(int i) {
        return f12089a <= i;
    }
}
