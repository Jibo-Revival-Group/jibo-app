package com.google.android.gms.common.internal;

import android.os.Looper;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class zzc {
    /* JADX INFO: renamed from: a */
    public static void m7396a(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("null reference");
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m7397a(String str) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            String strValueOf = String.valueOf(Thread.currentThread());
            String strValueOf2 = String.valueOf(Looper.getMainLooper().getThread());
            Log.e("Asserts", new StringBuilder(String.valueOf(strValueOf).length() + 57 + String.valueOf(strValueOf2).length()).append("checkMainThread: current thread ").append(strValueOf).append(" IS NOT the main thread ").append(strValueOf2).append("!").toString());
            throw new IllegalStateException(str);
        }
    }
}
