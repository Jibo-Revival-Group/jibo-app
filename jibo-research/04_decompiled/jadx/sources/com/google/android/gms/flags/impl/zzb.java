package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.internal.zzcbc;

/* JADX INFO: loaded from: classes.dex */
public final class zzb extends zza<Boolean> {
    /* JADX INFO: renamed from: a */
    public static Boolean m7575a(SharedPreferences sharedPreferences, String str, Boolean bool) {
        try {
            return (Boolean) zzcbc.m7818a(new zzc(sharedPreferences, str, bool));
        } catch (Exception e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.w("FlagDataUtils", strValueOf.length() != 0 ? "Flag value not available, returning default: ".concat(strValueOf) : new String("Flag value not available, returning default: "));
            return bool;
        }
    }
}
