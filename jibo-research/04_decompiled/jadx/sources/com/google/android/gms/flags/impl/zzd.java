package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.internal.zzcbc;

/* JADX INFO: loaded from: classes.dex */
public final class zzd extends zza<Integer> {
    /* JADX INFO: renamed from: a */
    public static Integer m7576a(SharedPreferences sharedPreferences, String str, Integer num) {
        try {
            return (Integer) zzcbc.m7818a(new zze(sharedPreferences, str, num));
        } catch (Exception e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.w("FlagDataUtils", strValueOf.length() != 0 ? "Flag value not available, returning default: ".concat(strValueOf) : new String("Flag value not available, returning default: "));
            return num;
        }
    }
}
