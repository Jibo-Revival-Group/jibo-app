package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzcaz;

/* JADX INFO: loaded from: classes.dex */
@DynamiteApi
public class FlagProviderImpl extends zzcaz {

    /* JADX INFO: renamed from: a */
    private boolean f6742a = false;

    /* JADX INFO: renamed from: b */
    private SharedPreferences f6743b;

    @Override // com.google.android.gms.internal.zzcay
    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        return !this.f6742a ? z : zzb.m7575a(this.f6743b, str, Boolean.valueOf(z)).booleanValue();
    }

    @Override // com.google.android.gms.internal.zzcay
    public int getIntFlagValue(String str, int i, int i2) {
        return !this.f6742a ? i : zzd.m7576a(this.f6743b, str, Integer.valueOf(i)).intValue();
    }

    @Override // com.google.android.gms.internal.zzcay
    public long getLongFlagValue(String str, long j, int i) {
        return !this.f6742a ? j : zzf.m7577a(this.f6743b, str, Long.valueOf(j)).longValue();
    }

    @Override // com.google.android.gms.internal.zzcay
    public String getStringFlagValue(String str, String str2, int i) {
        return !this.f6742a ? str2 : zzh.m7578a(this.f6743b, str, str2);
    }

    @Override // com.google.android.gms.internal.zzcay
    public void init(IObjectWrapper iObjectWrapper) {
        Context context = (Context) zzn.m7554a(iObjectWrapper);
        if (this.f6742a) {
            return;
        }
        try {
            this.f6743b = zzj.m7579a(context.createPackageContext("com.google.android.gms", 0));
            this.f6742a = true;
        } catch (PackageManager.NameNotFoundException e) {
        } catch (Exception e2) {
            String strValueOf = String.valueOf(e2.getMessage());
            Log.w("FlagProviderImpl", strValueOf.length() != 0 ? "Could not retrieve sdk flags, continuing with defaults: ".concat(strValueOf) : new String("Could not retrieve sdk flags, continuing with defaults: "));
        }
    }
}
