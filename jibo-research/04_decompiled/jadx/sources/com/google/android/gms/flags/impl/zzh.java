package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.internal.zzcbc;

/* JADX INFO: loaded from: classes.dex */
public final class zzh extends zza<String> {
    /* JADX INFO: renamed from: a */
    public static String m7578a(SharedPreferences sharedPreferences, String str, String str2) {
        try {
            return (String) zzcbc.m7818a(new zzi(sharedPreferences, str, str2));
        } catch (Exception e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.w("FlagDataUtils", strValueOf.length() != 0 ? "Flag value not available, returning default: ".concat(strValueOf) : new String("Flag value not available, returning default: "));
            return str2;
        }
    }
}
