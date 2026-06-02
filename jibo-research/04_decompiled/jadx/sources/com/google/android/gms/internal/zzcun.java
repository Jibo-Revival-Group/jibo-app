package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class zzcun extends zzcui<String> {
    zzcun(zzcup zzcupVar, String str, String str2) {
        super(zzcupVar, str, str2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzcui
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final String mo8481a(SharedPreferences sharedPreferences) {
        try {
            return sharedPreferences.getString(this.f7750a, null);
        } catch (ClassCastException e) {
            String strValueOf = String.valueOf(this.f7750a);
            Log.e("PhenotypeFlag", strValueOf.length() != 0 ? "Invalid string value in SharedPreferences for ".concat(strValueOf) : new String("Invalid string value in SharedPreferences for "), e);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.zzcui
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ String mo8482a(String str) {
        return str;
    }
}
