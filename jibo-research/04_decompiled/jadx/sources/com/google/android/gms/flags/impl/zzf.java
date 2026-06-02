package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.internal.zzcbc;

/* JADX INFO: loaded from: classes.dex */
public final class zzf extends zza<Long> {
    /* JADX INFO: renamed from: a */
    public static Long m7577a(SharedPreferences sharedPreferences, String str, Long l) {
        try {
            return (Long) zzcbc.m7818a(new zzg(sharedPreferences, str, l));
        } catch (Exception e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.w("FlagDataUtils", strValueOf.length() != 0 ? "Flag value not available, returning default: ".concat(strValueOf) : new String("Flag value not available, returning default: "));
            return l;
        }
    }
}
