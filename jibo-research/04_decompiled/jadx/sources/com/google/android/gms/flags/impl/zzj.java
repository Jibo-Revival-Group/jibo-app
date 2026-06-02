package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.zzcbc;

/* JADX INFO: loaded from: classes.dex */
public final class zzj {

    /* JADX INFO: renamed from: a */
    private static SharedPreferences f6756a = null;

    /* JADX INFO: renamed from: a */
    public static SharedPreferences m7579a(Context context) throws Exception {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (f6756a == null) {
                f6756a = (SharedPreferences) zzcbc.m7818a(new zzk(context));
            }
            sharedPreferences = f6756a;
        }
        return sharedPreferences;
    }
}
