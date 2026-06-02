package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.common.zzp;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public final class zzb {

    /* JADX INFO: renamed from: a */
    private SharedPreferences f5835a;

    public zzb(Context context) {
        try {
            Context remoteContext = zzp.getRemoteContext(context);
            this.f5835a = remoteContext == null ? null : remoteContext.getSharedPreferences("google_ads_flags", 0);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while getting SharedPreferences ", th);
            this.f5835a = null;
        }
    }

    /* JADX INFO: renamed from: a */
    final float m6665a(String str, float f) {
        try {
            return this.f5835a == null ? CropImageView.DEFAULT_ASPECT_RATIO : this.f5835a.getFloat(str, CropImageView.DEFAULT_ASPECT_RATIO);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
    }

    /* JADX INFO: renamed from: a */
    final String m6666a(String str, String str2) {
        try {
            return this.f5835a == null ? str2 : this.f5835a.getString(str, str2);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return str2;
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m6667a(String str, boolean z) {
        try {
            if (this.f5835a == null) {
                return false;
            }
            return this.f5835a.getBoolean(str, false);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return false;
        }
    }
}
