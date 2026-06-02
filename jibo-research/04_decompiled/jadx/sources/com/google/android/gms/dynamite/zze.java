package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* JADX INFO: loaded from: classes.dex */
final class zze implements DynamiteModule.zzd {
    zze() {
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.zzd
    /* JADX INFO: renamed from: a */
    public final zzj mo7571a(Context context, String str, zzi zziVar) throws DynamiteModule.zzc {
        zzj zzjVar = new zzj();
        zzjVar.f6739a = zziVar.mo7569a(context, str);
        if (zzjVar.f6739a != 0) {
            zzjVar.f6740b = zziVar.mo7570a(context, str, false);
        } else {
            zzjVar.f6740b = zziVar.mo7570a(context, str, true);
        }
        if (zzjVar.f6739a == 0 && zzjVar.f6740b == 0) {
            zzjVar.f6741c = 0;
        } else if (zzjVar.f6739a >= zzjVar.f6740b) {
            zzjVar.f6741c = -1;
        } else {
            zzjVar.f6741c = 1;
        }
        return zzjVar;
    }
}
