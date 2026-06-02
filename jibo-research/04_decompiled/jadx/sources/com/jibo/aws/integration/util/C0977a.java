package com.jibo.aws.integration.util;

import android.util.Log;

/* JADX INFO: renamed from: com.jibo.aws.integration.util.a */
/* JADX INFO: loaded from: classes.dex */
public class C0977a {

    /* JADX INFO: renamed from: a */
    private static final int f9691a = "JBAWS_".length();

    /* JADX INFO: renamed from: a */
    public static String m10070a(Class cls) {
        return m10071a(cls.getSimpleName());
    }

    /* JADX INFO: renamed from: a */
    public static String m10071a(String str) {
        return str.length() > 23 - f9691a ? "JBAWS_" + str.substring(0, (23 - f9691a) - 1) : "JBAWS_" + str;
    }

    /* JADX INFO: renamed from: a */
    public static void m10072a(String str, String str2) {
        Log.d(str, str2);
    }

    /* JADX INFO: renamed from: a */
    public static void m10073a(String str, String str2, Throwable th) {
        Log.d(str, str2, th);
    }

    /* JADX INFO: renamed from: b */
    public static void m10074b(String str, String str2) {
        Log.i(str, str2);
    }

    /* JADX INFO: renamed from: b */
    public static void m10075b(String str, String str2, Throwable th) {
        Log.i(str, str2, th);
    }

    /* JADX INFO: renamed from: c */
    public static void m10076c(String str, String str2) {
        Log.w(str, str2);
    }

    /* JADX INFO: renamed from: c */
    public static void m10077c(String str, String str2, Throwable th) {
        Log.w(str, str2, th);
    }

    /* JADX INFO: renamed from: d */
    public static void m10078d(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }
}
