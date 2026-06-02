package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class zzbq {
    /* JADX INFO: renamed from: a */
    public static <T> T m7373a(T t) {
        if (t == null) {
            throw new NullPointerException("null reference");
        }
        return t;
    }

    /* JADX INFO: renamed from: a */
    public static <T> T m7374a(T t, Object obj) {
        if (t == null) {
            throw new NullPointerException(String.valueOf(obj));
        }
        return t;
    }

    /* JADX INFO: renamed from: a */
    public static String m7375a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        return str;
    }

    /* JADX INFO: renamed from: a */
    public static String m7376a(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return str;
    }

    /* JADX INFO: renamed from: a */
    public static void m7377a(Handler handler) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException("Must be called on the handler thread");
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m7378a(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m7379a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m7380a(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m7381b(String str) {
        if (!com.google.android.gms.common.util.zzw.m7523a()) {
            throw new IllegalStateException(str);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m7382b(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m7383b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m7384b(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m7385c(String str) {
        if (com.google.android.gms.common.util.zzw.m7523a()) {
            throw new IllegalStateException(str);
        }
    }
}
